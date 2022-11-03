create table if not exists domicilio(id int primary key, calle varchar(255), numero varchar(255), localidad varchar(255), provincia varchar(255));
create table if not exists pacientes
(
    id           int auto_increment primary key,
    nombre       varchar(255),
    dni          varchar(255),
    ingreso      date,
    domicilio_id int,
    FOREIGN KEY (domicilio_id) REFERENCES domicilio (id)
    ON DELETE CASCADE
);