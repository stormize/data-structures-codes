import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
     public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
       
       int result =check(text);
      if(result==0){
          System.out.print("Success");
      }
      else
       System.out.print(result);
        
    }
       
static int check(String text){
     Stack<Character> mystack = new Stack<Character>();
   
    Stack<Integer>mystack2=new Stack<Integer>();
     for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
               mystack.push(next);
               mystack2.push(position);
             
            }
            
            else if (next == ')' || next == ']' || next == '}') {
               if (mystack.isEmpty())
                   return position+1;
               else{
                char top = mystack.pop();
               
                 mystack2.pop();
                if((top=='(' &&next !=')')||(top=='[' &&next !=']')||(top=='{' &&next !='}') )
                    return position+1;
               
            }
            }                       
     }
     if(!mystack.isEmpty()){
         int x = mystack2.pop();
         
         return x+1 ;
     }
   return 0;
}

}
