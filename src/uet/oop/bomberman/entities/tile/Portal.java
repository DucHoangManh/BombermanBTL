package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Sound.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Portal extends Tile {
	protected Board _board;
	public Portal(int x, int y, Sprite sprite, Board board) {
		super(x, y, sprite);
		_board=board;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		if (e instanceof Bomber ){
			if (Bomber.getBombNumber()==0) {
				if (_board.detectNoEnemies()) {
					Sound.get_item();
					_board.nextLevel();
				}
			}
		}
		return false;
	}

}
