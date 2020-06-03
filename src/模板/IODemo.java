package 模板;

import java.io.*;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:06
 * @since: 1.0
 */
public class IODemo extends GetTime {
    @Override
    public void code() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\GitRepositories\\SWING\\src\\模板\\a.rmvb"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\GitRepositories\\SWING\\src\\模板\\b.rmvb"));
            byte[] bys = new byte[1024];
            boolean var4 = false;

            int len;
            while((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }

            bos.close();
            bis.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }
    }
}
