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


### 二、练习

* 1、 查询student表中的所有记录的s_name s_sex和s_class列。

	  select s_name,s_sex,s_class from student;

* 2、 查询教师所有的单位即不重复的depart列。

	  select depart from teacher group by depart;
	  select distinct depart from teacher;
	  
	 ------------------------------ 
	  
	  select depart from teacher group by depart having depart='计算机系';
	  select distinct(depart) from teacher where depart='计算机系';

* 3、 查询student表的所有记录。



* 4、 查询score表中成绩在60到80之间的所有记录。



* 5、 查询score表中成绩为85，86或88的记录。



* 6、 查询student表中“95031”班或性别为“女”的同学记录。



* 7、 以s_class降序查询student表的所有记录。



* 8、 以c_id升序、degree降序查询score表的所有记录。



* 9、 查询“95031”班的学生人数。



* 10、查询score表中的最高分的学生学号和课程号。



* 11、查询‘3-105’号课程的平均分。



* 12、查询score表中至少有5名学生选修的并以3开头的课程的平均分数。



* 13、查询最低分大于70，最高分小于90的s_id列。



* 14、查询所有学生的s_name、c_id和degree列。



* 15、查询所有学生的s_id、c_name和degree列。



* 16、查询所有学生的s_name、c_name和degree列。



* 17、查询“95033”班所选课程的平均分。



* 18、假设使用如下命令建立了一个grade表：

      create table grade(low   int(3),
                  upp   int(3),
                  rank   varchar(50));
      insert into grade values(90,100,’A’);
      insert into grade values(80,89,’B’);
      insert into grade values(70,79,’C’);
      insert into grade values(60,69,’D’);
      insert into grade values(0,59,’E’);
      commit;

     现查询所有同学的s_id、c_id和rank列。


* 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。



* 20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。



* 22、查询和学号为108的同学同年出生的所有学生的s_id、s_name和s_birthday列。
	


* 23、查询“张旭“教师任课的学生成绩。



* 24、查询选修某课程的同学人数多于5人的教师姓名。
	


* 25、查询95033班和95031班全体学生的记录。
	


* 26、查询存在有85分以上成绩的课程c_id.



* 27、查询出“计算机系“教师所教课程的成绩表。
	


* 28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
	


* 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的c_id、s_id和Degree,并按Degree从高到低次序排序。



* 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的c_id、s_id和Degree.



* 31、查询所有教师和同学的name、sex和birthday.



* 32、查询所有“女”教师和“女”同学的name、sex和birthday.


* 33、查询成绩比该课程平均成绩低的同学的成绩表。



* 34、查询所有任课教师的t_name和Depart.



* 35  查询所有未讲课的教师的t_name和Depart. 



* 36、查询至少有2名男生的班号。
	


* 37、查询Student表中不姓“王”的同学记录。



* 38、查询Student表中每个学生的姓名和年龄。



* 39、查询Student表中最大和最小的s_birthday日期值。



* 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。



* 41、查询“男”教师及其所上的课程。



* 42、查询最高分同学的s_id、c_id和Degree列。



* 43、查询和“李军”同性别的所有同学的s_name.



* 44、查询和“李军”同性别并同班的同学s_name.



* 45、查询所有选修“计算机导论”课程的“男”同学的成绩表

































