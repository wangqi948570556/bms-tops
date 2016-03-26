-- merge into using使用
merge into employment a using(
select 1 as id, 500 as salary from dual
) b on ( a.employee_id= b.id)
when matched then
  update set a.maxsalary=b.salary
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
 cross join --交叉连接