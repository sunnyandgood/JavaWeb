# DDl、DML、DCL、DQL

* DDL 数据库模式定义语言 create

* DML 数据库操控语言 insert update等等

* DCL 数据库控制语言 grant remove等等

* DQL 数据库查询语言 query 等等

### 一、DDL（data definition language）数据库模式定义语言：

* 数据定义语言，用于定义和管理 SQL 数据库中的所有对象的语言。 

* DDL主要是用在定义或改变表（TABLE）的结构，数据类型，表之间的链接和约束等初始化工作上，他们大多在建立表时使用。

    * 1、CREATE - to create objects in the database   创建 

    * 2、ALTER - alters the structure of the database   修改 

    * 3、DROP - delete objects from the database   删除 

    * 4、TRUNCATE - 删除表中的所有记录，包括删除记录所分配的所有空间

      >eg:

           TRUNCATE TABLE [Table Name]。 

    * 5、COMMENT - add comments to the data dictionary 注释 

    * 6、GRANT - gives user's access privileges to database 授权 

    * 7、REVOKE - withdraw access privileges given with the GRANT command   收回已经授予的权限

### 二、DML（data manipulation language） 数据库操控语言：

* 数据操作语言，SQL中处理数据等操作统称为数据操纵语言 

* 它们是SELECT、UPDATE、INSERT、DELETE，就象它的名字一样，这4条命令是用来对数据库里的数据进行操作的语言。

    * 1、SELECT - retrieve data from the a database   查询 

    * 2、INSERT - insert data into a table  添加 

    * 3、UPDATE - updates existing data within a table  更新 

    * 4、DELETE - deletes all records from a table, the space for the records remain  删除 

    * 5、CALL - 调用PL/SQL或Java子程序

    * 6、EXPLAIN PLAN - 解释数据访问路径

      * Oracle RDBMS执行每一条SQL语句，都必须经过Oracle优化器的评估。所以，了解优化器是如何选择(搜索)路径以及索引是如何被使用的，对优化SQL语句有很大的帮助。Explain可以用来迅速方便地查出对于给定SQL语句中的查询数据是如何得到的即搜索路径(我们通常称为Access Path)。从而使我们选择最优的查询方式达到最大的优化效果。 

    * 7、LOCK TABLE - control concurrency 锁，用于控制并发

### 三、DCL（Data Control Language）数据库控制语言：

* 数据控制语言，用来授予或回收访问数据库的某种特权，并控制数据库操纵事务发生的时间及效果，对数据库实行监视等。

* 是数据库控制功能。是用来设置或更改数据库用户或角色权限的语句，包括（grant,deny,revoke等）语句。在默认状态下，只有 sysadmin,dbcreator,db_owner或db_securityadmin等人员才有权力执行DCL 

    * 1、COMMIT - save work done 提交 

    * 2、SAVEPOINT - identify a point in a transaction to which you can later roll back 保存点 

    * 3、ROLLBACK - restore database to original since the last COMMIT   回滚 

    * 4、SET TRANSACTION - Change transaction options like what rollback segment to use  设置当前事务的特性，它对后面的事务没有影响


### 四、DQL（Data Query Language SELECT ）数据查询语言：`select语句`。

* select具体用法

      SELECT select_list
      [ INTO new_table ]
      FROM table_source
      [ WHERE search_condition ]
      [ GROUP BY group_by_expression ]
      [ HAVING search_condition ]
      [ ORDER BY order_expression [ ASC | DESC ] ]

* 数据查询语言DQL基本结构是由 SELECT 子句，FROM 子句，WHERE 子句组成的查询块：

      SELECT <字段名表>
      FROM <表或视图名>
      WHERE <查询条件>



















