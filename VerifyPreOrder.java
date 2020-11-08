class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0)return true;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(preorder[0]);
        for(int i = 1;i<preorder.length;i++){
            int val = preorder[i];
            if(val < max){
                return false;
            }
            if(val < stack.peek()){
                stack.push(val);
            }else{
                while(stack.size() > 0 && val > stack.peek()){
                    max = Math.max(max,stack.pop());
                }
                stack.push(val);
            }
        }
        return true;
    }
}
