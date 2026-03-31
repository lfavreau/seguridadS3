USE mascotas_db;


-- USUARIOS (3 mínimos)
-- password: 123456 (ejemplo con hash)

INSERT INTO usuarios (username, password, role, enabled) VALUES
('admin', '$2y$10$WOpQysUKotuQmDXejBFw0OFsL03Gh8cziRmIodDhiuvQNerhakpGC', 'ROLE_ADMIN', TRUE),
('veterinario', '$2y$10$WOpQysUKotuQmDXejBFw0OFsL03Gh8cziRmIodDhiuvQNerhakpGC', 'ROLE_VET', TRUE),
('usuario', '$2y$10$WOpQysUKotuQmDXejBFw0OFsL03Gh8cziRmIodDhiuvQNerhakpGC', 'ROLE_USER', TRUE);

-- MASCOTAS

INSERT INTO mascotas (nombre, especie, raza, edad, ubicacion, estado_adopcion, descripcion) VALUES
('Luna', 'Perro', 'Mestizo', 3, 'Concepción', 'DISPONIBLE', 'Sociable y vacunada'),
('Milo', 'Gato', 'Europeo', 2, 'Talcahuano', 'DISPONIBLE', 'Esterilizado'),
('Nina', 'Perro', 'Poodle', 5, 'San Pedro', 'EN_PROCESO', 'Muy tranquila'),
('Simba', 'Gato', 'Siamés', 1, 'Chiguayante', 'ADOPTADO', 'Juguetón');