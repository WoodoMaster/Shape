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
		Point pointA = tetrahedron.getPointA();
		Point pointB = tetrahedron.getPointB();
		Point pointC = tetrahedron.getPointC();
		Point pointD = tetrahedron.getPointD();
		Vector bc = vectorCreator.createVector(pointB, pointC);
		Vector bd = vectorCreator.createVector(pointB, pointD);
		Vector ab = vectorCreator.createVector(pointA, pointB);
		Vector ac = vectorCreator.createVector(pointA, pointC);
		Vector ad = vectorCreator.createVector(pointA, pointD);
		Vector productOfBcBd = vectorCalculation.productOfVectors(bc, bd);
		Vector productOfAbAc = vectorCalculation.productOfVectors(ab, ac);
		Vector productOfAcAd = vectorCalculation.productOfVectors(ac, ad);
		Vector productOfAbAd = vectorCalculation.productOfVectors(ab, ad);
		return (vectorCalculation.lengthOfVector(productOfBcBd) + vectorCalculation.lengthOfVector(productOfAbAc)
				+ vectorCalculation.lengthOfVector(productOfAcAd) + vectorCalculation.lengthOfVector(productOfAbAd))
				/ 2;
	}

	public double calculateVolume(Tetrahedron tetrahedron) {
		Point pointA = tetrahedron.getPointA();
		Vector ab = vectorCreator.createVector(pointA, tetrahedron.getPointB());
		Vector ac = vectorCreator.createVector(pointA, tetrahedron.getPointC());
		Vector ad = vectorCreator.createVector(pointA, tetrahedron.getPointD());
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
		return smallTetrahedronVolume / mainShapeVolume;
	}

	public List<Axis> whichAxisesCrossing(Tetrahedron tetrahedron) {
		Point pointA = tetrahedron.getPointA();
		Point pointB = tetrahedron.getPointB();
		Point pointC = tetrahedron.getPointC();
		Point pointD = tetrahedron.getPointD();
		List<Axis> axises = new ArrayList<>();
		if (!((pointA.getCoordinateX() > 0 && pointB.getCoordinateX() > 0 && pointC.getCoordinateX() > 0
				&& pointD.getCoordinateX() > 0)
				|| (pointA.getCoordinateX() < 0 && pointB.getCoordinateX() < 0 && pointC.getCoordinateX() < 0
						&& pointD.getCoordinateX() < 0))) {
			axises.add(Axis.OX);
		}
		if (!((pointA.getCoordinateY() > 0 && pointB.getCoordinateY() > 0 && pointC.getCoordinateY() > 0
				&& pointD.getCoordinateY() > 0)
				|| (pointA.getCoordinateY() < 0 && pointB.getCoordinateY() < 0 && pointC.getCoordinateY() < 0
						&& pointD.getCoordinateY() < 0))) {
			axises.add(Axis.OY);
		}
		if (!((pointA.getCoordinateZ() > 0 && pointB.getCoordinateZ() > 0 && pointC.getCoordinateZ() > 0
				&& pointD.getCoordinateZ() > 0)
				|| (pointA.getCoordinateZ() < 0 && pointB.getCoordinateZ() < 0 && pointC.getCoordinateZ() < 0
						&& pointD.getCoordinateZ() < 0))) {
			axises.add(Axis.OZ);
		}
		return axises;
	}

	public boolean isBaseOnAxis(Tetrahedron tetrahedron) {
		Point pointB = tetrahedron.getPointB();
		Point pointC = tetrahedron.getPointC();
		Point pointD = tetrahedron.getPointD();
		return (pointB.getCoordinateX() == 0 && pointC.getCoordinateX() == 0 && pointD.getCoordinateX() == 0)
				|| (pointB.getCoordinateY() == 0 && pointC.getCoordinateY() == 0 && pointD.getCoordinateY() == 0)
				|| (pointB.getCoordinateZ() == 0 && pointC.getCoordinateZ() == 0 && pointD.getCoordinateZ() == 0);
	}
}
