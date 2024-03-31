package com.personetics.test.validator;

import static org.junit.jupiter.api.Assertions.*;

import com.personetics.test.model.IntegerNode;
import com.personetics.test.model.Node;
import com.personetics.test.model.StringNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeValueProcessorTest {
  NodeValueProcessor nodeValueProcessor;

  @BeforeEach
  public void setUp() {
    nodeValueProcessor = new NodeValueProcessor();
  }

  @Test
  public void testCollectValues_whenValidStringValues_thenAddToSets() {
    List<Node<?>> nodes = new ArrayList<>();
    nodes.add(new StringNode("A"));
    nodes.add(new StringNode("Apple"));

    nodeValueProcessor.collectValues(nodes);

    Set<Character> singleChars = nodeValueProcessor.getSingleChars();
    Set<String> multiLetterWords = nodeValueProcessor.getMultiLetterWords();

    assertTrue(singleChars.contains('a'));
    assertTrue(multiLetterWords.contains("apple"));
  }

  @Test
  public void testCollectValues_whenValidIntegerValues_thenAddToSets() {
    List<Node<?>> nodes = new ArrayList<>();
    nodes.add(new IntegerNode(1));
    nodes.add(new IntegerNode(10));

    nodeValueProcessor.collectValues(nodes);

    Set<Integer> singleDigits = nodeValueProcessor.getSingleDigits();
    Set<Integer> validNumbers = nodeValueProcessor.getValidNumbers();

    assertTrue(singleDigits.contains(1));
    assertTrue(validNumbers.contains(10));
  }

  @Test
  public void testClearSets_whenCalled_thenClearSets() {
    nodeValueProcessor.getSingleChars().add('A');
    nodeValueProcessor.getMultiLetterWords().add("Apple");

    nodeValueProcessor.clearSets();

    assertTrue(nodeValueProcessor.getSingleChars().isEmpty());
    assertTrue(nodeValueProcessor.getMultiLetterWords().isEmpty());
  }
}
