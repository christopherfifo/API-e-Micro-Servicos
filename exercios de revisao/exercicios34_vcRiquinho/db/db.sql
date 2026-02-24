CREATE DATABASE vcRiquinho;
USE vcRiquinho;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    documento VARCHAR(20), -- CPF ou CNPJ
    tipo_cliente ENUM('PF', 'PJ')
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descricao TEXT,
    tipo ENUM('FIXA', 'VARIAVEL'),
    rendimento_mensal DOUBLE,
    carencia_dias INT DEFAULT 0
);