import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ClientesPage extends StatelessWidget {
  const ClientesPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Clientes'),
      ),
      body: Center(
        child: Text('Página de Clientes'),
      ),
    );
  }
}