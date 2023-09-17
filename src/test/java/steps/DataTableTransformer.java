package steps;

import io.cucumber.java.DataTableType;
import models.Claim;
import models.Order;

import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public Order dataEntry(Map<String,String> entry){
        int orderId = Integer.valueOf(entry.get("orderID"));
        String product = entry.get("product");
        int quantity = Integer.valueOf(entry.get("quantity"));
        return new Order(orderId, product, quantity);
    }

    @DataTableType
    public Claim dataEntry2(Map<String,String> entry){
        // claimID   | amount   | date     | description     | supportingDocuments
        String claimID = entry.get("claimID");
        double amount = Double.valueOf(entry.get("amount"));
        String date = entry.get("date");
        String description = entry.get("description");
        String supportingDocuments = entry.get("supportingDocuments");
        return new Claim(claimID, amount, date, description, supportingDocuments);
    }
}
