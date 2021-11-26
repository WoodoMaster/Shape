package com.epam.shapeoperations.service.calculation;

import java.util.Arrays;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Segment;
import com.epam.shapeoperations.entity.Tetrahedron;
import com.epam.shapeoperations.entity.Vector;

public class Calculator {
//	public double calculateSurfaceArea(Tetrahedron tetrahedron) {
		// Heron's formula
		// sqrt(p*(p-a)*(p-b)*(p-c))
		// where p=(a+b+c)/2
//		Segment AB = new Segment(tetrahedron.getFirstPoint(), tetrahedron.getSecondPoint());
//		double AC;
//		double AD;
//		double DC;
//		double DB;
//		double BC;
//
//		return firstSide + 1;
//
//	}

	public double calculateVolume(Tetrahedron tetrahedron) {
		//      |ABx ABy ABz|
		//V=1/6*|ACx ACy ACz|
		//      |ADx ADy ADz|
		Vector ab = new Vector(tetrahedron.getB().getX() - tetrahedron.getA().getX(),
				tetrahedron.getB().getY() - tetrahedron.getA().getY(),
				tetrahedron.getB().getZ() - tetrahedron.getA().getZ());
		Vector ac = new Vector(tetrahedron.getC().getX() - tetrahedron.getA().getX(),
				tetrahedron.getC().getY() - tetrahedron.getA().getY(),
				tetrahedron.getC().getZ() - tetrahedron.getA().getZ());
		Vector ad = new Vector(tetrahedron.getD().getX() - tetrahedron.getA().getX(),
				tetrahedron.getD().getY() - tetrahedron.getA().getY(),
				tetrahedron.getD().getZ() - tetrahedron.getA().getZ());
		double[][] vectorMatrix = new double[3][3];
		vectorMatrix[0][0] = ab.getX();
		vectorMatrix[0][1] = ab.getY();
		vectorMatrix[0][2] = ab.getZ();
		vectorMatrix[1][0] = ac.getX();
		vectorMatrix[1][1] = ac.getY();
		vectorMatrix[1][2] = ac.getZ();
		vectorMatrix[2][0] = ad.getX();
		vectorMatrix[2][1] = ad.getY();
		vectorMatrix[2][2] = ad.getZ();
		double detA = ((vectorMatrix[0][0] * vectorMatrix[1][1] * vectorMatrix[2][2])
				+ (vectorMatrix[2][0] * vectorMatrix[0][1] * vectorMatrix[1][2])
				+ (vectorMatrix[0][2] * vectorMatrix[1][0] * vectorMatrix[2][1])
				- (vectorMatrix[0][2] * vectorMatrix[1][1] * vectorMatrix[2][0])
				- (vectorMatrix[2][2] * vectorMatrix[0][1] * vectorMatrix[1][0])
				- (vectorMatrix[0][0] * vectorMatrix[2][1] * vectorMatrix[1][2])) / 6;
		if (detA < 0) {
			return detA * -1;
		}
		return detA;
	}

	public double getSegmentLength(Dot firstPoint, Dot secondPoint) {
		// sqrt((x2-x1)^2+(y2-y1)^2+(z2-z1)^2)
		return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2)
				+ Math.pow(secondPoint.getY() - firstPoint.getY(), 2)
				+ Math.pow(secondPoint.getZ() - firstPoint.getZ(), 2));
	}
}
