import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class NovaReservaPage extends StatelessWidget {
  const NovaReservaPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Nova Reserva'),
      ),
      body: Center(
        child: Text('Página de Nova Reserva'),
      ),
    );
  }
}