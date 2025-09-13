CREATE TABLE musica (
    id INTEGER PRIMARY KEY UNIQUE NOT NULL,
    nome VARCHAR(255),
    genero VARCHAR(255),
    ano_lancamento INT,
    artista_id INTEGER,
    album_id INTEGER,
    FOREIGN KEY (artista_id) REFERENCES artista(id),
    FOREIGN KEY (album_id) REFERENCES album(id)
);
