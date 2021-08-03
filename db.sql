-- CREATE DATABASE book_sys;

-- CREATE TABLE `user` (
-- 	user_id int NOT NULL AUTO_INCREMENT,
--     user_name varchar(255) NOT NULL,
--     email varchar(255) NOT NULL UNIQUE,
--     `password` varchar(255) NOT NULL,
--     `role` varchar(20) NOT NULL DEFAULT 'Reader',
--     PRIMARY KEY (user_id)
-- );

-- CREATE TABLE book (
-- 	book_id int NOT NULL AUTO_INCREMENT,
--     title varchar(100) NOT NULL,
--     author varchar(255) NOT NULL,
--     category_id int NOT NULL,
--     published_year int NOT NULL,
--     PRIMARY KEY (book_id),
--     FOREIGN KEY (category_id) REFERENCES category(category_id)
-- )

-- CREATE TABLE category (
-- 	category_id int NOT NULL AUTO_INCREMENT,
--     category_name varchar(20) NOT NULL,
--     PRIMARY KEY (category_id)
-- )

-- CREATE TABLE borrow_detail (
-- 	user_id int NOT NULL,
--     book_id int NOT NULL,
--     date_borrow date NOT NULL,
--     date_return date NOT NULL,
--     PRIMARY KEY (user_id, book_id),
--     FOREIGN KEY (user_id) REFERENCES `user`(user_id),
--     FOREIGN KEY (book_id) REFERENCES book(book_id)
-- )

SELECT title FROM (
	SELECT u.user_name, u.user_id, b.title, b.book_id, c.category_name, bd.date_borrow, bd.date_return FROM `user` u
	INNER JOIN borrow_detail bd ON u.user_id = bd.user_id
	INNER JOIN book b ON b.book_id = bd.book_id
	INNER JOIN category c ON c.category_id = b.category_id
) AS t


























