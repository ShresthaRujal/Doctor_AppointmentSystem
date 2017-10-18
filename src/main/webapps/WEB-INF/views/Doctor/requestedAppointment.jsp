<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="DHeader.jsp"/>
    <aside class="main-sidebar" style="background-color: darkgreen;">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img class="img-circle" alt="User Image" src="/resources/dist/img/user2-160x160.jpg">
                </div>
                <div class="pull-left info">
                    <p></p>
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
                <li><a href="/doctors/${doctor.did}"><i class="fa fa-link"></i> <span>My Profile</span></a></li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>Apponintment</span>
                        <span class="pull-right-container">
<i class="fa fa-angle-left pull-right"></i>
</span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/doctors/appointment/approved/${doctor.did}">Approved</a></li>
                        <li><a href="/doctors/appointment/requested/${doctor.did}">Requested</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>


    <div class="content-wrapper" style="min-height: 294px;">

        <header>
            <h1>Appointment list :</h1>
        </header>
        <!-- Content Header (Page header) -->


        <section>
            <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Appointment Request.</h3>

                    <div class="box-tools">
                        <div class="input-group input-group-sm" style="width: 150px;">
                            <input name="table_search" class="form-control pull-right" type="text" placeholder="Search">

                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <th>ID</th>
                            <th>User</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Reason</th>
                            <th>Approve</th>
                        </tr>
                        <c:forEach items="${appointments}" var="appointment">
                        <tr>
                            <td>${appointment.id}</td>
                            <td>${appointment.name}</td>
                            <td>${appointment.date}</td>
                            <td><span class="label label-success">${appointment.time}:${appointment.timeMM}</span></td>
                            <td>${appointment.details}</td>
                            <td>
                                <a href="/doctorAppointments/${id}/doctorAppointmentsApproval/${appointment.id}?value=1" style="text-decoration: none;" class="btn btn-warning">${appointment.status}</a>
                            </td>

                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
            </div>
        </section>
        <!-- Main content -->
        <section class="content">

            <!-- Your Page Content Here -->

        </section>
        <!-- /.content -->
    </div>


   <jsp:include page="DFooter.jsp"/>