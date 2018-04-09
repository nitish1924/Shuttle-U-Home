var map;
var triptime = 0;
var distance_cover = 0.0;
var API_KEY = 'AIzaSyCJMprrXTtmUqciVaVgskmHxskLkVjrE6A';
//var address;
var mod_address = [];
var waypoint_order = 0;
var check = 0;
var interval;
 var directionsService;
var directionsDisplay;
// Make a function to fetch addresses from nitish module. Nitsh fuction should me write here


function receiveCoordinates(lat,lng){
         if (lat.length !=0 && lng.length != 0){
          //console.log(address);
          initMap();
          directionsService = new google.maps.DirectionsService;
          directionsDisplay = new google.maps.DirectionsRenderer;

          // waypoints in the form of address
          var waypts = [];

          // adding address in the waypoints

          directionsDisplay.setMap(map);

          //making parameters for the api
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

          var markers = [];

          function clearMarkers() {
          for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
          }
          markers = [];
          }


          //Ajax call
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

          for (var i = 0; i < data.snappedPoints.length; i++) {
            mod_lat.push(data.snappedPoints[i].location.latitude);
            mod_lng.push(data.snappedPoints[i].location.longitude);
          }

          console.log(mod_lat.length);
          console.log(mod_lng.length);

          function addMarkerWithTimeout(lat,lng, timeout) {
          window.setTimeout(function() {
            waypts = [];
            for (var i = 0; i < address.length; i++) {
            waypts.push({
                location: address[i],
                stopover: true
              });
            }
           // clearMarkers();
           // markers.push(new google.maps.Marker({
            //  position: {lat: lat, lng: lng},
           //   map: map,
           // }));
            
            // Write Here
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

              
              //console.log(response);
              
              // Calculate order of the trip
              var order = document.getElementById('order');
              order.innerHTML = '';
              order.innerHTML = '<b>Order of Trip:</b><br>';

              for (var i = 0; i < response.routes[0].legs.length; i++) {
              order.innerHTML += response.routes[0].legs[i].end_address + '<br><br>';
               }


              var route = document.getElementById('route');
              route.innerHTML = '';
              route.innerHTML = '<b>Directions:</b><br>';

              for (var i = 0; i < response.routes[0].legs[0].steps.length; i++) {
              route.innerHTML += response.routes[0].legs[0].steps[i].instructions + '<br><br>';
               }

               waypoint_order = response.routes[0].waypoint_order;

              // Calculate Trip time of the trip
              for (var i = 0; i < response.routes[0].legs.length; i++) {
                var temp = response.routes[0].legs[i].duration.text;
                var split = temp.split(" ");
                triptime += Number(split[0]);

               // console.log(response.routes[0].legs[i].distance.text);

                var temp1 = response.routes[0].legs[i].distance.text;
                var split1 = temp1.split(" ");
                if(split1[1] == 'mi')
                distance_cover += Number(split1[0]);
                else{
                  var miles = Number(split1[0]) / 5280;
                  distance_cover += miles;
                }
              } 
              
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

         // directionDisplay.setMap(null);
          //clearMarkers();
          //directionsDisplay.setDirections(null);

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

      map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 43.038799, lng: -76.124932},
          zoom: 16,
        });

    }