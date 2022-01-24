<?php

	require "connect.php";
	
	$studentID = $_GET["studentID"];
	
	$sql = " SELECT subject.subjectCode, subject.subjectTitle, subject.credits, subject.teacherName, subject.room, 
	subject.timeStart, subject.timeEnd, subject.day
			FROM subject JOIN studentsubject ON studentsubject.subjectCode = subject.subjectCode 
			WHERE studentID = '$studentID' ";
	$result = mysqli_query($con, $sql);
	
	if (mysqli_num_rows($result)) {
		while($row = mysqli_fetch_array($result)) {
			$output[] = $row;
		}
		echo(json_encode($output));
	}
	
	else 
		echo("faild");
		
	
		
	
	
	
	mysqli_close($con);
	
?>