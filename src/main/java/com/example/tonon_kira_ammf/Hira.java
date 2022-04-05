package com.example.tonon_kira_ammf;

public class Hira {
    private int id_hira;
    private String lohateny;
    private String sokajy;
    private String anarana;

    public Hira(int id_hira, String lohateny, String sokajy, String anarana) {
        this.id_hira = id_hira;
        this.lohateny = lohateny;
        this.sokajy = sokajy;
        this.anarana = anarana;
    }

    public int getId_hira() {
        return id_hira;
    }

    public void setId_hira(int id_hira) {
        this.id_hira = id_hira;
    }

    public String getLohateny() {
        return lohateny;
    }

    public void setLohateny(String lohateny) {
        this.lohateny = lohateny;
    }

    public String getSokajy() {
        return sokajy;
    }

    public void setSokajy(String sokajy) {
        this.sokajy = sokajy;
    }

    public String getAnarana() {
        return anarana;
    }

    public void setAnarana(String anarana) {
        this.anarana = anarana;
    }
}
