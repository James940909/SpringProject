<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sideBar" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>요기요 CENTER</title>

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

		<!-- Sidebar -->
		<sideBar:SideBar></sideBar:SideBar>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<sideBar:TopBar></sideBar:TopBar>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- 404 Error Text -->
					<br> <br> <br>
					<div class="text-center">
						<div>
							<h2>회 원 정 보 수 정</h2>
						</div>
						<br>
						<form action="updateStore.do" method="post"
							onsubmit="return confirm('수정하시겠습니까? 수정이 완료되면 다시 로그인 해주세요.');">
							<table style="margin: auto; width: 30%;">
								<tr style="width: 100%; height: 4rem;">
									<td>ID</td>
									<td style="width: 85%;"><input type="text" name="storeId"
										style="width: 100%; height: 2.5rem;" value="${store.storeId}"
										disabled></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>PW</td>
									<td style="width: 85%;"><input type="password"
										name="storePw" style="width: 100%; height: 2.5rem;"
										value="${store.storePw}"></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>Name</td>
									<td style="width: 85%;"><input type="text"
										name="storeName" style="width: 100%; height: 2.5rem;"
										value="${store.storeName}"></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>Category</td>
									<td style="width: 85%;"><select name="storeCategory"
										style="width: 100%; height: 2.5rem;">
											<option selected value="${store.storeCategory}">${store.storeCategory}</option>
											<option>--------------------------</option>
											<option value="치킨">치킨</option>
											<option value="피자/양식">피자/양식</option>
											<option value="중국집">중국집</option>
											<option value="한식">한식</option>
											<option value="일식/돈까스">일식/돈까스</option>
											<option value="족발/보쌈">족발/보쌈</option>
											<option value="분식">분식</option>
									</select></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>Phone</td>
									<td style="width: 85%;"><input type="text"
										name="storePhone" style="width: 100%; height: 2.5rem;"
										value="${store.storePhone}"></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>Address</td>
									<td style="width: 85%;"><input type="text"
										name="storeAddress" style="width: 100%; height: 2.5rem;"
										value="${store.storeAddress}"></td>
								</tr>
								<tr style="width: 100%; height: 4rem;">
									<td>Since</td>
									<td style="width: 85%;"><input type="text"
										name="signUpDate" style="width: 100%; height: 2.5rem;"
										value="${store.signUpDate}" disabled></td>
								</tr>
							</table>
							<br>
							<div>
								<input type="submit" value="수정완료">
							</div>
						</form>
					</div>
					<br> <br>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
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

	<!-- DeleteStore Modal-->
	<div class="modal fade" id="deleteStoreModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"></h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">정말 탈퇴하시겠습니까?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">취소</button>
					<a class="btn btn-primary" href="deleteStore.do">탈퇴</a>
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

</body>

</html>