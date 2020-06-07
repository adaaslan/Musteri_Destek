package dao;

import entity.Calisanlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalisanlarDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private UrunVeHizmetlerDAO hizmetdao;

    public void insert(Calisanlar calisan) {
        try {
            pst = this.getConnection().prepareStatement("insert into calisanlar (calisan_ad,calisan_soyad,calisan_tel,calisan_adres,calisan_mail,hizmet_id) values (?,?,?,?,?,?)");

            pst.setString(1, calisan.getCalisan_ad());
            pst.setString(2, calisan.getCalisan_soyad());
            pst.setString(3, calisan.getCalisan_tel());
            pst.setString(4, calisan.getCalisan_adres());
            pst.setString(5, calisan.getCalisan_mail());
            pst.setInt(6, calisan.getHizmet().getHizmet_id());

            pst.execute();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("CalisanDAO HATA(Create) : " + ex.getMessage());
        }
    }

    public void delete(Calisanlar calisan) {

        try {
            pst = this.getConnection().prepareStatement("delete from calisanlar where calisan_id=?");
            pst.setInt(1, calisan.getCalisan_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" CalisanDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public void update(Calisanlar calisan) {
        try {
            pst = this.getConnection().prepareStatement("update calisanlar set calisan_ad=? , calisan_soyad=? , calisan_tel=? , calisan_adres=? , calisan_mail=?, hizmet_id =? where calisan_id=?");

            pst.setString(1, calisan.getCalisan_ad());
            pst.setString(2, calisan.getCalisan_soyad());
            pst.setString(3, calisan.getCalisan_tel());
            pst.setString(4, calisan.getCalisan_adres());
            pst.setString(5, calisan.getCalisan_mail());
            pst.setInt(6, calisan.getHizmet().getHizmet_id());
            pst.setInt(7, calisan.getCalisan_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("CalisanDAO HATA(Update):" + ex.getMessage());
        }
    }

    public List<Calisanlar> findAll() {
        List<Calisanlar> clist = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from calisanlar");
            rs = pst.executeQuery();

            while (rs.next()) {
                Calisanlar temp = new Calisanlar();

                temp.setCalisan_id(rs.getInt("calisan_id"));
                temp.setCalisan_ad(rs.getString("calisan_ad"));
                temp.setCalisan_soyad(rs.getString("calisan_soyad"));
                temp.setCalisan_tel(rs.getString("calisan_tel"));
                temp.setCalisan_adres(rs.getString("calisan_adres"));
                temp.setCalisan_mail(rs.getString("calisan_mail"));
                temp.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
                clist.add(temp);
            }
        } catch (SQLException ex) {

            System.out.println("EgitimDAO HATA(FİNDALL):" + ex.getMessage());
        }
        return clist;
    }

    public Calisanlar find(int id) {
        Calisanlar calisan = null;
        try {
            pst = this.getConnection().prepareStatement("select * from calisanlar where calisan_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                calisan = new Calisanlar();
                calisan.setCalisan_id(rs.getInt("calisan_id"));
                calisan.setCalisan_ad(rs.getString("calisan_ad"));
                calisan.setCalisan_soyad(rs.getString("calisan_soyad"));
                calisan.setCalisan_tel(rs.getString("calisan_tel"));
                calisan.setCalisan_adres(rs.getString("calisan_adres"));
                calisan.setCalisan_mail(rs.getString("calisan_mail"));
                calisan.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
            }
        } catch (SQLException ex) {
            System.out.println("CalisanDAO HATA(Find):" + ex.getMessage());;
        }
        return calisan;
    }

    public Calisanlar findByHizmet(int id) throws Exception {
        Calisanlar calisan = null;
        try {
            pst = this.getConnection().prepareStatement("select * from calisanlar where hizmet_id = ? limit 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                calisan = new Calisanlar();
                calisan.setCalisan_id(rs.getInt("calisan_id"));
                calisan.setCalisan_ad(rs.getString("calisan_ad"));
                calisan.setCalisan_soyad(rs.getString("calisan_soyad"));
                calisan.setCalisan_tel(rs.getString("calisan_tel"));
                calisan.setCalisan_adres(rs.getString("calisan_adres"));
                calisan.setCalisan_mail(rs.getString("calisan_mail"));
                calisan.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return calisan;
    }

    public UrunVeHizmetlerDAO getHizmetdao() {
        if (this.hizmetdao == null) {
            this.hizmetdao = new UrunVeHizmetlerDAO();
        }
        return hizmetdao;
    }

    public void setHizmetdao(UrunVeHizmetlerDAO hizmetdao) {
        this.hizmetdao = hizmetdao;
    }

}
