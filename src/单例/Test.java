package 单例;

import 单例.枚举单例例子2.DBUtilEnum;

/**
 * @author: TangLiang
 * @date: 2020/6/3 16:44
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {

        DBUtil db1 = DataSourceEnum.DATASOURCE.getDBUtil();
        DBUtil db2 = DataSourceEnum.DATASOURCE.getDBUtil();
        System.out.println(db1 == db2);

//        DBUtilEnum dbUtilEnum1 = DBUtilEnum.getDbUtil();
//        DBUtilEnum dbUtilEnum2 = DBUtilEnum.getDbUtil();
        //System.out.println(dbUtilEnum1 == dbUtilEnum2);
    }
}
