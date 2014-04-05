package com.example.prueba;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SuperHeroes extends Activity{
	
	private int xDelta;
	private int yDelta;
	
	private ViewGroup marco;
	
	private ImageView fondoArrastrar;
	private ImageView ninyo;
	private ImageView gorra;
	private ImageView brazalete;
	private ImageView camiseta;
	private ImageView capa;
	private ImageView gafa;
	
	private Bitmap fondoFondoArrastrar;
	private Bitmap fondoNinyo;
	private Bitmap fondoGorra;
	private Bitmap fondoBrazalete;
	private Bitmap fondoCamiseta;
	private Bitmap fondoCapa;
	private Bitmap fondoGafa;
	
	private Bitmap fondoGorraSombra;
	private Bitmap fondoBrazaleteSombra;
	private Bitmap fondoCamisetaSombra;
	private Bitmap fondoCapaSombra;
	private Bitmap fondoGafaSombra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.superheroes);

		Log.d("TAG","CREADOR");
		
		marco = (ViewGroup) findViewById(R.id.back_nubes);
		Log.d("TAG","MARCO");
		ninyo = (ImageView) findViewById(R.id.ninyo_img);
		InputStream resourceNinyo = getResources().openRawResource(R.drawable.ninyo);
		fondoNinyo = BitmapFactory.decodeStream(resourceNinyo);
		ninyo.setImageBitmap(fondoNinyo);
		Log.d("TAG","NIÑO");
		
		
		fondoArrastrar = (ImageView) findViewById(R.id.fondo_superheroe);
		InputStream resourceFondoArrastrar = getResources().openRawResource(R.drawable.fondo_superheroes);
		fondoFondoArrastrar = BitmapFactory.decodeStream(resourceFondoArrastrar);
		fondoArrastrar.setImageBitmap(fondoFondoArrastrar);
		Log.d("TAG","FONDO");
		/*
		gorra = (ImageView) findViewById(R.id.gorra_img);
		InputStream resourceGorra = getResources().openRawResource(R.drawable.gorra);
		InputStream resourceGorraSombra = getResources().openRawResource(R.drawable.gorra_sombra);
		fondoGorra = BitmapFactory.decodeStream(resourceGorra);
		//fondoGorraSombra = BitmapFactory.decodeStream(resourceGorraSombra);
		gorra.setImageBitmap(fondoGorra);
		*/
		Log.d("TAG","GORRA");
		brazalete = (ImageView) findViewById(R.id.brazalete_img);
		InputStream resourceBrazalete = getResources().openRawResource(R.drawable.camiseta);
		InputStream resourceBrazaleteSombra = getResources().openRawResource(R.drawable.camiseta_sombra);
		fondoBrazalete = BitmapFactory.decodeStream(resourceBrazalete);
		//fondoBrazaleteSombra = BitmapFactory.decodeStream(resourceBrazaleteSombra);
		brazalete.setImageBitmap(fondoBrazalete);
		/*
		gafa = (ImageView) findViewById(R.id.gafas_img);
		InputStream resourceGafa = getResources().openRawResource(R.drawable.gafa);
		InputStream resourceGafaSombra = getResources().openRawResource(R.drawable.gafa_sombra);
		fondoGafa= BitmapFactory.decodeStream(resourceGafa);
		fondoGafaSombra = BitmapFactory.decodeStream(resourceGafaSombra);
		gafa.setImageBitmap(fondoGafa);
		
		capa = (ImageView) findViewById(R.id.capa_img);
		InputStream resourceCapa= getResources().openRawResource(R.drawable.capa);
		InputStream resourceCapaSombra = getResources().openRawResource(R.drawable.capa_sombra);
		fondoCapa = BitmapFactory.decodeStream(resourceCapa);
		fondoCapaSombra = BitmapFactory.decodeStream(resourceCapaSombra);
		capa.setImageBitmap(fondoCapa);
		
		camiseta = (ImageView) findViewById(R.id.camiseta_img);
		InputStream resourceCamiseta= getResources().openRawResource(R.drawable.camiseta);
		InputStream resourceCamisetaSombra = getResources().openRawResource(R.drawable.camiseta_sombra);
		fondoCamiseta = BitmapFactory.decodeStream(resourceCamiseta);
		fondoCamisetaSombra = BitmapFactory.decodeStream(resourceCamisetaSombra);
		camiseta.setImageBitmap(fondoCamiseta);
		*/
		
		Log.d("TAG","AKI A CREADO TODO");
		/*
		capa.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				final int iX = (int) event.getX();
				final int iY = (int) event.getY();
				Log.d("TAG","dentro del ontouch");
				// Dependiendo de la accion recogida..
				
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				
				case MotionEvent.ACTION_DOWN:
					Log.d("TAG","action down");
					capa.setImageBitmap(fondoCapaSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoCapa.getPixel(iX, iY);
					} catch (IllegalArgumentException e) {
					}
					if (color != Color.TRANSPARENT){
						RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
						xDelta = X - Params.leftMargin;
						yDelta = Y - Params.topMargin;
					}
					else
						return false;
					// Recogemos los parametros de la imagen que hemo tocado
		
					break;
				case MotionEvent.ACTION_UP:
					Log.d("TAG","action up");
					capa.setImageBitmap(fondoCapa);
					break;
				case MotionEvent.ACTION_MOVE:
					Log.d("TAG","move");
					// Al mover el dedo vamos actualizando
					// los margenes de la imagen para
					// crear efecto de arrastrado
					RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
					layoutParams.leftMargin = X - xDelta;
					layoutParams.topMargin = Y - yDelta;
					// Qutamos un poco de margen para
					// que la imagen no se deforme
					// al llegar al final de la pantalla y pueda ir más allá
					// probar también el codigo omitiendo estas dos líneas
					layoutParams.rightMargin = -200;
					layoutParams.bottomMargin = -200;
					// le añadimos los nuevos
					// parametros para mover la imagen
					v.setLayoutParams(layoutParams);
					break;
				}
				// Se podría decir que 'dibujamos'
				// la posición de la imagen en el marco.
				marco.invalidate();
				return true;
			}
		});
		
		Log.d("TAG","EL PRIMER LISTENER CONSEGUIDO");

		camiseta.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				final int iX = (int) event.getX();
				final int iY = (int) event.getY();
		
				// Dependiendo de la accion recogida..
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				case MotionEvent.ACTION_DOWN:
					camiseta.setImageBitmap(fondoCamisetaSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoCamiseta.getPixel(iX, iY);
					} catch (IllegalArgumentException e) {
					}
					if (color != Color.TRANSPARENT){
						RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
						xDelta = X - Params.leftMargin;
						yDelta = Y - Params.topMargin;
					}
					else
						return false;
					// Recogemos los parametros de la imagen que hemo tocado
		
					break;
				case MotionEvent.ACTION_UP:
					camiseta.setImageBitmap(fondoCamiseta);
					break;
				case MotionEvent.ACTION_MOVE:
					// Al mover el dedo vamos actualizando
					// los margenes de la imagen para
					// crear efecto de arrastrado
					RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
					layoutParams.leftMargin = X - xDelta;
					layoutParams.topMargin = Y - yDelta;
					// Qutamos un poco de margen para
					// que la imagen no se deforme
					// al llegar al final de la pantalla y pueda ir más allá
					// probar también el codigo omitiendo estas dos líneas
					layoutParams.rightMargin = -200;
					layoutParams.bottomMargin = -200;
					// le añadimos los nuevos
					// parametros para mover la imagen
					v.setLayoutParams(layoutParams);
					break;
				}
				// Se podría decir que 'dibujamos'
				// la posición de la imagen en el marco.
				marco.invalidate();
				return true;
			}
		});*/

		brazalete.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				final int iX = (int) event.getX();
				final int iY = (int) event.getY();
		
				// Dependiendo de la accion recogida..
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				case MotionEvent.ACTION_DOWN:
					brazalete.setImageBitmap(fondoBrazaleteSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoBrazalete.getPixel(iX, iY);
					} catch (IllegalArgumentException e) {
					}
					if (color != Color.TRANSPARENT){
						RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
						xDelta = X - Params.leftMargin;
						yDelta = Y - Params.topMargin;
					}
					else
						return false;
					// Recogemos los parametros de la imagen que hemo tocado
		
					break;
				case MotionEvent.ACTION_UP:
					brazalete.setImageBitmap(fondoBrazalete);
					break;
				case MotionEvent.ACTION_MOVE:
					// Al mover el dedo vamos actualizando
					// los margenes de la imagen para
					// crear efecto de arrastrado
					RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
					layoutParams.leftMargin = X - xDelta;
					layoutParams.topMargin = Y - yDelta;
					// Qutamos un poco de margen para
					// que la imagen no se deforme
					// al llegar al final de la pantalla y pueda ir más allá
					// probar también el codigo omitiendo estas dos líneas
					layoutParams.rightMargin = -200;
					layoutParams.bottomMargin = -200;
					// le añadimos los nuevos
					// parametros para mover la imagen
					v.setLayoutParams(layoutParams);
					break;
				}
				// Se podría decir que 'dibujamos'
				// la posición de la imagen en el marco.
				marco.invalidate();
				return true;
			}
		});
