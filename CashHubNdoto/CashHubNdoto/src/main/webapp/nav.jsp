<%@page import="datacollector.DataCollector"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--     <link rel="stylesheet" href="css/custom.css"> -->
     <header >
                    <div class="container">
                        <nav class="row align-items-center">
                        
                            <div class="left col-4" id="pr-00">
                                <div id="prize" onclick="$('#popprize').modal('show')">
                                    <p><i class="fa-solid fa-gift "></i> Prizes</p>
                                </div>
                            </div>

                            <div class="right col-4">
                                <div class="logo text-center"  style="text-align: right!important;">
                                    <a href="/"><img src="images/cashhubnew.png" alt="cashhub" class="img-fluid" /></a>
                                </div>
                            </div>
                            
                            
                           <div class="right col-4">
                                <div class="right_inner text-right">
                                	<button onclick="$('#username').modal('show')" class="btn btn-dark"><img src="images/user.png" style="width:30px;" class="img-fluid"> <span class="user"></span></button>
                                </div>
                            </div> 
                        </nav>
                        <hr>
                    </div>
                </header>
                
              
      