/* Gestão Avaliação - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 */
import java.util.*;
import static java.lang.System.*;

public class ex103_gestaoaval{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		//declaração da turma e primeiro preenchimento
		aluno[] turma = new aluno[20];
		for(int i=0; i<turma.length; i++)
			turma[i] = new aluno();
		int menu;
			
		do{	
			menu=menu();
			//LimparTerminal();
			switch(menu)
			{
				case 1: turma = InserirTurma();
					break;
				case 2: InformacaoAluno(turma); 
					break;
				case 3: AlterarAluno(turma);
					break;
				case 4: ListarAlunos(turma,1);
					break;
				case 5:	ListarAlunos(turma,2);
					break;
				case 6: MediaFinal(turma);
					break;
				case 7: MelhorAluno(turma);
					break;			
			}
		}while(menu!=8);
	}
	public static int menu(){
		int a;
		
		do{
			//display do menu
			out.println("Gestão da turma");
			out.println("1 - Inserir informação da turma");
			out.println("2 - Mostrar informação de um aluno");
			out.println("3 - Alterar informação de um aluno");
			out.println("4 - Listar os alunos ordenados por nº mec");
			out.println("5 - Listar os alunos ordenados por nota final");
			out.println("6 - Média das notas finais");
			out.println("7 - Melhor aluno");
			out.println("8 - Terminar o programa");
			out.print("Opção -> ");
			//ordem
			a = sc.nextInt();
			if(a<1 || a>8)
				out.println("Insira uma opção válida!");
		}while(a<1 || a>8);
		
		return a;
	}
	public static aluno[] InserirTurma(){
		aluno[] a = new aluno[20];
		int i=0;
		for(; i<a.length; i++)
			a[i] = new aluno();
			
		out.println("\n*** Inserir Turma ***");
		i=-1;
		do{
			//LimparTerminal();
			
			i++;
			LerAluno(a,i);
			
			a[i].notafinal=notafinal(a[i].nota);
			
		}while(a[i].nmec!=0 && i<19);
		out.println("** Turma inserida **\n");
		return a;
	}
	public static double notafinal(int[] a){
		return a[0]*0.1+a[1]*0.3+a[2]*0.1+a[3]*0.5;
	}
	public static void InformacaoAluno(aluno[] a){
		out.println("** Qual é o nºmec do aluno que pretende ver? **");
		int n=sc.nextInt(), id=AlunoExiste(a,n);
		
		if(id>-1 && n!=0){
			out.println("\n-Aluno encontrado!-");
			ImprimirAluno(a, id);
		}else
			out.println("\nO aluno não existe!\n");
	}
	public static void AlterarAluno(aluno[] a){
		out.println("** Qual é o nºmec do aluno que pretende alterar? **");
		int n=sc.nextInt(), id=AlunoExiste(a,n);
		
		if(id>-1 && n!=0){
			out.println("-Aluno encontrado!-");
			
			for(int b=0; b<a[id].nota.length; b++){
				out.printf("Nota [%d]: ",b+1);
				a[id].nota[b]=sc.nextInt();
			}
			a[id].notafinal=notafinal(a[id].nota);
			
		}else{
				int vaga=vaga(a);
				if(vaga>-1){
					out.println("\n-Aluno não encontrado!-");
					out.println("Insira os dados do novo aluno:");
					a[vaga].nmec=n;
					LerAluno(a,vaga);
				}else
					out.println("\n-Aluno não encontrado e não existe espaço nesta turma para adicionar um novo aluno!-\n");
		}	
	}
	public static void ListarAlunos(aluno[] a, int t){
		out.println("\nInformação dos alunos!");
		int i=0, prenchidas=0;
		
		double tmp;
		double[][] ordem;
		ordem = new double[20][2];
		//se t==1 ordena por nmec se t==2 ordena por notafinal
		if(t==1){
			for(;i<a.length;i++){
				if(a[i].nmec!=0){
					ordem[i][0]=a[i].nmec;
					ordem[i][1]=i;
					prenchidas++;
				}
			}
		}else{	
			for(;i<a.length;i++){
				if(a[i].notafinal!=0){
					ordem[i][0]=a[i].notafinal;
					ordem[i][1]=i;
					prenchidas++;
				}
			}
		}
		//Ordenar
		boolean trocas;
		do{
			trocas=false;
			for(i=0; i<prenchidas-1; i++)
				if(ordem[i][0]>ordem[i+1][0]){
					tmp=ordem[i+1][1];
					ordem[i+1][1]=ordem[i][1];
					ordem[i][1]=tmp;
					
					tmp=ordem[i+1][0];
					ordem[i+1][0]=ordem[i][0];
					ordem[i][0]=tmp;
					trocas=true;
				}
		}while(trocas);
		//Impressao	
		for(i=0; i<prenchidas; i++){
			if(a[(int)ordem[i][1]].nmec!=0){
				out.printf("\nAluno [%d]",i+1);
				ImprimirAluno(a, (int)ordem[i][1]);
			}
		}
	}
	public static void MediaFinal(aluno[] a){
		double media=0;
		int i=0, n=0;
		for(; i<a.length; i++)
			if(a[i].nmec!=0){
				n++;
				media+=a[i].notafinal;
			}
		media/=n;
		out.printf("\nMedia das notas finais da turma: %2.2f\n\n",media);
	}
	public static void MelhorAluno(aluno[] a){
		int i=0, p=0;
		double m=0;
		
		for(; i<a.length; i++)
			if(a[i].notafinal>m){
				m=a[i].notafinal;
				p=i;
		}
		if(a[p].nmec!=0){
			ImprimirAluno(a, p);	
		}	
	}
	public static void LerAluno(aluno[] a, int n){
		out.printf("\n* Aluno [%d] *\n",n+1);
		
		if(!(a[n].nmec!=0))
			do{
				out.print("Número mecanográfico: ");
				a[n].nmec=sc.nextInt();
			}while(a[n].nmec<0);
		
		if(a[n].nmec!=0){
			sc.nextLine();
			do{
				out.print("Nome do aluno: ");
				a[n].nomealuno=sc.nextLine();
			}while(!(a[n].nomealuno.length()>0));
			
			out.println("-Notas das várias componentes de avaliação-");
			out.println("nota[1]:10% | nota[2]:30% | nota[3]:10% | nota[4]: 50%");
				for(int b=0; b<a[n].nota.length; b++){
						do{
							out.printf("Nota [%d]: ",b+1);
							a[n].nota[b]=sc.nextInt();
						}while(a[n].nota[b]<0 || a[n].nota[b]>20);
				}
		}
	}
	public static void ImprimirAluno(aluno[] a, int p){
			out.printf("\nNome do aluno: %s\n",a[p].nomealuno);
			out.printf("Número mecanográfico: %d\n",a[p].nmec);
			
			for(int i=0; i<a[p].nota.length; i++)
				out.printf("Nota [%d]: %d \n",i+1,a[p].nota[i]);
			out.printf("Nota final: %2.2f\n\n",a[p].notafinal);
	}	
	public static int vaga(aluno[] a){
		int vaga=-2;
		for(int i=0; i<a.length; i++)
				if(a[i].nmec==0)
					return i;
		return vaga;
	}
	public static int AlunoExiste(aluno[] a, int n){
		int id=-2;
		for(int i=0; i<a.length; i++)
				if(a[i].nmec==n)
					id=i;
		return id;
	}
	/*public static void LimparTerminal()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}*/
}
class aluno{
	int nmec;
	String nomealuno;
	int[] nota = new int[4];
	double notafinal;
}
