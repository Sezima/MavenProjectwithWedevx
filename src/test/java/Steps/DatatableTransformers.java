package Steps;

import io.cucumber.java.DataTableType;
import models.Order;

import java.util.Map;

public class DatatableTransformers {
//        why we use Map 'cause cucumber will be converting each row into a map
    @DataTableType
    public Order dataEntry(Map<String,String> entry){

        int orderId = Integer.valueOf(entry.get("orderID"));
        String product = entry.get("product");
        int quantity = Integer.valueOf(entry.get("quantity"));
        return new Order(orderId, product, quantity);
    }

}
