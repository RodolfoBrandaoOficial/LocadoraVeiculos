import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class ChatSuportePage extends StatelessWidget {
  const ChatSuportePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Chat de Suporte'),
      ),
      body: Center(
        child: Text('Página de Chat de Suporte'),
      ),
    );
  }
}