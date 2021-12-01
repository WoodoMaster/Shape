package com.epam.shapeoperations.service.creation;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Vector;

public class VectorCreator {
	public Vector createVector(Dot firstDot, Dot secondDot) {
		return new Vector(secondDot.getCoordinateX() - firstDot.getCoordinateX(),
				secondDot.getCoordinateY() - firstDot.getCoordinateY(),
				secondDot.getCoordinateZ() - firstDot.getCoordinateZ());
	}
}
