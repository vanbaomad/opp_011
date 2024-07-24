package logic;

import entitry.NganHang;

import java.util.Scanner;

public class NganHangHandle {
    private NganHang[] nganHangs;
    private int nhCount;

    public NganHangHandle() {
        this.nganHangs = new NganHang[100];
        this.nhCount = 0;
    }

    public void themNganHang(NganHang nh) {
        if (nhCount < nganHangs.length) {
            nganHangs[nhCount++] = nh;
        }
    }

    public void inDanhSachNganHang() {
        for (int i = 0; i < nhCount; i++) {
            System.out.println(nganHangs[i]);
        }
    }

    public void infor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten ngan hang: ");
        String tenNH = scanner.nextLine();
        System.out.print("Nhap lai suat: ");
        double laiSuat = scanner.nextDouble();
        NganHang nh = new NganHang(tenNH, laiSuat);
        themNganHang(nh);
    }

    public NganHang[] getNganHangs() {
        return nganHangs;
    }

    public void setNganHangs(NganHang[] nganHangs) {
        this.nganHangs = nganHangs;
    }

    public int getNhCount() {
        return nhCount;
    }

    public void setNhCount(int nhCount) {
        this.nhCount = nhCount;
    }
}
