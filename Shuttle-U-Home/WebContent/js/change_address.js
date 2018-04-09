self.onmessage = function(event){
	
	var temp = event.data;
	var result = temp.address.splice(Number(temp.num), 1);
	postMessage(temp.address);
}

