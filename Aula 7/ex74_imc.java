/*
 * Indice de Massa Corporal
 * Dev/Comentários © Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;

public class ex74_imc{
	/*
	 * !Considerações importantes! Escrever sempre com vírgula os números: 18,8 e não 18.8 
	 * Ter atenção ao nextLine(); Para um bom funcionamento do programa colocámos um sc.nextLine(); a seguir à função
	 * de leitura da idade para leitura da nextLine referente ao sexo.
	 */
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		Individuo a = readIndividuo(); // Leitura
		printRelatorio(a); // Print 
		
	}
	public static double imc(Individuo a){
		return a.peso/(Math.pow(a.altura,2));
	}
	public static void printRelatorio(Individuo a){
		out.println("|--------------------------------------|");
		out.println("| Calculo do Indice de Massa Corporal  |");
		out.println("|--------------------------------------|");
		out.printf("| Nome: %-30s |\n", a.nome);
		if(a.sexo=='M')
			out.println("| Sexo: Masculino                      |");
		else
			out.println("| Sexo: Feminino                       |");
		//IMC
		double imc;
		imc=imc(a);
		out.printf("| IMC : %4.1f (kg/m2)                   |\n",imc);	
		//Comentário de IMC
		if(imc<=18.5)
			out.println("| Comentario: Abaixo do peso           |");
		else if(imc>=18.6 && imc<=24.9)
			out.println("| Comentario: Saudável                 |");
		else if(imc>=25 && imc<=29.9)
			out.println("| Comentario: Peso em excesso          |");
		else if(imc>=30 && imc<=34.9)
			out.println("| Comentario: Obesidade Grau I         |");
		else if(imc>=35 && imc<=39.9)
			out.println("| Comentario: Obesidade Grau II        |");
		else if(imc>=40)
			out.println("| Comentario: Obesidade Grau III       |");
		//Comentário de IMC
		out.println("|--------------------------------------|");
	}
	/*
	 * Leitura do Individuo 
	 */
	public static Individuo readIndividuo(){
			Individuo a = new Individuo();
			//Ler Nome
			a.nome=readNome();
			//Ler Idade
			a.idade=readIdade();
			//Ler Sexo
			sc.nextLine();
			a.sexo=readSexo();
			//Ler Peso
			a.peso=readPeso();
			//Ler Altura
			a.altura=readAltura();
		return a;
	}
	public static double readAltura(){
		double tmp;
		
		do{
			out.print("Altura (m): ");
			tmp=sc.nextDouble();
		}while(tmp<0);
			
		return tmp;
	}
	public static double readPeso(){
		double tmp;
		do{
				out.print("Peso (kg): ");
				tmp=sc.nextDouble();
		}while(tmp<0);
		return tmp;
	}
	public static char readSexo(){
		char tmp;
		String s = new String();
		do{
			out.print("Sexo (M/F): ");
			s=sc.nextLine();
			
			while(s.length()!=1)
			{
				out.println("Carácter Inválido!");
				s=sc.nextLine();
			}
			
			tmp=s.charAt(0);
		}while(tmp!='M' && tmp!='F');
		return tmp;
	}
	public static int readIdade(){
		int tmp;
		do{
			out.print("Idade (anos): ");
			tmp=sc.nextInt();
		}while(tmp<=0);
		return tmp;
	}
	public static String readNome(){
		String tmp = new String();
		boolean a = false;
		char c;
		do{
			out.print("Nome: ");
			tmp=sc.nextLine();
			
			for(int i=0; i<tmp.length(); i++){
				c=tmp.charAt(i);
				if(Character.isDigit(c))
					a=true;
			}
			if(a)
				out.println("O nome não deve conter números!");
				
		}while(a);
		return tmp;
	}
}

class Individuo{
	int idade;
	String nome;
	double peso, altura; 
	char sexo;
 }

