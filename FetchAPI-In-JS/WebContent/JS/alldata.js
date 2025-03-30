					// All data operation 
// By taking id of table performing operation in thead and tbody section
  var tableHead = document.querySelector("#employeeTable thead");
  var tableBody = document.querySelector("#employeeTable tbody");

  //this function will run after clicking the ALL Employee button 
  function showData() 
  {
	  // Using fetch api sending the request to servlet
    fetch("./AllDataServlet")
      .then(function (response) {
        return response.json();
      })
      .then(function(data) {
    	  console.log(data);
    	  var head = '<tr>'+
    	  			'<th scope="col">ID</th>'+
    	  			'<th scope="col">NAME</th>'+
    	  			'<th scope="col">EMAIL</th>'+
    	  			'<th scope="col">CITY</th>'+
    	  			'<th scope="col">ACTION</th>'+
    	  			'<th scope="col">DELETE</th>'+
    	  			'</tr>';
    	  tableHead.insertAdjacentHTML('beforebegin', head);
    	  
    	  
        for (var i = 0; i < data.length; i++) {
          var employee = data[i];
          /* var row = tableBody.insertRow();
          var idCell = row.insertCell();
          var nameCell = row.insertCell();
          var emailCell = row.insertCell();
          var cityCell = row.insertCell();
          var updateCell = row.insertCell();
          idCell.textContent = employee.eid;
          nameCell.textContent = employee.ename;
          emailCell.textContent = employee.email;
          cityCell.textContent = employee.city;
          updateCell = 'Update'; */
          var row = '<tr>' +
          '<td>' + employee.eid+ '</td>' +
          '<td>' + employee.ename+ '</td>' +
          '<td>' + employee.email + '</td>' +
          '<td>' + employee.city + '</td>' +
          '<td>' + '<a href="http://localhost:8080/FetchAPI-In-JS/update.jsp?id='+employee.eid+'&name='+employee.ename+'&email='+employee.email+'&city='+employee.city+'";>Update</a>'
				 + '</td>' +
          '<td>' + '<a href="http://localhost:8080/FetchAPI-In-JS/delete.jsp?id='+employee.eid+'&name='+employee.ename+'&email='+employee.email+'&city='+employee.city+'";>Delete</a>'
				 + '</td>' +
          
          /* '<td>' + '<button id="sendData" onclick="window.location.href ="http://localhost:8080/FetchAPI-In-JS/update.jsp";>Update</button>' + '</td>' + */
          '</tr>';
      		tableBody.insertAdjacentHTML('beforeend', row);
        }
        /* After one click button will be disable */
        showDataButton.disabled = true;
        
        
      }).catch(function(error) {
        	console.error(error);
      });
  }

  // Creating a listener to the button 
  var showDataButton = document.querySelector("#showDataButton");
  showDataButton.addEventListener("click", showData);
  
  
