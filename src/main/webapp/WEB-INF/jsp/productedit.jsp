<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="wrapper">
    <div class="container">
        <div class="col-md-12 headlines">
            <h2>EDIT<span class="color-bg">PRODUCT</span></h2>
        </div>

        <div class="col-md-12">
            <table class="table table-bordered table-striped table-advance table-hover">
                <tbody>
                <tr>
                    <th>PRODUCT NAME</th>
                    <td>
                        <input class="form-control" type="text" name="name" value="${product.name}">
                    </td>
                </tr>
                <tr>
                    <th>MODEL</th>
                    <td>
                        <input class="form-control" type="text" name="model" value="${product.model}">
                    </td>
                </tr>
                <tr>
                    <th>BRAND</th>
                    <td>
                        <input class="form-control" type="text" name="brand" disabled="disabled" value="${product.brand}">
                    </td>
                </tr>
                <tr>
                    <th>COLOR</th>
                    <td>
                        <input class="form-control" type="text" name="color" value="${product.color}">
                    </td>
                </tr>
                <tr>
                    <th>DESCRIPTION</th>
                    <td>
                        <textarea id="description" class="form-control" type="text">${product.description}</textarea>
                    </td>
                </tr>
                <tr>
                    <th>PRICE</th>
                    <td>
                        <input class="form-control" type="text" name="price" value="${product.price}">
                    </td>
                </tr>
                <tr>
                    <th>CATEGORY</th>
                    <td>
                        <input class="form-control" type="text" name="category" disabled="disabled" value="${product.category}">
                    </td>
                </tr>
                <tr>
                    <th>IMAGES</th>
                    <td>
                        <c:forEach var="pic" items="${product.images}">
                            <input id="image${product.id}" class="pic" type="image" name="image"
                                   src="${pic.url}" width="200">
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>PARAMETERS</th>
                    <td>
                        <c:forEach var="parameter" items="${product.parameters}">
                            <table id="par${parameter.id}" class="table table-bordered table-striped table-advance table-hover">
                                <tr>
                                    <th>ID</th>
                                    <td><input class="form-control paramId" type="number" disabled="disabled" name="size" value="${parameter.id}"></td>
                                    <th>Size</th>
                                    <td><input class="form-control" disabled="disabled" type="text" name="size" value="${parameter.size}">
                                    </td>
                                    <th>Weight</th>
                                    <td><input class="form-control" type="text" name="weight"
                                               value="${parameter.weight}"></td>
                                    <th>Quantity</th>
                                    <td><input class="form-control paramQuantity" type="text" name="quantity"
                                               value="${parameter.quantity}"></td>
                                </tr>
                            </table>
                        </c:forEach>

                    </td>
                </tr>
                <td><a id="updateProduct" data-id="${product.id}" href="#"
                       class="welcome-button-2 hvr-shutter-in-horizontal-2">SAVE</a></td>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript" src="/resources/productedit.js"></script>
</div>