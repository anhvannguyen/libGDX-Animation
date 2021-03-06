package me.anhvannguyen.animationtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private TextureAtlas spriteSheet;
	private Array<Sprite> ragna;
	private Array<Sprite> jin;
	private Animation ragnaAnimation;
	private Animation jinAnimation;
	
	private float stateTime;
	private float screenWidth;
	private float screenHeight;
	
	@Override
	public void create () {
		// Get the dimension of the screen
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		batch = new SpriteBatch();
		
		// load up our sprite sheet, generated by Texture Packer
		spriteSheet = new TextureAtlas(Gdx.files.internal("images/animation.txt"));
		// get all the regions with the specified name and return them as sprites
		ragna = spriteSheet.createSprites("ragna");
		jin = spriteSheet.createSprites("jin");
		
		// flipping the first character to make them face each other
		// looking for a better way to do this
		for (Sprite sprite : ragna) {
			sprite.flip(true, false);
		}
		
		// set the keyframe and frame delay for the animation
		ragnaAnimation = new Animation(0.1f, ragna);
		jinAnimation = new Animation(0.1f, jin);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// elapsed time that is used to determine the state of the animation
		stateTime += Gdx.graphics.getDeltaTime();
		batch.begin();
		// get the current frame based on the elapsed time and set looping to be true
		batch.draw(ragnaAnimation.getKeyFrame(stateTime, true), 150, 50);
		batch.draw(jinAnimation.getKeyFrame(stateTime, true), screenWidth - 300, 50);
		batch.end();
	}
}
