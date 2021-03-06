<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/assets/css/timepicki.css" />

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-8 col-md-7">
				<div class="card">
					<div class="header">
						<h4 class="title">신규매장등록</h4>
					</div>
					<div class="content">
						<form id="storeinsert" action="/store/insert" method="post" enctype="multipart/form-data">
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Store-Name</label>
										<input type="text" class="form-control border-input" name="storeName">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Category</label>
										<input type="text" class="form-control border-input" name="storeCategory">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Address</label>
										<input type="text" class="form-control border-input" name="storeAddr">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Tel</label>
										<input type="text" class="form-control border-input" name="storeTel">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Open-Time</label>
										<input type="text" class="form-control border-input timepicker" name="storeOpentime">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Close-Time</label>
										<input type="text" class="form-control border-input timepicker" name="storeClosetime">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Store-Image</label>
										<input type="file" id="storeImage" name="imgFile">
									</div>
								</div>
							</div>

							<div class="text-center">
								<button type="button" id="prevBtn"
										class="btn btn-info btn-fill btn-wd">이전페이지</button>
								<button type="submit" id="insertBtn"
										class="btn btn-info btn-fill btn-wd">매장등록</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<form id="prevForm" action="/store" method="get">
</form>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<script src="/resources/assets/js/timepicki.js"></script>

<script>
	
	$(".timepicker").timepicki();
	
	$(document).ready(function() {
		
		$("#insertBtn").on("click", function(e) {
			e.preventDefault();
			$("#storeinsert").submit();
		});
		
		$("#prevBtn").on("click", function() {
			$("#prevForm").submit();
		});
		
	});
</script>

 <%@ include file="footer.jsp" %>