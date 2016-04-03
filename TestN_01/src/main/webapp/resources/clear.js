function clear () {
	$("#div1").hide();
	  var jsonrpcrequest = {
  			"jsonrpc": "2.0",
  			"method": "clear",
  		   };
	  $.ajax({
	        type:"DELETE",
	        url: "http://localhost:8080/test/iqbuzz/cinema/clear",
	        dataType:"json",            
	        data: JSON.stringify(jsonrpcrequest),  
	        contentType: "application/json; charset=utf-8"
	      });
	
}
function clearBooking () {
	  var jsonrpcrequest = {
  			"jsonrpc": "2.0",
  			"method": "clearbooking",
  		   };
	  $.ajax({
	        type:"DELETE",
	        url: "http://localhost:8080/test/iqbuzz/cinema/clearbooking",
	        dataType:"json",            
	        data: JSON.stringify(jsonrpcrequest),  
	        contentType: "application/json; charset=utf-8"
	      });
	
}