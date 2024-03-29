<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="block">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        <i class="fa fa-plus-square-o"></i> Add product
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-product" class="form-horizontal " method="get">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Name<span
                                    class="required">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Model</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="model">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Color</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="color">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Price</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" required name="price">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Quantity</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="quantity">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Size</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="size">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Weight</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="weight">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Image url</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="imageurl">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Image name</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="imagename">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Brand</label>
                            <div class="col-sm-10">
                                <select id="br-select" class="form-control m-bot15">
                                    <c:forEach var="brand" items="${brands}">
                                        <option data-brand-id=${brand.id} data-brand-name=${brand.name}
                                                data-brand-image=${brand.brandImage}>${brand.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Category</label>
                            <div class="col-sm-10">
                                <select id="cat-select" class="form-control m-bot15">
                                    <c:forEach var="category" items="${categories}">
                                        <option data-category-id=${category.id} data-category-name=${category.name}
                                                data-category-image=${category.imageUrl} data-category-products='${category.products}'>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group ">
                            <label for="description" class="control-label col-lg-2">Description</label>
                            <div class="col-lg-10">
                                <textarea class="form-control " id="description" name="comment" required></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button id="btn-save-product" class="btn btn-primary">Save</button>
                                <button id="btn-cancel-product" class="btn btn-default" type="button">Cancel
                                </button>
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
                       href="#collapse1">
                        <i class="fa fa-plus-square-o"></i> Add new product parameter
                    </a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-param" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Product<span
                                    class="required">*</span></label>
                            <select id="paramProductSelect">
                                <option selected disabled>Select product</option>
                                <c:forEach var="product" items="${allProducts}">
                                    <option class="paramOptionClass" data-id=${product.id}>${product.id}|${product.name}|${product.model}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div id="paramForm" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Quantity</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="quantity">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Size</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="size">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Weight</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="weight">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button id="btn-add-param" class="btn btn-primary">Add</button>
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
                       href="#collapseTwo">
                        <i class="fa fa-plus-square-o"></i> Add category
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-category" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Name<span
                                    class="required">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Image url</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="imageUrl">
                            </div>
                        </div>
                        <div class="col-lg-offset-2 col-lg-10">
                            <button id="btn-save-category" class="btn btn-primary">Save</button>
                            <button id="btn-cancel-category" class="btn btn-default" type="button">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        <i class="fa fa-plus-square-o"></i> Edit category
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-edit-category" class="form-horizontal">
                        <div id="cat-ed-div" class="form-group">
                            <label class="col-sm-2 control-label">Category</label>
                            <div id="sel-div" class="col-sm-10">
                                <select id="cat-edit-select" class="form-control m-bot15">
                                    <c:forEach var="category" items="${categories}">
                                        <option data-category-id=${category.id} data-category-name=${category.name}
                                                data-category-image='${category.imageUrl}'
                                                data-category-products='${category.products}'>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button id="btn-edit-category" class="btn btn-primary">Edit</button>
                                <button id="btn-update-category" disabled="true" class="btn btn-primary">Update
                                </button>
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
                       href="#collapseFour">
                        <i class="fa fa-plus-square-o"></i> Add brand
                    </a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse">
                <div class="panel-body">
                    <div id="form-brand" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Name<span
                                    class="required">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Image url</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="brandImage">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button id="btn-save-brand" class="btn btn-primary">Save</button>
                                <button id="btn-cancel-brand" class="btn btn-default" type="button">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/admin_products.js"></script>