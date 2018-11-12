SQL小知识

## sqlserver中将varchar类型转换为int型
```sql
select * from TableName order by cast(colName as int); 
 
select * from TableName order by convert(int,colName);
```

## select语句中1/0与男/女的转换
```sql
SELECT *,CASE Ssex WHEN '男' THEN '0' ELSE '1' END AS sex FROM student
```
