package 原型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangLiang
 * @date: 2020/9/27 10:09
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tang");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        System.out.println(prototype);
        //原型复制
//        ConcretePrototype cloneType = prototype.clone();
//        cloneType.getHobbies().add("技术");
//
//        System.out.println("原型: " + prototype);
//        System.out.println("克隆: " + cloneType);
        ConcretePrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("技术");
        System.out.println("原型: " + prototype);
        System.out.println("克隆: " + cloneType);
        System.out.println(prototype == cloneType);
    }
}
