package com.truelocal.marsrover.commands;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;
import com.truelocal.marsrover.type.DirectionType;

/**
 * Unit test for Move command.
 */
public class MoveCommandTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MoveCommandTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MoveCommandTest.class );
    }

    public void testMoveCommandDirectionE()
    {
        MoveCommand command = new MoveCommand();
        Coordinates c = new Coordinates(2, 1);
        Rover.upperBoundaryCoordinates = new Coordinates(3, 3);
        Rover r = new Rover(DirectionType.E, c);
        command.run(r);
        assertEquals(DirectionType.E, r.getDirection());
        Coordinates expectedCoordinates = new Coordinates(3, 1);
        assertEquals(expectedCoordinates, r.getCoordinates());
        // run again, there should not be any change as it exceeds the
        // upper right coordinates
        command.run(r);
        assertEquals(DirectionType.E, r.getDirection());
        assertEquals(expectedCoordinates, r.getCoordinates());
    }
    public void testMoveCommandDirectionN()
    {
        MoveCommand command = new MoveCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.N, c);
        Rover.upperBoundaryCoordinates = new Coordinates(3, 3);
        command.run(r);
        assertEquals(DirectionType.N, r.getDirection());
        Coordinates expectedCoordinates = new Coordinates(1, 2);
        assertEquals(expectedCoordinates, r.getCoordinates());
    }
    
    public void testMoveCommandDirectionS()
    {
        MoveCommand command = new MoveCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.S, c);
        Rover.upperBoundaryCoordinates = new Coordinates(3, 3);
        command.run(r);
        assertEquals(DirectionType.S, r.getDirection());
        Coordinates expectedCoordinates = new Coordinates(1, 0);
        assertEquals(expectedCoordinates, r.getCoordinates());
    }
    
    public void testMoveCommandDirectionW()
    {
        MoveCommand command = new MoveCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.W, c);
        Rover.upperBoundaryCoordinates = new Coordinates(3, 3);
        command.run(r);
        assertEquals(DirectionType.W, r.getDirection());
        Coordinates expectedCoordinates = new Coordinates(0, 1);
        assertEquals(expectedCoordinates, r.getCoordinates());
    }
    
}
