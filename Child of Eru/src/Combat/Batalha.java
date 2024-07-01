package Combat;
import Hero.Personagem;

import java.util.Arrays;
import java.util.Comparator;


public class Batalha {

    public void OrdemDosTurnos(Personagem[] personagens) {
        Arrays.sort(personagens, Comparator.comparingInt(Personagem::getDestreza).reversed());
    }

    public void Atacar(Personagem atacante, Personagem alvo) {
        int dano = atacante.getForca() - alvo.getarmaduraNatural();
        if (dano < 0) {
            dano = 0;
        }
        alvo.setVida(alvo.getVida() - dano);
        System.out.println(atacante.getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    public void UsarMagia(Personagem mago, Personagem alvo) {
        int danoMagia = mago.getInteligencia() * 2;
        alvo.setVida(alvo.getVida() - danoMagia);
        System.out.println(mago.getNome() + " usou magia em " + alvo.getNome() + " causando " + danoMagia + " de dano!");
    }

    public void Defender(Personagem personagem) {
        personagem.setarmaduraNatural(personagem.getarmaduraNatural() + 2);
        System.out.println(personagem.getNome() + " está se defendendo!");
    }

    public void Fugir(Personagem personagem) {
        double chanceFuga = personagem.getDestreza() * 0.1;
        if (Math.random() < chanceFuga) {
            System.out.println(personagem.getNome() + " conseguiu fugir da batalha!");
        } else {
            System.out.println(personagem.getNome() + " tentou, mas falhou em fugir da batalha.");
        }
    }
}