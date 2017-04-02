<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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


<div id="wrapper">

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
                    <div><a id="btn-login" href="#" class="c-btn-1">LOGIN</a> <a href="#" class="f-pass">Forget Password?</a></div>
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
                                <a href="index.jsp">Home</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="index.jsp">Home Parallax</a></li>
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
                                <a href="#">Shop</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-1"/>
                                <ul>
                                    <li><a href="shop.html">Shop Without Sidebar</a></li>
                                    <li><a href="shop-3.html">Shop With Left Sidebar</a></li>
                                    <li><a href="shop-2.html">Shop With Right Sidebar</a></li>
                                    <li><a href="shop-parallax.html">Shop Parallax</a></li>
                                    <li><a href="shop-slider.html">Shop With Slider</a></li>
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
                                <a href="">Services</a>
                                <input class="show-submenu" type="checkbox" name="show-submenu-2" />
                                <ul>
                                    <li><a href="admin.jsp">Dashboard</a></li>
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

        <div class="container welcome">
            <div class="col-md-12">
                <img src="resources/images/man-shadow.png" class="shadow-man" alt=""/>
            </div>

            <div class="col-md-12">
                <h2>WELCOME TO</h2>
                <h1>GOOD<span class="color-bg">WAY</span></h1>
                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad velit, sed quia
                    non<br> numqua eius modi tempora. Neque porro quisquam est, qui dolorem ipsum.</p>
                <a href="#" class="welcome-button-2 hvr-shutter-in-horizontal-2">READ MORE</a>
                <a href="#" class="welcome-button hvr-shutter-in-horizontal">BUY NOW</a>

            </div>
        </div>

    </header>


    <div class="about">
        <div class="container">
            <div class="col-md-12 a-welcome">
                <h2>We <span class="color-bg-2">Deal With</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit <br>adipisicing
                    elit, sed do eiusmod tempor.</p>
            </div>


            <div class="col-md-12 about-boxes">
                <div class="row">
                    <div id="owl-3" class="owl-carousel">

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-bookmark-o"></i></div>
                                <div class="box-heading hvr-bounce-to-top">BRANDING</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-code-fork"></i></div>
                                <div class="box-heading hvr-bounce-to-top">DESIGNING</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-connectdevelop"></i></div>
                                <div class="box-heading hvr-bounce-to-top">DEVELOPING</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-line-chart"></i></div>
                                <div class="box-heading hvr-bounce-to-top">SEO</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-bar-chart-o"></i></div>
                                <div class="box-heading hvr-bounce-to-top">MARKETING</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="about-box">
                                <div><i class="fa fa-code"></i></div>
                                <div class="box-heading hvr-bounce-to-top">CODING</div>
                                <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad
                                    velit, sed quia non numqua eius modi tempora.</p>
                            </div>
                        </div>

                    </div>

                </div>
            </div>


        </div>
    </div>

    <div class="unique">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>WE ARE <span class="color-bg-2">UNIQUE</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit <br>adipisicing
                    elit, sed do eiusmod tempor.</p>
            </div>

            <div class="uni-main">
                <div class="col-md-7">
                    <img src="resources/images/banner.png" alt=""/>
                </div>

                <div class="col-md-5 right">
                    <h3>UNIQUE <span class="color">CONCEPT</span></h3>
                    <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                        wolf moon officia aute, non cupidatat skateboard dolor brunch. Anim pariatur cliche
                        reprehenderit, enim eiusmod high life accusamus terry richardson ad squid enim eiusmod high life
                        accusamus.<br><br>

                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Anim pariatur cliche
                        reprehenderit, enim eiusmod high life accusamus terry richardson ad squid enim eiusmod high life
                        accusamus.</p>
                    <a href="#" class="r-more hvr-shutter-in-horizontal-3">Read More</a>
                </div>
            </div>

        </div>
    </div>

    <div class="strategy">
        <div class="container headlines">

            <div class="lamps">
                <img src="resources/images/lamp3.png" class="img-1" alt=""/>
                <img src="resources/images/lamp3.png" class="img-2" alt=""/>
            </div>

            <div class="col-md-12">
                <h2>Our <span class="color-bg">Strategy</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit <br>adipisicing
                    elit, sed do eiusmod tempor.</p>
            </div>

            <div class="col-md-12 strategy-boxes">
                <div class="row">
                    <div class="col-md-3">
                        <div class="strategy-box hvr-float-shadow">
                            <img src="resources/images/about/icons/5.png" alt=""/>
                            <h3>Core Idea</h3>
                            <div class="circle">
                                1
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="strategy-box hvr-float-shadow">
                            <img src="resources/images/about/icons/6.png" alt=""/>
                            <h3>Research</h3>
                            <div class="circle">
                                2
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="strategy-box hvr-float-shadow">
                            <img src="resources/images/about/icons/7.png" alt=""/>
                            <h3>Action</h3>
                            <div class="circle">
                                3
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="strategy-box hvr-float-shadow">
                            <img src="resources/images/about/icons/8.png" alt=""/>
                            <h3>Success</h3>
                            <div class="circle">
                                4
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="why">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>Why <span class="color-bg-3">Goodway</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit <br>adipisicing
                    elit, sed do eiusmod tempor.</p>
            </div>

            <div class="content">
                <div class="col-md-6">
                    <img src="resources/images/parsel.png" class="img-responsive parsel" alt=""/>
                </div>

                <div class="col-md-6 a-t">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading active">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                        <i class="fa fa-plus fa-lg"></i> Pixel Perfect Design
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <p class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid enim eiusmod high life accusamus.
                                </p>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                                       class="collapsed">
                                        <i class="fa fa-minus fa-lg"></i> Easy To Customize
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse">
                                <p class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch.
                                </p>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                                       class="collapsed">
                                        <i class="fa fa-minus fa-lg"></i> Award Winning Support
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse">
                                <p class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch.
                                </p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>


    <div class="portfolio port-main">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>Recent <span class="color-bg">Projects</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit <br>adipisicing
                    elit, sed do eiusmod tempor.</p>
            </div>


            <div class="col-md-12">
                <div id="filters-container" class="cbp-l-filters-alignCenter">
                    <div data-filter="*" class="cbp-filter-item-active cbp-filter-item">ALL
                        <div class="cbp-filter-counter"></div>
                    </div>
                    /
                    <div data-filter=".identity" class="cbp-filter-item">IDENTITY
                        <div class="cbp-filter-counter"></div>
                    </div>
                    /
                    <div data-filter=".web-design" class="cbp-filter-item">WEB DESIGN
                        <div class="cbp-filter-counter"></div>
                    </div>
                    /
                    <div data-filter=".graphic" class="cbp-filter-item">GRAPHIC
                        <div class="cbp-filter-counter"></div>
                    </div>
                    /
                    <div data-filter=".logo" class="cbp-filter-item">LOGO
                        <div class="cbp-filter-counter"></div>
                    </div>
                    /
                    <div data-filter=".motion" class="cbp-filter-item">MOTION
                        <div class="cbp-filter-counter"></div>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div id="grid-container-1" class="cbp-l-grid-fullScreen">
                    <ul>
                        <li class="cbp-item identity logo">

                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resources/images/work/1.jpg" class="cbp-caption cbp-lightbox"
                               data-title="Dashboard<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/1.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">Dashboard</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>

                        </li>
                        <li class="cbp-item web-design">
                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resources/images/work/6.jpg" class="cbp-caption cbp-lightbox"
                               data-title="Client chat app WIP<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/6.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">Client chat app WIP</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="cbp-item motion identity">
                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resources/images/work/8.jpg" class="cbp-caption cbp-lightbox"
                               data-title="World Clock Widget<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/8.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">World Clock Widget</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="cbp-item identity graphic">
                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resouces/images/work/2.jpg" class="cbp-caption cbp-lightbox"
                               data-title="Website Lightbox<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/2.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">Website Lightbox</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="cbp-item identity graphic">
                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resources/images/work/3.jpg" class="cbp-caption cbp-lightbox"
                               data-title="Website Lightbox<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/3.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">Website Lightbox</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="cbp-item identity graphic">
                            <div class="item-info">
                                <div class="info-text">Eiusmod Tempor <span class="pull-right small-text">design / vector</span>
                                </div>
                            </div>

                            <a href="resources/images/work/7.jpg" class="cbp-caption cbp-lightbox"
                               data-title="Website Lightbox<br>by Paul Flavius Nechita">
                                <div class="cbp-caption-defaultWrap">
                                    <img src="resources/images/work/7.jpg" alt="">
                                </div>
                                <div class="cbp-caption-activeWrap">
                                    <div class="cbp-l-caption-alignLeft">
                                        <div class="cbp-l-caption-body">
                                            <div class="cbp-l-caption-title">Website Lightbox</div>
                                            <div class="cbp-l-caption-desc">by Paul Flavius Nechita</div>
                                            <div class="pr-btn">View Project</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>

                    </ul>
                </div>

            </div>
        </div>

    </div>
    <div class="clearfix"></div>


    <div class="theme-buy">
        <div class="container">
            <div class="col-md-8">
                <h2>A THEME FOR <br>YOUR <span class="color-bg-2">BUSINESS</span></h2>
                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Lorem ipsum dolor sit amet,
                    consectetur adipisicing elit, sed <br>do eiusmod temporum dolor sit adipisicing elit, sed do eiusmod
                    tempor.</p>
                <div><a href="#" class="buy-btn hvr-shutter-in-horizontal-3">BUY NOW</a></div>
            </div>

            <div class="col-md-4">
                <img src="resources/images/lamp2.png" alt=""/>
            </div>
        </div>
    </div>


    <div class="testimonials">
        <div class="container">
            <div class="col-md-12 headlines">
                <h2>Our <span class="color-bg-2">Reviews</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit<br>
                    adipisicing elit, sed do eiusmod tempor.</p>
            </div>
            <div class="clearfix"></div>

            <div id="owl-1" class="owl-carousel">
                <div>
                    <img src="resources/images/testimonials/1.jpg" alt=""/>
                    <div class="t-box">
                        <div class="t-data">
                            <div class="t-name">John Doe</div>
                            <div class="t-position">Chief Executing Officer</div>
                            <div class="t-stars">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="t-para">“Just Extraordinary Theme”</div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor
                                sit adipisicing elit, sed do eiusmod tempor. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit, sed do eiusmod temporum dolor sit adipisicing elit, sed do eiusmod
                                tempor.</p>
                            <div class="t-socials">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-skype"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <img src="resources/images/testimonials/2.jpg" alt=""/>
                    <div class="t-box">
                        <div class="t-data">
                            <div class="t-name">John Doe</div>
                            <div class="t-position">Chief Executing Officer</div>
                            <div class="t-stars">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="t-para">“Just Extraordinary Theme”</div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor
                                sit adipisicing elit, sed do eiusmod tempor. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit, sed do eiusmod temporum dolor sit adipisicing elit, sed do eiusmod
                                tempor.</p>
                            <div class="t-socials">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-skype"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>

    <div class="partners">
        <div class="container">
            <div class="col-md-12">
                <div id="owl-2" class="owl-carousel">
                    <div><img src="resources/images/partners/5.png" alt=""/></div>
                    <div><img src="resources/images/partners/2.png" alt=""/></div>
                    <div><img src="resources/images/partners/5.png" alt=""/></div>
                    <div><img src="resources/images/partners/2.png" alt=""/></div>
                    <div><img src="resources/images/partners/5.png" alt=""/></div>
                    <div><img src="resources/images/partners/2.png" alt=""/></div>
                </div>
            </div>
        </div>
    </div>


    <div class="blog">
        <div class="container">

            <div class="col-md-12 headlines">
                <h2>Latest From <span class="color-bg">Blog</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temporum dolor sit<br>
                    adipisicing elit, sed do eiusmod tempor.</p>
            </div>

            <div class=" blog-posts">
                <div class="col-md-4 blog-post">
                    <div class="circle">06
                        <hr>
                        JUNE
                    </div>
                    <img src="resources/images/blog/6.jpg" alt=""/>
                    <div class="blog-caption">
                        <a href="#" class="comments">
                            <i class="fa fa-comment-o"></i> 24 Comments
                        </a>
                        <a href="#" class="likes">
                            <i class="fa fa-thumbs-o-up"></i> 12 Likes
                        </a>

                    </div>
                    <div class="info-box">
                        <h3 class="blog-title">This is blog post 1</h3>
                        <div class="author">Posted By : <span class="color">Jass</span> in <span class="color">Web Designing</span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisic elit, sed do eiusmod temporum dolor sit
                            dolor adipisic elit, sed do eiusmod tempor.</p>
                        <a href="#" class="r-more hvr-shutter-in-horizontal">Read More</a>
                    </div>
                </div>

                <div class="col-md-4 blog-post-2">
                    <div class="circle">07
                        <hr>
                        JUNE
                    </div>
                    <img src="resources/images/blog/3.jpg" alt=""/>
                    <div class="blog-caption">
                        <a href="#" class="comments">
                            <i class="fa fa-comment-o"></i> 24 Comments
                        </a>
                        <a href="#" class="likes">
                            <i class="fa fa-thumbs-o-up"></i> 12 Likes
                        </a>

                    </div>
                    <div class="info-box">
                        <h3 class="blog-title">This is blog post 2</h3>
                        <div class="author">Posted By : <span class="color">Jass</span> in <span class="color">Web Designing</span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisic elit, sed do eiusmod temporum dolor sit
                            dolor adipisic elit, sed do eiusmod tempor.</p>
                        <a href="#" class="r-more hvr-shutter-in-horizontal">Read More</a>
                    </div>
                </div>

                <div class="col-md-4 blog-post-3">
                    <div class="circle">08
                        <hr>
                        JUNE
                    </div>
                    <img src="resources/images/blog/7.jpg" alt=""/>
                    <div class="blog-caption">
                        <a href="#" class="comments">
                            <i class="fa fa-comment-o"></i> 24 Comments
                        </a>
                        <a href="#" class="likes">
                            <i class="fa fa-thumbs-o-up"></i> 12 Likes
                        </a>

                    </div>
                    <div class="info-box">
                        <h3 class="blog-title">This is blog post 3</h3>
                        <div class="author">Posted By : <span class="color">Jass</span> in <span class="color">Web Designing</span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisic elit, sed do eiusmod temporum dolor sit
                            dolor adipisic elit, sed do eiusmod tempor.</p>
                        <a href="#" class="r-more hvr-shutter-in-horizontal">Read More</a>
                    </div>
                </div>

            </div>


        </div>
    </div>

    <div class="say-hello">
        <div class="container">
            <div class="col-md-12">
                <h2>Want To Work <span class="color-bg-2">With Us?</span></h2>
                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia <br>aute, non cupidatat skateboard dolor brunch.</p>
                <a href="#" class="hello-btn hvr-shutter-in-horizontal">Say Hello !</a>
                <img src="resources/images/team3-1.png" class="img-responsive" alt=""/>
            </div>
        </div>
    </div>


    <footer>
        <div class="container">
            <div class="col-md-12">
                <div class="row footer-blocks">
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
                            <p class="mid-para">Lorem ipsum dolor sit amet, consecte adipisicing elit, sed do eiusmod
                                tempor dolor sit adipisicing elit, sed do eiusmod tempor. Lorem ipsum dolor sit amet,
                                consectetur adipisicing elit, sed do eiusmod adipisicing sit.</p>
                            <a href="#"><img src="resources/images/f-logo.png" alt=""/></a>
                        </div>
                    </div>

                    <div class="col-md-3 footer-block">
                        <h3>GET IN TOUCH</h3>
                        <div class="block">
                            <p class="right-para">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                eiusmod. Lorem ipsum dolor sit amet, consectetur adipisi elit, sed ipsum do eiusmod.</p>
                            <ul class="address-ul">
                                <li><i class="fa fa-globe"></i> 32, Godman St. 46, Sky City</li>
                                <li><i class="fa fa-phone"></i> +123 786 007</li>
                                <li><i class="fa fa-paper-plane-o"></i> info@example.com</li>
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

<!-- Style Switcher -->
<div class="color-picker">
    <div class="picker-btn"></div>
    <div class="pickerTitle">Style Switcher</div>
    <div class="l-title">Select Layout</div>
    <div class="pwrapper">
        <div class="layout-1"><img src="resources/images/layout1.png" alt=""/>
            <div class="sub">Layout 1</div>
        </div>
        <div class="layout-2"><img src="resources/images/layout2.png" alt=""/>
            <div class="sub">Layout 2</div>
        </div>
        <div class="layout-3"><img src="resources/images/layout3.png" alt=""/>
            <div class="sub">Layout 3</div>
        </div>
        <div class="p-title">Select Pattern</div>
        <ul class="patterns">
            <li class="pattern-1"><img src="resources/images/patterns/1.png" alt=""/></li>
            <li class="pattern-2"><img src="resources/images/patterns/3.png" alt=""/></li>
            <li class="pattern-3"><img src="resources/images/patterns/4.png" alt=""/></li>
            <li class="pattern-4"><img src="resources/images/patterns/5.png" alt=""/></li>
        </ul>
    </div>
</div>


<!-- Jquery Libs -->
<!-- Latest Version Of Jquery -->
<script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>
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

</body>
</html>