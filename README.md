# Community-Tutoring-App

La **Aplicación de Tutorías Comunitarias** es un sistema gestor de bases de 
datos, desarrollado como proyecto para la materia de **Bases de Datos Avanzadas**. 
Su finalidad es conectar de manera organizada y accesible a estudiantes que 
requieren apoyo académico con tutores voluntarios de su comunidad. De esta 
forma, el proyecto busca activamente reducir la brecha educativa y fomentar 
oportunidades de aprendizaje personalizado. 

---

## Objetivo
Crear una plataforma centralizada y eficiente para la gestión integral del ciclo 
de tutorías comunitarias, desde el registro de los participantes hasta la 
programación y el seguimiento de las sesiones académicas.

---

## Funcionalidades principales
- **Registro de Tutores**: nombre, especialidad, teléfono, correo, disponibilidad.
- **Registro de Estudiantes**: nombre, grado escolar, edad, escuela de procedencia y contacto.
- **Gestión de Horarios**: cada tutor puede registrar distintos días y horas de disponibilidad.
- **Catálogo de Materias**: nombre, nivel educativo y descripción.
- **Gestión de Tutorías**: fecha, hora, estado de la sesión, tutor, estudiante y materia asignada.

---

## Modelo de Datos
El sistema contempla las siguientes entidades:
- **Estudiante**
- **Tutor**
- **Horario**
- **Materia**
- **Tutoría**

Cada entidad se encuentra normalizada y relacionada para permitir consultas eficientes, por ejemplo:
- Un tutor puede tener varios horarios.
- Una tutoría pertenece a un estudiante, un tutor y una materia.

---

## Base de Datos
El proyecto se implementa en **MySQL**, con el siguiente script de creación:

```sql
CREATE DATABASE tutorias;
USE tutorias;

CREATE TABLE Estudiante (
    idEstudiante INT PRIMARY KEY AUTO_INCREMENT,
    nombreEstudiante VARCHAR(40),
    gradoEscolar VARCHAR(20),
    edad INT,
    telefonoEstudiante VARCHAR(20),
    escuelaProcedencia VARCHAR(30)
);

CREATE TABLE Tutor (
    idTutor INT PRIMARY KEY AUTO_INCREMENT,
    nombreTutor VARCHAR(40),
    telefonoTutor VARCHAR(20),
    correo VARCHAR(40),
    especialidad VARCHAR(40)
);

CREATE TABLE Horario (
    idHorario INT PRIMARY KEY AUTO_INCREMENT,
    dia ENUM('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo'),
    horaInicio TIME,
    horaFin TIME,
    idTutor INT,
    FOREIGN KEY (idTutor) REFERENCES Tutor(idTutor) ON DELETE CASCADE
);

CREATE TABLE Materia (
    idMateria INT PRIMARY KEY AUTO_INCREMENT,
    nombreMateria VARCHAR(40),
    nivel VARCHAR(20),
    descripcion VARCHAR(80)
);

CREATE TABLE Tutoria (
    idTutoria INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    hora TIME,
    estado ENUM('Programada','En curso','Completada'),
    idTutor INT,
    idEstudiante INT,
    idMateria INT,
    FOREIGN KEY (idTutor) REFERENCES Tutor(idTutor) ON DELETE CASCADE,
    FOREIGN KEY (idEstudiante) REFERENCES Estudiante(idEstudiante) ON DELETE CASCADE,
    FOREIGN KEY (idMateria) REFERENCES Materia(idMateria) ON DELETE CASCADE
);
```

---

## Storyboard / Prototipo
Puedes visualizar el prototipo de la aplicación en los siguientes enlaces:
- [Diseño en Figma](https://www.figma.com/design/d0TvSYbRHQXQL63LMuxMsj/Community-Tutoring-App?node-id=1-3&m=dev&t=zaDrom7bGK3GjwUq-1)
- [Diagrama en Draw.io](https://drive.google.com/file/d/1M9R7WKziW42o52w3bUgcu1iXSihM3AzH/view?usp=sharing)

---

## Equipo de Desarrollo
Proyecto realizado por el **Equipo #3** - Ingeniería en Software:
- José Alfredo Guzman Moreno
- Manuel de Jesus Cortez Villa
- Angel Gabriel Beltran Duarte
