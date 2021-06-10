<?php
	include 'conn.php';

    $user_id = $_GET['user_id']

	$query = "SELECT * FROM `User` WHERE user_id = " $user_id;
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
        $rows['user_id'] = $data['user_id'];
        $rows['first_name'] = $data['first_name'];
        $rows['last_name'] = $data['last_name'];
		$rows['username'] = $data['username'];
        $rows['email'] = $data['email'];
        $rows['password'] = $data['password'];
        $rows['phone_num'] = $data['phone_num'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>