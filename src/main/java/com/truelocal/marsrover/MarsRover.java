package com.truelocal.marsrover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.truelocal.marsrover.exception.ErrorCodes;
import com.truelocal.marsrover.exception.MarsRoverException;
import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;
import com.truelocal.marsrover.type.DirectionType;

public class MarsRover {
	private static final String REGEX_SPACE_SPLITTER = "\\s+";

	public static void main(String[] args) throws MarsRoverException {
		// read from input file and store all non-empty lines in a list
		InputStream is = MarsRover.class.getResourceAsStream("/inputs.txt");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			List<String> inputs = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					inputs.add(line);
				}
			}
			if (!inputs.isEmpty()) {
				initializePlateauUpperRightCoordinates(inputs.get(0));
				List<String> finalPositions = new ArrayList<>();

				for (int i = 1, j = 1; i < inputs.size(); i += 2, j++) {
					System.out.println("Rover " + j + " starting to explore");
					try {
						System.out.println("Initial position : " + inputs.get(i));
						System.out.println("Commands : " + inputs.get(i + 1));
						String finalPosition = landRover(inputs.get(i), inputs.get(i + 1), j);
						finalPositions.add(finalPosition);
					} catch(IndexOutOfBoundsException e){
						System.out.println("Rover "+ j + " does not have "
								+ "correct initial position or commands");
						throw new MarsRoverException(ErrorCodes.INPUT_INVALID);
					}

				}
				System.out.println("******************");
				System.out.println("Final Output");
				finalPositions.forEach(finalPosition -> System.out.println(finalPosition));
			}
		} catch (IOException e) {
			System.out.println(ErrorCodes.ERROR_READING_FILE.getErrorMessage());
			throw new MarsRoverException(ErrorCodes.ERROR_READING_FILE, e);
		}
	}

	public static String landRover(String initialPosition, String commands, int roverNum) {
		String finalPosition = initialPosition;

		String[] s = initialPosition.split(REGEX_SPACE_SPLITTER);
		try {
			DirectionType initialDirection = DirectionType
					.find(s[2]);
			if (initialDirection == null) {
				System.out
				.println("Invalid direction for rover: "+ roverNum);
			} else {
				Rover r = new Rover(initialDirection,
						new Coordinates(Integer.parseInt(s[0]),
								Integer.parseInt(s[1])));
				if (r.getCoordinates().isWithinBounds(
						Rover.lowerBoundaryCoordinates, Rover.upperBoundaryCoordinates)) {
					r.explore(commands);
					finalPosition = r.toString();
				} else {
					System.out.println("Invalid coordinates for rover: "+ roverNum);
				}
			}
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println(MessageFormat.format(
					ErrorCodes.INPUT_INVALID.getErrorMessage(), "Rover's position")
					+ " for Rover: " + roverNum);
		}
		return finalPosition;
	}

	private static void initializePlateauUpperRightCoordinates(
			String input) throws MarsRoverException {
		String[] plateauUpperRightCoordinates = input.split(
				REGEX_SPACE_SPLITTER);
		try {
			Rover.upperBoundaryCoordinates = new Coordinates(
					Integer.parseInt(plateauUpperRightCoordinates[0]),
					Integer.parseInt(plateauUpperRightCoordinates[1]));
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println(MessageFormat.format(
					ErrorCodes.INPUT_INVALID.getErrorMessage(),
					"Plateau upper-right cordinates"));
			throw new MarsRoverException(ErrorCodes.INPUT_INVALID);
		}
	}
}
