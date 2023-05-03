CREATE TABLE product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    productName varchar(64) not null unique,
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE category (
     id BIGINT NOT NULL AUTO_INCREMENT,
     categoryName varchar(64) not null unique,
     PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;