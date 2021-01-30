package 装饰.demo1;

/**
 * @author: tangliang
 * @date: 2020/3/30 12:45.
 * @description: XXX
 */
public class Demo1 {

    public static void main(String[] args) {

        Player player = new LolPlayer();
        System.out.println("普通攻击:" + player.fight("aa"));

        MagicMaskPlayerDecorator magicMaskPlayerDecorator = new MagicMaskPlayerDecorator(player);
        int res = magicMaskPlayerDecorator.fight("aa");
        System.out.println("大面具攻击:" + res);

        HatMaskPlayerDecorator hatPlayerDecorator = new HatMaskPlayerDecorator(magicMaskPlayerDecorator);
        res = hatPlayerDecorator.fight("aa");
        System.out.println("帽子攻击:" + res);
    }
}
