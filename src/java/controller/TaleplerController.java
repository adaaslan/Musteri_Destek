package controller;

import dao.DosyaDAO;
import dao.TaleplerDAO;
import dao.UrunVeHizmetlerDAO;
import entity.Dosya;
import entity.Kullanici;
import entity.Musteriler;
import entity.Talepler;
import entity.UrunVeHizmetler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean(name = "taleplerBean")
@ViewScoped
public class TaleplerController implements Serializable {

    private static final long serialVersionUID = 0L;
    private UrunVeHizmetler seciliHizmet;
    private Kullanici kullanici;

    private List<Talepler> taleplerList;
    private TaleplerDAO taleplerdao;
    private DosyaDAO dosyadao;
    private UrunVeHizmetlerDAO hizmetDao;

    private List<UrunVeHizmetler> listUrunHizmet;
    private List<Musteriler> listMusteriler;
    private List<Dosya> dosyaList;
    private List<UrunVeHizmetler> hizmetler;

    private String bul = "";
    public static int page;
    private int pageCount = 10;
    private int totalCount = 0;
    @Inject
    private LoginBean loginBean;

    @PostConstruct
    public void init() {
        if (LoginBean.kullanici != null && LoginBean.kullanici.getCalisan() != null) {
            hizmetler = Arrays.asList(LoginBean.kullanici.getCalisan().getHizmet());
        } else {
            hizmetler = getHizmetDao().findAll();
        }
        seciliHizmet = hizmetler.get(0);
        yenile();
    }

    public void yenile() {
        try {
            List<Talepler> list = new ArrayList<>();
            if (!bul.equals("") || bul != null) {
                list = this.getTaleplerdao().findBy(bul, seciliHizmet.getHizmet_id());
            } else if (seciliHizmet != null) {
                list = this.getTaleplerdao().findBy(bul, seciliHizmet.getHizmet_id());
            } else {
                list = this.getTaleplerdao().findAll();
            }
            totalCount = list.size();

            int from = (page) * pageCount;

            int to = (page + 1) * pageCount;
            if (totalCount <= to) {
                to = totalCount;
            }
            this.taleplerList = list.subList(from, to);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ileri() {
        try {
            if (isHasNextPage()) {
                page++;
            }
            yenile();
        } catch (Exception e) {
        }
    }

    public void geri() {
        try {
            if (isHasPreviousPage()) {
                this.page--;
            }
            yenile();
        } catch (Exception e) {
        }
    }

    public int getPageFirstItem() {
        int first = page * pageCount;
        if (first >= totalCount) {
            return (page - 1) * pageCount;
        } else {
            return first;
        }
    }

    public int getPageLastItem() {
        int i = getPageFirstItem() + pageCount - 1;
        int count = totalCount - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public boolean isHasNextPage() {
        return (page + 1) * pageCount + 1 <= totalCount;
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    public void delete(int talep_id) {
        try {
            this.getTaleplerdao().delete(talep_id);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, talep_id + " Numaralı Talep Silindi.", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            yenile();

        } catch (Exception e) {
        }
    }

    public void durumKapat(int talep_id) {
        try {
            Talepler talepUp = new Talepler();
            talepUp.setTalep_id(talep_id);
            talepUp.setTalep_durum("Kapalı");
            this.getTaleplerdao().updateDurum(talepUp);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, talep_id + " Numaralı Talebin Durumu Kapalı Yapıldı.", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            yenile();
        } catch (Exception e) {
        }
    }

    public void konuylaTalepBul() {
        try {
            List<Talepler> list = this.getTaleplerdao().findBy(bul, seciliHizmet.getHizmet_id());
            totalCount = list.size();

            int from = (page) * pageCount;

            int to = (page + 1) * pageCount;
            if (totalCount <= to) {
                to = totalCount;
            }
            this.taleplerList = list.subList(from, to);
        } catch (Exception e) {
        }
    }

    @Inject
    private DosyaController dosyaController;

    public DosyaController getDosyaController() {
        return dosyaController;
    }

    public void setDosyaController(DosyaController dosyaController) {
        this.dosyaController = dosyaController;
    }

    public List<Talepler> getTaleplerList() {
        return taleplerList;
    }

    public void setTaleplerList(List<Talepler> taleplerList) {
        this.taleplerList = taleplerList;
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

    public DosyaDAO getDosyadao() {
        if (this.dosyadao == null) {
            this.dosyadao = new DosyaDAO();
        }
        return dosyadao;
    }

    public void setDosyadao(DosyaDAO dosyadao) {
        this.dosyadao = dosyadao;
    }

    public List<UrunVeHizmetler> getListUrunHizmet() {
        return listUrunHizmet;
    }

    public void setListUrunHizmet(List<UrunVeHizmetler> listUrunHizmet) {
        this.listUrunHizmet = listUrunHizmet;
    }

    public List<Musteriler> getListMusteriler() {
        return listMusteriler;
    }

    public void setListMusteriler(List<Musteriler> listMusteriler) {
        this.listMusteriler = listMusteriler;
    }

    public List<Dosya> getDosyaList() {
        this.dosyaList = this.getDosyadao().findAll();
        return dosyaList;
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public UrunVeHizmetler getSeciliHizmet() {
        return seciliHizmet;
    }

    public void setSeciliHizmet(UrunVeHizmetler seciliHizmet) {
        this.seciliHizmet = seciliHizmet;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
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

    public List<UrunVeHizmetler> getHizmetler() {
        return hizmetler;
    }

    public void setHizmetler(List<UrunVeHizmetler> hizmetler) {
        this.hizmetler = hizmetler;
    }
}
