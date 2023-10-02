<?php

$conn=new mysqli("localhost","root","","learnify");
if($conn->connect_error)
{
	die("connection failed:". $conn->connect_error);
}

$name=$_POST['name'];
$email=$_POST['email'];
$subject=$_POST['subject'];
$message=$_POST['message'];

$sql="INSERT INTO contact(name,email,subject,message)VALUES ('$name','$email','$subject','$message')";

if ($conn->query($sql)===TRUE) 
{
	header("refresh:0;url=contact.html");
}
else
{
	header("refresh:0;url=contact.html");
}
?>