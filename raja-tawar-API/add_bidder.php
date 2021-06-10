<?php

    include 'conn.php';

    $id_bidder = "NONE";
	$tanggal_bid = "NONE";
	$id_bid = $_GET['id_bid'];
	$messages = "NONE";
	$gambar = "NONE";
	$status_pemenangan = "NONE";
    $id_user = $_GET['id_user'];

    $query = "INSERT INTO Bidder
    ( 
    id_bid,
    messages,
    gambar,
    id_user,
    ) 
    VALUES 
    ('".$id_bid.
    "', '".$messages.
    "', '".$gambar.
    "', '".$id_user.
    "')";
	
    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>