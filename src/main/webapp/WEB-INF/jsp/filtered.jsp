<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="grid-container-10"
     class="cbp-l-grid-projects cbp cbp-chrome cbp-caption-overlayBottomReveal cbp-animation-flipOut cbp-ready"
     style="height: 1896px;">
    <ul class="cbp-wrapper" style="opacity: 1;">
        <c:set var="products" scope="session" value="${products}"/>
        <c:set var="totalCount" scope="session" value="${fn:length(products)}"/>
        <c:set var="perPage" scope="session" value="${5}"/>
        <c:set var="pageStart" value="${param.start}"/>
        <c:if test="${empty pageStart or pageStart < 0}">
            <c:set var="pageStart" value="0"/>
        </c:if>
        <c:if test="${totalCount < pageStart}">
            <c:set var="pageStart" value="${pageStart - perPage}"/>
        </c:if>
        <c:forEach var="product" items="${products}"
                   varStatus="loopCounter" begin="${pageStart}"
                   end="${pageStart + perPage - 1}">
            <li class="cbp-item graphic ">
                <div class="cbp-item-wrapper">
                    <div class="cbp-caption">
                        <div class="cbp-caption-defaultWrap">
                            <img src="resources/images/shop${product.mainImage}">
                        </div>

                        <div class="cbp-caption-activeWrap">
                            <div class="cbp-l-caption-alignCenter">
                                <div class="cbp-l-caption-body">
                                    <button type="button"
                                            class="cbp-l-caption-buttonLeft"
                                            value="${product.productId}">
                                        Large View
                                    </button>
                                    <button type="button"
                                            data-productId="${product.productId}"
                                            value="${product.productId}"
                                            class="cbp-l-caption-buttonRight addToCart">
                                        Add To Cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-productId="${product.productId}"
                         class="cbp-l-grid-projects-title">${product.name}<span
                            class="pull-right text">$${product.price}</span>
                    </div>
                    <div class="cbp-l-grid-projects-desc">${product.brand}
                        / ${product.model}</div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<script type="text/javascript" src="resources/js/cbp-10.js"></script>