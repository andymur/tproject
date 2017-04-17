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
            <div class="shop-single">
                <div class="container">
                    <div class="col-md-12 headlines">
                        <h2>${product.name}<span class="color-bg">${product.model}</span></h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor<br>
                            incididunt ut labore et dolore magna aliqua.</p>
                    </div>

                    <div class="col-md-9">

                        <div class="row custom-cols">
                            <div class="col-md-8">
                                <ul id="gal1">
                                    <c:forEach var="image" items="${product.images}">
                                    <li>
                                        <a class="active" href="#" data-image="/resources/images/shop/1-${image}"
                                           data-zoom-image="/resources/images/shop/${image}">
                                            <img id="img_01" src="/resources/images/shop/small-${image}" alt=""/>
                                        </a>
                                    </li>
                                    </c:forEach>
                                </ul>
                                <%--public ProductDto(Product product) {--%>
                                <%--this.productId = product.getId();--%>
                                <%--this.brand = product.getBrand().getName();--%>
                                <%--this.name = product.getName();--%>
                                <%--this.model = product.getModel();--%>
                                <%--this.color = product.getColor();--%>
                                <%--this.description = product.getDescription();--%>
                                <%--this.category = product.getCategory().getName();--%>
                                <%--this.price = product.getPrice();--%>
                                <%--product.getImages().forEach(productImage -> this.images.add(productImage.getImage()));--%>
                                <%--product.getParameters().forEach(parameter -> this.parameters.add(new ParametersDto(parameter)));--%>
                                <%--this.mainImage = product.getImages().stream()--%>
                                <%--.filter(im -> im.getName().equals("main"))--%>
                                <%--.map(ProductImage::getImage)--%>
                                <%--.findFirst().orElse("/new.png");--%>
                                <%--}--%>
                                <img id="zoom_02" src="/resources/images/shop/1-${product.mainImage}" data-zoom-image="/resources/images/shop/${product.mainImage}" alt=""/>

                            </div>

                            <div class="col-md-4 item-dec">
                                <div class="item-price">$${product.price}</div>
                                <div class="divider-1"></div>
                                <div class="stars">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                    <a href="#" class="review pull-right">10 REVIEWS</a>
                                </div>
                                <p>some review</p>
                                <div class="divider-2"></div>
                                <form class="f1">
                                    <input class="sub" type='button' name='subtract'
                                           onclick='javascript: subtractQty();' value='-'/>
                                    <input type='text' name='qty' id='qty' value='0'/>
                                    <input class="add" type='button' name='add'
                                           onclick='javascript: document.getElementById("qty").value++;' value='+'/>
                                </form>
                                <a href="#" class="cart-btn">Add To Cart</a>
                                <div class="clearfix"></div>
                                <div class="user-option">
                                    <a href="#" class="op-1"><i class="fa fa-heart"></i> ADD TO WISHLIST</a>
                                </div>

                                <div class="divider-2"></div>
                                <div class="categories">
                                    <span class="category">CATEGORIES:</span><a href="#">Ladies</a>, <a
                                        href="#">Tops</a>, <a href="#">Jeans</a>, <a href="#">Bags</a>
                                </div>
                                <div class="divider-2"></div>

                            </div>

                        </div>

                        <div class="row shop-row-2">
                            <div class="col-md-12">
                                <div role="tabpanel">

                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li role="presentation" class="active"><a href="#description"
                                                                                  aria-controls="description" role="tab"
                                                                                  data-toggle="tab">DESCRIPTION</a></li>
                                        <li role="presentation"><a href="#reviews" aria-controls="reviews" role="tab"
                                                                   data-toggle="tab">REVIEWS (4)</a></li>
                                        <li role="presentation"><a href="#specifications" aria-controls="specifications"
                                                                   role="tab" data-toggle="tab">SPECIFICATIONS</a></li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="description">
                                            <p>${product.description}</p>
                                            <ol class="dec-ol">
                                                <li>Vestibulum ornare, neque a consequat fermentum.</li>
                                                <li>Nullam id libero id lectus blandit fringilla eu nec felis.</li>
                                                <li>Sed elementum tempor ante, et volutpat sem hendrerit in.</li>
                                                <li>Nullam leo justo, sodales ut imperdiet non, porta eget urna.</li>
                                                <li>Phasellus dictum est eu nibh ullamcorper id commodo erat pretium.
                                                </li>
                                            </ol>
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="reviews">
                                            <div class="heading">4 Reviews From Buyers</div>
                                            <div class="media">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object" src="/resources/images/about/1.png" alt="/">
                                                </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading">Jessica Fernando</h4>
                                                    Just an awesome design!! We all love it !!
                                                    <div class="media-stars"><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="media">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object" src="/resources/images/about/2.png" alt="/">
                                                </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading">Jessica Fernando</h4>
                                                    Just an awesome design!! We all love it !!
                                                    <div class="media-stars"><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="media">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object" src="/resources/images/about/3.png" alt="/">
                                                </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading">Jessica Fernando</h4>
                                                    Just an awesome design!! We all love it !!
                                                    <div class="media-stars"><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div role="tabpanel" class="tab-pane" id="specifications">
                                            <table class="table table-bordered">

                                                <tbody>
                                                <tr>
                                                    <td>BRAND</td>
                                                    <td>${product.brand}</td>
                                                </tr>
                                                <tr>
                                                    <td>PRODUCT MODEL</td>
                                                    <td>${product.model}</td>
                                                </tr>
                                                <tr>
                                                    <td>COLOR</td>
                                                    <td>${product.color}</td>
                                                </tr>
                                                <tr>
                                                    <td>FEATURES</td>
                                                    <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit porta.
                                                        Pellentesque non dui at sapien tempor gravida ut vel arcu.
                                                        Pellentesque non dui at sapien tempor gravida ut vel arcu.
                                                        <br>Lorem ipsum dolor sit amet, consectetur adipiscing elit
                                                        porta. Pellentesque non dui at sapien tempor gravida ut vel
                                                        arcu.
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>SHIPMENT</td>
                                                    <td>FREE GROUND SHIPPING</td>
                                                </tr>
                                                <tr>
                                                    <td>SIZE</td>
                                                    <td>MEDIUM</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-md-3 shop-sidebar">

                        <div class="shop-divider"></div>

                        <div class="block">
                            <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad
                                squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.</p>
                        </div>

                        <div class="shop-divider"></div>

                        <div class="block">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseOne">
                                                <i class="fa fa-minus-square-o"></i> FREE DELIVERY
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                            richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard
                                            dolor brunch.
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseTwo">
                                                <i class="fa fa-plus-square-o"></i> 5 DAYS MONEY BACK
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                            richardson ad squid.
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                               href="#collapseThree">
                                                <i class="fa fa-plus-square-o"></i> SECURE PAYMENTS
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                            richardson ad squid.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="block">
                            <img src="/resources/images/shop/banner.jpg" alt=""/>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <!-- Image Zoom Plugin -->
    </jsp:body>
</t:genericpage>