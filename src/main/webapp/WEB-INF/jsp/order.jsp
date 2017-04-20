<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="wrapper">
    <div class="checkout">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>CHECK<span class="color-bg">OUT</span></h2>
            </div>
            <div id="form-deliveryTypes" class="form-horizontal">
                <div id="deliveryType" class="form-group">
                    <label class="col-sm-2 control-label">DeliveryType</label>
                    <div id="sel-div" class="col-sm-10">
                        <select id="deliveryTypeSelect" class="form-control m-bot15">
                            <c:forEach var="type" items="${deliveryTypes}">
                                <option data-delivery-type=${type}>${type}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div id="deliveryForm"></div>

            <div class="col-md-12 order">
                <div class="heading">Your Order</div>

                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <th>PRODUCT</th>
                        <th>TOTAL</th>
                    </tr>
                    <tr id="orderedProducts" class="tr-1">
                        <c:forEach var="product" items="${products}">
                        <td>${product.name} | ${product.model}</td>
                        <td>$${product.price}</td>
                    </tr>
                    <tr>
                        <td>PRODUCT AMOUNT</td>
                        <td>${product.count}</td>
                    </tr>
                    <tr>
                        <td>SUBTOTAL</td>
                        <td>$${product.price * product.count}</td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td>TOTAL</td>
                        <c:set var="total" value="${0}"/>
                        <c:forEach var="product" items="${products}">
                            <c:set var="total" value="${total + (product.price * product.count)}" />
                        </c:forEach>
                        <td>$${total}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-md-12 payment">
                <div class="heading">Payment Method</div>
                <div class="form-group">

                    <div class="radio-block">
                        <label class="radio-inline">
                            <input type="radio" class="pickup" name="payment" value="CASH"> <strong>CASH TO
                            COURIER</strong>
                        </label>
                        <div class="collapse pickup">
                            <p>This option is available for citizen of our store location.</p>
                        </div>
                    </div>

                    <div class="radio-block">
                        <label class="radio-inline">
                            <input type="radio" class="fax" name="payment" value="CARD"> <strong>PAYPAL</strong><img
                                class="paypal" src="/resources/images/paypal.png" alt=""/>
                        </label>
                        <div class="collapse fax">
                            <p>You can pay by PAYPAL with VISA or MASTERCARD</p>
                        </div>
                    </div>

                </div>

                <a id="submit-order" href="#" class="welcome-button-2 hvr-shutter-in-horizontal-2">PROCEED</a>
            </div>

        </div>
    </div>
</div>