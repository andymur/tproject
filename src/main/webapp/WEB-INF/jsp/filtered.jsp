<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="wrapper">
    <div class="arrivals">
        <div class="container">
            <div class="new">
                <div class="col-md-12">
                    <h2>The<span class="color">${category.name}</span></h2>
                </div>
                <div class="shop-products">
                    <div class="arrivals">
                        <div class="container">
                            <div class="new">
                                <div class="col-md-12">
                                    <h2>Our Latest <span class="color">Products</span></h2>
                                    <p>You will fall in love with our new products.</p>
                                </div>
                                <div class="shop-products">
                                    <div class="col-md-3 sidebar">
                                        <div id="cat-filter" data-category-id="${category.categoryId}"
                                             class="sidebar-block top-10">
                                            <h3>FILTER</h3>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Brand</label>
                                                <div class="col-sm-10">
                                                    <select id="br-select" class="form-control m-bot15">
                                                        <c:choose>
                                                            <c:when test="${(brand == 'undefined') or (brand == null)}">
                                                            <option selected disabled>Choose here</option>
                                                                <c:forEach var="brand" items="${brands}">
                                                                    <option>${brand}</option>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <option selected>${brand}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Size</label>
                                                <div class="col-sm-10">
                                                    <select id="size-select" class="form-control m-bot15">
                                                        <c:choose>
                                                            <c:when test="${(size == 'undefined') or (size == null)}">
                                                                <option selected disabled>Choose here</option>
                                                                <c:forEach var="size" items="${sizes}">
                                                                    <option>${size}</option>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option selected>${size}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Color</label>
                                                <div class="col-sm-10">
                                                    <select id="color-select" class="form-control m-bot15">
                                                        <c:choose>
                                                            <c:when test="${(color == 'undefined') or (color == null)}">
                                                                <option selected disabled>Choose here</option>
                                                                <c:forEach var="color" items="${colors}">
                                                                    <option>${color}</option>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option selected>${color}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <a type="button" href="catalog?categoryId=${category.categoryId}"
                                               class="welcome-button-2 hvr-shutter-in-horizontal-2">CLEAR FILTERS</a>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div id="pr-div" class="col-md-9">
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
                                                                    <img src="/resources/images/shop/${product.mainImage}">
                                                                </div>

                                                                <div class="cbp-caption-activeWrap">
                                                                    <div class="cbp-l-caption-alignCenter">
                                                                        <div class="cbp-l-caption-body">
                                                                            <button type="button"
                                                                                    class="cbp-l-caption-buttonLeft productButton"
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

                                        <div class="text-center">
                                            <ul class="pagination">
                                                <li><a href="?start=${pageStart - perPage}">«</a></li>
                                                <li><a href="#">${pageStart + 1}</a></li>
                                                <li><a href="#">-</a></li>
                                                <li><a href="#">${pageStart + perPage}</a></li>
                                                <li><a href="?start=${pageStart + perPage}">»</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/cbp-10.js"></script>