<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 9/4/2017
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="/WEB-INF/views/header.jsp"/>

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
                    <a href="#">Home</a>
                    <ul>
                        <li><a href="#">HomeBlog</a></li>
                        <li><a href="#">HospitalBlog</a></li>

                    </ul>
                </li>
                <li>
                    <a href="#">Doctors</a>
                    <ul>
                        <li>
                            <a href="#">Permanenet</a>
                        </li>
                        <li>
                            <a href="#">Trainee</a>
                        </li>
                        <li>
                            <a href="#">Visiting</a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="#">Gallery</a>
                    <ul>
                        <li>
                            <a href="#">Doctors Gallery</a>
                        </li>
                        <li>
                            <a href="#">Patients Gallery</a>
                        </li>
                        <li>
                            <a href="#">Staff Gallery</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/patients/login">Login</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </nav>
        <div id="responsive-menu-container"></div>
    </div>
</header>
<script>
    ${recoverymsg}
</script>
<section class="login-register sec-padding">
    <div class="container">
        <h5><p>We will send you an email for your password recovery!!</p></h5>

        <div class="col-md-6" style="border: 1px solid dimgrey; margin-top:15px; margin-bottom: 15px; margin-left: 25%; ">
            <div class="sec-title">
                <h2>Forgot Password!!</h2>
            </div>
            <form:form method="post" action="/password/recover" id="contact-form login" modelAttribute="forgotPassDto">

                <div class="row" >
                    <label class="col-sm-2">Email :</label>
                    <div class="col-sm-6">
                        <form:input path="email" id="test" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="email" cssClass="error" placeholder="john@gmail.com"/> </div>
                </div>
                <div class="row" style="margin-left: 5px; margin-bottom: 5px    ">
                    <input type="submit" class="thm-btn" value="Submit">
                </div>
            </form:form>
            </div>

</section>
<jsp:include page="/WEB-INF/views/footer.jsp"/>