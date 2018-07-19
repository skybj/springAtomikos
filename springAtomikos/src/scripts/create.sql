CREATE SCHEMA `qa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
CREATE SCHEMA `dev` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

 CREATE  TABLE `dev`.`nameDev` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `nameDev` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) );

  CREATE  TABLE `qa`.`nameQa` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `nameQa` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) );