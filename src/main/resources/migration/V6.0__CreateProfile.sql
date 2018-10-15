DROP TABLE IF EXISTS profile;

CREATE TABLE profile(
profileId INT AUTO_INCREMENT,
username VARCHAR(20),
age INT,
street VARCHAR(45) NOT NULL,
apartment_number INT NOT NULL,
city VARCHAR(45) NOT NULL,
state VARCHAR(45) NOT NULL,
zip INT NOT NULL,
tel_home VARCHAR(45),
tel_office VARCHAR(45),
PRIMARY KEY (profileId),
FOREIGN KEY (username)
REFERENCES userInfo(username)

);