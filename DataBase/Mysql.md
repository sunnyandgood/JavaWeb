# Mysql

* 注：所有操作都必须在英文状态下

### 一、查询

* 1、全查

  * 语句：

        select * from yingXiong

  * 理解：
  
        select表示查询
        *表示默认缺省(全部字段)
        from表示来自
        yingXiong表示表名称
        注意：select from在数据库查询中都为蓝色字体，表示当前为数据库关键字(保留字)
        注意：每一个单词之间只用空格进行分离
        
   * 结构：
   
         select 字段 from 表名称

* 2、按字段查询

  * 语句：
  
        select p_id,p_name from yingXiong
        
  * 理解：
  
        p_id/p_name表示要查询的字段
        注意：以字段查询时可以单一字段也可以多个字段
        注意：以多个字段内进行查询时，字段与字段之间用逗号(,)间隔

* 3、按条件查询

  * 语句：
  
        select * from yingXiong where p_sex='女'

  * 理解：
  
        where关键字表示条件
        p_sex=’值’
        注意：字段必须是当前表中存在的字段，值必须是当前字段存在的值，当值不存在时查询结果为空
        注意：如果SQL语句中存在条件关键字(where)则必须给条件
        注意：对于字符串来说，必须加单引号(‘’),对于数字来说可以不加，但推荐加单引号

* 4、运算符查询

      语句同条件查询  < > <= >= <>（！=）

* 5、命名别名

  * 语句：
  
        select p_age as p_age1 from yingXiong

  * 理解：
  
        作用：将查询的字段p_age命名为p_age1
        关键字as表示命名
        注意：as可以省略

* 6、多条件查询

  * 语句：（and）
  
        select * from yingXiong where p_age='23' and p_weizhi='打野'

  * 理解：
  
        作用：查询到同时满足p_age=’23’ 和 p_weizhi=’打野’条件的数据
        关键字：and表示和(与)，两边同时成立
        
  * 语句：（or）
  
        select * from yingXiong where p_age='23' or p_weizhi='打野'


  * 理解：
  
        作用：查询满足p_age=’23’ 或 p_weizhi=’打野’条件的数据
        关键字：or表示或，两边只要有一个满足就可以

* 7、以集合方式查询

  * 语句：

        select * from yingXiong where p_age in (23,34)

  * 理解：
  
        作用：将p_age的值为23或者34的数据取出来
        关键字：in表示集合，in后面跟小括号()，在括号中填入集合元素
        注意：在小括号的元素中，每一个元素需要用逗号(,)隔开
        相当于：select * from yingXiong where p_age='23' or p_age = '34'

* 8、以区间方式查询
  
  * 语句：
  
        select * from yingXiong where p_age between ‘18’ and ‘40’
  
  * 理解：
  
        作用：查询p_age值在18到40之间数据，包含18和40
        关键字：between...and...表示在...和...之间，包含...
        注意：and关键字前为小，后为大
        相当于：select * from yingXiong where p_age>='18' and p_age<='40'

* 9、以主键做单一查询

      select * from yingXiong where p_id='p001'

* 10、模糊查询

  * 语句：
  
        select * from yingXiong where p_name like '%啊%'

  * 理解：
  
        作用：查询p_name值中含有啊的数据
        关键字：like表示模糊，后面跟要模糊的值
        注意：如果将要虎摸的值中去掉%，则当前like相当于=
        注意：如果去掉要模糊的值前面的%，则结果为以“啊”开头的数据，如果去掉要模糊的值后面的%，则结果为以“啊”结尾的数据
                
* 11、分页查询

  * 语句：

        select * from yingXiong limit 0,3
  
  * 理解：

        作用：查询三条数据，从第一条开始
        关键字：limit表示分页，后面跟数字，如果为两个数字，则用逗号隔开，第一个数字表示从第几条开始查，
                  第二个数字表示要查询的条数，如果为一个数字，则表示从第一条开始查询，条数为指定数字
        注意：当前语句中的数字不能加单引号
        注意：分页查询时，第一条数据序号为0

* 12、排序查询

  * 语句：

        select * from yingXiong order by p_age

  * 理解：
  
        作用：将查询到的结果以p_age的值进行排序，默认为升序
        关键字：order by 表示以什么（哪一个字段）进行排序，order by后跟字段
        升序：asc（与默认方式相同）
        降序：desc
        
* 13、子条件查询

  * 语句：

        select * from yingXiong where p_id=(select p_leader from yingXiong where p_name='蛮王')
  
  * 理解：
  
        作用：查询蛮王的大哥的全部信息
        注意：小括号中包裹的为子语句，将子语句的结果作为主语句的条件值做查询
        注意：当前主语句条件为=，则子语句查询到的结果必须为一个
        如果子语句查询到的结果为多行，则主语句的条件应该为集合（in）
        
* 14、空值查询方式

  
  * 1、没有的空：`select * from yingxiong where p_sex=’’`
  
  * 2、值为null：`select * from yingxiong where p_sex=’null’`
  
  * 3、默认为空(Null)：`select * from yingxiong where p_age is null`

//--------------------聚合函数开始------------------------------------


