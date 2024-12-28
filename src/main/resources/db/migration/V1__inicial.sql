CREATE TABLE perfiles (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL
);

CREATE TABLE usuarios (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         correo_electronico VARCHAR(255) UNIQUE NOT NULL,
                         contrasena VARCHAR(255) NOT NULL,
                         perfil_id BIGINT,
                         FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);

CREATE TABLE cursos (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(255) NOT NULL,
                       categoria VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fecha_creacion TIMESTAMP NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        autor_id BIGINT,
                        curso_id BIGINT,
                        FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                        FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

CREATE TABLE respuestas (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           mensaje TEXT NOT NULL,
                           fecha_creacion TIMESTAMP NOT NULL,
                           topico_id BIGINT,
                           autor_id BIGINT,
                           solucion BOOLEAN,
                           FOREIGN KEY (topico_id) REFERENCES topicos(id),
                           FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
