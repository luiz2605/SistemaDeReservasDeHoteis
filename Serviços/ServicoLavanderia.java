package SistemaDeReservasHotel.Serviços;

import SistemaDeReservasHotel.Interface.Faturavel;

public class ServicoLavanderia implements Faturavel {

    private double pesoPorQuilo;
    private double quilosDeRoupa;

    public ServicoLavanderia(double pesoPorQuilo, double quilosDeRoupa) {
        this.pesoPorQuilo = 10.0;
        this.quilosDeRoupa = quilosDeRoupa;
    }

    @Override
    public String getDescriçaoDoItem() {
        return "Lavanderia: " + this.quilosDeRoupa + "kg";
    }

    @Override
    public double getValorDoItem() {
        return this.pesoPorQuilo * quilosDeRoupa;
    }
}
