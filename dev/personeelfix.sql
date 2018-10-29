set names utf8mb4;
set charset utf8mb4;
drop database if exists personeelfix;
create database personeelfix charset utf8mb4;
use personeelfix;

DROP TABLE IF EXISTS werknemers;
CREATE TABLE werknemers (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  geboorte date NOT NULL,
  rijksregisternr bigint unsigned NOT NULL
);

INSERT INTO werknemers(geboorte, rijksregisternr) VALUES
 ('1966-08-01',66080100153),
 ('1950-01-31',50013100129),
 ('1961-08-01',61080100145),
 ('1952-12-31',52123100151),
 ('1953-03-03',53030300173),
 ('1955-08-29',55082900149),
 ('1960-01-01',60010100172),
 ('1960-06-13',60061300138);
 
create user if not exists cursist identified by 'cursist';
grant select,update on werknemers to cursist;