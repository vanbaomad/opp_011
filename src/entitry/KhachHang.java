package entitry;

import constant.LoaiKH;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang  implements Serializable {
    private static int auto = 10000;
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private LoaiKH loaiKH;

    public KhachHang(int maKH) {
        this.maKH = auto;
        auto++;
    }

    public KhachHang(String hoTen, String diaChi, String soDT, LoaiKH loaiKH) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.loaiKH = loaiKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getMaKH() {
        return maKH;
    }


    @Override
    public String toString() {
        return "MaKH: " + maKH + ", HoTen: " + hoTen + ", DiaChi: " + diaChi + ", SoDT: " + soDT + ", LoaiKH: " + loaiKH;
    }
}
