<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="shop">
    <div class="container">
        <div class="col-md-12 welcome-msg">
            <h2><span class="color"></br></span></h2>
            <p></br></p></br>
            <a href="#" class="welcome-button"></br></a>
        </div>
    </div>
</div>
<div class="arrivals">
    <div class="container">
        <div class="new">
            <div class="col-md-12">
                <h2>Our Latest <span class="color">Products</span></h2>
                <p>You will fall in love with our new products.</p>
            </div>
            <div class="shop-products">
                <div class="col-md-3 sidebar">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
							<button class="btn btn-default" type="button">Search</button>
						</span>
                    </div><!-- /input-group -->
                    <div class="sidebar-block top-10">
                        <h3>CATEGORIES</h3>
                        <ul class="categories">
                            <c:forEach var="mapitem" items="${categoriesmap}">
                                <li>
                                    <a class="catalogPage" href="catalog?categoryId=${mapitem.key.id}">${mapitem.key.name}<kbd>${mapitem.value}></kbd></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="sidebar-block">
                        <h3>TAGS</h3>
                        <ul class="tags">
                            <li><a href="#">Classic</a></li>
                            <li><a href="#">Modern</a></li>
                            <li><a href="#">Speed</a></li>
                            <li><a href="#">New</a></li>
                            <li><a href="#">Best seller</a></li>
                        </ul>
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
                            <c:forEach var="product" items="${products}" varStatus="loopCounter" begin="${pageStart}"
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
                                                                value="${product.productId}">Large View
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
                                                class="pull-right text">$ ${product.price}</span></div>
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
<script type="text/javascript" src="resources/js/cbp-10.js"></script>
<script type="text/javascript" src="resources/cart.js"></script>
