class Solution {
    public TreeNode tree(int low, int high,List<Integer> arr){
        if(low>high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = tree(low,mid-1,arr);
        root.right = tree(mid+1,high,arr);
        return root;

    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        int low = 0;
        int high = arr.size();
        return tree(low,high-1,arr);
    }
}