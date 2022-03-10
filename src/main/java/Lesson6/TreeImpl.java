package Lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    private int level;
    private int levelLeft;
    private int levelRight;
    private Stack<Node> stack = new Stack<>();
    private boolean checkRight = true;

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    public int getLevelLeft() {
        return levelLeft;
    }

    public int getLevelRight() {
        return levelRight;
    }

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;

            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean add(E value) {

        NodeAndParent nodeAndParent = doFind(value);

        if (nodeAndParent.current != null) {
//            nodeAndParent.current.incRepeat();
            return false;
        }

        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<>(value);

        if (isEmpty()) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }

        size++;

        return true;
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);

        Node<E> parent = nodeAndParent.parent;
        Node<E> removed = nodeAndParent.current;

        if (removed == null) {
            return false;
        }

        if (removed.isLeaf()) {
            removeLeafNode(removed, parent);
        } else if (removed.hasOnlyOneChild()) {
            removeNodeWithOneChild(removed, parent);
        } else {
            //[1 2 3 4 5] 6 [7 8 9 10 11]
            removedNodeWithAllChildren(removed, parent);
        }

        size--;
        return true;
    }

    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        if (removed == root) {
            root = null;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() != null
                ? removed.getLeftChild()
                : removed.getRightChild();

        if (removed.isLeftChild(child.getValue())) {
            removed.setLeftChild(null);
        } else {
            removed.setRightChild(null);
        }

        if (removed == root) {
            root = child;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }
    }

    private void removedNodeWithAllChildren(Node<E> removed, Node<E> parent) {
        Node<E> successor = getSuccessor(removed);

        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
    }

    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> parent = null;
        Node<E> current = removed.getRightChild();

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removed.getRightChild() && parent != null) {
            parent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
        }
        successor.setLeftChild(removed.getLeftChild());

        return successor;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode) {
            case PRE_ORDER -> preOrder(root); //прямой
            case IN_ORDER -> inOrder(root); //центрированный
            case POST_ORDER -> postOrder(root); //обратный
        }
        System.out.println();
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    /**
     * HomeWork
     */

    public int getLevel() {
        stack.clear();
        level = 0;
        if (root.getLeftChild() != null) {
            Node<E> parent = root;
            Node<E> current = root.getLeftChild();
            stack.add(parent);
            getLevel(current, parent);
        }
        return level;
    }

    private void getLevel(Node<E> current, Node<E> parent) {
        if (current.getLeftChild() != null) {
            parent = current;
            current = current.getLeftChild();
            stack.add(parent);
            getLevel(current, parent);
        } else if (current.getRightChild() != null) {
            parent = current;
            current = current.getRightChild();
            stack.add(parent);
            getLevel(current, parent);
        } else {
            if (parent.getRightChild() != null) {
                current = parent.getRightChild();
                if (current.getRightChild() != null || current.getLeftChild() != null) {
                    getLevel(current, parent);
                } else {
                    if (checkRight) {
                        if (root.getRightChild() != null) {
                            checkRight = false;
                            levelLeft = stack.size();
                            stack.add(current);
                            level = stack.size();
                            stack.clear();
                            parent = root;
                            stack.add(parent);
                            current = root.getRightChild();
                            getLevel(current, parent);
                        }
                    } else {
                        stack.add(current);
                        levelRight = stack.size();
                        if (level <= stack.size()) {
                            level = stack.size();
                        }
                        return;
                    }
                }
            } else {

                level = stack.size();
                if (stack.size() > 2) {
                    parent = stack.peek();
                    stack.remove(stack.firstElement());
                }
                if (parent.getRightChild() != null) {
                    current = parent.getRightChild();
                    getLevel(current, parent);
                }
            }
        }
    }
}