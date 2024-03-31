package com.personetics.test.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharFinderTest {
  Set<Character> validSet;
  CharFinder charFinder;

  @BeforeEach
  public void setup() {
    validSet = new HashSet<>();
    charFinder = new CharFinder();
  }

  @Test
  public void testIsValid_whenUpperCaseCharacter_thenReturnTrue() {

    validSet.add('A');
    validSet.add('B');

    assertTrue(charFinder.find('A', validSet));
    assertTrue(charFinder.find('B', validSet));
  }

  @Test
  public void testFind_whenLowerCaseCharacter_thenReturnTrue() {
    validSet.add('c');
    validSet.add('d');

    CharFinder validator = new CharFinder();
    assertTrue(validator.find('c', validSet));
    assertTrue(validator.find('d', validSet));
  }

  @Test
  public void testIsValid_whenInvalidCharacter_thenReturnFalse() {
    validSet.add('A');
    validSet.add('B');

    assertFalse(charFinder.find('C', validSet));
  }

  @Test
  public void testIsValid_whenNullSet_thenReturnFalse() {
    assertFalse(charFinder.find(null, null));
  }
}
