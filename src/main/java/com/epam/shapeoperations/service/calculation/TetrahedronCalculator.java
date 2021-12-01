package com.epam.shapeoperations.service.calculation;

import java.util.ArrayList;
import java.util.List;

import com.epam.shapeoperations.entity.Axis;
import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;
import com.epam.shapeoperations.entity.Vector;
import com.epam.shapeoperations.service.creation.VectorCreator;

public class TetrahedronCalculator {
	private final VectorCalculator vectorCalculation = new VectorCalculator();
	private final VectorCreator vectorCreator = new VectorCreator();

	public double calculateSurfaceArea(Tetrahedron tetrahedron) {
		Vector bc = vectorCreator.createVector(tetrahedron.getDotB(), tetrahedron.getDotC());
		Vector bd = vectorCreator.createVector(tetrahedron.getDotB(), tetrahedron.getDotD());
		Vector ab = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotB());
		Vector ac = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotC());
		Vector ad = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotD());
		Vector productOfBcBd = vectorCalculation.productOfVectors(bc, bd);
		Vector productOfAbAc = vectorCalculation.productOfVectors(ab, ac);
		Vector productOfAcAd = vectorCalculation.productOfVectors(ac, ad);
		Vector productOfAbAd = vectorCalculation.productOfVectors(ab, ad);
		return (vectorCalculation.lengthOfVector(productOfBcBd) + vectorCalculation.lengthOfVector(productOfAbAc)
				+ vectorCalculation.lengthOfVector(productOfAcAd) + vectorCalculation.lengthOfVector(productOfAbAd))
				/ 2;
	}

	public double calculateVolume(Tetrahedron tetrahedron) {
		Vector ab = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotB());
		Vector ac = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotC());
		Vector ad = vectorCreator.createVector(tetrahedron.getDotA(), tetrahedron.getDotD());
		double[][] vectorMatrix = new double[3][3];
		vectorMatrix[0][0] = ab.getCoordinateX();
		vectorMatrix[0][1] = ab.getCoordinateY();
		vectorMatrix[0][2] = ab.getCoordinateZ();
		vectorMatrix[1][0] = ac.getCoordinateX();
		vectorMatrix[1][1] = ac.getCoordinateY();
		vectorMatrix[1][2] = ac.getCoordinateZ();
		vectorMatrix[2][0] = ad.getCoordinateX();
		vectorMatrix[2][1] = ad.getCoordinateY();
		vectorMatrix[2][2] = ad.getCoordinateZ();
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

	public double calculateVolumeRatio(Tetrahedron tetrahedron, Dot fristDot, Dot secondDot, Dot thirdDot, Axis axis) {
		switch (axis) {
		case OX:
			Tetrahedron smallTetrahedronOX = new Tetrahedron(fristDot, secondDot, thirdDot, tetrahedron.getDotB());
			return calculateVolumeRatioHelper(tetrahedron, smallTetrahedronOX);
		case OY:
			Tetrahedron smallTetrahedronOY = new Tetrahedron(fristDot, secondDot, thirdDot, tetrahedron.getDotC());
			return calculateVolumeRatioHelper(tetrahedron, smallTetrahedronOY);
		case OZ:
			Tetrahedron smallTetrahedronOZ = new Tetrahedron(tetrahedron.getDotA(), fristDot, secondDot, thirdDot);
			return calculateVolumeRatioHelper(tetrahedron, smallTetrahedronOZ);
		}
		return 0;
	}

	private double calculateVolumeRatioHelper(Tetrahedron tetrahedron, Tetrahedron smallTetrahedron) {
		double smallTetrahedronVolume = calculateVolume(smallTetrahedron);
		double mainShapeVolume = calculateVolume(tetrahedron) - smallTetrahedronVolume;
		return smallTetrahedronVolume / mainShapeVolume;
	}
}
