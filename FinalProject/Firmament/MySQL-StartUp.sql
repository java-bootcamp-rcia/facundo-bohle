

CREATE TABLE auth_user (
  auth_user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  status BOOLEAN,
  PRIMARY KEY (auth_user_id)
);

insert into auth_user (auth_user_id,username,password,email,status) values (1,'bohledevs','mypass321','facubohle2@gmail.com',TRUE);


CREATE TABLE cities (
  city_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  latitude DOUBLE(12,8) NOT NULL,
  longitude DOUBLE(12,8) NOT NULL,
  times_called int(11) NOT NULL,
  PRIMARY KEY (city_id)
);

insert into cities (city_id,name,country,latitude,longitude,times_called) values (1,'Resistencia','Argentina',-27.4605598,-58.9838905,1);