package 算法.zip;

import 算法.zip.optimized.OptimizedZipUtil;

public class OptimizedZipUtilTest {
    public static void main(String[] args) {
//        OptimizedZipUtil.zip("D:\\pom.xml","D:\\pom.zip");
//        OptimizedZipUtil.unzip("D:\\pom.zip","D:\\pom2.xml");
//        OptimizedZipUtil.zip("D:\\ceshi.bmp","D:\\ceshi.zip");
//        OptimizedZipUtil.unzip("D:\\ceshi.zip","D:\\ceshi2.bmp");
        OptimizedZipUtil.zip("D:\\database.log", "D:\\database.zip");
        OptimizedZipUtil.unzip("D:\\database.zip", "D:\\database2.log");

    }
}
