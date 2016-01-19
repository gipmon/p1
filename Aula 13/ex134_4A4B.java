/* Matriculas - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolucao por favor reporte para rafael.ferreira@ua.pt !
 */

import java.util.*;
import static java.lang.System.*;

public class ex134_4A4B{
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		
		Piloto piloto[] = new Piloto[10];
		for(int i=0; i<piloto.length; i++)
			piloto[i] = new Piloto();
			
		int menu;
		
		do{
			menu=Menu();
			switch(menu){
				case 1: piloto=InserirPiloto();
					break;
				case 2: ListarPilotos(piloto);
					break;
				case 3:	AlterarPiloto(piloto);
					break;
				case 4:	RemoverPiloto(piloto);
					break;
				case 5: ListarPilotosOddNome(piloto);
					break;
				case 6: RemoverPilotoNome(piloto);
					break;
				case 7: ValidarMatriculas(piloto);
					break;
			}
		}while(menu!=8);
		
	}
	public static void ValidarMatriculas(Piloto[] a){
		boolean notok=false;
		sc.nextLine();
		
		for(int i=0; i<a.length; i++){
			notok=false;
			
			if(a[i].matricula.length()!=8)
				notok=true;
			else if(a[i].matricula.charAt(2) != '-' && a[i].matricula.charAt(5) != '-')
				notok=true;
			else if(Character.isUpperCase(a[i].matricula.charAt(0)) && Character.isUpperCase(a[i].matricula.charAt(1)) && Character.isDigit(a[i].matricula.charAt(3))  && Character.isDigit(a[i].matricula.charAt(4))  && Character.isDigit(a[i].matricula.charAt(6))  && Character.isDigit(a[i].matricula.charAt(7))){
			}else if(Character.isUpperCase(a[i].matricula.charAt(6)) && Character.isUpperCase(a[i].matricula.charAt(7)) && Character.isDigit(a[i].matricula.charAt(0)) && Character.isDigit(a[i].matricula.charAt(1))  && Character.isDigit(a[i].matricula.charAt(3))  && Character.isDigit(a[i].matricula.charAt(4))){	
			}else if(Character.isUpperCase(a[i].matricula.charAt(3)) && Character.isUpperCase(a[i].matricula.charAt(4)) && Character.isDigit(a[i].matricula.charAt(0)) && Character.isDigit(a[i].matricula.charAt(1))  && Character.isDigit(a[i].matricula.charAt(6))  && Character.isDigit(a[i].matricula.charAt(7))){
			}else
				notok=true;
				
			if(notok){
					out.print("\nIndique a nova matrícula para o veículo nº"+a[i].nviatura+": ");
					a[i].matricula=sc.nextLine();
					i--;
			}
		}
		out.println();
	}
	public static void RemoverPilotoNome(Piloto[] a){
		out.print("\nQual piloto deseja remover (nome do piloto): "); 
		sc.nextLine();
		String nomedopiloto=sc.nextLine();
		
		boolean existe[] = new boolean[a.length];
		for(int i=0; i<a.length; i++)
			existe[i]=false;
		int nexst=0;	
		
        for(int i=0; i<a.length; i++)
           if(a[i].nomedopiloto.lastIndexOf(nomedopiloto)>-1){ 
           
				existe[i]=true;
                nexst++;
            }
            
        if(nexst>1){
			out.println("Encontrado "+nexst+" pilotos, qual deseja remover? (indique o nº viatura)");
			for(int i=0; i<existe.length; i++)
				if(existe[i])
					ImprimirPiloto(a[i]);
			int remover; char answer='n';
			do{
				out.print("Indique o nº viatura do piloto a remover: "); 
				remover=sc.nextInt();
				out.printf("\nRemovido Piloto [%d] ...\n\n",remover-1);
				a[remover-1].nomedopiloto="";
				a[remover-1].matricula="";
				
				if(--nexst!=0){
					out.print("Deseja remover outro piloto? "); 
					sc.nextLine();
					answer=Character.toLowerCase(sc.nextLine().charAt(0));
				}
			}while(answer!='n' && nexst!=0);
        }else if(nexst==1){
				for(int i=0; i<existe.length; i++)
					if(existe[i]){
						out.printf("\nRemovido Piloto [%d] ...\n\n",i);
						a[i].nomedopiloto="";
						a[i].matricula="";
						
					}
        }else
            out.println("\nNão foi encontrado nenhum piloto!\n");
    
		
	}
	public static void ListarPilotosOddNome(Piloto[] a){
		int ordenar[] = new int[a.length];
		for(int i=0; i<a.length; i++)
			ordenar[i]=i;
		
		int tmp;
		
		for(int i=0; i<a.length-1; i++)
			for(int b=i+1; b<a.length; b++)
				if(a[i].nomedopiloto.compareTo(a[b].nomedopiloto)>0){
					tmp=ordenar[i];
					ordenar[i]=ordenar[b];
					ordenar[b]=tmp;
				}
		for(int i=0; i<a.length; i++)
			if(a[i].nomedopiloto.length()!=0)
				ImprimirPiloto(a[ordenar[i]]);
		
	}
	public static void RemoverPiloto(Piloto[] a){
		out.print("\nQual piloto deseja remover (nº viatura): "); 
		int nviatura=sc.nextInt();
		boolean existe=false;
		
		for(int i=0; i<a.length; i++)
			if(a[i].nviatura==nviatura){
				out.printf("\nRemovido Piloto [%d] ...\n\n",i);
				a[i].nomedopiloto="";
				a[i].matricula="";
				
				existe=true;
			}
		if(!existe)
			out.println("O piloto não existe!");
	}
	public static void AlterarPiloto(Piloto[] a){
		
		out.print("\nQual piloto deseja alterar (nº viatura): "); 
		int nviatura=sc.nextInt();
		boolean existe=false;
		sc.nextLine();
		for(int i=0; i<a.length; i++)
			if(a[i].nviatura==nviatura){
				out.printf("\nAlterar Piloto [%d] \n",i);
				out.print("Nome: "); a[i].nomedopiloto=sc.nextLine();
				out.print("Matrícula da viatura: "); a[i].matricula=sc.nextLine();
				out.println("Número da viatura: "+a[i].nviatura+"\n");
				existe=true;
			}
		if(!existe)
			out.println("O piloto não existe!\n");
	}
	public static Piloto[] InserirPiloto(){
		sc.nextLine();
		Piloto a[] = new Piloto[10];
		
		for(int i=0; i<a.length; i++)
			a[i] = new Piloto();
		
		int n=0;	
		String tmp = new String();
		
		do{
				out.printf("\nInserir Piloto [%d] \n",n);
				out.print("Nome: "); a[n].nomedopiloto=sc.nextLine();
				
				if(a[n].nomedopiloto.length()!=0){
					out.print("Matrícula da viatura: "); a[n].matricula=sc.nextLine();
					a[n].nviatura=n+1;
					out.println("Número da viatura: "+a[n].nviatura);
				}
		}while(a[n++].nomedopiloto.length()!=0 && n<10);
		n--;
		out.println();
		
		
		Piloto b[] = new Piloto[n];
		for(int i=0; i<n; i++){
			b[i]=new Piloto();
			b[i].nomedopiloto=a[i].nomedopiloto;
			b[i].matricula=a[i].matricula;
			b[i].nviatura=a[i].nviatura;
		}
		
		return b;
	}
	public static void ListarPilotos(Piloto[] a){
		int ordem[] = new int[a.length];
		int tmp;
		for(int i=0; i<ordem.length; i++)
			ordem[i]=i;
		
		
		
		for(int i=a.length-1; i>=0; i--) 
		
				if(a[i].nomedopiloto.length()!=0)
					ImprimirPiloto(a[i]);
	}
	public static void ImprimirPiloto(Piloto a){
		out.println("\nNome: "+a.nomedopiloto);
		out.println("Matrícula da viatura: "+a.matricula);
		out.println("Número da viatura: "+a.nviatura+"\n");
	}
	public static int Menu(){
		int tmp;
		do{
			out.println("Gestão de uma prova automóvel:");
			out.println("1 - Inserir informação dos pilotos");
			out.println("2 - Listar pilotos ordenados pelo número da viatura");
			out.println("3 - Alterar informação de um piloto");
			out.println("4 - Remover piloto com base no número da viatura");
			out.println("5 - Listar pilotos ordenados pelo nome");
			out.println("6 - Remover piloto(s) com base no nome");
			out.println("7 - Validar matrículas");
			out.println("8 - Terminar o programa");			
			out.print("Opção -> "); tmp=sc.nextInt();
		}while(tmp>5 && tmp<1);
		return tmp;
	}
}
class Piloto{
	int nviatura;
	String nomedopiloto;
	String matricula;
}
