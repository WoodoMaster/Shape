package com.epam.shapeoperations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.shapeoperations.entity.Axis;
import com.epam.shapeoperations.entity.Tetrahedron;

public class Validator {
	public List<Axis> whichAxisesCrossing(Tetrahedron tetrahedron) {
		List<Axis> axises = new ArrayList<>();
		if (!((tetrahedron.getDotA().getCoordinateX() > 0 && tetrahedron.getDotB().getCoordinateX() > 0
				&& tetrahedron.getDotC().getCoordinateX() > 0 && tetrahedron.getDotD().getCoordinateX() > 0)
				|| (tetrahedron.getDotA().getCoordinateX() < 0 && tetrahedron.getDotB().getCoordinateX() < 0
						&& tetrahedron.getDotC().getCoordinateX() < 0 && tetrahedron.getDotD().getCoordinateX() < 0))) {
			axises.add(Axis.OX);
		}
		if (!((tetrahedron.getDotA().getCoordinateY() > 0 && tetrahedron.getDotB().getCoordinateY() > 0
				&& tetrahedron.getDotC().getCoordinateY() > 0 && tetrahedron.getDotD().getCoordinateY() > 0)
				|| (tetrahedron.getDotA().getCoordinateY() < 0 && tetrahedron.getDotB().getCoordinateY() < 0
						&& tetrahedron.getDotC().getCoordinateY() < 0 && tetrahedron.getDotD().getCoordinateY() < 0))) {
			axises.add(Axis.OY);
		}
		if (!((tetrahedron.getDotA().getCoordinateZ() > 0 && tetrahedron.getDotB().getCoordinateZ() > 0
				&& tetrahedron.getDotC().getCoordinateZ() > 0 && tetrahedron.getDotD().getCoordinateZ() > 0)
				|| (tetrahedron.getDotA().getCoordinateZ() < 0 && tetrahedron.getDotB().getCoordinateZ() < 0
						&& tetrahedron.getDotC().getCoordinateZ() < 0 && tetrahedron.getDotD().getCoordinateZ() < 0))) {
			axises.add(Axis.OZ);
		}
		return axises;
	}

	public boolean isBaseOnAxis(Tetrahedron tetrahedron) {
		return (tetrahedron.getDotB().getCoordinateX() == 0 && tetrahedron.getDotC().getCoordinateX() == 0
				&& tetrahedron.getDotD().getCoordinateX() == 0)
				|| (tetrahedron.getDotB().getCoordinateY() == 0 && tetrahedron.getDotC().getCoordinateY() == 0
						&& tetrahedron.getDotD().getCoordinateY() == 0)
				|| (tetrahedron.getDotB().getCoordinateZ() == 0 && tetrahedron.getDotC().getCoordinateZ() == 0
						&& tetrahedron.getDotD().getCoordinateZ() == 0);
	}

	// TODO mochito

	public boolean isTetrahedronLineValid(String line) {
		Pattern pattern = Pattern.compile("^(-?[0-9]+\\.[0-9]+\s){11}-?[0-9]+\\.[0-9]+$");
		Matcher matcher = pattern.matcher(line);
		return matcher.matches();
	}

	public boolean isObjectIsTetrahedron(Tetrahedron tetrahedron) {
		return !(tetrahedron.getDotA().equals(tetrahedron.getDotB())
				|| tetrahedron.getDotB().equals(tetrahedron.getDotC())
				|| tetrahedron.getDotC().equals(tetrahedron.getDotD())
				|| tetrahedron.getDotD().equals(tetrahedron.getDotA())
				|| tetrahedron.getDotA().equals(tetrahedron.getDotC())
				|| tetrahedron.getDotB().equals(tetrahedron.getDotD()));
	}
}
