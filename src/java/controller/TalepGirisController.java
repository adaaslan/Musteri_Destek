package controller;

import dao.CalisanlarDAO;
import dao.DosyaDAO;
import dao.TaleplerDAO;
import dao.UrunVeHizmetlerDAO;
import entity.Calisanlar;
import entity.Dosya;
import entity.Kullanici;
import entity.Musteriler;
import entity.Talepler;
import entity.UrunVeHizmetler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "talepGirisBean")
@ViewScoped
public class TalepGirisController implements Serializable {

    private static final long serialVersionUID = 0L;
    public static final String BEAN_NAME = "talepGirisBean";
    private UrunVeHizmetler seciliHizmet;
    private String konu;
    private String mesaj;
    private String oncelik;
    private Kullanici kullanici;
    public static int dosyaId;
    private List<UrunVeHizmetler> hizmetler;
    private List<Map<String, Object>> kurumlar;
    private List<String> oncelikler;
    private final List<String> dosyaUzantilari = Arrays.asList("bmp", "pdf", "gif", "jpe", "jpg", "png", "xml", "pdf", "doc", "docx", "xslt", "xlsx", "html", "txt", "zip", "log", "ini");
    private DosyaDAO dosyadao;
    private TaleplerDAO taleplerdao;
    private UrunVeHizmetlerDAO hizmetDao;
    private CalisanlarDAO calisanDao;
    @Inject
    LoginBean loginBean;

    @PostConstruct
    public void init() {
//        kullanici = loginBean.getKullanici();
        hizmetler = getHizmetDao().findAll();
        oncelikler = Arrays.asList("Normal", "Yüksek", "Kritik");
    }

    public void handle(FileUploadEvent event) throws IOException {
        if (event != null && event.getFile() != null) {
            Dosya dosya = new Dosya();
            UploadedFile file = event.getFile();
            Map<String, Object> map = new HashMap<>();

            String dosyaAdi = file.getFileName();
            long dosyasize = file.getSize();
            InputStream input = file.getInputstream();
            byte[] bytes = new byte[Integer.valueOf(String.valueOf(dosyasize))];
            DataInputStream dis = new DataInputStream(input);
            dis.readFully(bytes);
            map.put("name", dosyaAdi);
            map.put("size", dosyasize);
            map.put("input", input);
            dosya.setDosya_value(bytes);
            dosya.setDosya_ismi(dosyaAdi);
            if (!dosyaUzantilari.contains(dosyaAdi.substring(dosyaAdi.lastIndexOf(".") + 1, dosyaAdi.length()))) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "İşlem Ba�ar�s�z", "Y�kleyebilece�iniz Dosya Uzant�lar� " + dosyaUzantilari);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                int sizeLimit = 5000000;
                if (dosyasize > sizeLimit) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "��lem Ba�ar�s�z", "Y�kleyebilece�iniz Dosyan�n Boyutu Maksimum " + sizeLimit + " Olabilir.");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }
            dosyaId = getDosyadao().insert(dosya);
        }
    }

    public String kaydet() throws IOException, NamingException {
        try {
            if (this.mesaj != null && this.konu != null) {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                Object requestObj = context.getRequest();

                Musteriler musteri = new Musteriler();
                if (loginBean.kullanici == null) {
                    musteri.setMusteri_id(1);
                } else {
                    musteri = loginBean.kullanici.getMusteri();
                }

                UrunVeHizmetler hizmet = seciliHizmet;
                System.out.println("controller.TalepGirisController.kaydet()" + hizmet.getCalisanlar());
                Calisanlar calisan = new Calisanlar();
                calisan = getCalisanDao().findByHizmet(hizmet.getHizmet_id());
                Talepler talep = new Talepler();
                talep.setHizmet(hizmet);
                talep.setMusteri(musteri);

                Dosya eklenenDos = getDosyadao().find(dosyaId);
                talep.setDosya(eklenenDos);
                talep.setTalep_durum("Açık");
                talep.setTalep_konu(konu);
                talep.setTalep_mesaj(mesaj);
                talep.setTalep_oncelik(oncelik);
                talep.setCalisan(calisan);
                getTaleplerdao().insert(talep);

                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect(externalContext.getRequestContextPath() + "/view/talepler.xhtml");

            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gerekli Olan Alanlar� Doldurdu�unuzdan Emin Olunuz.", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "";
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hata: ", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
        return "";
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public List<Map<String, Object>> getKurumlar() {
        return kurumlar;
    }

    public void setKurumlar(List<Map<String, Object>> kurumlar) {
        this.kurumlar = kurumlar;
    }

    public TaleplerDAO getTaleplerdao() {
        if (this.taleplerdao == null) {
            this.taleplerdao = new TaleplerDAO();
        }
        return taleplerdao;
    }

    public void setTaleplerdao(TaleplerDAO taleplerdao) {
        this.taleplerdao = taleplerdao;
    }

    public UrunVeHizmetlerDAO getHizmetDao() {
        if (this.hizmetDao == null) {
            this.hizmetDao = new UrunVeHizmetlerDAO();
        }
        return hizmetDao;
    }

    public void setHizmetDao(UrunVeHizmetlerDAO hizmetDao) {
        this.hizmetDao = hizmetDao;
    }

    public UrunVeHizmetler getSeciliHizmet() {
        return seciliHizmet;
    }

    public void setSeciliHizmet(UrunVeHizmetler seciliHizmet) {
        this.seciliHizmet = seciliHizmet;
    }

    public String getOncelik() {
        return oncelik;
    }

    public void setOncelik(String oncelik) {
        this.oncelik = oncelik;
    }

    public List<UrunVeHizmetler> getHizmetler() {
        return hizmetler;
    }

    public void setHizmetler(List<UrunVeHizmetler> hizmetler) {
        this.hizmetler = hizmetler;
    }

    public List<String> getOncelikler() {
        return oncelikler;
    }

    public void setOncelikler(List<String> oncelikler) {
        this.oncelikler = oncelikler;
    }

    public DosyaDAO getDosyadao() {
        if (this.dosyadao == null) {
            this.dosyadao = new DosyaDAO();
        }
        return dosyadao;
    }

    public void setDosyadao(DosyaDAO dosyadao) {
        this.dosyadao = dosyadao;
    }

    public CalisanlarDAO getCalisanDao() {
        if (this.calisanDao == null) {
            this.calisanDao = new CalisanlarDAO();
        }
        return calisanDao;
    }

    public void setCalisanDao(CalisanlarDAO calisanDao) {
        this.calisanDao = calisanDao;
    }

}
