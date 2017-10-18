<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/local/css/datepicker.css" type="text/css" media="all">
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 8/23/2017
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../header.jsp"/>
<style>
    .errors{
        color: red;
    }
</style>
<script>

    $( function() {
        $( "#datepicker" ).datepicker();
    } );

</script>
<div class="col-md-9 contents-left" style="background-color: #ffffff; width: 100%;">
    <div class="contents-left-blocks clearfix">
        <h1>APPOINTMENT</h1>
        ${popUP}

        <div class="appointment-form clearfix">
            <form:form method="post" action="/appointment/${id}" modelAttribute="appointment">
                    <h5>Doctors Information</h5>
                    <div class="row">
                        <div class="col-sm-4">
                                <label>Departments</label>
                                <form:select class="form-control" path="department" id="department_id">
                                    <form:option value="Select Departments"/>
                                    <form:option value="Anesthesiology"/>
                                    <form:option value="Laboratory Services"/>
                                    <form:option value="Cardiothoracic & Vascular Surgery"/>
                                    <form:option value="General Surgery, Digestive Diseases & Laparoscopic Surgery"/>
                                    <form:option value="Urology & Kidney Transplant Surgery"/>
                                    <form:option value="ENT & Head Neck Surgery"/>
                                    <form:option value="Department of Neuro Sciences"/>
                                    <form:option value="Orthopedics & Traumatology"/>
                                    </form:select>
                            </div>
                            <div class="col-sm-4">
                                <form:errors path="department" cssClass="errors"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                            <label>Doctors</label>
                                <form:select class="form-control" id="doctors_id" path="doctor">

                                    <option>Any</option>
                                    <c:forEach var="doctors" items="${doctors}">
                                    <option>Dr.${doctors.dname}(${doctors.dtype})</option>
                                    </c:forEach>

                                </form:select>
                            </div>
                        </div>
                    </div>


                    <h5>Patient Information</h5>

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                                <label>Hospital Ip No.</label>
                                <form:input type="text" class="form-control" path="id" placeholder="Id"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                                <form:errors path="id" cssClass="errors"/>
                            </div>
                        </div>
                    </div>

                <div class="form-block no-margin-bottom clearfix">
                    <h5>Schedule Information</h5>

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group appointment-group">
                                <label>Appointment date</label>
                                <form:input placeholder="mm/DD/yyyy" path="date" class="form-control" id="datepicker"/>
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

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group appointment-group">
                                <label>Your Details* </label>
                                <form:textarea class="form-control" rows="5" path="details" placeholder="About You!" cssStyle="width: 40%;"></form:textarea>

                                <input type="submit" class="btn btn-success" value="REQUEST FOR AN APPOINTMENT"/>

                            </div>
                        </div>
                    </div>


                </div>


            </form:form>
        </div>
        <!-- end of appointment-form -->


    </div>
    <!-- end of contents-left-blocks -->
</div>


<script type='text/javascript' src='/resources/local/js/jquery.ui.core.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.ui.datepicker.min.js'></script>
<jsp:include page="../footer.jsp"/>
