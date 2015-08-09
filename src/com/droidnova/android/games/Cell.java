package com.droidnova.android.games;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A part of the map.
 */
public class Cell {
    public int _id = 0;
    // public int _backgroundColor = Color.GREEN;
    public Bitmap _cellimg;
    
    /**
     * Konstruktor.
     * @param id
     */
    public Cell(int id, Bitmap cellimg) {
        _id = id;
        _cellimg = cellimg;
    }

    /**
     * Draw the cell
     *  
     * @param canvas Canvas to draw on.
     * @param paint Color of the "pencil".
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public void draw(Canvas canvas, Paint paint, int x, int y) {
    	//Bitmap yourBitmap = Bitmap.createBitmap(bmLargeImage,x,y,(x+CellMap._cellSize), 
    		//	(y+CellMap._cellSize));
    	// paint.setColor(_backgroundColor);
    	//Bitmap icon = BitmapFactory.decodeResource(getResources(),
        //        R.drawable.icon);
        // canvas.drawRect(x, y, x + CellMap._cellSize, y + CellMap._cellSize, paint);
        
	    canvas.drawBitmap(_cellimg, x, y, paint);
	    //canvas.drawPath(path, paint);
        // paint.setColor(Color.BLACK);
        // canvas.drawText("" + _id, x + 1, y + 10, paint);
    }
}
