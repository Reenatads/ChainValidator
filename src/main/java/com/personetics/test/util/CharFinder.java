package com.personetics.test.util;

import java.util.Set;

/**
 * A validator for characters. This class checks if a given character is present in a set of valid
 * characters.
 *
 * @author Renata dos Santos
 */
public class CharFinder implements Finder<Character> {

  /**
   * Checks if the given character value is present in the set of valid characters.
   *
   * @param value the character value to validate
   * @param validSet the set of valid characters
   * @return true if the character is valid, false otherwise
   */
  @Override
  public boolean find(Character value, Set<Character> validSet) {
    return validSet != null && validSet.contains(value);
  }
}
