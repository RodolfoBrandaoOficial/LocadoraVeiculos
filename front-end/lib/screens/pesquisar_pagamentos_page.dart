import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class PesquisarPagamentosPage extends StatelessWidget {
  const PesquisarPagamentosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pesquisar Pagamentos'),
      ),
      body: Center(
        child: Text('Página de Pesquisar Pagamentos'),
      ),
    );
  }
}