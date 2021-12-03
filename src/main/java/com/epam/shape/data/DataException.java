package com.epam.shape.data;

import java.io.IOException;

public class DataException extends IOException {

	public DataException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
