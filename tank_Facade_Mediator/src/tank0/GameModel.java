package tank0;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import cor.BullterTankCollider;
import cor.Collider;
import cor.TankTankCollider;
import tank0.TankFrame;

public class GameModel {
	
	Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);
	
//	List<Bullet> bullets = new ArrayList<>();
//	List<Tank> tanks = new ArrayList<>();
//	List<Explode> explodes = new ArrayList<>();
	
	Collider collider = new BullterTankCollider();
	Collider collider2 = new TankTankCollider();
	
	private List<GameObject> objects = new ArrayList<>();
	
	public GameModel() {
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		
		//初始化敌方坦克
		for(int i = 0; i<initTankCount; i++){
			add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this)) ;
		}
	}
	
	public void add(GameObject go) {
		this.objects.add(go);
	}
	
	public void remove(GameObject go) {
		this.objects.remove(go);
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
//		g.drawString("子弹的数量：" + bullets.size(),10,60);
//		g.drawString("敌人的数量：" + tanks.size(),10,80);
//		g.drawString("爆炸的数量：" + explodes.size(),10,100);
		g.setColor(c);
		
		myTank.paint(g);
//		for(int i = 0; i<bullets.size(); i++) {
//			bullets.get(i).paint(g);
//		}
//		
//		for(int i = 0; i<tanks.size(); i++) {
//			tanks.get(i).paint(g);
//		}
//		
//		for(int i = 0; i<explodes.size(); i++) {
//			explodes.get(i).paint(g);
//			}
		
		for(int i = 0; i<objects.size(); i++) {
			objects.get(i).paint(g);
		}
		
		//互相碰撞
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size(); j++) {
				//效率低
//				GameObject o1 = objects.get(i);
//				GameObject o2 = objects.get(j);
//				o1.colliedWith(o2);
				
				//Comparator.compare(o1,o2)
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				collider.collide(o1, o2);
				collider2.collide(o1, o2);
				
			}
		}
		
		//collision detect
//		for(int i = 0; i<bullets.size(); i++) {
//			for(int j = 0; j<tanks.size();j++)
//				bullets.get(i).collideWith(tanks.get(j));
//		}
		
		
//		for (Iterator<Bullet> it = bullets.iterator(); it.hasNext();) {
//			Bullet b = it.next();
//			if(!b.live) it.remove();
//		}
	}

	public Tank getMainTank() {
		// TODO Auto-generated method stub
		return myTank;
	}
	
}
