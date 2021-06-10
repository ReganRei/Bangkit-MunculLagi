<?php

    include 'conn.php';

    $id_bid = "NONE";
	$tanggal_upload = "None";
	$tanggal_expire = "None";
	$id_pembeli = $_GET['id_pembeli'];
	$judul_produk = $_GET['judul_produk'];
	$deskripsi_produk = $_GET['deskripsi_produk'];
    $produk_tag = "NONE";
    $status_aktif = "NONE";
    $harga_min = $_GET['harga_min'];
    $harga_max = $_GET['harga_max'];
    $total_dibutuhkan = $_GET['total_dibutuhkan'];
    $id_kota = "NONE";
    $id_provinsi = "NONE";
    $alamat = "NONE";
    $id_bidder = "NONE";
    $gambar = $_GET['gambar'];

    $query = "INSERT INTO Produk_bidding 
    (   
    id_pembeli,
    judul_produk, 
    deskripsi_produk, 
    harga_min,
    harga_max,
    total_dibutuhkan,
    gambar
    ) 
    VALUES 
    ('".$id_pembeli.
    "', '".$judul_produk.
    "', '".$deskripsi_produk.
    "', '".$harga_min.
    "', '".$harga_max.
    "', '".$total_dibutuhkan.
    "', '".$gambar.
    "')";
	
    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>