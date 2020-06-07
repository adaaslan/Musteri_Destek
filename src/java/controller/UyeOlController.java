package controller;

import dao.KullaniciDAO;
import dao.MusterilerDAO;
import entity.Kullanici;
import entity.Musteriler;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandlerWrapper;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import util.NavigationBean;

@ManagedBean(name = "uyeOlBean")

@SessionScoped
public class UyeOlController implements Serializable {
    
    private static final long serialVersionUID = 7499456568301754701L;
    public static final String BEAN_NAME = "uyeOlBean";
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String sifre;
    private MusterilerDAO musterilerdao;
    private KullaniciDAO kullaniciDao;
    
    public void uyeOl() throws Exception {
        try {
            Musteriler musteri = new Musteriler();
            musteri.setMusteri_mail(kullaniciAdi);
            musteri.setMusteri_ad(ad);
            musteri.setMusteri_soyad(soyad);
            int musteriId = getMusterilerdao().insert(musteri);
            musteri.setMusteri_id(musteriId);
            
            Kullanici kullanici = new Kullanici();
            kullanici.setKullaniciAdi(kullaniciAdi);
            kullanici.setSifre(sifre);
            kullanici.setAd(ad);
            kullanici.setSoyad(soyad);
            kullanici.setRol("M");
            kullanici.setMusteri(musteri);
            getKullaniciDao().insert(kullanici);
            NavigationBean.toLogin();
        } catch (Exception e) {
            System.out.println(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hata: ", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    
    public MusterilerDAO getMusterilerdao() {
        if (this.musterilerdao == null) {
            this.musterilerdao = new MusterilerDAO();
        }
        return musterilerdao;
    }
    
    public void setMusterilerdao(MusterilerDAO musterilerdao) {
        this.musterilerdao = musterilerdao;
    }
    
    public String getAd() {
        return ad;
    }
    
    public void setAd(String ad) {
        this.ad = ad;
    }
    
    public String getSoyad() {
        return soyad;
    }
    
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    
    public String getSifre() {
        return sifre;
    }
    
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }
    
    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }
    
}
