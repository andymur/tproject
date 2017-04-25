<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="wrapper">
    <div class="container">
        <div class="col-md-12 headlines">
            <h2>ADDRESSES</h2>
        </div>
    </div>
    <div class="panel-group" id="accordion">
        <c:forEach var="address" items="${addresses}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                           href="#${address.id}">
                            <i class="fa fa-plus-square-o"></i>|${address.country}|${address.city}|${address.street}
                        </a>
                    </h4>
                </div>
                <div id="${address.id}" class="panel-collapse collapse">
                    <div class="panel-body">
                        <div class="col-md-6">
                            <div id="addressForm">
                                <label>Country</label>
                                <input type="text" class="form-control" name="country" value="${address.country}">
                                <label>Street</label>
                                <input type="text" class="form-control" name="street" value="${address.street}">
                                <label>Building</label>
                                <input type="text" class="form-control" name="building" value="${address.building}">
                                <label>Appartment</label>
                                <input type="text" class="form-control" name="appartment"
                                       value="${address.appartment}">
                                <label>Town/City</label>
                                <input type="text" class="form-control" name="city" value="${address.city}">
                                <label>Zip Code</label>
                                <input type="text" class="form-control" name="zipCode" value="${address.zipCode}">
                                <label>Email Address</label>
                                <input type="text" class="form-control" name="email" value="${address.email}">
                                <label>Phone Nmber</label>
                                <input type="text" class="form-control" name="phonenumber"
                                       value="${address.phoneNumber}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                       href="#newAddress">
                        <i class="fa fa-plus-square-o"></i>|Add new
                    </a>
                </h4>
            </div>
            <div id="newAddress" class="panel-collapse collapse">
                <div class="panel-body">
                    <div class="col-md-6">
                        <div id="newAddressForm">
                            <label>Country</label>
                            <input type="text" class="form-control" name="country" placeholder="Enter your country">
                            <label>Street</label>
                            <input type="text" class="form-control" name="street" placeholder="Enter your street">
                            <label>Building</label>
                            <input type="text" class="form-control" name="building" placeholder="Enter your building">
                            <label>Appartment</label>
                            <input type="text" class="form-control" name="appartment"
                                   placeholder="Enter your appartment">
                            <label>Town/City</label>
                            <input type="text" class="form-control" name="city" placeholder="Enter your town/city name">
                            <label>Zip Code</label>
                            <input type="text" class="form-control" name="zipCode" placeholder="Enter your zipcode">
                            <label>Email Address</label>
                            <input type="text" class="form-control" name="email"
                                   placeholder="Enter your  email address">
                            <label>Phone Nmber</label>
                            <input type="text" class="form-control" name="phonenumber"
                                   placeholder="Enter your phone number">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button id="btn-save-address" class="btn btn-primary">Save</button>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/address.js"></script>