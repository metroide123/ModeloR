-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema roletaDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema roletaDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `roletaDB` DEFAULT CHARACTER SET utf8 ;
USE `roletaDB` ;

-- -----------------------------------------------------
-- Table `roletaDB`.`TipoAposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roletaDB`.`TipoAposta` (
  `idTipoAposta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoAposta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roletaDB`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roletaDB`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roletaDB`.`Aposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roletaDB`.`Aposta` (
  `idAposta` INT NOT NULL AUTO_INCREMENT,
  `valorAposta` INT NOT NULL,
  `statusAposta` INT NULL,
  `idTipoAposta` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  `retorno` INT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`idAposta`),
  INDEX `fk_Aposta_TipoAposta_idx` (`idTipoAposta` ASC),
  INDEX `fk_Aposta_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Aposta_TipoAposta`
    FOREIGN KEY (`idTipoAposta`)
    REFERENCES `roletaDB`.`TipoAposta` (`idTipoAposta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aposta_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `roletaDB`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roletaDB`.`NumeroSorteado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roletaDB`.`NumeroSorteado` (
  `idNumeros` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idNumeros`),
  INDEX `fk_NumeroSorteado_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_NumeroSorteado_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `roletaDB`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
