/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.context.FacesContext;

/**
 *
 * @author Asus
 */
public class FilmdetayBean {

    private String filmId;
    private Film film;

    /**
     * Creates a new instance of FilmdetayBean
     */
    public FilmdetayBean() {

        film = new Film();
    }

    // filmleri listeleme method
    public String filmdetaylistele() {
        String sonuc = "";
        try {

            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanına bağlandı
            String sorgu = "select * from film where isbn=" + "'" + filmId + "'";
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu); // veritabanına sorgu gönderildi
            ResultSet rs = prs.executeQuery(); // dönen değerleri tutmak için resulset nesnesi oluşturuldu

            while (rs.next()) {

                film.setFilmid(rs.getInt("FILMID"));
                film.setFilmad(rs.getString("FILMAD"));
                film.setKonu(rs.getString("KONU"));
                film.setVtarih(rs.getString("VTARIH"));
                film.setTur(rs.getString("TUR"));
                film.setSalonno(rs.getInt("SALONNO"));

            }
            sonuc = "filmsil";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return sonuc;
    }
    // film silme method
    public String filmsil() {
        String sonuc = "";
        try {

            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanı bağlantısı sağlandı
            String sorgu = "delete from film where \"FILMID\"=" + filmId; // filmi ıd ye göre silme işlemi için sql sorgu yazıldı
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu); // sql sorgu veritabanına gönderildi
            prs.executeUpdate();

            FilmBean kbb = (FilmBean) FacesContext.getCurrentInstance().getELContext().getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), null, "filmBean");
            kbb.filmgetir();

            sonuc = "filmsil";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return sonuc;
    }

    /**
     * @return the filmId
     */
    public String getFilmId() {
        return filmId;
    }

    /**
     * @param filmId the filmId to set
     */
    public void setFilmId(String filmId) {
        this.filmId = filmId;
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
