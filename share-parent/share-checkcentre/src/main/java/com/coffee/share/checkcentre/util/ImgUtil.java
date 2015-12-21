package com.coffee.share.checkcentre.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 画图的工具类
 * 
 * @author and04
 *
 */
public class ImgUtil {

	/**
	 * 生成验证码
	 * 
	 * @param code
	 *            验证码的字符
	 * @return 生成图片的字字节数组
	 * @throws IOException
	 */
	public static byte[] getCaptchaImg(String code) throws IOException {

		final int height = 20;
		final int width = 70;

		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = bi.createGraphics(); // 获取画笔

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		g.setColor(new Color(0, 0, 150));
		g.setFont(new Font("黑体", Font.BOLD, 16));
		
		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			int x1 = r.nextInt(width);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(width);
			int y2 = r.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}

		for (int i = 0; i < code.length(); i++) {
			g.drawString(String.valueOf(code.charAt(i)), 5 + 15 * i, 18);
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(bi, "png", os);
		g.dispose();

		return os.toByteArray();
	}
}
