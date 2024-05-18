import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class EfetuarPagamentoPage extends StatelessWidget {
  const EfetuarPagamentoPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Efetuar Pagamento'),
      ),
      body: Center(
        child: Text('Página de Efetuar Pagamento'),
      ),
    );
  }
}
