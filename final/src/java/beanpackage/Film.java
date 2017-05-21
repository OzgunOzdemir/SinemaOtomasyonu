package beanpackage;

import java.io.Serializable;

public class Film implements Serializable {
    // film tablosunun kolonları
    private Integer filmid = 0;
    private String filmad = "";
    private String konu = "";
    private String vtarih = "";
    private String tur = "";
    private Integer salonno = 0;

    public Film() { // constructors method
    }
   // kolonların getter ve setter metodları
    public Integer getFilmid() {
        return filmid;
    }
    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }
    public String getFilmad() {
        return filmad;
    }
    public void setFilmad(String filmad) {
        this.filmad = filmad;
    }
    public String getKonu() {
        return konu;
    }
    public void setKonu(String konu) {
        this.konu = konu;
    }
    public String getVtarih() {
        return vtarih;
    }
    public void setVtarih(String vtarih) {
        this.vtarih = vtarih;
    }
    public String getTur() {
        return tur;
    }
    public void setTur(String tur) {
        this.tur = tur;
    }
    public Integer getSalonno() {
        return salonno;
    }
    public void setSalonno(Integer salonno) {
        this.salonno = salonno;
    }
}
