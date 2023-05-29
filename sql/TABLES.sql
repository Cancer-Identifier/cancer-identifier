CREATE TABLE TIPO_EXAME(
	ID_TIPO NUMBER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE EXAMES (
	ID_EXAMES NUMBER NOT NULL,
	DESCRICAO VARCHAR(50),
	ID_TIPO NUMBER,
	ID_PACIENTE NUMBER,
	ANEXO NUMBER,
	DATA_EXAMES DATE
);

CREATE TABLE PACIENTES (
	ID_PACIENTE NUMBER NOT NULL,
	CPF VARCHAR(11),
	NOME VARCHAR(100),
	ID_ENDERECO NUMBER,
	DATA_NASCIMENTO DATE,
	ID_CLINICA NUMBER
);

CREATE TABLE LOGRADOURO (
	ID_LOGRADOURO NUMBER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE ENDERECO (
	ID_ENDERECO NUMBER NOT NULL,
	ID_LOGRADOURO NUMBER,
	ID_BAIRRO NUMBER,
	ID_UF NUMBER,
	CEP VARCHAR(11)
);

CREATE TABLE BAIRRO (
	ID NUMBER NOT NULL,
	DESCRICAO VARCHAR(50)
);

CREATE TABLE UF (
	ID_UF NUMBER NOT NULL,
	DESCRICAO VARCHAR(2)
);

CREATE TABLE CLINICAS (
	ID_CLINICA NUMBER NOT NULL,
	ID_CNPJ NUMBER
);

CREATE TABLE CNPJ (
	CNPJ NUMBER NOT NULL,
	NOME_RAZAO VARCHAR(50),
	EMAIL VARCHAR (20),
	NOME_FANTASIA VARCHAR(50),
	ID_ENDERECOS NUMBER
);

CREATE TABLE PROFISSIONAL_SAUDE (
	CPF NUMBER NOT NULL,
	NOME VARCHAR(50),
	ID_CLINICA NUMBER,
	ID_USUARIO NUMBER,
	DATA_NASCIMENTO DATE,
	ID_FUNCAO NUMBER,
	COD_SIGLA NUMBER
);

CREATE TABLE FUNCAO (
	ID_FUNCAO NUMBER NOT NULL,
	DESCRICAO VARCHAR(50),
	ID_HORARIO NUMBER,
	BENEFICIOS VARCHAR(50),
	RESPONSABILIDADE VARCHAR(50),
	SALARIO_BASE VARCHAR(30)
);

CREATE TABLE HORARIO (
	ID_HORARIO NUMBER NOT NULL,
	HORA_INICIO DATE,
	HORA_INTERVALO DATE,
	HORA_FIM DATE
);

CREATE TABLE USUARIO (
	ID_USUARIO NUMBER NOT NULL,
	EMAIL VARCHAR(20),
	SENHA VARCHAR(30),
	ID_ENDERECOS NUMBER
);

CREATE TABLE SIGLA (
	COD_SIGLA NUMBER NOT NULL,
	ID_TIPO_SIGLA NUMBER
);

CREATE TABLE TIPO_SIGLA (
	ID_TIPO_SIGLA NUMBER NOT NULL,
	DESCRICAO VARCHAR(50)
);
