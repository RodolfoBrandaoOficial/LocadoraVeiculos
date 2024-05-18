import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sistema_dashboard/model/veiculos_clientes.dart';
import 'package:sistema_dashboard/router/instrucoes_api.dart';

class PesquisarClientesPage extends StatefulWidget {
  const PesquisarClientesPage({Key? key}) : super(key: key);

  @override
  _PesquisarClientesPageState createState() => _PesquisarClientesPageState();
}

class _PesquisarClientesPageState extends State<PesquisarClientesPage> {
  late Future<List<VeiculosClientes>> _futureClientes;
  late TextEditingController _searchController;

  @override
  void initState() {
    super.initState();
    _futureClientes = fetchClientes();
    _searchController = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pesquisar Clientes'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _searchController,
              decoration: InputDecoration(
                hintText: 'Pesquisar clientes',
                prefixIcon: Icon(Icons.search),
                border: OutlineInputBorder(),
              ),
              onChanged: (value) {
                setState(() {});
              },
            ),
          ),
          Expanded(
            child: FutureBuilder<List<VeiculosClientes>>(
              future: _futureClientes,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Center(child: Text('Error: ${snapshot.error}'));
                } else {
                  List<VeiculosClientes>? clientes = snapshot.data;
                  if (clientes != null && clientes.isNotEmpty) {
                    clientes = _filterClientes(clientes, _searchController.text);
                  }
                  return clientes != null && clientes.isNotEmpty
                      ? ListView.builder(
                    itemCount: clientes.length,
                    itemBuilder: (context, index) {
                      return ListTile(
                        title: Text(clientes![index].nome ?? ''),
                        subtitle: Text(clientes[index].cpf ?? ''),
                        onTap: () {
                          _showClientDetailsDialog(context, clientes![index]);
                        },
                      );
                    },
                  )
                      : Center(child: Text('Nenhum cliente encontrado'));
                }
              },
            ),
          ),
        ],
      ),
    );
  }

  Future<List<VeiculosClientes>> fetchClientes() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    final String? token = prefs.getString('token');

    if (token == null) {
      throw Exception('Token não encontrado');
    }

    final response = await http.get(
      Uri.parse(baseUrlApi + 'cliente/list'),
      headers: {'Authorization': 'Bearer $token'}, // Adiciona o token ao cabeçalho da solicitação
    );

    if (response.statusCode == 200) {
      try {
        final Map<String, dynamic> JsonReponse = jsonDecode(response.body);
        List<dynamic> resgistros = JsonReponse['registros'];
        return resgistros.map((json) => VeiculosClientes.fromJson(json)).toList();
      } catch (e) {
        throw Exception('Erro ao decodificar JSON: $e');
      }
    } else {
      if(response.statusCode == 403){
        Navigator.pushNamed(context, '/login');
      }
      throw Exception('Falha ao carregar clientes: ${response.statusCode}');
    }
  }

  List<VeiculosClientes> _filterClientes(List<VeiculosClientes> clientes, String searchText) {
    return clientes.where((cliente) {
      return cliente.nome!.toLowerCase().contains(searchText.toLowerCase()) ||
          cliente.cpf!.contains(searchText);
    }).toList();
  }

  void _showClientDetailsDialog(BuildContext context, VeiculosClientes cliente) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Detalhes do Cliente'),
          content: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisSize: MainAxisSize.min,
            children: [
              Text('Nome: ${cliente.nome ?? ''}'),
              Text('CPF: ${cliente.cpf ?? ''}'),
              Text('Endereço: ${cliente.logradouro ?? ''}'),
              Text('E-mail: ${cliente.email ?? ''}'),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Fechar'),
            ),
          ],
        );
      },
    );
  }
}
