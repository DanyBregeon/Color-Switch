package com.gdx.colorswitch;

import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controleur.GameScreen;
import controleur.Menu;

public class ColorSwitch extends Game{

	private GameScreen gameScreen;
    private Menu menuScreen;
    
	@Override
	public void create() {
		Gdx.app.log("ColorSwitch", "created");
		//setScreen(new GameScreen());
		setScreen(new Menu(this));
	}
	
	
	
	//Gdx.app.log instead of System.out.println()
}
