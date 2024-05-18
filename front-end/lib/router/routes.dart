import 'package:flutter/material.dart';
import 'package:sistema_dashboard/screens/exercise_page.dart';
import 'package:sistema_dashboard/screens/history_page.dart';
import 'package:sistema_dashboard/screens/main_screen.dart';
import 'package:sistema_dashboard/screens/profile_page.dart';
import 'package:sistema_dashboard/screens/settings_page.dart';
import 'package:sistema_dashboard/screens/signout_page.dart';
import 'package:sistema_dashboard/screens/home_page.dart';
import 'package:sistema_dashboard/screens/reservas_page.dart';
import 'package:sistema_dashboard/screens/veiculos_page.dart';
import 'package:sistema_dashboard/screens/clientes_page.dart';
import 'package:sistema_dashboard/screens/pagamentos_page.dart';
import 'package:sistema_dashboard/screens/relatorios_page.dart';
import 'package:sistema_dashboard/screens/configuracoes_page.dart';
import 'package:sistema_dashboard/screens/ajuda_page.dart';
import 'package:sistema_dashboard/screens/sair_page.dart';
import 'package:sistema_dashboard/screens/nova_reserva_page.dart';
import 'package:sistema_dashboard/screens/pesquisar_reservas_page.dart';
import 'package:sistema_dashboard/screens/novo_veiculo_page.dart';
import 'package:sistema_dashboard/screens/editar_veiculo_page.dart';
import 'package:sistema_dashboard/screens/pesquisar_veiculos_page.dart';
import 'package:sistema_dashboard/screens/novo_cliente_page.dart';
import 'package:sistema_dashboard/screens/editar_cliente_page.dart';
import 'package:sistema_dashboard/screens/pesquisar_clientes_page.dart';
import 'package:sistema_dashboard/screens/efetuar_pagamento_page.dart';
import 'package:sistema_dashboard/screens/historico_pagamentos_page.dart';
import 'package:sistema_dashboard/screens/pesquisar_pagamentos_page.dart';
import 'package:sistema_dashboard/screens/relatorios_mensais_page.dart';
import 'package:sistema_dashboard/screens/relatorios_anuais_page.dart';
import 'package:sistema_dashboard/screens/pesquisar_relatorios_page.dart';
import 'package:sistema_dashboard/screens/idioma_page.dart';
import 'package:sistema_dashboard/screens/notificacoes_page.dart';
import 'package:sistema_dashboard/screens/faq_page.dart';
import 'package:sistema_dashboard/screens/chat_suporte_page.dart';
import 'package:sistema_dashboard/screens/login_page.dart';
import 'package:sistema_dashboard/screens/home_page.dart';


Map<String, WidgetBuilder> routes = {
  '/login': (context) => const LoginPage(), // Tela de login como rota inicial
  '/main': (context) => const MainScreen(),
  '/profile': (context) => ProfilePage(),
  '/exercise': (context) => ExercisePage(),
  '/settings': (context) => SettingsPage(),
  '/history': (context) => HistoryPage(),
  '/signout': (context) => SignOutPage(),
  '/home': (context) => HomePage(),
  '/reservas': (context) => ReservasPage(),
  '/veiculos': (context) => VeiculosPage(),
  '/clientes': (context) => ClientesPage(),
  '/pagamentos': (context) => PagamentosPage(),
  '/relatorios': (context) => RelatoriosPage(),
  '/configuracoes': (context) => ConfiguracoesPage(),
  '/ajuda': (context) => AjudaPage(),
  '/sair': (context) => SairPage(),
  '/reservas/nova': (context) => NovaReservaPage(),
  '/reservas/pesquisar': (context) => PesquisarReservasPage(),
  '/veiculos/novo': (context) => NovoVeiculoPage(),
  '/veiculos/editar': (context) => EditarVeiculoPage(),
  '/veiculos/pesquisar': (context) => PesquisarVeiculosPage(),
  '/clientes/novo': (context) => NovoClientePage(),
  '/clientes/editar': (context) => EditarClientePage(),
  '/clientes/pesquisar': (context) => PesquisarClientesPage(),
  '/pagamentos/efetuar': (context) => EfetuarPagamentoPage(),
  '/pagamentos/historico': (context) => HistoricoPagamentosPage(),
  '/pagamentos/pesquisar': (context) => PesquisarPagamentosPage(),
  '/relatorios/mensais': (context) => RelatoriosMensaisPage(),
  '/relatorios/anuais': (context) => RelatoriosAnuaisPage(),
  '/relatorios/pesquisar': (context) => PesquisarRelatoriosPage(),
  '/configuracoes/idioma': (context) => IdiomaPage(),
  '/configuracoes/notificacoes': (context) => NotificacoesPage(),
  '/ajuda/faq': (context) => FaqPage(),
  '/ajuda/chat': (context) => ChatSuportePage(),
};
