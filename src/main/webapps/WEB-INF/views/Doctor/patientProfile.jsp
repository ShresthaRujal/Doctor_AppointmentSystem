<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 8/24/2017
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 6/11/2017
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<style type="text/css">
    #myId.fullscreen{
        z-index: 9999;
        margin-left: 360px;
        width: 75%;
        height: 100%;
        position: fixed;
        top:0;
        left:0;
    }
</style>
<jsp:include page="../header.jsp"/>

<div class="container">

    <header>
        <h1>${profile.name}'s Profile <button onclick="goBack()" style="margin-left: 1183px;" class="btn btn-success">Back</button></h1>

    </header>


    <div style="float: left; padding: 1em;max-width: 240px;">
        <p>height:160px  and width: 155 px</p>
        <%--<img align="center" width="180" height="80" src="${pageContext.request.contextPath}/resources/image/${user.image}" alt=""/>--%>
        <%--<img align="center" style="width: 155px; height: 160px;" src="${pageContext.request.contextPath}/resources/image/${patient.PProfile}" alt=""/>--%>
        <h3>Detail :</h3>
        <ul>
            <li><b>ID : </b>${profile.id}</li>
            <li><b>Name : </b>${profile.name}</li>
            <li><b>Email : </b>${profile.email}</li>
            <li><b>Appointment Time : </b>${profile.time}</li>
            <li><b>Contact : </b>${profile.contact}</li>
        </ul>

    </div>

    <article style="margin-left: 325px; border-left: 1px solid grey; padding: 1em;overflow: hidden;">
        <h1>${profile.name}'s Documents :</h1>
        <c:forEach items="${image}" var="images">
<div id="div1">
                <img id="myId" class="w3-circle" width="200px" height="200px" src="${pageContext.request.contextPath}/resources/image/${images}"/>
</div>
        </c:forEach>
    </article>



</div>

<script type="text/javascript">
    $('img').click(function (e) {
        $('#myId').toggleClass('fullscreen');
    });
</script>
<script type="text/javascript">
    function goBack() {
        window.history.back();
    }
</script>
<jsp:include page="../footer.jsp"/>

