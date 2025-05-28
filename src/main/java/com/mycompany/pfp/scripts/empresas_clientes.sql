CREATE TABLE empresas_clientes (
    id SERIAL PRIMARY KEY,
    nome_empresa         VARCHAR(100) NOT NULL,
    cnpj                 CHAR(14) UNIQUE NOT NULL,
    inscricao_estadual   VARCHAR(20),
    telefone             VARCHAR(20),
    email                VARCHAR(100),
    
    -- Endereço comercial
    endereco             VARCHAR(255),
    numero               VARCHAR(10),
    complemento          VARCHAR(50),
    bairro               VARCHAR(50),
    cidade               VARCHAR(50),
    estado               CHAR(2),
    cep                  CHAR(8),
    
    -- Responsável na empresa
    nome_responsavel     VARCHAR(100),
    cargo_responsavel    VARCHAR(50),
    telefone_responsavel VARCHAR(20),
    email_responsavel    VARCHAR(100)
);