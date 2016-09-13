<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=basePath%>bootstrap3/css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery.min.js"></script>
<script src="<%=basePath%>bootstrap3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
</script>
<body>
	<div id="detailInfo" class="container-fluid">
		<div class="row-fluid" style="margin-top: 10px">
			<div class="col-md-12">
				<video id="movies" controls width="100%" height="400"
					style="background-color: black;">
					<source src="http://storage.jd.com/vision-video/dress_0.mp4" type="video/mp4">
					<source src="" type="video/ogg">
					<source src="" type="video/webm">
				</video>
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-md-6">
				<canvas id="myCanvas" width="417px" height="545px"></canvas>
			</div>
			<div class="col-md-6">
				<img id="rendered" name="rendered" alt="" src="">
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-md-12">
				<textarea id="base64code" name="base64code" rows="10" style="width: 100%"></textarea>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//document.domain = 'jd.com';
		var video = document.getElementById("movies");
		var myCanvas = document.getElementById("myCanvas");
		var ctx = myCanvas.getContext('2d');
		var videoRatio=0.6;
		
		video.addEventListener('play', function(){
			video.crossOrigin = "";
			$("#myCanvas").attr("width",video.videoWidth*videoRatio);
			$("#myCanvas").attr("height",video.videoHeight*videoRatio);
			ctx.fillStyle="#ffffff";
			ctx.fillRect(0,0,video.videoWidth*videoRatio,video.videoHeight*videoRatio);
			$("#rendered").attr("width",video.videoWidth*videoRatio);
			$("#rendered").attr("height",video.videoHeight*videoRatio);
			$("#rendered").attr("src",myCanvas.toDataURL("image/jpeg"));
		});
		video.addEventListener('pause', function() {
			video.crossOrigin = "";
			ctx.drawImage(video, 0, 0, video.videoWidth*videoRatio, video.videoHeight*videoRatio);
			$("#base64code").val(myCanvas.toDataURL("image/jpeg"));
			$.ajax({
				 url:'<%=basePath %>renderPic/',
                 type:"POST",
                 data:{'base64code':myCanvas.toDataURL("image/jpeg")},
                 success:function(data) {
                	 //$("#rendered").attr("src","data:image/jpeg;base64,"+data);
                	 $("#rendered").attr("src","<%=basePath %>"+data);
                 }
			});
		}, false);
		video.addEventListener('ended', function() {
			video.crossOrigin = "";
			ctx.drawImage(video, 0, 0, video.videoWidth*videoRatio, video.videoHeight*videoRatio);
		}, false);
	</script>
</body>
</html>