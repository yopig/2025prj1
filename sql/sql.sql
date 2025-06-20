create database prj1;

use prj1;


CREATE TABLE board
(
    id         INT AUTO_INCREMENT NOT NULL,
    title      VARCHAR(255)       NULL,
    content    VARCHAR(255)       NULL,
    writer     VARCHAR(255)       NULL,
    created_at datetime           NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_board PRIMARY KEY (id)
);

select *
from board;

insert into board
    (title, content, writer)
select title, content, writer
from board;