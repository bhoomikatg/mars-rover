package com.truelocal.marsrover.commands;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;
import com.truelocal.marsrover.type.DirectionType;

/**
 * Unit test for Left command.
 */
public class LeftCommandTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LeftCommandTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LeftCommandTest.class );
    }

    public void testLeftCommandDirectionE()
    {
        LeftCommand command = new LeftCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.E, c);
        command.run(r);
        assertEquals(DirectionType.N, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    public void testLeftCommandDirectionN()
    {
        LeftCommand command = new LeftCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.N, c);
        command.run(r);
        assertEquals(DirectionType.W, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
    public void testLeftCommandDirectionS()
    {
        LeftCommand command = new LeftCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.S, c);
        command.run(r);
        assertEquals(DirectionType.E, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
    public void testLeftCommandDirectionW()
    {
        LeftCommand command = new LeftCommand();
        Coordinates c = new Coordinates(1, 1);
        Rover r = new Rover(DirectionType.W, c);
        command.run(r);
        assertEquals(DirectionType.S, r.getDirection());
        assertEquals(c, r.getCoordinates());
    }
    
}
