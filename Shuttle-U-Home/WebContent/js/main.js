/////////////////////////////////////////////////////////////////////////////
//  main.js - Contains button functionality for Road.jsp                   //
//  version 3.0  (Date - 04/06/2018)                                       //
//  Language:    JavaScript                                                //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Rishabh Agrawal, Syracuse University                      //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This file consist of functions name start(), end(), drop() and gettriptime(). 
 *   First three functions are used by Road.jsp for driver module.
 */

// This function is used to store the total trip time to the database.
function gettriptime() {
	
	// Ajax Call to background.jsp for storing the data
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            
        }
    };
    xmlhttp.open("GET", "background.jsp?triptime=" + triptime, true);
    xmlhttp.send();
}

// JavaScript function for start button in Road.jsp
function start() {
	var e=document.getElementsByClassName("add");
	var len = e.length; // length of the address variable

	for(i=0;i< len;i++){
				
		address[i] = e[i].defaultValue; // Fetching the address for plotting on map
	}
	
	setTimeout(getCoordinatesRefresh,2000); // Wait for 5 seconds while calling the function
	interval = setInterval(getCoordinatesRefresh,10000); // referesh this function every 5 seconds    
	document.getElementById("start").setAttribute("disabled", false); // disable the start button
	
	document.getElementById("drop").disabled = false; // enable the drop button
	document.getElementById("end").setAttribute("disabled", false); // disable the drop button
	setTimeout(gettriptime,4000); // Settimeout for 4 seconds
} // End of start function


// JavaScript function for drop button in Road,jsp 
function drop() {

var w;
if(typeof(Worker) !== "undefined") {

    if(typeof(w) == "undefined") {
        w = new Worker("js/change_address.js"); //Worker class for making threads in between the program
        var temp = {address: address,
        				num: waypoint_order[0]} //Send address to the file
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
    //Else part will run when Worker class is not supported by browser
}

	if (address.length == 0){
		// this part will run when address array becomes empty
		document.getElementById("end").disabled = false; //Enable end button
		document.getElementById("drop").disabled = true; // disable drop button
	}

} // End of Drop function

// This function gives the functionality to end button in Road.jsp
function end() {

	if (address.length == 0){
         clearInterval(interval);
	} // End the Interval
	
     document.getElementById("end").disabled = true; // disable the end button
     document.getElementById("start").disabled = false; // enable the start button
}// End of end function