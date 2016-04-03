function showbuy(){
	$("#div1, #h4, #label1, #label2").hide();
	$("#form2").show();
}

function buy () {
    	var id= $("#id").val();
    	var ccn= $("#ccn").val();
    	var jsonrpcrequest = {
    			"jsonrpc": "2.0",
    			"method": "buy",
    			"params": [id, ccn],
    			"id": 1
    		   };
    	
      $.ajax({
        type:"POST",
        url: "http://localhost:8080/test/iqbuzz/cinema/buy",
        dataType:"json",            
        data: JSON.stringify(jsonrpcrequest),  
        contentType: "application/json; charset=utf-8",
        success: function(data) {
        	$("#label3").html(JSON.parse(JSON.stringify(data)).result+'<br><br>');
        }, 
        error: function(qXHR, textStatus, errorThrown) {
         alert(errorThrown);
        }
      });
}