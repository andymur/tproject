<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="wrapper">
    <div class="container">
            <div class="col-md-12 headlines">
                <h2>CHECK<span class="color-bg">OUT</span></h2>
            </div>

        <div id="checkout-order-form">

            <fieldset id="fieldset-billing">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Card number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="number">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Full name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">CVV</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="cvv">
                    </div>
                </div>
            </fieldset>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button id="pay" class="btn btn-primary" value="{order.orderId}">Submit</button>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript" src="resources/order.js"></script>
