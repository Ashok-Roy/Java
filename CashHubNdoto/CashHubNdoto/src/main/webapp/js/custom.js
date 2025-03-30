
function redeempoints (uid)
{
	
	let points=document.querySelector('#points').value;
	let type1=document.getElementById("customRadio1");
	let type2=document.getElementById("customRadio2");


	let userid=uid;
	let refundtype="";
	
	if(type1.checked)
	{
		refundtype=type1.value;
		}
	else if(type2.checked)
	{
		refundtype=type2.value;

		}
	
	if(points=="" )
	{
	alert("please fill value ! ");
	return;
	}
	else if(refundtype=="" )
	{
	alert("Please Select Type  ! ");
	return;
	}
	let jsonD={
       "type":refundtype,
	   "points":points,
	   "action":1,
	   "userid":uid
	   }
	
	console.log(refundtype + points);
	let url=new URLSearchParams(jsonD);
//	console.log(jsonD)

   fetch('ApiServlet',
   {
   method:'POST',
   body:url
   }
   ).then(res=>{return res.json()}).then(data=>
	{


	console.log(data)

	if(data.status=='1')
	{
		alert("SuccessFully Redeem Points !");
		getPoints(uid);
		window.location.href="/";
	}
		else
		{
			alert("No enough Points !");
		}
	
	}).catch(error=>console.log(error));
	
}

function getPoints(userid){

	let url="ApiServlet";

	let jsonD={
       "action":4,
	   "userid":userid
	}
	console.log(jsonD);
	let oldpoints=document.getElementById("totalpoints");
	let oldticket=document.getElementById("totalticket");
     let queryString=new URLSearchParams(jsonD);

fetch(url,{

	method:'POST',
	body:queryString
}).then(resp=>{return resp.json()}).then(data=>{


	 console.log(data.point);
//	 oldpoints.innerText="0";
//	 oldticket.innerText="0";
//	 let point=data.point;
     oldpoints.innerText=data.point;
     oldticket.innerText=data.ticket;

}).catch(error=>console.log(error))

}


function checkTicket(userid ,gameurl,id)
{

	let url="ApiServlet";
	let jsonD={
		"action":3,
		"userid":userid
		,"gameid":id
	 }
	 console.log(jsonD)
	 let query=new URLSearchParams(jsonD);
fetch(url,{
	method:'POST',
	body:query
}).then(resp=>{return resp.json()}).then(data=>
	{
        if(data.status==1){

         //      window.location.href=onlinePlay.jsp?url=gameurl+"?user_id="+userid+"&game_id="+id+"&ref="+userid;
			}
		else{
	//	window.location.href=onlinePlay.jsp?url=gameurl+"?user_id="+userid+"&game_id="+id+"&ref="+userid;
       //   $('#exampleModal').modal();
		}

	}).catch(error=>console.log(error))

}


function buyTicket(userid)
{

	let jsonD={
      "action":5,
	  "userid":userid
		}
		let query= new URLSearchParams(jsonD);
		let tickvalue=document.getElementById('buyticket');
        console.log(tickvalue.value);
		if(tickvalue == "")
		{
           alert("Please Fill Value !");
		   return;
		   }
       let url="ApiServlet";
       fetch(url,{
           body:query,
		   method:'Post'
		}).then(resp=>{return resp}).then(data=>{


			if(data.status=='1'){
           		alert ("Add Ticket Successfully !");
				   window.location.href="/";	
				   return;
			}
			else{
				alert ("Faild To Add Ticket !");
				window.location.href="/";
			}

		}).catch(error=>console.log(error));
    
     
}


  function buyTicketcustom(userid)
			{
				let tickvalue=document.getElementById("buytickets").value;
               console.log(tickvalue);
				if(tickvalue == "")
					  {
			           alert("Please Fill Value !");
					   return;
					   }
				
				let jsonD={
      "action":2,
	  "userid":userid,
       "ticket":tickvalue
		}
		let query= new URLSearchParams(jsonD);
		
		
       let url="Notify";

       fetch(url,{
           body:query,
		   method:'Post'
		}).then(resp=>{return resp}).then(data=>{

               console.log("response 	"+data)
			if(data.status=='200'){
           		alert ("Add Ticket Successfully !");
				   window.location.href="";
				   return;
			}
			else{
				alert ("Faild To Add Ticket !");
				window.location.href="/";
			}

		}).catch(error=>console.log(error));
				
				
				
				   
			}