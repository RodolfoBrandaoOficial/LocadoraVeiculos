import 'package:flutter/material.dart';
import 'package:sistema_dashboard/data/side_menu_data.dart';
import 'package:sistema_dashboard/model/menu_model.dart';
import 'package:sistema_dashboard/const/constant.dart';

class SideMenuWidget extends StatefulWidget {
  const SideMenuWidget({Key? key}) : super(key: key);

  @override
  State<SideMenuWidget> createState() => _SideMenuWidgetState();
}

class _SideMenuWidgetState extends State<SideMenuWidget> {
  int selectedIndex = 0;

  @override
  Widget build(BuildContext context) {
    final data = SideMenuData();

    return Container(
      padding: const EdgeInsets.symmetric(vertical: 80, horizontal: 20),
      color: const Color(0xFF171821),
      child: ListView.builder(
        itemCount: data.menu.length,
        itemBuilder: (context, index) => buildMenuEntry(data.menu[index], index),
      ),
    );
  }

  Widget buildMenuEntry(MenuModel menuItem, int index) {
    final isSelected = selectedIndex == index;

    return Column(
      children: [
        Container(
          margin: const EdgeInsets.symmetric(vertical: 5),
          decoration: BoxDecoration(
            borderRadius: const BorderRadius.all(
              Radius.circular(6.0),
            ),
            color: isSelected ? selectionColor : Colors.transparent,
          ),
          child: InkWell(
            onTap: () {
              setState(() {
                selectedIndex = index;
              });
              // Navega para a rota correspondente ao item do menu
              if (menuItem.route != null) {
                Navigator.pushNamed(context, menuItem.route!);
              }
            },
            child: Row(
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 13, vertical: 7),
                  child: Icon(
                    menuItem.icon,
                    color: isSelected ? Colors.black : Colors.grey,
                  ),
                ),
                Text(
                  menuItem.title,
                  style: TextStyle(
                    fontSize: 16,
                    color: isSelected ? Colors.black : Colors.grey,
                    fontWeight: isSelected ? FontWeight.w600 : FontWeight.normal,
                  ),
                )
              ],
            ),
          ),
        ),
        if (menuItem.subMenu != null && isSelected)
          Column(
            children: menuItem.subMenu!
                .map((subMenuItem) => buildSubMenuEntry(subMenuItem))
                .toList(),
          ),
      ],
    );
  }

  Widget buildSubMenuEntry(MenuModel subMenuItem) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 20),
      child: InkWell(
        onTap: () {
          // Ação quando um submenu é selecionado
          if (subMenuItem.route != null) {
            Navigator.pushNamed(context, subMenuItem.route!);
          }
        },
        child: Row(
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 13, vertical: 7),
              child: Icon(
                subMenuItem.icon,
                color: Colors.grey,
              ),
            ),
            Text(
              subMenuItem.title,
              style: TextStyle(
                fontSize: 16,
                color: Colors.grey,
              ),
            )
          ],
        ),
      ),
    );
  }
}
