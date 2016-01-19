import java.util.Scanner;
public class classes2 {
  public static void main(String[] args) {
    Stats data;
    double x;
    data = f1();
    System.out.printf("%c\n", data.x);
    System.out.printf("%d\n", data.y);
    x = f2(data);
    System.out.printf("%c\n", data.x);
    System.out.printf("%d\n", data.y);
    System.out.printf("%3.1f\n", x);
  }
  public static Stats f1() {
    Scanner in = new Scanner(System.in);
    Stats i = new Stats();
    System.out.printf("y: "); i.y = in.nextInt();
    if(i.y > 0){
      i.x = 'p';
    }
    else{
      i.x = 'n';
    }
    return i;
  }
  public static double f2(Stats a) {
    double r;
    if(a.x == 'n'){
      r = Math.abs(a.y);
      a.y = 0;
    }
    else{
      r = Math.pow(a.y, 2);
      a.y = 1;
    }
    return r;
  }
}
class Stats{
  int y;
  char x;
}
