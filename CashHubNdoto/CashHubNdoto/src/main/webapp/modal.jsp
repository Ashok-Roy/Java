<div class="alert_sucess alert-success alert-dismissible fade "
	data-dismiss="alert" role="alert">
	<strong>Hey !</strong> Your Name Update SucessFully.
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>




<div class="modal fade" id="alertsucess" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Update</label>
					<p id="name">
						<strong>Hey !</strong> Your Name is Updated Successfully .
					</p>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="alertfail" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Update</label>
					<p id="name">
						<strong>Hey !</strong> Your Name not Update .
					</p>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

<!--  Username Update Modal -->
<div class="modal fade" id="username" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="form-group">
					<label for="exampleInputEmail1">UserName</label> <input type="text"
						class="form-control" id="user_name" aria-describedby="name"
						min="0" max="5"> <small class="form-text text-muted">
						<p id="name">Name Should Be Only Six Characters.</p>
					</small>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="changename()">Save</button>
			</div>
		</div>
	</div>
</div>


<!-- Prize modal -->
<div class="modal fade" id="popprize" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body pb-0">
				<div class="form-group">
					<label class="font-weight-bold">Prize</label>
					<p id="name">With CashHub there are daily winners and there's a grand prize at the end of the month where all players are added to a raffle and one is chosen to receive the R2000 grand cash prize.<br>
					The prizes for the daily winners which will be paid out as airtime are listed below:</p>
					<p>R50</p>
					<p>R30</p>
					<p>R20</p>
					<p>Players who are at the top of the scoreboard at 12:59pm will receive the prize payouts the following day at 13:00pm.</p>

				</div>
			</div>
			<div class="modal-footer py-1">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>



<!--  Id Update Modal -->
<div class="modal fade" id="Uid" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="form-group">
					<label for="exampleInputEmail1">UserId</label> <input type="number"
						class="form-control" id="user_id" aria-describedby="name"
						min="0" max="5"> <small class="form-text text-muted">
						<p id="name">ID Should Be Number.</p>
					</small>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="setUid()">Save</button>
			</div>
		</div>
	</div>
</div>



