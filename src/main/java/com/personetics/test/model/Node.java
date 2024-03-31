package com.personetics.test.model;

import lombok.Getter;

/**
 * Represents a generic node holding a value of type T. This class serves as a base for specific
 * types of nodes.
 */
@Getter
public abstract class Node<T> {
  private final T value;

  public Node(T value) {
    this.value = value;
  }
}
