package dev.melis.travelplanapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Place {
    @Id
    private String id;

    @Indexed
    private String sehir;

    private String isim;

    private String aciklama;

    private byte[] resim;

    public String getId() {
        return id;
    }

    public Place setId(String id) {
        this.id = id;
        return this;
    }

    public String getSehir() {
        return sehir;
    }

    public Place setSehir(String sehir) {
        this.sehir = sehir;
        return this;
    }

    public String getIsim() {
        return isim;
    }

    public Place setIsim(String isim) {
        this.isim = isim;
        return this;
    }

    public String getAciklama() {
        return aciklama;
    }

    public Place setAciklama(String aciklama) {
        this.aciklama = aciklama;
        return this;
    }

    public byte[] getResim() {
        return resim;
    }

    public Place setResim(byte[] resim) {
        this.resim = resim;
        return this;
    }
}
