package com.mauriciotogneri.swipeit.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.mauriciotogneri.swipeit.objects.Tile.Type;

public class Game
{
	public static final int RESOLUTION_X = 5;
	public static final int RESOLUTION_Y = 8;

	private final Renderer renderer;

	private final List<Tile> tiles = new ArrayList<Tile>();
	
	public Game(Context context, GLSurfaceView surfaceView)
	{
		this.renderer = new Renderer(context, this, surfaceView);

		Random random = new Random();

		for (int i = 0; i < Game.RESOLUTION_X; i++)
		{
			for (int j = 0; j < Game.RESOLUTION_Y; j++)
			{
				Tile tile = createTile(Type.values()[random.nextInt(Type.values().length)], i, j);
				this.tiles.add(tile);
			}
		}
	}

	public Renderer getRenderer()
	{
		return this.renderer;
	}

	public void onTap(float x, float y)
	{
		for (Tile tile : this.tiles)
		{
			if (tile.isInside(x, y) && tile.isType(Type.UP))
			{
				this.tiles.remove(tile);
				break;
			}
		}
	}
	
	public void onSwipeUp(float x, float y)
	{
		for (Tile tile : this.tiles)
		{
			if (tile.isInside(x, y) && tile.isType(Type.UP))
			{
				this.tiles.remove(tile);
				break;
			}
		}
	}
	
	public void onSwipeDown(float x, float y)
	{
		for (Tile tile : this.tiles)
		{
			if (tile.isInside(x, y) && tile.isType(Type.DOWN))
			{
				this.tiles.remove(tile);
				break;
			}
		}
	}
	
	public void onSwipeLeft(float x, float y)
	{
		for (Tile tile : this.tiles)
		{
			if (tile.isInside(x, y) && tile.isType(Type.LEFT))
			{
				this.tiles.remove(tile);
				break;
			}
		}
	}
	
	public void onSwipeRight(float x, float y)
	{
		for (Tile tile : this.tiles)
		{
			if (tile.isInside(x, y) && tile.isType(Type.RIGHT))
			{
				this.tiles.remove(tile);
				break;
			}
		}
	}
	
	private Tile createTile(Type type, int x, int y)
	{
		Tile result = null;

		switch (type)
		{
			case UP:
				result = new Tile(Type.UP, x + Tile.BLOCK_SIDE, y + Tile.BLOCK_SIDE);
				break;
			case DOWN:
				result = new Tile(Type.DOWN, x + Tile.BLOCK_SIDE, y + Tile.BLOCK_SIDE);
				break;
			case LEFT:
				result = new Tile(Type.LEFT, x + Tile.BLOCK_SIDE, y + Tile.BLOCK_SIDE);
				break;
			case RIGHT:
				result = new Tile(Type.RIGHT, x + Tile.BLOCK_SIDE, y + Tile.BLOCK_SIDE);
				break;
		}
		
		return result;
	}
	
	public void draw(int positionLocation, int colorLocation)
	{
		for (Tile tile : this.tiles)
		{
			tile.draw(positionLocation, colorLocation);
		}
	}
}