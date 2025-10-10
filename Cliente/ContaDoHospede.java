package SistemaDeReservasHotel.Cliente;

import SistemaDeReservasHotel.Interface.Faturavel;

import java.util.ArrayList;
import java.util.List;

public class ContaDoHospede {

    private Hospede hospede;

    public ContaDoHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    List<Faturavel> itensDaConta = new ArrayList<>();

    public void adiconarItensNaConta(Faturavel item){
        this.itensDaConta.add(item);
    }

    public double calcularTotal(){
        double valorTotal = 0.0;
        for(Faturavel item : itensDaConta){
            valorTotal += item.getValorDoItem();
        }
        return valorTotal;
    }

    public void ExtratoHospede(){
        System.out.println("O extrato do hospede " + hospede.getNome());
        for(Faturavel item : itensDaConta){
            System.out.println(item.getDescriçaoDoItem() + ": R$ " + item.getValorDoItem());
        }
        System.out.println("Total: " + calcularTotal());

    }


}