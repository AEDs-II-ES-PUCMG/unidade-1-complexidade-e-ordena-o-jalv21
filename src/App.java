import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    static Scanner teclado = new Scanner(System.in);
    
    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }

    static void menu() {
        System.out.println("=== MÉTODOS DE ORDENAÇÃO ===\n");
        System.out.println("Escolha um método de ordenação");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.println("0. Sair");
    }

    static <T> void executarMetodoOrdenacao(Supplier<IOrdenador<T>> metodo) {

    }

    public static void main(String[] args) {
        menu();

        int opcao = -1;
        opcao = teclado.nextInt();

        switch(opcao) {
            case 0 : System.exit(0); break;
            case 1 : executarMetodoOrdenacao(BubbleSort::new); break;
            case 2 : executarMetodoOrdenacao(InsertionSort::new); break;
            case 3 : executarMetodoOrdenacao(SelectionSort::new); break;
            case 4 : executarMetodoOrdenacao(MergeSort::new); break;
        }

        int tam = 20;
        Integer[] vetor = gerarVetorObjetos(tam);

        BubbleSort<Integer> bolha = new BubbleSort<>();

        bolha.ordenar(vetor);

        System.out.println("\nVetor ordenado método Bolha:");   
        System.out.println("Comparações: " + bolha.getComparacoes());
        System.out.println("Movimentações: " + bolha.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + bolha.getTempoOrdenacao());

        InsertionSort<Integer> insercao = new InsertionSort<>();

        insercao.ordenar(vetor);

        System.out.println("\nVetor ordenado método Inserção:");
        System.out.println("Comparações: " + insercao.getComparacoes());
        System.out.println("Movimentações: " + insercao.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + insercao.getTempoOrdenacao());

        SelectionSort<Integer> selecao = new SelectionSort<>();

        selecao.ordenar(vetor);

        System.out.println("\nVetor ordenado método Seleção:");
        System.out.println("Comparações: " + selecao.getComparacoes());
        System.out.println("Movimentações: " + selecao.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + selecao.getTempoOrdenacao());
    }
}
