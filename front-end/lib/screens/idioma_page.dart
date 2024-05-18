import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class IdiomaPage extends StatelessWidget {
  const IdiomaPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Idioma'),
      ),
      body: Center(
        child: Text('Página de Idioma'),
      ),
    );
  }
}