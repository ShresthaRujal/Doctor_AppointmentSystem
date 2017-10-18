<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 9/5/2017
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
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
<section class="login-register sec-padding">
    <div class="container">
        <h5><p>We will send you an email for your password recovery!!</p></h5>
        <h3>${passmessage}</h3>
        <div class="col-md-6" style="border: 1px solid dimgrey; margin-top:15px; margin-bottom: 15px; margin-left: 25%; ">
            <div class="sec-title">
                <h2>Enter new Password!!</h2>
            </div>
            <form:form method="post" action="/newPass/${id}" id="contact-form login" modelAttribute="newPassDto">

                <div class="row" >
                    <label class="col-sm-2">New Password :</label>
                    <div class="col-sm-6">
                        <form:input path="password" id="test" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="password" cssClass="error" /> </div>
                </div>


                <div class="row" >
                    <label class="col-sm-2">Confirm Password :</label>
                    <div class="col-sm-6">
                        <form:input path="passwordagain" id="test" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="passwordagain" cssClass="error" /> </div>
                </div>

                <div class="row" style="margin-left: 5px; margin-bottom: 5px    ">
                    <input type="submit" class="thm-btn" value="Submit">
                </div>
            </form:form>
        </div>

</section>
<jsp:include page="../footer.jsp"/>