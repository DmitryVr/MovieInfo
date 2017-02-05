-- Database: movieInfoDatabase
-- CREATE DATABASE movieInfoDatabase CHARACTER SET utf8;

-- Table: genres
CREATE TABLE movieInfoDatabase.genres (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

-- Table: movie
CREATE TABLE movieInfoDatabase.movie (
  id   INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nameRussian VARCHAR(50) NOT NULL,
  nameOriginal VARCHAR(50) NULL,
  image MEDIUMBLOB NULL,
  year VARCHAR(4) NOT NULL,
  country VARCHAR(70) NOT NULL,
  director VARCHAR(70) NOT NULL,
  genre_id INT NOT NULL,
  description TEXT NOT NULL,

  FOREIGN KEY (genre_id) REFERENCES movieInfoDatabase.genres (id)
) ENGINE = InnoDB;
--   CHARACTER SET utf8;

-- Insert data
INSERT INTO movieInfoDatabase.genres VALUES (1, 'Драма');
INSERT INTO movieInfoDatabase.genres VALUES (2, 'Фантастика');
INSERT INTO movieInfoDatabase.genres VALUES (3, 'Вестерн');
INSERT INTO movieInfoDatabase.genres VALUES (4, 'Фентези');
INSERT INTO movieInfoDatabase.genres VALUES (5, 'Триллер');

INSERT INTO movieInfoDatabase.movie VALUES (1, 'Бойцовский клуб', 'Fight Club', LOAD_FILE('/home/images/fight_club.jpg'), '1999', 'США', 'Дэвид Финчер', 1, 'Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно скучной жизни, клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение — единственное, ради чего стоит жить.');
INSERT INTO movieInfoDatabase.movie VALUES (2, 'Темный рыцарь', 'Dark Knight', LOAD_FILE('/home/images/dark_knight.jpg'), '2008', 'США', 'Кристофер Нолан', 2, 'Бэтмен поднимает ставки в войне с криминалом. С помощью лейтенанта Джима Гордона и прокурора Харви Дента он намерен очистить улицы от преступности, отравляющей город. Сотрудничество оказывается эффективным, но скоро они обнаружат себя посреди хаоса, развязанного восходящим криминальным гением, известным испуганным горожанам под именем Джокер.');
INSERT INTO movieInfoDatabase.movie VALUES (3, 'Джанго освобожденный', 'Django Unchained', LOAD_FILE('/home/images/django.jpg'), '2012', 'США', 'Квентин Тарантино', 3, 'Эксцентричный охотник за головами, также известный как «Дантист», промышляет отстрелом самых опасных преступников. Работенка пыльная, и без надежного помощника ему не обойтись. Но как найти такого и желательно не очень дорогого? Беглый раб по имени Джанго — прекрасная кандидатура. Правда, у нового помощника свои мотивы — кое с чем надо разобраться…');
INSERT INTO movieInfoDatabase.movie VALUES (4, 'Догма', 'Dogma', LOAD_FILE('/home/images/dogma.jpg'), '1999', 'США', 'Кевин Смит', 4, 'Два падших ангела, Локи и Бартлби, обреченные вечность торчать в штате Висконсин, узнали, что у них есть шанс вернуться в рай. Для этого нужно всего лишь воспользоваться ошибочной церковной католической догмой, провозглашенной кардиналом-новатором: каждый, прошедший через освященную арку в соборе в Нью-Джерси, получает отпущение грехов. Пройдя через нее, Локи и Бартлби получат прощение, далее им надо стать смертными, умереть и возвратиться в рай.');
INSERT INTO movieInfoDatabase.movie VALUES (5, 'Форрест Гамп', 'Forrest Gump', LOAD_FILE('/home/images/forrest.jpg'), '1994', 'США', 'Роберт Земекис', 1, 'От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.');
INSERT INTO movieInfoDatabase.movie VALUES (6, 'Омерзительная восьмерка', 'The Hateful Eight', LOAD_FILE('/home/images/hateful.jpg'), '2015', 'США', 'Квентин Тарантино', 3, 'США после Гражданской войны. Легендарный охотник за головами Джон Рут по кличке Вешатель конвоирует заключенную. По пути к ним прибиваются еще несколько путешественников. Снежная буря вынуждает компанию искать укрытие в лавке на отшибе, где уже расположилось весьма пестрое общество: генерал конфедератов, мексиканец, ковбой… И один из них — не тот, за кого себя выдает.');
INSERT INTO movieInfoDatabase.movie VALUES (7, 'Зеленая миля', 'The Green Mile', LOAD_FILE('/home/images/green.jpg'), '1999', 'США', 'Фрэнк Дарабонт', 4, 'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.');
INSERT INTO movieInfoDatabase.movie VALUES (8, 'Криминальное чтиво', 'Pulp Fiction', LOAD_FILE('/home/images/pulp.jpg'), '1994', 'США', 'Квентин Тарантино', 5, 'Двое бандитов Винсент Вега и Джулс Винфилд проводят время в философских беседах в перерыве между разборками и «решением проблем» с должниками своего криминального босса Марселласа Уоллеса. Параллельно разворачиваются три истории.');
INSERT INTO movieInfoDatabase.movie VALUES (9, 'Прометей', 'Prometheus', LOAD_FILE('/home/images/prometheus.jpg'), '2012', 'США', 'Ридли Скотт', 2, 'В поисках сакрального знания группа ученых отправляется в самые темные и неизведанные чертоги вселенной. Именно там, в отдаленных мирах, находясь на пределе своих умственных и физических возможностей, им предстоит вступить в безжалостную схватку за будущее всего человечества…');
-- -----------------------------------------------------------------------------
-- Table: users
CREATE TABLE movieInfoDatabase.users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

-- Table: roles
CREATE TABLE movieInfoDatabase.roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE movieInfoDatabase.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES movieInfoDatabase.users (id),
  FOREIGN KEY (role_id) REFERENCES movieInfoDatabase.roles (id),

  UNIQUE (user_id, role_id)
) ENGINE = InnoDB;

-- Insert data
-- password 12345678
INSERT INTO movieInfoDatabase.users VALUES (1, 'user1', '$2a$06$IKi0bs82p6arYeVACniOeOQ090TDr21tZZCmZd6VXvuekyg2XVNiO');
-- password 23456789
INSERT INTO movieInfoDatabase.users VALUES (2, 'user2', '$2a$06$ADJzFJLi6VEtHnR9PX5Vg.CenQcsQGHyENuBKcoffziH9XUQ4rDla');
-- password 34567890
INSERT INTO movieInfoDatabase.users VALUES (3, 'admin1', '$2a$06$.XzMCByLJ1I2MuJHvkAl9.6guHYj4e4mg45VW7/cER4avo2XfE5XW');
-- password 45678901
INSERT INTO movieInfoDatabase.users VALUES (4, 'admin2', '$2a$06$0M8qQb9DR5aNfInfpFO5I.K4ihMV48rzdROETgTKP6DOOdAKcaMqa');

INSERT INTO movieInfoDatabase.roles VALUES (1, 'ROLE_USER');
INSERT INTO movieInfoDatabase.roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO movieInfoDatabase.user_roles VALUES (1, 1);
INSERT INTO movieInfoDatabase.user_roles VALUES (2, 1);
INSERT INTO movieInfoDatabase.user_roles VALUES (3, 2);
INSERT INTO movieInfoDatabase.user_roles VALUES (4, 2);
INSERT INTO movieInfoDatabase.user_roles VALUES (3, 1);
INSERT INTO movieInfoDatabase.user_roles VALUES (4, 1);