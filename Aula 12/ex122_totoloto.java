/* Totoloto com manipulação de ficheiros - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolução por favor reporte para rafael.ferreira@ua.pt !
 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ex122_totoloto{

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		int[] chave = chave();
		BobleSort(chave);
		EscritaAposta(chave);
		out.println("Concluído!");
	}
	public static int[] chave() throws IOException{
		boolean invalido;
		do{
			// Le o nome do ficheiro de Origem
			String origem = LerFicheiro();
			// obter chave //
			invalido=false;
			//decalaracao do ficheiro de origem
			File fileorigem = new File(origem);
			//Scan ao ficheiro de origem
			Scanner scanorigem = new Scanner(fileorigem);
			//procura da chave
			int[] chave;
			String tmp;
			String[] linha;

			while(scanorigem.hasNextLine())
			{
				tmp=scanorigem.nextLine();
				if(tmp.length()>0){
					linha=tmp.split(" ");
					chave = new int[linha.length];
					for(int i=0; i<linha.length; i++)
						if(linha[i].length()!=0)
							chave[i]=Integer.valueOf(linha[i]);
					
					if(chave.length!=5 && ValidacaoChave(chave)){
						out.println("A chave dada não é válida !");	
						invalido=true;
						break;
					}else
						//fecho do scanner
						scanorigem.close();
						return chave;
				}
			}
			//fecho do scanner
			scanorigem.close();
		}while(invalido);
		// obter chave //
		return null;
	}
	public static boolean ValidacaoChave(int[] a){
		boolean  valido = true;
		for(int i=0; i<a.length; i++)
			if(a[i]>49 || a[i]<1)
				valido=false;
		return valido;
	}
	public static String NovoFicheiro(){ // faz a validação do novo ficheiro, se já existe um, se é um directório e se é txt
		String a = new String();
		boolean notok;
		String nxt = new String();
		do{
			notok=false;
			out.print("Nome do ficheiro destino para a matriz de aposta: ");
			a = sc.nextLine();
			File file = new File(a);
			if(file.exists()){
				do{
					out.print("O ficheiro destino já existe, deseja destruir o ficheiro existente? (y/n): ");
					nxt = sc.nextLine();
					if(nxt.charAt(0)=='n')
						notok=true;
				}while(nxt.charAt(0)!='n' && nxt.charAt(0)!='y');
			}else if(file.isDirectory()){
				out.println("O ficheiro destino indicado é um directório!");
				notok=true;
			}else if(!(a.charAt(a.length()-1) == 't' && a.charAt(a.length()-2) == 'x' && a.charAt(a.length()-3) == 't' && a.charAt(a.length()-4) == '.')){
				notok=true;
				out.println("O ficheiro deve ser .txt!");
			}
		}while(notok);
		return a;
	}
	public static String LerFicheiro(){ //faz a validação do ficheiro que o utilizador seleciona para a chave
		String a = new String();
		boolean notok;
		do{
			out.print("Nome do ficheiro com a chave: ");
			a = sc.nextLine();
			notok=false;	
			File file = new File(a);	
			if (!file.exists()){
				 out.println("O ficheiro não existe!");
				 notok=true;
			}else if (file.isDirectory()){
				 out.println("O ficheiro indicado é um directório!");
				 notok=true;
			}else if (!file.canRead()){
				 out.println("Não é possível ler o ficheiro indicado!");
				 notok=true;
			}
		}while(notok);
		return a;
	}
	public static void BobleSort(int[] a){
		boolean trocas;
		int tmp;
		do{
			trocas=false;
			
			for(int i=0; i<a.length-1; i++)
				if(a[i]>a[i+1]){
					tmp=a[i+1];
					a[i+1]=a[i];
					a[i]=tmp;
					trocas=true;
				}
			
		}while(trocas);
	}
	public static void EscritaAposta(int[] a) throws IOException{
		
		String destino = NovoFicheiro();
	    //declaaracao do ficheiro de destino
		File filedestino = new File(destino);
		//comando de impressao no ficheiro destino
		PrintWriter impressao = new PrintWriter(filedestino);
			
		impressao.println("\n   Aposta de totoloto");
		boolean replace; // esta variavel serve para sabermos qual o número que devemos susbstituir por X
		
		for(int i=1; i<=49; i++){
			replace=false;
			
			for(int w=0; w<a.length; w++){ // percurremos a array de int a toda para sabermos quais os numeros que 
				//devemos susbstituir pela chave
				if(a[w]==i)
					replace=true;
			}
			//aqui vamos susbstituir
			if(replace)
				impressao.print(" X");
			else
				impressao.printf("%2d",i);
			//espaços entre os números
			impressao.print("  ");
			//fazer os paragrafos
			if(i%7==0)
				impressao.println();
		}
		impressao.close();//fechar a escrita	
	}
	
}
