CREATE database auto_dealer;

CREATE TABLE `auto_dealer`.`automaker` (
  `automakerID` INT NOT NULL,
  `automaker` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`automakerID`));
  
  CREATE TABLE `auto_dealer`.`vehicle` (
  `vehicleID` VARCHAR(45) NOT NULL,
  `automakerID` INT NOT NULL,
  `model` VARCHAR(255) NOT NULL,
  `color` VARCHAR(255) NOT NULL,
  `year` INT NOT NULL,
  `createdAt` VARCHAR(255) NOT NULL,
  `vehicleType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`vehicleID`),
  INDEX `automakerID_idx` (`automakerID` ASC),
  CONSTRAINT `automakerID`
    FOREIGN KEY (`automakerID`)
    REFERENCES `auto_dealer`.`automaker` (`automakerID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('369416', 'kia');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('1329105', 'kawasaki');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('4016264', 'rivian');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('23955930', 'Mercedes');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('32863390', 'GM');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('36496215', 'Hyundai');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('47976589', 'Peugeot');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('48918054', 'Audi');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('78221788', 'Volkswagen');
INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('123456789', 'Jeep');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('10901306', '78221788', 'Jetta', 'purple', '2018', '2022-06-04T21:20:33Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('3105758', '36496215', 'Sonata', 'blue', '2016', '2021-09-16T03:44:49Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('32041979', '78221788', 'Golf', 'black', '2018', '2020-12-06T11:24:39Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('36424440', '48918054', 'R8', 'green', '2014', '2019-11-01T00:37:43Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('44650161', '36496215', 'Azera', 'red', '2019', '2020-10-11T18:14:30Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('45782289', '47976589', '206', 'silver', '2017', '2020-04-20T21:18:45Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('48826197', '23955930', 'eqs', 'black', '2022', '2018-10-06T18:47:50Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('61504644', '1329105', 'ninja', 'green', '2022', '2019-12-19T12:24:12Z', 'MOTORCYCLE');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('62979105', '47976589', '208', 'blue', '2016', '2020-07-07T07:14:19Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('66719076', '23955930', 'C 200', 'yellow', '2016', '2021-06-11T16:33:28Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('67243214', '32863390', 'Silverado', 'white', '2017', '2019-01-10T09:53:20Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('67439194', '48918054', 'A4', 'purple', '2021', '2021-04-08T00:01:23Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('68816790', '32863390', 'Suburban', 'brown', '2020', '2021-09-09T18:50:08Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('74599883', '78221788', 'Polo', 'green', '2019', '2019-08-17T14:57:42Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('84082667', '36496215', 'Veloster', 'green', '2017', '2020-03-27T22:50:28Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('86346450', '48918054', 'Q7', 'silver', '2020', '2020-01-26T13:16:44Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('90918011', '32863390', 'Malibu', 'red', '2018', '2019-02-25T18:09:55Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('95344954', '47976589', '2008', 'brown', '2019', '2019-06-24T16:23:20Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('99375423', '23955930', 'C 180', 'white', '2015', '2019-04-07T17:11:32Z', 'CAR');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `createdAt`, `vehicleType`) VALUES ('99821561', '23955930', 'GLA 200', 'blue', '2017', '2021-11-04T01:58:43Z', 'CAR');


