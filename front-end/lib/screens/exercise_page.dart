import 'package:flutter/material.dart';

class ExercisePage extends StatelessWidget {
  const ExercisePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Exercise'),
      ),
      body: Center(
        child: Text('Exercise Page'),
      ),
    );
  }
}
