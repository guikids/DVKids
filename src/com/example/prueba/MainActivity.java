package com.example.prueba;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ImageView fondo;
	private ImageView identificacion;
	private ImageView manifestacion;
	private ImageView empatia;
	private ImageView nube;
	private ImageView sentimientos;
	private ImageView superHeroes;
		
	private Bitmap fondoFondo;
	private Bitmap fondoIdentificacion;
	private Bitmap fondoSentimientos;
	private Bitmap fondoNube;
	private Bitmap fondoManifestacion;
	private Bitmap fondoEmpatia;
	private Bitmap fondoSuperHeroes;
	
	private Bitmap fondoIdentificacionSombra;
	private Bitmap fondoSentimientosSombra;
	private Bitmap fondoNubeSombra;
	private Bitmap fondoManifestacionSombra;
	private Bitmap fondoEmpatiaSombra;
	private Bitmap fondoSuperHeroesSombra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		fondo = (ImageView) findViewById(R.id.fondo);
		InputStream resourceFondo = getResources().openRawResource(R.drawable.fondo);
		
		sentimientos = (ImageView) findViewById(R.id.sentimientos);
		InputStream resourceSentimientos = getResources().openRawResource(R.drawable.montes);
		InputStream resourceSentimientosSombra = getResources().openRawResource(R.drawable.montes_sombra);

		nube = (ImageView) findViewById(R.id.nube);
		InputStream resourceNube = getResources().openRawResource(R.drawable.nube);
		InputStream resourceNubeSombra = getResources().openRawResource(R.drawable.nube_sombra);

		identificacion = (ImageView) findViewById(R.id.identificacion);
		InputStream resourceIdentificacion = getResources().openRawResource(R.drawable.isla);
		InputStream resourceIdentificacionSombra = getResources().openRawResource(R.drawable.isla_sombra);

		manifestacion = (ImageView) findViewById(R.id.manifestacion);
		InputStream resourceManifestacion = getResources().openRawResource(R.drawable.atracciones);
		InputStream resourceManifestacionSombra = getResources().openRawResource(R.drawable.atracciones_sombra);

		empatia = (ImageView) findViewById(R.id.empatia);
		InputStream resourceEmpatia = getResources().openRawResource(R.drawable.bosque);
		InputStream resourceEmpatiaSombra = getResources().openRawResource(R.drawable.bosque_sombra);

		superHeroes = (ImageView) findViewById(R.id.superheroes);
		InputStream resourceSuperHeroes = getResources().openRawResource(R.drawable.ciudad);
		InputStream resourceSuperHeroesSombra = getResources().openRawResource(R.drawable.ciudad_sombra);

		fondoFondo = BitmapFactory.decodeStream(resourceFondo);
		fondoIdentificacion = BitmapFactory.decodeStream(resourceIdentificacion);
		fondoManifestacion = BitmapFactory.decodeStream(resourceManifestacion);
		fondoEmpatia = BitmapFactory.decodeStream(resourceEmpatia);
		fondoNube = BitmapFactory.decodeStream(resourceNube);
		fondoSentimientos = BitmapFactory.decodeStream(resourceSentimientos);
		fondoSuperHeroes = BitmapFactory.decodeStream(resourceSuperHeroes);
		
		fondoIdentificacionSombra = BitmapFactory.decodeStream(resourceIdentificacionSombra);
		fondoManifestacionSombra = BitmapFactory.decodeStream(resourceManifestacionSombra);
		fondoEmpatiaSombra = BitmapFactory.decodeStream(resourceEmpatiaSombra);
		fondoNubeSombra = BitmapFactory.decodeStream(resourceNubeSombra);
		fondoSentimientosSombra = BitmapFactory.decodeStream(resourceSentimientosSombra);
		fondoSuperHeroesSombra = BitmapFactory.decodeStream(resourceSuperHeroesSombra);
		
		fondo.setImageBitmap(fondoFondo);
		identificacion.setImageBitmap(fondoIdentificacion);
		manifestacion.setImageBitmap(fondoManifestacion);
		empatia.setImageBitmap(fondoEmpatia);
		nube.setImageBitmap(fondoNube);
		sentimientos.setImageBitmap(fondoSentimientos);
		superHeroes.setImageBitmap(fondoSuperHeroes);
		
		identificacion.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						identificacion.setImageBitmap(fondoIdentificacionSombra);
						break;
					case MotionEvent.ACTION_UP :
						identificacion.setImageBitmap(fondoIdentificacion);
						lanzarIdentificacion(null);
						break;
					default :
						break;
				}
				return true;
			}
		});

		nube.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						nube.setImageBitmap(fondoNubeSombra);
						break;
					case MotionEvent.ACTION_UP :
						nube.setImageBitmap(fondoNube);
						lanzarNube(null);
						break;
					default :
						break;
				}
				return true;
			}
		});

		sentimientos.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						sentimientos.setImageBitmap(fondoSentimientosSombra);
						break;
					case MotionEvent.ACTION_UP :
						sentimientos.setImageBitmap(fondoSentimientos);
						lanzarSentimientos(null);
						break;
					default :
						break;
				}
				return true;
			}
		});


		manifestacion.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						manifestacion.setImageBitmap(fondoManifestacionSombra);
						break;
					case MotionEvent.ACTION_UP :
						manifestacion.setImageBitmap(fondoManifestacion);
						lanzarManifestacion(null);
						break;
					default :
						break;
				}
				return true;
			}
		});


		empatia.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						empatia.setImageBitmap(fondoEmpatiaSombra);
						break;
					case MotionEvent.ACTION_UP :
						empatia.setImageBitmap(fondoEmpatia);
						lanzarEmpatia(null);
						break;
					default :
						break;
				}
				return true;
			}
		});


		superHeroes.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK){
					case MotionEvent.ACTION_DOWN :
						superHeroes.setImageBitmap(fondoSuperHeroesSombra);
						break;
					case MotionEvent.ACTION_UP :
						superHeroes.setImageBitmap(fondoSuperHeroes);
						lanzarSuperHeroes(null);
						break;
					default :
						break;
				}
				return true;
			}
		});
	}
	
	private void lanzarIdentificacion(View view) {
		//Intent i = new Intent(this, Identificacion.class);
		//startActivity(i);
		Log.d("TAG","lanzar identificador TRUE JODER TRUE");
	}
	
	private void lanzarSentimientos(View view) {
		//Intent i = new Intent(this, Sentimientos.class);
		//startActivity(i);
		Log.d("TAG","lanzar sentimientos TRUE JODER TRUE");
	}
	
	private void lanzarNube(View view) {
		Intent i = new Intent(this, Nubes.class);
		startActivity(i);
		Log.d("TAG","lanzar nube TRUE JODER TRUE");
	}
	
	private void lanzarManifestacion(View view) {
		//Intent i = new Intent(this, Manifestacion.class);
		//startActivity(i);
		Log.d("TAG","lanzar manifa TRUE JODER TRUE");
	}
	
	private void lanzarEmpatia(View view) {
		//Intent i = new Intent(this, Empatia.class);
		//startActivity(i);
		Log.d("TAG","lanzar empatia TRUE JODER TRUE");
	}
	
	private void lanzarSuperHeroes(View view) {
		Intent i = new Intent(this, SuperHeroes.class);
		startActivity(i);
		Log.d("TAG","lanzar hero powa TRUE JODER TRUE");
	}

}
