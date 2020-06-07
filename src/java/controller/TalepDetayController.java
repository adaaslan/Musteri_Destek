package controller;

import dao.TaleplerDAO;
import entity.Dosya;
import entity.Talepler;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "talepDetayBean")
@ViewScoped
public class TalepDetayController implements Serializable {

    private static final long serialVersionUID = 1L;
    private TaleplerDAO taleplerdao;

    private boolean textEditable = false;
    private UploadedFile ekDosya;
    private Talepler talep;
    private StreamedContent stream;
    public static String selectedTalepId;
    String originalURL;
    private String aciklama;

    private List<String> durumlar;
    private String secilenDurum;

    private List[] oncelikler;
    private boolean izleyebilme = true;
    // private List<String> dosyaUzantilari = Arrays.asList("gif", "jpe", "jpg",
    // "png", "xml", "pdf", "doc", "bmp", "docx", "xlsx", "xslt", "html", "txt",
    // "zip", "log", "ini");

    @PostConstruct
    public void init() {
//            kullanici = loginBean.getKullanici();
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); // parametre
        String id = params.get("id");

        if (id != null) {
            selectedTalepId = id;
            talepYenile();
        }
        durumlar = Arrays.asList("Açık", "Kapalı");

    }

    public void talepYenile() {
        try {
            Dosya talepDosya = new Dosya();
            int id = Integer.valueOf(selectedTalepId);
            this.talep = this.getTaleplerdao().find(id);
            if (talep != null) {
                talepDosya = talep.getDosya();
                if (talepDosya != null) {
                    if (talepDosya.getDosya_value() != null) {
                        InputStream targetStream = new ByteArrayInputStream(talepDosya.getDosya_value());
//                        talepDosya.setStreamedContent(new DefaultStreamedContent(targetStream, "txt/txt", talepDosya.getDosya_ismi()));
                        stream = new DefaultStreamedContent(targetStream, "txt/txt", talepDosya.getDosya_ismi());
//                        String text = Base64.encode(stream.getData());
//                        talepDosya.setBase64(text);
                    }
                }
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext externalContext = context.getExternalContext();
                try {
                    externalContext.redirect(externalContext.getRequestContextPath() + "/view/talepTakip.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Haa: ", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }

    public Talepler getTalep() {
        return talep;
    }

    public void setTalep(Talepler talep) {
        this.talep = talep;
    }

    public UploadedFile getEkDosya() {
        return ekDosya;
    }

    public void setEkDosya(UploadedFile ekDosya) {
        this.ekDosya = ekDosya;
    }

    public boolean isIzleyebilme() {
        return izleyebilme;
    }

    public void setIzleyebilme(boolean izleyebilme) {
        this.izleyebilme = izleyebilme;
    }

    public boolean isTextEditable() {
        return textEditable;
    }

    public void setTextEditable(boolean textEditable) {
        this.textEditable = textEditable;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
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

    public StreamedContent getStream() {
        try {
            Dosya talepDosya = new Dosya();
            int idt = Integer.valueOf(selectedTalepId);
            this.talep = this.getTaleplerdao().find(idt);
            if (talep != null) {
                talepDosya = talep.getDosya();
                if (talepDosya != null) {
                    if (talepDosya.getDosya_value() != null) {
                        InputStream targetStream = new ByteArrayInputStream(talepDosya.getDosya_value());
//                        talepDosya.setStreamedContent(new DefaultStreamedContent(targetStream, "txt/txt", talepDosya.getDosya_ismi()));
                        stream = new DefaultStreamedContent(targetStream, "txt/txt", talepDosya.getDosya_ismi());
                        return stream;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TalepDetayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stream;
    }

    public void setStream(StreamedContent stream) {

        this.stream = stream;
    }

    public List<String> getDurumlar() {
        return durumlar;
    }

    public void setDurumlar(List<String> durumlar) {
        this.durumlar = durumlar;
    }

    public String getSecilenDurum() {
        return secilenDurum;
    }

    public void setSecilenDurum(String secilenDurum) {
        this.secilenDurum = secilenDurum;
    }

    public List[] getOncelikler() {
        return oncelikler;
    }

    public void setOncelikler(List[] oncelikler) {
        this.oncelikler = oncelikler;
    }

}
