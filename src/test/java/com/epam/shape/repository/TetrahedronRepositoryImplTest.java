package com.epam.shape.repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.observer.TetrahedronObservable;
import com.epam.shape.repository.specification.FindObjectInGivenDistanceSpecification;
import com.epam.shape.repository.specification.FirstQuadrantSpecification;
import com.epam.shape.repository.specification.IdSpecification;
import com.epam.shape.repository.specification.NameSpecification;
import com.epam.shape.repository.specification.SurfaceAreaRangeSpecification;

public class TetrahedronRepositoryImplTest {
	private final TetrahedronObservable firstTetrahedronObservable = new TetrahedronObservable(
			UUID.fromString("586d67eb-2647-4b1b-99c8-9630cc82276f"), "Petya",
			new Tetrahedron(new Point(10, 2, 5), new Point(-15, 3, 2), new Point(-15, 3, 5), new Point(-15, 2, 5)));
	private final TetrahedronObservable secondTetrahedronObservable = new TetrahedronObservable(
			UUID.fromString("766a6d22-11d0-4f6e-b0a4-4d025ea1bc22"), "Vasya",
			new Tetrahedron(new Point(11, 22, 1), new Point(7, 6, 0), new Point(3, 2, 1), new Point(4, 9, -1)));

	@Test
	public void ITSortShouldSortDataByIdWhenDataIsValid() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(secondTetrahedronObservable);
		repository.add(firstTetrahedronObservable);
		Comparator<TetrahedronObservable> idComparator = Mockito.mock(Comparator.class);
		Mockito.when(idComparator.compare(firstTetrahedronObservable, secondTetrahedronObservable)).thenReturn(-1);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(firstTetrahedronObservable,
				secondTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.sort(idComparator);

		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITSortShouldSortDataByNameWhenDataIsValid() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(secondTetrahedronObservable);
		repository.add(firstTetrahedronObservable);
		Comparator<TetrahedronObservable> nameComparator = Mockito.mock(Comparator.class);
		Mockito.when(nameComparator.compare(firstTetrahedronObservable, secondTetrahedronObservable)).thenReturn(-1);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(firstTetrahedronObservable,
				secondTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.sort(nameComparator);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITSortShouldSortDataByFirstPointXCoordinateWhenDataIsValid() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(firstTetrahedronObservable);
		repository.add(secondTetrahedronObservable);
		Comparator<TetrahedronObservable> firstPointComparator = Mockito.mock(Comparator.class);
		Mockito.when(firstPointComparator.compare(firstTetrahedronObservable, secondTetrahedronObservable))
				.thenReturn(1);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(secondTetrahedronObservable,
				firstTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.sort(firstPointComparator);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITQueryShouldReturnTetrahedronsWhenSurfaceAreaInGivenRange() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(firstTetrahedronObservable);
		repository.add(secondTetrahedronObservable);
		SurfaceAreaRangeSpecification specification = Mockito.mock(SurfaceAreaRangeSpecification.class);
		Mockito.when(specification.specified(firstTetrahedronObservable)).thenReturn(false);
		Mockito.when(specification.specified(secondTetrahedronObservable)).thenReturn(true);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(secondTetrahedronObservable);

		// when
		List<TetrahedronObservable> actualQuery = repository.query(specification);

		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITQueryShouldReturnTetrahedronWhenNameIsValid() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(firstTetrahedronObservable);
		repository.add(secondTetrahedronObservable);
		NameSpecification specification = Mockito.mock(NameSpecification.class);
		Mockito.when(specification.specified(firstTetrahedronObservable)).thenReturn(true);
		Mockito.when(specification.specified(secondTetrahedronObservable)).thenReturn(false);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(firstTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.query(specification);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITQueryShouldReturnTetrahedronWhenNameUUIDIsValid() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(firstTetrahedronObservable);
		repository.add(secondTetrahedronObservable);
		IdSpecification specification = Mockito.mock(IdSpecification.class);
		Mockito.when(specification.specified(firstTetrahedronObservable)).thenReturn(true);
		Mockito.when(specification.specified(secondTetrahedronObservable)).thenReturn(false);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(firstTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.query(specification);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITQueryShouldReturnTetrahedronWhenFirstDotIsInFirstQuadrant() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(secondTetrahedronObservable);
		repository.add(firstTetrahedronObservable);
		FirstQuadrantSpecification specification = Mockito.mock(FirstQuadrantSpecification.class);
		Mockito.when(specification.specified(secondTetrahedronObservable)).thenReturn(true);
		Mockito.when(specification.specified(firstTetrahedronObservable)).thenReturn(true);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(secondTetrahedronObservable,
				firstTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.query(specification);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void ITQueryShouldReturnTetrahedronWhenTetrahedronIsInGivenDistanceFromCoordinateOrigin() {
		// given
		final TetrahedronRepository repository = new TetrahedronRepositoryImpl();
		repository.add(firstTetrahedronObservable);
		repository.add(secondTetrahedronObservable);
		FindObjectInGivenDistanceSpecification specification = Mockito
				.mock(FindObjectInGivenDistanceSpecification.class);
		Mockito.when(specification.specified(firstTetrahedronObservable)).thenReturn(false);
		Mockito.when(specification.specified(secondTetrahedronObservable)).thenReturn(true);
		List<TetrahedronObservable> expectedQuery = Arrays.asList(secondTetrahedronObservable);
		// when
		List<TetrahedronObservable> actualQuery = repository.query(specification);
		// then
		Assert.assertEquals(expectedQuery, actualQuery);
	}
}