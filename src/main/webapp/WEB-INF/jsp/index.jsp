<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div id="wrapper">


            <div class="container-custom welcome-slider welcome-cust">
                <div id="w-owl" class="owl-carousel">
                    <c:forEach var="product" items="${carouselproducts}">
                        <div>
                            <div class="col-md-11 textoverlay">
                                <h1><span class="color-bg">${product.name}</span></h1>
                                <a href="/product/${product.id}" class="shop-button hvr-shutter-in-horizontal">SHOP
                                    NOW</a>
                            </div>
                            <img class="img-responsive" src="${product.longpic}"
                                 alt="" ;/>
                        </div>
                    </c:forEach>
                </div>
            </div>
                <%--<div class="col-md-12">--%>
                <%--<h2>WELCOME TO</h2>--%>
                <%--<h1>LIN<span class="color-bg">US</span></h1>--%>


                <%--</div>--%>
                <%--</div>--%>
            <div class="about">
                <div class="bestsellers">
                    <h4 class="text-center text-uppercase">best sellers</h4>
                    <div class="container">
                        <div class="col-md-12">
                            <div id="owl-2" class="owl-carousel">
                                <c:forEach var="product" items="${bestSellers}">
                                    <div><a href="/product/${product.id}"><img src="${product.mainpic}" alt=""
                                                                               class="img-responsive"/></a></div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="col-md-12 headlines">
                        <h2>WE ARE <span class="color-bg-2">UNIQUE</span></h2>
                        <p>That’s LINUS… a simple, affordable, elegant bike for riding around and doing stuff.</p>
                    </div>

                    <div class="uni-main">
                        <div class="col-md-7">
                            <img src="resources/images/banner.png" alt="" class="img-responsive"/>
                        </div>

                        <div class="col-md-5 right">
                            <h3>UNIQUE <span class="color">CONCEPT</span></h3>
                            <p>Inspired by French bicycle design of the 50s and 60s we have created a bicycle that
                                preserves the simple elegance and pure form of that golden era, but has all the benefits
                                of modern comfort and reliability. LINUS is the utilitarian city bike… simple and
                                reliable, but with a personality and style that makes you feel like you’re in an old
                                French movie… you’re floating a little from the wine you drank at lunch… maybe instead
                                of going back to the office you’ll take a nap under a tree, go for a swim in the sea or
                                drop by your lover’s house…<br><br>

                            </p>
                            <a href="#" class="r-more hvr-shutter-in-horizontal-3">Read More</a>
                        </div>
                    </div>

                </div>

            </div>

            <div class="clearfix"></div>
        </div>
    </jsp:body>
</t:genericpage>
