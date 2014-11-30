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

    $scope.markers = [];
    
    var infoWindow = new google.maps.InfoWindow();
    
    var createMarker = function (info){
        
        var marker = new google.maps.Marker({
            map: $scope.map,
            position: new google.maps.LatLng(info.lat, info.long),
            title: info.city
        });
        marker.content = '<div class="infoWindowContent">' + info.desc + '</div>';
        
        google.maps.event.addListener(marker, 'click', function(){

            var contentString = "<div ng-controller='MapCtrl' class = 'infoWindow'><a href='/tt' ng-click='detail()'>View detail</a></div>"
            infoWindow.setContent(contentString);
            infoWindow.open($scope.map, marker);
        });
        
        $scope.markers.push(marker);
        
    }  
    $scope.detail = function(){
        alert(2);
    }
    
    for (i = 0; i < cities.length; i++){
        createMarker(cities[i]);
    }

    $scope.$on("mapSearch",function(event,addr) {
        var geocoder = new google.maps.Geocoder();
        var address = addr;
        var Search = $resource("/upark/search");
        var markers = Search.save(
        		{
    				address:addr
    			},
    			function(){
    				alert(markers);
				}
        );
        
        
        
                //var address = document.getElementById('address').value;
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                $scope.map.setCenter(results[0].geometry.location);
                var marker1 = new google.maps.Marker({
                    map: $scope.map,
                    position: results[0].geometry.location
      });  
       $scope.markers.push(marker1);
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
        
});


    $scope.codeAddress = function() {
        var geocoder = new google.maps.Geocoder();
        var address = MapInfo.map.address;
                //var address = document.getElementById('address').value;
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                $scope.map.setCenter(results[0].geometry.location);
                var marker1 = new google.maps.Marker({
                    map: $scope.map,
                    position: results[0].geometry.location
      });  
       $scope.markers.push(marker1);
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
        
}

});