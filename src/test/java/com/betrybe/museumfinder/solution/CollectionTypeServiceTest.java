package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CollectionTypeServiceTest {
  @MockBean
  MuseumFakeDatabase museumDatabase;

  @Autowired
  CollectionTypeService collectionType;
  @Test
  public void CountByCollectionTest() {
    Mockito.when(museumDatabase.countByCollectionType("historia")).thenReturn(600L);

    CollectionTypeCount result = collectionType.countByCollectionTypes("historia");

    assertEquals(1, result.collectionTypes().length);
    assertEquals(600L, result.count());

  }
}