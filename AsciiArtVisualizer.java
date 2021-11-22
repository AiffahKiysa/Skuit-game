package com.Ascii;

import java.util.ArrayList;

public class AsciiArtVisualizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<AsciiArtInterface> asciiArt = new ArrayList<AsciiArtInterface>();
		
		asciiArt.add(new Aiffah());
		
		for (AsciiArtInterface Art : asciiArt) {
			if (Art instanceof AsciiArtInterface) {
				Art.visualize();
			}
		}
	}

}
