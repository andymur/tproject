package tapplication.controllers.dto;

import tapplication.model.Order;

import java.util.List;

/**
 * Created by alexpench on 07.04.17.
 */
public class OrderDto {
    private List<BasketProductDto> basketProductsDtoList;
    private Long deliveryAddressId;
    private Order.DeliveryTypeCode deliveryType;
    private Order.PaymentTypeCode paymentType;
    private Long customerId;
    private Long orderId;

    public OrderDto setNewOrderDetails(Order newOrder) {
        OrderDto newOrderDto = new OrderDto();
        newOrderDto.setOrderId(newOrder.getId());
        newOrderDto.setCustomerId(newOrder.getCustomer().getId());
        return newOrderDto;
    }

    public OrderDto(){}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<BasketProductDto> getBasketProductsDtoList() {
        return basketProductsDtoList;
    }

    public void setBasketProductsDtoList(List<BasketProductDto> basketProductsDtoList) {
        this.basketProductsDtoList = basketProductsDtoList;
    }

    public Long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(Long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public Order.DeliveryTypeCode getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Order.DeliveryTypeCode deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Order.PaymentTypeCode getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Order.PaymentTypeCode paymentType) {
        this.paymentType = paymentType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


}
