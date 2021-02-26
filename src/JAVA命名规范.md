1.包命名

全小写  
以cn.newangels开头

服务层：service  
服务实现层：service.impl  
控制层：controller  
实体层：dto  
DAO层：dao  

2.类命名

首字母大写  
服务类：对象名称+Service。如：UserService  
服务实现类：对象名称+ServiceImpl。如：UserServiceImpl  
控制类：对象名称+Controller。如：UserController  
实体类：对象名称。如：User  
DAO类：对象名称+Dao。如：UserDao  

3.方法命名

首字母小写  
动词在前，对象名称在后。如：insertUser  
专用条件查询，后面加By条件。如：selectUserByStatus. 或在对象名称前加形容词。如：selectDisabledUser  

相关动词：  
id单查询 load  
通用综合查询 select  
新增 insert  
修改 update  
删除 delete  
废弃 disable  
恢复 enable  

4.类变量命名

首字母小写，驼峰模式。如：userName  

5.静态常量的命名

全大写,单词之间用下划线分隔。如：ORG_TYPE  

6.集合变量命名

数组：对象名称+s。如users  
List：对象名称+List。如userList  
Map：对象名称+Map。如userMap  
Set：对象名称+Set。如userSet  

7.类，方法注释

注明作者，日期  
注明必要的入参，出参，业务相关说明  

8.排版

在IDE中设置排版模板，按照模板格式化代码。  
