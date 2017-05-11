<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="cart">
    <div class="container">
        <div class="col-md-12 headlines">
            <h2>CA<span class="color-bg">RT</span></h2>
        </div>

        <div class="col-md-12">
            <table class="table table-bordered table-striped table-advance table-hover">
                <tbody>
                <tr>
                    <th>PRODUCT NAME</th>
                    <th>PRODUCT MODEL</th>
                    <th>SIZE</th>
                    <th>QUANTITY</th>
                    <th>SUBTOTAL</th>
                    <th>REMOVE</th>
                </tr>
                <c:forEach var="product" items="${products}">
                <tr>
                    <td>
                        <div class="media">
                            <div class="media-left">
                                <a href="/product/${product.productId}">
                                    <img class="media-object" src="${product.mainImage}" alt="">
                                </a>
                            </div>
                            <div class="media-body">
                                <a href="/product/${product.productId}" class="media-heading">${product.name}</a>
                            </div>
                        </div>
                    </td>
                    <td>${product.model}</td>
                    <td id="sizep{product.productId}" data-sizep="${product.size}">
                        ${product.size}
                    </td>
                    <td>
                        <form class="f1">
                            <input id="${product.productId}" data-price="${product.price}" data-size="${product.size}" class="sub" type="button" name="subtract" value="-">
                            <input id="qty${product.productId}${product.size}" class="qty" type="text" name="qty" value="${product.count}">
                            <input id="${product.productId}" data-price="${product.price}" data-size="${product.size}" class="add" type="button" name="add" value="+">
                        </form>
                    </td>
                    <td id="subtotal${product.productId}${product.size}">
                        $${product.price * product.count}
                    </td>
                    <td>
                        <button class="removeItem" data-size="${product.size}"  type="button" value="${product.productId}"><i data-size="${product.size}" class="fa fa-times fa-lg"></i></button>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <sec:authorize access="isAuthenticated()">
            <a id="orderBtn" href="/order" class="welcome-button-2 hvr-shutter-in-horizontal-2">PROCEED</a>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <a href="#" disabled="true" class="welcome-button-2 hvr-shutter-in-horizontal-2 not-active">PROCEED</a>
                <p>Please login to proceed</p>
            </sec:authorize>
        </div>
    </div>
</div>