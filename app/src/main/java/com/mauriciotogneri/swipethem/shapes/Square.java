package com.mauriciotogneri.swipethem.shapes;

import com.mauriciotogneri.swipethem.shapes.figures.arrows.Arrow;

public class Square extends Arrow
{
    public Square(float x, float y, float width, int color)
    {
        super(color);

        float[] vertices = new float[] {x - width, y + width, //
                x - width, y - width, //
                x + width, y + width, //
                x + width, y - width};

        setVertices(vertices);
    }
}