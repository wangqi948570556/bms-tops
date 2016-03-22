索引分类
1.直接创建索引和间接创建索引
    直接创建索引： CREATE INDEX mycolumn_index ON mytable (myclumn)
    间接创建索引：定义主键约束或者唯一性键约束，可以间接创建索引
2.普通索引和唯一性索引
    普通索引：CREATE INDEX mycolumn_index ON mytable (myclumn)
    唯一性索引：保证在索引列中的全部数据是唯一的，对聚簇索引和非聚簇索引都可以使用
    CREATE UNIQUE COUSTERED INDEX myclumn_cindex ON mytable(mycolumn)
3.单个索引和复合索引
    单个索引：即非复合索引
    复合索引：又叫组合索引，在索引建立语句中同时包含多个字段名，最多16个字段
    CREATE INDEX name_index ON username(firstname,lastname)
4.聚簇索引和非聚簇索引(聚集索引，群集索引)
   聚簇索引：物理索引，与基表的物理顺序相同，数据值的顺序总是按照顺序排列
    CREATE CLUSTERED INDEX mycolumn_cindex ON mytable(mycolumn) WITH
    ALLOW_DUP_ROW(允许有重复记录的聚簇索引)
   非聚簇索引：CREATE UNCLUSTERED INDEX mycolumn_cindex ON mytable(mycolumn)
