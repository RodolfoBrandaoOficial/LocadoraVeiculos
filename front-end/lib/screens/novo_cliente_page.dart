import 'package:flutter/material.dart';

class NovoClientePage extends StatelessWidget {
  const NovoClientePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Novo Cliente'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            TextField(
              decoration: InputDecoration(
                labelText: 'Nome',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'CPF',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'RG',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Email',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Logradouro',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Cidade',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'CEP',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Telefone',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'CNH',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Data de Vencimento da CNH',
              ),
            ),
          ],
        ),
      ),
    );
  }
}
