<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<jsp:include page="include.jsp" />
<title>Add Book</title>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="container">
			<a class="navbar-brand" href="#"> <img
				src="${pageContext.request.contextPath}/resources/img/5cb9c03787ab7860fdd5dc4d13a72043-diseno-de-logo-de-biblioteca-digital.jpg"
				alt="" width="50" height="50">
			</a>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" id="addBookButton"><a
					class="nav-link active" aria-current="page" href="#">AddBook</a></li>
			</ul>
			<c:url var="get_book_url" value="/book/getSingleBook" />
			<form:form action="${get_book_url}" method="get"
				modelAttribute="bookisbn" class="d-flex">
				<input class="form-control me-2" type="text" placeholder="Search"
					aria-label="Search" name="isbn">
				<button class="btn btn-outline-primary" type="submit">Search</button>
			</form:form>
		</div>
	</nav>
	<c:if test="${getSingleBook}">
		<div class="card" id="card" style="width: 18rem;">
			<div class="card-header">
				<button id="cardCloseIcon" class="btn">&times;</button>
			</div>
			<div class="card-body">
				<h5 class="card-title">${bookRequired.isbn}</h5>
				<div class="card-text">
					<p>Titolo:${bookRequired.title}</p>
					<p>Autore:${bookRequired.author}</p>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${addBookSuccess}">
		<div>Successfully added Book with ISBN: ${savedBook.isbn}</div>
	</c:if>

	<div class="modal" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="display: none">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add a Book</h5>
				</div>
				<c:url var="add_book_url" value="/book/addBook" />
				<form:form action="${add_book_url}" method="post"
					modelAttribute="book">
					<div class="modal-body">

						<p>
							<form:label path="isbn">ISBN: </form:label>
							<form:input type="text" path="isbn" />
						</p>
						<p>
							<form:label path="title">Book Name: </form:label>
							<form:input type="text" path="title" />
						</p>
						<p>
							<form:label path="author">Author Name: </form:label>
							<form:input path="author" />
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							id="closeModalButton" data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" >Save Book</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<table id="myTable" class="display">
		<thead>
			<tr>
				<th>Column 1</th>
				<th>Column 2</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Row 1 Data 1</td>
				<td>Row 1 Data 2</td>
			</tr>
			<tr>
				<td>Row 2 Data 1</td>
				<td>Row 2 Data 2</td>
			</tr>
		</tbody>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable({
				ajax:{
					url:'/book/retriveBooks',
					cache: false,
					dataSrc:''
				},
				columns: [
					{data:"isbn"},
					{data:"title"},
					{data:"author"} 
					]
				}
			);
			$("#cardCloseIcon").click(function() {
				$("#card").css("display", "none");
				console.log($(".close"));
			});

			$("#addBookButton").click(function() {
				$(".modal").css("display", "block");
			});

			$("#closeModalButton").click(function() {
				$(".modal").css("display", "none");
				$("form input").val("")
			});
		});
	</script>
</body>

</html>