//Data
var cities = [
    {
        city : 'Toronto',
        desc : 'This is the best city in the world!',
        lat : 43.7000,
        long : -79.4000
    },
    {
        city : 'New York',
        desc : 'This city is aiiiiite!',
        lat : 40.6700,
        long : -73.9400
    },
    {
        city : 'Chicago',
        desc : 'This is the second best city in the world!',
        lat : 41.8819,
        long : -87.6278
    },
    {
        city : 'Los Angeles',
        desc : 'This city is live!',
        lat : 34.0500,
        long : -118.2500
    },
    {
        city : 'Las Vegas',
        desc : 'Sin City...\'nuff said!',
        lat : 36.0800,
        long : -115.1522
    }
];

//Angular App Module and Controller


app.controller('MapCtrl', function ($scope,$resource) {


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
    
//    var infoWindow = new google.maps.InfoWindow();
//    
//    var createMarker = function (info){
//        
//        var marker = new google.maps.Marker({
//            map: $scope.map,
//            position: new google.maps.LatLng(info.lat, info.long),
//            title: info.city
//        });
//        marker.content = '<div class="infoWindowContent">' + info.desc + '</div>';
//        
//        google.maps.event.addListener(marker, 'click', function(){
//
//            var contentString = "<div ng-controller='MapCtrl' class = 'infoWindow'><a href='/tt' ng-click='detail()'>View detail</a></div>"
//            infoWindow.setContent(contentString);
//            infoWindow.open($scope.map, marker);
//        });
//        
//        $scope.markers.push(marker);
//        
//    }  
//    $scope.detail = function(){
//        alert(2);
//    }
//    
   

    $scope.$on("mapSearch",function(event,addr) {
        var geocoder = new google.maps.Geocoder();
        var address = addr;
        var Search = $resource("/upark/search");
        
        var markers = Search.save(
        		{
    				address:addr
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
        
        
        
                //var address = document.getElementById('address').value;
       
        
});


//    $scope.codeAddress = function() {
//        var geocoder = new google.maps.Geocoder();
//        var address = MapInfo.map.address;
//                //var address = document.getElementById('address').value;
//        geocoder.geocode( { 'address': address}, function(results, status) {
//            if (status == google.maps.GeocoderStatus.OK) {
//                $scope.map.setCenter(results[0].geometry.location);
//                var marker1 = new google.maps.Marker({
//                    map: $scope.map,
//                    position: results[0].geometry.location
//      });  
//    } else {
//      alert('Geocode was not successful for the following reason: ' + status);
//    }
//  });
//        
//}

});