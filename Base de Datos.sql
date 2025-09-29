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
    FOREIGN KEY (idTutor) REFERENCES Tutor(idTutor)
    ON DELETE CASCADE
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
    FOREIGN KEY (idTutor) REFERENCES Tutor(idTutor),
    FOREIGN KEY (idEstudiante) REFERENCES Estudiante(idEstudiante),
    FOREIGN KEY (idMateria) REFERENCES Materia(idMateria)
    ON DELETE CASCADE
);