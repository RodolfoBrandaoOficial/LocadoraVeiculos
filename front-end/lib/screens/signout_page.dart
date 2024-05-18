import 'package:flutter/material.dart';

class SignOutPage extends StatelessWidget {
  const SignOutPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sign Out'),
      ),
      body: Center(
        child: Text('Sign Out Page'),
      ),
    );
  }
}
