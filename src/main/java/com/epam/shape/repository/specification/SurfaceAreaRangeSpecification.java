package com.epam.shape.repository.specification;

import com.epam.shape.logic.TetrahedronCalculator;
import com.epam.shape.observer.TetrahedronObservable;

public class SurfaceAreaRangeSpecification implements Specification {
	private final double surfaceAreaMin;
	private final double surfaceAreaMax;
	private final TetrahedronCalculator tetrahedronCalculator;

	public SurfaceAreaRangeSpecification(final double surfaceAreaMin, final double surfaceAreaMax,
			TetrahedronCalculator tetrahedronCalculator) {
		this.surfaceAreaMin = surfaceAreaMin;
		this.surfaceAreaMax = surfaceAreaMax;
		this.tetrahedronCalculator = tetrahedronCalculator;
	}

	@Override
	public boolean specified(TetrahedronObservable tetrahedron) {
		double surfaceArea = tetrahedronCalculator.calculateSurfaceArea(tetrahedron);
		return surfaceArea > surfaceAreaMin && surfaceAreaMin < surfaceAreaMax;
	}

}
