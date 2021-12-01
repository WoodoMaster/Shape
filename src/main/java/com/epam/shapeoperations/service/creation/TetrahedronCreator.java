package com.epam.shapeoperations.service.creation;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;

public class TetrahedronCreator {
	private static final String DELIMITER = " ";

	public Tetrahedron create(String line) {
		String[] splitLines = line.split(DELIMITER);
		Dot firstDot = new Dot(Double.parseDouble(splitLines[0]), Double.parseDouble(splitLines[1]),
				Double.parseDouble(splitLines[2]));
		Dot secondDot = new Dot(Double.parseDouble(splitLines[3]), Double.parseDouble(splitLines[4]),
				Double.parseDouble(splitLines[5]));
		Dot thirdDot = new Dot(Double.parseDouble(splitLines[6]), Double.parseDouble(splitLines[7]),
				Double.parseDouble(splitLines[8]));
		Dot fourthDot = new Dot(Double.parseDouble(splitLines[9]), Double.parseDouble(splitLines[10]),
				Double.parseDouble(splitLines[11]));
		return new Tetrahedron(firstDot, secondDot, thirdDot, fourthDot);
	}
}
