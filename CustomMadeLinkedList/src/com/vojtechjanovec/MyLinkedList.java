package com.vojtechjanovec;

public class MyLinkedList {
    private Node startNode;

    public MyLinkedList(Node startNode) {
        this.startNode = startNode;
    }

    // add node at the end
    public Node addNode(Node node) {
        Node currentNode = startNode;
        int index = 0;
        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            index++;
        }
        currentNode.setNextNode(node);
        System.out.println("Node inserted at index "+index);
        return node;
    }
    // remove node
    public Node removeNode(Node node) {
        Node currentNode = startNode;
        while(currentNode != node && currentNode != null) {
            currentNode = currentNode.getNextNode();
        }
        if(currentNode == null) {
            return null;
        }
        currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
        currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
        return node;
    }
    // add node at index
    public Node addNodeAtIndex(int index, Node node) {
        Node currentNode = startNode;
        int currentIndex = 0;
        while(currentNode.getNextNode() != null && currentIndex == index) {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        node.setNextNode(currentNode);
        currentNode.setPreviousNode(node);
        node.setPreviousNode(currentNode.getPreviousNode());
        currentNode.getPreviousNode().setNextNode(node);
        return node;
    }

    

}
