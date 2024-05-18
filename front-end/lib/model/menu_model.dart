// menu_model.dart

import 'package:flutter/material.dart';

class MenuModel {
  final IconData icon;
  final String title;
  final String route;
  final List<MenuModel>? subMenu;

  const MenuModel({
    required this.icon,
    required this.title,
    required this.route,
    required this.subMenu, required bool hideSubMenuOnClick,
  });
}
