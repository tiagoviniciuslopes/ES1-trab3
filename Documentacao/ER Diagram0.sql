CREATE TABLE Agencia (
 idAgencia INT NOT NULL,
 nomeAgencia VARCHAR(100)
);

ALTER TABLE Agencia ADD CONSTRAINT PK_Agencia PRIMARY KEY (idAgencia);


CREATE TABLE AtividadeComercial (
 idAtividadeComercial INT NOT NULL,
 descricaoAtividadeComercial VARCHAR(100)
);

ALTER TABLE AtividadeComercial ADD CONSTRAINT PK_AtividadeComercial PRIMARY KEY (idAtividadeComercial);


CREATE TABLE Bairro (
 idBairro INT NOT NULL,
 nomeBairro VARCHAR(100) NOT NULL
);

ALTER TABLE Bairro ADD CONSTRAINT PK_Bairro PRIMARY KEY (idBairro);


CREATE TABLE Banco (
 idBanco INT NOT NULL,
 nomeBanco VARCHAR(100)
);

ALTER TABLE Banco ADD CONSTRAINT PK_Banco PRIMARY KEY (idBanco);


CREATE TABLE DDD (
 idDDD INT NOT NULL,
 numeroDDD INT NOT NULL
);

ALTER TABLE DDD ADD CONSTRAINT PK_DDD PRIMARY KEY (idDDD);


CREATE TABLE DDI (
 idDDI INT NOT NULL,
 numeroDDI INT NOT NULL
);

ALTER TABLE DDI ADD CONSTRAINT PK_DDI PRIMARY KEY (idDDI);


CREATE TABLE Pais (
 idPais INT NOT NULL,
 nomePais VARCHAR(100) NOT NULL
);

ALTER TABLE Pais ADD CONSTRAINT PK_Pais PRIMARY KEY (idPais);


CREATE TABLE Sexo (
 idSexo INT NOT NULL,
 descricaoSexo VARCHAR(100) NOT NULL,
 siglaSexo VARCHAR(100) NOT NULL
);

ALTER TABLE Sexo ADD CONSTRAINT PK_Sexo PRIMARY KEY (idSexo);


CREATE TABLE TipoFone (
 idTipoFone INT NOT NULL,
 siglaTipoFone VARCHAR(100) NOT NULL,
 descricaoTipoFone VARCHAR(100)
);

ALTER TABLE TipoFone ADD CONSTRAINT PK_TipoFone PRIMARY KEY (idTipoFone);


CREATE TABLE TipoInvestimento (
 idTipoInvestimento INT NOT NULL,
 descricaoTipoInvestimento VARCHAR(100)
);

ALTER TABLE TipoInvestimento ADD CONSTRAINT PK_TipoInvestimento PRIMARY KEY (idTipoInvestimento);


CREATE TABLE TipoLogradouro (
 idTipoLogradouro INT NOT NULL,
 siglaTipo VARCHAR(100),
 nomeTIpo VARCHAR(100) NOT NULL
);

ALTER TABLE TipoLogradouro ADD CONSTRAINT PK_TipoLogradouro PRIMARY KEY (idTipoLogradouro);


CREATE TABLE TipoModalidadeContaBancaria (
 idTipoModalidadeContaBancaria INT NOT NULL,
 descricaoTipoModalidadeContaBancaria VARCHAR(100)
);

ALTER TABLE TipoModalidadeContaBancaria ADD CONSTRAINT PK_TipoModalidadeContaBancaria PRIMARY KEY (idTipoModalidadeContaBancaria);


CREATE TABLE TipoTransacao (
 idTipoTransacao INT NOT NULL,
 descricaoTipoTransicao VARCHAR(100) NOT NULL
);

ALTER TABLE TipoTransacao ADD CONSTRAINT PK_TipoTransacao PRIMARY KEY (idTipoTransacao);


