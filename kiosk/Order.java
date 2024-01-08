package kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Product, Integer> orderMap =  new HashMap<>();
    private final Map<Product, Integer> orderedMap = new HashMap<>();

    public void addProduct(Product product, Integer quantity){
        if(orderMap.containsKey(product)) orderMap.put(product, orderMap.get(product) + quantity);
        else orderMap.put(product, quantity);
    }

    public void addOrderedProduct() {
        for (Map.Entry<Product, Integer> entry : orderMap.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (orderedMap.containsKey(product)) {
                // 이미 있는 경우, quantity를 증가
                orderedMap.put(product, orderedMap.get(product) + quantity);
            } else {
                // 없는 경우, 새로운 값 추가
                orderedMap.put(product, quantity);
            }
        }
    }

    public void removeProduct(Product product){
        orderMap.remove(product);
    }
    public List<Product> getOrderList(Map<Product, Integer> map){
        return new ArrayList<>(map.keySet());
    }
    public Integer getQuantity(Map<Product, Integer> map, Product product){
        return map.get(product);
    }
    public void clearProduct(){
        orderMap.clear();
    }
    public int calculateTotalPrice(Map<Product, Integer> map) {
        int totalPrice = 0;

        for (Product product : map.keySet()) {
            int quantity = map.get(product);
            totalPrice += product.getPrice() * quantity;
        }

        return totalPrice;
    }
    public Map<Product, Integer> getOrderMap(){
        return orderMap;
    }
    public Map<Product, Integer> getOrderedMap(){
        return orderedMap;
    }
}
