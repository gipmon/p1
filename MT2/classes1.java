import java.util.Scanner;
public class classes1 {
  public static void main(String[] args) {
    Stats data;
    double x;
    data = f1();
    System.out.printf("%3.1f\n", data.x);
    System.out.printf("%d\n", data.y);
    x = f2(data);
    System.out.printf("%3.1f\n", data.x);
    System.out.printf("%d\n", data.y);
    System.out.printf("%3.1f\n", x);
  }
  public static Stats f1() {
    Scanner in = new Scanner(System.in);
    Stats i = new Stats();
    System.out.printf("x: "); i.x = in.nextDouble();
    System.out.printf("y: "); i.y = in.nextInt();
    return i;
  }
  public static double f2(Stats a) {
    double r = a.x * a.y;
    a.x = Math.pow(a.y, r);
    a.y = (int)(a.x / r);
    return r;
  }
}
class Stats{
  double x;
  int y;
}
