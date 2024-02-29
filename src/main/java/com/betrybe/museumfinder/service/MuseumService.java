package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * service De Museeum.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumDatabase;

  @Autowired
  public MuseumService(MuseumFakeDatabase museumDatabase) {
    this.museumDatabase = museumDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException("As coordenadas fornecidas não são válidas.");
    }

    Optional<Museum> closestMuseum = museumDatabase.getClosestMuseum(coordinate, maxDistance);

    if (closestMuseum.isEmpty()) {
      throw new MuseumNotFoundException("Nenhum museu foi encontrado dentro"
          + " da distância especificada.");
    }
    return closestMuseum.get();

  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException("As coordenadas fornecidas não são válidas.");
    }

    return museumDatabase.saveMuseum(museum);
  }
}
