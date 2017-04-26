package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by alexpench on 18.04.17.
 */
@Component
public class OrderStatusJob {
    @Autowired
    private OrderService orderService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 60000)
    public void updateOrderStatus() {
        orderService.updateExpiredOrders();
    }
}