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

public class Nubes extends Activity{
	
	private int xDelta;
	private int yDelta;
	
	private ViewGroup marco;

	private TextView texto;
	
	private ImageView fondoArrastrar;
	private ImageView nube;
	private ImageView contento;
	private ImageView triste;
	private ImageView enfadado;
	
	private Bitmap fondoFondoArrastrar;
	private Bitmap fondoNube;
	private Bitmap fondoContento;
	private Bitmap fondoTriste;
	private Bitmap fondoEnfadado;
	
	private Bitmap fondoContentoSombra;
	private Bitmap fondoTristeSombra;
	private Bitmap fondoEnfadadoSombra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nubes);

		texto = (TextView) findViewById(R.id.texto);
		marco = (ViewGroup) findViewById(R.id.back_nubes);
		
		fondoArrastrar = (ImageView) findViewById(R.id.fondo_arrastrar_imagen);
		InputStream resourceFondoArrastrar = getResources().openRawResource(R.drawable.fondo_arrastra_nube);
		fondoFondoArrastrar = BitmapFactory.decodeStream(resourceFondoArrastrar);
		fondoArrastrar.setImageBitmap(fondoFondoArrastrar);
		
		nube = (ImageView) findViewById(R.id.una_nube);
		InputStream resourceNube = getResources().openRawResource(R.drawable.nube_juego);
		fondoNube = BitmapFactory.decodeStream(resourceNube);
		nube.setImageBitmap(fondoNube);
		
		contento = (ImageView) findViewById(R.id.ninyoContento);
		InputStream resourceContento = getResources().openRawResource(R.drawable.ninyo_contento);
		InputStream resourceContentoSombra = getResources().openRawResource(R.drawable.ninyo_contento_sombra);
		fondoContento = BitmapFactory.decodeStream(resourceContento);
		fondoContentoSombra = BitmapFactory.decodeStream(resourceContentoSombra);
		contento.setImageBitmap(fondoContento);
		
		triste = (ImageView) findViewById(R.id.ninyoTriste);
		InputStream resourceTriste = getResources().openRawResource(R.drawable.ninyo_triste);
		InputStream resourceTristeSombra = getResources().openRawResource(R.drawable.ninyo_triste_sombra);
		fondoTriste = BitmapFactory.decodeStream(resourceTriste);
		fondoTristeSombra = BitmapFactory.decodeStream(resourceTristeSombra);
		triste.setImageBitmap(fondoTriste);
		
		enfadado = (ImageView) findViewById(R.id.ninyoEnfadado);
		InputStream resourceEnfadado = getResources().openRawResource(R.drawable.ninyo_enfadado);
		InputStream resourceEnfadadoSombra = getResources().openRawResource(R.drawable.ninyo_enfadado_sombra);
		fondoEnfadado = BitmapFactory.decodeStream(resourceEnfadado);
		fondoEnfadadoSombra = BitmapFactory.decodeStream(resourceEnfadadoSombra);
		enfadado.setImageBitmap(fondoEnfadado);
		
		texto.setText("    ARRASTRA AL NIÑO ENFADADO HACIA LA NUBE    ");
		
		
		
		enfadado.setOnTouchListener(new OnTouchListener() {
			
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
					enfadado.setImageBitmap(fondoEnfadadoSombra);
					int color = Color.TRANSPARENT;
					try {
						color = fondoEnfadado.getPixel(iX, iY);
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
					enfadado.setImageBitmap(fondoEnfadado);
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
					triste.setImageBitmap(fondoTristeSombra);
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
					contento.setImageBitmap(fondoContentoSombra);
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
