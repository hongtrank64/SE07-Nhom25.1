<?php

	require "connect.php";
	
	$sql = " SELECT eventID, eventName, timeStart, timeEnd, address, requirement, status FROM event";
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