<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">User datails </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <sec:authorize access="hasRole('ADMIN')">
                <th>NickName</th>
                </sec:authorize>
                <th>Birth Day</th>
                <th>Phone Number</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <sec:authorize access="hasRole('ADMIN')">
                <td>${user.ssoId}</td>
                </sec:authorize>
                <td>${user.birthDate}</td>
                <td>${user.phoneNumber}</td>
                <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                    <td><a href="<c:url value='/edit-details-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
                </sec:authorize>
            </tr>
            </tbody>
        </table>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
        <div class="well">
            <a href="<c:url value='/newuser' />">Add New User</a>
        </div>
    </sec:authorize>

</div>