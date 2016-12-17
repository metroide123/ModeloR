-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema roleta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema roleta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `roleta` DEFAULT CHARACTER SET utf8 ;
USE `roleta` ;

-- -----------------------------------------------------
-- Table `roleta`.`TipoAposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`TipoAposta` (
  `idTipoAposta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoAposta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`Aposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`Aposta` (
  `idAposta` INT NOT NULL AUTO_INCREMENT,
  `valorAposta` FLOAT NOT NULL,
  `status` INT NULL,
  `idTipoAposta` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  `retorno` FLOAT NULL,
  PRIMARY KEY (`idAposta`),
  INDEX `fk_Aposta_TipoAposta_idx` (`idTipoAposta` ASC),
  INDEX `fk_Aposta_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Aposta_TipoAposta`
    FOREIGN KEY (`idTipoAposta`)
    REFERENCES `roleta`.`TipoAposta` (`idTipoAposta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aposta_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `roleta`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`Cassino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`Cassino` (
  `idCassino` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tempoSessao` INT NOT NULL,
  `moeda` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idCassino`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`Roleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`Roleta` (
  `idRoleta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idCassino` INT NOT NULL,
  `valorMinino` INT NOT NULL,
  `tamanhoFrame` INT NOT NULL COMMENT 'Tamanho do frame para captura dos valores sorteados',
  PRIMARY KEY (`idRoleta`),
  INDEX `fk_Roleta_Cassino1_idx` (`idCassino` ASC),
  CONSTRAINT `fk_Roleta_Cassino1`
    FOREIGN KEY (`idCassino`)
    REFERENCES `roleta`.`Cassino` (`idCassino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`NumeroSorteado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`NumeroSorteado` (
  `idNumeros` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `idUsuario` INT NOT NULL,
  `idRoleta` INT NOT NULL,
  PRIMARY KEY (`idNumeros`),
  INDEX `fk_NumeroSorteado_Usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_NumeroSorteado_Roleta1_idx` (`idRoleta` ASC),
  CONSTRAINT `fk_NumeroSorteado_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `roleta`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumeroSorteado_Roleta1`
    FOREIGN KEY (`idRoleta`)
    REFERENCES `roleta`.`Roleta` (`idRoleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roleta`.`Fundos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roleta`.`Fundos` (
  `idUsuario` INT NOT NULL,
  `idCassino` INT NOT NULL,
  `saldo` FLOAT NULL DEFAULT 0,
  INDEX `fk_Fundos_Usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_Fundos_Cassino1_idx` (`idCassino` ASC),
  CONSTRAINT `fk_Fundos_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `roleta`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fundos_Cassino1`
    FOREIGN KEY (`idCassino`)
    REFERENCES `roleta`.`Cassino` (`idCassino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
