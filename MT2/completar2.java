//import static pt.ua.prog.WIO.*;
import java.util.*;
public class completar2
{
public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    int a[] = {1, 0, 3, 2, 5, 2, 7, 6, 3, 8};
    int v, idx;
    f2(a);
    System.out.printf("resultado1: ");
    for(int i = 0 ; i < a.length ; i++){
      System.out.printf("%2d,",a[i]);
    }
    System.out.printf("\n Um valor? ");
    v = in.nextInt();
    idx = f1(a,v);
    if(idx == -1)
      System.out.printf("resultado2: %s\n", "nada");
    else
      System.out.printf("resultado2: %d\n", idx);
  }
  public static int f1(int[] n, int x ){ 
    int p = -1;
    int i = 0, f = n.length-1, m;
    while(i <= f){
		m = (f + i) / 2;
      if(n[m] == x){
        p = m;
        break;
      }
      if(n[m] > x)
        f = m - 1;
      else
       i = m + 1;
    }
    return p;
  }
  public static void f2(int n[]){
    int tmp, t = 0;
    do{
      t = 0;
      for(int j = 0; j<n.length - 1; j++){
        if(n[j] > n[j+1])
        {
          tmp = n[j];
          n[j] = n[j+1];
          n[j+1] = tmp;
          t++;
        }}
    }while(t != 0);
  }
}
