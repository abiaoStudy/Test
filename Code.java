import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Code {

       static String [] strs = {"a","b","c","d","e","f","g","h","i","j","k","m","n","p","q","r",
                "s","t","u","v","w","x","y","z","2","3","4","5","6","7","8","9"};

    public static void main(String[] args) throws IOException {

        // 定义图片的宽度和高度，根据业务逻辑定
        int w = 180;
        int h = 60;

        // 定义图片的类型，rgb类型
        int imageType = BufferedImage.TYPE_INT_RGB;


        // 调用画板类，传参  宽，高，图片类型
        BufferedImage image = new BufferedImage(w,h,imageType);

        // 获取画笔对象
        Graphics g = image.getGraphics();

        // 把画笔的颜色设置成黄色
        g.setColor(Color.yellow);

        // 调用画笔的方法，在相同坐标下 填充一个宽、高一样的矩形 就是底图
        g.fillRect(0,0,w,h);

        Random random = new Random();
        int x = 30;
        int y = 25;
        // 调整画笔颜色 就是字体的颜色
        g.setColor(Color.red);

        // 设置字体 宋体 加粗 30px
        g.setFont(new Font("宋体",Font.BOLD,30));
        // 从strs中随机生成4个元素
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(strs.length);
            String str = strs[num];
            g.drawString(str,x,y);
            x += 30;
        }

        // 画干扰线,先设置画笔的颜色 就是线条的颜色
        g.setColor(Color.blue);

        // 画10条干扰线，x1 y1 代表起点的坐标  x2 y2 代表终点的坐标
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(60);

            int x2 = random.nextInt(30)+150;
            int y2 = random.nextInt(60);
            g.drawLine(x1,y1,x2,y2);
        }

        // IO流 把照片保存在e盘1.jpg下
        ImageIO.write(image,"jpg",new File("e:\\1.jpg"));
    }
}
