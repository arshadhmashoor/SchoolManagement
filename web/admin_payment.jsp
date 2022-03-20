<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        if (session.getAttribute("userfullname") == null && session.getAttribute("usertype") == null) {
            response.sendRedirect("index.jsp");
        } else if (session.getAttribute("usertype").equals("admin")) {
            response.sendRedirect("admin.jsp");
        }

    %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Payments</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.blue.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body onload="load()">
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss"><i class="icon-close"></i></button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..." class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand --><a href="#" class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block"><span>School </span><strong> Management</strong></div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>SM</strong></div></a>
                                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

                                <!-- Languages dropdown    -->
                                <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><span class="d-none d-sm-inline-block"><i class="fa fa-user-circle"></i>  Profile</span></a>
                                    <ul aria-labelledby="languages" class="dropdown-menu">
                                        <li><a rel="nofollow" href="#" class="dropdown-item">${userfullname}</a></li>
                                        <li><a rel="nofollow" href="#" class="dropdown-item">${studentId}</a></li>
                                        <li><a rel="nofollow" href="index.jsp" class="dropdown-item">Logout  <i class="fa fa-sign-out"></i></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch"> 
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar"><img src="img/user.png" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="title">
                            <h1 class="h4">${userfullname}</h1>
                            <p>${studentId}</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
                    <ul class="list-unstyled">
                        <li><a href="admin_assignment.jsp"> <i class="icon-list"></i>Assignments </a></li>
                        <li><a href="admin_grade.jsp"> <i class="fa fa-cubes"></i>Grade </a></li>
                        <li class="active"><a href="admin_payment.jsp"> <i class="fa fa-money"></i>Payment </a></li>
                    </ul><span class="heading">${userfullname} - Profile</span>
                    <ul class="list-unstyled">
                        <li> <a href="admin_student_profile.jsp"> <i class="fa fa-user-circle-o"></i>Student Profile </a></li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">Payment Details</h2>
                        </div>
                    </header>
                    <section class="forms"> 
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-close">
                                            <div class="dropdown">
                                                <button type="button" id="closeCard3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                                                <div aria-labelledby="closeCard3" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                                            </div>
                                        </div>
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">All Payments</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">                       
                                                <table class="table table-striped table-hover" id="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Payment ID</th>
                                                            <th>Student ID</th>
                                                            <th>Payment Method</th>
                                                            <th>Amount</th>
                                                            <th>Date</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <!-- Basic Form-->

                                <!-- Horizontal Form-->
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <form class="form-horizontal" id="form">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Student ID</label>
                                                    <div class="col-sm-9">
                                                        <input id="paymentId" type="hidden" value="0" class="form-control form-control-success">
                                                        <input id="studentId" type="text" onkeypress="validateNumber()" placeholder="Student ID" class="form-control form-control-success">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Payment Method</label>
                                                    <div class="col-sm-9">
                                                        <select id="paymentMethod" class="form-control form-control-warning">
                                                            <option>Cash</option>
                                                            <option>Bank Deposit</option>
                                                            <option>Online Transfer</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Amount</label>
                                                    <div class="col-sm-9">
                                                        <input id="amount" type="text" onkeypress="validateNumber()" placeholder="Amount" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">       
                                                    <div class="col-sm-9 offset-sm-3">
                                                        <input type="button" onclick="save()" value="Save" class="btn btn-primary">
                                                        <input type="button" onclick="update()" value="Edit" class="btn btn-primary">
                                                        <input type="button" onclick="delet()" value="Delete" class="btn btn-dark">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </section>


                    <!-- Page Footer-->
                    <footer class="main-footer">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-6">
                                    <p>SLIIT &copy; 2020</p>
                                </div>
                                <div class="col-sm-6 text-right">
                                    <p>Design by <a href="#" class="external">ISP_2020_0017</a></p>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
        <script src="js/charts-home.js"></script>
        <script src="js/ajax.js" type="text/javascript"></script>
        <script src="js/sw.js" type="text/javascript"></script>
        <!-- Main File-->
        <script src="js/front.js"></script>
        <script>
                                                            selectedRowToInput();
                                                            function selectedRowToInput() {
                                                                var table = document.getElementById('table'), rIndex;
                                                                for (var i = 0; i < table.rows.length; i++) {
                                                                    table.rows[i].onclick = function () {
                                                                        rIndex = this.rowIndex;
                                                                        document.getElementById("paymentId").value = this.cells[1].textContent;
                                                                        document.getElementById("studentId").value = this.cells[2].textContent;
                                                                        document.getElementById("paymentMethod").value = this.cells[3].textContent;
                                                                        document.getElementById("amount").value = this.cells[4].textContent;
                                                                    }
                                                                    ;
                                                                }
                                                            }


                                                            function save() {
                                                                var userId = 1;
                                                                var paymentId = $('#paymentId').val();
                                                                var studentId = $('#studentId').val();
                                                                var paymentMethod = $('#paymentMethod').val();
                                                                var amount = $('#amount').val();
                                                                var action = "insert";
                                                                if (studentId === "" || paymentMethod === "" || amount === "" ) {
                                                                    swal("Fill form!", "Please Enter Details", "error");
                                                                }  else {
                                                                    $.ajax({
                                                                        url: 'PaymentServlet',
                                                                        method: 'POST',
                                                                        data: {userId: userId, action: action, paymentId: paymentId, studentId: studentId, paymentMethod: paymentMethod, amount: amount},
                                                                        success: function (resultText) {
                                                                            $("#table").find("tr:gt(0)").remove();
                                                                            load();
                                                                            swal("Success!", resultText, "success");
                                                                        },
                                                                        error: function (jqXHR, exception) {
                                                                            swal("fail");
                                                                        }
                                                                    });
                                                                }
                                                            }

                                                            function update() {
                                                                var userId = 1;
                                                                var paymentId = $('#paymentId').val();
                                                                var studentId = $('#studentId').val();
                                                                var paymentMethod = $('#paymentMethod').val();
                                                                var amount = $('#amount').val();
                                                                var action = "update";
                                                                paymentId = parseInt(paymentId);
                                                                if (paymentId === 0) {
                                                                    swal("Select", "Please Select To Update", "error");
                                                                } else if (studentId === "" || paymentMethod === "" || amount === "") {
                                                                    swal("Fill form!", "Please Enter Details", "error");
                                                                } else {

                                                                    $.ajax({
                                                                        url: 'PaymentServlet',
                                                                        method: 'POST',
                                                                        data: {userId: userId, action: action, paymentId: paymentId, studentId: studentId, paymentMethod: paymentMethod, amount: amount},
                                                                        success: function (resultText) {

                                                                            $("#table").find("tr:gt(0)").remove();
                                                                            load();
                                                                            swal("Success!", resultText, "success");
                                                                        },
                                                                        error: function (jqXHR, exception) {
                                                                            swal("fail");
                                                                        }
                                                                    });
                                                                }
                                                            }


                                                            function delet() {
                                                                var userId = 1;
                                                                var paymentId = $('#paymentId').val();
                                                                var action = "delete";
                                                                paymentId = parseInt(paymentId);
                                                                if (paymentId === 0) {
                                                                    swal("Select!", "Please Select To Delete", "error");
                                                                } else {

                                                                    swal({
                                                                        title: "Are you sure?",
                                                                        text: "Do you realy want to Delete this?",
                                                                        icon: "warning",
                                                                        buttons: true,
                                                                        dangerMode: true,
                                                                    })
                                                                            .then((willDelete) => {
                                                                                if (willDelete) {
                                                                                    $.ajax({
                                                                                        url: 'PaymentServlet',
                                                                                        method: 'POST',
                                                                                        data: {userId: userId, action: action, paymentId: paymentId},
                                                                                        success: function (resultText) {

                                                                                            //alert(resultText);

                                                                                            $("#table").find("tr:gt(0)").remove();
                                                                                            load();
                                                                                            swal("Poof! deleted!", {
                                                                                                icon: "success",
                                                                                            });
                                                                                        },
                                                                                        error: function (jqXHR, exception) {
                                                                                            swal("fail");
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    swal("safe!");
                                                                                }
                                                                            });
                                                                }

                                                            }

                                                            function load() {
                                                                var table = document.getElementById('table');
                                                                var action = "serch";
                                                                $.ajax({
                                                                    url: 'PaymentServlet',
                                                                    method: 'POST',
                                                                    data: {action: action},
                                                                    success: function (resultText) {

                                                                        resultText = resultText.replace("[", "");
                                                                        resultText = resultText.replace("]", "");
                                                                        var c = [];
                                                                        c = resultText;
                                                                        if (c.length > 5) {

                                                                            var step1 = [];
                                                                            var step2 = [];
                                                                            step1 = resultText.split("~");
                                                                            for (i = 0; i < step1.length; ++i) {
                                                                                step2 = step1[i].split("_");
                                                                                var newRow = table.insertRow(table.length),
                                                                                        cell1 = newRow.insertCell(0),
                                                                                        cell2 = newRow.insertCell(1),
                                                                                        cell3 = newRow.insertCell(2),
                                                                                        cell4 = newRow.insertCell(3),
                                                                                        cell5 = newRow.insertCell(4),
                                                                                        cell6 = newRow.insertCell(5);
                                                                                k = i + 1;
                                                                                cell1.innerHTML = k;
                                                                                cell2.innerHTML = step2[0];
                                                                                cell3.innerHTML = step2[1];
                                                                                cell4.innerHTML = step2[2];
                                                                                cell5.innerHTML = step2[3];
                                                                                cell6.innerHTML = step2[4];
                                                                                selectedRowToInput();
                                                                            }
                                                                        }

                                                                    },
                                                                    error: function (jqXHR, exception) {
                                                                        swal("fail");
                                                                    }
                                                                });
                                                                document.getElementById("form").reset();
                                                            }
                                                            


//table Search
                                                            $(document).ready(function () {
                                                                $("#serch_id").on("keyup", function () {
                                                                    var value = $(this).val().toLowerCase();
                                                                    $("#table tr").filter(function () {
                                                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                                                    });
                                                                });
                                                            });
//name validation
                                                            function validateName(evt) {
                                                                var theEvent = evt || window.event;
                                                                // Handle paste
                                                                if (theEvent.type === 'paste') {
                                                                    key = event.clipboardData.getData('text/plain');
                                                                } else {
                                                                    // Handle key press
                                                                    var key = theEvent.keyCode || theEvent.which;
                                                                    key = String.fromCharCode(key);
                                                                }
                                                                var regex = /^[a-zA-Z\s]+$/;
                                                                if (!regex.test(key)) {
                                                                    theEvent.returnValue = false;
                                                                    if (theEvent.preventDefault)
                                                                        theEvent.preventDefault();
                                                                }

                                                            }

//contact number validation
                                                            function contactValidation() {
                                                                var contactNo = $('#contactNo').val();
                                                                if (contactNo.length === 10) {
                                                                    return false;
                                                                } else {
                                                                    swal("Invalid Contact Number!", "Please Enter Valid Contact", "error")
                                                                            .then((value) => {
                                                                                document.getElementById("contactNo").select();
                                                                            });
                                                                    return true;
                                                                }
                                                            }

//only number validation
                                                            function validateNumber(evt) {
                                                                var theEvent = evt || window.event;
                                                                // Handle paste
                                                                if (theEvent.type === 'paste') {
                                                                    key = event.clipboardData.getData('text/plain');
                                                                } else {
                                                                    // Handle key press
                                                                    var key = theEvent.keyCode || theEvent.which;
                                                                    key = String.fromCharCode(key);
                                                                }
                                                                var regex = /[0-9]|\./;
                                                                if (!regex.test(key)) {
                                                                    theEvent.returnValue = false;
                                                                    if (theEvent.preventDefault)
                                                                        theEvent.preventDefault();
                                                                }

                                                            }
                                                            function onClickValidationContactNumber(evt) {
                                                                var theEvent = evt || window.event;
                                                                // Handle paste
                                                                if (theEvent.type === 'paste') {
                                                                    key = event.clipboardData.getData('text/plain');
                                                                } else {
                                                                    // Handle key press
                                                                    var key = theEvent.keyCode || theEvent.which;
                                                                    key = String.fromCharCode(key);
                                                                }
                                                                var regex = /[0-9]/;
                                                                if (!regex.test(key)) {
                                                                    theEvent.returnValue = false;
                                                                    if (theEvent.preventDefault)
                                                                        theEvent.preventDefault();
                                                                }

                                                            }

                                                            function nicValidation() {
                                                                var nic_no = $('#nic').val();


                                                                if (nic_no.length === 12) {
                                                                    if (nic_no.includes("V") || nic_no.includes("v")) {
                                                                        swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
                                                                                .then((value) => {
                                                                                    document.getElementById("nic").select();
                                                                                });
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }
                                                                } else if (nic_no.length === 10) {
                                                                    if (nic_no.includes("V") || nic_no.includes("v")) {
                                                                        return false;
                                                                    } else {
                                                                        swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
                                                                                .then((value) => {
                                                                                    document.getElementById("nic").select();
                                                                                });
                                                                        return true;
                                                                    }
                                                                } else {
                                                                    swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
                                                                            .then((value) => {
                                                                                document.getElementById("nic").select();
                                                                            });
                                                                    return true;
                                                                }

                                                            }

                                                            //nic validation
                                                            function validateNIC(evt) {
                                                                var theEvent = evt || window.event;

                                                                // Handle paste
                                                                if (theEvent.type === 'paste') {
                                                                    key = event.clipboardData.getData('text/plain');
                                                                } else {
                                                                    // Handle key press
                                                                    var key = theEvent.keyCode || theEvent.which;
                                                                    key = String.fromCharCode(key);
                                                                }
                                                                var regex = /[0-9-Vv]|\./;
                                                                if (!regex.test(key)) {
                                                                    theEvent.returnValue = false;
                                                                    if (theEvent.preventDefault)
                                                                        theEvent.preventDefault();
                                                                }

                                                            }

                                                            function Export() {
                                                                html2canvas(document.getElementById('customer_report'), {
                                                                    onrendered: function (canvas) {
                                                                        var data = canvas.toDataURL();
//                                                                data.text
                                                                        var docDefinition = {
                                                                            content: [{

                                                                                    image: data,
                                                                                    width: 500
                                                                                }]
                                                                        };
                                                                        pdfMake.createPdf(docDefinition).download("Customer Report.pdf");
                                                                    }
                                                                });
                                                            }

                                                            function ValidateEmail() {

                                                                if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val()))
                                                                {
                                                                    return false;
                                                                }
                                                                swal("Invalid Email!", "Please Enter Valid Email", "error")
                                                                        .then((value) => {
                                                                            document.getElementById("email").select();
                                                                        });
                                                                return true;

                                                            }

        </script>
    </body>
</html>
