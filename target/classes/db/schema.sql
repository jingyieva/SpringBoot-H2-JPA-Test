CREATE TABLE department (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(200) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(200) DEFAULT NULL,
  department_id INT NOT NULL,
  gender_code varchar(200) NOT NULL,
  mobile varchar(200) DEFAULT NULL,
  address varchar(200) DEFAULT NULL,
  age int DEFAULT NULL,
  create_date datetime DEFAULT CURRENT_TIMESTAMP,
  update_date datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

