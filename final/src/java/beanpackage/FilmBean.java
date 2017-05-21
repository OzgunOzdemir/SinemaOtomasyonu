
package beanpackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilmBean implements Serializable {

    private List<Film> klist;
    private Film film;

    public FilmBean() {
        klist = new ArrayList<Film>();
        film = new Film();
    }
    // filmleri listeleme method
    public String filmgetir() {
        klist.clear();
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanı baglantısı kuruldu
            String sorgu = "select * from film";
            PreparedStatement prs; // veritabanına sorgu gonderebilmek icin preparedStatement nesnesi olusturuldu
            prs = c.prepareStatement(sorgu); // sorgu gönderildi   
            ResultSet rs = prs.executeQuery();  // veritabanından dönen verileri tutmak icin resulset nesnesi olusturuldu

            while (rs.next()) {
                Film k = new Film(); // Film sınıfından nesne olusturuldu
                k.setFilmid(rs.getInt("FILMID"));
                k.setFilmad(rs.getString("FILMAD"));
                k.setKonu(rs.getString("KONU"));
                k.setVtarih(rs.getString("VTARIH"));
                k.setTur(rs.getString("TUR"));
                k.setSalonno(rs.getInt("SALONNO"));
                getKlist().add(k); // degerler liste tutuluyor
                setKlist(getKlist());
            }

            sonuc = "filmler"; // method en son filmler sınıfına gider

        } catch (SQLException ex) {
            Logger.getLogger(DenemeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;
    }

    public String filmadmin() {
        klist.clear();

        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan();
            String sorgu = "select * from film";
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu);
            ResultSet rs = prs.executeQuery();

            while (rs.next()) {
                Film k = new Film();
                k.setFilmid(rs.getInt("FILMID"));
                k.setFilmad(rs.getString("FILMAD"));
                k.setKonu(rs.getString("KONU"));
                k.setVtarih(rs.getString("VTARIH"));
                k.setTur(rs.getString("TUR"));
                k.setSalonno(rs.getInt("SALONNO"));
                getKlist().add(k);
                setKlist(getKlist());
            }

            sonuc = "filmsil";

        } catch (SQLException ex) {
            Logger.getLogger(DenemeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;
    }
    // film kayit method
    public String filmkayit() {
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanı baglantı saglandı
            String sorgu = ("INSERT INTO film (\"FILMID\", \"FILMAD\", \"KONU\", \"VTARIH\", \"TUR\", \"SALONNO\") " + " values (?,?,?,?,?,?)"); // sql sorgu
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu); // sorgu veritabanına gönderildi
            prs.setInt(1, film.getFilmid());
            prs.setString(2, film.getFilmad());
            prs.setString(3, film.getKonu());
            prs.setString(4, film.getVtarih());
            prs.setString(5, film.getTur());
            prs.setInt(6, film.getSalonno());
            System.err.println(sorgu);
            prs.executeUpdate(); // veritabanını guncelleme icin method calıstırıldı

            sonuc = "filmsil";

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return sonuc;
    }

    /**
     * @return the klist
     */
    public List<Film> getKlist() {
        return klist;
    }

    /**
     * @param klist the klist to set
     */
    public void setKlist(List<Film> klist) {
        this.klist = klist;
    }

    /**
     * @return the film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * @param film the film to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }

}
