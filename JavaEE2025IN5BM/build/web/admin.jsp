<%-- 
    Document   : admin
    Created on : 22/07/2025, 16:43:15
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza & Co. | Ventana de Administrador</title>
    <link rel="stylesheet" href="Styles/admin.css">
</head>
<body>
    
    <nav>
        <ul>
            <li><a href="Controlador?menu=Cliente" target="Contenido" >Clientes</a></li>
            <li><a href="Controlador?menu=Proveedor" target="Contenido">Proveedores</a></li>
            <li><a href="Controlador?menu=Producto" target="Contenido">Productos</a></li>
            <li><a href="Controlador?menu=Empleado" target="Contenido">Empleados</a></li>
            <li><a href="Controlador?menu=Venta" target="Contenido">Ventas</a></li>
            <li><a href="Controlador?menu=DetalleVenta" target="Contenido">Detalle Ventas</a></li>
            <li><a href="Controlador?menu=Factura" target="Contenido">Facturas</a></li>
            <li><a href="Controlador?menu=Compras" target="Contenido">Compras</a></li>
            <li><a href="Controlador?menu=DetalleCompra" target="Contenido">Detalle Compras</a></li>
            <li class="avatar">
                <img src="img/UsuarioAdmin.png" alt="Avatar">
                <ul class="avatar-menu">
                    <li><a href="principal.jsp">Cambiar Cuenta</a></li>
                    <li><a href="index.jsp">Cerrar sesión</a></li>
                </ul>
            </li>
        </ul>
    </nav>

        <div class="panel">
            <h2>Bienvenido a la ventana de Administrador</h2>
        </div>
    <iframe name="Contenido" width="100%" height="1000" style="border:0;"></iframe>
</body>
</html>