import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';




class PerfilPage extends StatelessWidget {
  const PerfilPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Perfil'),
      ),
      body: Center(
        child: Text('Página de Perfil'),
      ),
    );
  }
}