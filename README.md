ApiRestFull-CRUD @H2, @Maven @Jackson

genera un proyecto Spring boot con las siguientes características:
![proyecto](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/108d89f5-8810-4972-9271-0ff4874d1c04)

Tenemos una entidad llamada "Fruta", que dispone de las siguientes propiedades:

int id
String nombre
Int cantidadQuilos
Aprovechando la especificación JPA, deberás persistir esta entidad en una base de datos H2, siguiendo el patrón MVC. Para ello, dependiendo del Package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.controllers
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.domain
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.services
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.repository
La clase ubicada en el paquete controllers (FruitaController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:

http://localhost:8080/fruta/add
![Post](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/b76b8b68-94ab-4c7a-af8f-7604b43e3cbd)

http://localhost:8080/fruta/update
![Put](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/6743d5ec-fa87-475d-9b35-13f1eb96f936)

http://localhost:8080/fruta/delete/{id}
![Delete](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/4b85e991-6b18-432a-9dff-f9149d7deacc)

http://localhost:8080/fruta/getOne/{id}
![Get](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/a81ec31a-925f-47d4-bbab-4de44819bca5)

http://localhost:8080/fruta/getAll
![GetAll](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/c5bdce82-b062-4378-a79f-c26a197b5759)

Test de Integración
![TestDeIntegracion](https://github.com/Luiso-o/ApiRestFull-CRUD/assets/128043647/ccc0afc0-a9dc-4777-bc6f-6c4a3b07e950)

