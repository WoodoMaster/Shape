package com.epam.shape.logic;

import java.util.ArrayList;
import java.util.List;

import com.epam.shape.entity.Axis;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.entity.Vector;

public class TetrahedronCalculator {
	private final VectorCalculator vectorCalculation = new VectorCalculator();
	private final VectorCreator vectorCreator = new VectorCreator();

	public double calculateSurfaceArea(Tetrahedron tetrahedron) {
		Vector bc = vectorCreator.createVector(tetrahedron.getPointB(), tetrahedron.getPointC());
		Vector bd = vectorCreator.createVector(tetrahedron.getPointB(), tetrahedron.getPointD());
		Vector ab = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointB());
		Vector ac = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointC());
		Vector ad = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointD());
		Vector productOfBcBd = vectorCalculation.productOfVectors(bc, bd);
		Vector productOfAbAc = vectorCalculation.productOfVectors(ab, ac);
		Vector productOfAcAd = vectorCalculation.productOfVectors(ac, ad);
		Vector productOfAbAd = vectorCalculation.productOfVectors(ab, ad);
		return (vectorCalculation.lengthOfVector(productOfBcBd) + vectorCalculation.lengthOfVector(productOfAbAc)
				+ vectorCalculation.lengthOfVector(productOfAcAd) + vectorCalculation.lengthOfVector(productOfAbAd))
				/ 2;
	}

	public double calculateVolume(Tetrahedron tetrahedron) {
		Vector ab = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointB());
		Vector ac = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointC());
		Vector ad = vectorCreator.createVector(tetrahedron.getPointA(), tetrahedron.getPointD());
		double volume = ((ab.getCoordinateX() * ac.getCoordinateY() * ad.getCoordinateZ())
				+ (ad.getCoordinateX() * ab.getCoordinateY() * ac.getCoordinateZ())
				+ (ab.getCoordinateZ() * ac.getCoordinateX() * ad.getCoordinateY())
				- (ab.getCoordinateZ() * ac.getCoordinateY() * ad.getCoordinateX())
				- (ad.getCoordinateZ() * ab.getCoordinateY() * ac.getCoordinateX())
				- (ab.getCoordinateX() * ad.getCoordinateY() * ac.getCoordinateZ())) / 6;
		return volume > 0 ? volume : volume * -1;
	}

	public double calculateVolumeRatio(Tetrahedron tetrahedron, Point fristPoint, Point secondPoint, Point thirdPoint,
			Axis axis) {
		Tetrahedron smallTetrahedron = null;
		switch (axis) {
		case OX:
			smallTetrahedron = new Tetrahedron(fristPoint, secondPoint, thirdPoint, tetrahedron.getPointB());
			break;
		case OY:
			smallTetrahedron = new Tetrahedron(fristPoint, secondPoint, thirdPoint, tetrahedron.getPointC());
			break;
		case OZ:
			smallTetrahedron = new Tetrahedron(tetrahedron.getPointA(), fristPoint, secondPoint, thirdPoint);
			break;
		}
		double smallTetrahedronVolume = calculateVolume(smallTetrahedron);
		double mainShapeVolume = calculateVolume(tetrahedron) - smallTetrahedronVolume;
		System.out.println(smallTetrahedronVolume + " " + calculateVolume(tetrahedron));
		return smallTetrahedronVolume / mainShapeVolume;
	}

	public List<Axis> whichAxisesCrossing(Tetrahedron tetrahedron) {
		List<Axis> axises = new ArrayList<>();
		if (!((tetrahedron.getPointA().getCoordinateX() > 0 && tetrahedron.getPointB().getCoordinateX() > 0
				&& tetrahedron.getPointC().getCoordinateX() > 0 && tetrahedron.getPointD().getCoordinateX() > 0)
				|| (tetrahedron.getPointA().getCoordinateX() < 0 && tetrahedron.getPointB().getCoordinateX() < 0
						&& tetrahedron.getPointC().getCoordinateX() < 0
						&& tetrahedron.getPointD().getCoordinateX() < 0))) {
			axises.add(Axis.OX);
		}
		if (!((tetrahedron.getPointA().getCoordinateY() > 0 && tetrahedron.getPointB().getCoordinateY() > 0
				&& tetrahedron.getPointC().getCoordinateY() > 0 && tetrahedron.getPointD().getCoordinateY() > 0)
				|| (tetrahedron.getPointA().getCoordinateY() < 0 && tetrahedron.getPointB().getCoordinateY() < 0
						&& tetrahedron.getPointC().getCoordinateY() < 0
						&& tetrahedron.getPointD().getCoordinateY() < 0))) {
			axises.add(Axis.OY);
		}
		if (!((tetrahedron.getPointA().getCoordinateZ() > 0 && tetrahedron.getPointB().getCoordinateZ() > 0
				&& tetrahedron.getPointC().getCoordinateZ() > 0 && tetrahedron.getPointD().getCoordinateZ() > 0)
				|| (tetrahedron.getPointA().getCoordinateZ() < 0 && tetrahedron.getPointB().getCoordinateZ() < 0
						&& tetrahedron.getPointC().getCoordinateZ() < 0
						&& tetrahedron.getPointD().getCoordinateZ() < 0))) {
			axises.add(Axis.OZ);
		}
		return axises;
	}

	public boolean isBaseOnAxis(Tetrahedron tetrahedron) {
		return (tetrahedron.getPointB().getCoordinateX() == 0 && tetrahedron.getPointC().getCoordinateX() == 0
				&& tetrahedron.getPointD().getCoordinateX() == 0)
				|| (tetrahedron.getPointB().getCoordinateY() == 0 && tetrahedron.getPointC().getCoordinateY() == 0
						&& tetrahedron.getPointD().getCoordinateY() == 0)
				|| (tetrahedron.getPointB().getCoordinateZ() == 0 && tetrahedron.getPointC().getCoordinateZ() == 0
						&& tetrahedron.getPointD().getCoordinateZ() == 0);
	}
}
