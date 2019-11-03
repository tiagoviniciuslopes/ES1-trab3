-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agencia`
--

DROP TABLE IF EXISTS `agencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agencia` (
  `idAgencia` int(11) NOT NULL,
  `nomeAgencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAgencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencia`
--

LOCK TABLES `agencia` WRITE;
/*!40000 ALTER TABLE `agencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `agencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividadecomercial`
--

DROP TABLE IF EXISTS `atividadecomercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividadecomercial` (
  `idAtividadeComercial` int(11) NOT NULL,
  `descricaoAtividadeComercial` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAtividadeComercial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividadecomercial`
--

LOCK TABLES `atividadecomercial` WRITE;
/*!40000 ALTER TABLE `atividadecomercial` DISABLE KEYS */;
INSERT INTO `atividadecomercial` VALUES (1,'Comercio'),(2,'Suporte');
/*!40000 ALTER TABLE `atividadecomercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividadecomercial_cliente`
--

DROP TABLE IF EXISTS `atividadecomercial_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividadecomercial_cliente` (
  `idAtividadeComercial` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idAtividadeComercial`,`idCliente`),
  KEY `FK_AtividadeComercial_Cliente_1` (`idCliente`),
  CONSTRAINT `FK_AtividadeComercial_Cliente_0` FOREIGN KEY (`idAtividadeComercial`) REFERENCES `atividadecomercial` (`idAtividadeComercial`),
  CONSTRAINT `FK_AtividadeComercial_Cliente_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividadecomercial_cliente`
--

