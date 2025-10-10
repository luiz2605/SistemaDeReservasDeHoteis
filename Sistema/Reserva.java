package SistemaDeReservasHotel.Sistema;

import SistemaDeReservasHotel.Cliente.Hospede;
import SistemaDeReservasHotel.Interface.Faturavel;

import java.util.Arrays;

import static jdk.internal.foreign.abi.s390.S390Architecture.Regs.r1;
import static jdk.internal.foreign.abi.s390.S390Architecture.Regs.r2;

public class Reserva implements Faturavel {

    private Hospede hospede;
    private String tipoDoQuarto;
    private int numeroDiasDiarias;
    private double valorTotalDasDiarias;
    private double valorDaDiaria;

    public Reserva(Hospede hospede, String tipoDoQuarto, int numeroDiasDiarias, double valorDaDiaria) {
        this.hospede = hospede;
        this.tipoDoQuarto = tipoDoQuarto;
        this.numeroDiasDiarias = numeroDiasDiarias;
        this.valorDaDiaria = valorDaDiaria;
    }

    public Reserva() {
    }

    public double valorTotalDiarias(){
        this.valorTotalDasDiarias = this.numeroDiasDiarias * this.valorDaDiaria;
        return  (double)this.valorTotalDasDiarias;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hospede=" + hospede +
                ", tipoDoQuarto='" + tipoDoQuarto + '\'' +
                ", numeroDiasDiarias=" + numeroDiasDiarias +
                ", valorTotalDasDiarias=" + valorTotalDasDiarias +
                ", valorDaDiaria=" + valorDaDiaria +
                '}';
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setValorDaDiaria(double valorDaDiaria) {
        this.valorDaDiaria = valorDaDiaria;
    }

    public void setTipoDoQuarto(String tipoDoQuarto) {
        this.tipoDoQuarto = tipoDoQuarto;
    }

    public void setNumeroDiasDiarias(int numeroDiasDiarias) {
        this.numeroDiasDiarias = numeroDiasDiarias;
    }

    public void setValorTotalDasDiarias(double valorTotalDasDiarias) {
        this.valorTotalDasDiarias = valorTotalDasDiarias;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public double getValorDaDiaria() {
        return valorDaDiaria;
    }

    public String getTipoDoQuarto() {
        return tipoDoQuarto;
    }

    public int getNumeroDiasDiarias() {
        return numeroDiasDiarias;
    }

    public double getValorTotalDasDiarias() {
        return valorTotalDasDiarias;
    }

    @Override
    public String getDescriçaoDoItem() {
        return "Nome do hospede: " + hospede.getNome() + "Tipo do quarto: " + this.tipoDoQuarto +
                "Diarias: " + this.numeroDiasDiarias + "Total a pagar: " + getValorDoItem();
    }

    @Override
    public double getValorDoItem() {
        return this.numeroDiasDiarias * this.valorDaDiaria;
    }

    public void ordenarReservas(Reserva[] reservas, int quantidadeDeReservas){
        if((reservas == null) || (reservas.length < 2)){
            return;
        }
        Arrays.sort(reservas, 0, quantidadeDeReservas, (r1, r2) -> Integer.compare(r2.getNumeroDiasDiarias(), r1.getNumeroDiasDiarias()));
        // Ele vai ordenar o vetor 'reservas', começando da posição 0 até a posição 'quantidadeDeReservas'.
        // As posições 'null' depois disso serão ignoradas.
    }

    public void listarReservas(Reserva[] reservas, int quantidadeDeReservas){
        ordenarReservas(reservas, quantidadeDeReservas);
        for(int i = 0;i < quantidadeDeReservas; i++){
            System.out.println(reservas[i]);
        }
    }
}
