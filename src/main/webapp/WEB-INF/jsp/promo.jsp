<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="wrapper">

    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseFive">
                        <i class="fa fa-plus-square-o"></i> Add PROMO product
                    </a>
                </h4>
            </div>
            <div id="collapseFive" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-promo" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Product<span
                                    class="required">*</span></label>
                            <select id="productSelect" >
                                <option selected disabled>Select product</option>
                                <c:forEach var="product" items="${allProducts}">
                                    <option class="optionClass" data-id=${product.id} data-thumbnail-src=${product.mainImage}>${product.id}|${product.name}|${product.model}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div id="preview"></div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button id="btn-add-promo" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        <i class="fa fa-plus-square-o"></i> Current PROMO products
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                    <div class="col-md-12">
                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>PRODUCT ID</th>
                                <th>NAME</th>
                                <th>ACTION</th>
                            </tr>
                            <c:forEach var="product" items="${products}">
                                <tr id="${product.id}">
                                    <td>
                                            ${product.id}
                                    </td>
                                    <td>
                                        <div class="media">
                                            <div class="media-left">
                                                <a href="/product/${product.id}">
                                                    <img class="media-object" src="${product.mainImage}" alt="">
                                                </a>
                                            </div>
                                            <div class="media-body">
                                                <a href="/product/${product.id}" class="media-heading">${product.name}</a>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <button class="removePromoProduct" value="${product.id}" type="button">
                                            Remove
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>