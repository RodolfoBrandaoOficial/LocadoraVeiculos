import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class RelatoriosMensaisPage extends StatelessWidget {
  const RelatoriosMensaisPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Relatórios Mensais'),
      ),
      body: Center(
        child: Text('Página de Relatórios Mensais'),
      ),
    );
  }
}