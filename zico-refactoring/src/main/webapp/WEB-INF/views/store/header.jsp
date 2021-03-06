<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="/resources/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/resources/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Zico-Project DashBoard</title>
	<!-- Bootstrap core CSS     -->
    <link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="/resources/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="/resources/assets/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/resources/assets/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="/resources/assets/css/themify-icons.css" rel="stylesheet">
    
    <!-- 구글 차트 -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <!-- c3 차트 사용 -->
    <!-- Load c3.css -->
	<!-- <link href="/path/to/c3.css" rel="stylesheet">
	
	Load d3.js and c3.js
	<script src="/path/to/d3.v3.min.js" charset="utf-8"></script>
	<script src="/path/to/c3.min.js"></script> -->
    
    <style>
    	<!-- Slide for 공지사항 -->
    	#slidebox {			
			width: 60%;
			height: 30px;
			overflow: hidden;
			white-space: nowrap;
			border: 1px solid #000;
		}

		#slidebox ul#slider {
			list-style: none;
			margin: 0;
			padding: 0;
		}
		
		#slidebox ul li {
			position: absolute;
			width: 40%;
			height: 20px;
			overflow:hidden; 
			text-overflow:ellipsis;
			white-space:nowrap;
		}
		
		#slidebox ul li p {
			width: 100%;
			height: 30px;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}
		
		#slidebox ul li a {
			text-decoration: none;
			color: black;
		}
		.micimg{
			position: fixed;
			top: calc(50% - 150px);
			left: calc(50% - 150px);
			display: none;
			z-index: 10;
			opacity: 0.5;
		}
		.guide{
			position: fixed;
			text-align: center;
			width: 300px;
			top: calc(50% - 10px);
			left: calc(50% - 150px);
			display: none;
			z-index: 20;
			color: black;
			font-size: 20px;
		}
    	<!-- END Slide for 공지사항 -->
    </style>
    
</head>
<body>

<!-- jquery -->
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

<div class="wrapper">
 <!--    <div class="sidebar" data-background-color="white" data-active-color="danger">

    
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Creative Tim
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="dashboard.html">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="user.html">
                        <i class="ti-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a href="table.html">
                        <i class="ti-view-list-alt"></i>
                        <p>Table List</p>
                    </a>
                </li>
                <li>
                    <a href="typography.html">
                        <i class="ti-text"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li>
                    <a href="icons.html">
                        <i class="ti-pencil-alt2"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="ti-map"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="notifications.html">
                        <i class="ti-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
				<li class="active-pro">
                    <a href="upgrade.html">
                        <i class="ti-export"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>
  -->
    <div style="width:100%" class="main-panel">
    
<!-- Top Start-->
<!-- Top Start-->
<!-- Top Start-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="/">Z I C O Bell</a>
                </div>
                
                <div class="collapse navbar-collapse">
                <div style="overflow:hidden;">
                	<div style="width: 40%; height: 30px; margin-top:10px; display:inline;" id="slidebox">
					        <ul id="slider">
					        	<c:forEach items="${list}" var="list">
					        		<li><a href="/notice/${list.noticeNo}">공지사항 | ${list.noticeTitle}</a></li>
					        	</c:forEach>
					               
					        </ul>
				    </div>
				</div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-archive"></i>
								<p>매장</p>
                            </a>
                              <ul class="dropdown-menu">
                               	<li class="newstore" style="display:none"><a href="/store/insert">매장등록</a></li>
                               	<li class="storeinfo" style="display:none"><a href="/store/detail">매장정보</a></li>
                              </ul>
                        </li>
                        <li class="dropdown storeinfo"  style="display:none">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-receipt"></i>
									<p>메뉴</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="/store/menu">메뉴리스트</a></li>
                              </ul>
                        </li>
                        <li class="dropdown storeinfo" style="display:none">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-headphone"></i>
								<p>주문</p>
                            </a>
                            <ul class="dropdown-menu" >
                                <li><a href="/admin/order">음성 주문</a></li>
                              </ul>
                        </li>
						<li>
							<c:choose>
								<c:when test="${sessionScope.id == null}">
		                            <a href="#">
										<i class="ti-power-off"></i>
										<p>Login</p>
		                            </a>
	                            </c:when>
	                            <c:otherwise>
		                            <a href="#">
										<i class="ti-power-off"></i>
										<p id="aftersignin">Logout</p>
		                            </a>
	                            </c:otherwise>
                            </c:choose>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <form id="logout" action="/logout" method="post" style="display:none"></form>

<script> 
	$(document).ready(function() {
		
		$("#aftersignin").on("click",function(){
			$("#logout").submit();
		})
		
    	//slide
    	var x = 50;
        var slider = document.getElementById("slider");
        var slideArray = slider.getElementsByTagName("li");
        var slideMax = slideArray.length - 1;
        var curSlideNo = 0;
		
        console.log(slideArray);
        console.log(slideMax);
        
        
        //한번만 실행
        for (i = 0; i <= slideMax; i++) {
            if (i == curSlideNo) {slideArray[i].style.top = 25 + "px";	// 첫번째 행의 top값을 15로 고정
            console.log("실행 : " + i);
        }else{ slideArray[i].style.top = -x + "px"; // 첫번째 행을 제외한 top값을 -x값으로 고정
            console.log("비실행 : " + i);}
        }

        slider.addEventListener('click', function () {
            changeSlide();
        }, false);

        var aniStart = false;
        var next = 1;
        var changeSlide = function(){	// 애니메이션이 진행되고 있다면 
            if (aniStart === true){ return; console.log("aniStart");}
            next = curSlideNo + 1;
            console.log("changeSlide");
            if (next > slideMax) next = 0;
            aniStart = true;
            sliding();
        }

        function sliding() {
            var curX = parseInt(slideArray[curSlideNo].style.top, 10);
            var nextX = parseInt(slideArray[next].style.top, 10);
            var newCurX = curX + 1;
            var newNextX = nextX + 1;
            if (newCurX >= x) {
                slideArray[curSlideNo].style.top = -x + "px";
                slideArray[next].style.top = 25 + "px";
                curSlideNo = curSlideNo + 1;
                if (curSlideNo > slideMax) curSlideNo = 0;
                aniStart = false;
                return;
            }
            slideArray[curSlideNo].style.top = newCurX + "px";
            slideArray[next].style.top = newNextX + "px";
            setTimeout(function () {
                sliding();
            }, 10);
        }
        setInterval(changeSlide,10000);
	});
	</script>
<!-- Top End -->
<!-- Top End -->
<!-- Top End -->