import java.util.ArrayList;
import java.util.List;

public class LC112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<Integer> path = new ArrayList<>();
        return dfs(root, path, targetSum);
    }

    public static boolean dfs(TreeNode node, List<Integer> path, int targetSum) {
        path.add(node.val);
        if (checkSum(path, targetSum)) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        int size = path.size();
        if (node.left != null) {
            left = dfs(node.left, path, targetSum);
            path = path.subList(0, size);
        }
        if (node.right != null) {
            right = dfs(node.right, path, targetSum);
            path = path.subList(0, size);
        }
        return left || right;
    }

    public static boolean checkSum(List<Integer> path, int targetSum) {
        int sum = 0;
        for (int num : path) {
            sum += num;
        }
        return sum == targetSum;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode treeNode = TreeNode.processTreeNode(arr);
        System.out.println(hasPathSum(treeNode, 22));
    }
}
