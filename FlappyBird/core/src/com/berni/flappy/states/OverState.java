package com.berni.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.berni.flappy.FlappyBird;

public class OverState extends State{
	private Texture background;
	private Texture playBtn;
	private Texture gameOver;
	private Texture ground;

	public OverState(GameStateManager gsm){
		super(gsm);
		cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
		background = new Texture("bg.png");
		playBtn = new Texture("playBtn.png");
		gameOver = new Texture("gameover.png");
		ground = new Texture("ground.png");
	}
	
	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()){
			gsm.set(new PlayState(gsm));
		}
	}

	@Override
	public void update(float dt) {	
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(background, 0, 0);
		sb.draw(ground, 0, -50);
		sb.draw(playBtn, (FlappyBird.WIDTH / 4 - (playBtn.getWidth() / 4)), (FlappyBird.HEIGHT / 4 - (playBtn.getHeight() / 4)), playBtn.getWidth() / 2, playBtn.getHeight() / 2);
		sb.draw(gameOver, (FlappyBird.WIDTH / 4 - (gameOver.getWidth() / 2)), (FlappyBird.HEIGHT / 3 - (gameOver.getHeight() / 4)));
		sb.end();
	}

	@Override
	public void dispose() {
		background.dispose();
		playBtn.dispose();
		gameOver.dispose();
		ground.dispose();
	}

}
