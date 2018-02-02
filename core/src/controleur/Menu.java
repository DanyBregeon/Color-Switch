package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gdx.colorswitch.ColorSwitch;

import modele.GameWorld;
import modele.MenuWorld;
import vue.GameRenderer;
import vue.MenuRenderer;

public class Menu implements Screen{
	private ColorSwitch main;
	private MenuWorld world;
	private MenuRenderer renderer;

	public Menu(ColorSwitch cs) {
		main = cs;
		world = new MenuWorld();
		renderer = new MenuRenderer(world);
		Gdx.input.setInputProcessor(new MenuInputHandler(main, world));
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
