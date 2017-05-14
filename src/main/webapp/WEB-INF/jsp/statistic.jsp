<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <div class="numbers">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>STAT <span class="color">ISTIC</span></h2>
                </div>
            </div>
            <div class="row number-row">
                <div class="col-md-6">
                    <div class="number-box">
                        <h3><span class="counter">${monthRevenue}</span></h3>
                    </div>
                    <div class="heading">MONTH REVENUE</div>
                    <p>Current month revenue.</p>
                </div>
                <div class="col-md-6">
                    <div class="number-box">
                        <h3><span class="counter">${weekRevenue}</span></h3>
                    </div>
                    <div class="heading">WEEK REVENUE</div>
                    <p>Current week revenue.</p>
                </div>
                <div class="col-md-12">
                    <div class="heading">TOP 10 PRODUCTS</div>
                    <table class="table table-bordered table-striped table-advance table-hover">
                        <tbody>
                        <tr>
                            <th>PRODUCT NAME</th>
                            <th>PRODUCT MODEL</th>
                            <th>SOLD COUNT</th>
                        </tr>
                        <c:forEach var="product" items="${topProducts}">
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
                                        ${product.count}
                                </td>

                            </tr>

                        </c:forEach>

                        </tbody>
                    </table>

                </div>
                <div class="col-md-12">
                    <div class="heading">TOP 10 USERS</div>
                    <table class="table table-bordered table-striped table-advance table-hover">
                        <tbody>
                        <tr>
                            <th>USER NAME</th>
                            <th>EMAIL</th>
                            <th>PHONE NUMBER</th>
                            <th>BIRTH DAY</th>
                            <th>TOTAL ORDERS</th>
                        </tr>
                        <c:forEach var="user" items="${topUsers}">
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="media-left">
                                                    ${user.name}
                                        </div>
                                        <div class="media-body">
                                                ${user.lastName}
                                        </div>
                                    </div>
                                </td>

                                <td>
                                        ${user.email}
                                </td>
                                <td>
                                        ${user.phoneNumber}
                                </td>
                                <td>
                                        ${user.birthDate}
                                </td>

                                <td>
                                        ${user.countOfOrders}
                                </td>

                            </tr>

                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>