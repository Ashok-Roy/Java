<%@page import="dataProccesor.DataProcessor"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cash Hub</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700;800;900&family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<%
// String ani=(String)session.getAttribute("user");

// if(ani == null)
// {
	
// 	response.sendRedirect("entry");
// }

%>
<body>
    <main class="d-flex flex-column min-vh-100">
        <div class="flex-grow-1 d-flex flex-column p-2 p-md-5">
            <div class="flex-grow-1 d-flex flex-column wrapper">

              <jsp:include page="nav.jsp"></jsp:include>

                <div class="radeem flex-grow-1 py-2">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5 my-3">
                                <div class="redeem_box bg-white shadow p-4 rounded overflow-hidden">
                                    <h2 class="cusheading">Radeem</h2>
                                    <p>You can Redeem the points as</p>
                                    
                                    
<!--                                     <form action=""> -->
                                        <div class="form-group d-flex">
                                            <div class="custom-control custom-radio mr-4">
                                            
                                                <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input" value="airtime">
                                                <label class="custom-control-label" for="customRadio1">Airtime</label>
                                                
                                            </div>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input" value="data">
                                                <label class="custom-control-label" for="customRadio2">Data</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="" placeholder="Enter Point" class="form-control"  id="points"/>
                                        </div>
                                        <div class="form-group mb-2">
                                            <button class="btn btn-theme text-uppercase btn-block py-2" onclick="redeempoints('a')">Radeem</button>
                                        </div>
<!--                                     </form> -->
                                    
                                    
                                    
                                </div>
                            </div>
                            <div class="col-md-1 my-3">
                                <div class="or text-center">
                                    <p class="mb-0">or</p>
                                </div>
                            </div>
                            <div class="col-md-6 my-3">
                                <div class="reward-table bg-white shadow p-4 rounded overflow-hidden">
                                    <h2 class="cusheading">Rewards</h2>
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Point</th>
                                                    <th>Reward</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                
                                                <%
                                                
                                                
                                                try{
                                                	
                                                	
                                                	
                                                	ResultSet rs=DataProcessor.getRewards();
                                                	while(rs.next())
                                                	{
                                                		
                                                		%>
                                                		<tr>
                                                    <td><%=rs.getString("point") %></td>
                                                    <td><%=rs.getString("reward") %></td>
                                                </tr>
                                                		
                                                		
                                                		<% 
                                                		
                                                		
                                                	}
                                                	
                                                }
                                                catch(Exception e)
                                                {
                                                	
                                                	e.printStackTrace();
                                                }
                                                
                                                %>
                                                
                                                
                                               
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                     <jsp:include page="footer.jsp"></jsp:include>
                
                
            </div>
        </div>
    </main>
  
    <!-- Modal -->
    <div class="modal cusmodal fade" id="buyticket" tabindex="-1" aria-labelledby="buyticketLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div class="modal-body">
                    <h5 class="modal-title" id="buyticketLabel">Buy Tickets</h5>
                    <div class="buyticket">
                        <form action="">
                            <div class="form-group">
                                <input type="number" placeholder="Enter no of Ticket" class="form-control" />
                            </div>
                            <div class="form-group mb-0">
                                <button class="btn btn-theme text-uppercase btn-block py-2">Buy Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  <script type="text/javascript" src="js/custom.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>