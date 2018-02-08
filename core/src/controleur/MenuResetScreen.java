package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gdx.colorswitch.ColorSwitch;

import modele.MenuResetWorld;
import vue.MenuResetRenderer;

public class MenuResetScreen implements Screen {
	private ColorSwitch main;
	private MenuResetWorld world;
	private MenuResetRenderer renderer;
	
	
	public MenuResetScreen(ColorSwitch cs) {
		main = cs;
		world = new MenuResetWorld();
		renderer = new MenuResetRenderer(world);
		Gdx.input.setInputProcessor(new MenuResetInputHandler(main,world));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
