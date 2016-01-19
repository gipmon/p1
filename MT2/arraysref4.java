import java.util.Scanner;
public class arraysref4 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Stats p[] = new Stats[3];
    double a = 0.0, b = 0.0;
    for(int i = 0; i < p.length; i++) {
      p[i] = new Stats();
      p[i].x = i * 2;
      p[i].y = i * 4;
    }
    for(int i = 0; i < p.length; i++) {
      a = a + p[i].x;
      b = b + p[i].y;
    }
    a = a / p.length;
    b = b / p.length;
    System.out.printf("%3.1f\n", a);
    System.out.printf("%3.1f\n", b);
  }
}
class Stats
{
  double x, y;
}
