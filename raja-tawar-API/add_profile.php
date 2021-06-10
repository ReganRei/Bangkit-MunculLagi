<?php

    include 'conn.php';

    $id_toko = "NONE";
    $user_id = $_GET['user_id'];
    $nama_toko = $_GET['nama_toko'];
	$deskripsi_toko = $_GET['deskripsi_toko'];
    $rating_toko = $_GET['rating_toko'];
    $foto_profile = $_GET['foto_profile'];
    $alamat = $_GET['alamat'];
    $id_kota = $_GET['id_kota'];
    $id_provinsi = $_GET['id_provinsi'];
    $total_barang_terjual = $_GET['total_barang_terjual'];

    $query = "INSERT INTO Profile
    ( 
    user_id,
    nama_toko, 
    deskripsi_toko, 
    rating_toko,
    foto_profile,
    alamat,
    id_kota,
    id_provinsi,
    total_barang_terjual
    ) 
    VALUES 
    ('".$user_id.
    "', '".$nama_toko.
    "', '".$deskripsi_toko.
    "', '".$rating_toko.
    "', '".$foto_profile.
    "', '".$alamat.
    "', '".$id_kota.
    "', '".$id_provinsi.
    "', '".$total_barang_terjual.
    "')";
	// $msql = mysqli_query($conn, $query);

    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>