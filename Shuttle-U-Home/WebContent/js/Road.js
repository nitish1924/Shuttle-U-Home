/////////////////////////////////////////////////////////////////////////////
//  Road.js:     Displaying and Routing of Address                         //
//  version 8.3  (Date - 04/15/2018)                                       //
//  Language:    JavaScript                                                //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Rishabh Agrawal, Syracuse University                      //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This file use to calling the Google Map API and display the address on the google map
 *   and display the optimize routing of path
 */

var map; // Map variable for display Google Map
var triptime = 0; // Total trip time variable
var distance_cover = 0.0; // Total distance to cover variable
var API_KEY = 'AIzaSyCJMprrXTtmUqciVaVgskmHxskLkVjrE6A'; // Google API key variable

var mod_address = []; //Modified address array
var waypoint_order = 0; // Total waypoints for address
var check = 0; // Testing variable
var interval; //Interval time variable
 var directionsService; // Display the routes on the Google Map
var directionsDisplay; // Direction dispaly for display the renderer from Google
// Make a function to fetch addresses from nitish module. Nitsh fuction should me write here


// recieveCoordinates function will recieve the coordinates and display it on Map

function receiveCoordinates(lat,lng){
	
         if (lat.length !=0 && lng.length != 0){
          initMap(); //Display the Map
          directionsService = new google.maps.DirectionsService; 
          directionsDisplay = new google.maps.DirectionsRenderer;

          // waypoints in the form of address
          var waypts = [];

          // adding address in the waypoints
          directionsDisplay.setMap(map);

          //making parameters for the API in the form of (co1 | co2 |..)
          var parameters = "";
          for (var i = 0; i < lat.length; i++) {
          if( i == 0)
          parameters = lat[i] + "," + lng[i]
          else
          parameters += "|" + lat[i] + "," + lng[i];
          }

          // modified coordinates for the api Snap-To-Road
          var mod_lat = [];
          var mod_lng = [];
          
          // Marker variable to display Markers on Google Map
          var markers = [];
          
          // Clear Marker function
          function clearMarkers() {
          for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
          }
          markers = [];
          }

          //Ajax call for calling Road-to-Snap API
          $.ajax({
          type: 'GET',
          url: 'https://roads.googleapis.com/v1/snapToRoads',
          data: {
          interpolate: true,
          key: API_KEY,
          path: parameters
          },

          //onSuccess call
          success: function(data) {

          // push the coordinates into mod_lat and mod_lng variable
          for (var i = 0; i < data.snappedPoints.length; i++) {
            mod_lat.push(data.snappedPoints[i].location.latitude);
            mod_lng.push(data.snappedPoints[i].location.longitude);
          }

          // Display all the markers one -by-one from modified variable
          function addMarkerWithTimeout(lat,lng, timeout) {
          window.setTimeout(function() {
            waypts = []; //waypoints array
            for (var i = 0; i < address.length; i++) {
            waypts.push({
                location: address[i],
                stopover: true
              });
            }
            
            //Display the Direction on to the Google Map
            //Calling of Google JavaScript API
            directionsService.route({
            origin: {lat: lat, lng: lng},
            destination: {lat: 43.039624, lng: -76.131576},
            waypoints: waypts,
            optimizeWaypoints: true,
            travelMode: 'DRIVING'
          }, function(response, status) {
              triptime = 0;
              distance_cover = 0;
              waypoint_order = 0;

            if (status === 'OK') {
              directionsDisplay.setDirections(response);

              // Calculate order of the trip
              var order = document.getElementById('order');
              order.innerHTML = '';
              order.innerHTML = '<b>Order of Trip:</b><br>';
              
              // Display order of the trip
              for (var i = 0; i < response.routes[0].legs.length; i++) {
              order.innerHTML += response.routes[0].legs[i].end_address + '<br><br>';
               }
              
              // Calculate the optimized route of the address
              var route = document.getElementById('route');
              route.innerHTML = '';
              route.innerHTML = '<b>Directions:</b><br>';
              
              // Dispaly the Directions of the address
              for (var i = 0; i < response.routes[0].legs[0].steps.length; i++) {
              route.innerHTML += response.routes[0].legs[0].steps[i].instructions + '<br><br>';
               }
               
              // Initilizing the waypoint_order variable
               waypoint_order = response.routes[0].waypoint_order;

              // Calculate Trip time of the trip
              for (var i = 0; i < response.routes[0].legs.length; i++) {
                var temp = response.routes[0].legs[i].duration.text;
                var split = temp.split(" ");
                triptime += Number(split[0]);
                
                //Extracting the triptime and distance
                
                var temp1 = response.routes[0].legs[i].distance.text;
                var split1 = temp1.split(" ");
                if(split1[1] == 'mi')
                distance_cover += Number(split1[0]);
                else{
                  var miles = Number(split1[0]) / 5280;
                  distance_cover += miles;
                }
              } 
              // Display the triptime and distance to Raod.jsp
              var general = document.getElementById('general');
              general.innerHTML = '';
              general.innerHTML += '<b> Total Trip Time:</b><br>' + triptime + ' mins';
              general.innerHTML += '<br><br><b> Distance to Cover:</b><br>' + distance_cover + ' miles';

              }
             else {
              window.alert('Directions request failed due to ' + status);
            }
          });


          }, timeout);
          }

          //Show coordinates every second

          for (var i = 0; i < mod_lat.length; i++) {
            addMarkerWithTimeout(Number(mod_lat[i]),Number(mod_lng[i]), i * 1000);
          }

        },// End of Success

          // onError show the status
          error: function(status) {
          window.alert('Directions request failed due to ' + status);
          }
          //End of Error
          });  // End of Ajax Call      
          }     
     }



    // Adding map in the iFrame
    function initMap(){

    	// Map variable intialization 
      map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 43.038799, lng: -76.124932},
          zoom: 16,
        });

    }