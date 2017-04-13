<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div id="wrapper">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>OR<span class="color-bg">DER</span></h2>
            </div>

            <div id="checkout-order-form">

                <h2 id="details" >Your Details</h2>
                <div id="wrapper">
                </div>
                <fieldset id="fieldset-billing">
                    <legend>Shipping</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Country</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="country" required="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">City</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="city">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Street</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="street">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Building</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="building">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Apartment</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="apartment">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">ZIP-CODE</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="zipCode">
                        </div>
                    </div>

                    <div id="paymentType" class="form-group">
                        <label class="col-sm-2 control-label">PaymentType</label>
                        <div id="sel-div" class="col-sm-10">
                            <select id="paymentTypeSelect" class="form-control m-bot15">
                                <c:forEach var="type" items="${paymentTypes}">
                                    <option data-payment-type=${type} >${type}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
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
                </fieldset>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <button id="submit-order" class="btn btn-primary">Submit</button>
                    </div>
                </div>

            </div>
            <a id="cart1" href="#" title="Shopping Cart"><span class="icon-cart"></span></a>
        </div>
        </div>
        <script type="text/javascript" src="resources/order.js"></script>
    </jsp:body>
</t:genericpage>
