/////////////////////////////////////////////////////////////////////////////
//  change_address.js - Contains button functionality for Road.jsp         //
//  version 1.0  (Date - 03/26/2018)                                       //
//  Language:    JavaScript                                                //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Rishabh Agrawal, Syracuse University                      //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This file is use by main.js file, drop function. 
 *   This file is the result of javascript threading. It will drop the first address of the address variable
 */

self.onmessage = function(event){
	
	var temp = event.data; // recieve the data
	var result = temp.address.splice(Number(temp.num), 1); // delete the first address
	postMessage(temp.address); //send the resultant address array
}

