
1- El ejercicio se encuentra en app\src\main\java\navent\com. Como la consigna no pedia que el proyecto se pueda levantar, obviamente no configuré datasource ni puse annotations en la entidad ni en el servicio, ni creé un controller, etc etc..

2- Definiria indices en la tabla, agregaria un buen manejo de caché para no ir a buscar a la base los registros que ya tengo, definiria métodos de  la capa de acceso que solamente traigan las columnas necesarias para cuando no necesito todo el registro, crearia stored procedures y vistas para casos en que considere que me pueda ayudar, si necesito traer registros por X condición lo haria con todas las funciones y clausulas  de SQL para traer solo los necesarios(en vez de traer registros de más y que después desde Java tenga que filtrar los que están de más), paginaria las busquedas usando limits y offsets.

3- El formulario está en app\src\main\webapp\index.html. Usé estilos de Navent para que parezca una sección del sitio. Hice las validaciones directamente con atributos html(tambien las podria haber hecho con algun plugin de jQuery), pero para lo que pedía la consigna era suficiente.
