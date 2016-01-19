/* Biblioteca - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolução por favor reporte para rafael.ferreira@ua.pt !
 */
import java.util.*;
import static java.lang.System.*;

public class ex104_biblioteca{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		out.println("Gestão de uma biblioteca");
		
		//contruir biblioteca
		livro[] biblioteca = new livro[200];
			for(int i=0; i<biblioteca.length; i++)
				biblioteca[i] = new livro();
				
		//MENU
		int opcao, n=-1;
		do{
			opcao = Menu();
			switch(opcao){
				case 1: n = InsertBooks(biblioteca, n);
					break;
				case 2: n = RemoveBooks(biblioteca, n);
					break;
				case 3: n = DeleteBd(biblioteca);
					break;
				case 4: RepeatedCotas(biblioteca, n);
					break;
				case 5: ChangeBookStatus(biblioteca, n);
					break;
				case 6: Requisitados(biblioteca, n);
					break;
				case 7: OrdenarCota(biblioteca, n); //cota
					break;
				case 8: OrdenarData(biblioteca, n); //data
					break;
			}
		}while(opcao!=9);
	}
	
	public static int InsertBooks(livro[] a, int n){
		do{ 
			
			n++;//incremento
			out.printf("\n--Livro %d--\n", n+1);
			
			//Livro
			a[n].cota = InsertCota(); 
			
			//Se a cota não estiver vazia
			if(!("").equals(a[n].cota)){
				//Autor
				do{
					out.print("Autor : "); 
					a[n].autor=sc.nextLine();
				}while(a[n].autor.length()>40 || a[n].autor.length()<1);
				//Titulo
				do{
					out.print("Título: "); 
					a[n].titulo=sc.nextLine();
				}while(a[n].titulo.length()>60 || a[n].titulo.length()<1);
				//Data
				out.println("Data de aquisição"); 
				a[n].datadeaquisicao = InsertData();
				//Estado
				do{
					out.print("Estado do livro (R / L / C): "); 
					a[n].estado = sc.nextLine().charAt(0); 
					a[n].estado = Character.toUpperCase(a[n].estado);
				}while(a[n].estado!='R' && a[n].estado!='L' && a[n].estado!='C');
				
			}else 
				return --n;//decremento para acertar quando sai
				
		}while(n!=199);
		
		return n;
	}
	public static String InsertCota(){
		boolean validado;
		String cota = new String();
		do{
			validado = false;
			out.print("Cota: "); cota = sc.nextLine();
			if(cota!=null)
				for(int i=0; i<cota.length(); i++)
					if(!Character.isLetterOrDigit(cota.charAt(i)))
						validado=true;
			if(cota.length()>20)
				validado=true;
		
		}while(validado);
		
		return cota;
	}
	public static data InsertData(){
		data tmp = new data();
		out.print("Inserir data actual? (y/n): ");
		
		if(Character.toLowerCase(sc.nextLine().charAt(0)) == 'y'){
			Calendar now = Calendar.getInstance();
			//Dia actual
			tmp.dia = now.get(Calendar.DAY_OF_MONTH);
			tmp.mes = now.get(Calendar.MONTH)+1;
			tmp.ano = now.get(Calendar.YEAR);
			//PrintData
			out.println(tmp.dia+" - "+tmp.mes+" - "+tmp.ano);
		}else{
			do{
				out.print("Dia: "); tmp.dia = sc.nextInt();
			}while(tmp.dia<1 ||  tmp.dia>31);
			do{
			out.print("Mês: "); tmp.mes = sc.nextInt();
			}while(tmp.mes<1 || tmp.mes>12);
			do{
				out.print("Ano: "); tmp.ano = sc.nextInt();
			}while(tmp.ano==0);
			sc.nextLine();
		}
		return tmp;
	}
	public static int RemoveBooks(livro[] a, int n){
		
		out.print("Qual é o livro que deseja remover? (indique a cota): ");
		String cota = new String();
		cota=sc.nextLine();
		for(int i=0; i<=n; i++)
			if(cota.equals(a[i].cota)){
				for(int b=i; b<n; b++){
					a[b].titulo=a[b+1].titulo;
					a[b].cota=a[b+1].cota;
					a[b].datadeaquisicao=a[b+1].datadeaquisicao;
					a[b].autor=a[b+1].autor;
					a[b].estado=a[b+1].estado;
				}
				out.printf("\nRemovido o livro nº %d \n", i+1);
				return --n;
			}
		out.println("O livro não foi encontrado!");
		return n;
		
	}
	public static int DeleteBd(livro[] a){
		livro[] b = new livro[200];
		for(int i=0; i<b.length;i++){
			b[i] = new livro();
		}
		a=b;
		out.println("\nBase de dados apagada!");
		return -1;
	}
	public static void RepeatedCotas(livro[] a, int n){
		boolean notrepetidos=true;
		for(int i=0; i<n; i++)
			for(int b=i+1; b<=n; b++)
				if(a[i].cota.equals(a[b].cota)){
					out.println("\nLivro com cota repetida encontrado!");
					ImprimirLivro(a[i]);
					out.print("Nova cota: "); a[i].cota=sc.nextLine();
					notrepetidos=false;
					b=i+1;	
				}
		if(notrepetidos)
			out.println("\nNão existem livros com cotas repetidas!");
	}
	public static void ChangeBookStatus(livro[] a, int n){
		out.println("\nQual é o livro que deseja alterar o estado? (cota): ");
		String cota = sc.nextLine();
		boolean nencontrado=true;
		for(int i=0; i<n+1; i++)
			if(cota.equals(a[i].cota)){
				nencontrado=false;
				if(a[i].estado=='R' || a[i].estado=='C'){
					out.print("Deseja colocar como libertado? (y/n): ");
					if(Character.toLowerCase(sc.nextLine().charAt(0))=='y')
						a[i].estado='L';
				}else if(a[i].estado=='L'){
					out.print("Deseja colocar em acesso condicionado (c) ou como requisitado (r)? (c/r/n): ");
					char tmp=Character.toLowerCase(sc.nextLine().charAt(0));
					if(tmp=='c')
						a[i].estado='C';
					else if(tmp=='r')
						a[i].estado='R';
				}	
				
				out.print("\nEstado actual: ");
				if(a[i].estado=='L')
					out.println("Livre");
				else if(a[i].estado=='R')
					out.println("Requisitado");
				else if(a[i].estado=='C')
					out.println("Condicionado");
					
				break;
			}
			if(nencontrado)
				out.println("Livro não encontrado!");
	}
	public static int Menu(){
		int tmp;
		do{
			out.println("\n1 - Introduzir livros");
			out.println("2 - Remover um livro");
			out.println("3 - Apagar a base de dados");
			out.println("4 - Verificação de cotas repetidas");
			out.println("5 - Alterar o estado de um livro");
			out.println("6 - Listar os livros requisitados");
			out.println("7 - Listar os livros ordenados pela cota");
			out.println("8 - Listar os livros ordenados pela data");
			out.println("9 - Terminar o programa");
			out.print("Opção -> "); 
			tmp = sc.nextInt();
		}while(!(tmp>0 && tmp<10));
		sc.nextLine();
		return tmp;
	}
	public static void Requisitados(livro[] a, int n){
		boolean nreq=true;
		for(int i=0; i<=n; i++)
			if(a[i].estado=='R'){
				ImprimirLivro(a[i]);
				nreq=false;
			}
		if(nreq)
			out.println("\nNão existem livros requisitados!");
	}
	public static void ImprimirLivro(livro a){
		out.println("\nCota : "+a.cota);
		out.println("Título : "+a.titulo);
		out.println("Autor : "+a.autor);
		out.println("Data de aquisição : "+a.datadeaquisicao.dia+"-"+a.datadeaquisicao.mes+"-"+a.datadeaquisicao.ano);
		out.println("Estado : "+a.estado+"\n");
	}
	public static void OrdenarCota(livro[] a, int n){
		/* ao ordenar numeros e letras vamos usar a funcao b.compareTo(String a) devolve int
		 * the value 0 if the argument is a string lexicographically equal to this string; 
		 * a value less than 0 if the argument is a string lexicographically greater than this string; 
		 * and a value greater than 0 if the argument is a string lexicographically less than this string.
		 */
		 
		 String b[] = new String[n+1];
		 int ordem[] = new int[n+1];
		 
		 for(int i=0; i<=n; i++){
			ordem[i]=i;
			b[i]=a[i].cota;
		 }
		 for(int i=0; i<n; i++)
			for(int c=i+1; c<=n; c++)
				if(b[c].compareTo(b[i])<0){
					//ordenando as strings
					String tmp = b[c];
					b[c]=b[i];
					b[i]=tmp;
					//ordem correspondente a array da biblioteca
					int odd = ordem[c];
					ordem[c]=ordem[i];
					ordem[i]=odd;
				}
		for(int i=0; i<=n; i++)
			ImprimirLivro(a[ordem[i]]);
	}
	public static void OrdenarData(livro[] a, int n){
		 
		 int dataodd[][] = new int[n+1][3];
		 int ordem[] = new int[n+1];
		 
		 for(int i=0; i<=n; i++){
			ordem[i]=i;
			dataodd[i][0]=a[i].datadeaquisicao.dia;
			dataodd[i][1]=a[i].datadeaquisicao.mes;
			dataodd[i][2]=a[i].datadeaquisicao.ano;
		 }
		 
		 for(int i=0; i<n; i++)
			for(int c=i+1; c<=n; c++)
				if(dataodd[i][2]>=dataodd[c][2] && dataodd[i][1]>=dataodd[c][1] && dataodd[i][0]>dataodd[c][0]){
					//ordenando as datas
					for(int u=0; u<3; u++){
						int tmp = dataodd[c][u];
						dataodd[c][u]=dataodd[i][u];
						dataodd[i][u]=tmp;
					}
					//ordem correspondente a array da biblioteca
					int odd = ordem[c];
					ordem[c]=ordem[i];
					ordem[i]=odd;
				}
		for(int i=0; i<=n; i++)
			ImprimirLivro(a[ordem[i]]);
		
	}
}
//Registos
class livro{
	String autor, cota, titulo; 
	/* optei por usar Strings e depois criar uma função de validação do que o utilizador insere
	 * mas poderia ser usado também um array de char para o efeito */
	data datadeaquisicao = new data();
	char estado; //R - requisitado , L - livre , C - condicionado
}
class data{
	int dia, mes, ano;
}

