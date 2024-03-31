package com.personetics.test.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerFinderTest {
  Set<Integer> validSet;
  IntegerFinder integerFinder;

  @BeforeEach
  public void setup() {
    validSet = new HashSet<>();
    integerFinder = new IntegerFinder();
  }

  @Test
  public void testFind_whenValidValue_thenReturnTrue() {
    validSet.add(1);
    validSet.add(2);
    validSet.add(3);
    assertTrue(integerFinder.find(123, validSet));
  }

  @Test
  public void testIsValid_InvalidValue() {
    validSet.add(1);
    validSet.add(2);
    validSet.add(3);
    assertFalse(integerFinder.find(456, validSet));
  }

  @Test
  public void testIsValid_NullSet() {
    assertFalse(integerFinder.find(null, null));
  }
}
