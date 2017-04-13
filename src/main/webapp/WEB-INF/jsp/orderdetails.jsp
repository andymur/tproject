<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                    </div>

                    <div class="col-md-12">
                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>ORDER ID</th>
                                <th>ORDER DATE</th>
                                <th>USER NICKNAME</th>
                                <th>USER PHONE</th>
                                <th>DELIVERY ADDRESS</th>
                                <th>PRODUCTS</th>
                            </tr>
                                <tr>
                                    <td>
                                        ${order.orderId}
                                    </td>
                                    <td>
                                        ${order.orderDate}
                                    </td>
                                    <td>
                                        ${order.firstName}
                                    </td>
                                    <td>
                                        ${order.phoneNumber}
                                    </td>
                                    <td>
                                        ${order.deliveryAddressDto}
                                    </td>
                                    <td>
                                        ${order.products}
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>