<?php
	// $content_type_args = explode(';', $_SERVER['CONTENT_TYPE']);
	// 	if ($content_type_args[0] == 'application/json')
	// 	  $_POST = json_decode(file_get_contents('php://input'),true);
		
	// $username = json_decode(file_get_contents('php://input'),true);
	session_start();
	class user{
			public $username = "";
			public $status = false;
		};

	if ($_SERVER['REQUEST_METHOD'] == 'POST' && empty($_POST))
	    $account = json_decode(file_get_contents('php://input'));

	if(isset($account->username))
		$username = $account->username;
	// else
	// 	$username ='';
		// $username = $_REQUEST['username'];
		$user = new user();
		
	if(isset($_SESSION['user'])&&$username == $_SESSION['user']->username){
		echo(json_encode($_SESSION['user']));
	}
		
	else{
		echo(json_encode($user));
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