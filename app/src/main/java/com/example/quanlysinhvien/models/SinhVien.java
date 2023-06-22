package com.example.quanlysinhvien.models;

public class SinhVien {
    private int id;
    private String ten;
    private int namsinh;
    private String quequan;
    private String namhoc;

    public SinhVien(String ten, int namsinh, String quequan, String namhoc) {
        this.id = id;
        this.ten = ten;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.namhoc = namhoc;
    }
    public SinhVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }
}
