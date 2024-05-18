import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class NotificacoesPage extends StatelessWidget {
  const NotificacoesPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Notificações'),
      ),
      body: Center(
        child: Text('Página de Notificações'),
      ),
    );
  }
}