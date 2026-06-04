class Solution {
    public TreeNode build(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(root.val>val) root.left = build(root.left,val);
        else root.right = build(root.right,val);
    return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i = 0; i< preorder.length;i++){
            root = build(root,preorder[i]);
        }
        return root;
    }
}