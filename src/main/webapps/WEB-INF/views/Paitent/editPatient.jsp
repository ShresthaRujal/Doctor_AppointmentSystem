<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/resources/local/css/datepicker.css" type="text/css" media="all">
<jsp:include page="../Paitent/pHeader.jsp"/>
<script>

    $( function() {
        $( "#datepicker" ).datepicker();
    } );

</script>
<style>
    .errors{
        color: red;
    }
</style>

<div class="content-wrapper" style="min-height: 294px;">
    <!-- Content Header (Page header) -->

    <section class="login-register sec-padding">
        <div class="container" style="border: 1px solid dimgrey">

            <h2>Edit your Profile!</h2>

            <form:form action="/patients/edit/${editPatientDto.id}" modelAttribute="editPatientDto" method="post">

                <div class="row" style="padding: 20px;">

                    <label class="col-sm-2">Name :</label>
                    <div class="form-group appointment-group">
                    <div class="col-md-3">
                        <form:input path="name" placeholder="your name!" cssClass="form-control"/>
                    </div>
                    </div>
                    <div class="col-md-7">
                        <form:errors path="name" cssClass="errors"/>
                    </div>
                </div>

                <div class="row" style="padding: 20px;">
                    <label class="col-sm-2">Email :</label>
                    <div class="form-group appointment-group">
                    <div class="col-md-3">
                        <form:input path="email" placeholder="john@xyz.com" cssClass="form-control"/>
                    </div>
                    </div>
                    <div class="col-md-7">
                        <form:errors path="email" cssClass="errors"/>
                    </div>
                </div>

                <div class="row" style="padding: 20px;">
                    <label class="col-sm-2">Date of Birth :</label>
                    <div class="form-group appointment-group">
                    <div class='col-sm-3'>
                        <form:input placeholder="mm/DD/yyyy" path="date" class="form-control" id="datepicker"/>
                    </div>
                    </div>
                </div>

                <div class="row" style="padding: 20px;">
                    <label class="col-sm-2">Address :</label>
                    <div class="form-group appointment-group">
                    <div class="col-md-3">
                        <form:input path="address" placeholder="Address" cssClass="form-control"/>
                    </div>
                    </div>
                    <div class="col-md-7">
                        <form:errors path="address" cssClass="errors"/>
                    </div>
                </div>

                <div class="row" style="padding: 20px;">
                    <label class="col-sm-2">Contact :</label>
                    <div class="form-group appointment-group">
                        <div class="col-md-3">
                        <form:input type="number" path="contact" placeholder="phone number!" cssClass="form-control"/>
                    </div>
                    </div>
                    <div class="col-md-7">
                        <form:errors path="contact" cssClass="errors"/>
                    </div>
                </div>


                <div class="row" style="padding: 20px;">
                    <input type="submit" value="Edit" style="margin-left: 10px; margin-bottom: 20px;"/>
                </div>
            </form:form>

        </div>
    </section>


</div>

<jsp:include page="../Paitent/pFooter.jsp"/>