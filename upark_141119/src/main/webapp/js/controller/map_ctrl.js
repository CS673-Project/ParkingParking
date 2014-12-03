//Angular App Module and Controller


app.controller('MapCtrl', function ($scope,$resource,$location,Greeting) {


    var mapOptions = {
        zoom: 4,
        center: new google.maps.LatLng(40.0000, -98.0000),
        mapTypeId: google.maps.MapTypeId.TERRAIN
    }

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
//
//    $scope.markers = [];
//    
    $scope.markersSet = [];
       
   
   
   function mapSearch(address){
	   var geocoder = new google.maps.Geocoder();
       var Search = $resource("/upark/search");
       var markers = Search.save(
       		{
   				address:address
   			},
   			function(){		
   				geocoder.geocode( { 'address': address}, function(results, status) {

   						 if (status == google.maps.GeocoderStatus.OK) {
   						 for (var j = 0;  j< $scope.markersSet.length; j++) {
   							 
   							 $scope.markersSet[j].setMap(null);
   							 }
   						 $scope.markersSet.length = 0;    							 
   							 
   							 var image = 'img/icon/parking.png';
   							 var destination = new google.maps.Marker({
   								 map: $scope.map,
   								 position: results[0].geometry.location,
   								 });
   							 
   							 $scope.markersSet.push(destination);
   							 
   							 var bounds = new google.maps.LatLngBounds();
	     			             bounds.extend(destination.position);
	     			             $scope.map.fitBounds(bounds);
   						 for (i = 0; i < markers.list.length; i++){
   	    					 //alert(markers.list[i].address1);
   	    					 var lattitude = markers.list[i].lattitude;
   				             var longitude = markers.list[i].longitude;
		     			            
		     			           // 	alert(lattitude +" "+longitude);
		     			                $scope.map.setCenter(results[0].geometry.location);
		     			                var marker1 = new google.maps.Marker({
		     			                    map: $scope.map,     			               
		     			                    position:new google.maps.LatLng(lattitude, longitude),
		     			                    icon: image
				     			      });
		     			                $scope.markersSet.push(marker1);

                                   
                                   //info window
                                   var contentString = '<div id="content">'+
                                   '<h6 id="firstHeading" class="firstHeading">'+markers.list[i].address1+'</h6>'+
                                   '<hr />'+
                                   '<div id="bodyContent">'+
                                   'Email:&nbsp'+markers.list[i].username+'<br>'+
                                   'Start Time:&nbsp'+markers.list[i].startTime+'<br>'+
                                   'End Time:&nbsp'+markers.list[i].endTime+'<br>'+
                                   'Unit Price:&nbsp$'+markers.list[i].unitPrice+'<br>'+
                                   
                                   '</div>'+
                                   '</div>';

                                   var infowindow = new google.maps.InfoWindow({
                                   	content: contentString
                                   });
                                   
                                   function makeInfoWindowEvent(map, infowindow, marker) {  
                                   	   return function() {  
                                   	      infowindow.open(map, marker);
                                   	   };  
                                   	}
                                   
                                   google.maps.event.addListener(marker1, 'click', 
                                   	makeInfoWindowEvent($scope.map,infowindow,marker1));
				     			    } 
   						 }else {
				     			      alert('Geocode was not successful for the following reason: ' + status);
				     			    }
   						 
		     			  });
				}
       );
   }
    
    	if(Greeting.greet.address!=""){
    		 var address = Greeting.greet.address;
    		 mapSearch(address);
    	}
    
    
    $scope.$on("mapSearch",function(event,addr) {
        mapSearch(addr);       
    });

    $scope.listView = function(){
    	$location.path('/mapListView/'+address)
    }
});