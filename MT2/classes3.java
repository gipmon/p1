import java.util.Scanner;
public class classes3 {
  public static void main(String[] args) {
    Stats data = new Stats();
    int x;
    System.out.printf("%d\n", data.x);
    System.out.printf("%d\n", data.y);
    f1(data);
    System.out.printf("%d\n", data.x);
    System.out.printf("%d\n", data.y);
    x = f2(data);
    System.out.printf("%d\n", x);
  }
  public static void f1(Stats i) {
    Scanner in = new Scanner(System.in);
    int tmp;
    System.out.printf("x: "); i.x = in.nextInt();
    System.out.printf("y: "); i.y = in.nextInt();
    if(i.x > i.y){
     tmp = i.x;
     i.x = i.y;
     i.y = tmp;
    }
  }
  public static int f2(Stats a) {
    int r = 0;
    for(int k = a.x ; k < a.y ; k++){
      r = r + k;
    }
    return r;
  }
}
class Stats{
  int x;
  int y;
}
