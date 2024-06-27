-- Drop the table if it exists to start fresh
DROP TABLE IF EXISTS `person` CASCADE;

-- Create the person table
CREATE TABLE `person` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `age` INTEGER,
    `job` VARCHAR(255)
);
