package com.example.onizlemelerigetirme.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Onizleme {

    @SerializedName("onIzlemeId")
    @Expose
    private Integer onIzlemeId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("boyut")
    @Expose
    private String boyut;
    @SerializedName("altyapiAltyapiId")
    @Expose
    private Integer altyapiAltyapiId;
    @SerializedName("altyapiAltyapi")
    @Expose
    private AltyapiAltyapi altyapiAltyapi;

    public Integer getOnIzlemeId() {
        return onIzlemeId;
    }

    public void setOnIzlemeId(Integer onIzlemeId) {
        this.onIzlemeId = onIzlemeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Integer getAltyapiAltyapiId() {
        return altyapiAltyapiId;
    }

    public void setAltyapiAltyapiId(Integer altyapiAltyapiId) {
        this.altyapiAltyapiId = altyapiAltyapiId;
    }

    public AltyapiAltyapi getAltyapiAltyapi() {
        return altyapiAltyapi;
    }

    public void setAltyapiAltyapi(AltyapiAltyapi altyapiAltyapi) {
        this.altyapiAltyapi = altyapiAltyapi;
    }

}
