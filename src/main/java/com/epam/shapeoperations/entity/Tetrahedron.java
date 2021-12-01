package com.epam.shapeoperations.entity;

public class Tetrahedron {
	private Dot dotA;
	private Dot dotB;
	private Dot dotC;
	private Dot dotD;
	private double surfaceArea;
	private double volume;

	public Tetrahedron(Dot dotA, Dot dotB, Dot dotC, Dot dotD) {
		this.dotA = dotA;
		this.dotB = dotB;
		this.dotC = dotC;
		this.dotD = dotD;
	}

	public Dot getDotA() {
		return dotA;
	}

	public void setDotA(Dot dotA) {
		this.dotA = dotA;
	}

	public Dot getDotB() {
		return dotB;
	}

	public void setDotB(Dot dotB) {
		this.dotB = dotB;
	}

	public Dot getDotC() {
		return dotC;
	}

	public void setDotC(Dot dotC) {
		this.dotC = dotC;
	}

	public Dot getDotD() {
		return dotD;
	}

	public void setDotD(Dot dotD) {
		this.dotD = dotD;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
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
		return this.dotA.equals(tetrahedron.getDotA()) && this.dotB.equals(tetrahedron.getDotB())
				&& this.dotC.equals(tetrahedron.getDotC()) && this.dotD.equals(tetrahedron.getDotD());
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + dotA.hashCode();
		result = 31 * result + dotB.hashCode();
		result = 31 * result + dotC.hashCode();
		result = 31 * result + dotD.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Dot A: " + dotA.toString() + ", Dot B: " + dotB.toString() + ", Dot C: " + dotC.toString() + ", Dot D: "
				+ dotD.toString();

	}
}
