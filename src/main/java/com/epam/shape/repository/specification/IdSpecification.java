package com.epam.shape.repository.specification;

import java.util.UUID;

import com.epam.shape.observer.TetrahedronObservable;

public class IdSpecification implements Specification {
	private final UUID id;

	public IdSpecification(final UUID id) {
		this.id = id;
	}

	@Override
	public boolean specified(TetrahedronObservable tetrahedron) {
		return tetrahedron.getId().equals(id);
	}

}
