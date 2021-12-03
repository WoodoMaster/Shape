package com.epam.shape.entity;

public class Tetrahedron {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;

	public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Tetrahedron)) {
			return false;
		}
		Tetrahedron tetrahedron = (Tetrahedron) o;
		return this.pointA.equals(tetrahedron.getPointA()) && this.pointB.equals(tetrahedron.getPointB())
				&& this.pointC.equals(tetrahedron.getPointC()) && this.pointD.equals(tetrahedron.getPointD());
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + pointA.hashCode();
		result = 31 * result + pointB.hashCode();
		result = 31 * result + pointC.hashCode();
		result = 31 * result + pointD.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Point A: " + pointA.toString() + ", Point B: " + pointB.toString() + ", Point C: " + pointC.toString()
				+ ", Point D: " + pointD.toString();

	}
}
