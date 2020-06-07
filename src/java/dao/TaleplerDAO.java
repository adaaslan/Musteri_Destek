package dao;

import entity.Talepler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class TaleplerDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private UrunVeHizmetlerDAO hizmetdao;
    private MusterilerDAO musteridao;
    private DosyaDAO dosyadao;
    private CalisanlarDAO calisandao;

    public void insert(Talepler talep) throws SQLException {
        try {
            pst = this.getConnection().prepareStatement("insert into talepler"
                    + " (talep_oncelik,talep_durum,talep_konu,talep_mesaj,hizmet_id,musteri_id,dosya_id,calisan_id,talep_tarih)"
                    + " values (?,?,?,?,?,?,?,?,?)");

            pst.setString(1, talep.getTalep_oncelik());
            pst.setString(2, talep.getTalep_durum());
            pst.setString(3, talep.getTalep_konu());
            pst.setString(4, talep.getTalep_mesaj());
            pst.setInt(5, talep.getHizmet().getHizmet_id());
            pst.setInt(6, talep.getMusteri().getMusteri_id());
            if (talep.getDosya() != null && talep.getDosya().getDosya_id() != 0) {
                pst.setInt(7, talep.getDosya().getDosya_id());
            } else {
                pst.setNull(7, java.sql.Types.BIGINT);
            }
            pst.setInt(8, talep.getCalisan().getCalisan_id());
            java.sql.Date sqlDate = new Date(Calendar.getInstance().getTime().getTime());
            System.out.println("dao.TaleplerDAO.insert()" + sqlDate);
            pst.setDate(9, sqlDate);

            pst.execute();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
    }

    public void delete(int talep_id) throws SQLException {
        try {
            pst = this.getConnection().prepareStatement("delete from talepler where talep_id=?");
            pst.setInt(1, talep_id);
            pst.executeUpdate();
            pst.close();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
    }

    public void updateDurum(Talepler talep) throws SQLException {
        try {
            pst = this.getConnection().prepareStatement("update talepler set talep_durum=? where talep_id=?");

            pst.setString(1, talep.getTalep_durum());
            pst.setInt(2, talep.getTalep_id());
            pst.executeUpdate();
            pst.close();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
    }

    public List<Talepler> findAll() throws SQLException {
        List<Talepler> tlist = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from talepler");
            rs = pst.executeQuery();

            while (rs.next()) {
                Talepler temp = new Talepler();

                temp.setTalep_id(rs.getInt("talep_id"));
                temp.setTalep_oncelik(rs.getString("talep_oncelik"));
                temp.setTalep_durum(rs.getString("talep_durum"));
                temp.setTalep_konu(rs.getString("talep_konu"));
                temp.setTalep_mesaj(rs.getString("talep_mesaj"));
                temp.setTalep_tarih(rs.getString("talep_tarih"));
                temp.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
                temp.setMusteri(this.getMusteridao().find(rs.getInt("musteri_id")));
                int dosyaId = rs.getInt("dosya_id");
                if (dosyaId != 0) {
                    temp.setDosya(this.getDosyadao().find(rs.getInt("dosya_id")));
                }
                temp.setCalisan(this.getCalisandao().find(rs.getInt("calisan_id")));
                tlist.add(temp);
            }
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
        return tlist;
    }

    public Talepler find(int id) throws SQLException {
        Talepler talep = null;
        try {
            pst = this.getConnection().prepareStatement("select * from talepler where talep_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                talep = new Talepler();
                talep.setTalep_id(rs.getInt("talep_id"));
                talep.setTalep_oncelik(rs.getString("talep_oncelik"));
                talep.setTalep_durum(rs.getString("talep_durum"));
                talep.setTalep_konu(rs.getString("talep_konu"));
                talep.setTalep_mesaj(rs.getString("talep_mesaj"));
                talep.setTalep_tarih(rs.getString("talep_tarih"));
                talep.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
                talep.setMusteri(this.getMusteridao().find(rs.getInt("musteri_id")));
                talep.setDosya(this.getDosyadao().find(rs.getInt("dosya_id")));
                talep.setCalisan(this.getCalisandao().find(rs.getInt("calisan_id")));
            }
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
        return talep;
    }

    public List<Talepler> findBy(String konu, int hizmet_id) throws SQLException {
        List<Talepler> talepler = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("select * from talepler  ");

            if (hizmet_id != 0 || (!konu.equals("") && !konu.isEmpty())) {
                sql.append("where");
            }
            if (!konu.equals("") && !konu.isEmpty()) {
                sql.append(" talep_konu like ? ");
                if (hizmet_id != 0) {
                    sql.append(" and hizmet_id = ?");
                }
            } else if (hizmet_id != 0) {
                sql.append(" hizmet_id = ?");
            }

            int i = 1;
            pst = this.getConnection().prepareStatement(sql.toString());
            if ((!konu.equals("") && !konu.isEmpty())) {
                String searchKey = "%" + konu + "%";
                pst.setString(i, searchKey);
                i++;
            }
            if (hizmet_id != 0) {
                pst.setInt(i, hizmet_id);
            }
            rs = pst.executeQuery();

            while (rs.next()) {
                Talepler talep = new Talepler();
                talep.setTalep_id(rs.getInt("talep_id"));
                talep.setTalep_oncelik(rs.getString("talep_oncelik"));
                talep.setTalep_durum(rs.getString("talep_durum"));
                talep.setTalep_konu(rs.getString("talep_konu"));
                talep.setTalep_mesaj(rs.getString("talep_mesaj"));
                talep.setTalep_tarih(rs.getString("talep_tarih"));
                talep.setHizmet(this.getHizmetdao().find(rs.getInt("hizmet_id")));
                talep.setMusteri(this.getMusteridao().find(rs.getInt("musteri_id")));
                talep.setDosya(this.getDosyadao().find(rs.getInt("dosya_id")));
                talep.setCalisan(this.getCalisandao().find(rs.getInt("calisan_id")));
                talepler.add(talep);
            }
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                disconnect();
            } catch (SQLException e) {
            }
        }
        return talepler;
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

    public MusterilerDAO getMusteridao() {
        if (this.musteridao == null) {
            this.musteridao = new MusterilerDAO();
        }
        return musteridao;
    }

    public void setMusteridao(MusterilerDAO musteridao) {
        this.musteridao = musteridao;
    }

    public DosyaDAO getDosyadao() {
        if (this.dosyadao == null) {
            this.dosyadao = new DosyaDAO();
        }
        return dosyadao;
    }

    public void setDosyadao(DosyaDAO dosyadao) {
        this.dosyadao = dosyadao;
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
