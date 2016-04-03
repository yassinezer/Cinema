function booking () {
	
    	var name= $("#Name").val();
    	var family= $("#Familly_Name").val();
    	var second_family= $("#Second_Familly_Name").val();
    	var price = $('input[name=price]:checked', '#div1').val();
    	var jsonrpcrequest = {
    			"jsonrpc": "2.0",
    			"method": "setBooking",
    			"params": [name, family ,second_family, price],
    			"id": 1
    		   };
    	
      $.ajax({
        type:"POST",
        url: "http://localhost:8080/test/iqbuzz/cinema/booking",
        dataType:"json",            
        data: JSON.stringify(jsonrpcrequest),  
        contentType: "application/json; charset=utf-8",
        success: function(data) {
        	$("#label2").html('You have one hour from now to buy this ticket, use this ID number: '+ 
        			(JSON.parse(JSON.stringify(data)).result) +' to Buy Your Ticket'+'<br><br>');
        	setTimeout(function(){ check_book(JSON.parse(JSON.stringify(data)).result) }, 1000*60*60);
        }, 
        error: function(qXHR, textStatus, errorThrown) {
         alert(qXHR + textStatus + errorThrown);
        }
      });
      
}


function check_book(id){
	var jsonrpcrequest = {
			"jsonrpc": "2.0",
			"method": "checkbook",
			"params": [id]
		   };
  $.ajax({
    type:"DELETE",
    url: "http://localhost:8080/test/iqbuzz/cinema/checkbooking",
    dataType:"json",            
    data: JSON.stringify(jsonrpcrequest),  
    contentType: "application/json; charset=utf-8",
  });
	
}