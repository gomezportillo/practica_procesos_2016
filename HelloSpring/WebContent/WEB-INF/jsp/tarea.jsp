<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">

  <link rel="stylesheet" type="text/css" href="css/procesos.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    <script>
        function Limpiar()
        {
          
          var frm = document.getElementById("cont");
          for (i=0;i<frm.elements.length;i++)
          {
            frm.elements[i].value="";
          }
          alert(sAux);
        }
  </script>
</head>
<body>
<h1> Inicio</h1>

</section>
<div  id='marco'>
  <div id="contenedor">
     <div class="vertical">
      <h2>Usuario</h2><br>      
      <div class="contenido" id="cont">
        <label for="movie">Prioridad: </label><input id="movie" type="number" value="0"/>
        <br>Pertenece a: <input type="text" align="right">
        <br>Fecha Limite: <input type="text" id="datepicker">
        <br> Notas: <input type="text" align="right">
        <br> Estado:
         <select name="ad" onchange="crearlink(this.form)">
        <option selected> ---</option>
        <option value="1.htm">texto 1</option>
        <option value="2.htm">texto 2</option>
        <option value="3.htm">texto 3</option>
        </select>
        <br><br><br><br>

      
        <button type="button" onclick="Limpiar()">Limpiar</button>     
        <button type="button" >Aceptar</button>    
             
      </div>
   </div>
</div>
 </div>
 <script type="text/javascript">
        mostrar_fecha(); // Invocar función
</script>
 

 
</body>
</html>