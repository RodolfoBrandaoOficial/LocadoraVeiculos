import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PesquisarRelatoriosPage extends StatelessWidget {
  const PesquisarRelatoriosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pesquisar Relatórios'),
      ),
      body: Center(
        child: Text('Página de Pesquisar Relatórios'),
      ),
    );
  }
}
