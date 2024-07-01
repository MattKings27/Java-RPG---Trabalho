package Hero;

import Hero.Classes.Arqueiro;
import Hero.Classes.Guerreiro;
import Hero.Classes.Mago;

import java.io.IOException;
import java.util.Scanner;


public class Jogo {

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

    public static void aventura1() {

        Scanner scanner = new Scanner(System.in);

        textoRPG("Escuridão... \nEscuridão é tudo o que parece existir...\nDe repente, você enxerga uma pequena luz em seu âmago, parece não existir uma forma à sua volta \nVocê se vê apenas como uma chama flutuante em meio ao nada");
        textoRPG("\nA chama dançante então começa a vibrar... \nVocê vai ganhando os sentidos um de cada vez... \nÀ distância, você vê uma forma, um homem enrome, sob vestes brancas e olhos azuis que ofuscam o brilho de sua forma");
        textoRPG("\nACORDE! você escuta dentro de sua alma");
        textoRPG("\nTRRRRRRRRK a realidade parece rachar enquanto você é atraído para o interior da fenda");

        System.out.println("\n");

        System.out.println("Quando retorna aos seus sentidos, você se vê em uma fila, homens e mulheres de distintas raças, idades e feições estão ali presentes");
        System.out.println("Guarda: Próximo! - Grita um homem de armadura vermelha e prateada com uma lista nas mãos");
        System.out.println("Guarda: Hm.. achei que tinha acabado de conferir os suspeitos, não vejo seu nome aqui.. devem ter esquecido de novo..");
        System.out.println("(Malditos novatos..) sussurra o homem, mas por algum motivo você escuta claramente");

        System.out.println("\n");

        System.out.println("Guarda: Pois bem.. Qual o seu nome prisioneiro?");
        String nome = scanner.nextLine();
        if (nome.matches("\\d+")) {
            System.out.println("Que nome mais estranho... mas bem... acho que na sua condição tanto faz.");
        }

        System.out.println("\n");
        System.out.println("Guarda: Hm... nunca ouvi falar, pois bem " + nome + ", e o que você fazia da vida?");

        String classe = "";

        while (true) {
            System.out.println("1 - Fui treinado para brandir minha espada e minhas armas com maestria (Guerreiro)");
            System.out.println("2 - Era um estudioso buscando mais conhecimento sobre o mundo e o véu por trás dele (Mago)");
            System.out.println("3 - Buscava incansavelmente ter a melhor e mais precisa mira entre todos os seres (Arqueiro)");

            if (scanner.hasNextInt()) {
                int escolhaClasse = scanner.nextInt();

                if (escolhaClasse == 1) {
                    classe = "guerreiro";
                    break;
                } else if (escolhaClasse == 2) {
                    classe = "mago";
                    break;
                } else if (escolhaClasse == 3) {
                    classe = "arqueiro";
                    break;
                }

            } else {
                System.out.println("Você está bêbado?! Não entendi o que você fazia. Tente mais uma vez e não me estresse!.");
                scanner.next();
            }
        }

        System.out.println("Hm... entendi, de toda forma deve ter dado errado pra você vir parar aqui");


        System.out.println();
        System.out.println("Enquanto o homem se vira para os demais oficiais presentes, você sente um formigamento, sua alma começa a se moldar de acordo com seu corpo.");
        System.out.println("Seus músculos se movem por baixo da pele, sua mente contrai e expande, sua percepção se altera, você sente uma enorme tontura, e..");
        System.out.println();

        int pontos = 27;
        int[] atributos = {8, 8, 8, 8, 8, 8}; // Força, Destreza, Constituição, Inteligência, Sabedoria, Carisma

        System.out.println("Você se sente capaz de alterar o próprio corpo!");
        System.out.println("O tempo parece parar por alguns segundos.. enquanto isso:");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }


        String[] nomesAtributos = {"Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma"};

