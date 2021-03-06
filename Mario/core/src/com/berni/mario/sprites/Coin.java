package com.berni.mario.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.berni.mario.MarioBros;
import com.berni.mario.scenes.Hud;

public class Coin extends InteractiveTileOject{
	private static TiledMapTileSet tileSet;
	private final int BLANK_COIN = 28;
	
	public Coin(World world, TiledMap map, Rectangle bounds) {
		super(world, map, bounds);
		tileSet = map.getTileSets().getTileSet("tileset_gutter");
		fixture.setUserData(this);
		setCategoryFilter(MarioBros.COIN_BIT);
	}

	@Override
	public void onHeadHit() {
		Gdx.app.log("Coin", "Collison");
		getCell().setTile(tileSet.getTile(BLANK_COIN));
		Hud.addScore(100);
	}
}
