package beanpackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DenemeBean implements Serializable {

    private Kullanici kullanici;

    public DenemeBean() {
        kullanici = new Kullanici();

    }

    // sisteme e-mail ve sifre ile giris metodu
    public String giris() {
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanına bağlatı yapıldı
            String sorgu = "select * from UYE where EMAIL=" + "'" + kullanici.getEmail() + "'" + " and SIFRE=" + "'" + kullanici.getSifre() + "'"; //Sql sorgu
            PreparedStatement prs; // veritabanına sorgu gönderebilmek için preparedStatement nesnesi oluşturuldu
            prs = c.prepareStatement(sorgu);
            ResultSet rs = prs.executeQuery(); // executeQuery metodu çalıştırıldı
            Kullanici k = new Kullanici();
            while (rs.next()) {
                k.setAdi(rs.getString("ADI"));
                k.setSoyadi(rs.getString("SOYADI"));
                k.setKadi(rs.getString("KADI"));
                k.setYetki(rs.getInt("YETKI"));
                k.setEmail(rs.getString("EMAIL"));
                k.setSifre(rs.getString("SIFRE"));
            }
            if (k.getEmail().equals(kullanici.getEmail()) && k.getSifre().equals(kullanici.getSifre()) && k.getYetki() == 1) { // e-mail ve sifre eslesirse ve yetki 1 ise admin sayfasına yonlendirilir
                sonuc = "filmkayit";
            } else if (k.getEmail().equals(kullanici.getEmail()) && k.getSifre().equals(kullanici.getSifre()) && k.getYetki() == 2) { // e-mail ve sifre eslesirse ve yetki 2 ise kullanıcı sayfasına yonlendirilir
                sonuc = "filmler";
            } else {
                sonuc = "giris";
            }

        } catch (SQLException ex) {
            Logger.getLogger(DenemeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;
    }

    // sisteme yeni kullanıcı kaydetme metodu
    public String kullanicikaydet() {
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan(); // veritabanına baglandı
            Kullanici k = new Kullanici();
            String sorgu = ("INSERT INTO uye (\"kadi\",\"adi\",\"soyadi\",\"email\",\"sifre\",\"yetki\") VALUES (?,?,?,?,?,?)"); // sql sorgu
            PreparedStatement prs; // veritabanına sorgu gönderebilmek için preparedStatement nesnesi oluşturuldu
            prs = c.prepareStatement(sorgu);
            // veritabanı kolonları kadi,adi,soyadi,email ve sifre ile dolduruldu
            prs.setString(1, kullanici.getKadi());
            prs.setString(2, kullanici.getAdi());
            prs.setString(3, kullanici.getSoyadi());
            prs.setString(4, kullanici.getEmail());
            prs.setString(5, kullanici.getSifre());
            prs.setInt(6, 2);

            prs.executeUpdate(); // guncelleme sorguları icin executeUpdate metodu calıstırıldı

            sonuc = "giris";

        } catch (SQLException ex) {
            Logger.getLogger(DenemeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;

    }

    /**
     * @return the kadi
     */
    /**
     * @return the kullanici
     */
    public Kullanici getKullanici() {
        return kullanici;
    }

    /**
     * @param kullanici the kullanici to set
     */
    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
}
