# 🏨 Sistema de Reservas de Hotéis

Sistema desenvolvido em **Java** para gerenciar o ciclo de hospedagem, desde a reserva de quartos até o controle de consumo e fechamento de conta. O projeto foca na aplicação prática de **Programação Orientada a Objetos** para resolver problemas reais de logística hoteleira.

## 🚀 Diferenciais Técnicos

* **Polimorfismo com Interfaces:** Implementação da interface `Faturavel` para unificar itens de naturezas distintas (Diárias, Frigobar, Lavanderia) em um único sistema de extrato.
* **Manipulação de Dados:** Uso de **Expressões Lambda** para ordenação personalizada de reservas com `Arrays.sort`.
* **Arquitetura Organizada:** Divisão clara de responsabilidades entre pacotes (`Cliente`, `Sistema`, `Serviços`, `Interface`).

## 🛠️ Funcionalidades

- **Gestão de Estadia:** Cadastro de hóspedes e cálculo automático de diárias.
- **Serviços Extras:** Adição dinâmica de itens de frigobar e serviços de lavanderia por peso.
- **Extrato Transparente:** Geração de faturas detalhadas listando descrição e valor individual de cada item consumido.
- **Busca e Relatórios:** Listagem organizada e busca de reservas por nome do cliente.

## 📦 Como executar
1. Clone o repositório.
2. Compile e rode a classe `Main.java` (pacote `Exec`).
3. Siga as instruções no console.

---
Desenvolvido como parte dos meus estudos em Java e POO.
