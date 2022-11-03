DROP TABLE movie IF EXISTS;

CREATE TABLE movie  (
                         id BIGINT IDENTITY NOT NULL PRIMARY KEY,
                         title VARCHAR,
                         studios VARCHAR,
                         producersName VARCHAR,
                         has_won BOOLEAN,
                         year INTEGER
);