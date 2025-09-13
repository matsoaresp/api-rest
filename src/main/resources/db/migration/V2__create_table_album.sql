CREATE TABLE album (
    id INTEGER PRIMARY KEY UNIQUE NOT NULL,
    titulo VARCHAR(255),
    ano_lancamento INT,
    artista_id INTEGER,
    FOREIGN KEY (artista_id) REFERENCES artista(id)
);
