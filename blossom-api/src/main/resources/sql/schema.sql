DROP TABLE IF EXISTS `USER`;
DROP TABLE IF EXISTS `FLOWER`;
DROP TABLE IF EXISTS `FLOWER_IMAGE`;
DROP TABLE IF EXISTS `FLOWER_TAG`;
DROP TABLE IF EXISTS `FLOWER_LANGUAGE`;
DROP TABLE IF EXISTS `FLOWER_TIME`;
DROP TABLE IF EXISTS `FLOWER_CARE`;
DROP TABLE IF EXISTS `BETTER_TOGETHER`;
DROP TABLE IF EXISTS `FLOWER_CONTENT`;
DROP TABLE IF EXISTS `FLOWER_LIKE`;
DROP TABLE IF EXISTS `FLOWER_HIT`;
DROP TABLE IF EXISTS `CONTENT`;
DROP TABLE IF EXISTS `CONTENT_INFORMATION`;

CREATE TABLE `USER`
(
    `USER_ID`           bigint auto_increment primary key,
    `SOCIAL_ID`         varchar(300) NOT NULL,
    `SOCIAL_TYPE`       varchar(30)  NOT NULL,
    `NICKNAME`          varchar(30)  NOT NULL,
    `PROFILE_IMAGE_URL` varchar(300) NULL,
    `CREATED_AT`        datetime     NOT NULL,
    `MODIFIED_AT`       datetime     NOT NULL
);

CREATE TABLE `FLOWER`
(
    `FLOWER_ID`              bigint auto_increment primary key,
    `KOREAN_NAME`            varchar(30)  NOT NULL,
    `ENGLISH_NAME`           varchar(100) NOT NULL,
    `CATEGORY`               varchar(30)  NOT NULL,
    `FAMILY_NAME`            varchar(30)  NOT NULL,
    `ADDITIONAL_INFORMATION` varchar(100) NOT NULL,
    `FIT_NAME`               varchar(30)  NOT NULL,
    `FIT_INFORMATION`        varchar(100) NOT NULL,
    `CREATED_AT`             datetime     NOT NULL,
    `MODIFIED_AT`            datetime     NOT NULL
);

CREATE TABLE `FLOWER_IMAGE`
(
    `FLOWER_IMAGE_ID`  bigint auto_increment primary key,
    `FLOWER_ID`        bigint       NOT NULL,
    `FLOWER_IMAGE_URL` varchar(300) NOT NULL,
    `ORDER`            int          NOT NULL,
    `CREATED_AT`       datetime     NOT NULL,
    `MODIFIED_AT`      datetime     NOT NULL
);

CREATE TABLE `FLOWER_TAG`
(
    `FLOWER_TAG_ID` bigint auto_increment primary key,
    `FLOWER_ID`     bigint      NOT NULL,
    `NAME`          varchar(30) NOT NULL,
    `CREATED_AT`    datetime    NOT NULL,
    `MODIFIED_AT`   datetime    NOT NULL
);

CREATE TABLE `FLOWER_LANGUAGE`
(
    `FLOWER_LANGUAGE_ID` bigint auto_increment primary key,
    `FLOWER_ID`          bigint      NOT NULL,
    `NAME`               varchar(30) NOT NULL,
    `CREATED_AT`         datetime    NOT NULL,
    `MODIFIED_AT`        datetime    NOT NULL
);

CREATE TABLE `FLOWER_TIME`
(
    `FLOWER_TIME_ID` bigint auto_increment primary key,
    `FLOWER_ID`      bigint   NOT NULL,
    `MONTH`          int      NOT NULL,
    `CREATED_AT`     datetime NOT NULL,
    `MODIFIED_AT`    datetime NOT NULL
);

CREATE TABLE `FLOWER_CARE`
(
    `FLOWER_CARE_ID` bigint auto_increment primary key,
    `FLOWER_ID`      bigint       NOT NULL,
    `INFORMATION`    varchar(100) NOT NULL,
    `ORDER`          int          NOT NULL,
    `CREATED_AT`     datetime     NOT NULL,
    `MODIFIED_AT`    datetime     NOT NULL
);

CREATE TABLE `BETTER_TOGETHER`
(
    `BETTER_TOGETHER_ID`        bigint auto_increment primary key,
    `FLOWER_ID`                 bigint   NOT NULL,
    `BETTER_TOGETHER_FLOWER_ID` bigint   NOT NULL,
    `CREATED_AT`                datetime NOT NULL,
    `MODIFIED_AT`               datetime NOT NULL
);

CREATE TABLE `FLOWER_CONTENT`
(
    `FLOWER_CONTENT_ID` bigint auto_increment primary key,
    `FLOWER_ID`         bigint   NOT NULL,
    `CONTENT_ID`        bigint   NOT NULL,
    `CREATED_AT`        datetime NOT NULL,
    `MODIFIED_AT`       datetime NOT NULL
);

CREATE TABLE `FLOWER_LIKE`
(
    `FLOWER_LIKE_ID` bigint auto_increment primary key,
    `USER_ID`        bigint   NOT NULL,
    `FLOWER_ID`      bigint   NOT NULL,
    `CREATED_AT`     datetime NOT NULL,
    `MODIFIED_AT`    datetime NOT NULL
);

CREATE TABLE `FLOWER_HIT`
(
    `FLOWER_HIT_ID` bigint auto_increment primary key,
    `FLOWER_ID`     bigint   NOT NULL,
    `COUNT`         int      NOT NULL,
    `CREATED_AT`    datetime NOT NULL,
    `MODIFIED_AT`   datetime NOT NULL
);

CREATE TABLE `CONTENT`
(
    `CONTENT_ID`        bigint auto_increment primary key,
    `TITLE`             varchar(100)  NOT NULL,
    `SUBTITLE`          varchar(100)  NOT NULL,
    `DESCRIPTION`       varchar(1000) NOT NULL,
    `CONTENT_IMAGE_URL` varchar(300)  NOT NULL,
    `POSTED_AT`         datetime      NOT NULL,
    `CREATED_AT`        datetime      NOT NULL,
    `MODIFIED_AT`       datetime      NOT NULL
);

CREATE TABLE `CONTENT_INFORMATION`
(
    `CONTENT_INFORMATION_ID` bigint auto_increment primary key,
    `CONTENT_ID`             bigint        NOT NULL,
    `TITLE`                  varchar(100)  NOT NULL,
    `SUBTITLE`               varchar(100)  NOT NULL,
    `DESCRIPTION`            varchar(1000) NOT NULL,
    `CONTENT_IMAGE_URL`      varchar(300)  NOT NULL,
    `ORDER`                  int           NOT NULL,
    `LINK_YN`                boolean       NOT NULL,
    `LINK_URL`               varchar(300) NULL,
    `CREATED_AT`             datetime      NOT NULL,
    `MODIFIED_AT`            datetime      NOT NULL
);