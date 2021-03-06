<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/assets/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/responsive.css">

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="listings">
				<div class="wrapper">
					<ul class="properties_list">
						<c:forEach items="${store}" var="store">
						<li>
							<a href="<c:out value='${store.storeNo}'/>" class="target">
							<img src="display?name=s_${store.storeImage}" class="property_img"/></a>
							<div class="property_details">
								<h1><c:out value="${store.storeName}" /></h1>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				<button id="insertBtn" class="btn btn-info btn-fill btn-wd">신규 매장 등록</button>
			</div>
		</div>
	</div>
</div>

<form id="listForm" action="/store/list" method="get">
	<input type="hidden" name="sno">
	<input type="hidden" name="page" value="${Page.page}">
	<input type="hidden" name="size" value="${Page.size}">
</form>

<form id="insertForm" action="/store/insert" method="get">
	<input type="hidden" name="page" value="${Page.page}">
	<input type="hidden" name="size" value="${Page.size}">
</form>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<script src="/resources/js/pagination.js"></script>
<script src="/resources/js/main.js"></script>

<script>
	
	var listForm = $("#listForm");
	
	// 신규 매장 등록
	$("#insertBtn").on("click", function() {
		$("#insertForm").submit();
	});
	
	// 매장 상세 정보
	$(".target").on("click", function(e) {
		e.preventDefault();

		var sno = $(this).attr("href");
		
		listForm.find("input[name='storeNo']").val(sno);
		listForm.attr("action", "/store/detail").submit();
	});
	
</script>

<%@ include file="footer.jsp" %>
	