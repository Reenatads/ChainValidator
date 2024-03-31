package com.personetics.test.validator;

import com.personetics.test.model.IntegerNode;
import com.personetics.test.model.StringNode;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/** Provides test data for {@link ChainFinderTest}. */
public class TestDataGenerator {

  public static Stream<Object[]> multiLetterWordsTestData() {
    return Stream.of(
        new Object[] {Collections.singleton("ab"), Set.of('a', 'b'), true},
        new Object[] {Collections.singleton("ab"), Set.of('a', 'c'), false},
        new Object[] {Collections.singleton("aB"), Set.of('a', 'b'), true},
        new Object[] {Collections.singleton("aU"), Set.of('a', 'c'), false});
  }

  public static Stream<Object[]> multiDigitNumbersTestData() {
    return Stream.of(
        new Object[] {Set.of(1, 2), Collections.singleton(12), true},
        new Object[] {Set.of(2, 3), Collections.singleton(23), true},
        new Object[] {Set.of(1, 2, 3), Collections.singleton(123), true},
        new Object[] {Collections.singleton(2), Collections.singleton(24), false});
  }

  public static Stream<Object[]> validateTestData() {
    return Stream.of(
        new Object[] {
          List.of(
              new IntegerNode(3),
              new IntegerNode(1),
              new IntegerNode(2),
              new IntegerNode(413),
              new IntegerNode(4),
              new IntegerNode(7),
              new IntegerNode(9)),
          false
        },
        new Object[] {
          List.of(
              new StringNode("p"),
              new StringNode("a"),
              new StringNode("b"),
              new StringNode("o"),
              new StringNode("pS"),
              new StringNode("A"),
              new StringNode("s")),
          true
        },
        new Object[] {
          List.of(
              new IntegerNode(3),
              new IntegerNode(1),
              new IntegerNode(2),
              new IntegerNode(45),
              new IntegerNode(4)),
          false
        },
        new Object[] {
          List.of(
              new StringNode("p"),
              new StringNode("a"),
              new StringNode("b"),
              new StringNode("o"),
              new StringNode("pU"),
              new StringNode("A"),
              new StringNode("s")),
          false
        });
  }
}
