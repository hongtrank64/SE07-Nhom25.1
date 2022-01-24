<?php

	require "connect.php";
	
	$id = $_GET["id"];
	$name = $_GET["name"];
	$money = $_GET["money"];
	$root = $_GET["root"];
	
	$sql_check = " SELECT id FROM money WHERE id = '$id' ";
	$result_check = mysqli_query($con, $sql_check);
	
	if (mysqli_num_rows($result_check) > 0) {
		$status = "exist";
	}

	else {
		$sql = " INSERT INTO money(id, name, money, root) 
				VALUES ('$id', '$name', '$money', '$root')";
					
		
		
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