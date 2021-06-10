<?php

    include 'conn.php';

    $produk_bid = "NONE";
	$id_toko = $_GET['id_toko'];
	$judul_produk = $_GET['judul_produk'];
	$deskripsi_produk = $_GET['deskripsi_produk'];
    $foto_produk = $_GET['foto_produk'];
    $id_kategori = $_GET['id_kategori'];
    $stok = $_GET['stok'];
    $harga = $_GET['harga'];
    $total_produk_terjual = $_GET['total_produk_terjual'];
    $rating_produk = $_GET['rating_produk'];

    $query = "INSERT INTO Produk_toko
    ( 
    id_toko, 
    judul_produk, 
    deskripsi_produk, 
    foto_produk,
    id_kategori,
    stok,
    harga,
    total_produk_terjual,
    rating_produk
    ) 
    VALUES 
    ('".$id_toko.
    "', '".$judul_produk.
    "', '".$deskripsi_produk.
    "', '".$foto_produk.
    "', '".$id_kategori.
    "', '".$stok.
    "', '".$harga.
    "', '".$total_produk_terjual.
    "', '".$rating_produk.
    "')";
	
    if ($conn->query($query)) {
        printf("Record inserted successfully.<br />");
    }
    if ($conn->errno) {
        printf("Could not insert record into table: %s<br />", $conn->error);
    }
?>