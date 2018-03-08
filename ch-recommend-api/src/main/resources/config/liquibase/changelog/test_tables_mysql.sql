# 
#  table for  test  add by leijp 
#  

DROP TABLE IF EXISTS tbl_user;

CREATE TABLE tbl_user (
   id int(11) NOT NULL,
   user_name varchar(100) DEFAULT NULL,
   age int(11) DEFAULT NULL,
   phone varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
commit;
