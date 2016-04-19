1.读写分离（读一个数据库，写一个数据库）
2.垂直分割（不同数据库运行不同的业务）
3.水平分割（一个数据库保存部分用户信息）
4.虚拟化存储（存在有的访问量大［存在负载均衡］让存储统一管理）
5.web缓存分割（增加存储频繁访问内容的数据库副本，减少io操作
6.存储cache缓存分割（使用多层缓存机制，数据库写入到缓存中交互完成，制作多个cache镜像，保证数据安全性）
-- merge into using使用
merge into employment a using(
select 1 as id, 500 as salary from dual
) b on ( a.employee_id= b.id)
when matched then
  update set a.maxsalary=b.salary where 1=1;
when Not MATCHED then
  insert(employee_id,maxsalary) values(b.id,b.salary);
--查看sql执行计划
  explain plan for select * from bms_project;
   select * from table(dbms_xplan.display);
--oracle查询连接方式
 inner join --内连接 （两表都有关联的数据）
 left join --左外连接 （以左边表为主，查询所有左表数据）
 right join --右外连接
 full outer join  --全外连接
 cross join --交叉连接 （左表每个元素对应右表每个元素）
 --oracle修改字段语句
 alter table tableName modify (columnNmae varchar(10) default '1');--修改列的类型
 alter table tableName add (columnName varchar(19) default '0');--增加列
 alter table tableName drop (columnName);--删除列
 alter table tableName rename column oldNmae to newName;--修改列名
 ALTER TABLE oldTableName RENAME TO newTableName;--修改表名
 alter table tableName add constraint columnName primary key(主键名);
 rename oldTablename to newTableName;--修改表名
 --通过闪回查询到对应时间删除的数据并创建一张表保存
 create table bms_set_of_books_relation1 as ;
select * from  bms_set_of_books_relation  as 
of timestamp to_timestamp('2016-04-18 09:45:00','yyyy-mm-dd hh24:mi:ss');
 