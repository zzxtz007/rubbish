SET NAMES utf8;
DROP TABLE IF EXISTS operator;
DROP TABLE IF EXISTS appraisal;
DROP TABLE IF EXISTS repair;
DROP TABLE IF EXISTS operator_id_seq;
DROP TABLE IF EXISTS user_id_seq;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS mode;
DROP TABLE IF EXISTS washer;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS storied;


CREATE TABLE storied (
  id          INT                  AUTO_INCREMENT PRIMARY KEY
  COMMENT '自增 ID',
  number      INT         NOT NULL UNIQUE
  COMMENT '楼层号',
  insert_user VARCHAR(12) NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12) NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)      NOT NULL DEFAULT FALSE
  COMMENT '删除标记'

)
  COMMENT '楼号';

CREATE TABLE mode (
  id          INT PRIMARY KEY      AUTO_INCREMENT
  COMMENT '自增 ID',
  type        VARCHAR(64) NOT NULL
  COMMENT '洗衣模式',
  price       INT         NOT NULL
  COMMENT '洗衣价格',
  washer_time INT         NOT NULL
  COMMENT '洗衣时间',
  insert_user VARCHAR(12) NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12) NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)      NOT NULL DEFAULT FALSE
  COMMENT '删除标记'
)
  COMMENT '洗衣模式';

CREATE TABLE washer (
  id          INT PRIMARY KEY        AUTO_INCREMENT
  COMMENT '自增 ID',
  storied_id  INT         NOT NULL
  COMMENT '所属楼号',
  status      INT         NOT NULL
  COMMENT '洗衣机状态标记
  0=待机(等待服务)
  1=被预约
  2=运行中
  3=故障
  ',
  insert_user VARCHAR(12) NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME    NOT NULL   DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12) NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME    NOT NULL   DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)      NOT NULL   DEFAULT FALSE
  COMMENT '删除标记',
  FOREIGN KEY (storied_id) REFERENCES storied (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  COMMENT '洗衣机';

CREATE TABLE user (
  id          VARCHAR(12) PRIMARY KEY
  COMMENT '自增 ID',
  name        VARCHAR(64)                NOT NULL
  COMMENT '姓名',
  phone       VARCHAR(20) UNIQUE         NOT NULL
  COMMENT '手机号',
  salt        VARCHAR(64)                NOT NULL
  COMMENT '盐值',
  pwd_hash    VARCHAR(64)                NOT NULL
  COMMENT '加盐密码的散列值',
  storied_id  INT                        NOT NULL DEFAULT 0
  COMMENT '所属楼号',
  balance     DECIMAL(10, 2)             NOT NULL DEFAULT 0
  COMMENT '余额',
  insert_user VARCHAR(12)                NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME                   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12)                NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME                   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)                     NOT NULL DEFAULT FALSE
  COMMENT '删除标记',
  FOREIGN KEY (storied_id) REFERENCES storied (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  COMMENT '用户';

CREATE TABLE user_id_seq
(
  id INT PRIMARY KEY AUTO_INCREMENT
);

DELIMITER //

CREATE TRIGGER user_id_trig
  BEFORE INSERT
  ON user
  FOR EACH ROW
  BEGIN
    IF new.id IS NULL
    THEN
      INSERT INTO user_id_seq VALUES ();
      SET new.id = concat('u_', last_insert_id());
    END IF;
  END;
//
DELIMITER ;


CREATE TABLE operator (
  id          VARCHAR(12) PRIMARY KEY
  COMMENT '自增 ID',
  username    VARCHAR(32) NOT NULL UNIQUE
  COMMENT '用户名',
  salt        VARCHAR(64) NOT NULL
  COMMENT '盐值',
  pwd_hash    VARCHAR(64) NOT NULL
  COMMENT '加盐密码的散列值',
  insert_time DATETIME    NOT NULL               DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_time DATETIME    NOT NULL               DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)      NOT NULL               DEFAULT FALSE
  COMMENT '删除标记'
)
  COMMENT '管理员';

CREATE TABLE operator_id_seq
(
  id INT PRIMARY KEY AUTO_INCREMENT
);

DELIMITER //
CREATE TRIGGER operator_id_trig
  BEFORE INSERT
  ON operator
  FOR EACH ROW
  BEGIN
    IF new.id IS NULL
    THEN
      INSERT INTO operator_id_seq VALUES ();
      SET new.id = concat('o_', last_insert_id());
    END IF;
  END;
//
DELIMITER ;


CREATE TABLE `order` (
  id          INT PRIMARY KEY            AUTO_INCREMENT
  COMMENT '自增 ID',
  washer_id   INT            NOT NULL
  COMMENT '洗衣机编号',
  user_id     VARCHAR(12)    NOT NULL
  COMMENT '用户编号',
  mode_id     INT            NOT NULL
  COMMENT '洗衣模式',
  status      INT            NOT NULL
  COMMENT '订单状态标记：可以判断是否为预约
  0=已付款
  1=运行中
  2=故障
  ',
  money       DECIMAL(10, 2) NOT NULL
  COMMENT '订单价格',
  insert_user VARCHAR(12)    NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME       NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12)    NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME       NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)         NOT NULL    DEFAULT FALSE
  COMMENT '删除标记',
  FOREIGN KEY (washer_id) REFERENCES washer (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (mode_id) REFERENCES mode (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  COMMENT '订单表';

CREATE TABLE appraisal (
  id          INT PRIMARY KEY          AUTO_INCREMENT
  COMMENT '自增 ID',
  order_id    INT          NOT NULL
  COMMENT '订单 ID',
  user_id     VARCHAR(12)  NOT NULL
  COMMENT '用户 ID',
  message     VARCHAR(256) NOT NULL
  COMMENT '评价信息',
  insert_user VARCHAR(12)  NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME     NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12)  NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME     NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)       NOT NULL    DEFAULT FALSE
  COMMENT '删除标记',
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (order_id) REFERENCES `order` (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  COMMENT '评价';

CREATE TABLE repair (
  id          INT PRIMARY KEY          AUTO_INCREMENT
  COMMENT '自增 ID',
  washer_id   INT          NOT NULL
  COMMENT '洗衣机 ID',
  user_id     VARCHAR(12)  NOT NULL
  COMMENT '用户 ID',
  message     VARCHAR(256) NOT NULL
  COMMENT '报修原因',
  is_handle   BIT(1)       NOT NULL    DEFAULT FALSE
  COMMENT '是否处理',
  insert_user VARCHAR(12)  NOT NULL
  COMMENT '插入数据的用户',
  insert_time DATETIME     NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '插入数据的时间',
  update_user VARCHAR(12)  NOT NULL
  COMMENT '最后修改数据的用户',
  update_time DATETIME     NOT NULL    DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改数据的时间',
  is_deleted  BIT(1)       NOT NULL    DEFAULT FALSE
  COMMENT '删除标记',
  FOREIGN KEY (washer_id) REFERENCES washer (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  COMMENT '报修';