drop database if exists `Corrigan`;
create database `Corrigan`;
use `Corrigan`;
CREATE TABLE `Items` (
	`itemID` INT(40) NOT NULL,
	`name` varchar(200) NOT NULL,
	`stock_q` INT(20) NOT NULL,
	`unit_of_measure` varchar(10) NOT NULL,
	`description` varchar(200) NOT NULL,
	`category` INT(20) NOT NULL,
	PRIMARY KEY (`itemID`)
);

CREATE TABLE `Categories` (
	`cateID` INT(20) NOT NULL AUTO_INCREMENT,
	`cate_name` varchar(20) NOT NULL,
	PRIMARY KEY (`cateID`)
);

CREATE TABLE `basket` (
	`basketID` INT(50) NOT NULL AUTO_INCREMENT,
	`userID` INT(100) NOT NULL,
	`itemID` INT(50) NOT NULL,
	`quantity` INT(50) NOT NULL,
	PRIMARY KEY (`basketID`,`itemID`)
);

CREATE TABLE `orders` (
	`orderID` INT NOT NULL,
	`userID` INT(100) NOT NULL,
	`basketID` INT(50) NOT NULL,
	PRIMARY KEY (`orderID`)
);

ALTER TABLE `Items` ADD CONSTRAINT `Items_fk0` FOREIGN KEY (`category`) REFERENCES `Categories`(`cateID`);

ALTER TABLE `basket` ADD CONSTRAINT `basket_fk0` FOREIGN KEY (`itemID`) REFERENCES `Items`(`itemID`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`basketID`) REFERENCES `basket`(`basketID`);
