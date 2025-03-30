// Log out code in JS
function logout() {
	// when user click on logout this function triggered and 
	// we will set the value as "logout" it will no longer "secret"
	// so if user try to go back or try to send request from other tab it won't be happen 
	// user will redirect to the login page only
      var code = localStorage.setItem("code", "logout");
      window.location.href="./index.jsp";
    }
