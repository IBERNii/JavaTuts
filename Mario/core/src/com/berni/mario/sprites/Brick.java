package com.berni.mario.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.berni.mario.MarioBros;
import com.berni.mario.scenes.Hud;

public class Brick extends InteractiveTileOject{
	public Brick(World world, TiledMap map, Rectangle bounds) {
		super(world, map, bounds);
		fixture.setUserData(this);
		setCategoryFilter(MarioBros.BRICK_BIT);
	}

	@Override
	public void onHeadHit() {
		Gdx.app.log("Brick", "Collison");
		setCategoryFilter(MarioBros.DESTROYED_BIT);
		getCell().setTile(null);
		Hud.addScore(200);
	}
}
