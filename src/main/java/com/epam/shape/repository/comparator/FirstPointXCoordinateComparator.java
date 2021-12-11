package com.epam.shape.repository.comparator;

import java.util.Comparator;

import com.epam.shape.observer.TetrahedronObservable;

public class FirstPointXCoordinateComparator implements Comparator<TetrahedronObservable> {

	@Override
	public int compare(TetrahedronObservable firstTetrahedron, TetrahedronObservable secondTetrahedron) {
		double firstCoordinate = firstTetrahedron.getPointA().getCoordinateX();
		double secondCoordinate = secondTetrahedron.getPointA().getCoordinateX();
		if (firstCoordinate > secondCoordinate) {
			return -1;
		} else if (firstCoordinate < secondCoordinate) {
			return 1;
		} else {
			return 0;
		}
	}

}
