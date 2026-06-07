class Solution {
    TreeNode first; TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp=first.val;
        first.val =second.val;
        second.val=temp;
    }
    void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        if(prev.val>node.val){
            if(first==null)
                first=prev;
            second=node;
        }
        prev=node;
        inorder(node.right);
    }}