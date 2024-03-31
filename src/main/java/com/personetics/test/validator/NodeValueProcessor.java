package com.personetics.test.validator;

import com.personetics.test.model.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Processes the values stored in nodes and performs validation. This class collects values from
 * nodes and validates them against certain criteria.
 *
 * @author Renata dos Santos
 */
@Slf4j
public class NodeValueProcessor {
  @Getter(AccessLevel.PROTECTED)
  private final Set<Character> singleChars = new HashSet<>();

  @Getter(AccessLevel.PROTECTED)
  private final Set<String> multiLetterWords = new HashSet<>();

  @Getter(AccessLevel.PROTECTED)
  private final Set<Integer> singleDigits = new HashSet<>();

  @Getter(AccessLevel.PROTECTED)
  private final Set<Integer> validNumbers = new HashSet<>();

  public void collectValues(List<Node<?>> nodes) throws IllegalArgumentException {
    clearSets();
    for (Node<?> node : nodes) {
      Object value = node.getValue();
      if (value instanceof Character || value instanceof String) {
        String stringValue = String.valueOf(value);
        if (stringValue.length() == 1 || isSingleCharOrString(stringValue)) {
          singleChars.add(stringValue.charAt(0));
        } else {
          multiLetterWords.add(stringValue);
        }
      } else if (value instanceof Integer) {
        int intValue = (Integer) value;
        if (isSingleDigit(intValue)) {
          singleDigits.add(intValue);
        } else if (isTwoDigitNumber(intValue)) {
          validNumbers.add(intValue);
        } else {
          log.warn("Invalid number found: {}", intValue);
          throw new IllegalArgumentException("Invalid number found: " + intValue);
        }
      }
    }
  }

  /**
   * Checks if the given string value represents a single character or string.
   *
   * @param value the string value to check
   * @return true if the value represents a single character or string, false otherwise
   */
  private static boolean isSingleCharOrString(String value) {
    return Pattern.matches("[a-zA-Z]|.", value);
  }

  /**
   * Checks if the given integer value is a single digit.
   *
   * @param number the integer value to check
   * @return true if the value is a single digit, false otherwise
   */
  private static boolean isSingleDigit(int number) {
    return Pattern.matches("[0-9]", String.valueOf(number));
  }

  private static boolean isTwoDigitNumber(int number) {
    return number >= 10 && number <= 99;
  }

  public void clearSets() {
    singleChars.clear();
    multiLetterWords.clear();
    singleDigits.clear();
    validNumbers.clear();
  }
}
