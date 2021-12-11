package com.epam.shape.repository.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.epam.shape.observer.TetrahedronObservable;

public class NameComparator implements Comparator<TetrahedronObservable> {

	@Override
	public int compare(TetrahedronObservable firstTetrahedron, TetrahedronObservable secondTetrahedron) {
		String firstTetrahedronName = firstTetrahedron.getName();
		String secondTetrahedronName = secondTetrahedron.getName();
		List<String> names = Arrays.asList(firstTetrahedronName, secondTetrahedronName);
		Collections.sort(names);
		if (names.get(0).equals(firstTetrahedronName)) {
			return -1;
		} else if (names.get(0).equals(secondTetrahedronName)) {
			return 1;
		} else {
			return 0;
		}
	}

}
