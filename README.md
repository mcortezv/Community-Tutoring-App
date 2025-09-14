# Community-Tutoring-App

Aplicación diseñada para gestionar **tutorías comunitarias**, conectando a estudiantes con tutores de forma accesible y organizada. Este proyecto surge como parte de la materia **Bases de Datos Avanzadas** y busca reducir la brecha educativa, ofreciendo apoyo académico personalizado.

---

## 🚀 Objetivo
Facilitar la **asignación de tutorías** en comunidades, permitiendo:
- Registro de tutores con especialidades y horarios.
- Registro de estudiantes con datos escolares.
- Catálogo de materias disponibles.
- Gestión de sesiones de tutorías (programadas, en curso, completadas).

---

## 🛠️ Funcionalidades principales
- **Registro de Tutores**: nombre, especialidad, teléfono, correo, disponibilidad.
- **Registro de Estudiantes**: nombre, grado escolar, edad, escuela de procedencia y contacto.
- **Gestión de Horarios**: cada tutor puede registrar distintos días y horas de disponibilidad.
- **Catálogo de Materias**: nombre, nivel educativo y descripción.
- **Gestión de Tutorías**: fecha, hora, estado de la sesión, tutor, estudiante y materia asignada.

---

## 🗂️ Modelo de Datos
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

## 💾 Base de Datos
El proyecto se implementa en **MySQL**, con el siguiente script de creación:

```sql
CREATE DATABASE tutorias;
USE tutorias;

CREATE TABLE Estudiante (
 id_estudiante INT PRIMARY KEY,
 nombre VARCHAR(40),
 grado_escolar VARCHAR(20),
 edad INT,
 telefono VARCHAR(20),
 escuela_procedencia VARCHAR(30)
);

CREATE TABLE Tutor (
 id_tutor INT PRIMARY KEY,
 nombre VARCHAR(40),
 telefono VARCHAR(20),
 correo_electronico VARCHAR(40),
 especialidad ENUM('Materia', 'Área de conocimiento')
);

CREATE TABLE Horario (
 id_horario INT,
 dia ENUM('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo'),
 hora_inicio TIME,
 hora_fin TIME,
 id_tutor INT,
 PRIMARY KEY(id_horario, id_tutor),
 FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor)
);

CREATE TABLE Materia (
 id_materia INT PRIMARY KEY,
 nombre VARCHAR(40),
 nivel VARCHAR(20),
 descripcion VARCHAR(80)
);

CREATE TABLE Tutoria (
 id_tutoria INT PRIMARY KEY,
 fecha DATE,
 hora TIME,
 estado ENUM('Programada','En curso','Completada'),
 id_tutor INT,
 id_estudiante INT,
 id_materia INT,
 FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor),
 FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
 FOREIGN KEY (id_materia) REFERENCES Materia(id_materia)
);
```

---

## 🎨 Storyboard / Prototipo
Puedes visualizar el prototipo de la aplicación en los siguientes enlaces:
- [Diseño en Figma](https://www.figma.com/design/d0TvSYbRHQXQL63LMuxMsj/Community-Tutoring-App?node-id=1-3&m=dev&t=zaDrom7bGK3GjwUq-1)
- [Diagrama en Draw.io](https://drive.google.com/file/d/1M9R7WKziW42o52w3bUgcu1iXSihM3AzH/view?usp=sharing)

---

## 👥 Equipo de Desarrollo
Proyecto realizado por el **Equipo #3** – Ingeniería en Software:
- José Alfredo Guzman Moreno
- Manuel de Jesus Cortez Villa
- Angel Gabriel Beltran Duarte

---

## 📌 Estado del Proyecto
- ✅ Modelo Entidad–Relación (MER)
- ✅ Modelo Relacional
- ✅ Script SQL de creación de base de datos
- ✅ Storyboard y prototipo en Figma
- 🔜 Desarrollo de la aplicación
