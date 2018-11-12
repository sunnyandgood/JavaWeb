# sqlserver中将varchar类型转换为int型

```sql
select * from TableName order by cast(colName as int); 
 
select * from TableName order by convert(int,colName);
```
