class Solution {
    public String[] findWords(String[] words) {
        String row1 ="qwertyuiop";
        String row2 ="asdfghjkl";
        String row3 ="zxcvbnm";
    List<String> res = new ArrayList<>();
        for (String word : words) {
            String w = word.toLowerCase();
    String row = row1.indexOf(w.charAt(0)) != -1 ? row1 :row2.indexOf(w.charAt(0))!= -1?row2 : row3;
            boolean valid = true;
            for (char c : w.toCharArray()) {
                if (row.indexOf(c) == -1) {
                    valid = false;
                    break;
                }}
            if (valid) {
                res.add(word);
            }}
        return res.toArray(new String[0]);
    }
}