CREATE TABLE itens_projeto (
    id SERIAL PRIMARY KEY,

    projeto_id INTEGER NOT NULL,
    titulo_item VARCHAR(100) NOT NULL,
    descricao TEXT,
    status VARCHAR(30) DEFAULT 'pendente',  -- Ex: pendente, em_andamento, concluido
    data_inicio DATE,
    data_entrega_prevista DATE,
    data_conclusao DATE,

    FOREIGN KEY (projeto_id) REFERENCES projetos(id) ON DELETE CASCADE
);