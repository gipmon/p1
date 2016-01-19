import java.util.Scanner;
public class completar1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a[] = {1, 0, 3, 2, 5, 2, 7, 6, 3, 8}; 
    int v, idx;
    
    System.out.print("Um valor? ");
    v = sc.nextInt();
    idx = f1(a,v);
    System.out.printf("resultado1: %d\n", idx);
	f2(a);
    System.out.printf("resultado2: ");
    
    for(int i = 0 ; i < a.length ; i++){
      System.out.printf("%2d,", a[i]);  
    }
    System.out.println();
  }
  
  public static int f1(int[] n, int x ){
    int p = 0; 
    for(int i = 0; i < n.length ; i++){
      if(n[i] == x){
        p++;
      }
    }
    return p;
  }
  
  public static void f2(int n[]){
    int tmp;
    for(int i = 0 ; i<n.length- 1 ; i++){
      for(int j = i +1; j<n.length ; j++){
        if(n[i]>n[j])
        {
          tmp = n[i];
          n[i] = n[j];
          n[j] = tmp;
        }}}
  }
}
