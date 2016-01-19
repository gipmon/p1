import java.util.*;
public class arraysref2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a[] = {"o", "Gato", "Roeu", "a", "Rolha", "do", "Rei", "..."};
    int x = 0, y = 0;

    for(int i = 0; i < a.length; i++) {
      if(a[i].length() <= 3){
        continue;
      }
      x = x + a[i].length();
      for(int j = 0 ; j < a[i].length() ; j++){
        char l = a[i].charAt(j);
        if(Character.isLowerCase(l)){
          y++;
        } 
      }
    }
    System.out.printf("%d\n", x);
    System.out.printf("%d\n", y);
  }
}