/*
		gorra.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				final int iX = (int) event.getX();
				final int iY = (int) event.getY();
		
				// Dependiendo de la accion recogida..
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				case MotionEvent.ACTION_DOWN:
					//gorra.setImageBitmap(fondoGorraSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoGorra.getPixel(iX, iY);
					} catch (IllegalArgumentException e) {
					}
					if (color != Color.TRANSPARENT){
						RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
						xDelta = X - Params.leftMargin;
						yDelta = Y - Params.topMargin;
					}
					else
						return false;
					// Recogemos los parametros de la imagen que hemo tocado
		
					break;
				case MotionEvent.ACTION_UP:
					gorra.setImageBitmap(fondoGorra);
					break;
				case MotionEvent.ACTION_MOVE:
					// Al mover el dedo vamos actualizando
					// los margenes de la imagen para
					// crear efecto de arrastrado
					RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
					layoutParams.leftMargin = X - xDelta;
					layoutParams.topMargin = Y - yDelta;
					// Qutamos un poco de margen para
					// que la imagen no se deforme
					// al llegar al final de la pantalla y pueda ir más allá
					// probar también el codigo omitiendo estas dos líneas
					layoutParams.rightMargin = -200;
					layoutParams.bottomMargin = -200;
					// le añadimos los nuevos
					// parametros para mover la imagen
					v.setLayoutParams(layoutParams);
					break;
				}
				// Se podría decir que 'dibujamos'
				// la posición de la imagen en el marco.
				marco.invalidate();
				return true;
			}
		});
/*
		gafa.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				final int iX = (int) event.getX();
				final int iY = (int) event.getY();
		
				// Dependiendo de la accion recogida..
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				case MotionEvent.ACTION_DOWN:
					gafa.setImageBitmap(fondoGafaSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoGafa.getPixel(iX, iY);
					} catch (IllegalArgumentException e) {
					}
					if (color != Color.TRANSPARENT){
						RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
						xDelta = X - Params.leftMargin;
						yDelta = Y - Params.topMargin;
					}
					else
						return false;
					// Recogemos los parametros de la imagen que hemo tocado
		
					break;
				case MotionEvent.ACTION_UP:
					gafa.setImageBitmap(fondoGafa);
					break;
				case MotionEvent.ACTION_MOVE:
					// Al mover el dedo vamos actualizando
					// los margenes de la imagen para
					// crear efecto de arrastrado
					RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
					layoutParams.leftMargin = X - xDelta;
					layoutParams.topMargin = Y - yDelta;
					// Qutamos un poco de margen para
					// que la imagen no se deforme
					// al llegar al final de la pantalla y pueda ir más allá
					// probar también el codigo omitiendo estas dos líneas
					layoutParams.rightMargin = -200;
					layoutParams.bottomMargin = -200;
					// le añadimos los nuevos
					// parametros para mover la imagen
					v.setLayoutParams(layoutParams);
					break;
				}
				// Se podría decir que 'dibujamos'
				// la posición de la imagen en el marco.
				marco.invalidate();
				return true;
			}
		});*/

	}
}
