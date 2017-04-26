<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<select id="deliveryAddressSelect" class="autowidht m-bot15">
    <c:forEach var="address" items="${addresses}">
        <option data-id=${address.id}>${address.zipCode}|${address.country}|${address.city}|${address.street}|${address.building}|${address.appartment}|${address.email}|${address.phoneNumber}</option>
    </c:forEach>
    <option id="otherAddress" data-delivery-address-id=${address.id}>Other address</option>
</select>