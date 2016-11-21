drop database if exists `Corrigan`;
create database `Corrigan`;
use `Corrigan`;
CREATE TABLE `Items` (
	`itemID` BIGINT(40) NOT NULL,
	`name` varchar(200) NOT NULL,
	`stock_q` INT(20) NOT NULL,
	`unit_of_measure` varchar(10) NOT NULL,
	`description` varchar(200) NOT NULL,
	`price` double(10,2) NOT NULL,
	`category` BIGINT(20) NOT NULL,
	PRIMARY KEY (`itemID`)
);

CREATE TABLE `Categories` (
	`cateID` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`cate_name` varchar(20) NOT NULL,
	PRIMARY KEY (`cateID`)
);

CREATE TABLE `basket` (
	`basketID` BIGINT(50) NOT NULL AUTO_INCREMENT,
	`userID` INT(11) NOT NULL,
	`itemID` BIGINT(50) NOT NULL,
	`quantity` INT(50) NOT NULL,
	PRIMARY KEY (`basketID`,`itemID`)
);

CREATE TABLE `orders` (
	`orderID` BIGINT NOT NULL,
	`userID` INT(11) NOT NULL,
	`basketID` BIGINT(50) NOT NULL,
	PRIMARY KEY (`orderID`)
);

ALTER TABLE `Items` ADD CONSTRAINT `Items_fk0` FOREIGN KEY (`category`) REFERENCES `Categories`(`cateID`);

ALTER TABLE `basket` ADD CONSTRAINT `basket_fk0` FOREIGN KEY (`itemID`) REFERENCES `Items`(`itemID`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`basketID`) REFERENCES `basket`(`basketID`);

CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_surname` varchar(45) DEFAULT NULL,
  `customer_login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`idcustomer`),
  UNIQUE KEY `customer_login_UNIQUE` (`customer_login`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

CREATE TABLE `payment` (
  `idpayment` int(11) NOT NULL AUTO_INCREMENT,
  `card_type` varchar(45) DEFAULT NULL,
  `card_no` varchar(45) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `cvv2` varchar(45) DEFAULT NULL,
  `card_holder` varchar(45) DEFAULT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`idpayment`),
  UNIQUE KEY `card_no_UNIQUE` (`card_no`),
  KEY `payment_customer_idx` (`customer`),
  CONSTRAINT `payment_customer` FOREIGN KEY (`customer`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into corrigan.customer (customer_name, customer_surname, customer_login, password, phone_number, email, date_of_birth)
values("Some", "Client", "admin", "admin", "123654", "ss@net.ie", "1988-11-12");

