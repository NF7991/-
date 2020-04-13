//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.nio.Buffer;
//
//import javax.imageio.ImageIO;
//
//import org.junit.jupiter.api.Test;
//
//class IamgeTest {
//
//	@Test
//	void test() {
//
//		try {
//			BufferedImage image = ImageIO.read(new File("C:/Users/Shinelon/Documents/GitHub/tank/tank/src/images"));
//			assertNotNull(image);
//
//			BufferedImage image2 = ImageIO.read(IamgeTest.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
//			assertNotNull(image2);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
////		fail("Not yet implemented");
//	}
//
//}
