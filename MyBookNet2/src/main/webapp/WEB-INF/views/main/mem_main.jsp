<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<title>회원 메인페이지</title>
<style>
</style>	
<script type="text/javascript">
</script>
</head>
<body onload="printClock()"/>
<!-- 파라미터로 넘길 데이터값 -->
<form method="POST" id="frm2">
	<input type="hidden" id="pno" name="pno"> <!-- 게시글 삭제시 넘겨줄 게시글 번호 -->
</form>
	<!-- 추천도서, 베스트셀러 모달 슬라이드 처리 -->
	<div class="firstModal slideRank" role="none">
		<div class="r-modal-content">
			<div style="width: 100%; height: 10px; margin: 0 atuo;">
				<span class="close r-x-btn" id="r-close_butt" style="color: #fefefe;">x</span>
			</div>
			<div style="width: 100%; height: 10px; margin: 5px auto;">
				<div class="w3-col"><a class="w3-third w3-card w3-bar-item" style="color: white; font-size: 18px; text-align: center;" href="">금주의 베스트셀러</a></div>
				<!-- <div><a class="w3-third w3-border" style="color: white; text-align: center;" href="">베스트셀러</a></div>
				<div><a class="w3-third w3-border" style="color: white; text-align: center;" href="">추천도서</a></div> -->
			</div>
			<!-- 베스트셀러 정보를 담을 div -->
			<div class="w100-h390 mgt15" id=""> 
				
			</div>
			<input type="checkbox" name="closeForDay" value="OK" id="closeForDay" /> 하루동안 창을 열지 않음
		</div>
	</div>
	<div>
		<!-- 본문부분 -->
		<div id="contents-wrap">
			<div class="contents">
				<!-- 좌측 게시글 부분 -->
				<div class="posts_area">
					<c:forEach var="data" items="${LIST}">
						<article class="eachPost"><!-- id="${data.pno}" -->
							<!-- 작성자 정보 & 버튼 :: 아이디 불러와야함  -->
							<div class="wrtInfo">
								<div class="wrtProf">
									<img src="">
								</div>
								<div class="wrter" id="id${data.pno}"><a href=""><b id="">${data.id}</b></a></div>
								<div class="time" id="time${data.pno}">${data.pdate} ${data.ptime}</div>
								<c:if test="${SID eq data.id}">
									<div class="like-butt" id="${data.pno}" style="display: flex;'">
										<span style="font-size: 12px; line-height: 0px;" class="e-d-img edbtn" id=""></span>
									</div>
								</c:if>
								<div class="like-butt" id="${data.pno}" style="display: flex;'">
									<c:if test="${data.ischeck eq NULL}">
										<span style="font-size: 12px; line-height: 0px;" class="like-img likebtn" id="like${data.pno}"></span>
									</c:if>
									<c:if test="${data.ischeck eq 'Y'}">
										<span style="font-size: 12px; line-height: 0px; background-position: -208px -370px;" class="like-img likebtn" id="like${data.pno}"></span>
									</c:if>
								</div>
							</div>
							<!-- 게시글의 본문부분::도서사진,도서이름,본문 -->
							<div class="postCont" style="text-align: center; font-size: 16px;">
								<!-- 도서사진, 도서이름, 게시글본문 -->
								<div class="book-pic">
									<!-- 도서 사진 들어갈 부분 -->
									<img id="img${data.pno}" src="${data.largeimg}" style="width: 90%; height: auto;" />
								</div>
								<div class="genre-name" style="font-size: 12px; text-align: left;" id="genre${data.pno}">
									<!-- 도서장르 들어갈 부분 -->
									${data.gname}
								</div>
								<div class="book-name" id="bname${data.pno}">
									<!-- 도서명 들어갈 부분 -->
									<b>${data.bname}</b>
								</div>
								<div class="post-body">
									<!-- 게시글 부분 -->
									<a style="box-sizing: border-box; font-size: 13px;" id="pbody${data.pno}">${data.postcont}</a>
								</div>
							</div>
							<div class="wrtInfo">
								<div class="etcdiv" style="text-align: left; font-size: 13px;" id="hash${data.pno}">${data.hash}</div>
								<span class="modifdiv modi_post" id="${data.pno}"></span>
							</div>
						</article>
					</c:forEach>
					<!-- 게시물 수정 삭제 선택 띄워주는 모달 -->
					<div class="modal edit-del-modal" role="none">
						<div class="e-modal-content" style="margin: 100px auto;" id="">
							<div class="w100-pt10" style="height: 40px; border-top: 1px solid black; border-bottom: 1px solid black;">
								<a id="e-btn" style="font-size: 15px; position: absolute; line-height: 1;">수 정</a>
							</div>
							<div class="w100-pt10" style="height: 40px;">
								<a id="d-btn" style="font-size: 15px; position: absolute; line-height: 1;">삭 제</a>
							</div>
							<div class="w100-pt10" style="height: 40px; border-top: 1px solid black; border-bottom: 1px solid black;">
								<a id="c-btn" style="font-size: 15px; position: absolute; line-height: 1;">취 소</a>
							</div>
						</div>
					</div>
					<!-- 게시물 상세보는 모달 -->
					<div class="modal detailPost" role="none">
						<div class="p-modal-content" id="" style="height: 540px;">
							<span class="close w-x-btn" id="">x</span>
							<div class="w100-pt10">
								<div class="wrtProf" style="width: 45px; height: 45px;">
									<img src="">
								</div>
								<div class="wrter" style="line-height: 40px;" id="">
									<a href="" style="font-size: 18px;"><b class="wrter"></b></a>
								</div>
								<div class="time" style="line-height: 40px;" id="time"></div>
							</div>
							<div class="w100-h500">
								<div class="w500-h450">
									<div class="genre-pad" id="genre-pad"></div>
									<div class="genre-pad" style="height: 35px; font-size: 25px; line-height: 25px;"><b id="genre-name"><b></b></b></div>
									<div class="book-pic">
										<!-- 도서 사진 들어갈 부분 -->
										<img id="bimg" src="" style="float: left; box-sizing: border-box;" />
									</div>
									<div class="detail-body">
										<!-- 게시글 부분 -->
										<a style="box-sizing: border-box; font-size: 13px;" id="p-body"></a>
									</div>
								<div class="w100-h35">
									<div style="float: left; margin-left: 20px; text-align: left; font-size: 12px;" id="gethash"></div>
									<div class="like-butt" style="margin-right: 20px;" id="">
										<span style="font-size: 12px; line-height: 0px;" class="comt-img comtbtn"></span>
									</div>
									<div class="like-butt" id="" style="display: flex;'">
										<span style="font-size: 12px; line-height: 0px;" class="like-img likebtn" id=""></span>
									</div>
								</div>
								</div>
								<div class="w450-h400">
									<div class="w450-h400 post-comment" style="height: 350px;" id="">
										<!-- 댓글 리스트 뽑아오기 -->
									</div>
									<div class="wrtcomt hidcommt" style="display: none;" id="">
										<div class="comwrter">
											<input type="hidden">
											<a>${SID}</a>
										</div>
										<input type="text" id="-comt-id" class="combody" placeholder="댓글을 입력하세요." />
										<input type="button" class="comsubbtn" value="등록" id=""/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 우측 정보 부분 : 고정페이지로 들어갈 것-->
				<div class="info_area">
					<div style="width: 100%; height: 250px; margin-top: 15px;">
						<div class="w100-h40" style="/* background-position: inherit; background-image: url('/BookNet/img/manuscript_img.png');  */border-bottom: solid 1px black;">
							<a class="fl-fs13"><b>페이지터너에서 가장 많은 글이 달린 도서</b></a>
						</div>
						<c:forEach var="bData" items="${OLIST}">
							<div class="w100-h40" id="${bData.bno}">
								<a class="fl-fs10">${bData.gname}</a>
								<div class="fl-fs15">${bData.bname}</div>
							</div>
						</c:forEach>
					</div>
					<div style="width: 100%; height: 200px; margin-top: 15px; border: solid 1px white;">
						<a></a>
					</div>
				</div>
				<!-- 우측 정보 끝! -->
			</div>
		</div>
		<!-- 고정페이지부분 -->
		<jsp:include page="/WEB-INF/views/fixed.jsp" />
	</div>
</body>
</html>