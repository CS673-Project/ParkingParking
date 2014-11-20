<?php
	session_start();

	if ($_SERVER['REQUEST_METHOD'] == 'POST' && empty($_POST))
	    $account = json_decode(file_get_contents('php://input'));

	if(isset($account->action))
		$action = $account->action;
	else
		$action ='';

	class user{
		public $username = '';
		public $status = false;
	}
	
	if($action == "signIn"){


  		if(isset($_SESSION['user']) && $_SESSION['user']->status == true)
  			echo(json_encode($_SESSION['user']));
  		else
  			echo(json_encode(new user()));
  	}

  	if($action == "logOut"){
  		unset($_SESSION['user']);
  		echo(json_encode(new user()));
  	}
 		
	// echo("{'name':'1'}");
	// if($test == '1')
	// if($test==1)
	// echo ('{
	//   "username":"sx",
	//   "password": "111111"
	//  }');
	// else{
	// echo ('{
	//   "username": "sx",
	//   "password": "111111"
	//  }');
	// }
?>