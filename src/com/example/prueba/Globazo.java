package com.example.prueba;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Globazo extends Activity{
	
	private int xDelta;
	private int yDelta;
	
	private ImageView fondoGlobo;
	
	private Bitmap fondoGloboExplosion1;
	private Bitmap fondoGloboExplosion2;
	private Bitmap fondoGloboExplosion3;
	private Bitmap fondoGloboExplosion4;
	private Bitmap fondoGloboExplosion5;
	
	private Bitmap fondoGloboSombra1;
	private Bitmap fondoGloboSombra2;
	private Bitmap fondoGloboSombra3;
	private Bitmap fondoGloboSombra4;
	private Bitmap fondoGloboSombra5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.globitos);

		
		fondoGloboExplosion1 = (ImageView) findViewById(R.id.fg1);
		InputStream resourceGlobo = getResources().openRawResource(R.drawable.fondoGloboExplosion1);
		
		InputStream resourceGloboSombra = getResources().openRawResource(R.drawable.fondoGloboSombra1);
		fondoGloboExplosion1 = BitmapFactory.decodeStream(resourceGlobo);
		fondoGloboSombra1 = BitmapFactory.decodeStream(resourceGloboSombra);
		
		fondoGloboExplosion2 = (ImageView) findViewById(R.id.fg2);
		InputStream resourceGlobo2 = getResources().openRawResource(R.drawable.fondoGloboExplosion2);
		InputStream resourceGloboSombra2 = getResources().openRawResource(R.drawable.fondoGloboSombra2);
		fondoGloboExplosion2 = BitmapFactory.decodeStream(resourceGlobo2);
		fondoGloboSombra2 = BitmapFactory.decodeStream(resourceGloboSombra2);
		
		
		fondoGloboExplosion3 = (ImageView) findViewById(R.id.fg3);
		InputStream resourceGlobo3 = getResources().openRawResource(R.drawable.fondoGloboExplosion3);
		InputStream resourceGloboSombra3 = getResources().openRawResource(R.drawable.fondoGloboSombra3);
		fondoGloboExplosion3 = BitmapFactory.decodeStream(resourceGlobo3);
		fondoGloboSombra3 = BitmapFactory.decodeStream(resourceGloboSombra3);
		
		fondoGloboExplosion1 = (ImageView) findViewById(R.id.fg4);
		InputStream resourceGlobo4 = getResources().openRawResource(R.drawable.fondoGloboExplosion1);
		InputStream resourceGloboSombra4 = getResources().openRawResource(R.drawable.fondoGloboSombra1);
		fondoGloboExplosion1 = BitmapFactory.decodeStream(resourceGlobo4);
		fondoGloboSombra1 = BitmapFactory.decodeStream(resourceGloboSombra4);
				
		fondoGloboExplosion5 = (ImageView) findViewById(R.id.fg1);
		InputStream resourceGlobo5 = getResources().openRawResource(R.drawable.fondoGloboExplosion1);
		InputStream resourceGloboSombra5 = getResources().openRawResource(R.drawable.fondoGloboSombra1);
		fondoGloboExplosion5 = BitmapFactory.decodeStream(resourceGlobo5);
		fondoGloboSombra1 = BitmapFactory.decodeStream(resourceGloboSombra5);
		
		
		fondoGlobo.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int X = (int) event.getRawX();
				final int Y = (int) event.getRawY();
		
				//final int iX = (int) event.getX();
				//final int iY = (int) event.getY();
		
				// Dependiendo de la accion recogida..
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// Al tocar la pantalla
				case MotionEvent.ACTION_DOWN:
					fondoGlobo.setImageBitmap(fondoGloboExplosion1);
					int color = Color.TRANSPARENT;
					try {
						color = fondoGlobo.getPixel(iX, iY);
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
					fondoGlobo.setImageBitmap(fondoGloboE2);
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

		triste.setOnTouchListener(new OnTouchListener() {
			
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
					triste.setImageBitmap(fondoGloboSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoTriste.getPixel(iX, iY);
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
					triste.setImageBitmap(fondoTriste);
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

		contento.setOnTouchListener(new OnTouchListener() {
			
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
					contento.setImageBitmap(fondoGloboSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoContento.getPixel(iX, iY);
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
					contento.setImageBitmap(fondoContento);
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
	
	}
}
