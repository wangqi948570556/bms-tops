DDL：数据库模式定义语言，关键字：create
DML：数据操纵语言，关键字：Insert、delete、update
DCL：数据库控制语言 ，关键字：grant、remove
DQL：数据库查询语言，关键字：select
--http://www.iteye.com/topic/649874
调用存储过程 exec  call
一  概念 
游标是SQL的一个内存工作区，由系统或用户以变量的形式定义。游标的作用就是用于临时存储从数据库中提取的数据块。在某些情况下，
需要把数据从存放在磁盘的表中调到计算机内存中进行处理，最后将处理结果显示出来或最终写回数据库。
这样数据处理的速度才会提高，否则频繁的磁盘数据交换会降低效率。
二  类型 
Cursor类型包含三种: 隐式Cursor，显式Cursor和Ref Cursor（动态Cursor）
1．	隐式Cursor: 
1).对于Select …INTO…语句，一次只能从数据库中获取到一条数据，对于这种类型的DML Sql语句，就是隐式Cursor。例如：Select /Update / Insert/Delete操作。 
2)作用：可以通过隐式Cusor的属性来了解操作的状态和结果，从而达到流程的控制。Cursor的属性包含： 
SQL%ROWCOUNT 整型 代表DML语句成功执行的数据行数 
SQL%FOUND  布尔型  值为TRUE代表插入、删除、更新或单行查询操作成功 
SQL%NOTFOUND 布尔型 与SQL%FOUND属性返回值相反 
SQL%ISOPEN 布尔型 DML执行过程中为真，结束后为假 
3) 隐式Cursor是系统自动打开和关闭Cursor.

2．	显式Cursor：
（1）	对于从数据库中提取多行数据，就需要使用显式Cursor。显式Cursor的属性包含： 
游标的属性   返回值类型   意    义  
%ROWCOUNT   整型  获得FETCH语句返回的数据行数  
%FOUND  布尔型 最近的FETCH语句返回一行数据则为真，否则为假  
%NOTFOUND   布尔型 与%FOUND属性返回值相反  
%ISOPEN 布尔型 游标已经打开时值为真，否则为假  

（2）	对于显式游标的运用分为四个步骤： 
	定义游标---Cursor  [Cursor Name]  IS; 
	打开游标---Open  [Cursor Name]; 
	操作数据---Fetch  [Cursor name] 
	关闭游标---Close [Cursor Name],这个Step绝对不可以遗漏。 
（3）以下是三种常见显式Cursor用法。 

3．	Ref Cursor（动态游标）： 
1）	与隐式Cursor,显式Cursor的区别：Ref Cursor是可以通过在运行期间传递参数来获取数据结果集。而另外两种Cursor，是静态的，在编译期间就决定数据结果集。 
2）	Ref cursor的使用: 
	Type [Cursor type name] is ref cursor 
	Define 动态的Sql语句 
	Open cursor 
	操作数据---Fetch  [Cursor name] 
	Close Cursor 

type cur_type is ref cursor; 

4.常见Exception 
1.  错 误 名 称 错误代码    错 误 含 义     
2.  CURSOR_ALREADY_OPEN ORA_06511   试图打开已经打开的游标     
3.  INVALID_CURSOR  ORA_01001   试图使用没有打开的游标     
4.  DUP_VAL_ON_INDEX    ORA_00001   保存重复值到惟一索引约束的列中     
5.  ZERO_DIVIDE ORA_01476   发生除数为零的除法错误     
6.  INVALID_NUMBER  ORA_01722   试图对无效字符进行数值转换     
7.  ROWTYPE_MISMATCH    ORA_06504   主变量和游标的类型不兼容     
8.  VALUE_ERROR ORA_06502   转换、截断或算术运算发生错误     
9.  TOO_MANY_ROWS   ORA_01422   SELECT…INTO…语句返回多于一行的数据     
10. NO_DATA_FOUND   ORA_01403   SELECT…INTO…语句没有数据返回     
11. TIMEOUT_ON_RESOURCE ORA_00051   等待资源时发生超时错误     
12. TRANSACTION_BACKED_OUT  ORA_00060   由于死锁，提交失败     
13. STORAGE_ERROR   ORA_06500   发生内存错误     
14. PROGRAM_ERROR   ORA_06501   发生PL/SQL内部错误     
15. NOT_LOGGED_ON   ORA_01012   试图操作未连接的数据库     
16. LOGIN_DENIED    ORA_01017   在连接时提供了无效用户名或口令    