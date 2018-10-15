DROP TABLE IF EXISTS product;

CREATE TABLE product(
productId INT NOT NULL,
productName VARCHAR(45) NOT NULL,
price DOUBLE NOT NULL,
quantity INT NOT NULL,
description VARCHAR(60),
photo VARCHAR(45),
creationDate TIMESTAMP,
PRIMARY KEY (productId)

);