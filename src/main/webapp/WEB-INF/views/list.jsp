<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./layout/header.jsp" %>

<div class="container">
	<h2>포지션별 팀의 선수 리스트</h2>
	
	<div class="card">
	    <div class="card-body d-flex justify-content-between pt-1 pb-1">
	    	<h4 class="card-title mb-1">포지션</h4>
	    	<h4 class="card-title mb-1">두산</h4>
	    	<h4 class="card-title mb-1">한화</h4>
	    	<h4 class="card-title mb-1">롯데</h4>
	    </div>
	</div>
	
	<c:forEach var="item" items="${dto}">
		<div class="card">
			<div class="card-body d-flex justify-content-between">
		    	<p class="mb-0">${item.position }</p>
		    	<p class="mb-0">${item.dusan }</p>
		    	<p class="mb-0">${item.hanhwa}</p>
		    	<p class="mb-0">${item.lotte}</p>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="./layout/footer.jsp" %>