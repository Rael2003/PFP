CREATE TABLE projetos (
    id SERIAL PRIMARY KEY,

    -- Informações do projeto
    nome_projeto            VARCHAR(100) NOT NULL,
    descricao               TEXT,
    data_inicio             DATE NOT NULL,
    data_previsao_entrega   DATE,
    status                  VARCHAR(30),   -- Ex: planejado, em_andamento, concluido, cancelado
    prioridade              VARCHAR(20),   -- Ex: baixa, media, alta

    -- Chaves estrangeiras
    empresa_cliente_id      INTEGER NOT NULL,
    funcionario_responsavel_id INTEGER NOT NULL,

    FOREIGN KEY (empresa_cliente_id) REFERENCES empresas_clientes(id),
    FOREIGN KEY (funcionario_responsavel_id) REFERENCES funcionarios(id)
);