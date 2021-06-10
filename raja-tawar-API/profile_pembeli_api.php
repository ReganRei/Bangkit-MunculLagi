<?php
	include 'conn.php';

	$user_id = $_GET['user_id'];

	$query = "SELECT * FROM `Profile_pembeli` WHERE id_user = " + $id_user;
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_pembeli'] = $data['id_pembeli'];
        $rows['user_id'] = $data['user_id'];
        $rows['nama_pembeli'] = $data['nama_pembeli'];
        $rows['foto_profile'] = $data['foto_profile'];
		$rows['deskripsi_pembeli'] = $data['deskripsi_pembeli'];
        $rows['status_pembeli'] = $data['status_pembeli'];
        $rows['id_kota'] = $data['id_kota'];
        $rows['id_provinsi'] = $data['id_provinsi'];
        $rows['alamat'] = $data['alamat'];
        $rows['total_barang_terbeli'] = $data['total_barang_terbeli'];
        $rows['rating_pembeli'] = $data['rating_pembeli'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>