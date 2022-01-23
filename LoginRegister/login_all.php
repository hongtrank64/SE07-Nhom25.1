<?php
	require "connect.php";

	$username = $_GET["username"];
	$password = $_GET["password"];
	
	$sql_student = "SELECT student.fullname, account.studentID, root FROM account, student WHERE student.studentID = account.studentID AND 
			username = '$username' AND password = '$password' LIMIT 1";
	$sql_teacher = "SELECT studentID, root FROM account WHERE username = '$username' AND password = '$password' LIMIT 1";

	
	$result_student = mysqli_query($con, $sql_student);
	$result_teacher = mysqli_query($con, $sql_teacher);
	
	
	
	if (mysqli_num_rows($result_student) == 0 && mysqli_num_rows($result_teacher) == 0) {
		$status = "failed";
		echo json_encode(array("response" => $status));
		
	}
	
	else  {
		// case for student login
		$row_student = mysqli_fetch_assoc($result_student);//tra gia tri cua hang trong result_student
		$returnRoot = $row_student['root'];
		if ($returnRoot == 2) {
			$returedFullname = $row_student['fullname'];
			$returnStudentID = $row_student['studentID'];
			$status = "ok_student";
			echo json_encode(array("response" => $status, 
								"root" => $returnRoot,
								"name" => $returedFullname,
								"studentID" => $returnStudentID));
		}
		
		// case for teacher login
		$row_teacher = mysqli_fetch_assoc($result_teacher); // tra gtri cua hang trong result_teacher
		$returnRoot = $row_teacher['root'];
		if($returnRoot == 1) {
			$returnTeacherID = $row_teacher['studentID'];
			$status = "ok_teacher";
			echo json_encode(array("response" => $status, 
								"root" => $returnRoot,
								"studentID" => $returnTeacherID));
		}
	}

	mysqli_close($con);

	
	
	 
?>