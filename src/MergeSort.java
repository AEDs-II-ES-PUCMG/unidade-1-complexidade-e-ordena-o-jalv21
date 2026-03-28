public class MergeSort<T extends Comparable<T>> implements IOrdenador<T> {

    @Override
    public T[] ordenar(T[] dados) {
        
    }

    public void mergesort(T[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            merge(array, esq, meio, dir);
        }
    }

    /// Intercalação
    /// 1) Inicializar duas variáveis de controle (i e j) com valor 0. 
    /// Vão apontar os elementos a serem comparados.
    /// 2) obter n = min(V1[i], V2[j]) 
    /// 3) Adicionar n ao valor resultante e incrementar o valor da variável do vetor escolhido.
    /// (i++ ou j++)
    /// 4) Repita 2 e 3 até chegar no final de um dos vetores. (i == v1.length ou j == v2.length)
    /// 5) Insira os elementos do vetor restante ao final do vetor resultante (mantenha a ordem)
    public void merge(int[] array, int esq, int meio, int dir) {
        int n1, n2, i, j, k;

        n1 = meio - esq + 1;
        n2 = dir - meio;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        // Inicializar primeiro subarray
        for(i = 0; i < n1; i++)
            a1[i] = array[esq + i];

        // Inicializar segundo subarray
        for(j = 0; j < n2; j++)
            a2[j] = array[meio + j + 1];

        // Intecalação
        for(i = j = 0, k = esq; (i < n1 && j < n2); k++) {
            if(a1[i] <= a2[j])
                array[k] = a1[i++];
            else
                array[k] = a2[j++];
        }

        if(i == n1) {
            for(; k <= dir; k++)
                array[k] = a2[j++];
        } else {
            
        }
    }

    @Override
    public long getComparacoes() {
        // TODO Auto-generated method stub
        return 0; 
    }

    @Override
    public long getMovimentacoes() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getTempoOrdenacao() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
