import java.util.Scanner;
public class arraysref3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double p[][] = {{2, 5}, {4, 10}, {6, 15}};
    double a = 0.0, b = 0.0;

    for(int i = 0; i < p.length; i++) {
      a = a + p[i][0];
      b = b + p[i][1];
    }
    a = a / p.length;
    b = b / p.length;
    System.out.printf("%3.1f\n", a);
    System.out.printf("%3.1f\n", b);
  }
}