        while (pontos >= 0) {

            if (pontos == 0) {
                System.out.println("Deseja confirmar os atributos? Y/N");
                String confirmar = scanner.next();
                if (confirmar.equalsIgnoreCase("y")) {
                    break;
                } else if (confirmar.equalsIgnoreCase("n")) {
                    pontos = 27;
                    atributos = new int[]{8, 8, 8, 8, 8, 8};
                    continue;
                }
            }
            System.out.println("\nAtributos atuais:");
            for (int i = 0; i < atributos.length; i++) {
                System.out.println(nomesAtributos[i] + ": " + atributos[i]);
            }

            System.out.println("Pontos restantes: " + pontos);
            System.out.print("Escolha um atributo para aumentar (1-Força, 2-Destreza, 3-Constituição, 4-Inteligência, 5-Sabedoria, 6-Carisma): \n");
            System.out.println("Caso precise de ajuda sobre os atributos, digite 'H'");
            System.out.println("Para adicionar aleatoriamente os atributos, digite 'A'");
            System.out.println();


            String escolhaStr = scanner.next();
            int escolha;
            if ("H".equalsIgnoreCase(escolhaStr)) {
                System.out.println("Menu de detalhamento de atributos:");
                System.out.println("Força: Ataque corpo a corpo e atletismo geral\n" +
                        "Destreza: Ataque a distancia, agilidade e precisão\n" +
                        "Constituição: Fôlego, vigor e vida máxima\n" +
                        "Inteligência: Ataque mágico, memória e conhecimento arcano\n" +
                        "Sabedoria: Conhecimento do mundo, sobrevivência e Percepção\n" +
                        "Carisma: Nuances sociais, habilidades interativas\"");


            } else if ("A".equalsIgnoreCase(escolhaStr)) {
                for (int i = 0; i < atributos.length; i++) {
                    int pontosAleatorios = (int) (Math.random() * pontos) + 1;
                    if (pontos >= pontosAleatorios && pontos > 0) {
                        int novoValor = atributos[i] + pontosAleatorios;
                        if (novoValor <= 15) {
                            atributos[i] = novoValor;
                            pontos -= pontosAleatorios;
                        }
                    }
                }
                System.out.println("Os pontos foram distribuídos aleatoriamente!");

            } else {
                try {
                    escolha = Integer.parseInt(escolhaStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Escolha inválida, escolha um número válido");
                    continue;
                }

                System.out.print("Escolha quantos pontos deseja adicionar ao atributo (máximo " + pontos + " pontos restantes): ");
                int pontosEscolhidos = scanner.nextInt();

                if (pontosEscolhidos < 1 || pontosEscolhidos > pontos) {
                    System.out.println("Número de pontos inválido. Tente novamente.");
                    continue;
                }

                if (escolha < 0 || escolha >= atributos.length) {
                    System.out.println("Escolha inválida, tente novamente.");
                    continue;
                }

                if (atributos[escolha] + pontosEscolhidos >= 15) {
                    System.out.println("O valor máximo para um atributo é 15.");
                    continue;
                }

                int custoTotal = pontosEscolhidos;

                if (atributos[escolha] >= 12 && atributos[escolha] < 14) {
                    custoTotal *= 2;
                } else if (atributos[escolha] >= 14) {
                    custoTotal *= 3;
                }

                if (pontos >= custoTotal) {
                    atributos[escolha] += pontosEscolhidos;
                    pontos -= custoTotal;
                } else {
                    System.out.println("Pontos insuficientes para aumentar o atributo com essa quantidade escolhida.");
                }

            }
        }

        Personagem personagem = new Personagem(nome, atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], classe);


        System.out.println("\n O formigamento some.. O tempo volta a correr, sua aparência e físico estão completamente diferentes mas ninguém parece ter percebido:");

        System.out.println("\n Personagem criado com sucesso!");

        System.out.println("\n HP: " + personagem.getVida() + "        Defesa: " + personagem.getarmaduraNatural());
        System.out.println("\n Nome: " + personagem.getNome() + "      Classe: " + personagem.getClasse());
        System.out.println("\n Força: " + personagem.getForca());
        System.out.println(" Destreza: " + personagem.getDestreza());
        System.out.println(" Constituição: " + personagem.getConstituicao());
        System.out.println(" Inteligência: " + personagem.getInteligencia());
        System.out.println(" Sabedoria: " + personagem.getSabedoria());
        System.out.println(" Carisma: " + personagem.getCarisma());



        System.out.println("\n-------------------------------------------------------");
        System.out.println("\nA aventura se inicia, após a confirmação dos outros oficiais, o guarda vira para você e os demais prisioneiros com imponência e diz:");
        System.out.println("Sigam-me, prisioneiros! Hoje é seu último dia de vida, mas antes disso, todos terão direito a uma última refeição");
        System.out.println();
        System.out.println("O que você faz?");
        System.out.println("\n");
        System.out.println("1 - Seguir o guarda");
        System.out.println("2 - Atacar o guarda");
        System.out.println("3 - Tentar fugir\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Você segue o guarda obedientemente até o local das refeições\n");
                break;
            case 2:
                System.out.println("Você percebe suas mãos amarradas... pode ser difícil atacar o guarda assim");
                System.out.println("1 - Tentar desatar as mãos sem que ninguém perceba");
                System.out.println("2 - Tentar atacar o guarda mesmo assim");
                System.out.println("3 - Desistir e seguir o guarda\n");

                break;
            case 3:
                System.out.println("Existem muitos guardas e cidadãos observando a cena, pode ser difícil escapar dali, mas não impossível.");
                System.out.println("À sua esquerda, você percebe uma carroça sendo descarregada, talvez dê para correr, saltar nela e então para fora dos muros da cidade");
                System.out.println("1 - Correr com toda velocidade e tentar saltar da carroça para fora do muro");
                System.out.println("2 - Tentar correr pela estrada da cidade passando por todos");
                System.out.println("3 - Desistir e seguir o guarda\n");
                break;


        }

    }
}

//        // Teste de ganho de experiência
//        System.out.println("\nGanhando experiência...");
//        personagem.ganharExperiencia(300);  // Pode alterar para testar
//        System.out.println("Nível: " + personagem.getNivel());
//        System.out.println("Experiência: " + personagem.getExperiencia());


