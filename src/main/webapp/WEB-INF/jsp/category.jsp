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
                                            <option selected disabled>Choose here</option>
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
                                            <option selected disabled>Choose here</option>
                                            <c:forEach var="size" items="${sizes}">
                                                <option>${size}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Color</label>
                                    <div class="col-sm-10">
                                        <select id="color-select" class="form-control m-bot15">
                                            <option selected disabled>Choose here</option>
                                            <c:forEach var="color" items="${colors}">
                                                <option>${color}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>

