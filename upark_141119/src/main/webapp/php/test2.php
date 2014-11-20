<?php
	// $content_type_args = explode(';', $_SERVER['CONTENT_TYPE']);
	// 	if ($content_type_args[0] == 'application/json')
	// 	  $_POST = json_decode(file_get_contents('php://input'),true);
	
	// $username = json_decode(file_get_contents('php://input'),true);





	require_once('database.php');	
	session_start();
	class user{
			public $username = "";
			public $status = false;
		}

	if ($_SERVER['REQUEST_METHOD'] == 'POST' && empty($_POST))
	    $account = json_decode(file_get_contents('php://input'));
	if(isset($account->username))
		$username = $account->username;
	else
		$username ='';

	if(isset($account->password))
		$password = $account->password;
	else
		$password ='';

	
	$user = new user();

	// echo json_encode($user);
	//  is_valid_customer_login($username,$password);


	if(is_valid_customer_login($username,$password)){
		$user->username = $username;
		$user->status = true;
		$_SESSION['user'] = $user;
		echo(json_encode($user));
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