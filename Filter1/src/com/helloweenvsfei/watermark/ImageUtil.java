package com.helloweenvsfei.watermark;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {

	
  public static byte [] waterMark(byte [] imageData,String waterMarkFile) throws IOException{
	
	int paddingRight=10;
	int paddingBottom=10;
	
	Image image=new ImageIcon(imageData).getImage();
	int imageWidth=image.getWidth(null);
	int imageHeight=image.getHeight(null);
	
	Image waterMark=ImageIO.read(new File(waterMarkFile));
	int waterMarkWidth=waterMark.getWidth(null);
	int waterMarkHeight=waterMark.getHeight(null);
	
	
	// �p�G�Ϥ��ؤo�L�p�A�h�����B���L�A�����Ǧ^
	if(imageWidth < waterMarkWidth +2*paddingRight || imageHeight < waterMarkHeight + 2*paddingBottom){
	  return imageData;	
	}
	
	// �v���w�İ�
	BufferedImage bufferedImage=new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_RGB);
	
	
	// ø�ϥΪ�Graphics ����
	Graphics g=bufferedImage.createGraphics();
	
	// ø�s��l�v��
	g.drawImage(image,0,0,imageWidth,imageHeight,null);
	
	// ø�s�B���L�Ϥ�
	g.drawImage(waterMark,imageWidth-waterMarkWidth-paddingRight,imageHeight-waterMarkHeight-paddingBottom,waterMarkWidth,waterMarkHeight,null);
	
	g.dispose();
	
	
	// ��X�y�A�֨��O������ 
	ByteArrayOutputStream out=new ByteArrayOutputStream();
	
	// �নJPG��
	JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
	
	// �ഫ
	encoder.encode(bufferedImage);
	
	// ��X�G�i��
	byte [] data=out.toByteArray();
	out.close();
	return data;
	
  }
  
}
