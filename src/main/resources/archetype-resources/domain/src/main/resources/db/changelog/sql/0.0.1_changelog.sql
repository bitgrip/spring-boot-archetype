CREATE TABLE IF NOT EXISTS test (
  id binary(16) NOT NULL,
  message varchar(255)  DEFAULT NULL,
  version int NOT NULL,
  PRIMARY KEY (id)
);
