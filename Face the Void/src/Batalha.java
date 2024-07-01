import java.util.Scanner;
import java.util.Random;
import Hero.*;
import Inimigos.*;

public class Batalha {

    public static String turnoDeCombate(Personagem personagem, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean batalhaAcabou = false;
        boolean fugiu = false;
        int turnosAdormecido = 0;

        while (personagem.isVivo() && inimigo.isVivo() && !fugiu) {
            System.out.println();
            System.out.println("Turno de " + personagem.getNome() + ":");
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Habilidade Especial");
            System.out.println("3 - Defender");
            System.out.println("4 - Tentar Fugir");

            int escolhaAcao = scanner.nextInt();

            if (escolhaAcao == 4) {
                int roll = random.nextInt(20) + 1;
                System.out.println(personagem.getNome() + " está tentando fugir...");
                if (roll > 10) {
                    System.out.println(personagem.getNome() + " conseguiu fugir da batalha!");
                    fugiu = true;
                    batalhaAcabou = true;
                } else {
                    System.out.println(personagem.getNome() + " tentou fugir, mas falhou.");
                }
            } else if (escolhaAcao == 2) {
                escolherHabilidadeEspecial(personagem, inimigo, random);
                personagem.passarTurno();
                if (personagem.isAdormecido()) {
                    turnosAdormecido = 2;
                }
            } else {
                if (escolhaAcao == 1) {
                    personagem.atacar(inimigo);
                    personagem.passarTurno();
                } else if (escolhaAcao == 3) {
                    int roll = random.nextInt(20) + 1;
                    if (roll > 10) {
                        personagem.defender();
                        personagem.passarTurno();
                    } else {
                        System.out.println(personagem.getNome() + " tentou se defender, mas falhou.");
                    }
                }

                if (!batalhaAcabou && inimigo.isVivo()) {
                    System.out.println("Fim do turno de " + personagem.getNome() + ".");
                    System.out.println("\nTurno de " + inimigo.getNome() + "...");
                    turnoInimigo(personagem, inimigo);
                }
            }

            if (turnosAdormecido > 0) {
                turnosAdormecido--;
                if (turnosAdormecido == 0) {
                    personagem.setAdormecido(false);
                    System.out.println(personagem.getNome() + " acordou!");
                }
            }

            if (fugiu) {
                return "fugiu";
            }
        }

        if (!personagem.isVivo()) {
            return "derrota";
        } else if (!inimigo.isVivo()) {
            return "vitoria";
        }

        return "fugiu";
    }

    private static void escolherHabilidadeEspecial(Personagem personagem, Inimigo inimigo, Random random) {
        System.out.println("Escolha sua habilidade especial:");
        if (personagem instanceof Guerreiro) {
            System.out.println("1 - Grito de Guerra");
            System.out.println("2 - Corte Profundo");
        } else if (personagem instanceof Arqueiro) {
            System.out.println("1 - Tiro Rápido");
            System.out.println("2 - Flecha no Calcanhar");
        } else if (personagem instanceof Mago) {
            System.out.println("1 - FireBolt");
            System.out.println("2 - Imobilizar com Magia");
        }

        int escolhaHabilidade = new Scanner(System.in).nextInt();

        if (personagem instanceof Guerreiro) {
            if (escolhaHabilidade == 1) {
                ((Guerreiro) personagem).gritoDeGuerra(inimigo);
            } else if (escolhaHabilidade == 2) {
                ((Guerreiro) personagem).corteProfundo(inimigo);
            }
        } else if (personagem instanceof Arqueiro) {
            if (escolhaHabilidade == 1) {
                ((Arqueiro) personagem).tiroRapido(inimigo);
            } else if (escolhaHabilidade == 2) {
                ((Arqueiro) personagem).flechaNoCalcanhar(inimigo);
            }
        } else if (personagem instanceof Mago) {
            if (escolhaHabilidade == 1) {
                ((Mago) personagem).fireBolt(inimigo);
            } else if (escolhaHabilidade == 2) {
                ((Mago) personagem).imobilizarComMagia(inimigo);
            }
        }

        if (personagem instanceof Hypnotizer && random.nextInt(100) < 50) {
            personagem.setAdormecido(true);
            System.out.println(personagem.getNome() + " foi adormecido pelo Hypnotizer!");
        }
    }

    private static void turnoInimigo(Personagem personagem, Inimigo inimigo) {
        Random random = new Random();

        if (inimigo instanceof Demon && inimigo.getVida() < inimigo.getVidaMaxima() / 2) {
            Demon demon = (Demon) inimigo;
            demon.usarHabilidadeEspecial(personagem);
            if (personagem.isAtordoado()) {
                System.out.println(personagem.getNome() + " está atordoado e perdeu seu turno!");
                personagem.setAtordoado(false);
            }
        } else if (inimigo instanceof Dragon && inimigo.getVida() < inimigo.getVidaMaxima() / 2) {
            Dragon dragon = (Dragon) inimigo;
            dragon.usarHabilidadeEspecial(personagem);
            if (personagem.isAtordoado()) {
                System.out.println(personagem.getNome() + " está atordoado e perdeu seu turno!");
                personagem.setAtordoado(false);
            }
        } else {
            if (inimigo.getVida() < inimigo.getVidaMaxima() / 2) {
                if (inimigo instanceof Demon) {
                    Demon demon = (Demon) inimigo;
                    demon.usarHabilidadeEspecial(personagem);
                } else if (inimigo instanceof Dragon) {
                    Dragon dragon = (Dragon) inimigo;
                    dragon.usarHabilidadeEspecial(personagem);
                }
            } else {
                if (inimigo.isAtordoado()) {
                    System.out.println(inimigo.getNome() + " está atordoado e perdeu seu turno!");
                    inimigo.setAtordoado(false);
                } else {
                    inimigo.atacar(personagem);
                }
            }
        }

        if (!personagem.isVivo()) {
            System.out.println(personagem.getNome() + " foi derrotado!");
        } else {
            System.out.println("Fim do turno de " + inimigo.getNome() + ".");
            System.out.println("\nTurno de " + personagem.getNome() + "...");
        }
    }
}