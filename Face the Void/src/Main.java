import java.io.IOException;
import java.util.Scanner;
import Hero.*;
import Inimigos.*;

public class Main {

    public static void textoRPG(String texto) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));

            try {
                Thread.sleep(200);
                if (System.in.available() > 0) {
                    scanner.nextLine();
                    System.out.print(texto.substring(i));
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        textoRPG("Escuridão... Escuridão é tudo o que você consegue sentir à sua volta, você se vê no Vazio, apenas um \"fogo dançante\" compõe sua forma, um espírito ao ermo...");
        textoRPG("De repente! uma figura gigante de um homem com um manto branco e os olhos azuis surge À sua frente, o próprio tecido da realidade se rasga e você é puxado para dentro.");
        textoRPG("Quando recobra os sentidos, você se vê em um espelho no meio de um corredor escuro.");

        System.out.println("\nAo olhar para o espelho, o que você vê?\n");

        System.out.println("1 - Guerreiro - Uma figura com o físico priorizado, empunhando uma espada e determinação nos olhos");
        System.out.println("2 - Arqueiro - Uma figura de aparência ágil, portando um arco e flechas brilhantes");
        System.out.println("3 - Mago - Uma figura de aparência sábia, vivida, alguém que se dedicou de forma incansável ao conhecimento");

        System.out.print("\nEscolha a classe do seu personagem [1, 2, 3]: ");
        int escolhaClasse = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do seu personagem: ");
        String nomePersonagem = scanner.nextLine();

        Personagem personagem = null;

        switch (escolhaClasse) {
            case 1:
                personagem = new Guerreiro(nomePersonagem, 12, 8, 8);
                break;
            case 2:
                personagem = new Arqueiro(nomePersonagem, 8, 10, 7);
                break;
            case 3:
                personagem = new Mago(nomePersonagem, 6, 12, 6);
                break;
            default:
                System.out.println("Escolha inválida. Quem não sabe o que quer, joga de guerreiro!");
                personagem = new Guerreiro(nomePersonagem, 12, 8, 5);
                break;
        }

        System.out.println("\nPersonagem criado:");
        System.out.println("Nome: " + personagem.getNome() + "      Classe: " + personagem.getClass().getSimpleName());
        System.out.println("HP: " + personagem.getVida() + "       Classe de Armadura: " + personagem.getDefesa());
        System.out.println("\nInício da Batalha!\n");

        Inimigo[] inimigos = {
                new Goblin("Boblin", 6, 10, 2),
                new Orc("Grug", 10, 14, 4),
                new Zumbi("Mikaeus", 15, 13, 3),
                new Hypnotizer("Alexei", 15, 14, 6),
                new Demon("Paymon", 20, 15, 8),
                new Dragon("Cryovain", 50, 20, 10)
        };

        for (Inimigo inimigo : inimigos) {
            System.out.println("Prepare-se! O próximo inimigo é um " + inimigo.getClass().getSimpleName() + "\n");

            String resultado = Batalha.turnoDeCombate(personagem, inimigo);

            if (resultado.equals("vitoria")) {
                System.out.println(personagem.getNome() + " venceu a batalha contra " + inimigo.getNome() + "!\n");
                System.out.print("Continuar o jogo? [Y/N]: ");
                String continuar = scanner.nextLine().toUpperCase();

                if (!continuar.equals("Y")) {
                    System.out.println("Fim do Jogo. Adeus, herói!");
                    return;
                }
                System.out.println();
            } else if (resultado.equals("fugiu")) {
                System.out.println(personagem.getNome() + " fugiu com medo de " + inimigo.getNome() + "!\n");
                System.out.println("GAME OVER");
                return;
            } else {
                System.out.println(inimigo.getNome() + " venceu a batalha!\n");
                System.out.println("GAME OVER");
                return;
            }
        }

        System.out.println("Parabéns! Você derrotou todos os inimigos e salvou o mundo!");
        scanner.close();
    }
}