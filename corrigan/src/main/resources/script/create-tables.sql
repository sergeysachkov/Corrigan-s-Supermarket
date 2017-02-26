drop database if exists `Corrigan`;
create database `Corrigan`;
use `Corrigan`;

CREATE TABLE `categories` (
	`cateid` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`cate_name` varchar(20) NOT NULL,
	PRIMARY KEY (`cateID`)
);

CREATE TABLE `Items` (
	`itemid` BIGINT(40) NOT NULL,
	`name` varchar(200) NOT NULL,
	`stock_q` INT(20) NOT NULL,
	`unit_of_measure` varchar(10) NOT NULL,
	`description` varchar(200) NOT NULL,
	`price` DECIMAL(10,2) NOT NULL,
	`category` BIGINT(20) NOT NULL,
	PRIMARY KEY (`itemid`),
    FOREIGN KEY (`category`) REFERENCES `categories`(`cateid`)
);


/*
CREATE TABLE `basket` (
	`basketID` BIGINT(50) NOT NULL AUTO_INCREMENT,
	`userID` INT(11) NOT NULL,
	`itemID` BIGINT(50) NOT NULL,
	`quantity` INT(50) NOT NULL,
	PRIMARY KEY (`basketID`,`itemID`)
);
*/
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

CREATE TABLE `orders` (
	`orderid` BIGINT NOT NULL AUTO_INCREMENT,
	`customerid` INT(11) NOT NULL,
	`price` DECIMAL(10,2) NOT NULL DEFAULT 0,
	`status` ENUM('Pending', 'Completed', 'Delivered', 'Canceled') NOT NULL DEFAULT 'Pending',
	`time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`orderID`),
    FOREIGN KEY (`customerid`) REFERENCES `customer`(`idcustomer`)
);

CREATE TABLE `orderitems` (
	`orderid` BIGINT NOT NULL AUTO_INCREMENT,
    `itemid` BIGINT(50) NOT NULL,
    `quantity` INT(50) NOT NULL,
    PRIMARY KEY (`orderid`,`itemid`),
    FOREIGN KEY (`orderid`) REFERENCES `orders`(`orderid`) on delete cascade
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

CREATE TABLE `address` (
	`adress_id` int(11) NOT NULL AUTO_INCREMENT,
  `adress_line_1` varchar(45) DEFAULT NULL,
  `adress_line_2` varchar(45) DEFAULT NULL,
  `town` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `eircode` varchar(45) DEFAULT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`adress_id`),
  CONSTRAINT `customer` FOREIGN KEY (`customer`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `manager` (
	`idmanager` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(45) DEFAULT NULL,
  `manager_surname` varchar(45) DEFAULT NULL,
  `manager_login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmanager`)
);

create table stockControl(
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    `phonenumber` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

/**** Triggers ****/

-- decrease stock quantity before inserting an orderitem
DROP TRIGGER IF EXISTS `corrigan`.`orderitems_BEFORE_INSERT`
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER `corrigan`.`orderitems_BEFORE_INSERT` BEFORE INSERT ON `orderitems` FOR EACH ROW
BEGIN
declare oldstock int;
SELECT stock_q into oldstock FROM items WHERE itemid = new.itemid;
if (oldstock-new.quantity)<0
then 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Out of stock';
else 
	update items set stock_q=stock_q-new.quantity where itemid=new.itemid;
end if;
END$$
DELIMITER ;

-- update stock quantity before updating an orderitem
DROP TRIGGER IF EXISTS `corrigan`.`orderitems_BEFORE_UPDATE`;

DELIMITER $$
USE `corrigan`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `corrigan`.`orderitems_BEFORE_UPDATE` BEFORE UPDATE ON `orderitems` FOR EACH ROW
BEGIN
declare oldstock int;
update items set stock_q=stock_q+old.quantity where itemid=old.itemid;
select stock_q into oldstock from items where itemid=new.itemid;
if (oldstock-new.quantity)<0
then SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Out of stock';
else update items set stock_q=stock_q-new.quantity where itemid=new.itemid;
end if;
END$$
DELIMITER ;

-- restore stock quantity before deleting an orderitem
DROP TRIGGER IF EXISTS `corrigan`.`orderitems_BEFORE_DELETE`;

DELIMITER $$
USE `corrigan`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `corrigan`.`orderitems_BEFORE_DELETE` BEFORE DELETE ON `orderitems` FOR EACH ROW
BEGIN
update items set stock_q=stock_q+old.quantity where itemid=old.itemid;
END$$
DELIMITER ;

/**** test data ****/
insert into stockControl values(1,'chris','admin','0874586756');

insert into corrigan.customer (customer_name, customer_surname, customer_login, password, phone_number, email, date_of_birth)
values("Some", "Client", "admin", "admin", "123654", "ss@net.ie", "1988-11-12");

insert into corrigan.categories (cateid,cate_name) values
(11,'fruit'),(2,'drink');

insert into corrigan.items (itemid,`name`,stock_q,unit_of_measure,description,price,category) values
(1,'Apples',40,'bag(1kg)','fresh apples',4,11),
(2,'Easy Peelers',60,'bag(300g)','sweet easy peelers',1.99,11),
(3,'Soda',100,'can(350ml)','a',1.5,2),
( 101, 'apples', 5, 'KG', '1 bag of apples 1 KG each',2.50, 11),
( 102, 'oranges', 10, 'KG', '1 bag of oganges 1 KG each',3.00, 11),
( 103, 'lemons', 10, 'KG', '1 bag of lemons 1 KG each', 1.20,11),
( 106, 'lemons', 10, 'KG', '1 bag of lemons 1 KG each',2.70, 11);
 
-- requires customer whose id=1 exists
insert into corrigan.orders (orderid,customerid) values
(1,1);

insert into corrigan.orderitems (orderid,itemid,quantity) values
(1,1,2),(1,2,3),(1,3,6);
