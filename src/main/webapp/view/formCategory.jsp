<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Juan Esteban Murcia Ramirez">
    <meta name="description" content="Formulario de registro de usuario de la pagina web">
    <meta name="keywords" content="HTML, CSS, Java">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login de usuarios</title>
    <link rel="icon" href="img/icon.png" type="image/x-icon" sizes="16x16">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stylesformregister.css">
</head>
<body>
<div class="container">
    <header></header>
    <nav></nav>
    <main>
        <div class="form">
            <form action="formCategory" method="post">
                <div class="container">
                    <h1><b>Registro Categoria</b></h1>
                </div>
                <div class="mb-3">
                    <label for="category_name" class="form-label">Nombre Categoria:</label>
                    <input type="text" class="form-control" id="category_name"  name="category_name" placeholder="Nombre de la categoria" required autofocus pattern="[a]\s[a][A-Za-z][{2,40}">
                </div>
                <div class="container">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </form>
        </div>
    </main>
    <footer>Todos los derechos reservados a My APP
    </footer>
</div>
</body>
</html>