<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="generic-container">
    <form:form method="POST" modelAttribute="user" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

            <div class="rows">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="ssoId">Nickname</label>
                    <div class="col-md-7">
                        <c:choose>
                            <c:when test="${edit}">
                                <sec:authorize access="hasRole('ADMIN')">
                                <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm"
                                            disabled="true"/>
                                </sec:authorize>
                            </c:when>
                            <c:otherwise>
                                <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="ssoId" class="help-inline"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Birth Date</label>
                <div class="col-md-7">
                    <form:input type="text" path="birthDate" id="birthDate" class="form-control input-sm datepicker"/>
                    <div class="has-error">
                        <form:errors path="birthDate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="rows">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Phone Number</label>
                <div class="col-md-7">
                    <form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="phoneNumber" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
            <div class="rows">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="role">Roles</label>
                    <div class="col-md-7">
                        <form:select path="role" items="${userrole}" multiple="true" itemValue="id" itemLabel="type"
                                     class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="role" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="rows">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="role">Roles</label>
                    <div class="col-md-7">
                        <form:select path="role" items="${roles}" multiple="true" itemValue="id" itemLabel="type"
                                     class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="role" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
        </sec:authorize>
        <div class="rows">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>