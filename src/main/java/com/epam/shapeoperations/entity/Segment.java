package com.epam.shapeoperations.entity;

public class Segment {
	private Dot firstPoint;
	private Dot secondPoint;
	private double length;

	public Segment(Dot firstPoint, Dot secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}

	public Dot getFirstPoint() {
		return firstPoint;
	}

	public void setFirstPoint(Dot firstPoint) {
		this.firstPoint = firstPoint;
	}

	public Dot getSecondPoint() {
		return secondPoint;
	}

	public void setSecondPoint(Dot secondPoint) {
		this.secondPoint = secondPoint;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

}
