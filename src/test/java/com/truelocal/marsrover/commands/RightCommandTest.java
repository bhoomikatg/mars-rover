package com.truelocal.marsrover.commands;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;
import com.truelocal.marsrover.type.DirectionType;

/**
 * Unit test for Right command.
 */
public class RightCommandTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RightCommandTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RightCommandTest.class );
    }

    public void testRightCommandDirectionE()
    {
        RightCommand command = new RightCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.E, c);
        command.run(r);
        assertEquals(DirectionType.S, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    public void testRightCommandDirectionN()
    {
        RightCommand command = new RightCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.N, c);
        command.run(r);
        assertEquals(DirectionType.E, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
    public void testRightCommandDirectionS()
    {
        RightCommand command = new RightCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.S, c);
        command.run(r);
        assertEquals(DirectionType.W, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
    public void testRightCommandDirectionW()
    {
        RightCommand command = new RightCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.W, c);
        command.run(r);
        assertEquals(DirectionType.N, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
}
