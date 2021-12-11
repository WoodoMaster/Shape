package com.epam.shape.repository.specification;

import com.epam.shape.observer.TetrahedronObservable;

public class NameSpecification implements Specification {
	private final String name;

	public NameSpecification(final String name) {
		this.name = name;
	}

	@Override
	public boolean specified(TetrahedronObservable tetrahedron) {
		return tetrahedron.getName().equals(name);
	}

}
