<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <!-- container section start -->
        <section id="container" class="">
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-file-text-o"></i>PRODUCTS MANAGEMENT</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Add product
                                </header>
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
                                                        <option data-brand-id=${brand.id} data-brand-name=${brand.name} data-brand-image=${brand.brandImage}>${brand.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Category</label>
                                            <div class="col-sm-10">
                                                <select id="cat-select" class="form-control m-bot15">
                                                    <c:forEach var="category" items="${categories}">
                                                        <option data-category-id=${category.id} data-category-name=${category.name} data-category-image=${category.categoryImage}>${category.name}</option>
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
                                                <button id="btn-cancel-product"class="btn btn-default" type="button">Cancel</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </section>
                            <section class="panel">
                                <header class="panel-heading">
                                    Add category
                                </header>
                                <div class="panel-body">
                                    <div id="form-category" class="form-horizontal " method="get">
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
                                                <input type="text" class="form-control" name="categoryimage">
                                            </div>
                                        </div>
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button id="btn-save-category" class="btn btn-primary">Save</button>
                                                <button id="btn-cancel-category" class="btn btn-default" type="button">Cancel</button>
                                            </div>
                                        </div>
                                    </div>
                            </section>
                            <section class="panel">
                                <div class="panel-body">
                                    <div class="form-horizontal " method="get">
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="inputSuccess">Add product</label>
                                            <div class="col-lg-10">
                                                <input class="form-control input-lg m-bot15" type="text"
                                                       placeholder=".input-lg">
                                                <input class="form-control m-bot15" type="text"
                                                       placeholder="Default input">
                                                <input class="form-control input-sm m-bot15" type="text"
                                                       placeholder=".input-sm">

                                                <select class="form-control input-lg m-bot15">
                                                    <option>Option 1</option>
                                                    <option>Option 2</option>
                                                    <option>Option 3</option>
                                                </select>
                                                <select class="form-control m-bot15">
                                                    <option>Option 1</option>
                                                    <option>Option 2</option>
                                                    <option>Option 3</option>
                                                </select>
                                                <select class="form-control input-sm m-bot15">
                                                    <option>Option 1</option>
                                                    <option>Option 2</option>
                                                    <option>Option 3</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                            <section class="panel">
                                <div class="panel-body">
                                    <form class="form-horizontal " method="get">
                                        <div class="form-group has-success">
                                            <label class="control-label col-lg-2" for="inputSuccess">Input with
                                                success</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="inputSuccess">
                                            </div>
                                        </div>
                                        <div class="form-group has-warning">
                                            <label class="control-label col-lg-2" for="inputWarning">Input with
                                                warning</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="inputWarning">
                                            </div>
                                        </div>
                                        <div class="form-group has-error">
                                            <label class="control-label col-lg-2" for="inputError">Input with
                                                error</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="inputError">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </section>
                            <section class="panel">
                                <div class="panel-body">
                                    <form class="form-horizontal " method="get">
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="inputSuccess">Checkboxes and
                                                radios</label>
                                            <div class="col-lg-10">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" value="">
                                                        Option one is this and that&mdash;be sure to include why it's
                                                        great
                                                    </label>
                                                </div>

                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" value="">
                                                        Option one is this and that&mdash;be sure to include why it's
                                                        great option one
                                                    </label>
                                                </div>

                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="optionsRadios" id="optionsRadios1"
                                                               value="option1" checked>
                                                        Option one is this and that&mdash;be sure to include why it's
                                                        great
                                                    </label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="optionsRadios" id="optionsRadios2"
                                                               value="option2">
                                                        Option two can be something else and selecting it will deselect
                                                        option one
                                                    </label>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="inputSuccess">Inline
                                                checkboxes</label>
                                            <div class="col-lg-10">
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
                                                </label>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="inputSuccess">Selects</label>
                                            <div class="col-lg-10">
                                                <select class="form-control m-bot15">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>

                                                <select multiple class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="inputSuccess">Column
                                                sizing</label>
                                            <div class="col-lg-10">
                                                <div class="row">
                                                    <div class="col-lg-2">
                                                        <input type="text" class="form-control" placeholder=".col-lg-2">
                                                    </div>
                                                    <div class="col-lg-3">
                                                        <input type="text" class="form-control" placeholder=".col-lg-3">
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <input type="text" class="form-control" placeholder=".col-lg-4">
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- Basic Forms & Horizontal Forms-->

                    <div class="row">
                        <div class="col-lg-6">
                            <section class="panel">
                                <header class="panel-heading">
                                    Basic Forms
                                </header>
                                <div class="panel-body">
                                    <form role="form">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Email address</label>
                                            <input type="email" class="form-control" id="exampleInputEmail1"
                                                   placeholder="Enter email">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Password</label>
                                            <input type="password" class="form-control" id="exampleInputPassword1"
                                                   placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile">File input</label>
                                            <input type="file" id="exampleInputFile">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Check me out
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>

                                </div>
                            </section>
                        </div>
                        <div class="col-lg-6">
                            <section class="panel">
                                <header class="panel-heading">
                                    Horizontal Forms
                                </header>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
                                            <div class="col-lg-10">
                                                <input type="email" class="form-control" id="inputEmail1"
                                                       placeholder="Email">
                                                <p class="help-block">Example block-level help text here.</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
                                            <div class="col-lg-10">
                                                <input type="password" class="form-control" id="inputPassword1"
                                                       placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox"> Remember me
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button type="submit" class="btn btn-danger">Sign in</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </section>
                            <section class="panel">

                                <div class="panel-body">
                                    <a href="#myModal" data-toggle="modal" class="btn btn-primary">
                                        Form in Modal
                                    </a>
                                    <a href="#myModal-1" data-toggle="modal" class="btn  btn-warning">
                                        Form in Modal 2
                                    </a>
                                    <a href="#myModal-2" data-toggle="modal" class="btn  btn-danger">
                                        Form in Modal 3
                                    </a>

                                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                         id="myModal" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button aria-hidden="true" data-dismiss="modal" class="close"
                                                            type="button">×
                                                    </button>
                                                    <h4 class="modal-title">Form Tittle</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <form role="form">
                                                        <div class="form-group">
                                                            <label for="exampleInputEmail1">Email address</label>
                                                            <input type="email" class="form-control"
                                                                   id="exampleInputEmail3" placeholder="Enter email">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleInputPassword1">Password</label>
                                                            <input type="password" class="form-control"
                                                                   id="exampleInputPassword3" placeholder="Password">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleInputFile">File input</label>
                                                            <input type="file" id="exampleInputFile3">
                                                            <p class="help-block">Example block-level help text
                                                                here.</p>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Check me out
                                                            </label>
                                                        </div>
                                                        <button type="submit" class="btn btn-primary">Submit</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                         id="myModal-1" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button aria-hidden="true" data-dismiss="modal" class="close"
                                                            type="button">×
                                                    </button>
                                                    <h4 class="modal-title">Form Tittle</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <form class="form-horizontal" role="form">
                                                        <div class="form-group">
                                                            <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
                                                            <div class="col-lg-10">
                                                                <input type="email" class="form-control"
                                                                       id="inputEmail4" placeholder="Email">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
                                                            <div class="col-lg-10">
                                                                <input type="password" class="form-control"
                                                                       id="inputPassword4" placeholder="Password">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-lg-offset-2 col-lg-10">
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox"> Remember me
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-lg-offset-2 col-lg-10">
                                                                <button type="submit" class="btn btn-info">Sign in
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </form>

                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                         id="myModal-2" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button aria-hidden="true" data-dismiss="modal" class="close"
                                                            type="button">×
                                                    </button>
                                                    <h4 class="modal-title">Form Tittle</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form class="form-inline" role="form">
                                                        <div class="form-group">
                                                            <label class="sr-only" for="exampleInputEmail2">Email
                                                                address</label>
                                                            <input type="email" class="form-control sm-input"
                                                                   id="exampleInputEmail5" placeholder="Enter email">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="sr-only"
                                                                   for="exampleInputPassword2">Password</label>
                                                            <input type="password" class="form-control sm-input"
                                                                   id="exampleInputPassword5" placeholder="Password">
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Remember me
                                                            </label>
                                                        </div>
                                                        <button type="submit" class="btn btn-success">Sign in</button>
                                                    </form>

                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- Inline form-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Inline form
                                </header>
                                <div class="panel-body">
                                    <form class="form-inline" role="form">
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                            <input type="email" class="form-control" id="exampleInputEmail2"
                                                   placeholder="Enter email">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputPassword2">Password</label>
                                            <input type="password" class="form-control" id="exampleInputPassword2"
                                                   placeholder="Password">
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Remember me
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Sign in</button>
                                    </form>

                                </div>
                            </section>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">

                            <div class="row">
                                <div class="col-lg-6">
                                    <section class="panel">
                                        <header class="panel-heading">
                                            Color Pickers & Date Pickers
                                        </header>
                                        <div class="panel-body">
                                            <form class="form-horizontal " action="#">
                                                <!--date picker start-->

                                                <div class="form-group">
                                                    <label class="control-label col-sm-4">Default Datepicker</label>
                                                    <div class="col-sm-6">
                                                        <input id="cp1" type="text" value="28-10-2013" size="16"
                                                               class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4">Starts with years view</label>
                                                    <div class="col-sm-6">


                                                        <div class="input-append date" id="dpYears"
                                                             data-date="18-06-2013"
                                                             data-date-format="dd-mm-yyyy" data-date-viewmode="years">
                                                            <input class="form-control" size="16" type="text"
                                                                   value="28-06-2013" readonly>
                                                            <span class="add-on"><i class="icon-calendar"></i></span>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-sm-4"> Date Ranges</label>
                                                    <div class="col-sm-6">
                                                        <div class="input-prepend">
                                                            <input id="reservation" type="text" class=" form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--date picker end-->

                                                <!--color picker start-->
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4">Default</label>

                                                    <div class="col-sm-5">
                                                        <input type="text" value="#CCCCCC" class="cp1 form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4">RGBA</label>

                                                    <div class="col-sm-5">
                                                        <input type="text" data-color-format="rgba"
                                                               value="rgb(255,255,255,1)" class="cp2 form-control">
                                                    </div>
                                                </div>

                                                <!--color picker end-->

                                            </form>


                                        </div>
                                    </section>
                                    <section class="panel">
                                        <header class="panel-heading">
                                            Tags Input
                                        </header>
                                        <div class="panel-body">
                                            <input name="tagsinput" id="tagsinput" class="tagsinput"
                                                   value="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal"/>
                                        </div>
                                    </section>
                                </div>
                                <div class="col-lg-6">
                                    <section class="panel">
                                        <header class="panel-heading">
                                            Custom Checkbox & Radio
                                        </header>
                                        <div class="panel-body">
                                            <form action="#" method="get" accept-charset="utf-8">
                                                <div class="checkboxes">
                                                    <label class="label_check" for="checkbox-01">
                                                        <input name="sample-checkbox-01" id="checkbox-01" value="1"
                                                               type="checkbox" checked/> I agree to the terms &#38;
                                                        conditions.
                                                    </label>
                                                    <label class="label_check" for="checkbox-02">
                                                        <input name="sample-checkbox-02" id="checkbox-02" value="1"
                                                               type="checkbox"/> Please send me regular updates.
                                                    </label>
                                                    <label class="label_check" for="checkbox-03">
                                                        <input name="sample-checkbox-02" id="checkbox-03" value="1"
                                                               type="checkbox"/> This is nice checkbox.</label>

                                                </div>
                                                <div class="radios">
                                                    <label class="label_radio" for="radio-01">
                                                        <input name="sample-radio" id="radio-01" value="1" type="radio"
                                                               checked/> This is option A...
                                                    </label>
                                                    <label class="label_radio" for="radio-02">
                                                        <input name="sample-radio" id="radio-02" value="1"
                                                               type="radio"/> and this is option B...
                                                    </label>
                                                    <label class="label_radio" for="radio-03">
                                                        <input name="sample-radio" id="radio-03" value="1"
                                                               type="radio"/> or simply choose option C
                                                    </label>
                                                </div>
                                            </form>
                                        </div>

                                    </section>

                                    <section class="panel">
                                        <header class="panel-heading">
                                            Switch
                                        </header>
                                        <div class="panel-body">
                                            <div class="row m-bot15">
                                                <div class="col-sm-6 text-center">
                                                    <input type="checkbox" checked="" data-toggle="switch"/>
                                                </div>
                                                <div class="col-sm-6 text-center">
                                                    <input type="checkbox" data-toggle="switch"/>
                                                </div>
                                            </div>
                                            <div class="row m-bot15">
                                                <div class="col-sm-6 text-center">
                                                    <div class="switch switch-square"
                                                         data-on-label="<i class=' icon-ok'></i>"
                                                         data-off-label="<i class='icon-remove'></i>">
                                                        <input type="checkbox"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6 text-center">
                                                    <div class="switch switch-square"
                                                         data-on-label="<i class=' icon-ok'></i>"
                                                         data-off-label="<i class='icon-remove'></i>">
                                                        <input type="checkbox" checked=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-6 text-center">
                                                    <input type="checkbox" disabled data-toggle="switch"/>
                                                </div>
                                                <div class="col-sm-6 text-center">
                                                    <input type="checkbox" checked disabled data-toggle="switch"/>
                                                </div>
                                            </div>
                                        </div>
                                    </section>


                                </div>
                            </div>

                            <div class="row">
                                <!-- Bootsrep Editor -->
                                <div class="col-lg-12">
                                    <section class="panel">
                                        <header class="panel-heading">
                                            Bootsrep Editor
                                        </header>
                                        <div class="panel-body">
                                            <div id="editor" class="btn-toolbar" data-role="editor-toolbar"
                                                 data-target="#editor"></div>
                                        </div>
                                    </section>
                                </div>
                                <!-- CKEditor -->
                                <div class="col-lg-12">
                                    <section class="panel">
                                        <header class="panel-heading">
                                            CKEditor
                                        </header>
                                        <div class="panel-body">
                                            <div class="form">
                                                <form action="#" class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-2">CKEditor</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control ckeditor" name="editor1"
                                                                      rows="6"></textarea>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
        </section>
        <script type="text/javascript" src="resources/admin_products.js"></script>
    </jsp:body>
</t:genericpage>
