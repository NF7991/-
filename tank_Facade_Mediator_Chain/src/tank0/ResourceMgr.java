package tank0;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

public class ResourceMgr {
//	public static BufferedImage tankL, tankR, tankU, tankD;
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD; 
	public static BufferedImage badTankL, badTankU, badTankR, badTankD; 
	public static BufferedImage bulletL, bulletR, bulletU, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	
	static {
		try {
//		tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//		tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif")); 
//		tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif")); 
//		tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
//		
//		bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
//		bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif")); 
//		bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif")); 
//		bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif")); 
		
		goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
		goodTankL = ImageUtil.rotateImage(goodTankU, -90);
		goodTankR = ImageUtil.rotateImage(goodTankU, 90);
		goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			
		badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
		badTankL = ImageUtil.rotateImage(badTankU, -90);
		badTankR = ImageUtil.rotateImage(badTankU, 90);
		badTankD = ImageUtil.rotateImage(badTankU, 180);
			
		bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
		bulletL = ImageUtil.rotateImage(bulletU, -90);
		bulletR = ImageUtil.rotateImage(bulletU, 90);
		bulletD = ImageUtil.rotateImage(bulletU, 180);
		
		for(int i = 0; i <16; i++)
			explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1)+ ".gif")); 	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
