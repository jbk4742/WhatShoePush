<?
    include("dbConnect.php");

        		$token = $_POST["Token"];
        		//데이터베이스에 접속해서 토큰을 저장
        		$query = "INSERT INTO fcm (Token) Values ('$token') ON DUPLICATE KEY UPDATE Token = '$token'; ";
        		mysqli_query($link, $query);

        		mysqli_close($link);
?>