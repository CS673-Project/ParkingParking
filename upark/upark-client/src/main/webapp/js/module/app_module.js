// the angularJS module intetface for all controllers
var app = angular.module('UPark', ['ngRoute','google-maps']);
// routing manage
app.config(['$routeProvider', function($routeProvider) {
$routeProvider.
      when('/', {templateUrl: 'view/content.html', controller: mapCtrl}).
      when('/view/:userID', {templateUrl: 'view/account_detail.html', controller: accountDetailCtrl}).
      otherwise({redirectTo: '/'});
}]);