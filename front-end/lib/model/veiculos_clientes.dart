class VeiculosClientes {
  int? id;
  String? rg;
  String? cpf;
  String? nome;
  String? logradouro;
  int? idMunicipio;
  int? idLei;
  String? cnh;
  String? datavencimentocnh;
  String? email;

  VeiculosClientes(
      this.id,
      this.rg,
      this.cpf,
      this.nome,
      this.logradouro,
      this.idMunicipio,
      this.idLei,
      this.cnh,
      this.datavencimentocnh,
      this.email);

  factory VeiculosClientes.fromJson(Map<String, dynamic> json) {
    return VeiculosClientes(
      json['id'],
      json['rg'],
      json['cpf'],
      json['nome'],
      json['logradouro'],
      json['idMunicipio'],
      json['idLei'],
      json['cnh'],
      json['datavencimentocnh'],
      json['email'],
    );
  }
}
