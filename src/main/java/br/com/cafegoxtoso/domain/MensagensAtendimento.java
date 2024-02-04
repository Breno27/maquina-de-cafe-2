package br.com.cafegoxtoso.domain;

public enum MensagensAtendimento {
    INICIO_ATENDIMENTO("Bom dia, seja bem vindo ao café goxtoso, este é o nosso menu, digite a opção desejada ou o número 0 para sair:\n"),
    PADRAO_ESCOLHAS("caso deseje outro, digite o numero correspondente ou zero para sair."),
    PADRAO_ERRO_ESCOLHA("escolha uma opção válida ou 0 para finalizar"),
    FINALIZANDO_PEDIDO("pedido finalizado! \n Cafés pedidos:\n");

    private final String mensagem;

    MensagensAtendimento(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void printMensagem() {
        System.out.println(getMensagem());
    }
}
