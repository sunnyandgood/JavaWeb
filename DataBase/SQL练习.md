# SQL练习

### 一、建表语句及数据

* 建表

		SET FOREIGN_KEY_CHECKS=0;
		-- ----------------------------
		-- Table structure for coures
		-- ----------------------------
		CREATE TABLE `coures` (
		  `c_id` varchar(50) NOT NULL,
		  `c_name` varchar(100) default NULL,
		  `t_id` varchar(100) default NULL,
		  PRIMARY KEY  (`c_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

		-- ----------------------------
		-- Table structure for score
		-- ----------------------------
		CREATE TABLE `score` (
		  `s_no` varchar(50) NOT NULL,
		  `s_id` varchar(30) default NULL,
		  `c_id` varchar(50) default NULL,
		  `degree` int(10) default NULL,
		  PRIMARY KEY  (`s_no`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

		-- ----------------------------
		-- Table structure for student
		-- ----------------------------
		CREATE TABLE `student` (
		  `s_id` varchar(50) NOT NULL,
		  `s_name` varchar(100) default NULL,
		  `s_sex` varchar(50) default NULL,
		  `s_birthday` datetime default NULL,
		  `s_class` varchar(50) default NULL,
		  PRIMARY KEY  (`s_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

		-- ----------------------------
		-- Table structure for teacher
		-- ----------------------------
		CREATE TABLE `teacher` (
		  `t_id` varchar(30) NOT NULL,
		  `t_name` varchar(40) default NULL,
		  `t_sex` varchar(20) default NULL,
		  `t_birthday` datetime default NULL,
		  `prof` varchar(60) default NULL,
		  `depart` varchar(100) default NULL,
		  PRIMARY KEY  (`t_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;



* 数据

		-- ----------------------------
		-- Records 
		-- ----------------------------
		INSERT INTO `coures` VALUES ('3-105', '计算机导论', '825');
		INSERT INTO `coures` VALUES ('3-245', '操作系统', '804');
		INSERT INTO `coures` VALUES ('6-166', '数据电路', '856');
		INSERT INTO `coures` VALUES ('9-888', '高等数学', '100');
		INSERT INTO `score` VALUES ('201', '103', '3-245', '86');
		INSERT INTO `score` VALUES ('2010', '101', '6-166', '85');
		INSERT INTO `score` VALUES ('2011', '107', '6-106', '79');
		INSERT INTO `score` VALUES ('2012', '108', '6-166', '81');
		INSERT INTO `score` VALUES ('202', '105', '3-245', '75');
		INSERT INTO `score` VALUES ('203', '109', '3-245', '68');
		INSERT INTO `score` VALUES ('204', '103', '3-105', '92');
		INSERT INTO `score` VALUES ('205', '105', '3-105', '88');
		INSERT INTO `score` VALUES ('206', '109', '3-105', '76');
		INSERT INTO `score` VALUES ('207', '101', '3-105', '64');
		INSERT INTO `score` VALUES ('208', '107', '3-105', '91');
		INSERT INTO `score` VALUES ('209', '108', '3-105', '78');
		INSERT INTO `student` VALUES ('101', '李军', '男', '1976-02-20 00:00:00', '95033');
		INSERT INTO `student` VALUES ('103', '陆君', '男', '1974-06-03 00:00:00', '95031');
		INSERT INTO `student` VALUES ('105', '匡明', '男', '1975-10-02 00:00:00', '95031');
		INSERT INTO `student` VALUES ('107', '王丽', '女', '1976-01-23 00:00:00', '95033');
		INSERT INTO `student` VALUES ('108', '曾华', '男', '1977-09-01 00:00:00', '95033');
		INSERT INTO `student` VALUES ('109', '王芳', '女', '1975-02-10 00:00:00', '95031');
		INSERT INTO `teacher` VALUES ('804', '李诚', '男', '1958-12-02 00:00:00', '副教授', '计算机系');
		INSERT INTO `teacher` VALUES ('825', '王萍', '女', '1972-05-05 00:00:00', '助教', '计算机系');
		INSERT INTO `teacher` VALUES ('831', '刘冰', '女', '1977-08-14 00:00:00', '助教', '电子工程系');
		INSERT INTO `teacher` VALUES ('856', '张旭', '男', '1969-03-12 00:00:00', '讲师', '电子工程系');


### 二、练习

* 1、 查询student表中的所有记录的s_name s_sex和s_class列。

	  select s_name,s_sex,s_class from student;

* 2、 查询教师所有的单位即不重复的depart列。

	  select depart from teacher group by depart;
	  select distinct depart from teacher;  //( distinct 与 group by depart 有什么区别)
	  
	 ------------------------------ 
	  
	  select depart from teacher group by depart having depart='计算机系';
	  select distinct(depart) from teacher where depart='计算机系';

* 3、 查询student表的所有记录。

	  select * from student;

* 4、 查询score表中成绩在60到80之间的所有记录。

	  select * from score where degree between 60 and 80;
	  select * from score where degree > 60 and degree < 80;

* 5、 查询score表中成绩为85，86或88的记录。

	  select * from score where degree in (85,86,88);
	  select * from score where degree = 85 or degree = 86 or degree = 88;

* 6、 查询student表中“95031”班或性别为“女”的同学记录。

	  select * from student where s_sex = '女' or s_class = '95031';

* 7、 以s_class降序查询student表的所有记录。

	  select * from student order by s_class desc;

* 8、 以c_id升序、degree降序查询score表的所有记录。

	  select * from score order by c_id asc;
	  
	  select * from score order by degree desc;

* 9、 查询“95031”班的学生人数。

	  select count(*) from student where s_class = '95031';
	  select sum(s_class = '95031') from student;

* 10、查询score表中的最高分的学生学号和课程号。

	  select s_id,c_id from score where degree = (select max(degree) from score);

* 11、查询‘3-105’号课程的平均分。

	  select avg(degree) from score where c_id = '3-105';

* 12、查询score表中至少有5名学生选修的并以3开头的课程的平均分数。

	  select avg(degree) from score where c_id like '3%' group by c_id having count(c_id) > 4;
	  select avg(degree) from score group by c_id having count(c_id)>=5 and c_id like '3%';

* 13、查询最低分大于70，最高分小于90的s_id列。

	  select s_id from score where degree > 70 and degree < 90;
	  select s_id from score where degree between 70 and 90;

* 14、查询所有学生的s_name、c_id和degree列。

	  select s_name,c_id,degree from student stu,score sco where stu.s_id = sco.s_id;

* 15、查询所有学生的s_id、c_name和degree列。

	  select s_id,c_name,degree from score sco,coures cou where sco.c_id = cou.c_id;

* 16、查询所有学生的s_name、c_name和degree列。

	  select s_name,c_name,degree from student,coures,score where 
	  			student.s_id = score.s_id and score.c_id = coures.c_id;
	  select s_name,c_name,degree from student join score on student.s_id = score.s_id 
	  					join coures on score.c_id = coures.c_id;			

* 17、查询“95033”班所选课程的平均分。

	  select avg(degree) from score where s_id in (select s_id from student where s_class = '95033');

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

































