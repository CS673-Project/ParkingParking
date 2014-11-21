app.controller('modalSignInCtrl',function($scope,$resource,$location,Greeting){

    $scope.invalid_account = '';
    var User = $resource(
                    'login/abc',
                    {
                        username:'',
                        password:''
                    },
                    {
                        'save': {method:'PUT'}
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
                                   $('#modal-sign-in').modal('hide');
                                }
                                else{
                                    $scope.invalid_account = "Incorrect username or password";
                                }
                            }
                        );

    }

    $scope.register = function(){   
        $("#modal-sign-in").modal('hide');
        $("#modal-register").modal().css({'margin-top': function(){return ($(this).height()/2-120);}});
    }
});