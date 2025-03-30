<%@page import="java.sql.ResultSet"%>
<%@page import="dataProccesor.DataProcessor"%>
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

<!-- <link rel="stylesheet" href="css/bootsrap4.6.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!-- <link rel="stylesheet" href="css/fontawesome5.15.css"> -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700;800;900&family=Questrial&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Work+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">

<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="js/dashboard.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>


</head>

<%
String ani = (String) session.getAttribute("user");

// if(ani == null)
// {
// 	response.sendRedirect("entry");
// 	return;
// }
ani = "9888495960";
%>
<body >
	<main class="d-flex flex-column min-vh-100">
		<div class="flex-grow-1 d-flex flex-column p-2 p-md-5">
			<div class="flex-grow-1 d-flex flex-column wrapper">


				<!--   NavBar -->

				<jsp:include page="nav.jsp"></jsp:include>

           <div class="scoreboard text-center">
					<h3>Scoreboards</h3>
				</div>

				<div class="gamer_inner flex-grow-1 py-2 pb-md-5">
					<div class="container">
                          
						<!-- DashBoard Start Here ! -->
						<div class="row justify-content-between dashboard"></div>
						   <script> 
						   setInterval(()=>{
							   loadDashboard(); 
						   },3000)
						   </script> 
						<!--Dashboard Ends !  -->
						<div class="scoreboard text-center">
							<h3>Games</h3>
						</div>
						
						
						<div class="row justify-content-center">


							<%
							try {

								ResultSet rs = DataProcessor.getAllGames();
								while (rs.next()) {
									String imgurl = rs.getString("game_img");
									String name = rs.getString("game_name");
									String id = rs.getString("game_id");
							%>

							<div class="col-md-6 col-sm-6 col-6  my-3">
								<div class="game_box">
									<a href="play.jsp?id=<%=id%>"> <img src="<%=imgurl%>"
										alt="sping-win" class="img-fluid" /></a>
									<div class="game-title">
										<h2>
											<a href="play.jsp?id=<%=id%>"><%=name%></a>
										</h2>
									</div>
								</div>
							</div>

							<%
							}

							} catch (Exception e) {
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
	<!-- Alert  -->
	<jsp:include page="modal.jsp"></jsp:include>


	
</body>
</html>