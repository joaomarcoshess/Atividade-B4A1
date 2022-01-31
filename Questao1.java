import java.util.Scanner;

class Pessoa{
    private String Nome;
    private int DataNascimento;
    private double Altura;
    public int Qtd = 11, i;
    public String Vetor[] = {"Jaum", "Pedro", "Isis", "Carlos", "Roberto", "Olavo", "Lazaro", "Maria", "Humberto", "Mônica"};
    public int VetorDN[] = {0,1,2,3,4,5,6,7,8,9};
    public double VetorA[] = {0,1,2,3,4,5,6,7,8,9}; 
    
    Scanner input = new Scanner ( System.in );
    
    public void Inicializa(String N, int DN, double A){
        System.out.println("----------------------------------------");
        System.out.println(" ");
        while(this.Qtd > 10 || this.Qtd < 1){
            System.out.println("Quantas pessoas terão nesta agenda? (Máximo de 10)");
            String q = input.next();
            DN = Integer.parseInt(q);
            this.Qtd = DN;
        }
        System.out.println(" ");
        for(i = 0; i < Qtd; i++){
            
            System.out.println("Informe o seu nome: ");
            N = input.next();
            this.Nome = N;
            System.out.println(" ");
            System.out.println("Informe a sua data de nascimento: ");
            String Year = input.next();
            DN = Integer.parseInt(Year);
            this.DataNascimento = DN;
            CalculaIdade();
            VetorDN[i] = this.DataNascimento;
            System.out.println(" ");
            System.out.println("Informe a sua altura: ");
            String Alt = input.next();
            int Altur = Integer.parseInt(Alt);
            A = new Double(Alt);
            A = A / 100;
            this.Altura = A;
            VetorA[i] = this.Altura;
            Vetor[i] = this.Nome;
            System.out.println(" ");
            Imprimir();
            
        }
    }
    
    public void CalculaIdade(){
        this.DataNascimento = 2022 - this.DataNascimento;
    }

    public void Imprimir(){
        System.out.println("Nome: " + this.Nome);
    	System.out.println("");
    	System.out.println("Data de Nascimento: " + this.DataNascimento);
    	System.out.println("");
    	System.out.println("Altura: " + this.Altura);
    	System.out.println("");
    
    }

//Sets
    public void setNome(){
        this.Nome = this.Nome;
    }
    
    public void setData(){
        this.DataNascimento = this.DataNascimento;
    }
    
    public void setAltura(){
        this.Altura = this.Altura;
    }


    
//Gets  
    public String getNome(){
        return Nome;
    }
    
    public int getData(){
        return DataNascimento;
    }
    
    public Double getAltura(){
        return Altura;
    }
    
}


class Agenda extends Pessoa{
    
    public int compara;
    
    public void armazenaPessoa(String N, int DN, double A){
        Inicializa("A", 1, 2.1);
    }
    
    public void removePessoa(String N){
        System.out.println("");
        System.out.println("Insira o nome da pessoa que você deseja remover da agenda:");
        N = input.next();
        for(i = 0; i < Qtd; i++){
            compara = N.compareTo(Vetor[i]);
            if(compara == 0){
                Vetor[i] = null;
                i = Qtd;
            }else{
                if(i == Qtd){
                    System.out.println("Desculpe, essa pessoa não existe na agenda.");
                }
                
            }
        }
        
    }
    
    public int buscaPessoa(String N){
        System.out.println("");
        System.out.println("Por quem você procura?");
        N = input.next();
        for(i = 0; i < Qtd; i++){
            compara = N.compareTo(Vetor[i]);
            if(compara == 0){
                System.out.println(Vetor[i] + " está na posição: " + i);
                i = Qtd;
            }else{
                if(i+1 == Qtd && compara != 0){
                    System.out.println("Desculpe, essa pessoa não existe na agenda.");
                }
            }
        }
        return i;
    }
    
    public void imprimeAgenda(){
        for(i = 0; i < Qtd; i++){
            System.out.println("Nome: " + this.Vetor[i]);
        }
    }
    
    public void imprimePessoa(int index){
        System.out.println("Você quer ver a pessoa de qual posição?");
        String numero = input.next();
        index = Integer.parseInt(numero);
        System.out.println(" ");
        System.out.println("Nome: " + Vetor[index]);
        System.out.println("Data: " + VetorDN[index]);
        System.out.println("Altura: " + VetorA[index]);
    }
    
}


public class Main
{
	public static void main(String[] args) {
		Pessoa P = new Pessoa();
		Agenda Ag = new Agenda();
		Ag.armazenaPessoa("A", 1, 2.1);
		Scanner inserircase = new Scanner ( System.in );
		
		while(true){
		    System.out.println("");
    		System.out.println("Como deseja operar a sua agenda? ");
    		System.out.println("Aperte 1 para remover uma pessoa.");
    		System.out.println("Aperte 2 para buscar uma pessoa.");
    		System.out.println("Aperte 3 para visualizar as pessoas da sua agenda.");
    		System.out.println("Aperte 4 para ver os dados específicos de uma pessoa.");
    		System.out.println("Aperte 5 para sair.");
    		
    		String operacao = inserircase.next();
    		int operar = Integer.parseInt(operacao);
        	    switch(operar){
        	        case 1:
        	            Ag.removePessoa("Bernadete");
        	            System.out.flush();
        	            break;
        	        case 2:
        	            Ag.buscaPessoa("Ilma");
        	            System.out.flush();
        	            break;
        	        case 3:
        	            Ag.imprimeAgenda();
        	            System.out.flush();
        	            break;
        	        case 4:
        	            Ag.imprimePessoa(1);
        	            System.out.flush();
        	            break;
        	        case 5:
        	            System.exit(0);
        	            break;
        	    }  
    		
    	}
	}
}
