<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/userEnd/css/bootstrap-datepicker.min.css">


<jsp:include page="../Paitent/pHeader.jsp"/>
<style>
    .errors{
        color: red;
    }
</style>

<script type="text/javascript">
    $('.datepicker').datepicker({
        format: 'mm/dd/yyyy',
        startDate: '-3d'
    });
</script>

    <div class="content-wrapper" style="min-height: 294px;">
        <!-- Content Header (Page header) -->

        <section class="login-register sec-padding">
            <div class="container" style="border: 1px solid dimgrey">

                <h2>Register your Appointment!</h2>

                <div class="errors">${idmessage}</div>
                <div class="errors">${timemessage}</div>
                <form:form method="post" action="/appointments/${id}" modelAttribute="appointment">

<h5>Doctor Information</h5>
                    <div class="row" >
                        <label class="col-sm-2">Department :</label>
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                            <form:select class="form-control" path="department" id="department_id">
                                <form:option value=""/>
                                <form:option value="Anesthesiology"/>
                                <form:option value="Laboratory Services"/>
                                <form:option value="Cardiothoracic and Vascular Surgery"/>
                                <form:option value="General Surgery, Digestive Diseases & Laparoscopic Surgery"/>
                                <form:option value="Urology and Kidney Transplant Surgery"/>
                                <form:option value="ENT and Head Neck Surgery"/>
                                <form:option value="Department of Neuro Sciences"/>
                                <form:option value="Orthopedics and Traumatology"/>
                            </form:select>
                            </div>
                        </div>
                        <div class="col-sm-6"><form:errors path="department" cssClass="errors"/> </div>
                    </div>
                    <div class="row" >
                        <label class="col-sm-2">Doctor :</label>
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                            <form:select class="form-control" id="doctors_id" path="doctor">

                                <c:forEach var="doctors" items="${doctors}">
                                    <option>Dr.${doctors.dname}(${doctors.dtype})</option>
                                </c:forEach>

                            </form:select>
                            </div>
                        </div>
                        <div class="col-sm-6"><form:errors path="doctor" cssClass="errors"/> </div>
                    </div>

                    <h5>Schedule Information</h5>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                                <label>Appointment date</label>
                                <form:input path="date" class="datepicker" data-date-format="mm/dd/yyyy"/>
                                <%--<form:input placeholder="mm/DD/yyyy" path="date" class="form-control" id="datepicker"/>--%>
                                <form:errors path="date" cssClass="errors"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group appointment-group">

                                <label>Time*</label>
                                <div class="row"><b>HH</b> <b style="margin-left: 61px;">MM</b></div>
                                <div class="row">
                                    <form:select path="time" cssStyle="width: 34%; border-radius: 5px;">
                                        <form:option value="10"/>
                                        <form:option value="11"/>
                                        <form:option value="12"/>
                                        <form:option value="13"/>
                                        <form:option value="14"/>
                                        <form:option value="15"/>
                                    </form:select>
                                    <b>:</b>
                                    <form:select path="timeMM" cssStyle="width: 34%; border-radius: 5px;">
                                        <form:option value="00"/>
                                        <form:option value="20"/>
                                        <form:option value="40"/>
                                        <form:option value="60"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <label class="col-sm-2">Your details :</label>
                        <div class="col-sm-4">
                            <form:textarea class="form-control" rows="5" path="details" placeholder="About You!" cssStyle="width: 40%;"></form:textarea>
                        </div>
                        <div class="col-sm-6"><form:errors path="details" cssClass="errors"/> </div>
                    </div>
                    <div class="row" style="margin-left: 10px;margin-bottom: 10px;">
                        <input type="submit" class="btn btn-success" value="REQUEST FOR AN APPOINTMENT"/>

                    </div>



                </form:form>
            </div>
        </section>


    </div>



 <jsp:include page="../Paitent/pFooter.jsp"/>