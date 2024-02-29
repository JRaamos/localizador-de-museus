package com.betrybe.museumfinder.exception;

/**
 * MuseumNotFoundException classe.
 */
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException(String message) {
    super(message);
  }
}
