package de.bcxp.school.devops.troubleshooting.presents;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDatabase {

    private List<OrderData> orderDataList;

    public OrderDatabase() {
        this.orderDataList = new ArrayList<>();
    }

    public void addOrderData(OrderData orderData) {
        orderDataList.add(orderData);
    }

    public List<OrderData> getAllOrderData() {
        return orderDataList;
    }
}
