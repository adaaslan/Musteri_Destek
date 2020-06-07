package dao;

import entity.Musteriler;
import entity.UrunVeHizmetler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusterilerDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private UrunVeHizmetlerDAO hizmetdao;

    public int insert(Musteriler musteri) throws Exception {
        try {
            pst = this.getConnection().prepareStatement("insert into musteriler (musteri_ad,musteri_soyad,musteri_mail,musteri_tel) values (?,?,?,?)");
            pst.setString(1, musteri.getMusteri_ad());
            pst.setString(2, musteri.getMusteri_soyad());
            pst.setString(3, musteri.getMusteri_mail());
            pst.setString(4, musteri.getMusteri_tel());

            pst.executeUpdate();
            pst.close();
            pst = this.getConnection().prepareStatement("select max(musteri_id) from musteriler");
            rs = pst.executeQuery();
            int musteri_id = 0;
            if (rs.next()) {
                musteri_id = rs.getInt(1);
            }

//            for (UrunVeHizmetler hizmet : musteri.getAldigiurun()) {
//                pst = this.getConnection().prepareStatement("insert into aldigiurun(hizmet_id,musteri_id) values(?,?)");
//                pst.setInt(1, hizmet.getHizmet_id());
//                pst.setInt(2, musteri_id);
//                pst.executeUpdate();
//            }
            pst.close();
            return musteri_id;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Musteriler musteri) {
        try {
            pst = this.getConnection().prepareStatement("delete from musteriler where musteri_id=?");
            pst.setInt(1, musteri.getMusteri_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public void update(Musteriler musteri) {
        try {
            pst = this.getConnection().prepareStatement("update musteriler set musteri_ad=? , musteri_soyad=? , musteri_mail=?,musteri_tel=? where musteri_id=?");

            pst.setString(1, musteri.getMusteri_ad());
            pst.setString(2, musteri.getMusteri_soyad());
            pst.setString(3, musteri.getMusteri_mail());
            pst.setString(4, musteri.getMusteri_tel());
            pst.setInt(5, musteri.getMusteri_id());
            pst.executeUpdate();
            pst.close();

            pst = this.getConnection().prepareStatement("delete from aldigiurun  where musteri_id=?");
            pst.setInt(1, musteri.getMusteri_id());
            pst.executeUpdate();
            pst.close();
            for (UrunVeHizmetler hizmet : musteri.getAldigiurun()) {
                pst = this.getConnection().prepareStatement("insert into aldigiurun(hizmet_id,musteri_id) values(?,?)");
                pst.setInt(1, hizmet.getHizmet_id());
                pst.setInt(2, musteri.getMusteri_id());
                pst.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Musteriler find(int id) {
        Musteriler musteri = null;

        try {
            pst = this.getConnection().prepareStatement("select * from musteriler where musteri_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                musteri = new Musteriler();

                musteri.setMusteri_id(rs.getInt("musteri_id"));
                musteri.setMusteri_ad(rs.getString("musteri_ad"));
                musteri.setMusteri_soyad(rs.getString("musteri_soyad"));
                musteri.setMusteri_mail(rs.getString("musteri_mail"));
                musteri.setMusteri_tel(rs.getString("musteri_tel"));
                musteri.setAldigiurun(this.getHizmetdao().getAlinanUrun(musteri.getMusteri_id()));

            }
        } catch (SQLException ex) {
            System.out.println(" MusteriDAO HATA(Find): " + ex.getMessage());
        }

        return musteri;
    }

    public List<Musteriler> findAll() { // bu findall metodu one to many ilişkisideki eklemeler de selectmenubox ın içinde kullanılıyor.Sayfalamada çıkan hatayı önlemek için yazıldı.
        List<Musteriler> mlist = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from musteriler");
            rs = pst.executeQuery();

            while (rs.next()) {
                Musteriler temp = new Musteriler();

                temp.setMusteri_id(rs.getInt("musteri_id"));
                temp.setMusteri_ad(rs.getString("musteri_ad"));
                temp.setMusteri_soyad(rs.getString("musteri_soyad"));
                temp.setMusteri_mail(rs.getString("musteri_mail"));
                temp.setMusteri_tel(rs.getString("musteri_tel"));
                temp.setAldigiurun(this.getHizmetdao().getAlinanUrun(temp.getMusteri_id()));

                mlist.add(temp);
            }
        } catch (SQLException ex) {

            System.out.println("MusteriDAO HATA(FİNDALL):" + ex.getMessage());
        }
        return mlist;
    }

    public List<Musteriler> Alinanurun(int hizmet_id) {
        List<Musteriler> list = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from aldigiurun where hizmet_id=?");
            pst.setInt(1, hizmet_id);
            rs = pst.executeQuery();

            while (rs.next()) {
                list.add(this.find(rs.getInt("musteri_id")));
            }
        } catch (Exception ex) {
            System.out.println("MusteriDAO HATA(Alinanurun):" + ex.getMessage());
        }
        return list;
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
