package com.company.set;

import java.util.ArrayList;
import java.util.List;

public class TreeSet implements Comparable<Integer> {

    private TreeNode root;

    public boolean add(int element) {
        if (contains(element)) {
            return false; // Element already exists in the set
        }

        root = addElement(root, element);
        return true;
    }

    private TreeNode addElement(TreeNode current, Integer element) {
        if (current == null) {
            return new TreeNode(element);
        }

        if (element.compareTo(current.value) < 0) {
            current.prev = addElement(current.prev, element);
        } else {
            current.next = addElement(current.next, element);
        }

        return current;
    }

    public boolean remove(int element) {
        if (!contains(element)) {
            return false; // Element does not exist in the set
        }

        root = removeElement(root, element);
        return true;
    }

    private TreeNode removeElement(TreeNode current, Integer element) {
        if (current == null) {
            return null;
        }

        if (element.compareTo(current.value) < 0) {
            current.prev = removeElement(current.prev, element);
        } else if (element.compareTo(current.value) > 0) {
            current.next = removeElement(current.next, element);
        } else {
            // Case 1: No child or one child
            if (current.prev == null) {
                return current.next;
            } else if (current.next == null) {
                return current.prev;
            }

            // Case 2: Two children
            TreeNode successor = findMinNode(current.next);
            current.value = successor.value;
            current.next = removeElement(current.next, successor.value);
        }

        return current;
    }

    private TreeNode findMinNode(TreeNode current) {
        while (current.prev != null) {
            current = current.prev;
        }
        return current;
    }

    public boolean contains(int element) {
        return search(root, element) != null;
    }

    private TreeNode search(TreeNode current, Integer element) {
        if (current == null || current.value == (element)) {
            return current;
        }

        if (element.compareTo(current.value) < 0) {
            return search(current.prev, element);
        } else {
            return search(current.next, element);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return countNodes(root);
    }

    private int countNodes(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int leftCount = countNodes(current.prev);
        int rightCount = countNodes(current.next);
        return leftCount + rightCount + 1;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }

        inorder(current.prev, result);
        result.add(current.value);
        inorder(current.next, result);
    }

    @Override
    public int compareTo(Integer o) {
        if (root != null) {
            return Integer.compare(root.value, o);
        }
        return 0;
    }
}
