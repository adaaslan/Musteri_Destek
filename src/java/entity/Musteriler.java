package entity;

import java.util.List;
import java.util.Objects;

public class Musteriler {

    private int musteri_id;
    private String musteri_ad;
    private String musteri_soyad;
    private String musteri_mail;
    private String musteri_tel;

    private List<UrunVeHizmetler> aldigiurun;

    public Musteriler() {
    }

    public Musteriler(int musteri_id, String musteri_ad, String musteri_soyad, String musteri_mail, String musteri_tel, List<UrunVeHizmetler> aldigiurun) {
        this.musteri_id = musteri_id;
        this.musteri_ad = musteri_ad;
        this.musteri_soyad = musteri_soyad;
        this.musteri_mail = musteri_mail;
        this.musteri_tel = musteri_tel;
        this.aldigiurun = aldigiurun;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getMusteri_ad() {
        return musteri_ad;
    }

    public void setMusteri_ad(String musteri_ad) {
        this.musteri_ad = musteri_ad;
    }

    public String getMusteri_soyad() {
        return musteri_soyad;
    }

    public void setMusteri_soyad(String musteri_soyad) {
        this.musteri_soyad = musteri_soyad;
    }

    public String getMusteri_mail() {
        return musteri_mail;
    }

    public void setMusteri_mail(String musteri_mail) {
        this.musteri_mail = musteri_mail;
    }

    public String getMusteri_tel() {
        return musteri_tel;
    }

    public void setMusteri_tel(String musteri_tel) {
        this.musteri_tel = musteri_tel;
    }

    public List<UrunVeHizmetler> getAldigiurun() {
        return aldigiurun;
    }

    public void setAldigiurun(List<UrunVeHizmetler> aldigiurun) {
        this.aldigiurun = aldigiurun;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.musteri_id;
        hash = 37 * hash + Objects.hashCode(this.musteri_ad);
        hash = 37 * hash + Objects.hashCode(this.musteri_soyad);
        hash = 37 * hash + Objects.hashCode(this.musteri_mail);
        hash = 37 * hash + Objects.hashCode(this.musteri_tel);
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
        final Musteriler other = (Musteriler) obj;
        if (this.musteri_id != other.musteri_id) {
            return false;
        }
        if (!Objects.equals(this.musteri_ad, other.musteri_ad)) {
            return false;
        }
        if (!Objects.equals(this.musteri_soyad, other.musteri_soyad)) {
            return false;
        }
        if (!Objects.equals(this.musteri_mail, other.musteri_mail)) {
            return false;
        }
        if (!Objects.equals(this.musteri_tel, other.musteri_tel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Musteriler{" + "musteri_id=" + musteri_id + ", musteri_ad=" + musteri_ad + ", musteri_soyad=" + musteri_soyad + ", musteri_mail=" + musteri_mail + ", musteri_tel=" + musteri_tel + ", aldigiurun=" + aldigiurun + '}';
    }

}
