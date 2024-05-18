import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PagamentosPage extends StatelessWidget {
  const PagamentosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pagamentos'),
      ),
      body: Center(
        child: Text('Página de Pagamentos'),
      ),
    );
  }
}