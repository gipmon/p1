/* Agenda - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 * Alguma falha na resolucao por favor reporte para rafael.ferreira@ua.pt !
 */
import java.util.*;
import static java.lang.System.*;

public class ex133_3A3B_UPDATED{
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int menu, n=0;
		
		contacto agenda[] = new contacto[100];
		for(int i=0; i<agenda.length; i++)
			agenda[i]=new contacto();
		
		do{
			menu=Menu();
			switch(menu){
				case 1: n=InserirContacto(agenda, n);
					break;
				case 2:	PesquisarContacto(agenda, n);
					break;
				case 3: VisualizarContactos(agenda, n);
					break;
				case 4: n=ApagarAgenda(agenda);
					break;
				case 5: n=EliminarContacto(agenda, n);
					break;
				case 6: ContactosOddNome(agenda, n);
					break;
				case 7: ValidarEmails(agenda, n);
					break;
			}
		}while(menu!=8);
		
	}
	public static int Menu(){
		
		out.println("Gestão de uma agenda:");
		out.println("1 - Inserir um contacto");
		out.println("2 - Pesquisar contacto por nome");
		out.println("3 - Visualizar todos os contactos");
		out.println("4 - Apagar a agenda");
		out.println("5 - Eliminar um contacto");
		out.println("6 - Visualizar contactos ordenados pelo nome");
		out.println("7 - Validar endereços de email");
		out.println("8 - Terminar o programa");
		out.print("Opção -> ");
		return sc.nextInt();
		
	}
	public static int InserirContacto(contacto[] a, int n){
		out.println("\n--Inserir Contacto["+n+"]--");
		sc.nextLine();
		
		out.print("Nome: "); 
		a[n].nome=sc.nextLine();
		
		out.print("Morada: ");
		a[n].morada=sc.nextLine();
		
		out.print("Telefone: ");
		a[n].telefone=sc.nextInt();
		
		sc.nextLine();
		out.print("Email: ");
		a[n].email=sc.nextLine();
		out.println();
		return n+1;
	}
	public static void PesquisarContacto(contacto[] a, int n){
		out.println("\n--Pesquisar por contacto por nome--");
		sc.nextLine();
		out.print("Qual o nome? ");
		String tmp=sc.nextLine();
		boolean existe=false;
		
		for(int i=0; i<n; i++)
			if(a[i].nome.indexOf(tmp)>-1){
				existe=true;
				ImprimirContacto(a[i]);
			}
		
		if(!existe)
			out.println("O contacto não existe!");
		
	}
	public static void VisualizarContactos(contacto[] a, int n){
		for(int i=0; i<n; i++)
			ImprimirContacto(a[i]);
	}
	public static int ApagarAgenda(contacto[] a){
		a = new contacto[100];
		for(int i=0; i<a.length; i++)
			a[i]=new contacto();
		out.println("\nAgenda apagada!\n");
		return 0;
	}
	public static int EliminarContacto(contacto[] a, int n){
		out.println("\n--Eliminar Contacto--");
		out.print("Qual contacto deseja eliminar? (telemovel): ");
		int tmp = sc.nextInt();
		String clean = new String();
		
		for(int i=0; i<n; i++)
			if(a[i].telefone==tmp){
				ImprimirContacto(a[i]);
				
				for(int b=i; b<n-1; b++){
					a[b].nome=a[b+1].nome;
					a[b].morada=a[b+1].morada;
					a[b].email=a[b+1].email;
					a[b].telefone=a[b+1].telefone;
				}
				
				out.println("\nContacto Eliminado!");
				return n-1;
			}
		
		out.println("O contacto não existe!");
		return n;
	}
	public static void ContactosOddNome(contacto[] a, int n){
		int ordena[] = new int[n];
		String nome[] = new String[n];
		
		for(int i=0; i<n; i++){
			ordena[i]=i;
			nome[i]=a[i].nome;
		}
		
		int tmp;
		String tmp1;
		
		for(int i=0; i<n-1; i++)
			for(int b=i+1; b<n; b++)
				if(nome[i].compareTo(nome[b])>0){
					//ordenar numeros
					tmp=ordena[i];
					ordena[i]=ordena[b];
					ordena[b]=tmp;
					//ordenar nomes
					tmp1=nome[i];
					nome[i]=nome[b];
					nome[b]=tmp1;
				}
		
		for(int i=0; i<n; i++)
			ImprimirContacto(a[ordena[i]]);
			
	}
	public static void ValidarEmails(contacto[] a, int n){
		out.println("--Validar emails--");
		sc.nextLine();
		for(int i=0; i<n; i++)
			if(!ValEmail(a[i].email)){
				out.println("Email invalido encontrado!");
				ImprimirContacto(a[i]);
				do{
					out.print("Insira um novo email: ");
					a[i].email=sc.nextLine();
				}while(!ValEmail(a[i].email));
			}
			
		out.println("Emails validados!\n");
	}
	public static boolean ValEmail(String a){
		int arroba=0;
		
		for(int i=0; i<a.length(); i++){
				if(a.charAt(i)=='.' || a.charAt(i)=='_')
					continue;
				else if(a.charAt(i)=='@')
					arroba++;
				else if(!Character.isLetterOrDigit(a.charAt(i)))
					return false;
		}
		
		if(arroba!=1)
			return false;
		else
			return true;
	}
	public static void ImprimirContacto(contacto a){
		out.println("----------------------");
		out.println("Nome: "+a.nome);
		out.println("Morada: "+a.morada);
		out.println("Telefone: "+a.telefone);
		out.println("Email: "+a.email);
		out.println("----------------------");
	}
}
class contacto{
	String nome, morada, email;
	int telefone;
}

