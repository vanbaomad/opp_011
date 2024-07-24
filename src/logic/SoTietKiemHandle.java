package logic;

import entitry.KhachHang;
import entitry.NganHang;
import entitry.SoTietKiem;

import java.util.Scanner;

public class SoTietKiemHandle {
    private SoTietKiem[] soTietKiems;
    private KhachHang[] khachHangs;
    private NganHang[] nganHangs;
    private int stkCount;

    public SoTietKiemHandle() {
    }

    public SoTietKiem[] getSoTietKiems() {
        return soTietKiems;
    }

    public void setSoTietKiems(SoTietKiem[] soTietKiems) {
        this.soTietKiems = soTietKiems;
    }

    public KhachHang[] getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public NganHang[] getNganHangs() {
        return nganHangs;
    }

    public void setNganHangs(NganHang[] nganHangs) {
        this.nganHangs = nganHangs;
    }

    public int getStkCount() {
        return stkCount;
    }

    public void setStkCount(int stkCount) {
        this.stkCount = stkCount;
    }

    public SoTietKiemHandle(KhachHang[] khachHangs, NganHang[] nganHangs) {
        this.soTietKiems = new SoTietKiem[500];
        this.stkCount = 0;
        this.khachHangs = khachHangs;
        this.nganHangs = nganHangs;
    }

    public void themSoTietKiem(SoTietKiem stk) {
        if (stkCount < soTietKiems.length) {
            soTietKiems[stkCount++] = stk;
        }
    }

    public void inDanhSachSoTietKiem() {
        for (int i = 0; i < stkCount; i++) {
            System.out.println(soTietKiems[i]);
        }
    }

    public void sapXepSoTietKiemTheoTenKhachHang() {
        for (int i = 0; i < stkCount - 1; i++) {
            if (soTietKiems[i] == null) {
                continue;
            }
            for (int j = 0; j < stkCount - i - 1; j++) {
                if (soTietKiems[j] == null) {
                    continue;
                }
                if (soTietKiems[j].getKhachHang().getHoTen().compareTo(soTietKiems[j + 1].getKhachHang().getHoTen()) > 0) {
                    SoTietKiem temp = soTietKiems[j];
                    soTietKiems[j] = soTietKiems[j + 1];
                    soTietKiems[j + 1] = temp;
                }
            }
        }
    }

    public void sapXepSoTietKiemTheoSoTienGui() {
        for (int i = 0; i < stkCount - 1; i++) {
            for (int j = 0; j < stkCount - i - 1; j++) {
                if (soTietKiems[j].getSoTienGui() < soTietKiems[j + 1].getSoTienGui()) {
                    SoTietKiem temp = soTietKiems[j];
                    soTietKiems[j] = soTietKiems[j + 1];
                    soTietKiems[j + 1] = temp;
                }
            }
        }
    }

    public void bangKeTongSoTienGui() {
        for (KhachHang khachHang : khachHangs) {
            if (khachHang == null) {
                continue;
            }
            double tongTien = 0;
            for (int j = 0; j < stkCount; j++) {
                if (soTietKiems[j].getKhachHang().equals(khachHang)) {
                    tongTien += soTietKiems[j].getSoTienGui();
                }
            }
            System.out.println("KhachHang: " + khachHang.getHoTen() + ", TongTien: " + tongTien);
        }
    }

    public void infor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        int maKH = scanner.nextInt();
        System.out.print("Nhap ma ngan hang: ");
        int maNH = scanner.nextInt();
        System.out.print("Nhap so tien gui: ");
        double soTienGui = scanner.nextDouble();
        scanner.nextLine();

        KhachHang khachHang = null;
        for (KhachHang kh : khachHangs) {
            if (kh != null && kh.getMaKH() == maKH) {
                khachHang = kh;
                break;
            }
        }
        if (khachHang == null) {
            System.out.println("Khach hang khong ton tai.");
            return;
        }

        NganHang nganHang = null;
        for (NganHang nh : nganHangs) {
            if (nh != null && nh.getMaNH() == maNH) {
                nganHang = nh;
                break;
            }
        }
        if (nganHang == null) {
            System.out.println("Ngan hang khong ton tai.");
            return;
        }

        SoTietKiem stk = new SoTietKiem(khachHang, nganHang, soTienGui);
        themSoTietKiem(stk);
    }
}
