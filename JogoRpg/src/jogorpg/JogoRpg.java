package jogorpg;
import java.util.Scanner;
import java.util.Random;

public class JogoRpg {
   
    static int ataqueUsuario(){
        Scanner leitor = new Scanner(System.in);
        int escolhaAtaque;
        
        System.out.println("Escolha seu ataque");
        System.out.println("(1) - Soco");
        System.out.println("(2) - Especial");
        return leitor.nextInt();
    }
    
    static int ataqueComputador(){
        Random gerador = new Random();
        return gerador.nextInt(3)+1; // retorna o numero entre 1 e 3.
    }
    static void imprimeHP(int hpUsuario, int hpComputador,int contagemEspecial){
        System.out.println("================================");
        System.out.println("- HP Usuario:" +hpUsuario);
        System.out.println("- HP Computador:" +hpComputador);
        System.out.println("Especiais : "+contagemEspecial);
        System.out.println("================================");
    }
    
    static int batalha(){
        int hpUsuario = 150;
        int hpComputador=11;
        int contagemEspecial=10;
        int escolhaAtaque;
        int i = 1;
        
        while(hpUsuario > 0){
            hpComputador = 10 + i;
           System.out.println("================================");
           System.out.println("Monstro " + i);
           System.out.println("================================");
        
        while(hpUsuario > 0 &&  hpComputador > 0){
            imprimeHP(hpUsuario , hpComputador,contagemEspecial);
            escolhaAtaque= ataqueUsuario();
            switch(escolhaAtaque){
                case 1:
                    System.out.println("Usuario deu um soco no Monstro!!!!!!!!!");
                    hpComputador -= 7;
                    break;
                case 2 :
                    System.out.println("Usuario aplicou um Super ataque ao Monstro!!!!!!");
                    hpComputador -= 20;
                    contagemEspecial --;
                    break;
                default:
                    System.out.println("Opcao invalida voce perdeu seu ataque.");
                    break;
            }
            if(hpComputador > 0){
                escolhaAtaque = ataqueComputador();
                switch(escolhaAtaque){
                    case 1: 
                        System.out.println("Voce tomou um soco do monstro!");
                        hpUsuario -= 2 + (int)(i / 10);
                        break;
                    case 2: 
                        System.out.println("O monstro lhe deu um chute");
                        hpUsuario -= 3 + (int)(i / 10);
                        break;
                    case 3: 
                        System.out.println("O monstro lhe deu uma ultra mordida!!!!!");
                        hpUsuario -=4 + (int)(i / 20);
                        break;
                }
            }
            else{
                System.out.println("Monstro derrotado!!!!!!");
            }
        }
        if(hpUsuario >0){
            hpUsuario +=7;
            if(hpUsuario >150){
                hpUsuario = 150;
            }
            if(i % 10 == 0){
               contagemEspecial++;
               if(contagemEspecial > 10){
                   contagemEspecial = 10;
               }
            }
        }
        i++;
        }
        return i;
    }
            
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continua = 1;
        int recorde = 0;
        while (continua == 1){
            int pontos = batalha();
            System.out.println("Jogador chegou a " + pontos + "pontos");
            if(pontos > recorde){
                recorde = pontos;
            }
            System.out.println("Jogador DERROTADO .Deseja continuar sua jornada?(1)- Sim (2)- Não");
            continua = leitor.nextInt();
        }
        
      
    }
    
}
