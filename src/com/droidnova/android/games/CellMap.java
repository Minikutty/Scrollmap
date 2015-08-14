/**************************************************************************************
 * 
 * Copyright (C) 2015 Minikutty Joseph
 * 
 * [This program is licensed under the "MIT License"]
 * For license information, please refer the following link. Link is
 * https://github.com/Minikutty/Scrollmap/blob/master/COPYING
 *
 *  **************************************************************************************/

package com.droidnova.android.games;

import java.util.HashMap;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * The SurfaceView, on which we draw the map.
 */
public class CellMap extends SurfaceView implements SurfaceHolder.Callback {
	private static Bitmap bmLargeImage;
	private static Bitmap yourBitmap; 
    
	private static int displayWidth;             
    private static int displayHeight;
    
    private static int dWidth = 480;             
    private static int dHeight = 854;
	
    float[] pts = new float [400];
    public static int _xcellSize;
    public static int _ycellSize;
    
    // HashMap, first level are the rows, second level are the columns
    private HashMap<Integer, HashMap<Integer, Cell>> _mapCells = new HashMap<Integer, HashMap<Integer, Cell>>();
    private MapThread _mapThread;
    
    // variables we will use often
    private HashMap<Integer, Cell> _row;
    private Paint paint = new Paint();
    
    // map size in cells
    public static int _mapSize = 10;
    
    // Offset to the upper left corner of the map
    private int _xOffset = 0;
    private int _yOffset = 0;
    private float _angle = 0;
    private int _mode = 0;
    Random gen = new Random();
    
    // last touch point
    private float _xTouch = 0;
    private float _yTouch = 0;
    
    /**
     * Constructor, fills the map on creation.
     * 
     * @param context
     */
    public CellMap(Context context) {
        super(context);
        // if(_xOffset >= 0 && _yOffset >= 0 && _xOffset < (2500) && _yOffset < (2500))
        bmLargeImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.image00);
                
        displayWidth = bmLargeImage.getWidth();
        displayHeight = bmLargeImage.getHeight();
        _xcellSize = displayWidth/_mapSize;
        _ycellSize = displayHeight/_mapSize;
        
        int x = 0;
        int y = 0;
       
        // fill the map with cells
        int id = 0;
        for (int i = 0; i < _mapSize; i++) {
            _row = new HashMap<Integer, Cell>();
            y = i*_ycellSize;
            for (int j = 0; j < _mapSize; j++) {
            	x = j*_xcellSize;
            	yourBitmap = Bitmap.createBitmap(bmLargeImage,x,y,(_xcellSize),
                		(_ycellSize));
                _row.put(j, new Cell(id++,yourBitmap));
            }
            _mapCells.put(i, _row);
        }
        
        for (int i = 0; i < 400; i = i+2) {
        	pts[i] = i+6;
        	if(i==0)
        		pts[i+1] = dHeight/2+75;
        	else
        	{
        		float num = gen.nextFloat();
        		
        		 int sum = (int) (pts[i-1]+gen.nextInt(3));
        		if(num < 0.75 && (sum < dHeight-60))
        			pts[i+1] = sum; 
        		else
        			pts[i+1] = pts[i-1]-3;  
           	}        	
        }
        
        // register the view to the surfaceholder
        getHolder().addCallback(this);
        
        // set the thread - not yet started
        _mapThread = new MapThread(this);
        
