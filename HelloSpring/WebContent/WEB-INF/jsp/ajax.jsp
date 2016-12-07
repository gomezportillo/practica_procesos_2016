




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function fun1()
{
var a;
 
    if (window.XMLHttpRequest)
    {// If the browser if IE7+[or]Firefox[or]Chrome[or]Opera[or]Safari
      a=new XMLHttpRequest();
    }
   else
    {//If browser is IE6, IE5
      a=new ActiveXObject("Microsoft.XMLHTTP");
    }
 
a.onreadystatechange=function()
{
  if (a.readyState==4 && a.status==200)
  {
    document.getElementById("myDiv").innerHTML=a.responseText;
   }
}
 
a.open("POST","java4s.txt",true);
a.send();
} // fun1() close
</script>
</head>
<body>
 
<div id="myDiv" style="width: 300px; height: 30px;">Click on the button below</div>
<button type="button" onclick="fun1()">Change Content</button>
 
</body>
</html>