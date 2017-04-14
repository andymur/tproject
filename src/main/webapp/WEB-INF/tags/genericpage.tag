<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="bodyfr" fragment="true" %>

<html>
<head>
    <title>Linus</title>
    <link rel="icon" href="images/favicon.ico">
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content=""/>
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="icon" href="//cdn.shopify.com/s/files/1/0049/9332/t/9/assets/logo.png">

    <!-- bootstrap magic -->
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
    <!-- cubeportfolio -->
    <link rel="stylesheet" type="text/css" href="resources/css/cubeportfolio.css"/>
    <!-- Owl Carousel Assets -->
    <link rel="stylesheet" href="resources/css/owl.carousel.css">
    <link rel="stylesheet" href="resources/css/owl.theme.css">

    <!-- theme custom -->
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/cart.css"/>


    <!-- fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>


    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome/css/font-awesome.min.css"/>

    <!--[if LTE IE 8]>
    <link rel="stylesheet" href="resources/css/menu-ie.css"/>
    <![endif]-->


    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

</head>
<body>
    <div id="body">
        <div id="preloader">
            <div class="container">
                <div class="col-md-12">
                    <div class="sbook">
                        <h2>LIN<span class="color">US</span></h2>
                        <p>THE BICYCLE</p>
                        <div class="spinner">
                            <div class="double-bounce1"></div>
                            <div class="double-bounce2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="css3droppanel">
                <input type="checkbox" id="paneltoggle"/>
                <label for="paneltoggle" title="Click to open Panel"></label>
                <div class="content">
                    <div class="container">
                        <!--panel content goes here-->

                        <sec:authorize access="isAnonymous()">
                            <div class="col-md-2">
                                <h3>LOG<span class="color">IN</span></h3>
                                <c:url var="loginUrl" value="/loginme"/>
                                <form action="${loginUrl}" method="post" class="form-horizontal">
                                    <input type="text" class="input-1" id="username" name="ssoId" placeholder="Enter Username"
                                           required>
                                    <input type="password" class="input-1" id="password" name="password"
                                           placeholder="Enter Password" required>
                                    <input type="submit" class="c-btn-1" value="LOGIN">
                                    <a href="/newuser" class="f-pass">Register</a>
                                    <c:if test="${param.error != null}">
                                        <p>Invalid username and password.</p>
                                    </c:if>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </div>
                        </sec:authorize>

                        <sec:authorize access="isAuthenticated()">
                            <div id="logout" class="col-md-1">
                                <h3>LOG<span class="color">OUT</span></h3>
                                <div class="form-inline">
                                    <div class="authbar">
                            <span class="floatRight">
                                    <a href="<c:url value="/logout" />" class="c-btn-1">Logout</a>
                                </span>
                                    </div>
                                </div>
                            </div>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        <header id="header">
                    <div class="container">
                        <div class="col-md-12">
                            <div class="main-menu">
                                <!-- START - MINIMAL CSS3 MENU -->

                                <div class="minimal-menu">
                                    <div class="logo">
                                    <a href="/"><img src="//cdn.shopify.com/s/files/1/0049/9332/t/9/assets/logo.png?12457888596116483597" alt="Linus Bike"></a>
                                    </div>


                                    <ul class="wrapper">
                                        <li class="submenu">
                                            <a href="index">Home</a>
                                            <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                            <ul>
                                                <li><a href="index">About</a></li>
                                            </ul>
                                        </li>
                                        <li class="submenu">
                                            <a id="shop" href="shop">Shop</a>
                                            <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                            <ul class="categories">
                                                <c:forEach var="mapitem" items="${categoriesmap}">
                                                    <li><a href="catalog?categoryId=${mapitem.key.id}">${mapitem.key.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li class="submenu">
                                            <a href="#">Contacts</a>
                                            <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                            <ul>
                                                <li><a href="contact.html">Contact Us</a></li>
                                            </ul>
                                        </li>
                                        <sec:authorize access="hasRole('ADMIN')">
                                            <li id="adminService" class="submenu">
                                                <a href=""><strong>Admin Dashboard</strong></a>
                                                <input class="show-submenu" type="checkbox" name="show-submenu-2"/>
                                                <ul>
                                                    <li><a href="admin_products">Products</a></li>
                                                    <li><a href="admin_orders">Orders</a></li>
                                                    <li><a href="dashboard">Statistics</a></li>
                                                </ul>
                                            </li>
                                        </sec:authorize>
                                        <sec:authorize access="isAuthenticated()">
                                            <li class="submenu">
                                                <a id="username" data-username="${loggedinuser}" href="/user"><strong>${loggedinuser}</strong></a>
                                                <ul>
                                                    <li><a id="usercart" href="#">Cart</a></li>
                                                    <li><a href="orders">Orders</a></li>
                                                </ul>
                                            </li>
                                        </sec:authorize>
                                        <li>
                                            <div class="popover_parent">
                                                <a href="javascript:void(0)"><i class="fa fa-search"></i></a>
                                                <fieldset class="popover search">
                                                    <input type="text" class="form-control" placeholder="Search">
                                                    <input type="submit" class="btn-1" value="Go">
                                                </fieldset>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="icon-cart"></span><a id="cart" href="#" class="cart" title="Shopping Cart">Cart: <span class="cart-count">0</span></a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- END - MINIMAL CSS3 MENU -->
                            </div>
                        </div>
                    </div>

                </header>
        <jsp:doBody/>

    </div>
    <div id="pagefooter">
        <jsp:invoke fragment="footer"/>
        <footer>
            <div class="container">
                <div class="col-md-12">
                    <div class="rows footer-blocks">
                        <div class="col-md-3 footer-block">
                            <h3>LATEST POSTS</h3>
                            <div class="block foot-posts">
                                <div class="media">
                                    <div class="media-left">
                                        <a href="#">
                                            <img class="media-object" src="resources/images/blog/small1.jpg" alt="#">
                                        </a>
                                    </div>
                                    <div class="media-body">
                                        <a href="#" class="media-heading">Dollis Latter</a>
                                        <div class="date">21 May 2015</div>
                                    </div>
                                </div>

                                <div class="media">
                                    <div class="media-left">
                                        <a href="#">
                                            <img class="media-object" src="resources/images/blog/small1.jpg" alt="#">
                                        </a>
                                    </div>
                                    <div class="media-body">
                                        <a href="#" class="media-heading">Dollis Latter</a>
                                        <div class="date">21 May 2015</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3 footer-block">
                            <h3>ABOUT COMPANY</h3>
                            <div class="block">
                                <p class="mid-para">At Linus we see bicycles not only for recreation and sport, but as a legitimate form of transportation. In our every day life we take numerous little journeys, under 5 miles…. to the store, the cafe, to work, etc. Besides the obvious joy of riding a bicycle, these small bicycle trips reduce carbon emissions, congestion, noise pollution, and make for a happier, more connected city experience.</p>
                            </div>
                        </div>

                        <div class="col-md-3 footer-block">
                            <h3>GET IN TOUCH</h3>
                            <div class="block">
                                <p class="right-para">
                                    1046 Princeton Dr. Unit 108
                                    Marina Del Rey, California USA 90292
                                    www.linusbike.com     hello@linusbike.com
                                    Office Hours:  Monday - Friday   9am - 6pm

                                    <a href="https://www.google.com/maps/place/1046+Princeton+Dr,+Marina+del+Rey,+CA+90292/@33.9861534,-118.4456324,17z/data=!3m1!4b1!4m2!3m1!1s0x80c2ba85fd16ac39:0x4ddb2da55798c255">Google Map </a></p>
                                <ul class="address-ul">
                                    <li><i class="fa fa-globe"></i> 1046 Princeton Dr. Unit 108</li>
                                    <li><i class="fa fa-phone"></i> +1.310.822.7722</li>
                                    <li><i class="fa fa-paper-plane-o"></i> hello@linusbike.com</li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 footer-block">
                            <h3>NEWSLETTER SIGNUP</h3>
                            <div class="block newsletter">
                                <p>Subscribe to Our Newsletter to get Important News, Amazing Offers & Inside Scoops.</p>
                                <div class="n-area-right">
                                    <input type="text" placeholder="Enter Email ...">
                                    <a href="#" class="n-btn"><i class="fa  fa-arrow-right"></i></a>
                                </div>
                                <div class="socials">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-skype"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-dribbble"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </footer>
        <div class="bottom-bar">
            <div class="container">
                <div class="col-md-12 left">
                    © 2017 Linus.
                    <ul class="foot-nav pull-right">
                        <li><a href="">Home</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Services</a></li>
                        <li><a href="">Blog</a></li>
                        <li><a href="">Contact</a></li>
                    </ul>
                </div>

            </div>
        </div>

        <!-- Jquery Libs -->
        <!-- Latest Version Of Jquery -->

        <script type="text/javascript" src="resources/cart.js"></script>
        <script type="text/javascript" src="resources/main.js"></script>
        <!-- Bootstrap Jquery -->
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
        <!-- Sticky Jquery -->
        <script type="text/javascript" src="resources/js/jquery.sticky.js"></script>
        <!-- Parallax Plugin -->
        <script type="text/javascript" src="resources/js/jquery.parallax-1.1.3.js"></script>
        <!-- Counter Plugin -->
        <script type="text/javascript" src="resources/js/jquery.counterup.min.js"></script>
        <!-- Waypoints -->
        <script type="text/javascript" src="resources/js/waypoints.min.js"></script>
        <!-- Cubeportfolio -->
        <script type="text/javascript" src="resources/js/jquery.cubeportfolio.min.js"></script>
        <%--<script type="text/javascript" src="resources/js/cbp-10.js"></script>--%>
        <!--To-Top Button Plugin -->
        <script type="text/javascript" src="resources/js/jquery.ui.totop.js"></script>
        <!--Easing animations Plugin -->
        <script type="text/javascript" src="resources/js/easing.js"></script>

        <!-- Owl Carousel Plugin -->
        <script type="text/javascript" src="resources/js/owl.carousel.min.js"></script>
        <!-- Theme Custom -->
        <script type="text/javascript" src="resources/js/preloader.js"></script>
        <script type="text/javascript" src="resources/js/switcher.js"></script>
        <script type="text/javascript" src="resources/js/custom.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <!--login/registration-->
        <%--<script type="text/javascript" src="resources/login.js"></script>--%>

        <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(function() {
                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
                $(document).ajaxSend(function(e, xhr, options) {
                    xhr.setRequestHeader(header, token);
                });
            });
        </script>
    </div>
</body>
</html>