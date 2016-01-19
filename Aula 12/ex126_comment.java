/* Apagar comentários - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolucao por favor reporte para rafael.ferreira@ua.pt !
 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ex126_comment {
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
	
		out.println("Retirar comentários de um programa Java!");
		char menu;
		do{
			// Le o nome do ficheiro de Origem
			String origem = LerFicheiro();
				
			//decalaracao do ficheiro de origem
			File fileorigem = new File(origem);
			//Scan ao ficheiro de origem
			Scanner scanorigem = new Scanner(fileorigem);
			
			//procura da nova biblioteca
			int i=0;
			
			//saber numero de linhas
			while(scanorigem.hasNextLine()){
				scanorigem.nextLine();
				i++;
			}
			
			//repor ao inicio
			scanorigem.close();
			scanorigem = new Scanner(fileorigem);
			
			String[] linhas = new String[i];
			i=0;
			while(scanorigem.hasNextLine()){
				linhas[i++]=scanorigem.nextLine();//linha em bruto
			}
			scanorigem.close();
			
			String[] novas = new String[i];
			
			i=0;
			
			for(int o=0; o<linhas.length; i++, o++){
				novas[i]="";
				for(int a=0; a<linhas[o].length()-1; a++)
					if((int)linhas[o].charAt(a)==47 && (int)linhas[o].charAt(a+1)==47)
						break;
					else if((int)linhas[o].charAt(a)==47 && (int)linhas[o].charAt(a+1)==42){
						for(; a<linhas[o].length()-1; a++){
							if((int)linhas[o].charAt(a+1)==47 && (int)linhas[o].charAt(a)==42){
								a+=1;
								break;
							}else if(a==linhas[o].length()-2){
								a=0;
								novas[++o]="";
							}
						}
					}else if(a==linhas[o].length()-2){
						novas[i]+=linhas[o].charAt(a);
						novas[i]+=linhas[o].charAt(a+1);
					}else
						novas[i]+=linhas[o].charAt(a);
				
			}
			//escrita			
			String destino = NovoFicheiro();
			//declaaracao do ficheiro de destino
			File filedestino = new File(destino);
			//comando de impressao no ficheiro destino
			PrintWriter impressao = new PrintWriter(filedestino);
			
			for(i=0; i<novas.length; i++)
				if(novas[i]!=null && novas[i]!="") 
					impressao.println(novas[i]);
			
			impressao.close();
				
			out.println("Concluído!\n");
			out.print("Deseja retirar comentários a outro ficheiro? (y/n): "); menu=sc.nextLine().charAt(0);
		}while(menu=='y' && menu!='n');
		
	}
	public static String NovoFicheiro(){ // faz a validação do novo ficheiro, se já existe um, se é um directório e se é .java
		String a = new String();
		boolean notok;
		String nxt = new String();
		
		do{
			notok=false;
			out.print("Nome do ficheiro destino para o programa (.java): ");
			a = sc.nextLine();
			
			if(a.charAt(a.length()-1) == 'a' && a.charAt(a.length()-2) == 'v' && a.charAt(a.length()-3) == 'a' && a.charAt(a.length()-4) == 'j'  && a.charAt(a.length()-5) == '.'){
				notok=true;
				out.println("Escreva o nome do ficheiro sem ser .java!");
				continue;
			}
			
			a+=".java";
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
			}
			
		}while(notok);
		return a;
	}
	public static String LerFicheiro(){ //faz a validação do ficheiro que o utilizador seleciona para java
		String a = new String();
		boolean notok;
		do{
			out.print("\nNome do ficheiro .java: ");
			a = sc.nextLine();
			notok=false;	
			
			if(a.charAt(a.length()-1) == 'a' && a.charAt(a.length()-2) == 'v' && a.charAt(a.length()-3) == 'a' && a.charAt(a.length()-4) == 'j'  && a.charAt(a.length()-5) == '.'){
				notok=true;
				out.println("Escreva o nome do ficheiro sem ser .java!");
				continue;
			}
			
			a+=".java";
			File file = new File(a);
			
			if (file.isDirectory()){
				 out.println("O ficheiro indicado é um directório!");
				 notok=true;
			}else if (!file.canRead()){
				 out.println("Não é possível ler o ficheiro indicado!");
				 notok=true;
			}else if (!file.exists()){
				 out.println("O ficheiro não existe!");
				 notok=true;
			 }
		}while(notok);
		return a;
	}
	
}

