import java.util.Scanner;
public class  strings{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = 0, b = 0;
    String e = new String();
    String s = new String();
    System.out.printf("Texto: ");
    s = in.nextLine();
    for(int i=0 ; i < s.length() ;i++)
    {
      char l = s.charAt(i);
      if(Character.isLowerCase(l)){
        a++;
      }
      if(Character.isDigit(l)){
        b++;
        break;
      }
      if(Character.isLetter(l)){
        e = l + e;
      }
    }
    System.out.printf("%s\n", e);
    System.out.printf("%d\n", a);
    System.out.printf("%d\n", b);
  }
}
