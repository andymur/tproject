<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
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

    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">

    <!-- bootstrap magic -->
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
    <!-- cubeportfolio -->
    <link rel="stylesheet" type="text/css" href="resources/css/cubeportfolio.css"/>
    <!-- Owl Carousel Assets -->
    <link rel="stylesheet" href="resources/css/owl.carousel.css">
    <link rel="stylesheet" href="resources/css/owl.theme.css">

    <!-- theme custom -->
    <link rel="stylesheet" href="resources/css/style.css"/>


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


    <!--[if lte IE 8]>

    <style>

        /* Hide panel from IE8 and below */

        div.css3droppanel {
            display: none;
        }

    </style>

    <![endif]-->


</head>
<body>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
    <!-- PRELOADER -->
    <div id="preloader">
        <div class="container">
            <div class="col-md-12">
                <div class="sbook">
                    <h2>LIN<span class="color">US</span></h2>
                    <p>HTML TEMPLATE</p>
                    <div class="spinner">
                        <div class="double-bounce1"></div>
                        <div class="double-bounce2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END PRELOADER -->
    <div class="css3droppanel">
        <input type="checkbox" id="paneltoggle"/>
        <label for="paneltoggle" title="Click to open Panel"></label>

        <div class="content">
            <div class="container">
                <!--panel content goes here-->
                <div class="col-md-4">
                    <h3>ABOUT <span class="color">US</span></h3>
                    <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad velit, sed quia
                        non numqua eius modi tempora.</p>
                </div>

                <div class="col-md-2" id="login">
                    <h3>LOG<span class="color">IN</span></h3>
                    <input type="text" name="email" class="input-1" placeholder="email.."/>
                    <input type="password" name="password" class="input-1" placeholder="Password.."/>
                    <div><a id="btn-login" href="#" class="c-btn-1">LOGIN</a> <a href="#" class="f-pass">Forget
                        Password?</a></div>
                </div>
                <div id="register" class="col-md-6 last-col">
                    <h3>REGIS<span class="color">TER</span></h3>
                    <div class="form-inline">
                        <div class="form-group">
                            <input type="text" class="form-control" name="name" placeholder="First Name">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="secondName" placeholder="Last Name">
                        </div>

                        <div class="form-group">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <div><a id="btn-register" href="#" class="c-btn-1">REGISTER</a></div>
                    </div>

                    <img src="resources/images/lamp.png" class="lamp" alt=""/>
                </div>

                    <img src="resources/images/lamp.png" class="lamp" alt=""/>
                </div>

            </div>
            <!-- end panel content -->
        </div>

    </div>
    <header id="header">
        <div class="container">
            <div class="col-md-12">
                <div class="main-menu">
                    <!-- START - MINIMAL CSS3 MENU -->
                    <label class="minimal-menu-button" for="mobile-nav">Menu</label>
                    <input class="minimal-menu-button" type="checkbox" id="mobile-nav" name="mobile-nav"/>

                    <div class="minimal-menu">
                        <div class="logo">
                            <a href="#"><img src="resources/images/logo.png" alt=""></a>
                        </div>

                        <ul class="wrapper">
                            <li class="submenu">
                                <a href="index">Home</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="index">Home Parallax</a></li>
                                    <li><a href="index-slider.html">Home With Slider</a></li>
                                    <li><a href="index_content_slider.html">Home Content Slider</a></li>
                                    <li><a href="index-static.html">Home Static Background</a></li>
                                    <li><a href="index_scroll_animations.html">Home Scroll Animations</a></li>
                                    <li class="submenu">
                                        <a href="#">More</a>
                                        <input class="show-submenu" type="checkbox" name="show-submenu-3"/>
                                        <ul>
                                            <li><a href="index_portfolio.html">Home Portfolio</a></li>
                                            <li><a href="index_blog.html">Home Blog</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="submenu">
                                <a href="#">Pages</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="about.html">About Us 1</a></li>
                                    <li><a href="about-2.html">About Us 2</a></li>
                                    <li><a href="pricing-table-3.html">Pricing Table 4 Column</a></li>
                                    <li><a href="pricing-table-1.html">Pricing Table 3 Column</a></li>
                                    <li><a href="pricing-table-2.html">Pricing Table 2 Column</a></li>
                                    <li><a href="page-sidebar-right.html">Page With Right Sidebar</a></li>
                                    <li><a href="page-sidebar-left.html">Page With Left Sidebar</a></li>
                                    <li><a href="page-fullwidth.html">Page Full Width</a></li>
                                    <li class="submenu">
                                        <a href="#">404 Pages</a>
                                        <input class="show-submenu" type="checkbox" name="show-submenu-3"/>
                                        <ul>
                                            <li><a href="404-error.html">404 Page v1</a></li>
                                            <li><a href="404-error-v2.html">404 Page v2</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="faq.html">FAQ</a></li>
                                    <li><a href="coming-soon.html">Under Construction Page</a></li>
                                </ul>
                            </li>
                            <li class="submenu">
                                <a href="shop">Shop</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="shop-3.html">Shop With Left Sidebar</a></li>
                                    <li><a href="shop-single.html">Shop Product Page</a></li>
                                    <li><a href="cart.html">Cart</a></li>
                                    <li><a href="checkout.html">Checkout</a></li>
                                </ul>
                            </li>

                            <li class="submenu">
                                <a href="#">Blog</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="blog.html">Blog Version 1</a></li>
                                    <li><a href="blog-2.html">Blog Version 2</a></li>
                                    <li><a href="blog-3.html">Blog Version 3</a></li>
                                    <li><a href="blog-4.html">Blog Version 4</a></li>
                                    <li><a href="blog-5.html">Blog Version 5</a></li>
                                    <li class="submenu">
                                        <a href="#">Blog Single</a>
                                        <input class="show-submenu" type="checkbox" name="show-submenu-3"/>
                                        <ul>
                                            <li><a href="blog-post-1.html">Single Right Sidebar</a></li>
                                            <li><a href="blog-post-2.html">Single Left Sidebar</a></li>
                                        </ul>
                                    </li>


                                </ul>
                            </li>

                            <li class="submenu">
                                <a href="#">Contacts</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="contact.html">Contact Us 1</a></li>
                                    <li><a href="contact-2.html">Contact Us 2</a></li>
                                    <li><a href="contact-3.html">Contact Us 3</a></li>
                                </ul>
                            </li>

                            <li id="adminService" class="submenu">
                                <a href="">Dashboard</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-2"/>
                                <ul>
                                    <li><a href="admin_products">Products</a></li>
                                    <li><a href="admin_orders">Orders</a></li>
                                    <li><a href="dashboard">Statistics</a></li>
                                </ul>
                            </li>

                            <li>
                                <div class="popover_parent">
                                    <a href="javascript:void(0)"><i class="fa fa-search"></i></a>
                                    <fieldset class="popover search">
                                        <input type="text" class="form-control" placeholder="Search">
                                        <input type="submit" class="btn-1" value="Go">
                                    </fieldset>
                                </div>
                            </li>


                        </ul>
                    </div>
                    <!-- END - MINIMAL CSS3 MENU -->
                </div>
            </div>
        </div>

    </header>
</div>
<div id="body">
    <jsp:doBody/>

</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
    <div class="bottom-bar">
        <div class="container">
            <div class="col-md-12 left">
                © 2015 Goodway. All rights reserved. Theme by GJ-Designs.
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


</div>

<!-- Jquery Libs -->
<!-- Latest Version Of Jquery -->

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
<script type="text/javascript" src="resources/js/cbp-3.js"></script>
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
<script type="text/javascript" src="resources/login.js"></script>

<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</div>
</body>
</html>