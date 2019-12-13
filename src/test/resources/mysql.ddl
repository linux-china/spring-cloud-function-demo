DROP TABLE IF EXISTS account;
CREATE TABLE account (
    id         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nick       VARCHAR(64),
    email      VARCHAR(128),
    phone      VARCHAR(16),
    passwd     VARCHAR(64),
    created_at DATETIME,
    updated_at DATETIME
)
    DEFAULT CHARSET = utf8;

insert into account(nick, email, phone, created_at, updated_at)
values ('linux_china', 'libing.chen@gmail.com', '1861111111', now(), now());
