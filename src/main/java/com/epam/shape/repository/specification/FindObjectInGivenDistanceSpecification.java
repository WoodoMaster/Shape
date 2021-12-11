package com.epam.shape.repository.specification;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Vector;
import com.epam.shape.logic.VectorCalculator;
import com.epam.shape.logic.VectorCreator;
import com.epam.shape.observer.TetrahedronObservable;

public class FindObjectInGivenDistanceSpecification implements Specification {
	private final static Point START_POINT = new Point(0, 0, 0);
	private final double distance;
	private final VectorCalculator vectorCalculator;
	private final VectorCreator vectorCreator;

	public FindObjectInGivenDistanceSpecification(final double distance, VectorCreator vectorCreator,
			VectorCalculator vectorCalculator) {
		this.distance = distance;
		this.vectorCalculator = vectorCalculator;
		this.vectorCreator = vectorCreator;
	}

	@Override
	public boolean specified(TetrahedronObservable tetrahedron) {
		Vector originA = vectorCreator.createVector(START_POINT, tetrahedron.getPointA());
		Vector originB = vectorCreator.createVector(START_POINT, tetrahedron.getPointB());
		Vector originC = vectorCreator.createVector(START_POINT, tetrahedron.getPointC());
		Vector originD = vectorCreator.createVector(START_POINT, tetrahedron.getPointD());
		double distanceOriginA = vectorCalculator.lengthOfVector(originA);
		double distanceOriginB = vectorCalculator.lengthOfVector(originB);
		double distanceOriginC = vectorCalculator.lengthOfVector(originC);
		double distanceOriginD = vectorCalculator.lengthOfVector(originD);
		return distanceOriginA > distance && distanceOriginB > distance && distanceOriginC > distance
				&& distanceOriginD > distance;
	}
}
