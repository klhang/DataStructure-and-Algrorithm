class Solution {
  public List<Integer> inorderTraversal(TreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> deque = new ArrayDeque<>();

    pushLeftNodes(root, deque);

    while(!deque.isEmpty()){
      TreeNode curr = deque.removeFirst();
      res.add(curr.val);

      pushLeftNodes(curr.right);
    }

    return res;
  }

  private void pushLeftNodes(TreeNode root, Deque<TreeNode> deque){
    if (root != null) {
      deque.addFirst(root);
      root = root.left;
    }
  }
}

class Solution {
  public List<Integer> preorderTraversal(TreeNode root){
    List<Integer> res = new ArrayList<>();

    if (root = null) {
      return res;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();


    while(!deque.isEmpty()){
      TreeNode curr = deque.removeFirst();
      res.add(curr.val);

      if (curr.right != null) {
        deque.addFirst(curr.right);
      }

      if (curr.left != null) {
        deque.addFirst(curr.left);
      }
    }
  }
}
