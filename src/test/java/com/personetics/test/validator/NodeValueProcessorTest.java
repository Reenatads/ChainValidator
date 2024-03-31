package com.personetics.test.validator;

import static org.junit.jupiter.api.Assertions.*;

import com.personetics.test.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class NodeValueProcessorTest {

  private static class TestNode<T> extends Node<T> {
    public TestNode(T value) {
      super(value);
    }
  }

  @Test
  public void testCollectValues_whenValidStringValues_thenAddToSets() {
    List<Node<?>> nodes = new ArrayList<>();
    nodes.add(new TestNode<>("A"));
    nodes.add(new TestNode<>("Apple"));

    NodeValueProcessor.collectValues(nodes);

    Set<Character> singleChars = NodeValueProcessor.getSingleChars();
    Set<String> multiLetterWords = NodeValueProcessor.getMultiLetterWords();

    assertTrue(singleChars.contains('A'));
    assertTrue(multiLetterWords.contains("Apple"));
  }

  @Test
  public void testCollectValues_whenValidIntegerValues_thenAddToSets() {
    List<Node<?>> nodes = new ArrayList<>();
    nodes.add(new TestNode<>(1));
    nodes.add(new TestNode<>(10));

    NodeValueProcessor.collectValues(nodes);

    Set<Integer> singleDigits = NodeValueProcessor.getSingleDigits();
    Set<Integer> validNumbers = NodeValueProcessor.getValidNumbers();

    assertTrue(singleDigits.contains(1));
    assertTrue(validNumbers.contains(10));
  }

  @Test
  public void testClearSets_whenCalled_thenClearSets() {
    NodeValueProcessor.getSingleChars().add('A');
    NodeValueProcessor.getMultiLetterWords().add("Apple");

    NodeValueProcessor.clearSets();

    assertTrue(NodeValueProcessor.getSingleChars().isEmpty());
    assertTrue(NodeValueProcessor.getMultiLetterWords().isEmpty());
  }
}
