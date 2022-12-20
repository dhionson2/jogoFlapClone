package com.primeirogame.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[]passaros;
	private Texture fundo;

	// atributos de configuracao
	private int larguraDispositivo;
	private int alturaDispotivo;


	private float variacao =0;

	private float velocidaQueda=0;
	private float posicaoInicialVertical=700;


	@Override
	public void create () {
		batch = new SpriteBatch();
		passaros = new Texture[4];
		passaros[0] = new Texture("pas.png");
		passaros[1] = new Texture("pas2.png");
		passaros[2] = new Texture("pass3.png");
		fundo = new Texture("fundo.png");
		larguraDispositivo =Gdx.graphics.getWidth();
		alturaDispotivo = Gdx.graphics.getHeight();

	}

	@Override
	public void render () {
		variacao += Gdx.graphics.getDeltaTime();
		velocidaQueda += Gdx.graphics.getDeltaTime();
		if(posicaoInicialVertical > 0) {
			posicaoInicialVertical = posicaoInicialVertical - velocidaQueda;
		}
		if(variacao > 3){
			variacao =0;
		}

		batch.begin();
		batch.draw(fundo,0,0,larguraDispositivo,alturaDispotivo);
		batch.draw(passaros[(int)variacao],900,posicaoInicialVertical);

		batch.end();
	}
	

}
