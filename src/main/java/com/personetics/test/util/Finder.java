package com.personetics.test.util;

import java.util.Set;

/**
 * A generic interface for value validators. Implementations of this interface define validation
 * logic for a specific type.
 *
 * @param <T> the type of value to be validated
 * @author Renata dos Santos
 */
interface Finder<T> {

  /**
   * Checks if the given value is valid based on a set of criteria.
   *
   * @param value the value to validate
   * @param validSet the set of valid values or criteria for validation
   * @return true if the value is valid, false otherwise
   */
  boolean find(T value, Set<T> validSet);
}
