<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

	<div class="container text-center">
		<h2>야구장등록페이지</h2>
		<form action="/stadium" method="POST">
			<div class="form-group">
		    	<input type="text" class="form-control" placeholder="Enter Stadium Name" name="name">
	  		</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	

<%@include file="../layout/footer.jsp" %>