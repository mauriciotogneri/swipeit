package com.mauriciotogneri.swipeit.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import android.graphics.Color;
import android.opengl.GLES20;

public class Shape
{
	private final int mode;
	protected final int color;
	protected FloatBuffer vertexData;
	private int length = 0;

	protected static final int POSITION_COMPONENT_COUNT = 2;

	protected static final int BYTES_PER_FLOAT = 4;

	protected static final int STRIDE = Shape.POSITION_COMPONENT_COUNT * Shape.BYTES_PER_FLOAT;

	public Shape(int mode, int color)
	{
		this.mode = mode;
		this.color = color;
	}
	
	protected void setVertices(float[] vertices)
	{
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * Shape.BYTES_PER_FLOAT);
		byteBuffer.order(ByteOrder.nativeOrder());
		this.vertexData = byteBuffer.asFloatBuffer();
		this.vertexData.put(vertices);
		
		this.length = (vertices.length / 2);
	}

	public void draw(int positionLocation, int colorLocation)
	{
		this.vertexData.position(0);
		GLES20.glVertexAttribPointer(positionLocation, Shape.POSITION_COMPONENT_COUNT, GLES20.GL_FLOAT, false, Shape.STRIDE, this.vertexData);
		GLES20.glEnableVertexAttribArray(positionLocation);

		float red = Color.red(this.color) / 255f;
		float green = Color.green(this.color) / 255f;
		float blue = Color.blue(this.color) / 255f;

		GLES20.glUniform4f(colorLocation, red, green, blue, 1);

		GLES20.glDrawArrays(this.mode, 0, this.length);
	}
}