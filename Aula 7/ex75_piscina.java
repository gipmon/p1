/*
 * Natacao
 * Dev/Comentários © Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;

public class ex75_piscina{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		out.println("#Gestão de Piscinas#");
		out.println("-Insira os seus dados: ");
		Utente a = LerUtente();
		//Calculo das despesas
		a = ValorAPagar(a);
		ImpressaoTabela(a);
	}
	public static Utente LerUtente(){
		Utente a = new Utente();
		//Nome do Individuo
		char c;
		boolean b;
		do{
			b=false;
			out.print("Nome: ");
			a.nome=sc.nextLine();
			for(int i=0; i<a.nome.length(); i++){
				c=a.nome.charAt(i);
				if(!Character.isLetter(c)){
					b=true;
					out.println("Só são permitidas letras!");
				}
			}
		}while(b);
		//Nome do Individuo
		//Modalidade
		do{
			out.print("Modalidade (1 Iniciação | 2 Aperfeiçoamento): ");
			a.modalidade=sc.nextInt();
		}while(a.modalidade!=1 && a.modalidade!=2);
		//Horas Semanais
		do{
			out.print("Horas semanais [1,10] :");
			a.horas=sc.nextInt();
		}while(a.horas>10 || a.horas<1);
		//Horas semanais
		//Utentes
		do{
			out.print("Quantos familiares tem no Clube? (0-não tem): ");
			a.familiares=sc.nextInt();
		}while(a.familiares<0);
		//Utentes
		//Primeira vez
		do{
			out.print("Primeira vez? (0-Sim|1-Não): ");
			a.primeira=sc.nextInt();
		}while(a.primeira<0 || a.primeira>1);
		//Primeira vez
		//Mensalidades
		do{
			out.print("N. mensalidades a pagar (>=1): ");
			a.mensalidades=sc.nextInt();
		}while(a.mensalidades<1);
		//Mensalidades
		return a;
	}
	public static Utente ValorAPagar(Utente a){
		//Preço Mensal tendo em conta as Horas e tal
		if(a.modalidade==1)
			a.valMensalidade+=4*a.horas;
		else
			a.valMensalidade+=6*a.horas;
		a.valMensalidade*=4;
		//Preço Mensal tendo em conta as Horas e tal
		//Desconto
		if(a.familiares==1)
			a.valMensalidade=a.mensalidades*(a.valMensalidade-(a.valMensalidade*0.1));
		else if(a.familiares>1)
			a.valMensalidade=a.mensalidades*(a.valMensalidade-(a.valMensalidade*0.25));
		//Desconto
		//Inscriçao
		if(a.primeira==0)
			a.valInsc+=50;
		else
			a.valInsc+=30;
		//Final
		a.total=a.valInsc+a.valMensalidade;
		return a;
	}
	public static void ImpressaoTabela(Utente a){
		out.println();
		out.println("Nova Inscrição para o Clube de Natação");
		out.printf("Nome: %s \n",a.nome);
			if(a.primeira==0)
				out.println("Primeira Vez");
			else if(a.primeira==1)
				out.println("Não é a 1ª Vez");
		out.printf("%d horas de aperfeiçoamento \n",a.horas);
			if(a.familiares==0)
				out.printf("Não tem familiares inscritos.");
			else
				out.printf("%d Familiar",a.familiares);
		out.println();
		out.println("---------------------------------------------------");
		out.println("Item       Quantidade            Valor     ");
		out.printf("Inscrição     1                  €%.2f       \n", a.valInsc);
		out.printf("Mensalidades  %d                  €%.2f       \n",a.mensalidades, a.valMensalidade);  
		out.println("---------------------------------------------------");
		out.printf("Total                            €%.2f", a.total);

	}
}
class Utente{
	String nome;
	int modalidade, horas, familiares, primeira, mensalidades;
	double total, valMensalidade, valInsc;
	
}
