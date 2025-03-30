<%
	
	String success = (String)session.getAttribute("success");
	if(success != null)
	{
		//out.println(success);
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Well done!</h4>
  <p>Data Insert Successfully</p>
  <hr>
</div>
<%
		session.removeAttribute("success");
	}
	String fail = (String)session.getAttribute("fail");
	if(fail != null){
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Something Went Wrong!</h4>
  <p>Data Insertion Failed</p>
  <hr>
</div>
<%
	session.removeAttribute("fail");
	}
	String notFound = (String)session.getAttribute("notfound");
	if(notFound != null)
	{
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Record Not Found!</h4>
  <p>Search With Suitable Id!</p>
  <hr>
</div>
<%
	session.removeAttribute("notfound");
	}
	
	String update = (String)session.getAttribute("update");
	if(update != null)
	{
%>

<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Well done!</h4>
  <p>Update Successfully</p>
  <hr>
</div>
<% 
	session.removeAttribute("update");
	}
	
	String delete = (String)session.getAttribute("delete");
	if(delete != null)
	{
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Well done!</h4>
  <p>Record Deleted Successfully</p>
  <hr>
</div>
<% 
	session.removeAttribute("delete");
	}
	
	String notavailable = (String)session.getAttribute("notavailable");
	if(notavailable != null)
	{
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Record Not Found!</h4>
  <p>Enter Valid Id!</p>
  <hr>
</div>
<%		
	session.removeAttribute("notavailable");
	}
	
	String record = (String)session.getAttribute("rnf");
	if(record != null)
	{
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Record Not Found!</h4>
  <p>Enter Valid Credential</p>
  <hr>
</div>
<%	
	session.removeAttribute("recordnotfound");
	}
	
	String logout = (String)session.getAttribute("logout");
	if(logout != null)
	{
%>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Log Out Successful</h4>
  <p>Thank You</p>
  <hr>
</div>
<%
	session.removeAttribute("logout");
	}
	String email = (String)session.getAttribute("incorrect");
	if(email != null)
	{
%>
<div class="alert alert-danger" role="alert">
  <h4 class="alert-heading">OOP's!</h4>
  <p>Look's like user mail is incorrect!</p>
  <hr>
</div>
<%
	session.removeAttribute("incorrect");
	}

%>

