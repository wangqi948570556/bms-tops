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