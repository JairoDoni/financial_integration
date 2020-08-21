SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `financeiro` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `financeiro` ;

-- -----------------------------------------------------
-- Table `financeiro`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro`.`fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(255) NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dat_nascimento` DATE NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `rg` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `cep` VARCHAR(10) NULL,
  `numero` VARCHAR(10) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `uf` CHAR(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro`.`debitos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro`.`debitos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dat_compra` DATE NOT NULL,
  `dat_vencimento` DATE NOT NULL,
  `dat_pagamento` DATE NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `valor_pago` DECIMAL(10,2) NULL,
  `pago` TINYINT(1) NOT NULL DEFAULT 0,
  `descricao` VARCHAR(255) NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `fornecedores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_debitos_fornecedores_idx` (`fornecedores_id` ASC),
  CONSTRAINT `fk_debitos_fornecedores`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `financeiro`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro`.`creditos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro`.`creditos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dat_venda` DATE NOT NULL,
  `dat_vencimento` DATE NOT NULL,
  `dat_pagamento` DATE NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `valor_pago` DECIMAL(10,2) NULL,
  `pago` TINYINT(1) NOT NULL DEFAULT 0,
  `descricao` VARCHAR(255) NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `clientes_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_creditos_clientes1_idx` (`clientes_id` ASC),
  CONSTRAINT `fk_creditos_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `financeiro`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
