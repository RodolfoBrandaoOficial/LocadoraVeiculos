import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PesquisarReservasPage extends StatelessWidget {
  const PesquisarReservasPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pesquisar Reservas'),
      ),
      body: Center(
        child: Text('Página de Pesquisar Reservas'),
      ),
    );
  }
}