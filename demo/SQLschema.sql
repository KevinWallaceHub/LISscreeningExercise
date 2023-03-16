BEGIN TRANSACTION;

DROP TABLE IF EXISTS formdata;

CREATE TABLE formdata(
name varchar(100) NOT NULL,
age int,
title VARCHAR(100) NOT NULL,
hometown VARCHAR(100) 
);

INSERT INTO formdata (name, age, title, hometown)
VALUES ('Archie', '7', 'top-dog', 'Columbus');

INSERT INTO formdata (name, title)
VALUES ('Leo', 'Best Pup');

COMMIT TRANSACTION;