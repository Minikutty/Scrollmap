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

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A part of the map.
 */
public class Cell {
    public int _id = 0;
    public Bitmap _cellimg;
   
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
    	       
	    canvas.drawBitmap(_cellimg, x, y, paint);
	    
    }
}
