package com.epam.shape.logic;

import com.epam.shape.entity.Point;

public class TetrahedronValidator {
	public boolean isObjectIsTetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
		return !(pointA.equals(pointB) || pointB.equals(pointC) || pointC.equals(pointD) || pointD.equals(pointA)
				|| pointA.equals(pointC) || pointB.equals(pointD));
	}
}
