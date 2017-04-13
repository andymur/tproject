<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="wrapper">
    <div class="cart">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>CHECK<span class="color-bg">OUT</span></h2>
                <h2>OrderId : ${order.orderId}</h2>
            </div>

            <div class="col-md-12">
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
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">CVV</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="cvv">
                    </div>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button id="submit-order" class="btn btn-primary" value="${order.orderId}">Submit</button>
                        </div>
                    </div>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a href="#" disabled="true" class="welcome-button-2 hvr-shutter-in-horizontal-2 not-active">PROCEED</a>
                    <p>Please login to proceed</p>
                </sec:authorize>
            </div>
        </div>
    </div>
</div>