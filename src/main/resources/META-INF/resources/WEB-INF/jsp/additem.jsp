
<%@ include file="common/header.jspf" %>	
	<%@ include file="common/navigation.jspf" %>	
	
	<div class="Container" align="center">
	  
	   <form:form method="post" modelAttribute="todo">
	    <fieldset class="m-3">
	         <form:label path="description">Description:</form:label>
			 <form:input type="text" path="description" />
		     <form:errors path="description" cssClass="text-warning"/>
		</fieldset>		     
		   
		 <fieldset class="m-3">  
		   <form:label path="description">Total:</form:label>
		   <form:input type="number" path="total"/>
		   <form:errors path="total" cssClass="text-warning"/>
		</fieldset>		     
		 
		 <fieldset class="m-3">
		 <form:label path="description">Price:</form:label>
		 <form:input  path="price"/>
		 </fieldset>		     
		 
		 <form:input type="hidden" path="id"/>
			</br>
		  <input type="submit" class="btn btn-success">
		
		</form:form>
		
       </div> 
      <%@ include file="common/footer.jspf" %>	
      