* 15、求平均值

  * 语句：
  
        select avg(p_age) avg_pAge from yingxiong

  * 理解：
  
        avg关键字表示平均，后面跟小括号，里面为要平均的字段
        注意：avg只能对数字进行求平均值，与类型无关
        注意：在求平均值时，如果字段值含有不为数字的字符，则从遇到第一个不是数字的字符开始不记算

* 16、求和

  * 语句：
  
        select sum(p_leader)  from yingxiong

  * 理解：
  
        Sum关键字表示求和后面跟小括号，小括号中为要求和的字段


* 17、求最大值

  * 语句：
  
        select max(p_leader)  from yingxiong

  * 理解：
  
        max关键字表示求最大值，后面跟小括号，小括号中为要求最大值的字段

* 18、求最小值

  * 语句：
  
        select min(p_leader)  from yingxiong

  * 理解：
  
        min关键字表示求最小值，后面跟小括号，小括号中为要求和的字段

* 19、求总数

  * 语句：
  
        select count(p_leader)  from yingxiong

  * 理解：
  
        count关键字表示求总数，后面跟小括号，小括号中为要求总数的字段

//-------------------聚合函数结束--------------------------

* 20、分组函数

  * 语句：
  
        select p_sex from yingxiong group by p_sex

  * 理解：
  
        关键字：group by表示通过什么来分组，后面跟要分组的字段

* 21、分组函数加条件

  * 语句：
  
        select p_weizhi from yingxiong group by p_weizhi having p_weizhi != '上单'

  * 理解：
  
        注意：分组函数专用条件关键字having
        注意：having和where的区别，having从查询的字段中进行筛选，where从表中进行筛选
        
* 22、多表联合查询

  * 语句：
  
        select * from yingxiong yx,wanjia wj where yx.w_id=wj.w_id

  * 理解：
  
        注意：当有多张表是。表与表之间用逗号间隔
        注意：多表联合查询需要条件过滤，如果不进行过滤，则得到的数据为两表数据的乘积，此种方式称之为笛卡尔乘积；
        条件过滤的方式：一表中的字段 条件 另一表中的字段

* 23、左连接查询

  * 语句：
  
        select * from yingxiong yx left join wanjia wj on yx.w_id =wj.w_id

  * 理解：
  
        关键字：left join... on ...,left join表示左连接，on表示条件
        结果：以左表数据为准（数据全要），右表数据匹配，如有未匹配项，则以空填充

* 24、右连接查询

  * 语句：
  
        select * from yingxiong yx right join wanjia wj on yx.w_id =wj.w_id;
        
  * 理解：
  
        关键字：right join... on ...,right join表示右连接，on表示条件
        结果：以右表数据为准（数据全要），左表数据匹配，如有未匹配项，则以空填充
        
* 25、内连接查询

  * 语句：
  
        select * from yingxiong yx inner join wanjia wj on yx.w_id =wj.w_id;

  * 理解：
  
        关键字：inner join... on ...,inner join表示内连接，on表示条件
        结果：以两表数据为准，互相匹配，如有未匹配项，则摒弃
        注意：on为两表联查的专用条件关键字

### 二、新增

* 语句：

      insert into wanjia (w_id,w_name,w_sex,w_like) values ('w008','秦奋','男','打野')

* 理解：

      效果：在wanjia表中插入一条新数据
      框架：insert into 表名称 (字段1，字段2，...) values (‘字段1的值’,’字段2的值’...)
      注意：字段和值的位置和数量必须一致
      注意：不允许为空的字段新增时必须指定值

### 三、修改（更新）

* 语句：

      update wanjia set w_name='萧炎',w_sex='男' where w_id='w010'

* 理解：

      效果：将指定的一条数据修改为想要的结果
      框架：update 表名称 set 字段1=’值’,字段2=’值’... where 主键=’值’
      注意：修改语句必须使用条件，如果不使用条件则结果为整张表的数据被修改

### 四、删除

* 语句：

      delete from wanjia where w_id='w010'

* 理解：

      效果：删除指定数据
      框架：delete from 表名称 where 主键=’值’
      注意：删除语句必须使用条件，强烈建议使用主键进行删除

### 五、创建视图

* 语句：

      create view view3 as select * from yingXiong

* 理解：

      Create表示创建 	view表示视图	view3表示视图名称

### 六、创建存储过程

* 语句：

    DELIMITER ;;
    CREATE PROCEDURE `pro1`(out shu int)
    begin
      select count(*) into shu from yingXiong;
    end;;
    DELIMITER ;

* 理解：

      DELIMITER定义结束标志
      PROCEDURE 表示存储过程
      pro1当前存储过程的名称
      begin表示存储过程开始
      end表示存储过程结束
      out shu int		out表示输出，shu表示变量名称，int表示变量类型
       into shu 		into表示将当前值赋值给后面跟的变量
      Shu在参数位置定义的变量
      存储过程的调用：
      call pro1(@shu);
      select @shu;
      注意：存储过程传递变量时需要加上@

### 七、外键

* set null当主表数据发生删除或者修改主键时，从表外键设置为默认空

* Cascade级联，当删除主表数据时，从表外键值为当前数据的主键的数据一起删除，修改主表主键时，从表原来引用当前主键的数据全部一起修改为当前主表主键值

* No action没有动作，主表数据改变不影响从表数据

* Restrict 限制,约束,制约，当从表中有主表的主键引用，则主表数据不能删除或修改














