

<html>
<head>
<script type="text/javascript">
function getData()
{
var nm=document.getElementById("name1").value
var uphno=document.getElementById("phno").length
var uemail = document.f1.email;
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(nm=="")
{
  alert("Please enter valid name");
return false;
}
else if(isNaN(uphno)||uphno<1||uphno>10)
{
alert("Please enter valid phno with 10 digits only");
return false;
}
else if(!(uemail.value.match(mailformat)))
{
alert("Please enter valid email");
return false;
}
else
return true;
}

</script>
</head>
<body background="C:\images\background.png">
<strong><pre><center>
<form  name="f1" action="http://localhost:8989/FileUpload/register" method="post" onSubmit="return getData()">
<h1> <font color="#8B008B">WELCOME TO EASY UPLOAD</font></h1>
<h2><font color="#800000">FILL DETAILS TO SIGNUP!!!</font></h2>
<table id="tb1"><tr>
<td>ENTER NAME:</td><td><input type="text" name="name" id="name" required><br></td></tr>
<tr>
<td>ENTER LOGINID:</td><td><input type="text" name="loginid" id="loginid" required><br></td></tr>
<td>ENTER LOGIN PASSWORD:</td><td><input type="password" name="pwd" id="pwd" required><br></td></tr><tr>
<td>ENTER EMAIL:</td><td><input type="email" name="email" id="email" required><br></td></tr><tr>
<td>ENTER ADDRESS:</td><td><input type="text" name="address" id="addr" required><br></td></tr><tr>
<td>ENTER PHONE NO.:</td><td><input type="text" name="phno" id="phno" required><br></td></tr><tr>
</table>
<input type="submit" name="sub" value="REGISTER" />
<!-- <button name="b1" value="REGISTER">REGISTER</button> -->
</form>
</center></pre></strong>
</body>
</html>