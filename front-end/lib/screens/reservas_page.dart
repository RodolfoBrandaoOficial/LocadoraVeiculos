import 'package:flutter/material.dart';

class ReservasPage extends StatelessWidget {
  const ReservasPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Reservas'),
      ),
      body: Center(
        child: Text('Página de Reservas'),
      ),
    );
  }
}