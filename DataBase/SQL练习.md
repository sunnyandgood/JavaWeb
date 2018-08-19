# SQL练习

### 一、建表语句及数据

* 建表

      CREATE TABLE student
      (s_id VARCHAR(50) NOT NULL,
      s_name VARCHAR(100) NOT NULL,
      s_sex VARCHAR(50) NOT NULL, 
      s_birthday DATETIME,
      s_class VARCHAR(50))
      //---------------
      CREATE TABLE coures
      (c_id VARCHAR(50) NOT NULL,
      c_name VARCHAR(100) NOT NULL, 
      t_id VARCHAR(100) NOT NULL)
      //--------------------------
      CREATE TABLE score 
      (s_no varchar(50) NOT NULL,
      s_id VARCHAR(30) NOT NULL, 
      c_id VARCHAR(50) NOT NULL, 
      degree int(10) NOT NULL) 
      //--------------------------------
      CREATE TABLE teacher 
      (t_id VARCHAR(30) NOT NULL, 
      t_name VARCHAR(40) NOT NULL, 
      t_sex VARCHAR(20) NOT NULL, 
      t_birthday DATETIME NOT NULL, 
      prof VARCHAR(60), 
      depart VARCHAR(100) NOT NULL)

* 数据

      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (108 ,'曾华' 
      ,'男' ,'1977-09-01',95033);
      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (105 ,'匡明' 
      ,'男' ,'1975-10-02',95031);
      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (107 ,'王丽' 
      ,'女' ,'1976-01-23',95033);
      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (101 ,'李军' 
      ,'男' ,'1976-02-20',95033);
      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (109 ,'王芳' 
      ,'女' ,'1975-02-10',95031);
      INSERT INTO student (s_id,s_name,s_sex,s_birthday,s_class) VALUES (103 ,'陆君' 
      ,'男' ,'1974-06-03',95031);
      //--------------------------
      INSERT INTO coures(c_id,c_name,t_id)VALUES ('3-105' ,'计算机导论',825);
      INSERT INTO coures(c_id,c_name,t_id)VALUES ('3-245' ,'操作系统' ,804);
      INSERT INTO coures(c_id,c_name,t_id)VALUES ('6-166' ,'数据电路' ,856);
      INSERT INTO coures(c_id,c_name,t_id)VALUES ('9-888' ,'高等数学' ,100);
      //---------------------------
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (201,103,'3-245',86);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (202,105,'3-245',75);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (203,109,'3-245',68);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (204,103,'3-105',92);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (205,105,'3-105',88);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (206,109,'3-105',76);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (207,101,'3-105',64);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (208,107,'3-105',91);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (209,108,'3-105',78);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (2010,101,'6-166',85);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (2011,107,'6-106',79);
      INSERT INTO score(s_no,s_id,c_id,degree)VALUES (2012,108,'6-166',81);
      //--------------------------------------
      INSERT INTO teacher(t_id,t_name,t_sex,t_birthday,prof,depart) 
      VALUES (804,'李诚','男','1958-12-02','副教授','计算机系');
      INSERT INTO teacher(t_id,t_name,t_sex,t_birthday,prof,depart) 
      VALUES (856,'张旭','男','1969-03-12','讲师','电子工程系');
      INSERT INTO teacher(t_id,t_name,t_sex,t_birthday,prof,depart)
      VALUES (825,'王萍','女','1972-05-05','助教','计算机系');
      INSERT INTO teacher(t_id,t_name,t_sex,t_birthday,prof,depart) 
      VALUES (831,'刘冰','女','1977-08-14','助教','电子工程系');




































