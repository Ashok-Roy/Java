//let id=localStorage.getItem('id');
 let id =window.sessionStorage.getItem("id");
//${(winn.id == `${id}` ? "CH00".concat(`${winn.uid}`) : "".concat(`${winn.uid}`))}
function loadDashboard(){
let url="https://www.cashhubgameapi.ndotomobile.com";
let idd =window.sessionStorage.getItem("id");
  fetch(url+"/users/winnersdashbord").then(resp=>{return resp.json();}).then(data=>
  {
    console.log("ID  ::: ",idd)
    let dash=document.querySelector(".dashboard").innerHTML=null;
    data.forEach(element => {
    let count=1;
      let co=`<div class="col-md-6 col-6"> <div class="board">  <div class="title ${element.color}"><h6>${element.gamename}</h6></div>
   ${ element.winners.map(winn=> 
      `<div class="scores">
    
          <div class="d-flex font-weight-bolder text-uppercase ${ (winn.id== `${idd}` ? "winners" : "normals")}"  ><p>${count++}. ${winn.uid}</p>
          </div>
          <p class="font-weight-bolder text-uppercase ${ (winn.id== `${idd}` ? "winners" : "normals")}">${winn.totalpoints}</p>
        </div>`.trim()
  ).join('')
  }
   </div> </div>`;
  //console.log("new Elements :::: ",co)
   document.querySelector(".dashboard").innerHTML+=co;
    });
  }
  ).catch(e=>console.log(e));
     
     
     }
function changename(){

 let uname = document.getElementById("user_name");
            if (uname.value.length > 6) {
                document.querySelector("#name").classList.add("text-danger");
                uname.value = '';
                return;

            }


            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");
            var raw = JSON.stringify({
                "id": id,
                "u_name": uname.value
            });

            var requestOptions = {
                method: 'PUT',
                headers: myHeaders,
                body: raw
            };

            fetch("https://www.cashhubgameapi.ndotomobile.com/users/updateusername", requestOptions)
                .then(response => {
                    if (response.status == 200) {
	                    $('#username').modal('hide')
	                    $('#alertsucess').modal('show')
	                       hidealert('#alertsucess'); 
	                          getusername(id)
	                          loadDashboard();
                    }
                   else
                    {
	                    $('#username').modal('hide')
	                      $('#alertfail').modal('show')
	                      hidealert('#alertfail');
	                       return {"message":"Your Name Is Not Update."}

                    }
                })
                .then(result => { 

                    console.log(result); 


                })
                .catch(error => console.log('error', error));

}


function getusername(id)
{

var requestOptions = {
  method: 'GET'
};

fetch("https://www.cashhubgameapi.ndotomobile.com/users/username/"+id, requestOptions)
  .then(response => response.text())
  .then(result => {
  document.querySelector(".user").innerText='';
  document.querySelector(".user").insertAdjacentText('beforeend',result);
  }
  )
  .catch(error => console.log('error', error));
}


function hidealert(id)
{

setTimeout(()=>{
console.log("alertw remove...."+id);
     $(id).modal('hide')
},5000)
}


function redirect(url){

location.href=url.replace("u_idd",id);

}
