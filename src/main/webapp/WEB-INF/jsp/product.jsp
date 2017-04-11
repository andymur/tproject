<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="arrivals">
            <div class="container">
                <div class="clearfix"></div>
                <div class="new">
                    <div class="col-md-12">
                        <h2>The<span class="color">Bicycle</span></h2>
                    </div>
                    <div class="clearfix"></div>
                    <div class="shop-products">
                        <div class="col-md-3 sidebar">
                            <div class="sidebar-block top-10">
                                <h3>FILTER</h3>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Brand</label>
                                    <div class="col-sm-10">
                                        <select id="br-select" class="form-control m-bot15">
                                            <c:forEach var="brand" items="${brands}">
                                                <option data-brand-id=${brand.id} data-brand-name=${brand.name} data-brand-image=${brand.brandImage}>${brand.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Size</label>
                                    <div class="col-sm-10">
                                        <select id="size-select" class="form-control m-bot15">
                                            <c:forEach var="size" items="${Size}">
                                                <option data-size-id=${size.id} data-size-name=${size.name}>${size.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-md-9">
                            <div id="grid-container-10" class="cbp-l-grid-projects cbp cbp-chrome cbp-caption-overlayBottomReveal cbp-animation-flipOut cbp-ready" style="height: 1896px;">
                                <ul class="cbp-wrapper" style="opacity: 1;">
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(0px, 0px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/1.jpg" alt="">
                                            </div>
                                            <div class="labels">
                                                <div class="ribbon-wrapper-orange">
                                                    <div class="ribbon-orange">50% OFF</div>
                                                </div>
                                            </div>

                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$123.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(427px, 0px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/resources/images/shop/2.jpg" alt="">
                                            </div>
                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class="cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$60.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(0px, 474px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/resources/images/shop/3.jpg" alt="">
                                            </div>

                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class="cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$45.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(427px, 474px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/4.jpg" alt="">
                                            </div>
                                            <div class="labels">
                                                <div class="ribbon-wrapper-orange">
                                                    <div class="ribbon-orange">NEW</div>
                                                </div>
                                            </div>
                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class="cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class=" cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$80.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(0px, 948px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/5.jpg" alt="">
                                            </div>
                                            <div class="labels">
                                                <div class="ribbon-wrapper-orange">
                                                    <div class="ribbon-orange">HOT</div>
                                                </div>
                                            </div>
                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$170.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(427px, 948px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/6.jpg" alt="">
                                            </div>
                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$300.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(0px, 1422px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/7.jpg" alt="">
                                            </div>

                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class="cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$65.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                    <li class="cbp-item graphic" style="width: 397px; height: 474px; transform: translate3d(427px, 1422px, 0px);"><div class="cbp-item-wrapper">
                                        <div class="cbp-caption">
                                            <div class="cbp-caption-defaultWrap">
                                                <img src="resources/images/shop/1.jpg" alt="">
                                            </div>
                                            <div class="labels">
                                                <div class="ribbon-wrapper-orange">
                                                    <div class="ribbon-orange">70% OFF</div>
                                                </div>
                                            </div>
                                            <div class="cbp-caption-activeWrap">
                                                <div class="cbp-l-caption-alignCenter">
                                                    <div class="cbp-l-caption-body">
                                                        <a href="#" class=" cbp-l-caption-buttonLeft">Large View</a>
                                                        <a href="#" class=" cbp-l-caption-buttonRight" data-title="Dashboard<br>by Paul Flavius Nechita">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cbp-l-grid-projects-title">Summer Collection Of 2014 <span class="pull-right text">$90.00</span></div>
                                        <div class="cbp-l-grid-projects-desc">Clothes / Women</div>
                                    </div></li>
                                </ul>
                            </div>


                        </div>



                    </div>


                </div>

            </div>
        </div>
    </jsp:body>
</t:genericpage>