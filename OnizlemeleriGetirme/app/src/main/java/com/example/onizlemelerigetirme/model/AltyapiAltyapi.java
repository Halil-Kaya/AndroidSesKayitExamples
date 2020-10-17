package com.example.onizlemelerigetirme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AltyapiAltyapi {


    @SerializedName("altyapiId")
    @Expose
    private Integer altyapiId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("sure")
    @Expose
    private String sure;
    @SerializedName("boyut")
    @Expose
    private String boyut;
    @SerializedName("puan")
    @Expose
    private Integer puan;
    @SerializedName("fotoUrl")
    @Expose
    private String fotoUrl;
    @SerializedName("ad")
    @Expose
    private String ad;
    @SerializedName("soz")
    @Expose
    private String soz;
    @SerializedName("sanatciSanatciId")
    @Expose
    private Integer sanatciSanatciId;
    @SerializedName("sanatciSanatci")
    @Expose
    private Object sanatciSanatci;
    @SerializedName("onizleme")
    @Expose
    private Object onizleme;

    public Integer getAltyapiId() {
        return altyapiId;
    }

    public void setAltyapiId(Integer altyapiId) {
        this.altyapiId = altyapiId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Integer getPuan() {
        return puan;
    }

    public void setPuan(Integer puan) {
        this.puan = puan;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoz() {
        return soz;
    }

    public void setSoz(String soz) {
        this.soz = soz;
    }

    public Integer getSanatciSanatciId() {
        return sanatciSanatciId;
    }

    public void setSanatciSanatciId(Integer sanatciSanatciId) {
        this.sanatciSanatciId = sanatciSanatciId;
    }

    public Object getSanatciSanatci() {
        return sanatciSanatci;
    }

    public void setSanatciSanatci(Object sanatciSanatci) {
        this.sanatciSanatci = sanatciSanatci;
    }

    public Object getOnizleme() {
        return onizleme;
    }

    public void setOnizleme(Object onizleme) {
        this.onizleme = onizleme;
    }
}
