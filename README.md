# Proyecto HOY NO CIRCULA - CONECTA
## Autor: Pablo Suntaxi Heredia
El repositorio contiene **frontend y backend en un mismo proyecto**, organizados de la siguiente forma:

- El backend se encuentra en la carpeta autos/

- El frontend se encuentra en la carpeta frontend-conecta/

---

# Backend – Spring Boot

Aplicación Backend desarrollada en **Spring Boot** para el registro de vehículos y la consulta de circulación según la normativa de *Pico y Placa*.  

---

## Tecnologías utilizadas

- Java 21
- Gradle (incluido vía Gradle Wrapper)
- PostgreSQL 
---

## Requisitos previos

- **Java JDK 21**
- **PostgreSQL** (local o remoto)

---

## Configuración

El backend usa **variables de entorno** para la conexión a la base de datos.

Configurar las variables de entorno **antes de ejecutar**, Por ejemplo:

### Windows (PowerShell)
```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/autos"
$env:DB_USER="postgres"
$env:DB_PASSWORD="tu_password"
```
---
La base de datos debe existir previamente.
Las tablas se crean automáticamente al iniciar la aplicación.

### Linux / macOS
```powershell
export DB_URL=jdbc:postgresql://localhost:5432/autos
export DB_USER=postgres
export DB_PASSWORD=tu_password
```
---
La base de datos debe existir previamente.
Las tablas se crean automáticamente al iniciar la aplicación.

## Ejecución
### Windows (PowerShell)
```powershell
.\gradlew bootRun

```
### Linux / macOS
```powershell
./gradlew bootRun

```

La aplicación se ejecutará en: http://localhost:8080

### Endpoints principales

- Registrar auto
```
POST /vehiculos/registrar
```
- Consultar circulación
```
GET /vehiculos/consultar?placa=ABC1234&fechaHora=2026-01-31T15:00
```

- Listar autos
```
GET /vehiculos
```
---
---

# Frontend - Angular

Aplicación frontend desarrollada en **Angular** para el registro de vehículos y la consulta de circulación según la normativa de *Pico y Placa*.  

---

## Tecnologías utilizadas

- Angular 20
- Angular Material
- TypeScript
- RxJS
- Node.js / npm

---

## Requisitos previos

- Node.js (v18 o superior recomendado)
- Angular CLI
- Backend en ejecución (por defecto en `http://localhost:8080`)

---

## Configuración del entorno

El frontend consume el backend mediante la siguiente variable de entorno:

```ts
// src/environments/environment.ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080'
};
```

Asegúrese de que el backend esté corriendo en el puerto **8080**.

---

## Instalación y ejecución

Desde la carpeta del frontend:

```bash
npm install
ng serve
```

La aplicación estará disponible en:

```
http://localhost:4200
```
> Nota: si el puerto **4200** está ocupado, Angular utilizará automáticamente otro puerto disponible (4201, 4202, etc.).  
> Revisar la consola al ejecutar `ng serve`.
---

## Funcionalidades principales

- Registro de vehículos
- Consulta de circulación por placa y fecha/hora
- Listado de vehículos registrados
- Validaciones y manejo de errores desde el backend
- Interfaz construida con Angular Material


