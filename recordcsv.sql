CREATE DATABASE IF NOT EXISTS `recordcsv`;

CREATE TABLE IF NOT EXISTS `recordcsv`.`record` (
`idRecord`					INT AUTO_INCREMENT,
`description`					VARCHAR(50) NOT NULL,
`scadenza`					VARCHAR(50) NOT NULL,
`valore`					DOUBLE,
CONSTRAINT `pk_record` PRIMARY KEY (`idRecord`)
);

CREATE TABLE IF NOT EXISTS `recordcsv`.`inforecord` (
`idInfo`					INT AUTO_INCREMENT,
`nome_record`					VARCHAR(50) NOT NULL,
`dimensione`					LONG,
CONSTRAINT `pk_info` PRIMARY KEY (`idInfo`),
CONSTRAINT `fk_idInfo` FOREIGN KEY (`idInfo`) REFERENCES `recordcsv`.`record` (`idRecord`)
);