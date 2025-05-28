CREATE TABLE estoque (
    id SERIAL PRIMARY KEY,
    nome_produto           VARCHAR(100) NOT NULL,
    descricao              TEXT,
    categoria              VARCHAR(50),
    unidade_medida         VARCHAR(10),         -- Ex: un, kg, lt
    quantidade             INTEGER NOT NULL DEFAULT 0,
    preco_custo            DECIMAL(10, 2),
    fornecedor             VARCHAR(100),
    data_entrada           DATE,
    validade               DATE
);