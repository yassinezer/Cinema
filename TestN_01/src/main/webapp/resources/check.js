	function check() {
		 nam = document.getElementById("Name").checkValidity();
		 family =  document.getElementById("Familly_Name").checkValidity();
		 second= document.getElementById("Second_Familly_Name").checkValidity();
		  if(nam && family && second)
		  booking();
		  if(nam == false) $("#namelabel").html('Required String') ;
		  else $("#namelabel").html('');
		  if(family == false)$("#familylabel").html('Required String') ;
		  else $("#familylabel").html('');
		  if(second==false)$("#secondlabel").html('Required String') ;
		  else $("#secondlabel").html('');
	}
	
	function check2() {
		 idc = document.getElementById("id").checkValidity();
		 ccn =  document.getElementById("ccn").checkValidity();
		  if(idc && ccn)
		  buy();
		  if(idc == false) $("#idlabel").html('Required Number') ;
		  else $("#idlabel").html('');
		  if(ccn == false)$("#ccnlabel").html('Required 14 Digits') ;
		  else $("#ccnlabel").html('');
	}