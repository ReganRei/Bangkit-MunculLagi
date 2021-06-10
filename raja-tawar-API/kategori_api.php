<?php
	include 'conn.php';

	$query = "SELECT * FROM `Kategori`";
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_kategori'] = $data['id_kategori'];
		$rows['nama_kategori'] = $data['nama_kategori'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>