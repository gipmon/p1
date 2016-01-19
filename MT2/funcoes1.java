
import java.util.Scanner;
public class funcoes1 {
  public static void main(String[] args) {
    int a, b;
    boolean c;
    a = f1();
    b = f1();
    c = f2(a, b);
    System.out.printf("%d\n", a);
    System.out.printf("%d\n", b);
    if(c){
      System.out.printf("%d\n", a + b);
    }
    else{
      System.out.printf("%d\n", a - b);
    }
  }
  public static int f1(){
    Scanner in = new Scanner(System.in);
    int tmp = in.nextInt();
    if(tmp >= 10){
      return tmp;
    }
    else if(tmp < 10 && tmp > 0){
      return tmp * 10;
    }
    else{
      return tmp * (-1);
    }
  }
  public static boolean f2(int x, int y){
    boolean r;
    if(y > x){
      r = true;
    }
    else{
      r = false;
    }
    return r;
  }
}
