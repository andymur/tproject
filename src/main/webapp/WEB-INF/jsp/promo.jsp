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
                        <label class="col-sm-2 control-label">Product Id<span
                                class="required">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="productId" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Name<span
                                class="required">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Price<span
                                class="required">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="price" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Image Url<span
                                class="required">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="imageurl" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button id="btn-add-promo" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>