        // secure the view is focusable
        setFocusable(true);
    }

    /**
     * Draw what we want to see.
     */
    @Override
    public void onDraw(Canvas canvas) {
        // help variables
        int x = 0;
        int y = 0;
        
        canvas.save();
        final android.graphics.Matrix matrix = canvas.getMatrix();
        
        Camera camera = new Camera();
        camera.save();
        	
        if(_mode == 2) camera.rotateX(55); //Applies a rotation transform around the X axis.
        camera.getMatrix(matrix);       
        camera.applyToCanvas(canvas);
        
        // canvas.save();
        canvas.rotate(_angle, dWidth/2, dHeight/4);
        
        for (int i = 0; i < _mapSize; i++) {
            // get the row
            _row = _mapCells.get(i);
            
            // calculate the correct y for the row
            y = i * _ycellSize - _yOffset;
            // go through the row
            for (int j = 0; j < _mapSize; j++) {
                // calculate the x coordinate for the columns
                x = j * _xcellSize - _xOffset;
                
                _row.get(j).draw(canvas, paint, x, y);
            }
        }
        canvas.restore();
        matrix.preTranslate(-dWidth/2,-dHeight/2);
        matrix.postTranslate(dWidth/2,dHeight/2);
        camera.restore();
      
        paint.setColor(Color.GREEN);               // setting the marker
        canvas.drawCircle(dWidth/2-10, dHeight/4, 10, paint);
        Rect rect = new Rect(0,dHeight/2,dWidth,dHeight-40);
        paint.setColor(Color.WHITE);
        canvas.drawRect(rect, paint);
        
	    paint.setColor(Color.BLUE);
	    canvas.drawLine(5, dHeight/2+10, dWidth-30, dHeight/2+10, paint);
	    canvas.drawLine(5, dHeight-20, dWidth-30, dHeight-20, paint);
	    canvas.drawLine(5, dHeight/2+10, 5, dHeight-20, paint);
	    canvas.drawLine(dWidth-30, dHeight/2+10, dWidth-30, dHeight-20, paint);
	       
	    paint.setStrokeWidth(4);
		canvas.drawLines(pts, paint);
		paint.setColor(Color.BLACK);
		paint.setTextSize(20);
		canvas.drawText("3.6 kt "+_xTouch+" degrees "+_yTouch+" degrees ", 5, dHeight/2, paint);
		float height = (pts[1]-dHeight/2)*200/ dHeight;
		canvas.drawText(""+height+" ft", 5, dHeight-40, paint); 
		        
    }
    
    /**
     * Handle touch event on the map.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if (event.getAction() == MotionEvent.ACTION_DOWN){
    		_mode = (_mode + 1)%3;
    	}
    	
    	return true;
    }
    
    public boolean onEvent(int xMove, int yMove, float angle, int shift) {
       	    	
    	if(shift==1){
    	if(xMove < 1625 && yMove < 2237) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image00);
    	}
    	else if(xMove < 1625 && yMove >= 2237 && yMove < 4474) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image01);
    	}
    	else if(xMove < 1625 && yMove >= 4474 && yMove < 6711) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image02);
    	}
    	else if(xMove < 1625 && yMove >= 6711 && yMove < 8948) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image03);
    	}
    	else if(xMove >= 1625 && xMove < 3250 && yMove < 2237) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image10);
    	}
    	else if(xMove >= 1625 && xMove < 3250 && yMove >= 2237 && yMove < 4474) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image11);
    	}
    	else if(xMove >= 1625 && xMove < 3250 && yMove >= 4474 && yMove < 6711) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image12);
    	}
    	else if(xMove >= 1625 && xMove < 3250 && yMove >= 6711 && yMove < 8948) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image13);
    	}
    	else if(xMove >= 3250 && xMove < 4875 && yMove < 2237) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image20);
    	}
    	else if(xMove >= 3250 && xMove < 4875 && yMove >= 2237 && yMove < 4474) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image21);
    	}
    	else if(xMove >= 3250 && xMove < 4875 && yMove >= 4474 && yMove < 6711) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image22);
    	}
    	else if(xMove >= 3250 && xMove < 4875 && yMove >= 6711 && yMove < 8948) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image23);
    	}
    	else if(xMove >= 4875 && xMove < 6500 && yMove < 2237) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image30);
    	}
    	else if(xMove >= 4875 && xMove < 6500 && yMove >= 2237 && yMove < 4474) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image31);
    	}
    	else if(xMove >= 4875 && xMove < 6500 && yMove >= 4474 && yMove < 6711) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image32);
    	}
    	else if(xMove >= 4875 && xMove < 6500 && yMove >= 6711 && yMove < 8948) {
    		bmLargeImage = BitmapFactory.decodeResource(getResources(),
                    R.drawable.image33);
    	}
    	   	
    		displayWidth = bmLargeImage.getWidth();
            displayHeight = bmLargeImage.getHeight();
            _xcellSize = displayWidth/_mapSize;
            _ycellSize = displayHeight/_mapSize;
            int x = 0;
            int y = 0;
            int id = 0;
            for (int i = 0; i < _mapSize; i++) {
                _row = new HashMap<Integer, Cell>();
                y = i*_ycellSize;
                for (int j = 0; j < _mapSize; j++) {
                	x = j*_xcellSize;
                	yourBitmap = Bitmap.createBitmap(bmLargeImage,x,y,(_xcellSize),
                    		(_ycellSize));
                    _row.put(j, new Cell(id++,yourBitmap));
                }
                _mapCells.put(i, _row);
            }
          }
    	
    	_xTouch = (76.7833f - (xMove/6020.00f)*0.2639f);
    	_yTouch = (34.8918f - (yMove/8094.00f)*0.2918f);
       	_xOffset = xMove%1625;
    	_yOffset = yMove%2237;
    	if(_mode != 0)
    		_angle = (angle)%360;// + angle;
    	else _angle = 0;
    	
    	int i;
    	for (i = 3; i < 400; i = i+2) {
    		pts[i-2] = pts[i];
    	}
    	float num = gen.nextFloat();
    	int sum = (int) (pts[i-2]+gen.nextInt(10));
		if(num < 0.75 && (sum < dHeight-250))
			pts[399] = sum; 
		else
			pts[399] = pts[397]-3;
        return true;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    /**
     * Called when surface created.
     * Starts the thread if not already running.
     */
    public void surfaceCreated(SurfaceHolder holder) {
        if (!_mapThread.isAlive()) {
            _mapThread = new MapThread(this);
        }
        _mapThread._run = true;
        _mapThread.start();
    }

    /**
     * Called when surface destroyed
     * Stops the thread.
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        _mapThread._run = false;
        while (retry) {
            try {
                _mapThread.join();
                retry = false;
            } catch (InterruptedException e) {
               
            }
        }
    }
}
