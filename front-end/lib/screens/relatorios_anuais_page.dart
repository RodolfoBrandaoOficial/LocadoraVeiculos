import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class RelatoriosAnuaisPage extends StatelessWidget {
  const RelatoriosAnuaisPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Relatórios Anuais'),
      ),
      body: Center(
        child: Text('Página de Relatórios Anuais'),
      ),
    );
  }
}