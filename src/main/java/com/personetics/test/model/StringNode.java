package com.personetics.test.model;

/** Represents a node containing a string value. This class extends the generic Node class. */
public class StringNode extends Node<String> {

  /**
   * Constructs an StringNode with the specified string value.
   *
   * @param value the string value of the node
   */
  public StringNode(String value) {
    super(value.toLowerCase());
  }
}
