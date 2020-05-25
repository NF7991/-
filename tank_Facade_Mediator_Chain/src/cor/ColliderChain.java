package cor;

import java.util.LinkedList;
import java.util.List;

import tank0.GameObject;

public class ColliderChain {
	private List<Collider> colliders = new LinkedList<>();
	
	public ColliderChain() {
		add(new BullterTankCollider());
		add(new TankTankCollider());
	}
	
	public void add(Collider c) {
		colliders.add(c);
	}

	public boolean collider(GameObject o1, GameObject o2) {
		for(int i = 0; i<colliders.size(); i++) {
			if(colliders.get(i).collide(o1, o2)) {
				return false;
			}
		}
		return true;
	}
	

}
