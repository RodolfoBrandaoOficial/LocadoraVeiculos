import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class EditarVeiculoPage extends StatelessWidget {
  const EditarVeiculoPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Editar Veículo'),
      ),
      body: Center(
        child: Text('Página de Editar Veículo'),
      ),
    );
  }
}