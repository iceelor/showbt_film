package com.showbt.util;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Map;

public class ResizeImage {

    /**
     * @param im            原始图像
     * @param resizeTimes   需要缩小的倍数，缩小2倍为原来的1/2 ，这个数值越大，返回的图片越小
     * @return              返回处理后的图像
     */
    public BufferedImage resizeImage(BufferedImage im, float resizeTimes) {
        /*原始图像的宽度和高度*/
        int width = im.getWidth();
        int height = im.getHeight();

        /*调整后的图片的宽度和高度*/
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) / resizeTimes);
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) / resizeTimes);

        /*新生成结果图片*/
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }

    /**
     * @param im            原始图像
     * @param resizeTimes   倍数,比如0.5就是缩小一半,0.98等等double类型
     * @return              返回处理后的图像
     */
    public BufferedImage zoomImage(BufferedImage im, float resizeTimes) {
        /*原始图像的宽度和高度*/
        int width = im.getWidth();
        int height = im.getHeight();

        /*调整后的图片的宽度和高度*/
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) * resizeTimes);
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) * resizeTimes);

        /*新生成结果图片*/
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
    
    /**
     * @param im            原始图像
     * @param w				指定宽度
     * @param h 			指定高度
     * @return              返回处理后的图像
     */
    public BufferedImage zoomImage(BufferedImage im, int w, int h) {
        /*原始图像的宽度和高度*/
        int width = im.getWidth();
        int height = im.getHeight();
        float resizeTimes = 1;
        if(w >0){
        	resizeTimes = Float.parseFloat(String.valueOf(w))/Float.parseFloat(String.valueOf(width));
        }else if(h >0){
        	resizeTimes = Float.parseFloat(String.valueOf(h))/Float.parseFloat(String.valueOf(height));
        }

        /*调整后的图片的宽度和高度*/
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) * resizeTimes);
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) * resizeTimes);
        if(w !=0 && h !=0){
        	toWidth = w;
        	toHeight = h;
        }
        /*新生成结果图片*/
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
    

    /**
     * @param path  要转化的图像的文件夹,就是存放图像的文件夹路径
     * @param type  图片的后缀名组成的数组
     * @return
    */
    public List<BufferedImage> getImageList(String path, String[] type) throws IOException{
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        for(String s : type) {
            map.put(s,true);
        }
        List<BufferedImage> result = new ArrayList<BufferedImage>();
        File[] fileList = new File(path).listFiles();
        for (File f : fileList) {
            if(f.length() == 0)
                continue;
            if(map.get(getExtension(f.getName())) == null)
                continue;
            result.add(javax.imageio.ImageIO.read(f));
        }
        return result;
    }

    /**
     * 把图片写到磁盘上
      * @param im
     * @param path     eg: C://home// 图片写入的文件夹地址
      * @param fileName DCM1987.jpg  写入图片的名字
      * @return
     */
    public boolean writeToDisk(BufferedImage im, String path, String fileName) {
        File f = new File(path + fileName);
        String fileType = getExtension(fileName);
        if (fileType == null)
            return false;
        try {
            ImageIO.write(im, fileType, f);
            im.flush();
            return true;
        } catch (IOException e) {
        	e.printStackTrace();
            return false;
        }
    }

    public String writeHighQuality(BufferedImage im, String fileFullPath, String fileName) {
    	String fName = fileName+".jpg";
        try {
            /*输出到文件流*/
            FileOutputStream newimage = new FileOutputStream(fileFullPath+File.separator+fName);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
            /* 压缩质量 */
            jep.setQuality(1f, true);
            encoder.encode(im, jep);
           /*近JPEG编码*/
            newimage.close();
            return fName;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 返回文件的文件后缀名
      * @param fileName
      * @return
    */
    public String getExtension(String fileName) {
        try {
            return fileName.split("\\.")[fileName.split("\\.").length - 1];
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception{


//        String inputFoler = "c:\\cameraImage" ; 
         /*这儿填写你存放要缩小图片的文件夹全地址*/
        String outputFolder = "c:\\output\\";  
        /*这儿填写你转化后的图片存放的文件夹*/
        float times = 0.5f; 
        /*这个参数是要转化成的倍数,如果是1就是转化成1倍*/


        ResizeImage r = new ResizeImage();
        BufferedImage bi = ImageIO.read(new URL("http://apollo.s.dpool.sina.com.cn/nd/dataent/moviepic/pics/87/moviepic_1b5c5a0ec22f7431a76de0f42911e7da.jpg"));
		List<BufferedImage> imageList = new ArrayList<BufferedImage>();//r.getImageList(inputFoler,new String[] {"jpg"});
		imageList.add(bi);
        for(BufferedImage i : imageList) {
	        r.writeHighQuality(r.zoomImage(i,times),outputFolder,System.currentTimeMillis()+"");
		}
    }
}