<?php
	include 'conn.php';

	$query = "SELECT * FROM `Produk_toko`";
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['produk_bid'] = $data['produk_bid'];
		$rows['id_toko'] = $data['id_toko'];
		$rows['judul_produk'] = $data['judul_produk'];
		$rows['deskripsi_produk'] = $data['deskripsi_produk'];
        $rows['foto_produk'] = $data['foto_produk'];
        $rows['id_kategori'] = $data['id_kategori'];
        $rows['stok'] = $data['stok'];
        $rows['harga'] = $data['harga'];
        $rows['total_produk_terjual'] = $data['total_produk_terjual'];
        $rows['rating_produk'] = $data['rating_produk'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>