CREATE TABLE tb_users (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
 	name varchar(100) DEFAULT NULL,
 	document varchar(15) DEFAULT NULL,
 	creation_date timestamp DEFAULT NULL,
 	update_date timestamp NOT NULL
);