<?php
	include 'conn.php';

	$query = "SELECT * FROM `Produk_review`";
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_bid'] = $data['id_bid'];
		$rows['tanggal_upload'] = $data['tanggal_upload'];
		$rows['id_expire'] = $data['id_expire'];
		$rows['id_pembeli'] = $data['id_pembeli'];
		$rows['judul_produk'] = $data['judul_produk'];
		$rows['deskripsi_produk'] = $data['deskripsi_produk'];
        $rows['produk_tag'] = $data['produk_tag'];
        $rows['status_aktif'] = $data['status_aktif'];
        $rows['harga_min'] = $data['harga_min'];
        $rows['harga_max'] = $data['harga_max'];
        $rows['total_dibutuhkan'] = $data['total_dibutuhkan'];
        $rows['id_kota'] = $data['id_kota'];
        $rows['id_provinsi'] = $data['id_provinsi'];
        $rows['alamat'] = $data['alamat'];
        $rows['id_bidder'] = $data['id_bidder'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>