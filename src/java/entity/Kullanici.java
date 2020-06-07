package entity;

import java.io.Serializable;

public class Kullanici implements Serializable {

    private static final long serialVersionUID = -8703728992996671676L;
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;
    private String adSoyad;
    private String rol;
    private String rolStr;
    private Musteriler musteri;
    private Calisanlar calisan;

    public Kullanici() {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getRolStr() {
        return rolStr;
    }

    public void setRolStr(String rolStr) {
        this.rolStr = rolStr;
    }

    public Musteriler getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteriler musteri) {
        this.musteri = musteri;
    }

    public Calisanlar getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisanlar calisan) {
        this.calisan = calisan;
    }

}
