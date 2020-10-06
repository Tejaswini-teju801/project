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
/**
 * 
 */