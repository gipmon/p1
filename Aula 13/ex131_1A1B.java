/* Alunos - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolucao por favor reporte para rafael.ferreira@ua.pt !
 */
import java.util.*;
import static java.lang.System.*;

public class ex131_1A1B{
	public static Scanner sc = new Scanner(System.in);

	public static void main (String args[]) {
		
		aluno Aluno[] = new aluno[20];
			
		int menu, n=0;
		
		do{
			menu=Menu();
			switch(menu){
					case 1: n = InserirTurma(Aluno);
						break;
					case 2: ProcurarAluno(Aluno, n);
						break;
					case 3: MediaFinal(Aluno, n);
						break;
					case 4: n=AlterarInf(Aluno, n);
						break;
					case 5: ListOddNmec(Aluno, n);
						break;
					case 6: ListOddNotaFinal(Aluno, n);
						break;
					case 7: MelhorAluno(Aluno, n);
						break;
			}
		}while(menu!=8);
		
	}
	public static int Menu(){
		out.println("Gestão de uma turma:");
		out.println("1 - Inserir informação de uma turma");
		out.println("2 - Mostrar informação de um aluno");
		out.println("3 - Média das notas finais");
		out.println("4 - Alterar informação de um aluno");
		out.println("5 - Listar os alunos por nº mec");
		out.println("6 - Listar os alunos ordenados por nota final");
		out.println("7 - Melhor aluno");
		out.println("8 - Terminar programa");
		out.print("Opção -> ");
		return sc.nextInt();
	}
	public static int InserirTurma(aluno[] a){
		sc.nextLine();
			
		out.println("\n--Inserir Turma--");
		
		for(int i=0; i<a.length; i++)
			a[i]=new aluno();
			
		int n=0;
		for(; n<a.length; n++){
		    
			out.println("Aluno ["+n+"]");
			out.print("N. Mec.: ");
			a[n].numeromecanografico=sc.nextInt();
			
			if(a[n].numeromecanografico!=0){
				sc.nextLine();
				out.print("Nome do aluno: ");
				a[n].nome=sc.nextLine();
				
				for(int i=0; i<4; i++){
					out.printf("Nota %d: ", i+1);
					a[n].nota[i]=sc.nextInt();
				}
				
				a[n].notafinal=a[n].nota[0]*0.1+a[n].nota[1]*0.3+a[n].nota[2]*0.1+a[n].nota[3]*0.5;
				out.printf("Nota final: %.2f \n", a[n].notafinal);
				
			}else
				break;
		
		}
		
		return n;
	}
	public static void ProcurarAluno(aluno[] a, int n){
		out.println("--Mostrar informação de um aluno--");
		out.print("Qual é o aluno que deseja procurar? n.mec: ");
		int tmp=sc.nextInt();
		boolean existe=false;
		
		for(int i=0; i<n; i++)
			if(a[i].numeromecanografico==tmp){
				existe=true;
				out.println("Aluno encontrado!");
				ImprimirAluno(a[i]);
			}
			
		if(!existe)
			out.println("O aluno não existe!");
		
	}
	public static void MediaFinal(aluno[] a, int n){
		out.println("--Media da Turma--");
		
		double media=0;
		
		for(int i=0; i<n; i++)
			media+=a[n].notafinal;
		media=media/n;
		out.printf("Média final da turma é de %.2f \n\n", media);
	}
	public static int AlterarInf(aluno[] a, int n){
		out.println("--Alterar Informação de um Aluno--");
		out.print("Qual é o aluno que deseja alterar? (nmec): ");
		int tmp = sc.nextInt();
		boolean existe=false;
		
		for(int i=0; i<n; i++)
			if(tmp==a[i].numeromecanografico){
				existe=true;
				out.println("Aluno encontrado!");
				ImprimirAluno(a[i]);
				out.println("Alterar notas do aluno "+i);
				
				for(int b=0; b<4; b++){
					out.printf("Nota %d: ", i+1);
					a[n].nota[b]=sc.nextInt();
				}
				
				a[n].notafinal=a[n].nota[0]*0.1+a[n].nota[1]*0.3+a[n].nota[2]*0.1+a[n].nota[3]*0.5;
				out.printf("Nota final: %.2f \n", a[n].notafinal);
				
			}
		
		if(!existe && n<20){
			a[n].numeromecanografico=tmp;
			sc.nextLine();
			
			out.print("Nome do aluno: ");
			a[n].nome=sc.nextLine();
				
			for(int i=0; i<4; i++){
				out.printf("Nota %d: ", i++);
				a[n].nota[i]=sc.nextInt();
			}
				
			a[n].notafinal=a[n].nota[0]*0.1+a[n].nota[1]*0.3+a[n].nota[2]*0.1+a[n].nota[3]*0.5;
			out.printf("Nota final: %.2f \n", a[n].notafinal);
			return n++;
		}else if(!existe && n>=20)
			out.println("A turma encontra-se preenchida!");
		
		return n;
		
	}
	public static void ListOddNmec(aluno[] a, int n){
		out.println("--Listar ordenado por N.Mec--");
		int[][] odd = new int[n][2];
		int tmp;
		
		for(int i=0; i<n; i++){
			odd[i][0]=i;
			odd[i][1]=a[i].numeromecanografico;
		}
			
		for(int i=0; i<n-1; i++){
			for(int t=i+1; t<n; t++){
				if(odd[i][1]>odd[t][1]){
					tmp=odd[i][0];
					odd[i][0]=odd[t][0];
					odd[t][0]=tmp;
					tmp=odd[i][1];
					odd[i][1]=odd[t][1];
					odd[t][1]=tmp;
				}
			}
		}
		
		for(int i=0; i<n; i++)
			ImprimirAluno(a[odd[i][0]]);
		
	}
	public static void ListOddNotaFinal(aluno[] a, int n){
		out.println("--Listar ordenado por N.Mec--");
		int[] odd = new int[n];
		double notafinal[] = new double[n];
		int tmp0; double tmp1;
		
		for(int i=0; i<n; i++){
			odd[i]=i;
			notafinal[i]=a[i].notafinal;
		}
			
		for(int i=0; i<n-1; i++){
			for(int t=i+1; t<n; t++){
				if(notafinal[i]>notafinal[t]){
					tmp0=odd[i];
					odd[i]=odd[t];
					odd[t]=tmp0;
					tmp1=notafinal[i];
					notafinal[i]=notafinal[t];
					notafinal[t]=tmp1;
				}
			}
		}
		
		for(int i=0; i<n; i++)
			ImprimirAluno(a[odd[i]]);
		
	}
	public static void MelhorAluno(aluno[] a, int n){
		double max=0;
		int m=0;
		
		for(int i=0; i<n; i++)
			if(a[i].notafinal>max){
				max=a[i].notafinal;
				m=i;
			}
			
		ImprimirAluno(a[m]);
		
	}
	public static void ImprimirAluno(aluno a){
		out.println("--------------------");
		out.println("N.Mec.: "+a.numeromecanografico);
		out.println("Nome do aluno: "+a.nome);
		for(int i=0; i<4; i++)
			out.println("Nota "+i+": "+a.nota[i]);
		out.printf("Nota final: %.2f \n",a.notafinal);
		out.println("--------------------");
	}
	
}
class aluno{
	int numeromecanografico;
	String nome;
	int nota[] = new int[4];
	//0-3 notas 
	double notafinal;
}
