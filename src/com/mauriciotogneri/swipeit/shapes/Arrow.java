package com.mauriciotogneri.swipeit.shapes;

import android.opengl.GLES20;

public class Arrow extends Shape
{
	public Arrow(int color)
	{
		super(GLES20.GL_TRIANGLE_STRIP, color);
	}
}