import java.util.Scanner;
public class arrays2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int b[] = new int[a.length];
    int d = 0, i;
    for(i = 0; i < a.length; i++) {
        d = a[i] / 10;
        if(d  % 2 == 0){
          b[i] = 0;
        }
        else{
          b[i] = 1;
        }
    }
    for(int k = 0; k < b.length; k++){
      System.out.printf("%d,", b[k]);
    }
    System.out.printf("\n");
    System.out.printf("%d", i);
  }
}
