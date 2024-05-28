package com.example.myapplication.slot6;

public class SanPham {
    private String masp;
    private String tensp;
    private int soluongSP;

    public SanPham(String masp, String tensp, int soluongSP) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluongSP = soluongSP;
    }

    public SanPham() {
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluongSP() {
        return soluongSP;
    }

    public void setSoluongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }
}
