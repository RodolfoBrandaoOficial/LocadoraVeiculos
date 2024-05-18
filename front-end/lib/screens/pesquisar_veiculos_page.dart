import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sistema_dashboard/model/veiculos_model.dart';
import 'package:sistema_dashboard/router/instrucoes_api.dart';



class PesquisarVeiculosPage extends StatefulWidget {
  const PesquisarVeiculosPage({Key? key}) : super(key: key);

  @override
  _PesquisarVeiculosPageState createState() => _PesquisarVeiculosPageState();
}

class _PesquisarVeiculosPageState extends State<PesquisarVeiculosPage> {
  late Future<List<Veiculo>> _futureVeiculos;
  late TextEditingController _searchController;
  late String token = '';

  @override
  void initState() {
    super.initState();
    _futureVeiculos = fetchVeiculos();
    _searchController = TextEditingController();
    getToken();
  }

  Future<void> getToken() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    token = prefs.getString('token') ?? '';
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pesquisar Veículos'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _searchController,
              decoration: InputDecoration(
                hintText: 'Pesquisar veículos',
                prefixIcon: Icon(Icons.search),
                border: OutlineInputBorder(),
              ),
              onChanged: (value) {
                setState(() {});
              },
            ),
          ),
          Expanded(
            child: FutureBuilder<List<Veiculo>>(
              future: _futureVeiculos,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Center(child: Text('Error: ${snapshot.error}'));
                } else {
                  List<Veiculo>? veiculos = snapshot.data;
                  if (veiculos != null && veiculos.isNotEmpty) {
                    veiculos =
                        _filterVeiculos(veiculos, _searchController.text);
                  }
                  return veiculos != null && veiculos.isNotEmpty
                      ? GridView.builder(
                    gridDelegate:
                    SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 2, // 2 miniaturas por linha
                      mainAxisSpacing: 8,
                      crossAxisSpacing: 8,
                    ),
                    itemCount: veiculos.length,
                    itemBuilder: (context, index) {
                      return GestureDetector(
                        onTap: () {
                          _showCarDetailsDialog(
                              context, veiculos![index]);
                        },
                        child: Card(
                          elevation: 2,
                          child: Padding(
                            padding: EdgeInsets.all(8),
                            // Espaçamento interno do card
                            child: Column(
                              crossAxisAlignment:
                              CrossAxisAlignment.start,
                              children: [
                                Expanded(
                                  child: FutureBuilder<String>(
                                          future: fetchModelData(
                                              veiculos![index].idModelo, token),
                                          builder: (context, snapshot) {
                                            if (snapshot.connectionState ==
                                                ConnectionState.waiting) {
                                              return Center(
                                                  child:
                                                      CircularProgressIndicator());
                                            } else if (snapshot.hasError) {
                                              return Center(
                                                  child: Text(
                                                      'Erro: ${snapshot.error}'));
                                            } else {
                                              String imgUrl =
                                                  snapshot.data ?? '';
                                              if (imgUrl.isNotEmpty) {
                                                return Image.memory(
                                                  base64Decode(imgUrl),
                                                  fit: BoxFit.cover,
                                                );
                                              } else {
                                                return Image.network(
                                                  imgUrlDefault,
                                                  fit: BoxFit.cover,
                                                );
                                              }
                                            }
                                          },
                                        ),
                                ),
                                SizedBox(height: 8),
                                // Espaçamento interno entre a imagem e o texto
                                Text(
                                  veiculos[index].placa,
                                  style: TextStyle(
                                    fontSize: 16,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                                SizedBox(height: 4),
                                Text(
                                  'Cor: ${veiculos[index].cor}',
                                  style: TextStyle(fontSize: 14),
                                ),
                              ],
                            ),
                          ),
                        ),
                      );
                    },
                  )
                      : Center(child: Text('Nenhum veículo encontrado'));
                }
              },
            ),
          ),
        ],
      ),
    );
  }

  Future<String> fetchModelData(int modelId, String token) async {
    print(baseUrlApi);
    try {
      final Uri uri = Uri.parse(baseUrlApi + 'modelo/$modelId');
      print('URL da requisição: $uri');

      final response = await http.get(
        uri,
        headers: {
          'Authorization': 'Bearer $token',
        },
      );

      print('Response status code: ${response.statusCode}');
      print('Response body: ${response.body}');

      if (response.statusCode == 200) {
        final Map<String, dynamic> data = jsonDecode(response.body);
        String? imgUrl = data['imgbase64']; // Alteração aqui para aceitar nulo
        print('Base64 da imagem: $imgUrl');
        if (imgUrl != null && imgUrl.isNotEmpty) {
          return imgUrl; // Retorna a URL da imagem em base64
        } else {
          return imgUrlDefault; // Retorna a imagem padrão
        }
      } else {
        throw Exception('Erro ao buscar os dados do modelo');
      }
    } catch (e) {
      print('Erro ao buscar os dados do modelo: $e');
      throw Exception('Erro ao buscar os dados do modelo: $e');
    }

  }



  Future<List<Veiculo>> fetchVeiculos() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    final String? token = prefs.getString('token');

    if (token == null) {
      throw Exception('Token não encontrado');
    }

    final response = await http.get(
      Uri.parse(baseUrlApi + 'carro/list'),
      headers: {
        'Authorization': 'Bearer $token'
      }, // Adiciona o token ao cabeçalho da solicitação
    );

    if (response.statusCode == 200) {
      try {
        final Map<String, dynamic> JsonResponse = jsonDecode(response.body);
        List<dynamic> registros = JsonResponse['registros'];
        return registros.map((json) => Veiculo.fromJson(json)).toList();
      } catch (e) {
        throw Exception('Erro ao decodificar JSON: $e');
      }
    } else {
      if(response.statusCode == 403){
        Navigator.pushNamed(context, '/login');
      }
      throw Exception('Falha ao carregar veículos: ${response.statusCode}');

    }
  }

  List<Veiculo> _filterVeiculos(List<Veiculo> veiculos, String searchText) {
    return veiculos.where((veiculo) {
      return veiculo.placa.toLowerCase().contains(searchText.toLowerCase()) ||
          veiculo.cor.toLowerCase().contains(searchText.toLowerCase());
    }).toList();
  }

  void _showCarDetailsDialog(BuildContext context, Veiculo veiculo) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          content: Container(
            padding: EdgeInsets.all(16),
            decoration: BoxDecoration(
              border: Border.all(color: Colors.grey),
              color: Colors.grey.shade800,
              borderRadius: BorderRadius.circular(10),
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisSize: MainAxisSize.min,
              children: [
                FutureBuilder<String>(
                  future: fetchModelData(veiculo.idModelo, token),
                  builder: (context, snapshot) {
                    if (snapshot.connectionState ==
                        ConnectionState.waiting) {
                      return Center(child: CircularProgressIndicator());
                    } else if (snapshot.hasError) {
                      return Center(
                          child: Text('Erro: ${snapshot.error}'));
                    } else {
                      String imgUrl = snapshot.data ?? '';
                      if (imgUrl.isNotEmpty) {
                        return Image.memory(
                          base64Decode(imgUrl),
                          width: 120,
                          height: 120,
                          fit: BoxFit.cover,
                        );
                      } else {
                        return Image.network(
                          imgUrlDefault,
                          width: 120,
                          height: 120,
                          fit: BoxFit.cover,
                        );
                      }
                    }
                  },
                ),
                SizedBox(height: 16),
                Text(
                  veiculo.placa,
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey,
                    decoration: TextDecoration.underline,
                    decorationColor: Colors.grey,
                    decorationThickness: 2,
                    decorationStyle: TextDecorationStyle.solid,
                  ),
                ),
                SizedBox(height: 8),
                Text(
                  'Cor: ${veiculo.cor}',
                  style: TextStyle(fontSize: 16),
                ),
                SizedBox(height: 4),
                Text(
                  'Ano: ${veiculo.ano}',
                  style: TextStyle(fontSize: 16),
                ),
                SizedBox(height: 4),
                Text(
                  'Valor de locação: ${veiculo.valorLocacao}',
                  style: TextStyle(fontSize: 16),
                ),
              ],
            ),
          ),
          actions: [
            Center(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  TextButton(
                    onPressed: () {
                      _showCarEditDialog(context, veiculo);
                    },
                    child: Text('Editar'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green.shade800,
                    ),
                  ),
                  SizedBox(width: 1),
                  TextButton(
                    onPressed: () {
                      _showCarDeleteConfirmationDialog(context, veiculo);
                    },
                    child: Text('Excluir'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.lightBlue.shade800,
                    ),
                  ),
                  SizedBox(width: 1),
                  TextButton(
                    onPressed: () {
                      // Implemente a ação desejada para o terceiro botão
                    },
                    child: Text('Locar'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.yellow.shade900,
                    ),
                  ),
                  SizedBox(width: 1),
                  TextButton(
                    onPressed: () {
                      Navigator.of(context).pop();
                    },
                    child: Text('Fechar'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.red.shade800,
                    ),
                  ),
                ],
              ),
            ),
          ],
        );
      },
    );
  }

  void _showCarEditDialog(BuildContext context, Veiculo veiculo) {
    TextEditingController placaController =
    TextEditingController(text: veiculo.placa);
    TextEditingController corController =
    TextEditingController(text: veiculo.cor);
    TextEditingController anoController =
    TextEditingController(text: veiculo.ano.toString());
    TextEditingController valorLocacaoController =
    TextEditingController(text: veiculo.valorLocacao.toString());

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Editar Veículo'),
          content: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                TextField(
                  controller: placaController,
                  decoration: InputDecoration(labelText: 'Placa'),
                ),
                TextField(
                  controller: corController,
                  decoration: InputDecoration(labelText: 'Cor'),
                ),
                TextField(
                  controller: anoController,
                  decoration: InputDecoration(labelText: 'Ano'),
                  keyboardType: TextInputType.number,
                ),
                TextField(
                  controller: valorLocacaoController,
                  decoration: InputDecoration(labelText: 'Valor de Locação'),
                  keyboardType: TextInputType.number,
                ),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Cancelar'),
            ),
            TextButton(
              onPressed: () async {
                try {
                  final SharedPreferences prefs =
                  await SharedPreferences.getInstance();
                  final String? token = prefs.getString('token');

                  if (token == null) {
                    throw Exception('Token não encontrado');
                  }

                  final Uri url = Uri.parse(baseUrlApi + 'carro/${veiculo.id}');
                  final Map<String, dynamic> body = {
                    'id': veiculo.id,
                    'id_fabricante': veiculo.idFabricante,
                    'id_modelo': veiculo.idModelo,
                    'placa': veiculo.placa,
                    'cor': veiculo.cor,
                    'disponivel': veiculo.disponivel,
                    'ano': veiculo.ano,
                    'valorlocacao': veiculo.valorLocacao,
                  };

                  final http.Response response = await http.put(
                    url,
                    headers: {
                      'Content-Type': 'application/json',
                      'Authorization': 'Bearer $token',
                    },
                    body: jsonEncode(body),
                  );


                  print('Body da requisição PUT: $body Uri: $url');

                  if (response.statusCode == 200) {
                    Navigator.of(context).pop(); // Fecha o diálogo de edição
                    setState(() {
                      _futureVeiculos =
                          fetchVeiculos(); // Reatualiza a lista de veículos
                    });
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text('Veículo editado com sucesso!'),
                        duration: Duration(seconds: 2),
                      ),
                    );

                  } else {
                    throw Exception(

                        'Falha ao editar veículo: ${response.statusCode}');
                  }
                } catch (e) {
                  Navigator.of(context).pop(); // Fecha o diálogo de edição
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                    content: Text('Erro ao editar veículo: $e'),
                    duration: Duration(seconds: 2),
                  ));
                }
              },
              child: Text('Salvar'),
            ),
          ],
        );
      },
    );
  }

  void _deleteCar(Veiculo veiculo) async {
    try {
      final SharedPreferences prefs = await SharedPreferences.getInstance();
      final String? token = prefs.getString('token');

      if (token == null) {
        throw Exception('Token não encontrado');
      }

      final response = await http.delete(
        Uri.parse(baseUrlApi + 'carro/${veiculo.id}'),
        headers: {
          'Authorization': 'Bearer $token'
        }, // Adiciona o token ao cabeçalho da solicitação
      );
      if (response.statusCode == 200) {
        // Exclusão bem-sucedida, exiba a mensagem
        showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('Sucesso'),
            content: Text(response.body),
            // Exibe a mensagem retornada pela API
            actions: <Widget>[
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                  setState(() {
                    _futureVeiculos =
                        fetchVeiculos(); // Reatualiza a lista de veículos
                  });
                },
                child: Text('OK'),
              ),
            ],
          ),
        );
      } else {
        // Se a exclusão falhar, exiba uma mensagem de erro
        showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('Erro'),
            content: Text('Falha ao excluir o carro'),
            actions: <Widget>[
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: Text('OK'),
              ),
            ],
          ),
        );
      }
    } catch (e) {
      // Em caso de exceção, exiba uma mensagem de erro
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: Text('Erro'),
          content: Text('Erro ao se conectar ao servidor'),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('OK'),
            ),
          ],
        ),
      );
    }
  }

  void _showCarDeleteConfirmationDialog(BuildContext context, Veiculo veiculo) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Confirmar exclusão'),
          content: Text(
              'Tem certeza que deseja excluir o veículo ${veiculo.placa}?'),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Cancelar'),
            ),
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
                _deleteCar(veiculo);
              },
              child: Text('Excluir'),
            ),
          ],
        );
      },
    );
  }
}
