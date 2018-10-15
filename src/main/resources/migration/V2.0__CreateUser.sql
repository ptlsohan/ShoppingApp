DROP TABLE IF EXISTS userInfo;

CREATE TABLE userInfo(
username VARCHAR(20),
firstName VARCHAR(45) NOT NULL,
lastName VARCHAR(45),
password VARCHAR(20) NOT NULL,
email VARCHAR(45) NOT NULL,
gender VARCHAR(10),
PRIMARY KEY (username)

);