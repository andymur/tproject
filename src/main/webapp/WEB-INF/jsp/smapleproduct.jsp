<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-md-9">
    <div id="grid-container-10" class="cbp-l-grid-projects cbp cbp-chrome cbp-caption-overlayBottomReveal cbp-animation-flipOut cbp-ready" style="height: 1896px;">
        <ul class="cbp-wrapper" style="opacity: 1;">
            <c:forEach var="product" items="${products}">
            <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(0px, 1422px, 0px);"><div class="cbp-item-wrapper">
                <div class="cbp-caption">
                    <div class="cbp-caption-defaultWrap">
                        <img src="resources/images${product.images}" alt="">
                    </div>

                    <div class="cbp-caption-activeWrap">
                        <div class="cbp-l-caption-alignCenter">
                            <div class="cbp-l-caption-body">
                                <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                <a href="#" class="cbp-l-caption-buttonRight">Add To Cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="cbp-l-grid-projects-title">${product.name}<span class="pull-right text">$${product.price}</span></div>
                <div class="cbp-l-grid-projects-desc">${product.brand} / ${product.model}</div>
            </div></li>
            </c:forEach>
         </ul>
    </div>
</div>


</div>