package 单例;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public enum DataSourceEnum {
    DATASOURCE;
    private DBUtil dbUtil = null;

    private DataSourceEnum() {
        dbUtil = new DBUtil();
    }

    public DBUtil getDBUtil() {
        return dbUtil;
    }
}
