public class backtracksubsets {
  public static void findsubsets(String s ,String ans,int i) /*Yeh function hai findsubsets()
 String s → Wo word jiska subset nikalna hai (yaha "abc")
  String ans → Ab tak ka answer (kya bana ab tak?) int i → Kis position pe ho (index number/* */
    {
      //base case
      if(i==s.length()) //Jab i number word ke last tak pahuch jaye (i == s.length()) toh ruk jao.
         {
        if(ans.length()==0) 
        {
          System.out.println("null");
        }
        else
        {
          System.out.println(ans);
        }
        return;
       } //Yes Choice
            findsubsets(s,ans+s.charAt(i),i+1); //ans + s.charAt(i) → Ab tak ke answer me wo letter add kar diya
             //No choice
             findsubsets(s, ans, i+1);
      }
    

  public static void main(String args[]) {
    String s = "xyz";
    findsubsets(s, "", 0);
}
}

