package 动态代理;

import java.lang.reflect.Proxy;

/**
 * @author: TangLiang
 * @date: 2020/6/3 9:10
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentImpl();
        studentDao.add();
        studentDao.update();
        studentDao.delete();
        studentDao.selete();
        System.out.println("----------------------");
        MyInvocationHandler handler = new MyInvocationHandler(studentDao);
        StudentDao proxy = (StudentDao) Proxy.newProxyInstance(studentDao.getClass().getClassLoader(), studentDao.getClass().getInterfaces(), handler);
        proxy.add();
        proxy.update();
        proxy.delete();
        proxy.selete();
    }
}
