<jsp:include page="DHeader.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
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
            <h1>Your Profile</h1>
        </header>
        <!-- Content Header (Page header) -->
        <section class="content-header">
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="container" style="margin-left: 40%;">



                <div class="col-sm-4" style="margin-bottom: 10px;">
                    <%--<img align="center" width="180" height="80" src="/resources/image/${user.image}" alt=""/>--%>
                    <%--<img align="center" style="width: 155px;height: 160px;" src="" alt=""/>--%>
                        <img class="w3-circle" width="200px" height="200px" src="${pageContext.request.contextPath}/resources/image/${doctor.pp}" id="myId"/>
                        <h3>Detail :</h3>

                    <b>Id  :</b><u>${doctor.did}</u><br/>
                    <b>Name:</b><u>Dr.${doctor.dname}</u><br/>
                    <b>Doctor:</b><u>${doctor.dtype}</u><br/>
                    <b>Contact:</b><u>${doctor.dphone}</u><br/>

                </div>
            </div>
            <!-- Your Page Content Here -->

        </section>
        <!-- /.content -->
    </div>


    <!-- Main Footer -->
   <jsp:include page="DFooter.jsp"/>