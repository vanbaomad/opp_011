package logic;

import entitry.KhachHang;
import entitry.NganHang;
import entitry.SoTietKiem;

import java.util.Scanner;

public class QuanLy {
    private static final String KH_FILE = "kh.txt";
    private static final String NH_FILE = "nh.txt";
    private static final String STK_FILE = "sok.txt";
    private final KhachHangHandle khachHangHandle;
    private final NganHangHandle nganHangHandle;
    private final SoTietKiemHandle soTietKiemHandle;

    public QuanLy() {
        KhachHang[] khachHangs = FileUtils.readFromFile(KH_FILE, KhachHang[].class);
        NganHang[] nganHangs = FileUtils.readFromFile(NH_FILE, NganHang[].class);
        SoTietKiem[] soTietKiems = FileUtils.readFromFile(STK_FILE, SoTietKiem[].class);

        khachHangHandle = new KhachHangHandle();
        nganHangHandle = new NganHangHandle();
        soTietKiemHandle = new SoTietKiemHandle(khachHangs, nganHangs);

        khachHangHandle.setKhachHangs(khachHangs);
        nganHangHandle.setNganHangs(nganHangs);
        soTietKiemHandle.setSoTietKiems(soTietKiems);
    }

    public void menu() {
        while (true) {
            printMenuOptions();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    khachHangHandle.infor();
                    break;
                case 2:
                    nganHangHandle.infor();
                    break;
                case 3:
                    soTietKiemHandle.infor();
                    break;
                case 4:
                    khachHangHandle.inDanhSachKhachHang();
                    break;
                case 5:
                    nganHangHandle.inDanhSachNganHang();
                    break;
                case 6:
                    soTietKiemHandle.inDanhSachSoTietKiem();
                    break;
                case 7:
                    soTietKiemHandle.sapXepSoTietKiemTheoTenKhachHang();
                    soTietKiemHandle.inDanhSachSoTietKiem();
                    break;
                case 8:
                    soTietKiemHandle.sapXepSoTietKiemTheoSoTienGui();
                    soTietKiemHandle.inDanhSachSoTietKiem();
                    break;
                case 9:
                    soTietKiemHandle.bangKeTongSoTienGui();
                    break;
                case 0:
                    FileUtils.writeToFile(KH_FILE, khachHangHandle.getKhachHangs());
                    FileUtils.writeToFile(NH_FILE, nganHangHandle.getNganHangs());
                    FileUtils.writeToFile(STK_FILE, soTietKiemHandle.getSoTietKiems());
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private int chooseFunction() {
        while (true) {
            System.out.print("Chon chuc nang mong muon (0-9): ");
            try {
                int functionChoice = new Scanner(System.in).nextInt();
                if (functionChoice >= 0 && functionChoice <= 9) {
                    return functionChoice;
                } else {
                    System.out.println("Lua chon khong hop le, vui long chon so tu 0-9");
                }
            } catch (Exception e) {
                System.out.println("Dau vao khong hop le, vui long nhap so nguyen");
                new Scanner(System.in).next();
            }
        }
    }


    private void printMenuOptions() {
        System.out.println("1. Nhap danh sach khach hang.");
        System.out.println("2. Nhap danh sach ngan hang.");
        System.out.println("3. Nhap so tiet kiem.");
        System.out.println("4. In danh sach khach hang.");
        System.out.println("5. In danh sach ngan hang.");
        System.out.println("6. In danh sach so tiet kiem.");
        System.out.println("7. Sap xep so tiet kiem theo ten khach hang.");
        System.out.println("8. Sap xep so tiet kiem theo so tien gui.");
        System.out.println("9. Bang ke tong so tien gui.");
        System.out.println("0. Thoat.");
        System.out.print("Chon: ");
    }
}
