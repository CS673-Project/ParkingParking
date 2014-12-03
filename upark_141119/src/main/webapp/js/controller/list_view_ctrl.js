// angularJS navCtrl implementation for nav
app.controller('listViewCtrl', function($scope,$location,$resource,$routeParams){
	
	 var Search = $resource("/upark/search");
	 
     var markers = Search.save(
     		{
 				address:$routeParams.address
 			},
 			function(){
 				if(markers.list.length != 0)
 					$scope.markers = markers.list;
 				else
 					$location.path("/");
 			}
 		);
     $scope.predicate = '-address1';
});
