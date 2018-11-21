<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/assets/css/timepicki.css" />

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-8 col-md-7">
				<div class="card">
					<div class="header">
						<h4 class="title">매장정보수정</h4>
					</div>
					<div class="content">
						<form id="storeupdate" action="/store/update" method="post" enctype="multipart/form-data">
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Store-Name</label>
										<input type="text" class="form-control border-input"
											   name="storeName" value="<c:out value='${store.storeName}'/>" >
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Category</label>
										<input type="text" class="form-control border-input"
											   name="storeCategory" value="<c:out value='${store.storeCategory}'/>" >
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Address</label>
										<input type="text" class="form-control border-input"
											   name="storeAddr" value="<c:out value='${store.storeAddr}'/>" >
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Tel</label>
										<input type="text" class="form-control border-input"
											   name="storeTel" value="<c:out value='${store.storeTel}'/>" >
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Open-Time</label>
										<input type="text" class="form-control border-input timepicker"
											   name="storeOpentime" value="<c:out value='${store.storeOpentime}'/>" >
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Close-Time</label>
										<input type="text" class="form-control border-input timepicker"
											   name="storeClosetime" value="<c:out value='${store.storeClosetime}'/>" >
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Store-Image</label>
										<input type="file" id="storeImage" name="imgFile" >
									</div>
								</div>
							</div>

							<div class="text-center">
								<button type="button" id="prevBtn"
										class="btn btn-info btn-fill btn-wd">이전페이지</button>
								<button type="submit" id="updateBtn"
										class="btn btn-info btn-fill btn-wd">수정</button>
								<button type="submit" id="deleteBtn"
										class="btn btn-info btn-fill btn-wd">삭제</button>
							</div>
							
							<input type="hidden" name="sno" value="${store.storeNo}">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<form id="prevForm" action="/store/detail" method="get">
</form>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<script src="/resources/assets/js/timepicki.js"></script>

<script>
	
	$(".timepicker").timepicki();
	
	$(document).ready(function() {
		
		$("#prevBtn").on("click", function() {
			$("#prevForm").submit();
		});
		
		$("#updateBtn").on("click", function() {
			$("#storeupdate").submit();
		});
		
		$("#deleteBtn").on("click", function(e) {
			e.preventDefault();
			$("#storeupdate").attr("action", "/store/delete").submit();
		});
		
		
	});
</script>

 <%@ include file="footer.jsp" %>