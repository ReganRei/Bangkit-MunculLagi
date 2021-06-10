<?php
	include 'conn.php';

	$query = "SELECT * FROM `Kota`";
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_kota'] = $data['id_kota'];
		$rows['id_provinsi'] = $data['id_provinsi'];
		$rows['nama_kota'] = $data['nama_kota'];
		$rows['latitude'] = $data['latitude'];
		$rows['longitude'] = $data['longitude'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>