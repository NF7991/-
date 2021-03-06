package tank0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {
	private static final int SPEED = 2;
	public static int WIDTH = ResourceMgr.goodTankU.getWidth();

	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
	
	Rectangle rect = new Rectangle();
	
	private Random rendom = new Random();
	
	/*private*/ int x;int y;
	/*private*/ Dir dir = Dir.DOWN;
	
	private boolean moving = true;
	private boolean living = true;
	/*private*/ Group group = Group.BAD;
	
	
	//开火策略作为成员变量；
	//也可以作为开火方法的参数，需要将DefaultFireStreategy设计成单例
	//FireStrategy fs = new DefaultFireStrategy();
	
	//四向开火策略，，敌人坦克开火也会改变。后面需要修改敌人的开发策略
	FireStrategy fs = new FourDirFireStrategy();
	
	
	/*private*/ TankFrame tf = null;
	
	public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		//判断敌我坦克的开火策略
//		if(group == Group.GOOD) fs = new FourDirFireStrategy();
//		else fs = new DefaultFireStrategy();
		
		//通过配置文件实施判断
		if(group == Group.GOOD) { 
			String goodFSName =(String)PropertyMgr.get("goodFS");
			
			try {
				fs = (FireStrategy)Class.forName(goodFSName).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			fs = new FourDirFireStrategy();
			}
		else {
			fs = new DefaultFireStrategy();	
		}
	}
	
	
	public void fire() {
//		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
//		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGH/2;
//		tf.bullets.add(new Bullet(bX, bY, this.dir, this.group,this.tf));
		
		fs.fire(this);
	}

	public Dir getDir() {
		return dir;
	}

	public int getX() {
		return x;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getY() {
		return y;
	}

	public boolean isMoving() {
		return moving;
	}

	
	
	private void move() {
		if(!moving) return;
		
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
			
		if(this.group == Group.BAD && rendom.nextInt(100) > 95) 
			this.fire();
		if(this.group == Group.BAD && rendom.nextInt(100) > 95)
			randomDir();
		
		boundsCheck();
		//update rect
		rect.x = this.x;
		rect.y = this.y;
	}

	private void boundsCheck() {
		if(this.x < 2) x = 2;
		if(this.y < 28) y = 28;
		if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH-2;
		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) x = TankFrame.GAME_HEIGHT - Tank.HEIGHT-2;
		
	}

	private void randomDir() {
		this.dir = Dir.values()[rendom.nextInt(4)];
		
	}

	public void paint(Graphics g) {
		if(!living) tf.tanks.remove(this);
		
		switch(dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
			break;
		}
		
		move();
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void die() {
		this.living = false;
	}

}
