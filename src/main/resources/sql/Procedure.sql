oracle 存储过程的基本语法
1.基本结构 
CREATE OR REPLACE PROCEDURE 存储过程名字
(
    参数1 IN NUMBER,
    参数2 IN NUMBER
) IS
变量1 INTEGER :=0;
变量2 DATE;
BEGIN

END 存储过程名字

2.SELECT INTO STATEMENT
  将select查询的结果存入到变量中，可以同时将多个列存储多个变量中，必须有一条
  记录，否则抛出异常(如果没有记录抛出NO_DATA_FOUND)
  例子： 
  BEGIN
  SELECT col1,col2 into 变量1,变量2 FROM typestruct where xxx;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
      xxxx;
  END;
  ...

3.IF 判断
  IF V_TEST=1 THEN
    BEGIN 
       do something
    END;
  END IF;

4.while 循环
  WHILE V_TEST=1 LOOP
  BEGIN
 XXXX
  END;
  END LOOP;

5.变量赋值
  V_TEST := 123;

6.用for in 使用cursor
  ...
  IS
  CURSOR cur IS SELECT * FROM xxx;
  BEGIN
 FOR cur_result in cur LOOP
  BEGIN
   V_SUM :=cur_result.列名1+cur_result.列名2
  END;
 END LOOP;
  END;

7.带参数的cursor
  CURSOR C_USER(C_ID NUMBER) IS SELECT NAME FROM USER WHERE TYPEID=C_ID;
  OPEN C_USER(变量值);
  LOOP
 FETCH C_USER INTO V_NAME;
 EXIT FETCH C_USER%NOTFOUND;
    do something
  END LOOP;
  CLOSE C_USER;
  
  案例
create or replace procedure s_wq(name in varchar2)
is 
cursor c is select distinct id,packet_id,item_id from bms_ctrl_packet_item;
    v_id number(19,0);
    v_packetId number(19,0);
    v_itemId number(19,0);
begin  
    open c;
    loop
      fetch c into v_id,v_packetId,v_itemId;
      if c %notfound then
        dbms_output.put_line(name);
        commit;
      else
        dbms_output.put_line(name);
        commit;
      end if;
    end loop;
    close c;
end s_wq;

call s_wq('wangqi');