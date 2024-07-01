package Hero;
import Inimigos.Inimigo;
import java.util.Random;

public class Guerreiro extends Personagem {
    private boolean habilidadeUsada = false;

    public Guerreiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    public void gritoDeGuerra(Inimigo inimigo) {
        if (!habilidadeUsada) {
            System.out.println(nome + " solta um Grito de Guerra fortalecendo-se!");
            vida += 15;
            ataque += 15;
            habilidadeUsada = true;
        } else {
            System.out.println("A habilidade Grito de Guerra já foi usada. Atacando normalmente.");
            atacar(inimigo);
        }
    }

    public void corteProfundo(Personagem alvo) {
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > alvo.getDefesa()) {
            System.out.println(nome + " usa Corte Profundo em " + alvo.getNome() + "!");
            alvo.receberDano(ataque);
            alvo.setSangrando(true);
        } else {
            System.out.println(nome + " tentou usar Corte Profundo, mas falhou.");
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " ataca com força bruta!");
        super.atacar(alvo);
    }

    @Override
    public void defender() {
        System.out.println(nome + " levanta seu escudo para defender!");
        defesa += 3;
    }

    @Override
    public String getTipo() {
        return "Humanoide";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }

    public boolean isHabilidadeUsada() {
        return habilidadeUsada;
    }

    public void setHabilidadeUsada(boolean habilidadeUsada) {
        this.habilidadeUsada = habilidadeUsada;
    }
}