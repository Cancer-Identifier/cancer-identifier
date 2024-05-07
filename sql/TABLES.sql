CREATE TABLE TIPO_EXAME(
	ID_TIPO INTEGER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE EXAMES (
	ID_EXAMES INTEGER NOT NULL,
	DESCRICAO VARCHAR(50),
	ID_TIPO NUMERIC,
	ID_PACIENTE NUMERIC,
	DATA_EXAMES DATE
);

CREATE TABLE PACIENTES (
	ID INTEGER NOT NULL,
    NOME VARCHAR(100),
    RG NUMERIC(9),
	CPF NUMERIC(11),
    DATA_NASCIMENTO DATE,
    ENDERECO VARCHAR(100)
);

CREATE TABLE LOGRADOURO (
	ID_LOGRADOURO INTEGER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE ENDERECO (
	ID_ENDERECO INTEGER NOT NULL,
	ID_LOGRADOURO NUMERIC,
	ID_BAIRRO NUMERIC,
	ID_UF NUMERIC,
	CEP VARCHAR(11)
);

CREATE TABLE BAIRRO (
	ID INTEGER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE UF (
	ID_UF INTEGER NOT NULL,
	DESCRICAO VARCHAR(2)
);

CREATE TABLE CLINICAS (
	ID_CLINICA INTEGER NOT NULL,
	ID_CNPJ NUMERIC
);

CREATE TABLE CNPJ (
	CNPJ INTEGER NOT NULL,
	NOME_RAZAO VARCHAR(50),
	EMAIL VARCHAR (20),
	NOME_FANTASIA VARCHAR(50),
	ID_ENDERECOS NUMERIC
);

CREATE TABLE PROFISSIONAL_SAUDE (
	CPF INTEGER NOT NULL,
	NOME VARCHAR(50),
	ID_CLINICA NUMERIC,
	ID_USUARIO NUMERIC,
	DATA_NASCIMENTO DATE,
	ID_FUNCAO NUMERIC,
	COD_SIGLA NUMERIC
);

CREATE TABLE FUNCAO (
	ID_FUNCAO INTEGER NOT NULL,
	DESCRICAO VARCHAR(50),
	ID_HORARIO NUMERIC,
	BENEFICIOS VARCHAR(50),
	RESPONSABILIDADE VARCHAR(50),
	SALARIO_BASE VARCHAR(30)
);

CREATE TABLE HORARIO (
	ID_HORARIO INTEGER NOT NULL,
	HORA_INICIO DATE,
	HORA_INTERVALO DATE,
	HORA_FIM DATE
);

CREATE TABLE USUARIO (
	ID INTEGER NOT NULL,
    NOME VARCHAR(100),
	EMAIL VARCHAR(20),
	SENHA VARCHAR(30),
    CPF NUMERIC(11),
    RG NUMERIC(9),
    DATA_NASCIMENTO DATE
);

CREATE TABLE SIGLA (
	COD_SIGLA INTEGER NOT NULL,
	ID_TIPO_SIGLA NUMERIC
);

CREATE TABLE TIPO_SIGLA (
	ID_TIPO_SIGLA INTEGER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE IMAGENS (
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ARQUIVO BYTEA NOT NULL,
    DESCRICAO VARCHAR(255),
    ID_EXAME NUMERIC
);