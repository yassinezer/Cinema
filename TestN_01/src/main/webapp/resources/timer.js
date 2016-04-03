function timer () {
	
	  var d= new Date().getHours();
	  var dm= new Date().getMinutes();
	  
	  if(d<22 && d>9) {

		  if(d==21) {
			  $("#label1").html('available time for Booking: '+ (60-dm) + ' Minutes <br><br>');
			  if(dm==30) clearBooking();
		  }
		  else {
			  $("#label1").html('available time for Booking: ' + (21-d) + ' Hours and ' + (60-dm) + ' Minutes <br><br>');
		  }
	  }
	  else {
		  $("#label1").html('no available booking now,  please wait for 10:00');
		  clear();
	  }
}