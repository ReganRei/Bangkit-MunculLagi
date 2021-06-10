<?php

    include 'conn.php';

    $user_id = "NONE";
    $first_name = $_GET['first_name'];
    $last_name = "NONE";
	$username = $_GET['username'];
    $email = $_GET['email'];
    $password = "NONE";
    $phone_num = $_GET['phone_num'];

    $query = "INSERT INTO User (first_name, username, email, phone_num) 
    VALUES 
    ('".$first_name.
    "', '".$username.
    "', '".$email.
    "', '".$phone_num.
    "')";

    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>