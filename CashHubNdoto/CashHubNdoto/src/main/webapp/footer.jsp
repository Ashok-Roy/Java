
<footer class="py-2">
	<div class="container">
		<div class="row">
			<div
				class="col-12 text-center text-uppercase small font-weight-bolder">
				<p class="mb-0">2022 © copyright All Right Reserved.</p>
			</div>
		</div>
	</div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>



<script>

window.onload=()=> {
		let id = window.sessionStorage.getItem("id");
		if (id == null || id == '') {
			
			$('#Uid').modal('show');
		}
		else {
			getusername(id);
		}
	};
	function setUid() {

		let id = document.querySelector('#user_id').value;
		window.sessionStorage.setItem("id", id);

		console.log("User Id ::: ", id);
		// 	localStorage.setItem("id",id);

		// 	id=localStorage.getItem("id");
		id = window.sessionStorage.getItem("id");
		$('#Uid').modal('hide');
		getusername(id);
	}
</script>