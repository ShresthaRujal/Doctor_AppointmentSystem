<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="/resources/local/css/datepicker.css" type="text/css" media="all">

<jsp:include page="../header.jsp"/>

<header id="header">
    <div class="container">

        <!-- Website Logo -->
        <div class="logo clearfix">
            <a href="home.html">
                <%--<img width="180" height="80" src="${pageContext.request.contextPath}/resources/image/${user.image}" alt=""/>--%>
                <img src="/resources/local/images/temp-images/logo-two.png" height="80" width="180" alt="">${user.name}
            </a>
        </div>

        <!-- Main Navigation -->
        <nav class="main-menu">
            <ul class="header-nav clearfix" id="menu-main-menu">
                <li class="current-menu-item page_item">
                    <a href="${pageContext.request.contextPath}/">Home</a>
                    <ul>
                        <li><a href="homeblog.html">HomeBlog</a></li>
                        <li><a href="hospitalblog.html">HospitalBlog</a></li>

                    </ul>
                </li>
                <li>
                    <a href="doctors.html">Doctors</a>
                    <ul>
                        <li>
                            <a href="regular.html">Permanenet</a>
                        </li>
                        <li>
                            <a href="weekly.html">Trainee</a>
                        </li>
                        <li>
                            <a href="monthly.html">Visiting</a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="gallery.html">Gallery</a>
                    <ul>
                        <li>
                            <a href="galleryd.html">Doctors Gallery</a>
                        </li>
                        <li>
                            <a href="galleryp.html">Patients Gallery</a>
                        </li>
                        <li>
                            <a href="gallerys.html">Staff Gallery</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/patientLogin">Login</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/contect">Contact</a>
                </li>
            </ul>
        </nav>
        <div id="responsive-menu-container"></div>
    </div>
</header>
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
<div class="container-fluid" style="border: 1px solid dimgrey;">
    <form:form action="/patients/regPatient" modelAttribute="patientRegDto" method="post">

        <div class="row" style="margin-top: 10px;">
            <div class="col-md-2">
            <label>Name :</label>
            </div>
            <div class="col-md-3">
            <form:input path="name" placeholder="your name!"/>
            </div>
            <div class="col-md-7">
                <form:errors path="name" cssClass="errors"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <label>Email :</label>
            </div>
            <div class="col-md-3">
                <form:input path="email" placeholder="john@xyz.com"/>
            </div>
            <div class="col-md-7">
                <form:errors path="email" cssClass="errors"/>
            </div>
        </div>

            <div class="row">
                <div class="col-md-2">
                    <label>Date of Birth</label>
                </div>
                <div class='col-sm-3'>
                    <form:input placeholder="mm/DD/yyyy" path="date" class="form-control" id="datepicker"/>
                </div>

            </div>


        <div class="row" style="margin-bottom: 20px;">
            <div class="col-md-2">
                <label>Gender</label>
            </div>
            <div class="col-md-3">
                <form:radiobutton path="sex" value="Male"/>Male
                <form:radiobutton path="sex" value="Female"/>Female<br/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <label>Address :</label>
            </div>
            <div class="col-md-3">
                <form:input path="address" placeholder="Address"/>
            </div>
            <div class="col-md-7">
                <form:errors path="address" cssClass="errors"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <label>Contact :</label>
            </div>
            <div class="col-md-3">
                <form:input type="number" path="contact" placeholder="phone number!"/>
            </div>
            <div class="col-md-7">
                <form:errors path="contact" cssClass="errors"/>
            </div>
        </div>



        <div class="row">
            <div class="col-md-2">
                <label>Password :</label>
            </div>
            <div class="col-md-3">
                <form:password path="password" placeholder="Password!"/>
            </div>
            <div class="col-md-7">
                <form:errors path="password" cssClass="errors"/>
            </div>
        </div>
        <div class="row">
            <input type="submit" value="register" style="margin-left: 10px; margin-bottom: 20px;"/>
        </div>
    </form:form>
</div>
<jsp:include page="../footer.jsp"/>