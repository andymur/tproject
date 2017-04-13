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
    private BasketDto basketDto;
    private DeliveryAddressDto deliveryAddressDto;
    private DeliveryTypeCode deliveryType;
    private PaymentTypeCode paymentType;
    private Long userId;
    private Long orderId;
    private OrderStatusCode orderStatusCode;
    private PaymentStatusCode paymentStatusCode;
    private Date orderDate;
    private String email;
    private String firstName;
    private String phoneNumber;
    private List<ProductDto> products;


    public OrderDto setNewOrderDetails(Order newOrder) {
        OrderDto newOrderDto = new OrderDto();
        newOrderDto.setOrderId(newOrder.getId());
        return newOrderDto;
    }

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

    public OrderDto prepareForAdmin(Order order) {
        OrderDto newOrderDto = new OrderDto();
        newOrderDto.setOrderId(order.getId());
        newOrderDto.setOrderDate(order.getOrderDate());
        newOrderDto.setFirstName(order.getUser().getName());
        newOrderDto.setEmail(order.getUser().getEmail());
        newOrderDto.setPhoneNumber(order.getUser().getPhoneNumber());
        newOrderDto.setDeliveryAddressDto(new DeliveryAddressDto(order.getAddress()));
        newOrderDto.setProducts(order.getOrderedProducts().stream().map(pr->new ProductDto(pr.getProduct())).collect(Collectors.toList()));
        return newOrderDto;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
