package practice.Strings;

public class longestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].length()==0) return"";
        char ans=strs[0].charAt(0);
        for (int i=1;i<strs.length;i++){
            if (strs[i].length()==0) return"";
          char curr= strs[i].charAt(0);
          if (ans!=curr) return"";
        }
        StringBuilder an= new StringBuilder();
        an.append(ans);
        int j=0,i=1;
        while(i<=200){
            if (i>=strs[0].length()) return an.toString();
            char c=strs[0].charAt(i);
            for (int a=1;a<strs.length;a++) // this is to iterate over strings array
            {
                if (i>=strs[a].length()) return an.toString();
                char curr=strs[a].charAt(i);//this gives particular indexed character of string
                if (c!=curr) return an.toString();
            }
            an.append(c);
            i++;
        }
        return an.toString();
    }
    public static void main(String[] args) {
     String[] str= {""};
        System.out.println(longestCommonPrefix(str));
    }
}
