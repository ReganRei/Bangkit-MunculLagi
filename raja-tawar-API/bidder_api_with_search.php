<?php
	include 'conn.php';

    $id_bid = $_GET['id_bid'];

	$query = "SELECT * FROM `Bidder` WHERE id_bid = " + $id_bid;
	$msql = mysqli_query($conn, $query);

	$jsonArray = array();

	while ($data = mysqli_fetch_assoc($msql)) {
		
		$rows['id_bidder'] = $data['id_bidder'];
		$rows['tanggal_bid'] = $data['tanggal_bid'];
		$rows['id_bid'] = $data['id_bid'];
		$rows['messages'] = $data['messages'];
		$rows['gambar'] = $data['gambar'];
		$rows['status_pemenangan'] = $data['status_pemenangan'];
		$rows['id_user'] = $data['id_user'];

		array_push($jsonArray, $rows);
	}

	echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>