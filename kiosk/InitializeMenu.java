package kiosk;
import java.util.*;

public class InitializeMenu {
    // 메뉴 초기화 메소드
    public static void initializeMenu(List<Menu> menuList){
        // 상품 메뉴
        menuList.add(new Menu("Toast", "맛있는 토스트", "Product"));
        menuList.add(new Menu("Set Menu", "다함께 즐겨요", "Product"));
        menuList.add(new Menu("Side Menu", "사이드 메뉴", "Product"));
        menuList.add(new Menu("Beverage", "맛있는 음료", "Product"));
        // 주문 메뉴
        menuList.add(new Menu("Order", "장바구니를 확인 후 주문합니다", "Order"));
        menuList.add(new Menu("Cancel", "진행중인 주문을 취소합니다", "Order"));
    }

    // 상품 초기화 메소드
    public static void initializeProduct(List<Product> productList){
        // 토스트 데이터
        productList.add(new Product("Bulgogi Special", 3100, "오리지널 불고기의 감칠맛을 가득 담았어요.", "Toast"));
        productList.add(new Product("Chicken Special", 3200, "달콤한 칠리소스와 풍성한 양배추가 매력적인 통닭다리살 치킨 토스트에요.", "Toast"));
        productList.add(new Product("Hot Bacon Chicken", 3300, "강렬한 핫칠리 소스의 맛이 매력적인 통닭다리살 치킨 토스트에요.", "Toast"));
        productList.add(new Product("Ham Cheese", 3400, "햄, 치즈의 조화가 완벽한 시그니처 토스트에요.", "Toast"));
        productList.add(new Product("Grilled Bulgogi", 3500, "불고기 그릴향이 가득 담긴 토스트에요.", "Toast"));
        productList.add(new Product("Bacon Best", 3600, "짭짤 베이컨과 양배추로 조화가 매력적인 토스트에요.", "Toast"));
        productList.add(new Product("Grilled Bulgalbi", 3700, "불갈비 그릴향이 가득 담긴 토스트에요.", "Toast"));
        productList.add(new Product("Deep Cheese Bacon", 3800, "짭짤 베이컨과 딥치즈 소스, 모짜렐라 치즈의 깊은 맛이 인상적이에요.", "Toast"));
        productList.add(new Product("Ham Cheese Potato", 3900, "햄치즈와 해시브라운으로 더 담백하고 든든한 토스트에요.", "Toast"));
        // 세트메뉴 데이터
        productList.add(new Product("Bulgogi Special Set", 5100, "오리지널 불고기의 감칠맛을 가득 담았어요.", "Set"));
        productList.add(new Product("Chicken Special Set", 5200, "달콤한 칠리소스와 풍성한 양배추가 매력적인 통닭다리살 치킨 토스트에요.", "Set"));
        productList.add(new Product("Hot Bacon Chicken Set", 5300, "강렬한 핫칠리 소스의 맛이 매력적인 통닭다리살 치킨 토스트에요.", "Set"));
        productList.add(new Product("Ham Cheese Set", 5400, "햄, 치즈의 조화가 완벽한 시그니처 토스트에요.", "Set"));
        productList.add(new Product("Grilled Bulgogi Set", 5500, "불고기 그릴향이 가득 담긴 토스트에요.", "Set"));
        productList.add(new Product("Bacon Best Set", 5600, "짭짤 베이컨과 양배추로 조화가 매력적인 토스트에요.", "Set"));
        productList.add(new Product("Grilled Bulgalbi Set", 5700, "불갈비 그릴향이 가득 담긴 토스트에요.", "Set"));
        productList.add(new Product("Deep Cheese Bacon Set", 5800, "짭짤 베이컨과 딥치즈 소스, 모짜렐라 치즈의 깊은 맛이 인상적이에요.", "Set"));
        productList.add(new Product("Ham Cheese Potato Set", 5900, "햄치즈와 해시브라운으로 더 담백하고 든든한 토스트에요.", "Set"));
        // 사이드메뉴 데이터
        productList.add(new Product("Potato Pop", 1500, "바삭 고소한 맛 감자에요.", "SideMenu"));
        // 음료 데이터
        productList.add(new Product("Coke", 1000, "청량한 탄산, 콜라", "Beverage"));
        productList.add(new Product("Zero Coke", 1000, "청량한 탄산, 제로 콜라", "Beverage"));
        productList.add(new Product("Cider", 1000, "청량한 탄산, 사이다", "Beverage"));
        productList.add(new Product("Zero Cider", 1000, "청량한 탄산, 제로 사이다", "Beverage"));
        productList.add(new Product("Iced Tea", 1000, "복숭아향 가득 담은 시원달콤, 아이스티", "Beverage"));
        productList.add(new Product("Americano", 1000, "아라비카 원두의 깊은 풍미와 크레마가 매력적인, 아메리카노", "Beverage"));
    }
}
