DROP DATABASE IF EXISTS bookstore;

CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE book (
	id INTEGER NOT NULL,
	title VARCHAR(100),
	descriptions VARCHAR(100),
	isbn VARCHAR(13) UNIQUE,
	author_first_name VARCHAR(50),
	author_last_name VARCHAR(50),
	publisher_company VARCHAR(50),
	publisher_address VARCHAR(100),
    mimeType VARCHAR(50),
	cover BLOB,
	PRIMARY KEY(id)
);