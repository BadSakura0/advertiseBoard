CREATE TABLE product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(64) not null unique,
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;