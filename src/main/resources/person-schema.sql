-- Drop the table if it exists to start fresh
DROP TABLE IF EXISTS `person` CASCADE;
DROP TABLE IF EXISTS `pet` CASCADE;

-- Create the person table
CREATE TABLE `person` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `age` INTEGER,
    `job` VARCHAR(255)
);

CREATE TABLE `pet` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `type` VARCHAR(255),
    `name` VARCHAR(255),
    `age` INTEGER,
    `person_id` INTEGER,
    FOREIGN KEY (`person_id`) REFERENCES `person`(`id`)
);