CREATE TABLE UF (
 idUF INT NOT NULL,
 siglaUF VARCHAR(100),
 nomeUF VARCHAR(100) NOT NULL,
 idPais INT
);

ALTER TABLE UF ADD CONSTRAINT PK_UF PRIMARY KEY (idUF);


CREATE TABLE Cidade (
 idCidade INT NOT NULL,
 nomeCidade VARCHAR(100) NOT NULL,
 idUF INT
);

ALTER TABLE Cidade ADD CONSTRAINT PK_Cidade PRIMARY KEY (idCidade);


CREATE TABLE Logradouro (
 idLogradouro INT NOT NULL,
 nomeLogradouro VARCHAR(100) NOT NULL,
 idTipoLogradouro INT
);

ALTER TABLE Logradouro ADD CONSTRAINT PK_Logradouro PRIMARY KEY (idLogradouro);


CREATE TABLE OrgaoExpeditor (
 idOrgaoExpeditor INT NOT NULL,
 nomeOrgaoExpeditor VARCHAR(100) NOT NULL,
 idUF INT
);

ALTER TABLE OrgaoExpeditor ADD CONSTRAINT PK_OrgaoExpeditor PRIMARY KEY (idOrgaoExpeditor);


CREATE TABLE Endereco (
 idEndereco INT NOT NULL,
 cep VARCHAR(100) NOT NULL,
 idBairro INT,
 idCidade INT,
 idLogradouro INT
);

ALTER TABLE Endereco ADD CONSTRAINT PK_Endereco PRIMARY KEY (idEndereco);


CREATE TABLE Cliente (
 idCliente INT NOT NULL,
 primeiroNomeCliente VARCHAR(100) NOT NULL,
 nomeMeioCliente VARCHAR(100),
 ultimoNomeCliente VARCHAR(100),
 nomeAbreviadoCliente VARCHAR(100),
 nomeCompletoCliente CHAR(100),
 cpf VARCHAR(100),
 cnpj VARCHAR(100),
 idSexo INT,
 numero INT NOT NULL,
 complemento VARCHAR(100),
 idEndereco INT,
 numeroDoc VARCHAR(100),
 dataExpedicao DATE,
 idOrgaoExpeditor INT
);

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY (idCliente);

CREATE TABLE ContaBancaria (
 idContaBancaria INT NOT NULL,
 saldoAtual FLOAT,
 idCliente INT,
 idTipoModalidadeContaBancaria INT,
 idAgencia INT,
 idBanco INT
);

ALTER TABLE ContaBancaria ADD CONSTRAINT PK_ContaBancaria PRIMARY KEY (idContaBancaria);


CREATE TABLE EmailCliente (
 idEmailCliente INT NOT NULL,
 descricaoEmail VARCHAR(100) NOT NULL,
 idCliente INT
);

ALTER TABLE EmailCliente ADD CONSTRAINT PK_EmailCliente PRIMARY KEY (idEmailCliente);


CREATE TABLE FoneCliente (
 idFoneCliente INT NOT NULL,
 numeroFone VARCHAR(100) NOT NULL,
 idCliente INT,
 idDDI INT,
 idDDD INT,
 idTipoFone INT
);

ALTER TABLE FoneCliente ADD CONSTRAINT PK_FoneCliente PRIMARY KEY (idFoneCliente);


CREATE TABLE Investimento (
 idInvestimento INT NOT NULL,
 dataInvestimento DATE,
 valorInvestimento FLOAT,
 idContaBancaria INT,
 idTipoInvestimento INT,
 idTipoTransacao INT
);

ALTER TABLE Investimento ADD CONSTRAINT PK_Investimento PRIMARY KEY (idInvestimento);


CREATE TABLE Transacao (
 idTransacao INT NOT NULL,
 dataTransacao DATE,
 motivoTransacao VARCHAR(100) DEFAULT '010 Transferencia Bancaria',
 valorTransacao FLOAT,
 idContaBancaria INT,
 idContaBancaria_Favorecido INT,
 idTipoTransacao INT
);

