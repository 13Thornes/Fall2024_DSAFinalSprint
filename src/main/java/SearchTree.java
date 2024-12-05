import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {
    TreeNode1 root;

    public  SearchTree() {
        this.root = null;
    }

    private TreeNode1 insert(TreeNode1 currentNode, int value) {
        if (currentNode == null) {
            TreeNode1 newNode = new TreeNode1(value);
            return newNode;

        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert (int value) {
        root = insert(root, value);
    }

    public void preOrder (TreeNode1 node) {
        if (node == null) {
            return;
        } System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
//
//    public void inOrder (Tree.TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        inOrder(node.left);
//        System.out.println(node.value + "");
//        inOrder(node.right);
//    }
//
//    public void postOrder(Tree.TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        inOrder(node.left);
//        inOrder(node.right);
//        System.out.println(node.value + "");
//    }

    public void levelOrder(TreeNode1 root) {
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode1 curr = queue.poll();

            System.out.print(curr.value + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
   }

    public TreeNode1 search(TreeNode1 root, int value) {
        if (root == null) {
            System.out.println("Value: " + value + " not found");
            return null;
        } else if (root.value == value) {
            System.out.println("Value: " + value + " found");
            return root;
        } else if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

   public static TreeNode1 minimumNode(TreeNode1 root) {
        if (root.left == null) {
            return root;
        } else  {
            return minimumNode(root.left);
        }
   }

    public static TreeNode1 maximumNode(TreeNode1 root) {
        if (root.right == null) {
            return root;
        } else  {
            return maximumNode(root.right);
        }
    }

    public TreeNode1 deleteNode(TreeNode1 root, int value) {
        if (root == null) {
            System.out.println("Value not found");
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode1 temp = root;
                TreeNode1 minforRight = minimumNode(temp.right);
                root.value = minforRight.value;
                root.right = deleteNode(root.right, minforRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    public void deleteSearchTree() {
        root = null;
        System.out.println("Tree had been deleted");
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        tree.preOrder(tree.root);
        tree.search(tree.root, 3);
    }
}
