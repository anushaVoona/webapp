   <%@ include file="common/header.jspf" %>	
	
	<%@ include file="common/navigation.jspf" %>	
	
	 <div class="Container">
	 <h1>Hi ${name}</h1>
	 
			<div>
			    <table class="table">
			     <thead>
			        <tr>
			            
			            <th>Description</th>
			            <th>Total</th>
			            <th>Price</th>
			            <th></th>
			            
			         </tr>
			      </thead>
			 <tbody>		
							<c:forEach items="${todo}" var="todo">
								<tr>
									
									<td>${todo.description}</td>
									<td>${todo.total}</td>
									<td>${todo.price}</td>
									<td><a href="update?id=${todo.id}" class="btn btn-success">Update</a> </td>
									<td><a href="delete?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
								</tr>
							</c:forEach>
						</tbody>
			    </table>
		      </div> 
		      
		      <a href="add" class="btn btn-success">AddItem</a>
      </div>
      <%@ include file="common/footer.jspf" %>	
      
	