<%@page import="dataProccesor.DataProcessor"%>
<%@page import="java.util.Map"%>
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
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700;800;900&family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    
      <link rel="stylesheet" href="css/style.css">
      <script type="text/javascript" src="js/custom.js"></script>
   
</head>
<%
String ani=(String)session.getAttribute("user");
String uid=(String)session.getAttribute("id");
// if(ani == null)
// {
	
// 	response.sendRedirect("entry");
// 	return;
// }
ani="9888495960";
uid="1";

%>
<body>
    <main class="d-flex flex-column min-vh-100">
        <div class="flex-grow-1 d-flex flex-column p-2 p-md-5">
            <div class="flex-grow-1 d-flex flex-column wrapper">
                <jsp:include page="nav.jsp"></jsp:include>
               
                <div class="gamer_inner_page flex-grow-1 py-2 py-md-3">
                    <div class="container">
                        <div class="row">
                        
                        <%
                        String id=request.getParameter("id"); 
                        
                        try{
                        	
                        	
                        Map <String,String > map=DataProcessor.getGame(id);  
                        
                     String name=   map.get("name");
                     String imgurl=map.get("imgurl");
                     String about=map.get("about");
                     String prize=map.get("gameprize");
                     String gamedesc=map.get("gamedesc");
                     String link=map.get("link");
                     request.setAttribute("gameurl", link);
                 %>
                 <div class="col-md-6 my-3">
                                <div class="game_img h-100">
                                    <img src="<%=imgurl %>" alt="cash-quiz" class="img-fluid rounded h-100 w-100 shadow" />
                                </div>
                            </div>
                            
                            
                            <div class="col-md-6 my-3">
                                <div class="game_detail">
                                    <div class="row m-0 justify-content-between">
                                        <h1><%=name %></h1>
                                        <div class="ticket_price">
<!--                                             <p class="mb-0">Tic ket Price <span>5</span></p> -->
                                        </div>
                                    </div>
                                    <div>
                                        <h3>GAME DETAILS</h3>
                                        <ul class="list-unstyled">
                                            <li>
                                                <div class="dtl-img">
                                                    <i class="fa fa-ribbon"></i>
                                                </div>
                                                <div class="content">
                                                    <h5><%=name %></h5>
                                                    <p><%=gamedesc %></p>
<!--                                                     <p>Cash Quiz is a multi-level skilled web trivia game that allows users to play and answer knowledge based questions in order to win prizes when they reach pre-defined levels. The user qualifies for one game per day when they subscribe, but can purchase more entries</p> -->
                                                </div>
                                            </li>
                                            <li>
                                                <div class="dtl-img">
                                                    <i class="fa fa-gamepad"></i>
                                                </div>
                                                <div class="content">
                                                <p><%=about %></p>
                                               </div>
                                            </li> 
                                         <li>
                                                <div class="dtl-img">
                                                    <i class="fas fa-trophy"></i>
                                                </div>
                                                <div class="content">
                                                  <p><%=prize %></p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="play-btn">
                                      <button class="btn btn-theme text-uppercase btn-block py-2 font-weight-bolder" 
<%--                                       onclick="javascript:location.href='onlinePlay.jsp?url=<%=link%>?uid=`${window.sessionStorage.getItem('id')}`&gameid=<%=id%>'">Play</button> --%>
                                      onclick="onclick=redirect('onlinePlay.jsp?url=<%=link%>?uid=u_idd&gameid=<%=id%>')">Play</button>
                                    
                                    </div>
                                </div>
                            </div>
             <% 
                   }catch(Exception e)
                        {
                        	
                        	e.printStackTrace();
                        }
                        
                        
                        
                        %>
                        
                            
                            
                            
                        </div>
                    </div>
                </div>
                
                
               <jsp:include page="footer.jsp"></jsp:include>
                
                
            </div>
        </div>
    </main>
	
    

   
    <script type="text/javascript" src="js/dashboard.js"></script>
<!--     <script type="text/javascript">getusername(window.sessionStorage.getItem("id"));</script> -->
    <jsp:include page="modal.jsp"></jsp:include>
    
    
    
</body>
</html>