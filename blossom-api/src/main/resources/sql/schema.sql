DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id          bigint auto_increment primary key,
    social_id   varchar(300) not null,
    social_type varchar(30)  not null,
    created_at  datetime(6) not null,
    modified_at datetime(6) not null
);
