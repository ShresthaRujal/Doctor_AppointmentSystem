<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    ${notify}
</script>

<%String token= (String) request.getAttribute("tokan");
    session.setAttribute("token",token);%>
<div class="container">
    <h3 class="error"><u>${message}</u></h3>
</div>
<section class="login-register sec-padding">
    <div class="container">

        <div class="col-md-6" style="border: 1px solid dimgrey">
            <div class="sec-title">
                <h2>Login</h2>
            </div>
            <div class="error">${idmessage}</div>

            <form:form method="post" action="/doctors/login" id="contact-form login" modelAttribute="doctorLoginDto">
                <div class="row" >
                    <label class="col-sm-2">ID :</label>
                    <div class="col-sm-6">
                        <form:input path="id" id="test" cssClass="form-control" onfocus="true"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="" cssClass="error" placeholder=""/> </div>
                </div>
                <div class="row">
                    <label class="col-sm-2">Password :</label>
                    <div class="col-sm-6">
                        <form:password path="pass" id="test" class="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="pass" cssClass="error"/> </div>
                </div>
                <div class="row" style="margin-left: 5px; margin-bottom: 5px    ">
                    <input type="submit" class="thm-btn" value="Login now">
                    <a href="#" style="margin-left: 125px;"><i>Forgot Password!</i></a>

                </div>


            </form:form>
        </div>
        </div>
    </div>

</section>
<jsp:include page="../footer.jsp"/>