<?php

	require "connect.php";
	
	$output = array();
	
	$studentID = $_GET['studentID'];
	
	$sql = " SELECT studentID, fullname, gender, birthday, address, classroom, email, phone, GPA FROM student 
				WHERE studentID = '$studentID' ";
	$result = mysqli_query($con, $sql);
	
	if (mysqli_num_rows($result) == 0) {
		$status = "failed";
		echo json_encode(array("response" => $status));
	}
	
	else {
		$row = mysqli_fetch_assoc($result);
		$output['response'] = "ok";
		$output['studentID'] = $row['studentID'];
		$output['fullname'] = $row['fullname'];
		$output['gender'] = $row['gender'];
		$output['birthday'] = $row['birthday'];
		$output['address'] = $row['address'];
		$output['classroom'] = $row['classroom'];
		$output['email'] = $row['email'];
		$output['phone'] = $row['phone'];
		$output['GPA'] = $row['GPA'];
		
		echo json_encode($output);
		
	}
	
	mysqli_close($con);
	
?>