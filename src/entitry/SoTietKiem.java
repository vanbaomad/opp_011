package entitry;

import java.io.Serializable;
import java.util.Scanner;

public class SoTietKiem implements Serializable {
    private KhachHang khachHang;
    private NganHang nganHang;
    private double soTienGui;

    public SoTietKiem(KhachHang khachHang, NganHang nganHang, double soTienGui) {
        this.khachHang = khachHang;
        this.nganHang = nganHang;
        this.soTienGui = soTienGui;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NganHang getNganHang() {
        return nganHang;
    }

    public void setNganHang(NganHang nganHang) {
        this.nganHang = nganHang;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    @Override
    public String toString() {
        return "KhachHang: " + khachHang.getHoTen() + ", NganHang: " + nganHang.getTenNH() + ", SoTienGui: " + soTienGui;
    }
}
