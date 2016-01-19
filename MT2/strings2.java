import java.util.*;
public class strings2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = 0;
    String e = new String();
    String s = new String();
    System.out.printf("Texto: ");
    s = in.nextLine();
    for(int i = s.length()-1 ; i >= 0 ; i--)
    {
      char l = s.charAt(i);
      if(Character.isLetter(l)){
        e = e + l;
      }
      if(Character.isDigit(l)){
        a++;
        break;
      }
    }
    System.out.printf("%s\n", e);
    System.out.printf("%d\n", e.length());
    System.out.printf("%d\n", a);
  }
}
