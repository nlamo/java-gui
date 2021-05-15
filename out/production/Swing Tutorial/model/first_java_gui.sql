-- DROP DATABASE IF EXISTS first_java_GUI;
CREATE DATABASE IF NOT EXISTS first_java_GUI;
USE first_java_GUI;

CREATE TABLE `users` (
`user_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(25),
`height` SMALLINT,  -- in cm
`weight` SMALLINT, -- in kgusers
`programming_pref` VARCHAR(25),
PRIMARY KEY (user_ID)
);