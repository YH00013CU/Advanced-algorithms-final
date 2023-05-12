package task5;

// Define a Node class to represent a single node in the binary tree
class Node {
    int value;       // The integer value stored in this node
    Node left;       // A reference to the left child node
    Node right;      // A reference to the right child node

    // Constructor to initialize a new Node object with the given value and null child references
    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Define a BinaryTree class to represent the entire binary tree data structure
class BinaryTree {
    Node root;       // A reference to the root node of the binary tree

    // Constructor to initialize a new BinaryTree object with the given value as the root node
    BinaryTree(int value) {
        root = new Node(value);
    }

    // Method to add a new node with the given value to the binary tree
    void add(int value) {
        root = addRecursive(root, value);   // Call a recursive helper method to traverse the tree and insert the new node
    }

    // Recursive helper method to add a new node with the given value to the binary tree
    Node addRecursive(Node current, int value) {
        // If the current node is null, create a new node with the given value
        if (current == null) {
            return new Node(value);
        }

        // If the value is less than the current node value, recursively insert it in the left subtree
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        // If the value is greater than the current node value, recursively insert it in the right subtree
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        // If the value is equal to the current node value, do not insert it (binary trees do not allow duplicates)
        else {
            return current;
        }

        return current;
    }

    // Method to traverse the binary tree in order and print the value of each node
    void traverseInOrder(Node node) {
        if (node != null) {
            // Recursively traverse the left subtree
            traverseInOrder(node.left);

            // Print the value of the current node
            System.out.print(" " + node.value);

            // Recursively traverse the right subtree
            traverseInOrder(node.right);
        }
    }
}
public static void main(String[] args) {
    // Create a new BinaryTree object with 5 as the root node value
    BinaryTree tree = new BinaryTree(5);

    // Add additional nodes to the binary tree with the add method
    tree.add(3);
    tree.add(2);
    tree.add(4);
    tree.add(7);
    tree.add(6);
    tree.add(8);

    // Traverse the binary tree in order and print the value of each node
    tree.traverseInOrder(tree.root);
}

