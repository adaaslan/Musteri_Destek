package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calisanlar {

    private int calisan_id;
    private String calisan_ad;
    private String calisan_soyad;
    private String calisan_tel;
    private String calisan_adres;
    private String calisan_mail;

    private UrunVeHizmetler hizmet;

    public Calisanlar() {
        List<String> a = new ArrayList<>();
        
    }

    public Calisanlar(int calisan_id, String calisan_ad, String calisan_soyad, String calisan_tel, String calisan_adres, String calisan_mail) {
        this.calisan_id = calisan_id;
        this.calisan_ad = calisan_ad;
        this.calisan_soyad = calisan_soyad;
        this.calisan_tel = calisan_tel;
        this.calisan_adres = calisan_adres;
        this.calisan_mail = calisan_mail;
    }

    public int getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(int calisan_id) {
        this.calisan_id = calisan_id;
    }

    public String getCalisan_ad() {
        return calisan_ad;
    }

    public void setCalisan_ad(String calisan_ad) {
        this.calisan_ad = calisan_ad;
    }

    public String getCalisan_soyad() {
        return calisan_soyad;
    }

    public void setCalisan_soyad(String calisan_soyad) {
        this.calisan_soyad = calisan_soyad;
    }

    public String getCalisan_tel() {
        return calisan_tel;
    }

    public void setCalisan_tel(String calisan_tel) {
        this.calisan_tel = calisan_tel;
    }

    public String getCalisan_adres() {
        return calisan_adres;
    }

    public void setCalisan_adres(String calisan_adres) {
        this.calisan_adres = calisan_adres;
    }

    public String getCalisan_mail() {
        return calisan_mail;
    }

    public void setCalisan_mail(String calisan_mail) {
        this.calisan_mail = calisan_mail;
    }

    public UrunVeHizmetler getHizmet() {
        if (this.hizmet == null) {
            this.hizmet = new UrunVeHizmetler();
        }
        return hizmet;
    }

    public void setHizmet(UrunVeHizmetler hizmet) {
        this.hizmet = hizmet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.calisan_id;
        hash = 83 * hash + Objects.hashCode(this.calisan_ad);
        hash = 83 * hash + Objects.hashCode(this.calisan_soyad);
        hash = 83 * hash + Objects.hashCode(this.calisan_tel);
        hash = 83 * hash + Objects.hashCode(this.calisan_adres);
        hash = 83 * hash + Objects.hashCode(this.calisan_mail);
        hash = 83 * hash + Objects.hashCode(this.hizmet);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Calisanlar other = (Calisanlar) obj;
        if (this.calisan_id != other.calisan_id) {
            return false;
        }
        if (!Objects.equals(this.calisan_ad, other.calisan_ad)) {
            return false;
        }
        if (!Objects.equals(this.calisan_soyad, other.calisan_soyad)) {
            return false;
        }
        if (!Objects.equals(this.calisan_tel, other.calisan_tel)) {
            return false;
        }
        if (!Objects.equals(this.calisan_adres, other.calisan_adres)) {
            return false;
        }
        if (!Objects.equals(this.calisan_mail, other.calisan_mail)) {
            return false;
        }
        if (!Objects.equals(this.hizmet, other.hizmet)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Calisanlar{" + "calisan_id=" + calisan_id + ", calisan_ad=" + calisan_ad + ", calisan_soyad=" + calisan_soyad + ", calisan_tel=" + calisan_tel + ", calisan_adres=" + calisan_adres + ", calisan_mail=" + calisan_mail + ", hizmet=" + hizmet + '}';
    }

}
