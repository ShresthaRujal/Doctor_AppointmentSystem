<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 6/4/2017
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../header.jsp"/>
<style>
    * {
        box-sizing: border-box;
    }

    #myInput {
        background-image: url('/css/searchicon.png');
        background-position: 10px 10px;
        background-repeat: no-repeat;
        width: 100%;
        font-size: 16px;
        padding: 12px 20px 12px 40px;
        border: 1px solid #ddd;
        margin-bottom: 12px;
    }

    #myTable {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #ddd;
        font-size: 18px;
    }

    #myTable th, #myTable td {
        text-align: left;
        padding: 12px;
    }

    #myTable tr {
        border-bottom: 1px solid #ddd;
    }

    #myTable tr.header, #myTable tr:hover {
        background-color: #f1f1f1;
    }
</style>
<div class="container" style="margin-left: 40%;">
<c:set var="message" value="${successMessage}"/>
    <c:choose>
        <c:when test="${message=='success'}">
            <script type="text/javascript">
                alert("Your Profile is Updated!");
            </script>
        </c:when>
    </c:choose>

    <header>
        <h1>Your Profile</h1>
    </header>

    <div class="col-sm-3" style="margin-bottom: 10px;">
        <%--<img align="center" width="180" height="80" src="/resources/image/${user.image}" alt=""/>--%>
        <img align="center" style="width: 155px;height: 160px;" src="/resources/local/images/active-slide-arrow.png" alt=""/>
        <h3>Detail :</h3>
            <ul>
                <li><u>${doctor.did}</u></li>
                <li><u>Dr.${doctor.dname}</u></li>
                <li><u>${doctor.dtype}</u></li>
                <li><u>${doctor.dphone}</u></li>
        </ul>
        <a href="/updateDoc">Edit</a>
    </div>
</div>
<jsp:include page="../footer.jsp"/>