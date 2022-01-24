<?php

	require "connect.php";
	
	$studentID = $_GET["studentID"];
	$fullname = $_GET["fullname"];
	$gender = $_GET["gender"];
	$birthday = $_GET["birthday"];
	$address = $_GET["address"];
	$classroom = $_GET["classroom"];
	$email = $_GET["email"];
	$phone = $_GET["phone"];
	$GPA = $_GET["GPA"];
	$position = $_GET["position"];
	
	$sql_check = " SELECT studentID FROM student WHERE studentID = '$studentID' ";
	$result_check = mysqli_query($con, $sql_check);
	
	if (mysqli_num_rows($result_check) > 0) {
		$status = "exist";
	}

	else {
		$sql = " INSERT INTO student (studentID, fullname, gender, birthday, address, classroom, email, phone, GPA, position) 
					VALUES ('$studentID', '$fullname', '$gender', '$birthday', '$address', '$classroom', '$email', '$phone', '$GPA', '$position')";
		
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