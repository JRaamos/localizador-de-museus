package com.betrybe.museumfinder.exception;

/**
 * Classe de excessão.
 */
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException(String message) {
    super(message);
  }
}
