package kiosk;

import java.util.*;


public class KioskApp {
    private static int orderCount = 1;
    private static final String restaurantName = "이삭토스트";
    private static final List<Product> productList =  new ArrayList<>();
    private static final List<Menu> menuList = new ArrayList<>();
    private final Order order = new Order();
    private final PrintScreen printScreen = PrintScreen.getInstance();
    // 메뉴 데이터 초기화
    public void initializeMenuList() {
        // 상품 리스트 초기화
        InitializeMenu.initializeProduct(productList);
        // 메뉴 리스트 초기화
        InitializeMenu.initializeMenu(menuList);
    }

    // 키오스크 실행
    public void executeKiosk() {

        label:
        while (true) {
            System.out.println();
            printScreen.kioskInitScreen();
            printScreen.printMenuList(menuList);

            switch (InputHandler.getIntInput()) {
                case 1:
                    printScreen.printProductList(productList, "Toast");
                    printScreen.orderScreen(order, productList, "Toast");
                    break;
                case 2:
                    printScreen.printProductList(productList, "Set");
                    printScreen.orderScreen(order, productList, "Set");
                    break;
                case 3:
                    printScreen.printProductList(productList, "SideMenu");
                    printScreen.orderScreen(order, productList, "SideMenu");
                    break;
                case 4:
                    printScreen.printProductList(productList, "Beverage");
                    printScreen.orderScreen(order, productList, "Beverage");
                    break;
                case 5:         // 장바구니 확인 후 주문
                    System.out.println();
                    printScreen.printOrderByCategory(order, order.getOrderMap());


                    int totalPrice = order.calculateTotalPrice(order.getOrderMap());
                    System.out.println();
                    printScreen.printTotalPrice(totalPrice);

                    if(printScreen.getUserConfirm("주문", "메뉴판")) {
                        printScreen.confirmOrder();
                        order.addOrderedProduct();
                        order.clearProduct();
                        increaseOrderCount();
                    }
                    break;
                case 6:         //장바구니 초기화
                    if(printScreen.confirmScreen("진행하던 주문을 취소하시겠습니까?")) order.clearProduct();
                    break;
                case 7:        // 종료
                    if(printScreen.confirmScreen("키오스크를 종료하시겠습니까?")){
                        InputHandler.closeScanner();
                        break label;
                    }
                    break;
                case 0:
                    System.out.println();
                    System.out.println("[ 총 판매 상품 목록 현황 ]");
                    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
                    printScreen.printOrderByCategory(order, order.getOrderedMap());
                    System.out.println();

                    int totalOrderedPrice = order.calculateTotalPrice(order.getOrderedMap());
                    System.out.println("[ 총 판매 금액 현황 ]");
                    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
                    System.out.println("W "+ totalOrderedPrice);
                    printScreen.press1ToBack();
                    break;
            }
        }
    }

    public void increaseOrderCount() {
        orderCount++;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public String getRestaurantName(){
        return restaurantName;
    }

}
