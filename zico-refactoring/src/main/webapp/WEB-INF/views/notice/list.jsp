<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	<style type="text/css">
			table,th,td {
				background: white;
				text-align: center;
				/* overflow:hidden;
				text-overflow:ellipsis;
				white-space:nowrap; */
			}
			.notice-integer{
				width: 10%;
			}
			.notice-title{
				padding-top: 20px;
				width: 50%;
			}
			.notice-id{
				width: 10%;
			}
			.notice-date{
				width: 20%;
			}
			tr:hover td{
				background-color: #D7DBDD;
			}
			.nth {
				font-weight:bold;
				text-align: center;
			}
			.ntitle{
				text-align: left;
				padding-left: 0.75rem;
			}
			.ntitle a:link { color: black; text-decoration: none;}
			.ntitle a:visited { color: #884EA0; text-decoration: none;}
			.pagination {
			   display:inline-block;
			   padding:0 calc(calc(100% - 600px)/2) 0 calc(calc(100% - 600px)/2);
			}
			
			.pagination a {
			    color: black;
			    float: left;
			    padding: 8px 16px;
			    text-decoration: none;
			    transition: background-color .3s;
			}
			
			.pagination a.active {
			    background-color: #5AA6ED;
			    color: white;
			}
			
			.pagination a:hover:not(.active) {background-color: #ddd;}

		</style>
	
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yy-MM-dd" /></c:set> 
			
		<!-- Footer -->
			<footer id="footer" class="wrapper">
				<div class="inner">
					<section>
						<div style="min-height:60%;" class="box">
							<div class="content">
								<div>
								<h2 style="font-weight:bold; float:left" class="align-center">공지 사항</h2>
								<br>
								<br>
								
								<table style=" border-top: 1px solid #E3E3E3">
									<thead>
										<tr>
											<th class="nth notice-integer">No</th>
											<th class="nth notice-title">Title</th>
											<th class="nth notice-id">id</th>
											<th class="nth notice-date">Date</th>
											<th class="nth notice-integer">Hits</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${noticeList}" var="list">
							            <tr>
							                <td>${list.noticeNo}</td>
							                <%-- <td class="ntitle"><a style="" href="/notice/detail?nno=${list.nno}">${list.ntitle}</a></td> --%>
							                <td class="ntitle"><a style="" href="/notice/${list.noticeNo}">${list.noticeTitle}</a></td>
							                <td>${list.noticeMemberId}</td>
							                <td class="regdate">
							                	<c:set var="javaYear"><fmt:formatDate  value="${list.noticeRegdate}" pattern="yy-MM-dd"/></c:set>
								                	<c:choose>
								                	<c:when test="${sysYear == javaYear}">
								                		<c:set var="sysTime"><fmt:formatDate  value="${list.noticeRegdate}" pattern="HH:mm"/></c:set>
								                		<c:out value="${sysTime}"/>
								                	</c:when>
													<c:otherwise>
														<c:out value="${sysYear}"/>
													</c:otherwise>
												</c:choose>										
							                </td>
							                <td>${list.noticeHits}</td>
							            </tr>
						            </c:forEach>
									</tbody>
								</table>
									<div class="pagination">
										  
									</div>
								</div>
							<input value="등록" class="button special admin-inlineblock" style="display:none" onclick="location.href='/notice/insert'" type="button">
							</div>
						</div>
					</section>
					<script src="/resources/assets/js/pagination.js"></script>
					<script type="text/javascript">
					  $(document).ready(function() {
						
						/* paging 처리
						   ## 간소화 작업 할 것
						*/ 
						str='';
					    var pageResult = makePage({ page:${page.page}, size:${page.size}, total:${totalCnt} });
					    if(pageResult.prev){
					    	str += "<a href=javascript:goPage("+ (pageResult.first - 1) +")>&laquo;</a>";
					    }
					   	for(var i = pageResult.first; i <= pageResult.last; i++){
					   		str += "<a " + (pageResult.page == i ? "class='active'":"") + "href=javascript:goPage("+i+")>"+i+"</a>";
					   	}
					   	if(pageResult.next){
					   		str += "<a href=javascript:goPage("+ (pageResult.last + 1) +")>&raquo;</a>";
					   	}
					   	$(".pagination").html(str);
					   	
					  });
					  
					  /* notice 페이지간 이동을 위한 post방식 function */
					  function goPage(page){
					   		var path = "/notice"
					   		var form = document.createElement("form");
					   		form.setAttribute("method","Post");
					   		form.setAttribute("action",path)
					   		var field = document.createElement("input");
					   		field.setAttribute("type","hidden");
					   		field.setAttribute("name","page");
					   		field.setAttribute("value",page);
					   		
					   		form.appendChild(field);
					   		
					   		document.body.appendChild(form);
					   		form.submit();
					   	}
					</script>
					<script type="text/javascript">
					</script>
<%@ include file="footer.jsp" %>