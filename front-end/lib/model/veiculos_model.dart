class Veiculo{
  final int id;
  final int idFabricante;
  final int idModelo;
  final String placa;
  final String cor;
  final bool disponivel;
  final int ano;
  final double valorLocacao;


  Veiculo({
    required this.id,
    required this.idFabricante,
    required this.idModelo,
    required this.placa,
    required this.cor,
    required this.disponivel,
    required this.ano,
    required this.valorLocacao,
  });

  factory Veiculo.fromJson(Map<String, dynamic> json) {
    return Veiculo(
      id: json['id'],
      idFabricante: json['id_fabricante'],
      idModelo: json['id_modelo'],
      placa: json['placa'],
      cor: json['cor'],
      disponivel: json['disponivel'],
      ano: json['ano'],
      valorLocacao: json['valorlocacao'],
    );
  }

}
