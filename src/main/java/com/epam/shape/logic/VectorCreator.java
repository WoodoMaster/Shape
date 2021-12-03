package com.epam.shape.logic;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Vector;

public class VectorCreator {
	public Vector createVector(Point firstDot, Point secondDot) {
		return new Vector(secondDot.getCoordinateX() - firstDot.getCoordinateX(),
				secondDot.getCoordinateY() - firstDot.getCoordinateY(),
				secondDot.getCoordinateZ() - firstDot.getCoordinateZ());
	}
}
