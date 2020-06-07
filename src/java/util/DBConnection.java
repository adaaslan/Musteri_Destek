package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() {
        Connection c = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/musteridestek?user=root&password=123");
            System.out.println("Connected to the MariDB server successfully.");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
