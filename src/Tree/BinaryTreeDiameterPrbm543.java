package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import util.TreeNode;
//543 problem
public class BinaryTreeDiameterPrbm543 {

    public int diameterOfBinaryTree(TreeNode root) {
        //stack to process node
        Stack<TreeNode> processingNodeStack = new Stack<>();
        //node depth map will keep key as node and depth as value
        Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
        int diameter = 0;

        //first put the root node in the stack
        if (root != null) {
            processingNodeStack.push(root);
        }

        // while stack is not empty
        while (!processingNodeStack.isEmpty()) {
            //look into the top node from stack
            TreeNode node = processingNodeStack.peek();

            //if node has left children push them into stack
            if (node.left != null && !nodeDepthMap.containsKey(node.left)) {
                processingNodeStack.push(node.left);
            }// if node has right children push them into stack
             else if (node.right != null && !nodeDepthMap.containsKey(node.right)) {
                processingNodeStack.push(node.right);
            } else {
                processingNodeStack.pop();
                int ld = nodeDepthMap.getOrDefault(node.left, 0);
                int rd = nodeDepthMap.getOrDefault(node.right, 0);
                nodeDepthMap.put(node, 1 + Math.max(ld, rd));
                diameter = Math.max(diameter, ld + rd);
            }

        }

        return diameter;
    }

    public static void main(String[] args) {
        BinaryTreeDiameterPrbm543 solver = new BinaryTreeDiameterPrbm543();

        // Test 1: [1,2,3,4,5] → expected diameter = 3
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root1 = new TreeNode(1);
        root1.left  = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left  = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test 1: " + solver.diameterOfBinaryTree(root1)); // 3

        // Test 2: [1,2] → expected diameter = 1
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Test 2: " + solver.diameterOfBinaryTree(root2)); // 1

        // Test 3: single node → expected diameter = 0
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + solver.diameterOfBinaryTree(root3)); // 0

        // Test 4: null → expected diameter = 0
        System.out.println("Test 4: " + solver.diameterOfBinaryTree(null)); // 0

        // Test 5: linear chain 1→2→3→4 → expected diameter = 3
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.left.left = new TreeNode(4);
        System.out.println("Test 5: " + solver.diameterOfBinaryTree(root5)); // 3
    }

}
