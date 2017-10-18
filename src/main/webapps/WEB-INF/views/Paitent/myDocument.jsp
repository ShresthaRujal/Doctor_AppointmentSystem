<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="pHeader.jsp"/>
<%String token= (String) request.getAttribute("tokan");
    session.setAttribute("token",token);%>

    <div class="content-wrapper" style="min-height: 500px;">
        <!-- Content Header (Page header) -->
        <%--<section class="content-header">--%>

               <form method="post" action="/patients/document/${id}" enctype="multipart/form-data">
                   <div class="row">
                   <input type="file" name="document" multiple="multiple">
                   <input type="submit" value="button">
                       <hr style="border-width:4px; border-color: #60646d;">
                   </div>
               </form>
            <div>
                <c:forEach var="document" items="${file}">
                    <div id="div1" class="col-sm-6">
                        <img class="w3-circle" width="200px" height="200px" src="${pageContext.request.contextPath}/resources/image/${document}" id="myId"/>
                    </div>
                </c:forEach>
            </div>
        <%--</section>--%>

        <!-- Main content -->
        <%--<section class="content">--%>

            <%--<!-- Your Page Content Here -->--%>

        <%--</section>--%>
        <!-- /.content -->
    </div>


    <!-- Main Footer -->


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

<jsp:include page="pFooter.jsp"/>