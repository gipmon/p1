import java.util.Scanner;
public class arrays3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a[] = {5, 10, 15, 20, 25};
    int b[] = new int[a.length];
    int d = 0;
    for(int i = 1; i < a.length; i++) {
      b[i] = b[i-1] + a[i];
    }
    for(int i = 0; i < b.length; i++) {
      d = d + b[i];
    }
    for(int i = 0; i < b.length; i++){
      System.out.printf("%d,", b[i]);
    }
    System.out.printf("\n");
    System.out.printf("%d", d);
  }
}
