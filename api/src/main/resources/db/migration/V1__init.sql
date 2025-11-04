create table users (
  id serial primary key,
  name varchar(100) not null
);

create table movies (
  id serial primary key,
  title varchar(200) not null,
  genre varchar(100),
  year int
);

create table reviews (
  id serial primary key,
  user_id int not null references users(id) on delete cascade,
  movie_id int not null references movies(id) on delete cascade,
  rating numeric(2,1) not null check (rating >= 0 and rating <= 5),
  comment text,
  created_at timestamp default now()
);

insert into users (name) values
('Ava'), ('Liam'), ('Noah');

insert into movies (title, genre, year) values
('The Matrix', 'Sci-Fi', 1999),
('Inception', 'Sci-Fi', 2010),
('The Dark Knight', 'Action', 2008),
('Interstellar', 'Sci-Fi', 2014),
('Parasite', 'Thriller', 2019);

insert into reviews (user_id, movie_id, rating, comment) values
(1, 1, 4.5, 'Iconic'),
(2, 2, 4.0, 'Mind bending'),
(3, 3, 5.0, 'Masterpiece'),
(1, 4, 4.2, 'Beautiful'),
(2, 5, 4.7, 'Brilliant');
