import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class RelatoriosPage extends StatelessWidget {
  const RelatoriosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Relatórios'),
      ),
      body: Center(
        child: Text('Página de Relatórios'),
      ),
    );
  }
}