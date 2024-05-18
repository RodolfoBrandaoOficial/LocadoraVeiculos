import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class EditarClientePage extends StatelessWidget {
  const EditarClientePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Editar Cliente'),
      ),
      body: Center(
        child: Text('Página de Editar Cliente'),
      ),
    );
  }
}