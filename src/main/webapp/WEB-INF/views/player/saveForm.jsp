<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

	<div class="container text-center">
		<h2>선수 등록</h2>
		<form action="/player" method="POST">
			<div class="form-group">
		    	<input type="text" class="form-control" placeholder="Enter Team Name" name="name">
	  		</div>
			<div class="form-group">
		    	<input type="text" class="form-control" placeholder="Enter Position" name="position">
	  		</div>
	  		<div class="form-group">
	  			<select class="form-control" name="teamId">
	  				<c:forEach var="item" items="${dto}">
	  					<option value="${item.id }">${item.name }</option>
					</c:forEach>
	  			</select>
	  		</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	

<%@include file="../layout/footer.jsp" %>