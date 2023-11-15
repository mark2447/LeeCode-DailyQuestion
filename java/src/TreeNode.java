import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }


    public static TreeNode processTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(treeNode);
        // 先左后右
        boolean isleft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode peek = deque.getFirst();
            if (isleft) {
                if (array[i] != null) {
                    peek.left = new TreeNode(array[i]);
                    //将左节点添加至队尾
                    deque.offer(peek.left);
                }
                isleft = false;

            } else {
                if (array[i] != null) {
                    peek.right = new TreeNode(array[i]);
                    deque.offer(peek.right);
                }
                // 删除队头第一个元素
                deque.pollFirst();
                isleft = true;
            }
        }
        return treeNode;
    }
}