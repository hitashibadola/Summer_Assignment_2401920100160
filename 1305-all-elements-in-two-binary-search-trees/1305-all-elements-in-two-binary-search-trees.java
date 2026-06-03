/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void merge(List<Integer> a, List<Integer> b, List<Integer> c){
            int i = 0;
            int j = 0;
            while(i<a.size() && j<b.size()){
                if(a.get(i)<b.get(j)){
                    c.add(a.get(i));
                    i++;
                }
                else if(a.get(i)==b.get(j)){
                    c.add(a.get(i));
                    c.add(b.get(j));
                    i++;
                    j++;
                }
                else{
                    c.add(b.get(j));
                    j++;
                }}
            while (i < a.size()){
                c.add(a.get(i));
                i++;
            }
            // Add remaining elements of b
            while (j < b.size()) {
                c.add(b.get(j));
                j++;
            }
        }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        TreeNode curr = root1;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr) pred = pred.right;
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right== curr){
                    pred.right = null;
                    a.add(curr.val);
                    curr = curr.right;
                }
            }else{
                a.add(curr.val);
                curr = curr.right;
            }
        }
        List<Integer> b = new ArrayList<>();
        curr = root2;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr) pred = pred.right;
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right== curr){
                    pred.right = null;
                    b.add(curr.val);
                    curr = curr.right;
                }
            }else{
                b.add(curr.val);
                curr = curr.right;
            }
        }
    List<Integer> c = new ArrayList<>();
    merge(a,b,c);
    return c;
}}