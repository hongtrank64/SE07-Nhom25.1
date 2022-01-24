<?php

	require "connect.php";
	
	$studentID = $_GET["studentID"];
	
	$sql = " SELECT trainingscores.sem_year, trainingscores.scores FROM trainingscores 
			WHERE trainingscores.studentID = '$studentID' ";
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