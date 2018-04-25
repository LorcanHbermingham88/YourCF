package com.example.lorcan.yourcf.Model;

/**
 * Created by lorcan on 09/03/18.
 */

public class MedicalProfile {

    private String DOB;
    private String siblingWithCf;
    private String cfDiabetes;
    private String ageOfPrognosis;

    public MedicalProfile() {
    }

    public MedicalProfile(String DOB, String siblingWithCf, String cfDiabetes, String ageOfPrognosis) {
        this.DOB = DOB;
        this.siblingWithCf = siblingWithCf;
        this.cfDiabetes = cfDiabetes;
        this.ageOfPrognosis = ageOfPrognosis;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSiblingWithCf() {
        return siblingWithCf;
    }

    public void setSiblingWithCf(String siblingWithCf) {
        this.siblingWithCf = siblingWithCf;
    }

    public String getCfDiabetes() {
        return cfDiabetes;
    }

    public void setCfDiabetes(String cfDiabetes) {
        this.cfDiabetes = cfDiabetes;
    }

    public String getAgeOfPrognosis() {
        return ageOfPrognosis;
    }

    public void setAgeOfPrognosis(String ageOfPrognosis) {
        this.ageOfPrognosis = ageOfPrognosis;
    }
}

