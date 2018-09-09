CREATE SEQUENCE hibernate_sequence;

CREATE TABLE person (
  id         INTEGER PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(20) NOT NULL
);

INSERT INTO person (id, first_name, last_name)
  VALUES (1, 'Fix', 'Me');