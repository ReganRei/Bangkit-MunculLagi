<?php

    include 'conn.php';

    $id_pembeli = "NONE";
    $user_id = $_GET['user_id'];
    $nama_pembeli = $_GET['nama_pembeli'];
    $foto_profile = "NONE";
	$deskripsi_pembeli = "NONE";
    $status_pembeli = "NONE";
    $id_kota = "NONE";
    $id_provinsi = "NONE";
    $alamat = "NONE";
    $total_barang_terbeli = "NONE";
    $rating_pembeli = "NONE";

    $query = "INSERT INTO Profile_pembeli
    ( 
    user_id,
    nama_pembeli,
    ) 
    VALUES 
    ('".$user_id.
    "', '".$nama_pembeli.
    "')";
	// $msql = mysqli_query($conn, $query);

    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>