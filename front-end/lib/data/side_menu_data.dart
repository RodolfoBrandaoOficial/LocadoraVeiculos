// side_menu_data.dart

import 'package:flutter/material.dart';
import 'package:sistema_dashboard/model/menu_model.dart';

class SideMenuData {
  final menu = const <MenuModel>[
    MenuModel(icon: Icons.home, title: 'Dashboard', route: '/', hideSubMenuOnClick: true,subMenu: []),
    MenuModel(icon: Icons.calendar_today, title: 'Reservas', route: '', hideSubMenuOnClick: true,subMenu: [
      MenuModel(icon: Icons.add, title: 'Nova Reserva', route: '/reservas/nova', hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.search, title: 'Pesquisar Reservas', route: '/reservas/pesquisar',hideSubMenuOnClick: true, subMenu: []),
    ]),
    MenuModel(icon: Icons.directions_car, title: 'Veículos', route: '', hideSubMenuOnClick: true,subMenu: [
      MenuModel(icon: Icons.add, title: 'Novo Veículo', route: '/veiculos/novo',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.edit, title: 'Editar Veículo', route: '/veiculos/editar',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.search, title: 'Pesquisar Veículos', route: '/veiculos/pesquisar', hideSubMenuOnClick: true,subMenu: []),
    ]),
    MenuModel(icon: Icons.people, title: 'Clientes', route: '', hideSubMenuOnClick: true,subMenu: [
      MenuModel(icon: Icons.person_add, title: 'Novo Cliente', route: '/clientes/novo',hideSubMenuOnClick: true,subMenu: []),
      MenuModel(icon: Icons.edit, title: 'Editar Cliente', route: '/clientes/editar', hideSubMenuOnClick: true,subMenu: []),
      MenuModel(icon: Icons.search, title: 'Pesquisar Clientes', route: '/clientes/pesquisar',hideSubMenuOnClick: true, subMenu: []),
    ]),
    MenuModel(icon: Icons.attach_money, title: 'Pagamentos', route: '', hideSubMenuOnClick: true, subMenu: [
      MenuModel(icon: Icons.payment, title: 'Efetuar Pagamento', route: '/pagamentos/efetuar',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.receipt, title: 'Histórico de Pagamentos', route: '/pagamentos/historico',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.search, title: 'Pesquisar Pagamentos', route: '/pagamentos/pesquisar',hideSubMenuOnClick: true, subMenu: []),
    ]),
    MenuModel(icon: Icons.analytics, title: 'Relatórios', route: '',hideSubMenuOnClick: true, subMenu: [
      MenuModel(icon: Icons.insert_chart, title: 'Relatórios Mensais', route: '/relatorios/mensais', hideSubMenuOnClick: true,subMenu: []),
      MenuModel(icon: Icons.list_alt, title: 'Relatórios Anuais', route: '/relatorios/anuais',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.search, title: 'Pesquisar Relatórios', route: '/relatorios/pesquisar', hideSubMenuOnClick: true,subMenu: []),
    ]),
    MenuModel(icon: Icons.settings, title: 'Configurações', route: '',hideSubMenuOnClick: true, subMenu: [
      MenuModel(icon: Icons.language, title: 'Idioma', route: '/configuracoes/idioma', hideSubMenuOnClick: true,subMenu: []),
      MenuModel(icon: Icons.notifications, title: 'Notificações', route: '/configuracoes/notificacoes',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.person, title: 'Perfil', route: '/profile', hideSubMenuOnClick: true,subMenu: []),
    ]),
    MenuModel(icon: Icons.help, title: 'Ajuda e Suporte', route: '', hideSubMenuOnClick: true,subMenu: [
      MenuModel(icon: Icons.question_answer, title: 'Perguntas Frequentes', route: '/ajuda/faq',hideSubMenuOnClick: true, subMenu: []),
      MenuModel(icon: Icons.chat, title: 'Chat de Suporte', route: '/ajuda/chat', hideSubMenuOnClick: true,subMenu: []),
    ]),
    MenuModel(icon: Icons.logout, title: 'Sair', route: '/sair', hideSubMenuOnClick: true, subMenu: []),
  ];
}
