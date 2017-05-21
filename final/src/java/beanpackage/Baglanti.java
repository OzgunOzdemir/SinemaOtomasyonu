package beanpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Baglanti {

    public Connection baglan() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");// veritabanının url adresi  
            //veritabanı adı proje , kullanıcı adı postgres , password 1234
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/proje", "postgres", "1234");
        } catch (Exception ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
