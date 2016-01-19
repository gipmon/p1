import java.util.Scanner;
public class funcoes2 {
  public static void main(String[] args) {
    int a, b;
    double c;
    a = f1();
    b = f1();
    c = f2(a, b);
    System.out.printf("%d\n", a);
    System.out.printf("%d\n", b);
    System.out.printf("%3.1f\n", c);
  }
  public static int f1(){
    Scanner in = new Scanner(System.in);
    int tmp = in.nextInt();
    if(tmp < 10){
      return tmp * 10;
    }
    else{
      return tmp;
    }
  }
  public static double f2(int x, int y){
    double r;
    if(y > x){
      r = (double)y / x;
    }
    else{
      r = (double)x / y;
    }
    return r;
  }
}
