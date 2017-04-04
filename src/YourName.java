import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class YourName
{
    public int saturate (int valor)
    {
        if (valor < 0)
            return 0;
        else if(valor > 255)
            return 255;
        else
            return valor;
    }

    public BufferedImage bright(BufferedImage img, float intensity)
    {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < img.getHeight(); y++)
        {
            for (int x = 0; x < img.getWidth(); x++)
            {
                Color p = new Color(img.getRGB(x,y));
                int red = saturate((int) (p.getRed() * intensity));
                int blue = saturate((int)  (p.getBlue() * intensity));
                int green = saturate((int) (p.getGreen() * intensity));
                Color i = new Color(red, green, blue);

                out.setRGB(x,y, i.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        File PATH = new File("C:\\Users\\João Miguel\\Desktop\\WallPapers");
        BufferedImage Nn = ImageIO.read(new File(PATH, "NntTiz.jpg"));
        BufferedImage newT = bright(Nn, 0.5f);
        ImageIO.write(newT, "jpg", new File(PATH,"NnTz.jpg"));
    }

    public static void main(String[] args) throws IOException
    {
        YourName Joao = new YourName();
        Joao.run();
    }
}
