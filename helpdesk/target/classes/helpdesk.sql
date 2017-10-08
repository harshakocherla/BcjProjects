-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema helpdesk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema helpdesk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `helpdesk` DEFAULT CHARACTER SET utf8 ;
USE `helpdesk` ;

-- -----------------------------------------------------
-- Table `helpdesk`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`user` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `userType` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`address` (
  `addressId` INT(11) NOT NULL AUTO_INCREMENT,
  `addressLine1` VARCHAR(45) NULL DEFAULT NULL,
  `addressLine2` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `zip` VARCHAR(45) NULL DEFAULT NULL,
  `user_userId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`addressId`),
  INDEX `user_userId_idx` (`user_userId` ASC),
  CONSTRAINT `user_userId`
    FOREIGN KEY (`user_userId`)
    REFERENCES `helpdesk`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`helpdesk_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`helpdesk_categories` (
  `helpdesk_categoriesId` INT(11) NOT NULL,
  `categories` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`helpdesk_categoriesId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`helpdesk_subcategories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`helpdesk_subcategories` (
  `helpdesk_subcategoriesId` INT(11) NOT NULL,
  `subcategories` VARCHAR(45) NULL DEFAULT NULL,
  `helpdesk_categoriesId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`helpdesk_subcategoriesId`),
  INDEX `helpdesk_categoriesId` (`helpdesk_categoriesId` ASC),
  CONSTRAINT `helpdesk_subcategories_ibfk_1`
    FOREIGN KEY (`helpdesk_categoriesId`)
    REFERENCES `helpdesk`.`helpdesk_categories` (`helpdesk_categoriesId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`login` (
  `loginId` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `user_userId` INT(11) NOT NULL,
  PRIMARY KEY (`loginId`),
  INDEX `fk_login_user1_idx` (`user_userId` ASC),
  CONSTRAINT `fk_login_user1`
    FOREIGN KEY (`user_userId`)
    REFERENCES `helpdesk`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`state` (
  `stateId` INT(11) NOT NULL,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`stateId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`tickets` (
  `ticketId` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `subcategory` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `stat` VARCHAR(45) NULL DEFAULT NULL,
  `comments` VARCHAR(45) NULL DEFAULT NULL,
  `login_loginId` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `ticketNumber` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ticketId`),
  INDEX `login_loginId_idx` (`login_loginId` ASC),
  CONSTRAINT `login_loginId`
    FOREIGN KEY (`login_loginId`)
    REFERENCES `helpdesk`.`login` (`loginId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `helpdesk`.`usertype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `helpdesk`.`usertype` (
  `userTypeId` INT(11) NOT NULL AUTO_INCREMENT,
  `userType` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`userTypeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
