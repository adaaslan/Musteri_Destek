package entity;

import java.util.Objects;

public class Talepler {

    private int talep_id;
    private String talep_oncelik;
    private String talep_tarih;
    private String talep_durum;
    private String talep_mesaj;
    private String talep_konu;

    private UrunVeHizmetler hizmet;
    private Musteriler musteri;
    private Dosya dosya;
    private Calisanlar calisan;

    public Talepler() {
    }

    public Talepler(int talep_id, String talep_oncelik, String talep_tarih, String talep_durum, String talep_konu, String talep_mesaj) {
        this.talep_id = talep_id;
        this.talep_oncelik = talep_oncelik;
        this.talep_tarih = talep_tarih;
        this.talep_durum = talep_durum;
        this.talep_konu = talep_konu;
        this.talep_mesaj = talep_mesaj;
    }

    public int getTalep_id() {
        return talep_id;
    }

    public void setTalep_id(int talep_id) {
        this.talep_id = talep_id;
    }

    public String getTalep_oncelik() {
        return talep_oncelik;
    }

    public void setTalep_oncelik(String talep_oncelik) {
        this.talep_oncelik = talep_oncelik;
    }

    public String getTalep_tarih() {
        return talep_tarih;
    }

    public void setTalep_tarih(String talep_tarih) {
        this.talep_tarih = talep_tarih;
    }

    public String getTalep_durum() {
        return talep_durum;
    }

    public void setTalep_durum(String talep_durum) {
        this.talep_durum = talep_durum;
    }

    public String getTalep_konu() {
        return talep_konu;
    }

    public void setTalep_konu(String talep_konu) {
        this.talep_konu = talep_konu;
    }

    public String getTalep_mesaj() {
        return talep_mesaj;
    }

    public void setTalep_mesaj(String talep_mesaj) {
        this.talep_mesaj = talep_mesaj;
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

    public Musteriler getMusteri() {
        if (this.musteri == null) {
            this.musteri = new Musteriler();
        }
        return musteri;
    }

    public void setMusteri(Musteriler musteri) {
        this.musteri = musteri;
    }

    public Dosya getDosya() {
        if (this.dosya == null) {
            this.dosya = new Dosya();
        }
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public Calisanlar getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisanlar calisan) {
        this.calisan = calisan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.talep_id;
        hash = 79 * hash + Objects.hashCode(this.talep_oncelik);
        hash = 79 * hash + Objects.hashCode(this.talep_tarih);
        hash = 79 * hash + Objects.hashCode(this.talep_durum);
        hash = 79 * hash + Objects.hashCode(this.talep_mesaj);
        hash = 79 * hash + Objects.hashCode(this.hizmet);
        hash = 79 * hash + Objects.hashCode(this.musteri);
        hash = 79 * hash + Objects.hashCode(this.dosya);
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
        final Talepler other = (Talepler) obj;
        if (this.talep_id != other.talep_id) {
            return false;
        }
        if (!Objects.equals(this.talep_oncelik, other.talep_oncelik)) {
            return false;
        }
        if (!Objects.equals(this.talep_tarih, other.talep_tarih)) {
            return false;
        }
        if (!Objects.equals(this.talep_durum, other.talep_durum)) {
            return false;
        }
        if (!Objects.equals(this.talep_mesaj, other.talep_mesaj)) {
            return false;
        }
        if (!Objects.equals(this.hizmet, other.hizmet)) {
            return false;
        }
        if (!Objects.equals(this.musteri, other.musteri)) {
            return false;
        }
        if (!Objects.equals(this.dosya, other.dosya)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Talepler{" + "talep_id=" + talep_id + ", talep_oncelik=" + talep_oncelik + ", talep_tarih=" + talep_tarih + ", talep_durum=" + talep_durum + ", talep_mesaj=" + talep_mesaj + ", hizmet=" + hizmet + ", musteri=" + musteri + ", dosya=" + dosya + '}';
    }

}
