package SistemaDeReservasHotel.Exec;

import SistemaDeReservasHotel.Cliente.ContaDoHospede;
import SistemaDeReservasHotel.Cliente.Hospede;
import SistemaDeReservasHotel.Serviços.ItemFrigobar;
import SistemaDeReservasHotel.Serviços.ServicoLavanderia;
import SistemaDeReservasHotel.Sistema.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Reserva reserva = new Reserva();
        Reserva[] reservas = new Reserva[10];
        List<ContaDoHospede> contasDosHospedes = new ArrayList<>();
        int contadorDeReservas = 0;
        boolean execucao = true;


        while (execucao){
            System.out.println("Menu Principal: ");
            System.out.println(" 1 - Nova reserva");
            System.out.println(" 2 - Listar reserva");
            System.out.println(" 3 - Buscar reserva por nome do hospede");
            System.out.println(" 4 - Conta do hospede");
            System.out.println(" 5 - Sair");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1:
                    if(contadorDeReservas < 10){
                        Hospede hospede = new Hospede();
                        System.out.println("Nome do hospede: ");
                        hospede.setNome(scanner.nextLine());
                        System.out.println("CPF do hospede: " );
                        hospede.setCpf(scanner.nextLine());
                        hospede = new Hospede(hospede.getNome(), hospede.getCpf());

                        System.out.println("Escolha o tipo do quarto: ");
                        System.out.println(" 1 - Deluxe: 300.0");
                        System.out.println(" 2 - Standard: 200.0");
                        System.out.println(" 3 - Padrao: 100.0");

                        int opcQuarto = Integer.parseInt(scanner.nextLine());

                        switch (opcQuarto){
                            case 1:
                                reserva.setTipoDoQuarto("Deluxe");
                                reserva.setValorDaDiaria(300.0);
                                break;
                            case 2:
                                reserva.setTipoDoQuarto("Standard");
                                reserva.setValorDaDiaria(200.0);
                                break;
                            case 3:
                                reserva.setTipoDoQuarto("Padrao");
                                reserva.setValorDaDiaria(100.0);
                                break;
                            default:
                                System.out.println("Opção de quarto inválida. Usando Padrão.");
                                break;
                        }

                        System.out.println("Quantidade de diarias: ");
                        reserva.setNumeroDiasDiarias(Integer.parseInt(scanner.nextLine()));
                        System.out.println("O valor de cada diaria sera " + reserva.getValorDaDiaria());
                        reserva.valorTotalDiarias();
                        System.out.println("Total das diarias: " + reserva.getValorTotalDasDiarias());

                        System.out.println("Deseja confirmar a reserva?");
                        System.out.println("Sim ou Nao");
                        String opcaoConfirmacao;
                        opcaoConfirmacao = scanner.nextLine();

                        if(opcaoConfirmacao.equalsIgnoreCase("sim")){
                            reserva = new Reserva(hospede, reserva.getTipoDoQuarto(), reserva.getNumeroDiasDiarias(), reserva.getValorDaDiaria());
                            reservas[contadorDeReservas] = reserva;
                            contadorDeReservas++;
                            ContaDoHospede contaDoHospede = new ContaDoHospede(hospede);
                            contasDosHospedes.add(contaDoHospede);
                        }
                        else{
                            System.out.println("Reserva cancelada");
                            return;
                        }

                    }
                    else{
                        throw new IllegalArgumentException("Nao temos mais vagas para reservas");
                    }
                    break;

                case 2:
                    System.out.println("Lista de reservas: ");
                    reserva.listarReservas(reservas, contadorDeReservas);
                    break;

                case 3:
                    System.out.println("Digite o nome do hospede: ");
                    String nomeDeBusca = scanner.nextLine();

                    Reserva reservaEncontrada = null;

                    for(Reserva r1: reservas){
                        if(r1 != null && r1.getHospede().getNome().equalsIgnoreCase(nomeDeBusca)){
                            reservaEncontrada = r1;
                            break;
                        }
                    }
                        if(reservaEncontrada != null){
                            System.out.println("Reserva encontrada:");
                            System.out.println(reservaEncontrada);
                        }
                        else{
                            System.out.println("Reserva nao encontrada!");
                        }
                    break;

                case 4:
                    System.out.println("Digite o nome do hospede que deseja consultar o extrato: ");
                    String nomeBusca = scanner.nextLine();
                    ContaDoHospede contaEncontrada = null;

                    for(ContaDoHospede conta: contasDosHospedes){
                        if(conta.getHospede().getNome().equalsIgnoreCase(nomeBusca)){
                            contaEncontrada = conta;
                            break;
                        }
                    }
                        if(contaEncontrada != null){
                            System.out.println("Conta encontrada com sucesso");
                            System.out.println(contaEncontrada);
                        }
                        else{
                            System.out.println("Conta nao encontrada!");
                        }
                        System.out.println("Quais servicos o hospede utilizou? ");
                        System.out.println("1 - Servico de lavanderia ");
                        System.out.println("2 - Servico de frigobar ");

                        int opcaoConta = 0;
                        opcaoConta = scanner.nextInt();

                        switch (opcaoConta){
                            case 1:
                                System.out.println("Quantos quilos de roupa?: ");
                                double peso = Double.parseDouble(scanner.nextLine());
                                scanner.nextLine();
                                ServicoLavanderia servicoLavanderia = new ServicoLavanderia(10, peso);
                                contaEncontrada.adiconarItensNaConta(servicoLavanderia);
                                break;

                            case 2:
                                System.out.println("Digite o nome do produto, valor e quantidade");
                                String nomeDoProduto = scanner.nextLine();
                                double precoDoProduto = Double.parseDouble(scanner.nextLine());
                                int quantidadeProduto = Integer.parseInt(scanner.nextLine());

                                ItemFrigobar itemFrigobar = new ItemFrigobar(nomeDoProduto, precoDoProduto, quantidadeProduto);
                                contaEncontrada.adiconarItensNaConta(itemFrigobar);
                                break;
                        }
                        contaEncontrada.ExtratoHospede();

                case 5:
                    System.out.println("Saindo do sistema...");
                    execucao = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
            scanner.close();

    }
}
