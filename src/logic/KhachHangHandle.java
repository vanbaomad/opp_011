package logic;

import constant.LoaiKH;
import entitry.KhachHang;

import java.util.Scanner;

public class KhachHangHandle {
    private KhachHang[] khachHangs;
    private int khCount;

    public KhachHangHandle() {
        this.khachHangs = new KhachHang[100];
        khCount = 0;
    }

    public KhachHang[] getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public int getKhCount() {
        return khCount;
    }

    public void setKhCount(int khCount) {
        this.khCount = khCount;
    }

    public void themKhachHang(KhachHang kh) {
        if (khCount < khachHangs.length) {
            khachHangs[khCount++] = kh;
        }
    }

    public void inDanhSachKhachHang() {
        for (int i = 0; i < khCount; i++) {
            System.out.println(khachHangs[i]);
        }
    }

    public void infor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten khach hang: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDT = scanner.nextLine();
        System.out.print("Nhap loai khach hang(CN/TT/DN): ");
        String loaiKHInput = scanner.nextLine();
        LoaiKH loaiKH = null;
        switch (loaiKHInput) {
            case "CN":
                loaiKH = LoaiKH.CN;
                break;
            case "TT":
                loaiKH = LoaiKH.TT;
                break;
            case "DN":
                loaiKH = LoaiKH.DN;
                break;
            default:
                System.out.println("Loai khach hang khong hop le.");
                return;
        }
        KhachHang kh = new KhachHang(hoTen, diaChi, soDT, loaiKH);
        themKhachHang(kh);
    }
}
