CREATE TABLE `automaker` (
  `automakerID` int NOT NULL,
  `automaker` varchar(255) NOT NULL,
  PRIMARY KEY (`automakerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sort` (
  `id` int NOT NULL,
  `sort` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vehicle` (
  `vehicleID` varchar(45) NOT NULL,
  `automakerID` int NOT NULL,
  `model` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `year` int NOT NULL,
  `modified` varchar(255) NOT NULL,
  `sortID` int NOT NULL,
  PRIMARY KEY (`vehicleID`),
  KEY `automakerID_idx` (`automakerID`) /*!80000 INVISIBLE */,
  KEY `vehicleTypeID_idx` (`sortID`) /*!80000 INVISIBLE */,
  CONSTRAINT `automakerID` FOREIGN KEY (`automakerID`) REFERENCES `automaker` (`automakerID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vehicle_sortid` FOREIGN KEY (`sortID`) REFERENCES `sort` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `web_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authorities` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sydf5vujahmtb782b5tycd0h4` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
    
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
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('123456789', 'testVehicle');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('124958753', 'PICKUP');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('654258952', 'OTHERS');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('658659321', 'TRUCK');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('757215896', 'VAN');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('858124568', 'MOTORCYCLE');
INSERT INTO `auto_dealer`.`sort` (`id`, `sort`) VALUES ('875412569', 'CAR');
INSERT INTO `auto_dealer`.`web_user` (`id`, `authorities`, `name`, `password`, `username`) VALUES ('1', 'ROLE_USER, ROLE_ADMIN', 'Admin admin', '$2a$10$S84BaSg4vgMO2Fx/.5tG4u3p6kXjYEtLss6V4OWjA.Gs3aHf/QAvG', 'admin1');
INSERT INTO `auto_dealer`.`web_user` (`id`, `authorities`, `name`, `password`, `username`) VALUES ('2', 'ROLE_USER', 'User user', '$2a$10$S84BaSg4vgMO2Fx/.5tG4u3p6kXjYEtLss6V4OWjA.Gs3aHf/QAvG', 'user1');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('10901306', '78221788', 'Jetta', 'purple', '2018', '2022-06-04T21:20:33Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('3105758', '36496215', 'Sonata', 'blue', '2016', '2021-09-16T03:44:49Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('32041979', '78221788', 'Golf', 'black', '2018', '2020-12-06T11:24:39Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('36424440', '48918054', 'R8', 'green', '2014', '2019-11-01T00:37:43Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('44650161', '36496215', 'Azera', 'red', '2019', '2020-10-11T18:14:30Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('45782289', '47976589', '206', 'silver', '2017', '2020-04-20T21:18:45Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('48826197', '23955930', 'eqs', 'black', '2022', '2018-10-06T18:47:50Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('61262437', '369416', 'ioniq 5', 'red', '2019', '2019-08-12T08:30:34Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('61504644', '1329105', 'ninja', 'green', '2022', '2019-12-19T12:24:12Z', '858124568');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('62979105', '47976589', '208', 'blue', '2016', '2020-07-07T07:14:19Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('66719076', '23955930', 'C 200', 'yellow', '2016', '2021-06-11T16:33:28Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('67243214', '32863390', 'Silverado', 'white', '2017', '2019-01-10T09:53:20Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('67439194', '48918054', 'A4', 'purple', '2021', '2021-04-08T00:01:23Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('68816790', '32863390', 'Suburban', 'brown', '2020', '2021-09-09T18:50:08Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('74599883', '78221788', 'Polo', 'green', '2019', '2019-08-17T14:57:42Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('84082667', '36496215', 'Veloster', 'green', '2017', '2020-03-27T22:50:28Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('86346450', '48918054', 'Q7', 'silver', '2020', '2020-01-26T13:16:44Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('90918011', '32863390', 'Malibu', 'red', '2018', '2019-02-25T18:09:55Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('95344954', '47976589', '2008', 'brown', '2019', '2019-06-24T16:23:20Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('99375423', '23955930', 'C 180', 'white', '2015', '2019-04-07T17:11:32Z', '875412569');
INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`, `color`, `year`, `modified`, `sortID`) VALUES ('99821561', '23955930', 'GLA 200', 'blue', '2017', '2021-11-04T01:58:43Z', '875412569');



