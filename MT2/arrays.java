
import java.util.Scanner;
public class arrays{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int b[] = new int[a.length];
    int d = 0, e = 0;

    for(int i = 0; i < a.length; i++) {
        d = a[i] / 10;
        e = e + d;
        if(d  % 2 == 0){
          b[i] = d;
        }
        else{
          b[i] = a[i];
        }
    }
    for(int i = 0; i < b.length; i++){
      System.out.printf("%d,", b[i]);
    }
    System.out.printf("\n");
    System.out.printf("%d", e);
  }
}
