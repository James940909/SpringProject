<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sideBar" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>배민 Center</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<sideBar:SideBar></sideBar:SideBar>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<sideBar:TopBar></sideBar:TopBar>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Middle -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">메뉴</h1>
						<a href="insertMenu.jsp"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i>메뉴 등록</a>
					</div>
				</div>
				<table>
					<c:set var="first" value="0" />
					<c:set var="last" value="3" />
					<c:forEach var="i" begin="0" end="${fn:length(menuList)/4}">
						<tr>
							<c:forEach var="menuList" items="${menuList}" varStatus="status"
								begin="${first}" end="${last}">
								<td>
									<div style="width: 100%; height: 100%;">
										<!-- Illustrations -->
										<div class="card shadow mb-4">
											<div class="card-header py-3">
												<h6 class="m-0 font-weight-bold text-primary">${menuList.menuName}</h6>
											</div>
											<div class="card-body">
												<div class="text-center">
													<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
														style="width: 17rem; height: 12rem;"
														src="img/${fn:split(menuList.m_img,'\\')[10]}" alt="..."
														onerror="this.src='img/default.png'">
												</div>
														
												<p style="text-align: left;">￦ ${menuList.menuPrice}</p>
												<p style="text-align: left;">menuNum: ${menuList.menuNum}</p>
												<input type="hidden" name="menuNum" value="${menuList.menuNum}">
												<p style="text-align: right;">
													<a href="getMenu.do?menuNum=${menuList.menuNum}"
														class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
														class="fas fa-download fa-sm text-white-50"></i>수정</a> <a
														href="deleteMenu.do?menuNum=${menuList.menuNum}"
														onclick="return confirm('정말 삭제하시겠습니까?');"
														class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
														class="fas fa-download fa-sm text-white-50"></i>삭제</a>
												</p>
											</div>
										</div>
									</div>
								</td>
							</c:forEach>
							<c:set var="first" value="${first+4}" />
							<c:set var="last" value="${last+4}" />
						</tr>
					</c:forEach>
				</table>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>