import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorVolumeItens implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        return (int) (o1.getQuantosProdutos() - o2.getQuantosProdutos());
    }
}
