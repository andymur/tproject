<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="wrapper">
<div class="cart">
    <div class="container">
        <div class="col-md-12 headlines">
            <h2>CA<span class="color-bg">RT</span></h2>
        </div>

        <div class="col-md-12">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th>PRODUCT NAME</th>
                    <th>PRODUCT MODEL</th>
                    <th>QUANTITY</th>
                    <th>SUBTOTAL</th>
                    <th>REMOVE</th>
                </tr>
                <c:forEach var="product" items="${products}">
                <tr>
                    <td>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="/resources/images/shop/${product.icon}" alt="">
                                </a>
                            </div>
                            <div class="media-body">
                                <a href="#" class="media-heading">${product.name}</a>
                                <%--<div class="stars"><a href="#"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star-o"></i></a></div>--%>
                            </div>
                        </div>
                    </td>
                    <td>${product.model}</td>
                    <td>
                        <form class="f1">
                            <input type="text" name="qty" id="qty" value="${product.count}">
                        </form>
                    </td>
                    <td>
                        $${product.price * product.count}
                    </td>
                    <td>
                        <button class="removeItem"  type="button" value="${product.productId}"><i class="fa fa-times fa-lg"></i></button>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>

            <a href="#" class="welcome-button-2 hvr-shutter-in-horizontal-2">PROCEED</a>

        </div>
    </div>
</div>
</div>