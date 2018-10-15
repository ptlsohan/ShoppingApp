DROP TABLE IF EXISTS Payment;

CREATE TABLE Payment(
paymentId INT AUTO_INCREMENT,
orderId INT,
payment_amount DOUBLE,
payment_date TIMESTAMP,
PRIMARY KEY (paymentId),
FOREIGN KEY (orderId)
REFERENCES orderInfo(orderId)
);