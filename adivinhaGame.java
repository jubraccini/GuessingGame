import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class adivinhaGame {

    public static void main(String[] args) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativas = 0;
        int limiteTentativas = 10;
        boolean acertou = false;
        List<Integer> palpites = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar o número entre 1 e 100.");

        while (tentativas < limiteTentativas) {
            System.out.printf("Tentativa %d de %d. Qual é o seu palpite? ", tentativas + 1, limiteTentativas);
            int palpite = scanner.nextInt();

            if (palpites.contains(palpite)) {
                System.out.println("Você já tentou esse número. Tente outro.");
                continue;
            }

            palpites.add(palpite);
            tentativas++;

            if (palpite == numeroAleatorio) {
                acertou = true;
                break;
            } else if (palpite < numeroAleatorio) {
                System.out.println("Mais alto...");
            } else {
                System.out.println("Mais baixo...");
            }
        }

        if (acertou) {
            System.out.printf("Parabéns! Você acertou o número em %d tentativas.\n", tentativas);
        } else {
            System.out.printf("Você esgotou todas as suas %d tentativas. O número era %d.\n", limiteTentativas, numeroAleatorio);
        }

        scanner.close();
    }
}
