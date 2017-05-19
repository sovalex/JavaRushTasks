package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Created by work on 14.03.2017.
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setBorderColor(this).draw();
    }

    private Shape setBorderColor(ShapeDecorator shapeDecorator){
        System.out.println("Setting border color for "+shapeDecorator.decoratedShape.getClass().getSimpleName().toUpperCase()+" to red.");
        return decoratedShape;
    }
}
