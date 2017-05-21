
package beanpackage;

public class Kullanici {
    // uye tablosunun kolonları
    private String kadi = "";
    private String adi = "";
    private String soyadi = "";
    private String sifre = "";
    private String email = "";
    private int yetki = 0;
    
    // kolonların getter ve setter metotları

    /**
     * @return the kadi
     */
    public String getKadi() {
        return kadi;
    }

    /**
     * @param kadi the kadi to set
     */
    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    /**
     * @return the adi
     */
    public String getAdi() {
        return adi;
    }

    /**
     * @param adi the adi to set
     */
    public void setAdi(String adi) {
        this.adi = adi;
    }

    /**
     * @return the soyadi
     */
    public String getSoyadi() {
        return soyadi;
    }

    /**
     * @param soyadi the soyadi to set
     */
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the yetki
     */
    public int getYetki() {
        return yetki;
    }

    /**
     * @param yetki the yetki to set
     */
    public void setYetki(int yetki) {
        this.yetki = yetki;
    }
}
