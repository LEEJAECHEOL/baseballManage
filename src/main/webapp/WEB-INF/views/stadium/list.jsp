<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<div class="container">
	<h2>야구장 리스트</h2>
	
	<div class="card">
	    <div class="card-body d-flex justify-content-between pt-1 pb-1">
	    	<h4 class="card-title mb-1">No</h4>
	    	<h4 class="card-title mb-1">구장</h4>
	    	<h4 class="card-title mb-1">팀</h4>
	    	<h4 class="card-title mb-1">&nbsp;</h4>
	    </div>
	</div>
	
	<c:forEach var="item" items="${dto}">
		<div class="card list-${item.id }">
			<div class="card-body d-flex justify-content-between">
		    	<p class="mb-0">${item.id }</p>
		    	<p class="mb-0">${item.name }</p>
		    	<p class="mb-0">${item.team.name}</p>
		    	<p class="mb-0">
		    		<button class="btn btn-danger" onClick="deleteStadium(${item.id})">삭제</button>
		    	</p>
			</div>
		</div>
	</c:forEach>
</div>
<script>
	function deleteStadium(id) {
		console.log(id);
		$.ajax({
			method:"DELETE",
			url: "/stadium/"+id
		})
		.done((data) => {
			console.log(data);
			if(data === "ok"){
				$(".list-"+id).remove();
			}
		});
		
	}
</script>

<%@include file="../layout/footer.jsp" %>