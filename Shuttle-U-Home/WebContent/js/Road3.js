//////////////////////////////////////////////////////
var max_trip_count=1;
var coordinates_keys;
var loc_data;


//initiliaze the firebase database
// set the authentication for firebase
var config = {
                apiKey: "AIzaSyCMBSNoFI1tUMW3rugVZmNDTyvwZoBbURQ",
      authDomain: "locationtracking-6a81b.firebaseapp.com",
      databaseURL: "https://locationtracking-6a81b.firebaseio.com",
      projectId: "locationtracking-6a81b",
      storageBucket: "locationtracking-6a81b.appspot.com",
      messagingSenderId: "46778088607"
   };


//Calling firebase variable and link to the configurations
firebase.initializeApp(config);

//Initialize the database
var database = firebase.database();

// access the location node in the tree
var ref = database.ref('location'); 

//take the value from the ref and give as a parameter to goData() and errData() function
ref.on('value',gotData,errData);


//Start of gotData function
function gotData(data){
          loc_data = data.val(); // get all the location data
          var keys = Object.keys(loc_data); // get all the keys in an array
          //console.log(keys);
          //console.log(keys.length);

          if(keys.length > 0){
              // gets the latest trip count
           for(var i =0 ; i < keys.length;i++){
            var k = keys[i];
            if(loc_data[k].tripId > max_trip_count)
              max_trip_count = loc_data[k].tripId; 

           }
          // console.log(max_trip_count);        
             coordinates_keys=[];
             for (var i=0;i<keys.length;i++){
                    var k = keys[i];
                  if(loc_data[k].tripId == max_trip_count)
                      coordinates_keys.push(k);
               }         
           }
              // get all the keys corresponding to the maximum(latest) trip
             // console.log(coordinates_keys.length);
           for (var i=0; i<coordinates_keys.length;i++){
            var k = coordinates_keys[i];
            //console.log(loc_data[k].tripId,loc_data[k].latitude,loc_data[k].longitude);
   }
}

 // End of function goData();


// Start of function errData(); 
function errData(err){
  console.log("Error !");
  console.log(err);
  
}

// End of function errData();

//completed firebase initialization

// function to get coordinates repeatedly every 5 seconds
var key_count=0;
var coordinates_limit = 5;

//Start of getCoordinatesRefresh
function getCoordinatesRefresh(){

          var itr=0;
          var latitude_coord=[];
          var longitude_coord=[];       


            while (key_count < coordinates_keys.length) {
                      //console.log("key count is:"+key_count);

                      if(itr != coordinates_limit){
                                var k = coordinates_keys[key_count];
                                latitude_coord.push(parseFloat(loc_data[k].latitude));
                                  longitude_coord.push(parseFloat(loc_data[k].longitude));
                                  key_count++;
                                  itr++;
                      }
                      else{
                                 receiveCoordinates(latitude_coord,longitude_coord);
                                 break;
                      }
              
            }

            if(key_count == coordinates_keys.length){
              //console.log("length is:"+latitude_coord.length);
              receiveCoordinates(latitude_coord,longitude_coord);
            }
}


//main Function calling 