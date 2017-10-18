<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Welcome ${patient.name}</title>
    <%--title--%>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap 3.3.6 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/style.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Ionicons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
    page. However, you can choose any other skin. Make sure you
    apply the skin class to the body tag so the changes take effect.
    -->
    <link href="/resources/dist/css/skins/skin-blue.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<link rel="stylesheet" href="/resources/local/css/datepicker.css" type="text/css" media="all">-->

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <script type="text/javascript">
        ${alert}
    </script>


    <%--window.localStorage.setItem('token', ${token});--%>
    <%--window.localStorage.getItem(token);--%>
    <%--<c:out value=></c:out>--%>
    <%--</script> <script>--%>

</head>

<body class="skin-blue sidebar-mini">

<div class="wrapper" style="background-color: whitesmoke;">

    <!-- Main Header -->
    <header class="main-header">
        <a class="sidebar-toggle" role="button" href="#" data-toggle="offcanvas">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <!-- Logo -->


        <form action="/chName" method="post">
            <!-- Header Navbar -->
            <nav class="navbar navbar-static-top" role="navigation" style="background-color: #60646d">
                <!-- Sidebar toggle button-->

                <label style="margin: 15px; color: white; font-size: 14px;">Welcome to E-health Management System </label>

                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Tasks Menu -->

                        <li class="dropdown tasks-menu">
                            <!-- Menu Toggle Button -->
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                                <i class="fa fa-flag-o"></i>
                                <span class="label label-danger">${size}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have ${size} schedule</li>
                                <li>
                                    <!-- Inner menu: contains the tasks -->
                                    <c:forEach items="${myappointments}" var="appointment">
                                    <ul class="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <!-- Task title and progress text -->
                                                <h3>
                                                    Appointment with :<br/> <i>${appointment.doctor}</i><br/></h3>
                                                    <h6>Date : ${appointment.date}</h6><br/>
                                                    <h6>Time : ${appointment.time}:${appointment.timeMM}</h6>

                                                <!-- The progress bar -->
                                                <div class="progress xs">
                                                    <!-- Change the css width attribute to simulate progress -->
                                                    <div class="progress-bar progress-bar-aqua" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <!-- end task item -->
                                    </ul>
                                    </c:forEach>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- User Account Menu -->
                        <li class="dropdown user user-menu">
                            <!-- Menu Toggle Button -->
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                                <!-- The user image in the navbar-->
                                <img class="user-image" alt="User Image" src="${pageContext.request.contextPath}/resources/image/${patient.pp}">
                                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                <span class="hidden-xs">${patient.name}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- The user image in the menu -->
                                <li class="user-header">
                                    <img class="img-circle" alt="User Image" src="${pageContext.request.contextPath}/resources/image/${patient.pp}">

                                    <p>
                                        ${patient.name} - ${patient.contact}
                                        <small>${patient.email}</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <%--<li class="user-body">--%>
                                <%--<div class="row">--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Followers</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Sales</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Friends</a>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--<!-- /.row -->--%>
                                <%--</li>--%>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a class="btn btn-default btn-flat" href="/patients/edit/${patient.id}">Edit Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a class="btn btn-default btn-flat" href="/patient/logout">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <!-- Control Sidebar Toggle Button -->
                        <li>
                            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </form>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar" style="background-color: grey;">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img class="img-circle" alt="User Image" src="${pageContext.request.contextPath}/resources/image/${patient.pp}">
                </div>
                <div class="pull-left info">
                    <p>${patient.name}</p>
                    <!-- Status -->

                </div>
            </div>

            <!-- search form (Optional) -->
            <form class="sidebar-form" action="#" method="get" style="background-color: whitesmoke;">
                <div class="input-group">
                    <input name="q" class="form-control" type="text" placeholder="Search..." style="margin-top: 8px;">
                    <span class="input-group-btn">
<button name="search" class="btn btn-flat" id="search-btn" type="submit"><i class="fa fa-search"></i>
</button>
</span>
                </div>
            </form>
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header" STYLE="background-color: grey;"></li>
                <!-- Optionally, you can add icons to the links -->
                <li class="active" ><a href="${pageContext.request.contextPath}/patients/${patient.id}"><i class="fa fa-link"></i> <span>My Profile</span></a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/appointments/${patient.id}"><i class="fa fa-link"></i> <span>Appointment</span></a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/patients/document/${patient.id}" ><i class="fa fa-link"></i> <span>My Document</span></a></li>
                <%--<li><a href="${pageContext.request.contextPath}/#"><i class="fa fa-link"></i> <span>Preview</span></a></li>--%>
                <%--<li class="treeview">--%>
                <%--<a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>--%>
                <%--<span class="pull-right-container">--%>
                <%--<i class="fa fa-angle-left pull-right"></i>--%>
                <%--</span>--%>
                <%--</a>--%>
                <%--<ul class="treeview-menu">--%>
                <%--<li><a href="#">Link in level 2</a></li>--%>
                <%--<li><a href="#">Link in level 2</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>
