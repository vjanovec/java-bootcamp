package com.vojtechjanovec;

public class Node {
    private int num;
    private Node previousNode;
    private Node nextNode;

    public Node(int num, Node previousNode, Node nextNode) {
        this.num = num;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
