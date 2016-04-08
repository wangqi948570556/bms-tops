1.触发器类型：
1)DML触发器 (ORACLE可以在DML语句进行触发，可以在DML操作前或操作后进行触发，并且可以对每个行或语句操作上进行触发)
2)替代触发器 (由于在ORACLE里，不能直接对由两个以上的表建立的视图进行操作。所以给出了替代触发器。它就是ORACLE 8专门为进行视图操作的一种处理方法)
3)系统触发器 (ORACLE 8i 提供了第三种类型的触发器叫系统触发器。它可以在ORACLE数据库系统的事件中进行触发，如ORACLE系统的启动与关闭等)

2.触发器组成:
1)触发事件：引起触发器被触发的事件。 例如：DML语句(INSERT, UPDATE, DELETE语句对表或视图执行数据处理操作)、DDL语句（如CREATE、ALTER、DROP语句在数据库中创建、修改、删除模式对象）、数据库系统事件（如系统启动或退出、异常错误）、用户事件（如登录或退出数据库）。
2)触发时间：即该TRIGGER 是在触发事件发生之前（BEFORE）还是之后(AFTER)触发，也就是触发事件和该TRIGGER 的操作顺序。
3)触发操作：即该TRIGGER 被触发之后的目的和意图，正是触发器本身要做的事情。 例如：PL/SQL 块。
4)触发对象：包括表、视图、模式、数据库。只有在这些对象上发生了符合触发条件的触发事件，才会执行触发操作。
5)触发条件：由WHEN子句指定一个逻辑表达式。只有当该表达式的值为TRUE时，遇到触发事件才会自动执行触发器，使其执行触发操作。
6)触发频率：说明触发器内定义的动作被执行的次数。即语句级(STATEMENT)触发器和行级(ROW)触发器。
触发器级别
语句级(STATEMENT)触发器：是指当某触发事件发生时，该触发器只执行一次；
行级(ROW)触发器：是指当某触发事件发生时，对受到该操作影响的每一行数据，触发器都单独执行一次。
3.注意
触发器不接受参数。
1)一个表上最多可有12个触发器，但同一时间、同一事件、同一类型的触发器只能有一个。并各触发器之间不能有矛盾。
2)在一个表上的触发器越多，对在该表上的DML操作的性能影响就越大。
3)触发器最大为32KB。若确实需要，可以先建立过程，然后在触发器中用CALL语句进行调用。
4)在触发器的执行部分只能用DML语句（SELECT、INSERT、UPDATE、DELETE），不能使用DDL语句（CREATE、ALTER、DROP）。
5)触发器中不能包含事务控制语句(COMMIT，ROLLBACK，SAVEPOINT)。因为触发器是触发语句的一部分，触发语句被提交、回退时，触发器也被提交、回退了。
6)在触发器主体中调用的任何过程、函数，都不能使用事务控制语句。
7)在触发器主体中不能申明任何Long和blob变量。新值new和旧值old也不能是表中的任何long和blob列。
8)不同类型的触发器(如DML触发器、INSTEAD OF触发器、系统触发器)的语法格式和作用有较大区别。

CREATE [OR REPLACE] TRIGGER trigger_name
{BEFORE | AFTER }   --before前触发器 after后触发器
{INSERT | DELETE | UPDATE [OF column [, column …]]}
[OR {INSERT | DELETE | UPDATE [OF column [, column …]]}...]
ON [schema.]table_name | [schema.]view_name 
[REFERENCING {OLD [AS] old | NEW [AS] new| PARENT as parent}]  -- referencing 子句说明相关名称
[FOR EACH ROW ] --for each row 行级触发器  for each statement 语句级触发器
[WHEN condition] -- condition 条件
PL/SQL_BLOCK | CALL procedure_name; --调用存储过程

4.每张表最多可建12个触发器 为：
BEFORE INSERT
BEFORE INSERT FOR EACH ROW
AFTER INSERT
AFTER INSERT FOR EACH ROW

BEFORE UPDATE
BEFORE UPDATE FOR EACH ROW
AFTER UPDATE
AFTER UPDATE FOR EACH ROW
 
BEFORE DELETE
BEFORE DELETE FOR EACH ROW
AFTER DELETE
AFTER DELETE FOR EACH ROW
 
案例
CREATE TABLE EMPLOYMENT
(
  EMPLOYEE_ID NUMBER, --员工ID
  MAXSALARY   NUMBER --工资上限
)
插入两条记录
Insert into employment values(1, 1000);
Insert into employment values(2, 2000);
CREATE OR REPLACE TRIGGER salary_raiu
AFTER INSERT OR UPDATE ON maxsalary
FOR EACH ROW
WHEN ( NEW.amount >= 1000 AND (old.amount IS NULL OR OLD.amount <= 500))
DECLARE
 v_maxsalary NUMBER;
BEGIN
 SELECT maxsalary
  INTO v_maxsalary
  FROM employment
  WHERE employee_id = :NEW.employee_id;
 IF :NEW.amount > v_maxsalary THEN
  raise_application_error(-20000, '工资超限');
 END IF;
END;
 
 
 
 
 
 