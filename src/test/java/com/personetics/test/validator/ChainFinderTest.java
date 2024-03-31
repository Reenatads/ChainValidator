package com.personetics.test.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.personetics.test.model.Node;
import com.personetics.test.util.CharFinder;
import com.personetics.test.util.IntegerFinder;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ChainFinderTest {

  @ParameterizedTest
  @MethodSource("com.personetics.test.validator.TestDataGenerator#validateTestData")
  void testValidate(List<Node<?>> nodes, boolean expected) {
    ChainValidator validator = new ChainValidator();
    boolean result = validator.validate(nodes);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("com.personetics.test.validator.TestDataGenerator#multiLetterWordsTestData")
  void testValidateMultiLetterWords(
      Set<String> multiLetterWords, Set<Character> singleChars, boolean expected) {
    ChainValidator validator = new ChainValidator(new CharFinder(), new IntegerFinder());
    boolean result = validator.validateMultiLetterWords(multiLetterWords, singleChars);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("com.personetics.test.validator.TestDataGenerator#multiDigitNumbersTestData")
  void testValidateMultiDigitNumbers(
      Set<Integer> singleDigits, Set<Integer> validNumbers, boolean expected) {
    ChainValidator validator = new ChainValidator(new CharFinder(), new IntegerFinder());
    boolean result = validator.validateTwoDigitsNumbers(singleDigits, validNumbers);
    assertEquals(expected, result);
  }
}
