package SistemaDeReservasHotel.Serviços;

import SistemaDeReservasHotel.Interface.Faturavel;

public class ItemFrigobar  implements Faturavel {

    private String nomeDoItem;
    private double valorDoItem;
    private int quantidade;

    public ItemFrigobar(String nomeDoItem, double valorDoItem, int quantidade) {
        this.nomeDoItem = nomeDoItem;
        this.valorDoItem = valorDoItem;
        this.quantidade = quantidade;
    }

    @Override
    public String getDescriçaoDoItem() {
        return "Item: " + nomeDoItem + "/" + "Valor do item: " + valorDoItem + "/" + "Quantidade: " + quantidade;
    }

    @Override
    public double getValorDoItem() {
        return this.valorDoItem * this.quantidade;
    }
}
