/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dosya;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DosyaDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public int insert(Dosya d) {
        try {
//            byte[] bytes = new byte[d.getDosya_size()];
//            DataInputStream dis = new DataInputStream(d.getDosya_value());
//            dis.readFully(bytes);

            pst = this.getConnection().prepareStatement("insert into dosya(dosya_yolu,dosya_ismi,dosya_tipi, dosya_value) "
                    + " values(?,?,?,?)"
            );
            pst.setString(1, d.getDosya_yolu());
            pst.setString(2, d.getDosya_ismi());
            pst.setString(3, d.getDosya_tipi());
            pst.setBytes(4, d.getDosya_value());
            pst.execute();

            pst = this.getConnection().prepareStatement("select max(dosya_id) from dosya");
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void delete(Dosya dosya) {
        String query = "delete from dosya where dosya_id=?";

        try {
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, dosya.getDosya_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Dosya> findAll() {
        List<Dosya> dList = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select*from dosya");

            rs = pst.executeQuery();
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setDosya_id(rs.getInt("dosya_id"));
                d.setDosya_yolu(rs.getString("dosya_yolu"));
                d.setDosya_ismi(rs.getString("dosya_ismi"));
                d.setDosya_tipi(rs.getString("dosya_tipi"));
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public Dosya find(int id) {
        Dosya dosya = null;

        try {
            pst = getConnection().prepareStatement("select * from dosya where dosya_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();

            dosya = new Dosya();
            dosya.setDosya_id(rs.getInt("dosya_id"));
            dosya.setDosya_yolu(rs.getString("dosya_yolu"));
            dosya.setDosya_ismi(rs.getString("dosya_ismi"));
            dosya.setDosya_tipi(rs.getString("dosya_tipi"));
            dosya.setDosya_value(rs.getBytes("dosya_value"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dosya;

    }

}
