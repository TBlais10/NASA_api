package com.nasaapi.nasaapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APOD {

    private String title;
    private String date;
    private String explanation;
    private String hdurl = "https://apod.nasa.gov/apod/image/2111/MACSJ0138_Hubble_1762.jpg";


    private String copyright;
    private URL iconURL = new URL(hdurl);
    // iconURL is null when not found
    private ImageIcon icon = new ImageIcon(iconURL);
    Image image = icon.getImage();

    public APOD() throws MalformedURLException {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "Nasa API{" +
                "date='" + date + '\'' +
                "title='" + title + '\'' +
                "explination=" + explanation + '\'' +
                "copyright='" + copyright + '\'' +
                "image= " + hdurl +
                '}';
    }

}
