package strategy;

import tank0.Audio;
import tank0.Bullet;
import tank0.Dir;
import tank0.Group;
import tank0.Tank;

public class FourDirFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGH/2;
		
		Dir[] dirs = Dir.values();
		for(Dir dir : dirs) {
			new Bullet(bX, bY, dir, t.group, t.gm);
		}
		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		
	}
}
