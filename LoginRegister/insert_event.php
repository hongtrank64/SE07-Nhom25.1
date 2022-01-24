<?php

	require "connect.php";
	
	$eventID = $_GET["eventID"];
	$eventName = $_GET["eventName"];
	$timeStart = $_GET["timeStart"];
	$timeEnd = $_GET["timeEnd"];
	$address = $_GET["address"];
	$requirement = $_GET["requirement"];
	$status = $_GET["status"];
	
	$sql_check = " SELECT eventID FROM event WHERE eventID = '$eventID' ";
	$result_check = mysqli_query($con, $sql_check);
	
	if (mysqli_num_rows($result_check) > 0) {
		$status = "exist";
	}

	else {
		$sql = " INSERT INTO event(eventID, eventName, timeStart, timeEnd, address, requirement, status) 
				VALUES ('$eventID', '$eventName', '$timeStart', '$timeEnd', '$address', '$requirement', '$status')";
					
		
		
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