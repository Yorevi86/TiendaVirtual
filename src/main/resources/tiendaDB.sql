CREATE DATABASE tienda
GO
USE tienda
GO

DROP TABLE IF EXISTS orderdetails;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

/*Table structure for table `users` */

CREATE TABLE users (
  userID int NOT NULL IDENTITY(1,1),
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  login varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  postalCode varchar(5) NOT NULL,
  phoneNumber varchar(12) NOT NULL,
  admin bit NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (userID)
);

/*Data for the table `users` */

insert into users(name,surname,login,address,state,city,postalCode,phoneNumber,admin,password) values 

('Jonatan','Carrera Viera','jcviera','54, rue Royale','Sevilla ','Sevilla','41015','600600601',1, 'paprobar'),
('Jean','King','jking','8489 Strong St.','Sevilla ','Sevilla','41008','600600602',0, '1111'),
('Peter','Ferguson','pferguson','636 St Kilda Road','Sevilla ','Sevilla','41001','600600603',0, '2222'),
('Janine','Labrune','jlabrune','67, rue des Cinquante Otages','Sevilla ','Sevilla','41153','600600604',0, '3333'),
('Jonas','Bergulfsen','jbergulfsen','Erling Skakkes gate 78','Sevilla ','Sevilla','41064','600600605',0, '4444'),
('Susan','Nelson','snelson','5677 Strong St.','Sevilla ','Sevilla','41021','600600606',0, '5555'),
('Zbyszek','Piestrzeniewicz','zpiestrzeniewicz','ul. Filtrowa 68','Sevilla ','Sevilla','41001','600600607',0, '6666'),
('Roland','Keitel','rkeitel','Lyonerstr. 34','Sevilla ','Sevilla','41006','600600608',0, '7777'),
('Julie','Murphy','jmurphy','5557 North Pendale Street','Sevilla ','Sevilla','41020','600600609',0, '8888');

/*Table structure for table `products` */

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  productID int NOT NULL IDENTITY(1,1),
  productName varchar(255) NOT NULL,
  stock int NOT NULL,
  description varchar(255) NOT NULL,
  price decimal(10,2) NOT NULL,
  PRIMARY KEY (productID)
);

/*Data for the table `products` */

insert  into products(productName,stock,description,price) values 

('Dado d4', 20, 'Un dado d4 simple, pero robusto y sin descompensaciones.', 1.50),
('Dado d6', 4, 'Un dado d6 simple, pero robusto y sin descompensaciones.', 1.50),
('Dado d8', 20, 'Un dado d8 simple, pero robusto y sin descompensaciones.', 1.50),
('Dado d10', 8, 'Un dado d10 simple, pero robusto y sin descompensaciones.', 1.50),
('Dado d12', 20, 'Un dado d12 simple, pero robusto y sin descompensaciones.', 2.00),
('Dado d20', 20, 'Un dado d20 simple, pero robusto y sin descompensaciones.', 2.00),
('Dado d100', 12, 'Un dado d10 simple de decenas, pero robusto y sin descompensaciones.', 1.50),
('Set completo de dados', 40, 'Un set completo de dados para D&D. Contiene 1d4, 1d6, 1d8, 1d10, 1d12, 1d20 y 1d100.', 10.25);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  orderID int NOT NULL IDENTITY(1,1),
  orderDate date NOT NULL,
  buyerID int NOT NULL,
  PRIMARY KEY (orderID),
  CONSTRAINT orders_userid_fk_1 FOREIGN KEY (buyerID) REFERENCES users (userID)
);

/*Data for the table `orders` */

insert  into orders(orderDate,buyerID) values 

('2022-01-06',2),
('2022-01-10',8),
('2022-02-11',4),
('2022-02-17',7),
('2022-03-03',8),
('2022-03-18',8),
('2022-03-26',2),
('2022-04-01',7),
('2022-04-04',2),
('2022-04-11',8),
('2022-05-07',5),
('2022-05-28',5),
('2022-06-12',2),
('2022-06-25',2),
('2022-06-27',4),
('2022-07-02',2),
('2022-07-07',9),
('2022-07-16',8),
('2022-07-24',6),
('2022-08-01',3),
('2022-08-08',2),
('2022-08-13',8),
('2022-09-03',4),
('2022-09-05',7),
('2022-09-12',8),
('2022-09-25',3),
('2022-09-28',4),
('2022-10-06',8),
('2022-10-09',7),
('2022-10-10',2),
('2022-10-11',4),
('2022-10-20',2),
('2022-10-28',6),
('2022-11-04',7),
('2022-11-05',3),
('2022-11-06',8),
('2022-11-07',4),
('2022-11-12',2),
('2022-11-14',2),
('2022-11-18',6),
('2022-11-20',6),
('2022-11-21',7),
('2022-11-27',8),
('2022-12-01',7),
('2022-12-02',5);

/*Table structure for table `orderdetails` */

DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails (
  orderID int NOT NULL,
  productID int NOT NULL,
  quantity int NOT NULL,
  priceEach decimal(10,2) NOT NULL,
  PRIMARY KEY (orderID,productID),
  CONSTRAINT orderdetails_orderid_fk_1 FOREIGN KEY (orderID) REFERENCES orders (orderID),
  CONSTRAINT orderdetails_productid_fk_2 FOREIGN KEY (productID) REFERENCES products (productID)
);

/*Data for the table `orderdetails` */

insert into orderdetails(orderID,productID,quantity,priceEach) values 

(1, 8, 1, 9.00),
(2, 8, 1, 9.00),
(3, 8, 1, 9.00),
(4, 8, 1, 9.00),
(5, 8, 1, 9.00),
(6, 8, 1, 9.00),
(7, 8, 1, 9.00),
(8, 8, 1, 9.00),
(9, 8, 1, 9.00),
(10, 8, 1, 9.00),
(11, 8, 1, 9.00),
(12, 8, 1, 9.00),
(13, 8, 1, 9.00),
(14, 8, 1, 10.25),
(15, 8, 1, 10.25),
(16, 8, 1, 10.25),
(17, 8, 1, 10.25),
(18, 8, 1, 10.25),
(19, 8, 1, 10.25),
(20, 8, 1, 10.25),
(21, 8, 1, 10.25),
(22, 8, 1, 10.25),
(23, 8, 1, 10.25),
(24, 8, 1, 10.25),
(25, 8, 1, 10.25),
(26, 8, 1, 10.25),
(27, 8, 1, 10.25),
(28, 8, 1, 10.25),
(29, 8, 1, 10.25),
(30, 8, 1, 10.25),
(31, 8, 1, 10.25),
(32, 8, 1, 10.25),
(33, 8, 1, 10.25),
(34, 8, 1, 10.25),
(35, 8, 1, 10.25),
(36, 8, 1, 10.25),
(37, 8, 1, 10.25),
(38, 8, 1, 10.25),
(39, 8, 1, 10.25),
(40, 8, 1, 10.25),
(41, 8, 1, 10.25),
(42, 8, 1, 10.25),
(43, 8, 1, 10.25),
(44, 8, 1, 10.25);