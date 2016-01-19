/* Copia e manipulação de ficheiros - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolução por favor reporte para rafael.ferreira@ua.pt !
 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ex121_copy{
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
		out.println("Cópia de ficheiro e ordenação lexicográfica!\n");
		// Le o nome do ficheiro de Origem
		String origem = LerFicheiro();
		 // Le o nome do ficheiro de destino
		String destino = NovoFicheiro();
		// ---------- //
		CopiarFicheiro(origem, destino);
		out.println("Concluído!");
	}
	public static void CopiarFicheiro(String origem, String destino) throws IOException{
		int i=0;
		String[] ordena;
		String tmp = new String();
		boolean trocas;
		//decalaracao do ficheiro de origem
		File fileorigem = new File(origem);
		//Scan ao ficheiro de origem
		Scanner scanorigem = new Scanner(fileorigem);
		//declaaracao do ficheiro de destino
		File filedestino = new File(destino);
		//enquanto existir uma linhatte seguinte vai incrementar o i, serve para sabermos
		//o numero de linhas que o fichmeiro tem
		while(scanorigem.hasNextLine())
		{
			i++;
			scanorigem.nextLine(); //isto é essencial para que o programa avance nas linhas do ficheiro txt
		}
		//declaracao da array string com o conteúdo das linhas
		String[] linha = new String[i];
		//reposicao a zero do scanner 
		scanorigem.close();
		scanorigem = new Scanner(fileorigem);
		//leitura das linhas, ordenacao de cada linha, das linhas e colocacao das mesmas no array
		//no seguinte for apenas vamos fazer a ordenacao lexicografica de linha a linha
		for(int a=0; a<i; a++){
			linha[a]=scanorigem.nextLine();
			ordena=linha[a].split(" ");//colocamos as palavras da linha 'a' numa string array ordena[]
			//algoritmo para fazer ordenacao da linha
			do{
				trocas=false;
				for(int z=0; z<ordena.length-1; z++)
					/* ao ordenar numeros e letras vamos usar a funcao b.compareTo(String a) devolve int
					 * the value 0 if the argument is a string lexicographically equal to this string; 
					 * a value less than 0 if the argument is a string lexicographically greater than this string; 
					 * and a value greater than 0 if the argument is a string lexicographically less than this string.
					 */
					if(ordena[z+1].compareTo(ordena[z])<0){
						tmp = ordena[z];
						ordena[z]=ordena[z+1];
						ordena[z+1]=tmp;
						trocas=true;
					}
			}while(trocas);
			// linha final
			linha[a]="";//reposicao a nada porque ela continha a linha lida no ficheiro origem
			for(int z=0; z<ordena.length; z++)
				linha[a]+=" "+ordena[z]; //impressao da nova linha ordenada
		}
		//agora vamos fazer a ordenacao de cada linha com todas as linhas
		for(int a=0; a<linha.length-1; a++)
			do{
				trocas=false;
				for(int z=0; z<linha.length-1; z++)
					if(linha[a+1].compareTo(linha[a])<0){
						tmp = linha[a];
						linha[a]=linha[a+1];
						linha[a+1]=tmp;
						trocas=true;
					}
			}while(trocas);
			
		//comando de impressao no ficheiro destino
		PrintWriter impressao = new PrintWriter(filedestino);
		for(int z=0; z<linha.length; z++)
			impressao.printf("\n%s", linha[z]);
		impressao.close();//fechar a escrita
	}	
	public static String NovoFicheiro(){ // faz a validação do novo ficheiro, se já existe um, se é um directório e se é txt
		String a = new String();
		boolean notok;
		String nxt = new String();
		do{
			notok=false;
			out.print("Nome do ficheiro destino: ");
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
	public static String LerFicheiro(){ //faz a validação do ficheiro que o utilizador seleciona
		String a = new String();
		boolean notok;
		do{
			out.print("Nome do ficheiro origem: ");
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
}

