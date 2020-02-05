drop schema if exists `gateway`;
create schema `gateway`;
use `gateway`;
DROP TABLE IF EXISTS `tb_gateway`;
CREATE TABLE `tb_gateway`
(
    `id`   int(10) unsigned NOT NULL AUTO_INCREMENT,
    `url` varchar(1024)    NOT NULL,
    `remark`    varchar(1024)    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;



