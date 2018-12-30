class Solution {
    public String simplifyPath(String path) {
        String[] temp = path.split("/");
        Stack<String> pathing = new Stack<>();
        for(String i : temp){
            if(i.equals("")){
                continue;
            } else if(i.equals("..")){
                if(!pathing.isEmpty()){
                    pathing.pop();
                } 
            } else if(i.equals(".")){
                continue;
            } else {
                pathing.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(pathing.isEmpty()){
            return "/";
        }
        while(!pathing.isEmpty()){
            sb.insert(0,pathing.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }
}
