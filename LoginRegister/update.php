<?php

	require "connect.php";
	
	$studentID = $_GET["studentID"];
	$address = $_GET["address"];
	$email = $_GET["email"];
	$phone = $_GET["phone"];
	
	$sql = " UPDATE student SET address = '$address' , email = '$email', phone = '$phone' WHERE studentID = '$studentID' ";
	
	if (mysqli_query($con, $sql)) {
		$status = "ok";
	}
	
	else {
		$status = "error";
	}
	
	

	echo json_encode(array("response" => $status));
	
	mysqli_close($con);
	
?>