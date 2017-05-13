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
            <div class="shop-single">
                <div class="container">
                    <div class="col-md-12 headlines">
                        <h2>${product.brand} <span class="color-bg">${product.name}</span></h2>
                    </div>

                    <div class="col-md-9">

                        <div class="row custom-cols">
                            <div class="col-md-8">
                                <ul id="gal1">
                                    <c:forEach var="image" items="${product.images}">
                                        <li>
                                            <a class="active" href="#"
                                               data-image="${image.url}"
                                               data-zoom-image="${image.url}">
                                                <img id="img_01" src="${image.url}"
                                                     alt=""/>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <img id="zoom_02" src="${product.mainImage}"
                                     data-zoom-image="${product.mainImage}" alt="" width="400"/>

                            </div>

                            <div class="col-md-4 item-dec">
                                <div class="item-price">$${product.price}</div>
                                <div class="divider-1"></div>
                                <div class="divider-2"></div>
                                <div class="form-group">
                                    <label class="col-sm-2-cust control-label">SIZE</label>
                                    <div class="col-sm-10">
                                        <select id="size${product.id}" class="autowidht m-bot15">
                                            <c:forEach var="size" items="${product.sizes}">
                                                <option data-size="${size}">${size}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="divider-2"></div>
                                <button type="button"
                                        data-id="${product.id}"
                                        value="${product.id}"
                                        class="cbp-l-caption-buttonRight addToCart">
                                    Add To Cart
                                </button>
                                <div class="clearfix"></div>
                                <div class="divider-2"></div>
                                <div class="categories">
                                    <span class="category">CATEGORIES:</span><a href="#">${product.category}</a>
                                </div>
                                <div class="divider-2"></div>

                            </div>

                        </div>

                        <div class="row shop-row-2">
                            <div class="col-md-12">
                                <div role="tabpanel">

                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li role="presentation" class="active"><a href="#description"
                                                                                  aria-controls="description" role="tab"
                                                                                  data-toggle="tab">DESCRIPTION</a></li>
                                        <li role="presentation"><a href="#specifications" aria-controls="specifications"
                                                                   role="tab" data-toggle="tab">SPECIFICATIONS</a></li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="description">
                                            <p>${product.description}</p>
                                        </div>

                                        <div role="tabpanel" class="tab-pane" id="specifications">
                                            <table class="table table-bordered">

                                                <tbody>
                                                <tr>
                                                    <td>BRAND</td>
                                                    <td>${product.brand}</td>
                                                </tr>
                                                <tr>
                                                    <td>PRODUCT MODEL</td>
                                                    <td>${product.model}</td>
                                                </tr>
                                                <tr>
                                                    <td>COLOR</td>
                                                    <td>${product.color}</td>
                                                </tr>
                                                <tr>
                                                    <td>SHIPMENT</td>
                                                    <td>FREE GROUND SHIPPING</td>
                                                </tr>
                                                <tr>
                                                    <td>PARAMETERS</td>
                                                    <td><c:forEach var="parameter" items="${product.parameters}">
                                                        <table id="par${parameter.id}"
                                                               class="table table-bordered table-striped table-advance table-hover">
                                                            <tr>
                                                                <th>Size</th>
                                                                <td><input class="form-control" type="text" name="size"
                                                                           value="${parameter.size}" disabled="disabled">
                                                                </td>
                                                                <th>Weight</th>
                                                                <td><input class="form-control" type="text"
                                                                           name="weight"
                                                                           value="${parameter.weight}" disabled="disabled"></td>
                                                            </tr>
                                                        </table>
                                                    </c:forEach>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-md-3 shop-sidebar">

                        <div class="block">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseOne">
                                                <i class="fa fa-minus-square-o"></i> FREE DELIVERY
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            We are offering free Europe wide delivery.
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseTwo">
                                                <i class="fa fa-plus-square-o"></i> 5 DAYS MONEY BACK
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            We are supporting 5 days mony back.
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseThree">
                                                <i class="fa fa-plus-square-o"></i> SECURE PAYMENTS
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            All card payments going thru PayPal system, which is supporting Visa and MasterCard.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%--<div class="block">--%>
                            <%--<img src="https://res.cloudinary.com/alexpench/image/upload/v1494597095/linus-bike-roadster-sport-lifestyle2-2000x931_awsddn.jpg" alt="" width="250"/>--%>
                        <%--</div>--%>

                    </div>

                </div>
                <div class="container-custom welcome-slider welcome-cust">
                    <div id="w-owl" class="owl-carousel">
                            <div class="col-md-12-cust">
                                <img src="${product.longpic}" alt="" class="longpic";/>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Image Zoom Plugin -->
    </jsp:body>
</t:genericpage>