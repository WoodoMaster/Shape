package com.epam.shape.logic;

import com.epam.shape.entity.Vector;

public class VectorCalculator {

	public Vector productOfVectors(Vector firstVector, Vector secondVector) {
		return new Vector(
				(firstVector.getCoordinateY() * secondVector.getCoordinateZ())
						- (firstVector.getCoordinateZ() * secondVector.getCoordinateY()),
				(firstVector.getCoordinateZ() * secondVector.getCoordinateX())
						- (firstVector.getCoordinateX() * secondVector.getCoordinateZ()),
				(firstVector.getCoordinateX() * secondVector.getCoordinateY())
						- (firstVector.getCoordinateY() * secondVector.getCoordinateX()));
	}

	public double lengthOfVector(Vector vector) {
		return Math.sqrt((vector.getCoordinateX() * vector.getCoordinateX())
				+ (vector.getCoordinateY() * vector.getCoordinateY())
				+ (vector.getCoordinateZ() * vector.getCoordinateZ()));
	}

}
