<?php
	include 'conn.php';

	$query = "SELECT * FROM `Profile`";
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_toko'] = $data['id_toko'];
        $rows['user_id'] = $data['user_id'];
        $rows['nama_toko'] = $data['nama_toko'];
		$rows['deskripsi_toko'] = $data['deskripsi_toko'];
        $rows['rating_toko'] = $data['rating_toko'];
        $rows['foto_profile'] = $data['foto_profile'];
        $rows['alamat'] = $data['alamat'];
        $rows['id_kota'] = $data['id_kota'];
        $rows['id_provinsi'] = $data['id_provinsi'];
        $rows['total_barang_terjual'] = $data['total_barang_terjual'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>