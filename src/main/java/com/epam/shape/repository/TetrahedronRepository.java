package com.epam.shape.repository;

import java.util.Comparator;
import java.util.List;

import com.epam.shape.observer.TetrahedronObservable;
import com.epam.shape.repository.specification.Specification;

public interface TetrahedronRepository {
	public void add(TetrahedronObservable tetrahedron);

	public void remove(TetrahedronObservable tetrahedron);

	public void update(TetrahedronObservable oldTetrahedron, TetrahedronObservable newTetrahedron);

	public List<TetrahedronObservable> query(final Specification specification);

	public List<TetrahedronObservable> sort(final Comparator<TetrahedronObservable> comparator);
}
