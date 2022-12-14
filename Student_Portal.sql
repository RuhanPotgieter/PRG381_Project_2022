-- MySQL Script generated by MySQL Workbench
-- Thu Aug 18 11:07:01 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Student_Portal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Student_Portal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Student_Portal` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `Student_Portal` ;

-- -----------------------------------------------------
-- Table `Student_Portal`.`Course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student_Portal`.`Course` ;

CREATE TABLE IF NOT EXISTS `Student_Portal`.`Course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(45) NOT NULL,
  `course_tuition` FLOAT NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE INDEX `course_name_UNIQUE` (`course_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Student_Portal`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student_Portal`.`Student` ;

CREATE TABLE IF NOT EXISTS `Student_Portal`.`Student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `student_name` VARCHAR(45) NULL,
  `student_surname` VARCHAR(45) NULL,
  `student_address` VARCHAR(45) NULL,
  `student_email` VARCHAR(45) NOT NULL,
  `student_password` VARCHAR(45) NOT NULL,
  `student_course` INT NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE INDEX `student_email_UNIQUE` (`student_email` ASC) VISIBLE,
  UNIQUE INDEX `student_password_UNIQUE` (`student_password` ASC) VISIBLE,
  CONSTRAINT `course`
    FOREIGN KEY (`student_course`)
    REFERENCES `Student_Portal`.`Course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Student_Portal`.`Subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student_Portal`.`Subject` ;

CREATE TABLE IF NOT EXISTS `Student_Portal`.`Subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE INDEX `subject_name_UNIQUE` (`subject_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Student_Portal`.`Register`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student_Portal`.`Register` ;

CREATE TABLE IF NOT EXISTS `Student_Portal`.`Register` (
  `register_id` INT NOT NULL AUTO_INCREMENT,
  `student` INT NULL,
  `subject` INT NULL,
  PRIMARY KEY (`register_id`),
  CONSTRAINT `student`
    FOREIGN KEY (`student`)
    REFERENCES `Student_Portal`.`Student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `subject`
    FOREIGN KEY (`subject`)
    REFERENCES `Student_Portal`.`Subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Student_Portal`.`Administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student_Portal`.`Administrator` ;

CREATE TABLE IF NOT EXISTS `Student_Portal`.`Administrator` (
  `Admin_id` INT NOT NULL AUTO_INCREMENT,
  `Admin_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(12) NULL,
  PRIMARY KEY (`Admin_id`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE)
ENGINE = InnoDB;

USE `Student_Portal`;

DELIMITER $$

USE `Student_Portal`$$
DROP TRIGGER IF EXISTS `Student_Portal`.`Register_AFTER_INSERT` $$
USE `Student_Portal`$$
CREATE DEFINER = CURRENT_USER TRIGGER `Student_Portal`.`Register_AFTER_INSERT` BEFORE INSERT ON `Register` FOR EACH ROW
BEGIN
	DECLARE stud_id integer;
    DECLARE sub_id integer;
    
    SET stud_id := NEW.student;
    SET sub_id :=  NEW.subject;
    
    IF sub_id IN (SELECT subject FROM Register WHERE student = stud_id) THEN
		SIGNAL sqlstate '45001' set message_text = "Student already has that subject!";
	END IF;
END;$$


USE `Student_Portal`$$
DROP TRIGGER IF EXISTS `Student_Portal`.`Register_AFTER_UPDATE` $$
USE `Student_Portal`$$
CREATE DEFINER = CURRENT_USER TRIGGER `Student_Portal`.`Register_AFTER_UPDATE` BEFORE UPDATE ON `Register` FOR EACH ROW
BEGIN
	DECLARE stud_id integer;
    DECLARE sub_id integer;
    
    SET stud_id := NEW.student;
    SET sub_id := NEW.subject;
    
    IF sub_id IN (SELECT subject FROM Register WHERE student = stud_id) THEN
		SIGNAL sqlstate '45001' set message_text = "Student already has that subject!";
	END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Student_Portal`.`Course`
-- -----------------------------------------------------
START TRANSACTION;
USE `Student_Portal`;
INSERT INTO `Student_Portal`.`Course` (`course_id`, `course_name`, `course_tuition`) VALUES (1, 'Bachelor of Computing', 98000.00);
INSERT INTO `Student_Portal`.`Course` (`course_id`, `course_name`, `course_tuition`) VALUES (2, 'Bachelor of Information Technology', 88000.00);
INSERT INTO `Student_Portal`.`Course` (`course_id`, `course_name`, `course_tuition`) VALUES (3, 'Diploma in Information Technology', 62000.00);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Student_Portal`.`Subject`
-- -----------------------------------------------------
START TRANSACTION;
USE `Student_Portal`;
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (1, 'Academic Writing');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (2, 'Business Management');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (3, 'Computer Architecture');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (4, 'Database Development');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (5, 'Information Systems');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (6, 'Linear Programming');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (7, 'Mathematics');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (8, 'Network Development');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (9, 'Programming');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (10, 'Project Management');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (11, 'Statistics');
INSERT INTO `Student_Portal`.`Subject` (`subject_id`, `subject_name`) VALUES (12, 'Web Programming');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Student_Portal`.`Administrator`
-- -----------------------------------------------------
START TRANSACTION;
USE `Student_Portal`;
INSERT INTO `Student_Portal`.`Administrator` (`Admin_name`, `password`, `contact`) VALUES ('Brooks', 'gx2toxHzp', '127-513-0956');
INSERT INTO `Student_Portal`.`Administrator` (`Admin_name`, `password`, `contact`) VALUES ('Athene', 'eNuxjRB', '442-485-3995');
INSERT INTO `Student_Portal`.`Administrator` (`Admin_name`, `password`, `contact`) VALUES ('Shelbi', 'Aae1YFTRAe', '478-995-5810');
INSERT INTO `Student_Portal`.`Administrator` (`Admin_name`, `password`, `contact`) VALUES ('Luciana', '70af0Vxo', '233-782-3404');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Student_Portal`.`Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `Student_Portal`;
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Amelita', 'Varnham', '36 Laurel Avenue', 'avarnham0@1und1.de', 'O17JnPZtnT', 1);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Matty', 'Archbutt', '7203 Service Drive', 'marchbutt1@example.com', 'GYp1ky0i', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Amye', 'Espinosa', '952 Karstens Street', 'aespinosa2@xing.com', 'uHChTvJ', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Joelly', 'Claydon', '0619 Lakewood Road', 'jclaydon3@jimdo.com', '0DUqAoW', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Anet', 'Gogie', '614 Loomis Road', 'agogie4@google.cn', 'aiX4Jyl7d7', 2);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Evan', 'Waldocke', '38 Riverside Parkway', 'ewaldocke5@bigcartel.com', 'sTGBhX6iB', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Fawne', 'Byles', '518 Ohio Terrace', 'fbyles6@taobao.com', '8Q8l3GcYmA', 2);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Alic', 'Cicchelli', '765 Anderson Drive', 'acicchelli7@ucoz.ru', 'snIp0SltKhHb', 1);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Rafi', 'Abendroth', '85778 Columbus Street', 'rabendroth8@biblegateway.com', 'kP6jXNlQXk', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Annamarie', 'Mattosoff', '5749 David Lane', 'amattosoff9@tuttocitta.it', '9biMQL', 2);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Carlee', 'Sandison', '6193 Memorial Plaza', 'csandisona@oaic.gov.au', 'ewnpE5Fx91', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Laughton', 'Doak', '92513 Lakewood Gardens Lane', 'ldoakb@w3.org', 'E30Tri', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Gabriellia', 'Vigrass', '8 Anzinger Place', 'gvigrassc@fema.gov', 'Y0ZmAe3sFXZ', 1);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Spenser', 'Ingledew', '26674 Dahle Center', 'singledewd@vk.com', 'mz98vfe', 3);
INSERT INTO `Student_Portal`.`Student` (`student_name`, `student_surname`, `student_address`, `student_email`, `student_password`, `student_course`) VALUES ('Harriett', 'McGuffog', '57854 Westerfield Pass', 'hmcguffoge@blog.com', 'HNoUfcrFTE', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Student_Portal`.`Register`
-- -----------------------------------------------------
START TRANSACTION;
USE `Student_Portal`;
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (1, 5);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (2, 10);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (3, 8);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (4, 9);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (5, 1);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (6, 1);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (7, 7);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (8, 8);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (9, 3);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (10, 2);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (11, 4);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (12, 7);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (13, 5);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (14, 1);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (15, 9);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (1, 3);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (2, 7);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (3, 5);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (4, 12);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (5, 9);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (6, 2);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (7, 1);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (8, 4);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (9, 7);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (10, 8);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (11, 1);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (12, 3);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (13, 6);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (14, 11);
INSERT INTO `Student_Portal`.`Register` (`student`, `subject`) VALUES (15, 11);
COMMIT;
