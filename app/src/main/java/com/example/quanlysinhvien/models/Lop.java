package com.example.quanlysinhvien.models;

public class Lop {
    private int id;
    private String tenlop,mota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Lop(String tenlop, String mota) {
        this.id = id;
        this.tenlop = tenlop;
        this.mota = mota;
    }
    public Lop() {
    }
}