LOCK TABLES `atividadecomercial_cliente` WRITE;
/*!40000 ALTER TABLE `atividadecomercial_cliente` DISABLE KEYS */;
INSERT INTO `atividadecomercial_cliente` VALUES (2,2);
/*!40000 ALTER TABLE `atividadecomercial_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bairro` (
  `idBairro` int(11) NOT NULL,
  `nomeBairro` varchar(100) NOT NULL,
  PRIMARY KEY (`idBairro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
INSERT INTO `bairro` VALUES (1,'Centro'),(2,'Vila A'),(3,'Vila B'),(4,'Vila C');
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banco` (
  `idBanco` int(11) NOT NULL,
  `nomeBanco` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `idCidade` int(11) NOT NULL,
  `nomeCidade` varchar(100) NOT NULL,
  `idUF` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCidade`),
  KEY `FK_Cidade_0` (`idUF`),
  CONSTRAINT `FK_Cidade_0` FOREIGN KEY (`idUF`) REFERENCES `uf` (`idUF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Curitiba',1),(2,'Londrina',1),(3,'Medianeira',1),(4,'Sao Paulo',2);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `primeiroNomeCliente` varchar(100) NOT NULL,
  `nomeMeioCliente` varchar(100) DEFAULT NULL,
  `ultimoNomeCliente` varchar(100) DEFAULT NULL,
  `nomeAbreviadoCliente` varchar(100) DEFAULT NULL,
  `nomeCompletoCliente` char(100) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `idSexo` int(11) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `numeroDoc` varchar(100) DEFAULT NULL,
  `dataExpedicao` date DEFAULT NULL,
  `idOrgaoExpeditor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FK_Cliente_0` (`idSexo`),
  KEY `FK_Cliente_1` (`idEndereco`),
  KEY `FK_Cliente_2` (`idOrgaoExpeditor`),
  CONSTRAINT `FK_Cliente_0` FOREIGN KEY (`idSexo`) REFERENCES `sexo` (`idSexo`),
  CONSTRAINT `FK_Cliente_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`),
  CONSTRAINT `FK_Cliente_2` FOREIGN KEY (`idOrgaoExpeditor`) REFERENCES `orgaoexpeditor` (`idOrgaoExpeditor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Tiago','Lopes','Pereira','Tiago V L Pereira','Tiago Vinicius Lopes Pereira','09722879901',NULL,1,23,'null',2,'97667450','1997-07-03',1),(2,'Tiago V L P DevOps',NULL,NULL,'TVLP DevOps',NULL,NULL,'32864581000104',NULL,54,NULL,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contabancaria`
--

DROP TABLE IF EXISTS `contabancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contabancaria` (
  `idContaBancaria` int(11) NOT NULL,
  `saldoAtual` float DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idTipoModalidadeContaBancaria` int(11) DEFAULT NULL,
  `idAgencia` int(11) DEFAULT NULL,
  `idBanco` int(11) DEFAULT NULL,
  PRIMARY KEY (`idContaBancaria`),
  KEY `FK_ContaBancaria_0` (`idCliente`),
  KEY `FK_ContaBancaria_1` (`idTipoModalidadeContaBancaria`),
  KEY `FK_ContaBancaria_2` (`idAgencia`),
  KEY `FK_ContaBancaria_3` (`idBanco`),
  CONSTRAINT `FK_ContaBancaria_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_ContaBancaria_1` FOREIGN KEY (`idTipoModalidadeContaBancaria`) REFERENCES `tipomodalidadecontabancaria` (`idTipoModalidadeContaBancaria`),
  CONSTRAINT `FK_ContaBancaria_2` FOREIGN KEY (`idAgencia`) REFERENCES `agencia` (`idAgencia`),
  CONSTRAINT `FK_ContaBancaria_3` FOREIGN KEY (`idBanco`) REFERENCES `banco` (`idBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contabancaria`
--

LOCK TABLES `contabancaria` WRITE;
/*!40000 ALTER TABLE `contabancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `contabancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddd`
--

DROP TABLE IF EXISTS `ddd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ddd` (
  `idDDD` int(11) NOT NULL,
  `numeroDDD` int(11) NOT NULL,
  PRIMARY KEY (`idDDD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddd`
--

LOCK TABLES `ddd` WRITE;
/*!40000 ALTER TABLE `ddd` DISABLE KEYS */;
INSERT INTO `ddd` VALUES (1,45);
/*!40000 ALTER TABLE `ddd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddi`
--

DROP TABLE IF EXISTS `ddi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ddi` (
  `idDDI` int(11) NOT NULL,
  `numeroDDI` int(11) NOT NULL,
  PRIMARY KEY (`idDDI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddi`
--

LOCK TABLES `ddi` WRITE;
/*!40000 ALTER TABLE `ddi` DISABLE KEYS */;
INSERT INTO `ddi` VALUES (1,55);
/*!40000 ALTER TABLE `ddi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailcliente`
--

DROP TABLE IF EXISTS `emailcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emailcliente` (
  `idEmailCliente` int(11) NOT NULL,
  `descricaoEmail` varchar(100) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmailCliente`),
  KEY `FK_EmailCliente_0` (`idCliente`),
  CONSTRAINT `FK_EmailCliente_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailcliente`
--

LOCK TABLES `emailcliente` WRITE;
/*!40000 ALTER TABLE `emailcliente` DISABLE KEYS */;
INSERT INTO `emailcliente` VALUES (1,'tiago.foz@hotmail.com',1),(2,'suporte@devops.com.br',2);
/*!40000 ALTER TABLE `emailcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `cep` varchar(100) NOT NULL,
  `idBairro` int(11) DEFAULT NULL,
  `idCidade` int(11) DEFAULT NULL,
  `idLogradouro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `FK_Endereco_0` (`idBairro`),
  KEY `FK_Endereco_1` (`idCidade`),
  KEY `FK_Endereco_2` (`idLogradouro`),
  CONSTRAINT `FK_Endereco_0` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`idBairro`),
  CONSTRAINT `FK_Endereco_1` FOREIGN KEY (`idCidade`) REFERENCES `cidade` (`idCidade`),
  CONSTRAINT `FK_Endereco_2` FOREIGN KEY (`idLogradouro`) REFERENCES `logradouro` (`idLogradouro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'85867530',1,1,1),(2,'85867500',1,1,1);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fonecliente`
--

DROP TABLE IF EXISTS `fonecliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fonecliente` (
  `idFoneCliente` int(11) NOT NULL,
  `numeroFone` varchar(100) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idDDI` int(11) DEFAULT NULL,
  `idDDD` int(11) DEFAULT NULL,
  `idTipoFone` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFoneCliente`),
  KEY `FK_FoneCliente_0` (`idCliente`),
  KEY `FK_FoneCliente_1` (`idDDI`),
  KEY `FK_FoneCliente_2` (`idDDD`),
  KEY `FK_FoneCliente_3` (`idTipoFone`),
  CONSTRAINT `FK_FoneCliente_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_FoneCliente_1` FOREIGN KEY (`idDDI`) REFERENCES `ddi` (`idDDI`),
  CONSTRAINT `FK_FoneCliente_2` FOREIGN KEY (`idDDD`) REFERENCES `ddd` (`idDDD`),
  CONSTRAINT `FK_FoneCliente_3` FOREIGN KEY (`idTipoFone`) REFERENCES `tipofone` (`idTipoFone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fonecliente`
--

LOCK TABLES `fonecliente` WRITE;
/*!40000 ALTER TABLE `fonecliente` DISABLE KEYS */;
INSERT INTO `fonecliente` VALUES (1,'99940308',1,1,1,1),(2,'35776715',2,1,1,1);
/*!40000 ALTER TABLE `fonecliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investimento`
--

DROP TABLE IF EXISTS `investimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investimento` (
  `idInvestimento` int(11) NOT NULL,
  `dataInvestimento` date DEFAULT NULL,
  `valorInvestimento` float DEFAULT NULL,
  `idContaBancaria` int(11) DEFAULT NULL,
  `idTipoInvestimento` int(11) DEFAULT NULL,
  `idTipoTransacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInvestimento`),
  KEY `FK_Investimento_0` (`idContaBancaria`),
  KEY `FK_Investimento_1` (`idTipoInvestimento`),
  KEY `FK_Investimento_2` (`idTipoTransacao`),
  CONSTRAINT `FK_Investimento_0` FOREIGN KEY (`idContaBancaria`) REFERENCES `contabancaria` (`idContaBancaria`),
  CONSTRAINT `FK_Investimento_1` FOREIGN KEY (`idTipoInvestimento`) REFERENCES `tipoinvestimento` (`idTipoInvestimento`),
  CONSTRAINT `FK_Investimento_2` FOREIGN KEY (`idTipoTransacao`) REFERENCES `tipotransacao` (`idTipoTransacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investimento`
--

LOCK TABLES `investimento` WRITE;
/*!40000 ALTER TABLE `investimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `investimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logradouro`
--

DROP TABLE IF EXISTS `logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logradouro` (
  `idLogradouro` int(11) NOT NULL,
  `nomeLogradouro` varchar(100) NOT NULL,
  `idTipoLogradouro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLogradouro`),
  KEY `FK_Logradouro_0` (`idTipoLogradouro`),
  CONSTRAINT `FK_Logradouro_0` FOREIGN KEY (`idTipoLogradouro`) REFERENCES `tipologradouro` (`idTipoLogradouro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouro`
--

LOCK TABLES `logradouro` WRITE;
/*!40000 ALTER TABLE `logradouro` DISABLE KEYS */;
INSERT INTO `logradouro` VALUES (1,'Vitorino',1),(2,'Brasil',2);
/*!40000 ALTER TABLE `logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orgaoexpeditor`
--

DROP TABLE IF EXISTS `orgaoexpeditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orgaoexpeditor` (
  `idOrgaoExpeditor` int(11) NOT NULL,
  `nomeOrgaoExpeditor` varchar(100) NOT NULL,
  `idUF` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrgaoExpeditor`),
  KEY `FK_OrgaoExpeditor_0` (`idUF`),
  CONSTRAINT `FK_OrgaoExpeditor_0` FOREIGN KEY (`idUF`) REFERENCES `uf` (`idUF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orgaoexpeditor`
--

LOCK TABLES `orgaoexpeditor` WRITE;
/*!40000 ALTER TABLE `orgaoexpeditor` DISABLE KEYS */;
INSERT INTO `orgaoexpeditor` VALUES (1,'SSP',1);
/*!40000 ALTER TABLE `orgaoexpeditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL,
  `nomePais` varchar(100) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Brasil'),(2,'Argentina'),(3,'Canada'),(4,'Irlanda');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexo` (
  `idSexo` int(11) NOT NULL,
  `descricaoSexo` varchar(100) NOT NULL,
  `siglaSexo` varchar(100) NOT NULL,
  PRIMARY KEY (`idSexo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino','M'),(2,'Feminino','F');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipofone`
--

DROP TABLE IF EXISTS `tipofone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipofone` (
  `idTipoFone` int(11) NOT NULL,
  `siglaTipoFone` varchar(100) NOT NULL,
  `descricaoTipoFone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTipoFone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipofone`
--

LOCK TABLES `tipofone` WRITE;
/*!40000 ALTER TABLE `tipofone` DISABLE KEYS */;
INSERT INTO `tipofone` VALUES (1,'Cel','Celular');
/*!40000 ALTER TABLE `tipofone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoinvestimento`
--

DROP TABLE IF EXISTS `tipoinvestimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoinvestimento` (
  `idTipoInvestimento` int(11) NOT NULL,
  `descricaoTipoInvestimento` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTipoInvestimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoinvestimento`
--

LOCK TABLES `tipoinvestimento` WRITE;
/*!40000 ALTER TABLE `tipoinvestimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoinvestimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologradouro`
--

DROP TABLE IF EXISTS `tipologradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipologradouro` (
  `idTipoLogradouro` int(11) NOT NULL,
  `siglaTipo` varchar(100) DEFAULT NULL,
  `nomeTIpo` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoLogradouro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologradouro`
--

LOCK TABLES `tipologradouro` WRITE;
/*!40000 ALTER TABLE `tipologradouro` DISABLE KEYS */;
INSERT INTO `tipologradouro` VALUES (1,'RUA','rua'),(2,'AV','avenida');
/*!40000 ALTER TABLE `tipologradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomodalidadecontabancaria`
--

DROP TABLE IF EXISTS `tipomodalidadecontabancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipomodalidadecontabancaria` (
  `idTipoModalidadeContaBancaria` int(11) NOT NULL,
  `descricaoTipoModalidadeContaBancaria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTipoModalidadeContaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomodalidadecontabancaria`
--

LOCK TABLES `tipomodalidadecontabancaria` WRITE;
/*!40000 ALTER TABLE `tipomodalidadecontabancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipomodalidadecontabancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipotransacao`
--

DROP TABLE IF EXISTS `tipotransacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipotransacao` (
  `idTipoTransacao` int(11) NOT NULL,
  `descricaoTipoTransicao` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoTransacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipotransacao`
--

LOCK TABLES `tipotransacao` WRITE;
/*!40000 ALTER TABLE `tipotransacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipotransacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacao`
--

DROP TABLE IF EXISTS `transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacao` (
  `idTransacao` int(11) NOT NULL,
  `dataTransacao` date DEFAULT NULL,
  `motivoTransacao` varchar(100) DEFAULT '010 Transferencia Bancaria',
  `valorTransacao` float DEFAULT NULL,
  `idContaBancaria` int(11) DEFAULT NULL,
  `idContaBancaria_Favorecido` int(11) DEFAULT NULL,
  `idTipoTransacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTransacao`),
  KEY `FK_Transacao_0` (`idContaBancaria`),
  KEY `FK_Transacao_1` (`idContaBancaria_Favorecido`),
  KEY `FK_Transacao_2` (`idTipoTransacao`),
  CONSTRAINT `FK_Transacao_0` FOREIGN KEY (`idContaBancaria`) REFERENCES `contabancaria` (`idContaBancaria`),
  CONSTRAINT `FK_Transacao_1` FOREIGN KEY (`idContaBancaria_Favorecido`) REFERENCES `contabancaria` (`idContaBancaria`),
  CONSTRAINT `FK_Transacao_2` FOREIGN KEY (`idTipoTransacao`) REFERENCES `tipotransacao` (`idTipoTransacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacao`
--

LOCK TABLES `transacao` WRITE;
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uf`
--

DROP TABLE IF EXISTS `uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uf` (
  `idUF` int(11) NOT NULL,
  `siglaUF` varchar(100) DEFAULT NULL,
  `nomeUF` varchar(100) NOT NULL,
  `idPais` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUF`),
  KEY `FK_UF_0` (`idPais`),
  CONSTRAINT `FK_UF_0` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uf`
--

LOCK TABLES `uf` WRITE;
/*!40000 ALTER TABLE `uf` DISABLE KEYS */;
INSERT INTO `uf` VALUES (1,'PR','Parana',1),(2,'SP','Sao Paulo',1);
/*!40000 ALTER TABLE `uf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-02 20:58:09
