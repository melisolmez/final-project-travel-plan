package dev.melis.travelplanapp.service.travel;

import org.springframework.web.multipart.MultipartFile;

public class SavePlaceRequest {

    private String sehir;
    private String isim;
    private String aciklama;
    private MultipartFile resim;

    public String getSehir() {
        return sehir;
    }

    public SavePlaceRequest setSehir(String sehir) {
        this.sehir = sehir;
        return this;
    }

    public String getIsim() {
        return isim;
    }

    public SavePlaceRequest setIsim(String isim) {
        this.isim = isim;
        return this;
    }

    public String getAciklama() {
        return aciklama;
    }

    public SavePlaceRequest setAciklama(String aciklama) {
        this.aciklama = aciklama;
        return this;
    }

    public MultipartFile getResim() {
        return resim;
    }

    public SavePlaceRequest setResim(MultipartFile resim) {
        this.resim = resim;
        return this;
    }
}
