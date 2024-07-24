package entitry;

import java.io.Serializable;
import java.util.Scanner;

public class NganHang  implements Serializable {
    private static int auto = 100;
    private int maNH;
    private String tenNH;
    private double laiSuat;

    public NganHang() {
        this.maNH = auto;
        auto++;
    }

    public NganHang(String tenNH, double laiSuat) {
        this.tenNH = tenNH;
        this.laiSuat = laiSuat;
    }

    public String getTenNH() {
        return tenNH;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public int getMaNH() {
        return maNH;
    }


    @Override
    public String toString() {
        return "MaNH: " + maNH + ", TenNH: " + tenNH + ", LaiSuat: " + laiSuat;
    }
}
