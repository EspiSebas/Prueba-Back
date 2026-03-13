# Autos Spring Boot API

Este proyecto es una API REST construida con **Spring Boot** para la gestión de autos. Permite crear, listar, actualizar y eliminar autos desde un frontend o cliente HTTP.

---

### Autos

- **GET** `/car/all` – Listar todos los autos  
- **POST** `/car/create` – Crear un nuevo auto  
- **PUT** `/car/update/{id}` – Actualizar un auto por su ID  
- **DELETE** `/car/delete/{id}` – Eliminar un auto por su ID  

### Autenticación

- **POST** `/auth/register` – Registrar un nuevo usuario  
- **POST** `/auth/login` – Iniciar sesión y obtener token  

---

Cuenta con una coleccion de Postman la cual encontrara en el src
Cuenta con el script de la base de datos con datos cargados - El nombre del archivo es baseDatos.sql



