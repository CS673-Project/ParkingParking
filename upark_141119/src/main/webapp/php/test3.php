<?php
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

	if(isset($account->repassword))
		$repassword = $account->repassword;
	else
		$repassword ='';

	if(isset($account->firstname))
		$firstname = $account->firstname;
	else
		$firstname ='';

	if(isset($account->lastname))
		$lastname = $account->lastname;
	else
		$lastname ='';  		
 	

	if(!is_valid_customer_email($username))
 		$customer_id = add_customer($username, $firstname,$lastname, $password, $repassword);
 	else
 		$customer_id = 0;

 	$user = new user();

 	if($customer_id != 0){
 		$user->username = $username;
		$user->status = true;
		$_SESSION['user'] = $user;
		echo(json_encode($user));	
 	}
 	else
 		echo(json_encode($user));
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