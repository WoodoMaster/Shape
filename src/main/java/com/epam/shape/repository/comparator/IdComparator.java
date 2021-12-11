package com.epam.shape.repository.comparator;

import java.util.Comparator;

import com.epam.shape.observer.TetrahedronObservable;

public class IdComparator implements Comparator<TetrahedronObservable> {

	@Override
	public int compare(TetrahedronObservable firstTetrahedron, TetrahedronObservable secondTetrahedron) {
		return firstTetrahedron.getId().compareTo(secondTetrahedron.getId());
	}
}
