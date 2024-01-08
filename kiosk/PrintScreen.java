package kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintScreen {
    private static PrintScreen instance;
    private PrintScreen() {}
    public static PrintScreen getInstance() {
        if (instance == null) {
            instance = new PrintScreen();
        }
        return instance;
    }
    private static final KioskApp kioskApp = new KioskApp();

    // 키오스크 초기 화면
    public void kioskInitScreen(){
        //clearScreen();
        System.out.println("현재 " + kioskApp.getOrderCount() + "번째 주문입니다");
        System.out.println(kioskApp.getRestaurantName() + "에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
    }
    // 메뉴 출력 부분
    // 키오스크 메뉴 리스트 출력
    public void printMenuList(List<Menu> menuList) {
        int count = 0;
        final String product = "Product";
        final String order = "Order";

        System.out.println("[Product Menu]");
        List<Menu> productMenus = menuList.stream().filter(menu -> product.equals(menu.getCategory())).toList();
        for (int i = 0; i < productMenus.size(); i++) {
            System. out.printf("%-1d.",count+1);
            Menu menu = productMenus.get(count);
            printMenu(menu);
            count++;
        }

        System.out.println();
        System.out.println("[Order Menu]");
        List<Menu> orderMenus = menuList.stream().filter(menu -> order.equals(menu.getCategory())).toList();
        for (Menu orderMenu : orderMenus) {
            System.out.printf("%-1d.", count + 1);
            printMenu(orderMenu);
            count++;
        }
    }
    // 메뉴 단일 출력
    public void printMenu(Menu menu){
        System.out.printf("%-23s | %s%n", menu.getName(), menu.getDescription());
    }

    // 상품 출력 부분
    // 상품 리스트 출력
    public void printProductList(List<Product> productList, String category) {
        //clearScreen();
        System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ "+ category + " Menu ]");
        List<Product> products = productList.stream().filter(product -> category.equals(product.getCategory())).toList();
        for (int i = 0; i < products.size(); i++) {
            System. out.printf("%-1d.",i+1);
            Product product = products.get(i);
            printProduct(product);
        }
    }
    // 상품 단일 출력
    public void printProduct(Product product){
        System.out.printf("%-23s | %-7s | %s%n", product.getName(), formatPrice(product.getPrice()), product.getDescription());
    }
    // 상품 가격 출력 시 가격을 문자열로 변환 후 화폐 단위 추가
    public String formatPrice(int price){
        return String.format("W %-5d", price);
    }
    public String formatPrice(int price, int value) {
        String formatSpecifier = "W %-" + value + "d";
        return String.format(formatSpecifier, price);
    }
    // 주문한 상품정보 출력
    public void printOrder(Product product, Integer quantity){
        System.out.printf("%-23s | %-7s | %-2d개 | %s%n", product.getName(), formatPrice(product.getPrice()), quantity, product.getDescription());
    }

    // 상품을 순서에 따라 출력
    public void printOrderByCategory(Order order, Map<Product, Integer> orderMap) {
        System.out.println("[ Orders ]");

        // 카테고리별로 정렬된 상품 리스트 가져오기
        Map<String, List<Product>> categoryMap = new HashMap<>();
        for (Product product : order.getOrderList(orderMap)) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        // 정의한 순서에 따라 출력
        for (String category : getCategoryOrder()) {
            if (categoryMap.containsKey(category)) {
                for (Product product : categoryMap.get(category)) {
                    printOrder(product, order.getQuantity(orderMap, product));
                }
            }
        }
    }

    // 원하는 상품 순서 정의
    private List<String> getCategoryOrder() {
        return List.of("Toast", "Set", "SideMenu", "Beverage");
    }

    //
    public void printTotalPrice(int totalPrice){
        String formatPrice = formatPrice(totalPrice, 8);
        System.out.println("[ Total ]");
        System.out.printf("%s", formatPrice);
        System.out.println();
    }


    // 확인, 취소로 유저 입력 확인
    private boolean getUserConfirm(){
        while(true) {
            System.out.println("1. 확인 \t\t 2. 취소");
            int num = InputHandler.getIntInput();
            if (num == 1) return true;
            else if (num == 2) return false;
        }
    }
    public boolean getUserConfirm(String string1, String string2) {
        while(true) {
            System.out.printf("1. %s \t\t 2. %s\n", string1, string2);
            int num = InputHandler.getIntInput();
            if (num == 1) return true;
            else if (num == 2) return false;}}

    public void orderScreen(Order order, List<Product> productList, String category){
        int firstNumber = InputHandler.getIntInput();
        List<Product> products = productList.stream().filter(product -> category.equals(product.getCategory())).toList();
        if(firstNumber <= 0 || firstNumber > products.size())   return;

        System.out.println("구매를 원하시는 상품의 개수를 입력해주세요.");
        int secondNumber = InputHandler.getIntInput();

        if(confirmScreen(products.get(firstNumber-1), secondNumber,"위 메뉴를 장바구니에 추가하시겠습니까?"))
            order.addProduct(products.get(firstNumber - 1), secondNumber);
    }

    // 유저 입력으로 확정하기 (설명만)
    public boolean confirmScreen(String string){
        //clearScreen();
        System.out.println(string);
        System.out.println();
        return getUserConfirm();
    }

    // 유저 입력으로 확정하기 + (상품정보 + 설명)
    public boolean confirmScreen(Product product, String string){
        //clearScreen();
        printProduct(product);
        System.out.println(string);
        return getUserConfirm();
    }

    // 유저 입력으로 확정하기 + (상품정보 + 개수 + 설명) 상품 제거할때 사용
    public boolean confirmScreen(Product product, Integer quantity, String string){
        //clearScreen();
        printOrder(product, quantity);
        System.out.println(string);
        return getUserConfirm();
    }

    // 주문 확정
    public void confirmOrder() {
        try {
            //clearScreen();
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("주문번호는 [ " + kioskApp.getOrderCount() + " ]번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }
    }
    // 1. 돌아가기 출력
    public void press1ToBack(){
        System.out.println("1. 돌아가기");
        while(true) {
            if(InputHandler.getIntInput() == 1)break;
        }
    }

    // 빈줄 15줄을 만들어 화면을 지우기
//    public void clearScreen() {
//        for(int i = 0; i < 15; i++)
//            System.out.println();
//    }
}
