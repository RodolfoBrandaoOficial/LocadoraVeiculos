import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sistema_dashboard/util/responsive.dart';
import 'package:sistema_dashboard/widgets/dashboard_widget.dart';
import 'package:sistema_dashboard/widgets/side_menu_widget.dart';
import 'package:sistema_dashboard/widgets/summary_widget.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({Key? key}) : super(key: key);

  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  bool isLoggedIn = false;

  @override
  void initState() {
    super.initState();
    checkLoginStatus();
  }

  Future<void> checkLoginStatus() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    final String? token = prefs.getString('token');

    setState(() {
      isLoggedIn = token != null;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (!isLoggedIn) {
      // Se não estiver logado, redirecione para a página de login
      return Scaffold(
        body: Center(
          child: CircularProgressIndicator(), // ou qualquer indicador de carregamento
        ),
      );
    }

    final isDesktop = Responsive.isDesktop(context);

    return Scaffold(
      drawer: !isDesktop
          ? const SizedBox(
        width: 250,
        child: SideMenuWidget(),
      )
          : null,
      endDrawer: Responsive.isMobile(context)
          ? SizedBox(
        width: MediaQuery.of(context).size.width * 0.8,
        child: const SummaryWidget(),
      )
          : null,
      body: SafeArea(
        child: Row(
          children: [
            if (isDesktop)
              Expanded(
                flex: 2,
                child: SizedBox(
                  child: SideMenuWidget(),
                ),
              ),
            Expanded(
              flex: 7,
              child: DashboardWidget(),
            ),
            if (isDesktop)
              Expanded(
                flex: 3,
                child: SummaryWidget(),
              ),
          ],
        ),
      ),
    );
  }
}
