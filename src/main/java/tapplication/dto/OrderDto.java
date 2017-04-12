package tapplication.dto;

import tapplication.model.Order;
import tapplication.service.DeliveryTypeCode;
import tapplication.service.PaymentTypeCode;

/**
 * Created by alexpench on 07.04.17.
 */
public class OrderDto {
    private BasketDto basketDto;
    private DeliveryAddressDto deliveryAddressDto;
    private DeliveryTypeCode deliveryType;
    private PaymentTypeCode paymentType;
    private Long userId;
    private Long orderId;

    public OrderDto setNewOrderDetails(Order newOrder) {
        OrderDto newOrderDto = new OrderDto();
        newOrderDto.setOrderId(newOrder.getId());
        newOrderDto.setUserId(newOrder.getUser().getId());
        return newOrderDto;
    }

    public OrderDto(){}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BasketDto getBasketDto() {
        return basketDto;
    }

    public void setBasketDto(BasketDto basketDto) {
        this.basketDto = basketDto;
    }

    public DeliveryAddressDto getDeliveryAddressDto() {
        return deliveryAddressDto;
    }

    public void setDeliveryAddressDto(DeliveryAddressDto deliveryAddressDto) {
        this.deliveryAddressDto = deliveryAddressDto;
    }

    public DeliveryTypeCode getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeCode deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PaymentTypeCode getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeCode paymentType) {
        this.paymentType = paymentType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
