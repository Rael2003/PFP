CREATE TABLE pedidos_estoque (
    id SERIAL PRIMARY KEY,

    item_projeto_id INTEGER NOT NULL,
    produto_estoque_id INTEGER NOT NULL,
    quantidade_solicitada INTEGER NOT NULL,
    quantidade_atendida INTEGER DEFAULT 0,
    data_pedido DATE NOT NULL DEFAULT CURRENT_DATE,
    status VARCHAR(30) DEFAULT 'pendente',  -- Ex: pendente, atendido, parcial, cancelado

    FOREIGN KEY (item_projeto_id) REFERENCES itens_projeto(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_estoque_id) REFERENCES estoque(id) ON DELETE CASCADE
);