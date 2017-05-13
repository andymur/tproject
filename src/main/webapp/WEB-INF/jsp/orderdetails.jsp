<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div id="wrapper">
            <div class="cart">
                <div class="container">
                    <div class="col-md-12 headlines">
                        <h2>ORDER<span class="color-bg">DETAILS</span></h2>
                        <h1>ORDER ID <span class="color-bg">${order.orderId}</span></h1>
                    </div>
                    <div class="col-md-12">

                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>ORDER DATE</th>
                                <th>DELIVERY ADDRESS</th>
                                <th>ORDER STATUS</th>
                            </tr>
                            <tr>

                                <td>
                                        ${order.orderDate}
                                </td>

                                <td>
                                        ${order.deliveryAddressDto.zipCode}|${order.deliveryAddressDto.country}|${order.deliveryAddressDto.city}|${order.deliveryAddressDto.street}|${order.deliveryAddressDto.building}|${order.deliveryAddressDto.appartment}|${order.deliveryAddressDto.email}|${order.deliveryAddressDto.phoneNumber}
                                </td>

                                <td>
                                    <div id="orderStatus" class="form-group">
                                        <div id="sel-div" class="col-sm-10">
                                            <select id="orderStatusSelect" class="autowidht m-bot15">
                                                <option data-order-status=${order.orderStatusCode} selected>${order.orderStatusCode}</option>
                                                <sec:authorize access="hasRole('ADMIN')">
                                                    <c:forEach var="status" items="${orderStatuses}">
                                                        <c:if test="${status != order.orderStatusCode}">
                                                            <option data-order-status=${status}>${status}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </sec:authorize>
                                            </select>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            </tbody>
                        </table>


                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>PRODUCT NAME</th>
                                <th>PRODUCT MODEL</th>
                                <th>SIZE</th>
                                <th>QUANTITY</th>
                                <th>SUBTOTAL</th>
                            </tr>
                            <c:forEach var="product" items="${order.products}">
                                <tr>
                                    <td>
                                        <div class="media">
                                            <div class="media-left">
                                                <a href="/product/${product.id}">
                                                    <img class="media-object" src="${product.mainImage}" alt="">
                                                </a>
                                            </div>
                                            <div class="media-body">
                                                <a href="/product/${product.id}"
                                                   class="media-heading">${product.name}</a>
                                            </div>
                                        </div>
                                    </td>

                                    <td>
                                            ${product.model}
                                    </td>

                                    <td>
                                            ${product.size}
                                    </td>

                                    <td>
                                            ${product.count}
                                    </td>

                                    <td>
                                        $${product.price * product.count}
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                        <sec:authorize access="hasRole('ADMIN')">
                            <button class="saveOrderStatus welcome-button-2 hvr-shutter-in-horizontal-2"
                                    value="${order.orderId}" type="button">Save
                            </button>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ADMIN', 'USER')">
                            <button class="repeatOrder welcome-button-2 hvr-shutter-in-horizontal-2"
                                    value="${order.orderId}" type="button">Repeat
                            </button>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="resources/orders.js"></script>
    </jsp:body>
</t:genericpage>