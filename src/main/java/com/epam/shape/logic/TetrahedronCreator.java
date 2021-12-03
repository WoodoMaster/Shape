package com.epam.shape.logic;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronCreator {
	private static final String DELIMITER = " ";
	private final TetrahedronValidator tetrahedronValidator = new TetrahedronValidator();

	public Tetrahedron create(String line) {
		String[] splitLines = line.split(DELIMITER);
		Point firstPoint = new Point(Double.parseDouble(splitLines[0]), Double.parseDouble(splitLines[1]),
				Double.parseDouble(splitLines[2]));
		Point secondPoint = new Point(Double.parseDouble(splitLines[3]), Double.parseDouble(splitLines[4]),
				Double.parseDouble(splitLines[5]));
		Point thirdPoint = new Point(Double.parseDouble(splitLines[6]), Double.parseDouble(splitLines[7]),
				Double.parseDouble(splitLines[8]));
		Point fourthPoint = new Point(Double.parseDouble(splitLines[9]), Double.parseDouble(splitLines[10]),
				Double.parseDouble(splitLines[11]));
		if (tetrahedronValidator.isObjectIsTetrahedron(firstPoint, secondPoint, thirdPoint, fourthPoint)) {
			return new Tetrahedron(firstPoint, secondPoint, thirdPoint, fourthPoint);
		} else {
			return null;
		}
	}
}
