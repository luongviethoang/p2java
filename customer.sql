CREATE DATABASE Customerlist;

use Customerlist;

CREATE TABLE Customer(
    name varchar(50),
    Sp varchar(50),
    price int,
    Bill varchar(50));
INSERT INTO Customer('Hoang','May Say Toc',100.000,'Dang tao Bill');
INSERT INTO Customer('Hoang Hoa','May Cat Toc',200.000,'Dang tao Bill');
INSERT INTO Customer('Hang','May Luom Toc',300.000,'Dang tao Bill');

SELECT name FROM * Customer;
SELECT Sp FROM * Customer;
SELECT Sp, price FROM Customer WHERE price>= 100.000 ORDER By price DESC;
SELECT name,Sp,price,Bill FROM * Customer Where name = 'Hoang';