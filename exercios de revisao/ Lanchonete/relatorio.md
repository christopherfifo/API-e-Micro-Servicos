# Documento de Design e Funcionamento

Este documento descreve as escolhas de arquitetura orientada a objetos para o protótipo da lanchonete "Quase Três Lanches".
Escolhas de Design (Arranjo entre Classes)

    Herança e Classe Abstrata: A classe Prato foi definida como a superclasse (classe pai) de forma abstrata para garantir que todos os itens de venda possuam obrigatoriamente Preço, Data de Validade e Peso. Isso evita a existência de um "prato vazio" no sistema.

    Especialização: As classes Pizza, Lanche e Salgadinho estendem Prato, herdando seus atributos e adicionando características específicas exigidas pelos proprietários, como tipo de borda, tipo de pão ou tipo de massa (frito/assado).

    Composição: A classe Pedido utiliza um ArrayList<Prato>, permitindo que um único pedido contenha múltiplos itens de diferentes categorias (Pizza, Lanche ou Salgadinho) de forma dinâmica.

    Polimorfismo: O método calcularPreco() e a sobrescrita de toString() permitem que o sistema trate objetos de subclasses diferentes através de uma referência da superclasse, facilitando a geração da nota fiscal de forma uniforme.

# Funcionamento do Sistema

    Identificação: O sistema solicita o nome do cliente para abrir a sessão de pedido.

    Seleção (Cardápio): O vendedor escolhe os itens através de um menu interativo. Cada item instanciado já recebe os parâmetros de peso e validade exigidos.

    Fechamento de Conta: O sistema percorre a lista de itens, soma seus valores e aplica a taxa de serviço configurada.

    Emissão de Nota e Pagamento: É gerada a fatura detalhada na tela. O sistema então recebe o valor em dinheiro e calcula o troco em tempo real.