-- Aquí metí a los primeros 4 estudiantes, los que ya estaban en el código de java.
INSERT INTO Estudiante (nombreEstudiante, gradoEscolar, edad, telefonoEstudiante, escuelaProcedencia) VALUES
('Manuel Cortez', 'Secundaria', 15, '5512345678', 'Escuela Uno'),
('Sebastian Escalante', 'Preparatoria', 17, '5598765432', 'Escuela Dos'),
('Ana Garcia', 'Universidad', 20, '5555550000', 'Universidad Central'),
('Sofia Lopez', 'Primaria', 10, '5511112222', 'Escuela Tres');

-- Y aquí agregué unos cuantos más para que haya más variedad.
-- Puse a una de prepa, otro de universidad y uno de secundaria.
INSERT INTO Estudiante (nombreEstudiante, gradoEscolar, edad, telefonoEstudiante, escuelaProcedencia) VALUES
('Valeria Reyes', 'Preparatoria', 16, '5544332211', 'Prepa Sur'),
('Jorge Jimenez', 'Universidad', 22, '5599887766', 'Tecnologico Nacional'),
('Mateo Fernandez', 'Secundaria', 14, '5566778899', 'Secundaria Tecnica 5');

-- Estos son los 4 tutores originales de la prueba que está en Java.
INSERT INTO Tutor (nombreTutor, telefonoTutor, correo, especialidad) VALUES
('Luis Alonso', '5511122233', 'luis@gmail.com', 'Matematicas'),
('Cristian Devora', '5522233344', 'cris@gmail.com', 'Historia'),
('Laura Torres', '5533344455', 'laura@gmail.com', 'Ciencias'),
('Carlos Mendoza', '5544455566', 'carlos@gmail.com', 'Fisica');

-- Agregué otros 3 tutores para cubrir más materias.
-- Uno de Química, otra de Español y uno de Inglés.
INSERT INTO Tutor (nombreTutor, telefonoTutor, correo, especialidad) VALUES
('Ricardo Salas', '5577788899', 'ricardo@gmail.com', 'Quimica'),
('Mariana Solis', '5588899900', 'mariana@gmail.com', 'Literatura y Español'),
('David Guzman', '5599900011', 'david@gmail.com', 'Ingles');

-- Las 4 materias que ya se tenian, para que todo siga funcionando igual.
INSERT INTO Materia (nombreMateria, nivel, descripcion) VALUES
('Calculo', 'Universidad', 'Calculo diferencial e integral'),
('Historia de Mexico', 'Preparatoria', 'Historia de la nacion mexicana'),
('Biologia', 'Secundaria', 'Conceptos basicos de biologia celular'),
('Fisica I', 'Preparatoria', 'Mecanica clasica y cinematica');

-- Y aquí cree las materias para los nuevos tutores.
-- Tienen que coincidir, ¿no? Si hay un tutor de Química, debe haber una materia de Química.
INSERT INTO Materia (nombreMateria, nivel, descripcion) VALUES
('Quimica Organica', 'Preparatoria', 'Fundamentos de la quimica del carbono'),
('Taller de Lectura', 'Secundaria', 'Comprension lectora y redaccion'),
('Ingles Intermedio', 'General', 'Conversacion y gramatica nivel B1');

-- Estos son los horarios de los primeros tutores.
-- Ojo: el idTutor=1 es Luis Alonso, y el idTutor=3 es Laura Torres.
INSERT INTO Horario (dia, horaInicio, horaFin, idTutor) VALUES
('Lunes', '08:00', '10:00', 1),
('Miercoles', '08:00', '10:00', 1),
('Martes', '14:00', '16:00', 3),
('Jueves', '14:00', '16:00', 3);

-- Y aquí van los horarios para los nuevos tutores que metí arriba.
-- Hay que usar sus IDs correctos (Ricardo=5, Mariana=6, David=7).
-- Les puse horarios en la tarde y uno en sábado para variar.
INSERT INTO Horario (dia, horaInicio, horaFin, idTutor) VALUES
('Viernes', '16:00', '18:00', 5), -- Horario para Ricardo (Química)
('Martes', '17:00', '19:00', 6), -- Horario para Mariana (Español)
('Sabado', '10:00', '12:00', 7); -- Horario para David (Inglés)

-- Las primeras 3 tutorías que ya tenías programadas.
INSERT INTO Tutoria (fecha, hora, estado, idTutor, idEstudiante, idMateria) VALUES
('2025-10-01', '15:00', 'Programada', 3, 3, 3), -- Laura (Ciencias) con Ana (Uni) sobre Biología
('2025-10-02', '15:00', 'Programada', 3, 4, 3), -- Laura (Ciencias) con Sofia (Primaria) sobre Biología
('2025-11-05', '12:00', 'Programada', 4, 3, 4); -- Carlos (Física) con Ana (Uni) sobre Física I

-- Y aquí juntamos todo: creé nuevas tutorías con los nuevos y los viejos.
-- Mezclé tutores, estudiantes y materias para simular un uso real.
-- Puse una 'Completada' y otra 'En curso' para probar los diferentes estados.
INSERT INTO Tutoria (fecha, hora, estado, idTutor, idEstudiante, idMateria) VALUES
('2025-10-15', '16:00', 'Completada', 5, 2, 5), -- Ricardo (Química) con Sebastian (Prepa) sobre Química Orgánica
('2025-10-20', '17:00', 'En curso', 6, 1, 6), -- Mariana (Español) con Manuel (Secundaria) sobre Taller de Lectura
('2025-11-10', '10:00', 'Programada', 7, 5, 7), -- David (Inglés) con Valeria (Prepa) sobre Inglés Intermedio
('2025-11-12', '09:00', 'Programada', 1, 6, 1); -- Luis (Matemáticas) con Jorge (Uni) sobre Cálculo