package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    private MusterilerDAO musteriDao;
    private CalisanlarDAO calisanDao;

    public Kullanici find(String kullaniciAdi) {
        Kullanici k = null;
        try {
            pst = this.getConnection().prepareStatement("select ad, soyad, kullaniciAdi, rol, sifre, musteri_id, calisan_id from kullanici where kullaniciAdi = ?");
            pst.setString(1, kullaniciAdi);
            rs = pst.executeQuery();

            while (rs.next()) {
                k = new Kullanici();
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                k.setAdSoyad(rs.getString("ad") + " " + rs.getString("soyad"));
                k.setKullaniciAdi(rs.getString("kullaniciAdi"));
                k.setRol(rs.getString("rol"));
                k.setSifre(rs.getString("sifre"));
                k.setMusteri(this.getMusteriDao().find(rs.getInt("musteri_id")));
                k.setCalisan(this.getCalisanDao().find(rs.getInt("calisan_id")));
            }
        } catch (SQLException ex) {
            System.out.println("EgitimDAO HATA(Find):" + ex.getMessage());;
        }
        return k;
    }

    public void insert(Kullanici kullanici) throws Exception {
        try {
            pst = this.getConnection().prepareStatement("insert into kullanici (ad, soyad, kullaniciAdi, sifre, rol, musteri_id) values (?,?,?,?,?,?)");
            pst.setString(1, kullanici.getAd());
            pst.setString(2, kullanici.getSoyad());
            pst.setString(3, kullanici.getKullaniciAdi());
            pst.setString(4, kullanici.getSifre());
            pst.setString(5, "M");
            pst.setInt(6, kullanici.getMusteri().getMusteri_id());
//            pst.setInt(7, "M");
            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            throw ex;
        }

    }

    public MusterilerDAO getMusteriDao() {
        if (this.musteriDao == null) {
            this.musteriDao = new MusterilerDAO();
        }
        return musteriDao;
    }

    public void setMusteriDao(MusterilerDAO musteriDao) {
        this.musteriDao = musteriDao;
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
