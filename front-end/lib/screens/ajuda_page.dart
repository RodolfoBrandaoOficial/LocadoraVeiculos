import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AjudaPage extends StatelessWidget {
  const AjudaPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Ajuda e Suporte'),
      ),
      body: Center(
        child: Text('Página de Ajuda e Suporte'),
      ),
    );
  }
}