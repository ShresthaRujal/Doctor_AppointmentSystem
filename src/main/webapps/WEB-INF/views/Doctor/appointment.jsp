<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 8/23/2017
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../header.jsp"/>
<script>
${notify}
</script>
<%String token= (String) request.getAttribute("tokan");
    session.setAttribute("token",token);%>

<section>
<div style="float: left; padding: 1em;max-width: 240px;">
    <%--<img align="center" width="180" height="80" src="${pageContext.request.contextPath}/resources/image/${user.image}" alt=""/>--%>
    <img align="center" style="width: 155px;height: 160px;" src="/resources/local/images/active-slide-arrow.png" alt=""/>
    <h3>Detail :</h3>
    <ul>
        <li><u>${doctor.did}</u></li>
        <li><u>Dr.${doctor.dname}</u></li>
        <li><u>${doctor.dtype}</u></li>
        <li><u>${doctor.dphone}</u></li>
    </ul>
    <%--<a href="${pageContext.request.contextPath}/updateDoc">Edit</a>--%>
</div>

<article style="margin-left: 325px; border-left: 1px solid grey; padding: 1em;overflow: hidden;">
    <h1>Todays Appointment list :</h1>
    <table border="1">
        <tr>
            <th>Appointment no :</th>
            <th>Name :</th>
            <th>Time : </th>
            <th>Date : </th>
            <%--<th>Checked ? </th>--%>
        </tr>

        <c:forEach items="${appointment}" var="appointment">

            <tr>
                <%--<td><a href="${pageContext.request.contextPath}/patient/viewProfile/${appointment.id}">${appointment.id}</a> </td>--%>
                <td><a href="${pageContext.request.contextPath}/patientProfile/${appointment.id}">${appointment.id}</a> </td>
                <td><a href="${pageContext.request.contextPath}/patientProfile/${appointment.id}">${appointment.name}</a> </td>
                <td><a href="${pageContext.request.contextPath}/patientProfile/${appointment.id}">${appointment.time}</a></td>
                <td><a href="${pageContext.request.contextPath}/patientProfile/${appointment.id}">${appointment.date}</a></td>

                    <%--<td align="center"><input type="checkbox" name="checked" onclick="<c:url value="/patient/delete?deleteid=${patients.PId}"/>"></td>--%>
            </tr>

        </c:forEach>



    </table>
</article>
</section>
<section style="margin-top: 168px;"></section>
<jsp:include page="../footer.jsp"/>
