


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">

  <link rel="stylesheet" type="text/css" href="css/procesos.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AÒadir una Tarea</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
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
       <form action="tareaAÒadida.jsp" method="post"> 
       <br>Nombre: <input type="text" align="right" name="nombre">
        <label for="movie">Prioridad: </label><input id="movie" type="number" value="0" name="prioridad"/>
        <br>Pertenece a: <input type="text" align="right" name="pertenece">
        <br>Fecha Limite: <input type="text"  id="datepicker" name="fecha">
        <br> Notas: <input type="text" align="right" name="notas">
        <br> Estado:
         <select onchange="crearlink(this.form)" name="estado">
	        
	        <option value="1">texto 1</option>
	        <option value="2">texto 2</option>
	        <option value="3">texto 3</option>
	     </select>
        <br><br><br><br>

     
        <button type="button" onclick="Limpiar()">Limpiar</button> 
            
          
              
        	<button type="submit" value="Aceptar" name="Aceptar"/>Aceptar</button> <br>
        </form>
      </div>
   </div>
</div>
 </div>
 <script type="text/javascript">
        mostrar_fecha(); // Invocar funci√≥n
</script>
 

 
</body>
</html>