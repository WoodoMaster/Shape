package com.epam.shape.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TetrahedronLineValidator {
	public boolean isTetrahedronLineValid(String line) {
		Pattern pattern = Pattern.compile("^(-?[0-9]+\\.[0-9]+\s){11}-?[0-9]+\\.[0-9]+$");
		Matcher matcher = pattern.matcher(line);
		return matcher.matches();
	}
}
