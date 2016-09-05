package com.truelocal.marsrover;

import com.truelocal.marsrover.exception.MarsRoverException;
import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarsRoverTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public MarsRoverTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MarsRoverTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws MarsRoverException
	 */
	public void testLandRoverTestdata1() throws MarsRoverException {
		String initialPosition = "1 2 N";
		String commands = "LMLMLMLMM";
		Rover.upperBoundaryCoordinates = new Coordinates(5, 5);
		String finalPos = MarsRover.landRover(initialPosition, commands, 1);
		assertEquals("1 3 N", finalPos);

	}

	public void testLandRoverTestdata2() throws MarsRoverException {
		String initialPosition = "3 3 E";
		String commands = "MMRMMRMRRM";
		Rover.upperBoundaryCoordinates = new Coordinates(5, 5);
		String finalPos = MarsRover.landRover(initialPosition, commands, 1);
		assertEquals("5 1 E", finalPos);
	}
	
	public void testLandRoverTestInvalidData() throws MarsRoverException {
		String initialPosition = "3 3 Q";
		String commands = "MMRMMRMRRM";
		Rover.upperBoundaryCoordinates = new Coordinates(5, 5);
		String finalPos = MarsRover.landRover(initialPosition, commands, 1);
		assertEquals(initialPosition, finalPos);
	}	
}
