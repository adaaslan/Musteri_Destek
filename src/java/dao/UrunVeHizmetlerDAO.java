package dao;

import entity.Calisanlar;
import entity.UrunVeHizmetler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UrunVeHizmetlerDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private CalisanlarDAO calisandao;

    public void insert(UrunVeHizmetler hizmet) {
        try {
            pst = this.getConnection().prepareStatement("insert into hizmetler (hizmet_adi,hizmet_aciklama,calisan_id) values (?,?,?)");

            pst.setString(1, hizmet.getHizmet_adi());
            pst.setString(2, hizmet.getHizmet_aciklama());
//            pst.setInt(3, hizmet.getCalisan().getCalisan_id());

            pst.execute();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("HizmetDAO HATA(Create) : " + ex.getMessage());
        }
    }

    public void delete(UrunVeHizmetler hizmet) {

        try {
            pst = this.getConnection().prepareStatement("delete from hizmetler where hizmet_id=?");
            pst.setInt(1, hizmet.getHizmet_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" HizmetDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public void update(UrunVeHizmetler hizmet) {
        try {
            pst = this.getConnection().prepareStatement("update hizmetler set hizmet_adi=? , hizmet_aciklama=? where hizmet_id=?");

            pst.setString(1, hizmet.getHizmet_adi());
            pst.setString(2, hizmet.getHizmet_aciklama());
//            pst.setInt(3, hizmet.getCalisan().getCalisan_id());
            pst.setInt(3, hizmet.getHizmet_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("HizmetDAO HATA(Update):" + ex.getMessage());
        }
    }

    public UrunVeHizmetler find(int id) {
        UrunVeHizmetler hizmet = null;
        List<Calisanlar> calisanlar = new ArrayList<Calisanlar>();
        try {
            pst = this.getConnection().prepareStatement("select * from hizmetler where hizmet_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                hizmet = new UrunVeHizmetler();
                hizmet.setHizmet_id(rs.getInt("hizmet_id"));
                hizmet.setHizmet_adi(rs.getString("hizmet_adi"));
                hizmet.setHizmet_aciklama(rs.getString("hizmet_aciklama"));
            }
//            pst = this.getConnection().prepareStatement("select calisan_id from calisanlar where hizmet_id = ?");
//            pst.setInt(1, id);
//            rs = pst.executeQuery();

//            while (rs.next()) {
//                Calisanlar calisan = this.getCalisandao().find(rs.getInt("calisan_id"));
//                calisanlar.add(calisan);
//            }
//            hizmet.setCalisanlar(calisanlar);

        } catch (SQLException ex) {

            System.out.println("HizmetDAO HATA(Find):" + ex.getMessage());;
        }
        return hizmet;
    }

    public List<UrunVeHizmetler> findAll() {
        List<UrunVeHizmetler> hlist = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from hizmetler");
            rs = pst.executeQuery();

            while (rs.next()) {
                UrunVeHizmetler temp = new UrunVeHizmetler();

                temp.setHizmet_id(rs.getInt("hizmet_id"));
                temp.setHizmet_adi(rs.getString("hizmet_adi"));
                temp.setHizmet_aciklama(rs.getString("hizmet_aciklama"));
//                temp.setCalisan(this.getCalisandao().find(rs.getInt("calisan_id")));
                hlist.add(temp);
            }
        } catch (SQLException ex) {

            System.out.println("HizmetDAO HATA(FİNDALL):" + ex.getMessage());
        }
        return hlist;
    }

    public List<UrunVeHizmetler> getAlinanUrun(int musteri_id) {
        List<UrunVeHizmetler> urunalinan = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from aldigiurun where musteri_id=?");
            pst1.setInt(1, musteri_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                urunalinan.add(this.find(rs1.getInt("hizmet_id")));

            }

        } catch (Exception ex) {
            System.out.println("HizmetDAO HATA(getAlinanUrun):" + ex.getMessage());
        }

        return urunalinan;
    }

    public CalisanlarDAO getCalisandao() {
        if (this.calisandao == null) {
            this.calisandao = new CalisanlarDAO();
        }
        return calisandao;
    }

    public void setCalisandao(CalisanlarDAO calisandao) {
        this.calisandao = calisandao;
    }

}
