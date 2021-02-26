1.总体规范

全大写  
长度不超过32个字符  
单词之间用_分隔  

2.表名

系统缩写名+对象名称。如MP_USER

3.列名

不加任何前缀和后缀  
以下划线为单词分割和结尾。  
如USER_NAME_  

4.主键名

PK加对象名称  
PK_USER  

5.外键名

FK+对象名称+关联字段名称  
如FK_USER_ORG_ID  

6.唯一键名

UQ+对象名称，如有多个+相关字段名称  
如UQ_USER  

7.索引名

IX+对象名称+相关字段名称  
如IX_USER_ORDER  

8.触发器名

TR+对象名称+操作名（I/U/D代表insert、update和delete）  
如TR_USER_I  

9.视图名

系统缩写名+V+对象名称。如MPV_USER  

10.存储过程名

SP+对象名称+操作名（I/U/D/S代表insert、update、delete和select）  
如SP_USER_I  

11.函数名

FUNC+函数名  
如FUNC_LOAD_USER  

12.变量名

输入输出标识(I/O/IO)+变量名  
如I_USER_NAME  

13.SQL格式

在IDE中设置排版模板，按照模板格式化代码。  
如：PL/SQL Developer格式化模板  
