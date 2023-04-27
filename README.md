# EX02-Prueba Técnica
## Clínica dental

La app es un sistema de gestión para una clínica dental. Basada en **Spring Boot**
Se compone de varios paquetes, entidades e interfaces encargados de la gestion de la clínica dental, como **citas**, **clientes**, **dentistas** y **tipos de intervenciones**.

•	**DTO**: Contiene las **entidades** que representan las tablas de la base de datos (**Cita**, **Cliente**, **Dentista**, y **TipoIntervencion**).

•	**DAO**: Contiene las **interfaces DAO** para cada entidad **ICitaDAO**, **IClienteDAO**, **IDentistaDAO** y **ITipoIntervencionDAO**. Estas interfaces heredan de **JpaRepository** y proporcionan métodos para realizar operaciones CRUD en la base de datos.

•	**SERVICE**: Contiene las interfaces **ICitaService**, **IClienteService**, **IDentistaService** y **ITipoIntervencionService** que definen los métodos CRUD. También incluye las implementaciones de estas interfaces **CitaServiceImpl**, **ClienteServiceImpl**, **DentistaServiceImpl** y **TipoIntervencionServiceImpl**, que utilizan las interfaces DAO para interactuar con la base de datos.

•	**CONTROLLER**: Contiene los controladores (**CitaController**, **ClienteController**, **DentistaController** y **TipoIntervencionController**) que manejan las solicitudes HTTP de la API REST.

------------

#### Funcionalidades principales:

•	**Gestión de citas:** Permite listar, crear, leer, actualizar y eliminar citas. Las citas están relacionadas con un cliente, un dentista y un tipo de intervención.

•	**Gestión de clientes:** Permite listar, crear, leer, actualizar y eliminar clientes. Los clientes tienen atributos como nombre, apellidos, dirección, teléfono, etc.

•	**Gestión de dentistas:** Permite listar, crear, leer, actualizar y eliminar dentistas. Los dentistas tienen atributos como nombre, apellidos, especialidad, etc.

•	**Gestión de tipos de intervenciones:** Permite listar, crear, leer, actualizar y eliminar tipos de intervenciones. Los tipos de intervenciones tienen atributos como nombre y descripción.

------------
### Módelo ER y Módelo Relacional
[Modelo ER y Moldelo Relacional](https://github.com/AlbertoDPH/adph-tsystems-ex02/blob/master/EX02_ClinicaDental.jpg)

### Consultas Postman Json
[Consultas Postman Json](https://github.com/AlbertoDPH/adph-tsystems-ex02/blob/master/Consultas%20postman%20EX02-ClinicaDental.postman_collection.json)

------------
