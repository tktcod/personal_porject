package kiosk;

public class Main {
    public static void main(String[] args) {
        KioskApp kioskApp = new KioskApp();

        kioskApp.initializeMenuList();
        kioskApp.executeKiosk();
        System.out.println("키오스크가 종료되었습니다.");
    }
}