package com.truelocal.marsrover.type;

/**
 * Enum to contain all direction types.
 * @author bgalrani
 *
 */
public enum DirectionType {
	N(0, 1),
	S(0, -1),
	E(1, 0),
	W(-1, 0);
	private int xStep;
	private int yStep;
	private DirectionType(int xStep, int yStep) {
		this.xStep = xStep;
		this.yStep = yStep;
	}
	public DirectionType getLeft() {
		switch(this) {
		case N:
			return W;
		case W:
			return S;
		case S:
			return E;
		case E:
			return N;
		}
		return null;
	}
	public DirectionType getRight() {
		switch(this) {
		case N:
			return E;
		case W:
			return N;
		case S:
			return W;
		case E:
			return S;
		}
		return null;
	}
	public int getXstep() {
		return xStep;
	}
	public void setXstep(int xStep) {
		this.xStep = xStep;
	}
	public int getYstep() {
		return yStep;
	}
	public void setYstep(int yStep) {
		this.yStep = yStep;
	}
	
	public static DirectionType find(String s) {
		for(DirectionType value : DirectionType.values()) {
			if (value.name().equalsIgnoreCase(s)) {
				return value;
			}
		}
		return null;
	}
}
