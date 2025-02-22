package com.personetics.test;

import com.personetics.test.model.IntegerNode;
import com.personetics.test.model.Node;
import com.personetics.test.model.StringNode;
import com.personetics.test.validator.ChainValidator;
import java.util.List;

/**
 * Main class to demonstrate node validation. This class creates lists of nodes with integer and
 * string values and validates them.
 *
 * @author Renata dos Santos
 */
public class Main {
  public static void main(String[] args) {
    // Valid chain: 36, 6, 24, 4, 47, 7, 2, 3, 27
    List<Node<?>> validIntegerNodes =
        List.of(
            new IntegerNode(36),
            new IntegerNode(6),
            new IntegerNode(24),
            new IntegerNode(4),
            new IntegerNode(47),
            new IntegerNode(7),
            new IntegerNode(2),
            new IntegerNode(3),
            new IntegerNode(27));

    // Valid chain: "p", "aba", "a", "b", "perso", "o", "r", "e", "s"
    List<Node<?>> validStringNodes =
        List.of(
            new StringNode("p"),
            new StringNode("aba"),
            new StringNode("a"),
            new StringNode("b"),
            new StringNode("perso"),
            new StringNode("o"),
            new StringNode("r"),
            new StringNode("e"),
            new StringNode("s"));

    // Not valid chain: 35, 5, 65, 6, 24, 4
    List<Node<?>> invalidIntegerNodes =
        List.of(
            new IntegerNode(35),
            new IntegerNode(5),
            new IntegerNode(65),
            new IntegerNode(6),
            new IntegerNode(24),
            new IntegerNode(4));

    // Valid mixed list: "a", 5, "s", "d",7, "asd"
    List<Node<?>> validMixedNodes =
        List.of(
            new StringNode("a"),
            new IntegerNode(5),
            new StringNode("s"),
            new StringNode("d"),
            new IntegerNode(7),
            new StringNode("asd"));

    // Invalid mixed list: "a", 5, "s", "d",7, 74
    List<Node<?>> invalidMixedNodes =
        List.of(
            new StringNode("a"),
            new IntegerNode(5),
            new StringNode("s"),
            new StringNode("d"),
            new IntegerNode(7),
            new IntegerNode(74));

    ChainValidator validator = new ChainValidator();
    System.out.println(
        "Is list {36, 6, 24, 4, 47, 7, 2, 3, 27} valid? : "
            + validator.validate(validIntegerNodes));
    System.out.println(
        "Is list {\"p\", \"aba\", \"a\", \"b\", \"perso\", \"o\", \"r\", \"e\", \"s\"} valid?: "
            + validator.validate(validStringNodes));
    System.out.println(
        "Is list {35, 5, 65, 6, 24, 4} valid?: " + validator.validate(invalidIntegerNodes));
    System.out.println(
        "Is list {\"a\", 5, \"s\", \"d\", 7, \"asd\"} valid?: "
            + validator.validate(validMixedNodes));
    System.out.println(
        "Is list {\"a\", 5, \"s\", \"d\", 7, 74} valid?: " + validator.validate(invalidMixedNodes));
  }
}
