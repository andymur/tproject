package tapplication.dto;

import tapplication.model.Order;
import tapplication.service.DeliveryTypeCode;
import tapplication.service.OrderStatusCode;
import tapplication.service.PaymentStatusCode;
import tapplication.service.PaymentTypeCode;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 07.04.17.
 */
public class OrderDto {
    private List<ProductAndAmount> productAndAmounts;
    private AddressDto deliveryAddressDto;
    private DeliveryTypeCode deliveryType;
    private PaymentTypeCode paymentType;
    private Long userId;
    private Long orderId;
    private OrderStatusCode orderStatusCode;
    private PaymentStatusCode paymentStatusCode;
    private Date orderDate;
    private List<ProductDto> products;

    public OrderDto prepareForUser(Order newOrder) {
        OrderDto newOrderDto = new OrderDto();
        newOrderDto.setOrderId(newOrder.getId());
        newOrderDto.setDeliveryType(newOrder.getDeliveryType());
        newOrderDto.setOrderDate(newOrder.getOrderDate());
        newOrderDto.setOrderStatusCode(newOrder.getOrderStatus());
        newOrderDto.setPaymentStatusCode(newOrder.getPaymentStatus());
        newOrderDto.setPaymentType(newOrder.getPaymentType());
        return newOrderDto;
    }

    public OrderDto (Order order) {
        this.orderId = order.getId();
        this.orderDate = order.getOrderDate();
        this.deliveryAddressDto = new AddressDto(order.getAddress());
        this.products = order.getOrderedProducts().stream().map(ProductDto::new).collect(Collectors.toList());
        this.orderStatusCode = order.getOrderStatus();
    }

    public OrderDto(){}

    public OrderStatusCode getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(OrderStatusCode orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public PaymentStatusCode getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(PaymentStatusCode paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<ProductAndAmount> getProductAndAmounts() {
        return productAndAmounts;
    }

    public void setProductAndAmounts(List<ProductAndAmount> productAndAmounts) {
        this.productAndAmounts = productAndAmounts;
    }

    public AddressDto getDeliveryAddressDto() {
        return deliveryAddressDto;
    }

    public void setDeliveryAddressDto(AddressDto deliveryAddressDto) {
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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
