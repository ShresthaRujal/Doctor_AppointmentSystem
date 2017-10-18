<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 8/29/2017
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="pHeader.jsp"/>
<%--<div class="col-sm-6" >--%>
<%--<img src="${pageContext.request.contextPath}/resources/image/${patient.pp}" style="margin-left: 640px; width: 240px;"/>--%>
<%--</div>--%>
<%--<div>--%>

<%--</div>--%>
<div class="content-wrapper" style="min-height: 294px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
<div class="container">
        <img class="img-responsive" src="${pageContext.request.contextPath}/resources/image/${patient.pp}" alt="Chania" width="345" height="345">
</div>



        <div class="row container-fluid">
            <table>
                <tr>
                    <td>
                        <b>Id</b>
                    </td><td style="margin-left: 5px;"><b>:</b></td>
                    <td style="margin-left: 5px;">${patient.id}</td>
                </tr>
                <tr>
                    <td>
                        <b>Name</b>
                    </td><td style="margin-left: 5px;"><b> : </b></td>
                    <td style="margin-left: 5px;">${patient.name}</td>
                </tr>
                <tr>
                    <td>
                        <b>Email</b>
                    </td><td style="margin-left: 5px;"><b> : </b></td>
                    <td style="margin-left: 5px;">${patient.email}</td>
                </tr>
                <tr>
                    <td>
                        <b>Gender</b>
                    </td><td style="margin-left: 5px;"><b> : </b></td>
                    <td style="margin-left: 5px;">${patient.sex}</td>
                </tr>
                <tr>
                    <td>
                        <b>Date</b>
                    </td><td style="margin-left: 5px;"><b> : </b></td>
                    <td style="margin-left: 5px;">${patient.date}</td>
                </tr>

                <tr>
                    <td>
                        <b>Address</b>
                    </td><td style="margin-left: 5px;"><b> : </b></td>
                    <td style="margin-left: 5px;">${patient.address}</td>
                </tr>
                <tr>
                    <td>
                        <b>Contact</b>
                    </td><td style="margin-left: 5px;"><b> :</b></td>
                    <td style="margin-left: 5px;">${patient.contact}</td>
                </tr>

</table>
        </div>
    </section>

    <!-- Main content -->
    <section class="content">

        <!-- Your Page Content Here -->

    </section>
<jsp:include page="pFooter.jsp"/>