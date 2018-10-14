# SQL练习

    /*
    MySQL Data Transfer
    Source Host: localhost
    Source Database: test
    Target Host: localhost
    Target Database: test
    Date: 2018/10/14 22:10:46
    */

    SET FOREIGN_KEY_CHECKS=0;
    -- ----------------------------
    -- Table structure for j
    -- ----------------------------
    CREATE TABLE `j` (
      `jno` varchar(11) NOT NULL,
      `jname` varchar(20) DEFAULT NULL,
      `city` varchar(20) DEFAULT NULL,
      PRIMARY KEY (`jno`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Table structure for p
    -- ----------------------------
    CREATE TABLE `p` (
      `pno` varchar(11) NOT NULL,
      `pname` varchar(20) DEFAULT NULL,
      `color` varchar(10) DEFAULT NULL,
      `weight` varchar(10) DEFAULT NULL,
      PRIMARY KEY (`pno`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Table structure for s
    -- ----------------------------
    CREATE TABLE `s` (
      `sno` varchar(11) NOT NULL,
      `sname` varchar(20) DEFAULT NULL,
      `status` varchar(5) DEFAULT NULL,
      `city` varchar(50) DEFAULT NULL,
      PRIMARY KEY (`sno`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Table structure for spj
    -- ----------------------------
    CREATE TABLE `spj` (
      `sno` varchar(11) DEFAULT NULL,
      `pno` varchar(11) DEFAULT NULL,
      `jno` varchar(11) DEFAULT NULL,
      `qty` int(10) DEFAULT NULL
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Records 
    -- ----------------------------
    INSERT INTO `j` VALUES ('j1', '三建', '北京');
    INSERT INTO `j` VALUES ('j2', '一汽', '长春');
    INSERT INTO `j` VALUES ('j3', '弹簧厂', '天津');
    INSERT INTO `j` VALUES ('j4', '造船厂', '天津');
    INSERT INTO `j` VALUES ('j5', '机车厂', '唐山');
    INSERT INTO `j` VALUES ('j6', '无线电厂', '常州');
    INSERT INTO `j` VALUES ('j7', '半导体厂', '南京');
    INSERT INTO `p` VALUES ('p1', '螺母', '红', '12');
    INSERT INTO `p` VALUES ('p2', '螺栓', '绿', '17');
    INSERT INTO `p` VALUES ('p3', '螺丝刀', '蓝', '14');
    INSERT INTO `p` VALUES ('p4', '螺丝刀', '红', '14');
    INSERT INTO `p` VALUES ('p5', '凸轮', '蓝', '40');
    INSERT INTO `p` VALUES ('p6', '齿轮', '红', '30');
    INSERT INTO `s` VALUES ('s1', '精益', '20', '天津');
    INSERT INTO `s` VALUES ('s2', '盛锡', '10', '北京');
    INSERT INTO `s` VALUES ('s3', '东方红', '30', '北京');
    INSERT INTO `s` VALUES ('s4', '丰泰盛', '20', '天津');
    INSERT INTO `s` VALUES ('s5', '为民', '30', '上海');
    INSERT INTO `spj` VALUES ('s1', 'p1', 'j1', '200');
    INSERT INTO `spj` VALUES ('s1', 'p1', 'j3', '100');
    INSERT INTO `spj` VALUES ('s1', 'p1', 'j4', '700');
    INSERT INTO `spj` VALUES ('s1', 'p2', 'j2', '100');
    INSERT INTO `spj` VALUES ('s2', 'p3', 'j1', '400');
    INSERT INTO `spj` VALUES ('s2', 'p3', 'j2', '200');
    INSERT INTO `spj` VALUES ('s2', 'p3', 'j4', '500');
    INSERT INTO `spj` VALUES ('s2', 'p3', 'j5', '400');
    INSERT INTO `spj` VALUES ('s2', 'p5', 'j1', '400');
    INSERT INTO `spj` VALUES ('s2', 'p5', 'j2', '100');
    INSERT INTO `spj` VALUES ('s3', 'p1', 'j1', '200');
    INSERT INTO `spj` VALUES ('s3', 'p3', 'j1', '200');
    INSERT INTO `spj` VALUES ('s4', 'p5', 'j1', '100');
    INSERT INTO `spj` VALUES ('s4', 'p6', 'j3', '300');
    INSERT INTO `spj` VALUES ('s4', 'p6', 'j4', '200');
    INSERT INTO `spj` VALUES ('s5', 'p2', 'j4', '100');
    INSERT INTO `spj` VALUES ('s5', 'p3', 'j1', '200');
    INSERT INTO `spj` VALUES ('s5', 'p6', 'j2', '200');
    INSERT INTO `spj` VALUES ('s5', 'p6', 'j4', '500');


（1）求供应工程 J1 零件的供应商号码 SNO :

    select distinct sno from spj where jno = 'j1'

（2）求供应工程 J1 零件 P1 的供应商号码 SNO

    select distinct sno from spj where jno = 'j1' and pno = 'p1'

（3）求供应工程 J1 零件为红色的供应商号码 SNO :

    select distinct sno from spj where jno = 'j1' and pno in (select pno from p where color = '红')

（4）求没有使用天津供应商生产的红色零件的工程号 JNO :

    select distinct jno from spj where jno not in (select jno from spj,p,s where s.city = '天津' 
                                      and color = '红' and spj.sno = s.sno and p.pno = spj.pno)

（5）求至少用了供应商 S1 所供应的全部零件的工程号 JNO :

    select distinct pno from spj where sno = 's1'
    
    select jno from spj where pno = 'p1' and jno in (select jno from spj where pno = 'p2')

----------------------------

(1) 找出所有供应商的姓名和所在城市。

    select sname,city from s

(2) 找出所有零件的名称、颜色、重量。

    select pname,color,weight from p

(3) 找出使用供应商 S1 所供应零件的工程号码。

    select distinct jno from spj where sno = 's1'

(4) 找出工程项目 J2 使用的各种零件的名称及其数量。

    select pname,qty from p,spj where spj.jno = 'j2' and spj.pno = p.pno

(5) 找出上海厂商供应的所有零件号码。

    select pno from spj where sno in (select sno from s where city = '上海')

(6) 找出使用上海产的零件的工程名称。

    select jname from j where jno in (select jno from spj where sno in (select sno from s where city = '上海'))

select distinct jname from spj,s,j where s.sno = spj.sno and j.jno = spj.jno and s.city = '上海'

(7) 找出没有使用天津产的零件的工程号码。

    select jno from spj where jno not in (select jno from spj where sno in (select sno from s where city = '天津'))

select jno from spj where jno not in (select jno from spj,s where s.sno = spj.sno and s.city ='天津')

(8) 把全部红色零件的颜色改成蓝色。

    update p set color = '蓝' where color = '红'

(9) 由 S5 供给 J4 的零件 P6 改为由 S3 供应。

    update spj set sno = 's3' where sno = 's5' and pno = 'p6' and jno = 'j4'

(10) 从供应商关系中删除供应商号是 S2 的记录,并从供应情况关系中删除相应的记录。

    1>delete from s where sno = 's2'

	2>delete from spj where sno = 's2'

(11) 请将 (S2 , J6 , P4 , 200) 插入供应情况关系。

    insert into spj (sno,pno,jno,qty) values ('s2','j6','p4',200)
