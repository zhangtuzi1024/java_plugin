DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id    BIGINT(20)  NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_extend;

CREATE TABLE user_extend
(
    id          BIGINT(20)   NOT NULL COMMENT '主键ID',
    description VARCHAR(255) NULL DEFAULT NULL COMMENT '说明'
);

DELETE
FROM user;

INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');

DELETE
FROM user_extend;

INSERT INTO user_extend (id, description)
VALUES (1, '说明1'),
       (2, '说明2'),
       (3, '说明3'),
       (4, '说明4'),
       (5, '说明5');
