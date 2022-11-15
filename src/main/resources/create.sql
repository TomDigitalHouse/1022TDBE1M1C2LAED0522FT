CREATE TABLE IF NOT EXISTS Odontologos (matricula int primary key, nombre VARCHAR(255), apellido VARCHAR(255));

CREATE TABLE if not exists Pacientes (id int auto_increment primary key , nombre VARCHAR(255), apellido VARCHAR(255), dni VARCHAR(9), domicilio VARCHAR(200), fechAalta DATE NOT NULL);

--CREATE TABLE if not exists Turnos (id INT auto_increment primary key, id_odontologo INT NOT NULL, id_paciente INT NOT NULL, fecha DATETIME, FOREIGN KEY(matricula_ontologo) REFERENCES Odontologos(matricula), FOREIGN KEY(id_paciente) REFERENCES Pacientes(id));
--idq