package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UrunVeHizmetler {

    private int hizmet_id;
    private String hizmet_adi;
    private String hizmet_aciklama;

    private List<Calisanlar> calisanlar = new ArrayList<Calisanlar>();

    public UrunVeHizmetler() {
    }

    public UrunVeHizmetler(int hizmet_id, String hizmet_adi, String hizmet_aciklama) {
        this.hizmet_id = hizmet_id;
        this.hizmet_adi = hizmet_adi;
        this.hizmet_aciklama = hizmet_aciklama;
    }

    public int getHizmet_id() {
        return hizmet_id;
    }

    public void setHizmet_id(int hizmet_id) {
        this.hizmet_id = hizmet_id;
    }

    public String getHizmet_adi() {
        return hizmet_adi;
    }

    public void setHizmet_adi(String hizmet_adi) {
        this.hizmet_adi = hizmet_adi;
    }

    public String getHizmet_aciklama() {
        return hizmet_aciklama;
    }

    public void setHizmet_aciklama(String hizmet_aciklama) {
        this.hizmet_aciklama = hizmet_aciklama;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 97 * hash + this.hizmet_id;
//        hash = 97 * hash + Objects.hashCode(this.hizmet_adi);
//        hash = 97 * hash + Objects.hashCode(this.hizmet_aciklama);
//        hash = 97 * hash + Objects.hashCode(this.calisan);
//        return hash;
//    }

    public List<Calisanlar> getCalisanlar() {
        return calisanlar;
    }

    public void setCalisanlar(List<Calisanlar> calisanlar) {
        this.calisanlar = calisanlar;
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
        final UrunVeHizmetler other = (UrunVeHizmetler) obj;
        if (this.hizmet_id != other.hizmet_id) {
            return false;
        }
//        if (!Objects.equals(this.hizmet_adi, other.hizmet_adi)) {
//            return false;
//        }
//        if (!Objects.equals(this.hizmet_aciklama, other.hizmet_aciklama)) {
//            return false;
//        }
//        if (!Objects.equals(this.calisan, other.calisan)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "UrunVeHizmetler{" + "hizmet_id=" + hizmet_id + ", hizmet_adi=" + hizmet_adi + ", hizmet_aciklama=" + hizmet_aciklama + ", calisanlar=" + calisanlar + '}';
    }

}
