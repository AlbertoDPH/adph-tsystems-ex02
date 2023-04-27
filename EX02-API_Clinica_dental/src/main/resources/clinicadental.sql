-- drop database if exists clinicadental;
-- create database clinicadental;
-- use clinicadental;

DROP table IF EXISTS clientes;
DROP table IF EXISTS tipo_intervenciones;
DROP table IF EXISTS tipo_intervenciones;
DROP table IF EXISTS citas;

-- Tabla clientes
CREATE TABLE clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL
);

-- Tabla dentistas
CREATE TABLE dentistas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  especialidad VARCHAR(255) NOT NULL
);

-- Tabla tipo_intervenciones
CREATE TABLE tipo_intervenciones (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  descripcion TEXT,
  duracion_estimada INT NOT NULL
);

-- Tabla citas
CREATE TABLE citas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT NOT NULL,
  id_dentista INT NOT NULL,
  id_tipo_intervencion INT NOT NULL,
  fecha_hora DATETIME NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_dentista) REFERENCES dentistas(id)ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_tipo_intervencion) REFERENCES tipo_intervenciones(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Clientes
INSERT INTO clientes (nombre, apellido, email, contrasena) VALUES
  ('Alberto', 'del Pozo', 'alberto.delpozo@suemail.com', 'pass_alberto'),
  ('Tamy', 'Morales', 'tamy.morales@suemail.com', 'pass_tamy'),
  ('Hugo', 'del Pozo', 'hugo.delpozo@suemail.com', 'pass_hugo'),
  ('Sergio', 'Garcia', 'sergio.garcia@suemail.com', 'pass_sergio'),
  ('Natalia', 'Fernandez', 'natalia.fernandez@suemail.com', 'pass_natalia');

-- Dentistas
INSERT INTO dentistas (nombre, apellido, email, contrasena, especialidad) VALUES
  ('Jordi', 'Camps', 'jordi.camps@suemail.com', 'pass_jordi', 'Ortodoncia'),
   ('Oriol', 'Gimenez', 'oriol.gimenez@suemail.com', 'pass_ori', 'Periodoncia'),
  ('Laia', 'Perez', 'laia.perez@suemail.com', 'pass_laia', 'Implantologia'),
  ('Xavier', 'Navarro', 'xavier.navarro@suemail.com', 'pass_xavi', 'Ortodoncia'),
  ('Sofia', 'Casals', 'sofia.casals@suemail.com', 'pass_sofia', 'Prostodoncia');

-- Tipo de Intervenciones
INSERT INTO tipo_intervenciones (nombre, descripcion, duracion_estimada) VALUES
  ('Limpieza dental', 'Limpieza dental', 30),
  ('Extraccion', 'Extraccion pieza dental', 45),
  ('Empaste', 'Empaste pieza dental', 60),
  ('Endodoncia', 'Tratamiento ortodoncia', 90),
  ('Blanqueamiento', 'Blanqueamiento dental', 60);
  
-- Citas
INSERT INTO citas (id_cliente, id_dentista, id_tipo_intervencion, fecha_hora) VALUES
  (1, 2, 1, NOW()),
  (2, 3, 2, NOW()),
  (3, 4, 3, NOW()),
  (4, 5, 4, NOW()),
  (5, 1, 5, NOW());

