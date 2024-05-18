import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class NovoVeiculoPage extends StatelessWidget {
  const NovoVeiculoPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Novo Veículo'),
        centerTitle: true,
        actions: [
          IconButton(
            icon: Icon(Icons.save),
            onPressed: () {
            },
            tooltip: 'Save',
          ),
          IconButton(
            icon: Icon(Icons.add),
            onPressed: () {
              Navigator.of(context).pop();
              Navigator.of(context).pushNamed('/novo_veiculo');

            },
          )
        ]
      ),
      // DADOS DA API para adicionar veiculo
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            TextField(
              decoration: InputDecoration(
                labelText: 'Placa',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Modelo',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Ano',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Cor',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Valor da Locação',
              ),
            ),
          ],
        ),
      ),
    );
  }
}