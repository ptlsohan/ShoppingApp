DROP TABLE IF EXISTS orderInfo;

CREATE TABLE orderInfo(
orderId INT AUTO_INCREMENT,
username VARCHAR(45) NOT NULL,
productId INT NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY (orderId),
FOREIGN KEY (username)
REFERENCES userInfo(username),
FOREIGN KEY (productId)
REFERENCES product(productId)
);
