import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ConfiguracoesPage extends StatelessWidget {
  const ConfiguracoesPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Configurações'),
      ),
      body: Center(
        child: Text('Página de Configurações'),
      ),
    );
  }
}