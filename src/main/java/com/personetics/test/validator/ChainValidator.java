package com.personetics.test.validator;

import com.personetics.test.model.Node;
import com.personetics.test.util.CharFinder;
import com.personetics.test.util.IntegerFinder;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Validates a list of nodes based on certain criteria. This class provides methods to validate
 * nodes containing different types of values.
 */
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ChainValidator {
  private final CharFinder charFinder;
  private final IntegerFinder integerFinder;

  /**
   * Validates a list of nodes against multiple criteria. This method collects values from nodes and
   * performs validation.
   *
   * @param nodes the list of nodes to validate
   * @return true if all validation criteria are met, false otherwise
   */
  public boolean validate(List<Node<?>> nodes) {
    try {
      NodeValueProcessor.collectValues(nodes);
    } catch (IllegalArgumentException e) {
      return false;
    }
    return validateMultiLetterWords(
            NodeValueProcessor.getMultiLetterWords(), NodeValueProcessor.getSingleChars())
        && validateTwoDigitsNumbers(
            NodeValueProcessor.getSingleDigits(), NodeValueProcessor.getValidNumbers());
  }

  /**
   * Validates multi-letter words extracted from node values. This method checks if each character
   * in multi-letter words is valid.
   *
   * @param multiLetterWords the set of multi-letter words to validate
   * @param singleChars the set of single characters considered valid
   * @return true if all characters in multi-letter words are valid, false otherwise
   */
  public boolean validateMultiLetterWords(
      Set<String> multiLetterWords, Set<Character> singleChars) {
    return multiLetterWords.stream()
        .allMatch(word -> word.toLowerCase().chars().allMatch(c -> singleChars.contains((char) c)));
  }

  /**
   * Validates multi-digit numbers extracted from node values. This method checks if each digit in
   * multi-digit numbers is valid.
   *
   * @param singleDigits the set of single digits considered valid
   * @param validNumbers the set of multi-digit numbers to validate
   * @return true if all digits in multi-digit numbers are valid, false otherwise
   */
  public boolean validateTwoDigitsNumbers(Set<Integer> singleDigits, Set<Integer> validNumbers) {
    IntegerFinder integerFinder = new IntegerFinder();
    for (int number : validNumbers) {
      if (!integerFinder.find(number, singleDigits)) {
        return false;
      }
    }
    return true;
  }
}
