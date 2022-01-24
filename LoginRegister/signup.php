<?php

	require "connect.php";
	
	$studentID = $_GET["studentID"];
	$username = $_GET["username"];
	$password = $_GET["password"];

	
	//kiem tra ten dang nhap ton tai chua
	$sql_1 = "SELECT username FROM account WHERE username ='$username' ";
	
	$result_1 = mysqli_query($con, $sql_1);	
	
	if (mysqli_num_rows($result_1) > 0) {
		$status = "exist";
	}
	
	else {
		$sql = "INSERT INTO account (studentID, username, password, root) VALUES ('$studentID', '$username', '$password', 2)";
		
		if (mysqli_query($con, $sql)) {
			$status = "ok";
		}
		
		else {
			$status = "error";
		}
		
	}
	
	echo json_encode(array("response" => $status));
	
	mysqli_close($con);
										
		
?>