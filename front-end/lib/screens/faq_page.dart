import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';



class FaqPage extends StatelessWidget {
  const FaqPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Perguntas Frequentes'),
      ),
      body: Center(
        child: Text('Página de Perguntas Frequentes'),
      ),
    );
  }
}
