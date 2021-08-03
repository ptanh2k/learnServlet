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

-- INSERT INTO `user` 
-- 	(user_name, email, `password`, `role`)
-- VALUES
-- 	('Dao Duc Anh', 'daoducanhc@gmail.com', 'daoc', 'Reader'),
--     ('Duong Minh Hoang Anh', 'hoanganhnvnb@gmail.com', 'hoanganh76', 'Reader'),
--     ('Nguyen Hai Anh', 'dumathu@gmail.com', 'dumathu', 'Reader'),
--     ('Nguyen Quang Bach', 'backwibu@gmail.com', 'wjbu', 'Librarian'),
--     ('Vuong Tri Thien Cong', 'vuongcong144@gmail.com', 'chun', 'Reader'),
--     ('Duong Quoc Cuong', 'quoccuong100300@gmail.com', 'cuongdiy', 'Administrator'),
--     ('Le Minh Hoang', 'hoangleminh@gmail.com', 'machinelearning', 'Reader'),
--     ('Nguyen Thanh Binh', 'binhshadow@gmail.com', 'tibi2k', 'Reader');

-- INSERT INTO category
-- 	(category_name)
-- VALUES 
-- 	('Adventure'),
--     ('Autobiography'),
--     ('Biography'),
--     ("Children"),
-- 	('Classics'),
--     ('Essay'),
--     ('Fantasy'),
--     ('Historical Fiction'),
--     ('History'),
--     ('Horror'),
--     ('Literary Fiction'),
--     ('Medical'),
--     ('Memoir'),
--     ('Mystery'),
--     ('Novel'),
--     ('Poetry'),
--     ('Psychology'),
--     ('Romance'),
--     ('Science Fiction'),
--     ('Self-Help'),
--     ('Short Story'),
--     ('Slice of life'),
--     ('Thriller'),
--     ('True Crime'),
--     ('Vignette');

-- INSERT INTO book 
-- 	(title, author, category_id, published_year)
-- VALUES
-- 	('3 phut so cuu', 'BS. Ngo Duc Hung', 12, 2019),
--     ('Lang nghe gio hat', 'Haruki Murakami', 22, 1979),
--     ("Man's search for meaning", 'Viktor E. Frankl', 17, 1946),
--     ('Ve em bang mau noi nho', 'Tam Pham', 18, 2016),
--     ('Flow', 'Mihaly Csikszentmihalyi', 20, 1990),
--     ('Ta ba lo tren dat A', 'Rosie Nguyen', 13, 2015),
--     ('Co mot pho vui di qua pho', 'Dinh Vu Hoang Nguyen', 25, 2013),
--     ('The Alchemist', 'Paulo Coelho', 1, 1993),
--     ('Nha gia kim', 'Paulo Coelho', 1, 2006),
--     ('The Miracles of the Namiya General Store', 'Keigo Higashino', 14, 2012);

-- INSERT INTO borrow_detail
-- 	(user_id, book_id, date_borrow, date_return)
-- VALUES
-- 	(1, 2, '2021-07-29', '2021-08-03'),
--     (1, 3, '2021-07-29', '2021-08-03'),
--     (2, 7, '2021-08-03', '2021-08-07'),
--     (3, 1, '2021-08-03', '2021-08-15'),
--     (5, 4, '2021-08-02', '2021-08-15'),
--     (6, 10, '2021-07-28', '2021-08-05'),
--     (8, 5, '2021-07-30', '2021-08-01');


SELECT u.user_name, u.user_id, b.title, b.book_id, c.category_name, bd.date_borrow, bd.date_return FROM `user` u
JOIN borrow_detail bd ON u.user_id = bd.user_id
JOIN book b ON b.book_id = bd.book_id
JOIN category c ON c.category_id = b.category_id



























