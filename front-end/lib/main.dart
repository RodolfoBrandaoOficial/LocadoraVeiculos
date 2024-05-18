import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sistema_dashboard/router/instrucoes_api.dart';
import 'package:sistema_dashboard/router/routes.dart';

import 'const/constant.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<bool>(
      future: checkLoggedInStatus(),
      builder: (BuildContext context, AsyncSnapshot<bool> snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          // Se estiver aguardando, exibir indicador de carregamento
          return CircularProgressIndicator();
        } else {
          // Se o status de login foi determinado, redirecione para a página correta
          return MaterialApp(
            title: 'Sistema Dashboard UI',
            debugShowCheckedModeBanner: false,
            theme: ThemeData(
              scaffoldBackgroundColor: backgroundColor,
              brightness: Brightness.dark,
            ),
            initialRoute: snapshot.data! ? '/main' : '/login',
            routes: routes,
          );
        }
      },
    );
  }

  Future<bool> checkLoggedInStatus() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    final String? token = prefs.getString('token');
    // Retorna verdadeiro se o token estiver presente, indicando que o usuário está logado
    return token != null;
  }
}

class LoginPage extends StatelessWidget {
  final TextEditingController loginController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  Future<void> login(BuildContext context) async {
    final String login = loginController.text;
    final String password = passwordController.text;

    final Uri url = Uri.parse(baseUrlIpApi + 'auth/login');
    final Map<String, String> body = {
      'login': login,
      'password': password,
    };

    final http.Response response = await http.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(body),
    );

    if (response.statusCode == 200) {
      final Map<String, dynamic> responseData = jsonDecode(response.body);
      String token = responseData['token'];

      // Salvar o token de acesso na sessão
      final SharedPreferences prefs = await SharedPreferences.getInstance();
      await prefs.setString('token', token);

      // Salvar o token na variável global
      token = token;

      // Navegar para a próxima tela
      Navigator.pushNamed(context, '/main');
    } else {
      // Exibir mensagem de erro, por exemplo
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: const Text('Erro'),
            content: Text('Erro de login: ${response.body}'),
            actions: <Widget>[
              TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('OK'),
              ),
            ],
          );
        },
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Login'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: loginController,
              decoration: const InputDecoration(labelText: 'Login'),
            ),
            TextField(
              controller: passwordController,
              decoration: const InputDecoration(labelText: 'Senha'),
              obscureText: true,
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => login(context),
              child: const Text('Login'),
            ),
          ],
        ),
      ),
    );
  }
}
