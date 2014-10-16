app.controller('modalSignInCtrl',function($scope,$resource,$location,$rootScope,Greeting){

     var User = $resource(
                    'php/test2.php/username/:username/password/:password',
                    {
                        username:'',
                        password:''
                    },
                    {
                        'save': {method:'POST'}
                    }
                );
     $scope.logIn = function(){

        var user = User.save(
                        {
                            username:$scope.input_username,
                            password:$scope.input_password
                        },
                        function()
                            {
                                if(user.username != "" ){
                                   // $scope.$parent.account.text = user.username;
                                   Greeting.greet.text = user.username;
                                   Greeting.greet.isLogIn = true; 
                                }
                                else
                                    alert(2);
                            }
                        );
    //  $http.get('data/account.json').success(function(data) {
            
    //  $scope.user = data;
    //  if($scope.account.input_username == $scope.user.username ){
    //          $scope.account.text = $scope.user.username ;
    //          account_status = true;      
    //      }
       // });
     
    }
});