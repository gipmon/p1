import java.util.Scanner;
public class arraysref1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a[] = {"o", "Gato", "roeu", "a", "rolha", "do", "Rei", "..."};
    int x = 0, y = 0;

    for(int i = 0; i < a.length; i++) {
      x = x + a[i].length();
      for(int j = 0 ; j < a[i].length() ; j++){
        char l = a[i].charAt(j);
        if(Character.isUpperCase(l)){
          break;
        }
        y++;
      } 
    }
    System.out.printf("%d\n", x);
    System.out.printf("%d\n", y);
  }
}
