import java.util.Scanner;
public class funcoes3 {
  public static void main(String[] args) {
    int a, b;
    a = f1();
    System.out.printf("%d\n", a);
    b = f2(a);
    System.out.printf("%d\n", b);
  }
  public static int f1(){
    Scanner in = new Scanner(System.in);
    int tmp = in.nextInt();
    tmp = Math.abs(tmp);
      return tmp % 2;
  }
  public static int f2(int x){
    int r;
    switch(x){
      case 0:
        System.out.println("xpto");
        r = 10;
        break;
      case 1:
        System.out.println("abcd");
        r = 100;
        break;
      default:
        r = 0;
    }
    return r;
  }
}
