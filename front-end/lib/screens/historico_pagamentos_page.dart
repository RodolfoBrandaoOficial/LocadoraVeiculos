import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class HistoricoPagamentosPage extends StatelessWidget {
  const HistoricoPagamentosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Histórico de Pagamentos'),
      ),
      body: Center(
        child: Text('Página de Histórico de Pagamentos'),
      ),
    );
  }
}