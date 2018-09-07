package com.example.demo.MycustomBean;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class GongJu {
    private static String mulu="没有设置";
    public static void ChangeImageSize(InputStream in, OutputStream out,int width,int height) throws IOException {
        BufferedImage image= ImageIO.read(in);
        BufferedImage Image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = Image.getGraphics();
        Size percent = calculatelocation(image.getWidth(), image.getHeight(), width, height);
        graphics.drawImage(image,percent.x,percent.y,percent.width,percent.height,null);
        ImageIO.write(Image,"png",out);
        in.close();
        out.close();
//        return true;
//        return false;
    }
    private static Size calculatelocation(double width, double heitht, double WIDTH, double HEIGHT){
        Size size=new Size();
        double h1=(WIDTH/width)*heitht;
        double w1=(HEIGHT/heitht)*width;
        if(h1<HEIGHT){
            size.x = 0;
            size.width=(int)WIDTH;
            size.y=(int)(HEIGHT-h1)/2;
            size.height=(int)h1;
        }
        else{
            size.y=0;
            size.height=(int)HEIGHT;
            size.x=(int)(WIDTH-w1)/2;
            size.width=(int)w1;
        }
        return size;
    }
    private  static class Size {
        public int x=0;
        public int y=0;
        public int width=0;
        public int height=0;
    }
}
