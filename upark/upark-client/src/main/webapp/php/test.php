<?php
	session_start();

		class user{
			public $username = '';
			public $status = false;
		}
		

  		if(isset($_SESSION['user']) && $_SESSION['user']->status == true)
  			echo(json_encode($_SESSION['user']));
  		else
  			echo(json_encode(new user()));
  		
 		
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