ALTER TABLE Transacao ADD CONSTRAINT PK_Transacao PRIMARY KEY (idTransacao);


CREATE TABLE AtividadeComercial_Cliente (
 idAtividadeComercial INT NOT NULL,
 idCliente INT NOT NULL
);

ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT PK_AtividadeComercial_Cliente PRIMARY KEY (idAtividadeComercial,idCliente);


ALTER TABLE UF ADD CONSTRAINT FK_UF_0 FOREIGN KEY (idPais) REFERENCES Pais (idPais);


ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_0 FOREIGN KEY (idUF) REFERENCES UF (idUF);


ALTER TABLE Logradouro ADD CONSTRAINT FK_Logradouro_0 FOREIGN KEY (idTipoLogradouro) REFERENCES TipoLogradouro (idTipoLogradouro);


ALTER TABLE OrgaoExpeditor ADD CONSTRAINT FK_OrgaoExpeditor_0 FOREIGN KEY (idUF) REFERENCES UF (idUF);


ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_0 FOREIGN KEY (idBairro) REFERENCES Bairro (idBairro);
ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_1 FOREIGN KEY (idCidade) REFERENCES Cidade (idCidade);
ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_2 FOREIGN KEY (idLogradouro) REFERENCES Logradouro (idLogradouro);


ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_0 FOREIGN KEY (idSexo) REFERENCES Sexo (idSexo);
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_1 FOREIGN KEY (idEndereco) REFERENCES Endereco (idEndereco);
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_2 FOREIGN KEY (idOrgaoExpeditor) REFERENCES OrgaoExpeditor (idOrgaoExpeditor);


ALTER TABLE ContaBancaria ADD CONSTRAINT FK_ContaBancaria_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);
ALTER TABLE ContaBancaria ADD CONSTRAINT FK_ContaBancaria_1 FOREIGN KEY (idTipoModalidadeContaBancaria) REFERENCES TipoModalidadeContaBancaria (idTipoModalidadeContaBancaria);
ALTER TABLE ContaBancaria ADD CONSTRAINT FK_ContaBancaria_2 FOREIGN KEY (idAgencia) REFERENCES Agencia (idAgencia);
ALTER TABLE ContaBancaria ADD CONSTRAINT FK_ContaBancaria_3 FOREIGN KEY (idBanco) REFERENCES Banco (idBanco);


ALTER TABLE EmailCliente ADD CONSTRAINT FK_EmailCliente_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);


ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_1 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_2 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_3 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);


ALTER TABLE Investimento ADD CONSTRAINT FK_Investimento_0 FOREIGN KEY (idContaBancaria) REFERENCES ContaBancaria (idContaBancaria);
ALTER TABLE Investimento ADD CONSTRAINT FK_Investimento_1 FOREIGN KEY (idTipoInvestimento) REFERENCES TipoInvestimento (idTipoInvestimento);
ALTER TABLE Investimento ADD CONSTRAINT FK_Investimento_2 FOREIGN KEY (idTipoTransacao) REFERENCES TipoTransacao (idTipoTransacao);


ALTER TABLE Transacao ADD CONSTRAINT FK_Transacao_0 FOREIGN KEY (idContaBancaria) REFERENCES ContaBancaria (idContaBancaria);
ALTER TABLE Transacao ADD CONSTRAINT FK_Transacao_1 FOREIGN KEY (idContaBancaria_Favorecido) REFERENCES ContaBancaria (idContaBancaria);
ALTER TABLE Transacao ADD CONSTRAINT FK_Transacao_2 FOREIGN KEY (idTipoTransacao) REFERENCES TipoTransacao (idTipoTransacao);


ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT FK_AtividadeComercial_Cliente_0 FOREIGN KEY (idAtividadeComercial) REFERENCES AtividadeComercial (idAtividadeComercial);
ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT FK_AtividadeComercial_Cliente_1 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);


