CREATE DATABASE if not EXISTS ebookshop;

use ebookshop;

DROP TABLE if EXISTS books;

CREATE TABLE books(
                      id int,
                      title varchar(50),
                      author varchar(50),
                      price float,
                      qty int,
                      PRIMARY KEY(id));

INSERT into	books values (1001,'Java for dummies','Dang Kim Thi',11.11,11 );
INSERT into	books values (1002,'Java for dummies','Dang Kim Thi',22.22,22 );
INSERT into	books values (1003,'Java for dummies','Dang Kim Thi',33.33,33 );
INSERT into	books values (1004,'Java for dummies','Dang Kim Thi',44.44,44 );
INSERT into	books values (1005,'Java for dummies','CodeLeanVn',55.55,55 );


SELECT * FROM books;
SELECT title, price FROM books WHERE author = 'CodeLeanVN';
SELECT title, author, price, qty FROM books WHERE author = 'CodeLeanVn' OR price >=30 ORDER BY price DESC, id ASCCREATE DATABASE if not EXISTS ebookshop;

