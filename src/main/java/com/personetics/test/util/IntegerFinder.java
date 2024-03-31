package com.personetics.test.util;

import java.util.Set;

/**
 * A validator for integers. This class checks if a given integer consists of digits present in a
 * set of valid digits.
 *
 * @author Renata dos Santos
 */
public class IntegerFinder implements Finder<Integer> {

  /**
   * Checks if the given integer value consists of digits present in the set of valid digits.
   *
   * @param value the integer value to validate
   * @param validSet the set of valid digits
   * @return true if the integer is valid, false otherwise
   */
  @Override
  public boolean find(Integer value, Set<Integer> validSet) {
    if (validSet == null) {
      return false;
    }

    String strValue = String.valueOf(value);
    for (char c : strValue.toCharArray()) {
      if (!validSet.contains(Character.getNumericValue(c))) {
        return false;
      }
    }
    return true;
  }
}
