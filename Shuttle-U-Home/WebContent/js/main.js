//document.getElementById("drop").setAttribute("disabled", false);
//document.getElementById("end").setAttribute("disabled", false);

function gettriptime() {
	console.log(triptime);
	
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            
        }
    };
    xmlhttp.open("GET", "background.jsp?triptime=" + triptime, true);
    xmlhttp.send();
}

function start() {
	var e=document.getElementsByClassName("add");
	//console.log(e);
	var len = e.length;
	//console.log(e);
	for(i=0;i< len;i++){
		//console.log(e[i].defaultValue);
		
		address[i] = e[i].defaultValue;
	}
	
	
	
	
	//address = ["205 Lexington Ave Syracuse NY","135 Lexington Ave. Syracuse NY","323 Lexington Ave. Syracuse NY","414 Columbus Ave Syracuse NY"];
	setTimeout(getCoordinatesRefresh,2000); // Wait for 5 seconds while calling the function
	interval = setInterval(getCoordinatesRefresh,10000); // referesh this function every 5 seconds    
	document.getElementById("start").setAttribute("disabled", false);
	//document.getElementById("drop").setAttribute("editable", true);
	document.getElementById("drop").disabled = false;
	document.getElementById("end").setAttribute("disabled", false);
	setTimeout(gettriptime,4000);
}

function drop() {

var w;
		    if(typeof(Worker) !== "undefined") {


		        if(typeof(w) == "undefined") {
		            w = new Worker("js/change_address.js");
		            var temp = {address: address,
		            				num: waypoint_order[0]}
		            w.postMessage(temp);
		        }
		        w.onmessage = function(event) {
		            address = event.data;
		            if(address.length == 0) {
		            	//clearInterval(interval);
		            }
		        };

		    } else {
		        document.getElementById("result").innerHTML = "Sorry! No Web Worker support.";
		    }

//document.getElementById("start").setAttribute("disabled", false);
//document.getElementById("start").setAttribute("disabled", false);
if (address.length == 0){
	document.getElementById("end").disabled = false;
	document.getElementById("drop").disabled = true;
}

}

function end() {

	if (address.length == 0){
         clearInterval(interval);
	}
	
     document.getElementById("end").disabled = true;
     document.getElementById("start").disabled = false;
}