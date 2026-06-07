public class Codec {
    public String serialize(TreeNode root){
        StringBuilder sb=new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
void dfs(TreeNode n,StringBuilder sb){
        if(n==null){
            sb.append("#,");
            return;
        }
        sb.append(n.val).append(",");
        dfs(n.left,sb);
        dfs(n.right,sb);
    }
public TreeNode deserialize(String data){
        String[] arr=data.split(",");
        int[] p={0};
        return dfs(arr,p);
    }
    TreeNode dfs(String[] arr,int[] p){
        if(arr[p[0]].equals("#")){
            p[0]++;
            return null;
        }
        TreeNode n= new TreeNode(Integer.parseInt(arr[p[0]++]));
        n.left=dfs(arr,p);
        n.right=dfs(arr,p);
        return n;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));