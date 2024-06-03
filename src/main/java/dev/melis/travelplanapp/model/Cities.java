package dev.melis.travelplanapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "citiesandplace")
public class Cities {
    @Id
    private String id;
    private String isim;
    private String tanitim;
    private List<Place> yerler;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTanitim() {
        return tanitim;
    }

    public void setTanitim(String tanitim) {
        this.tanitim = tanitim;
    }

    public List<Place> getYerler() {
        return yerler;
    }

    public void setYerler(List<Place> yerler) {
        this.yerler = yerler;
    }

}
