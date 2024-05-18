import 'package:sistema_dashboard/model/business_model.dart';

class BusinessDetails {
  final businessData = const [
    BusinessModel(
        icon: 'assets/icons/burn.png', value: "93", title: "Vendas"),
    BusinessModel(
        icon: 'assets/icons/steps.png', value: "15", title: "OS em aberto"),
    BusinessModel(
        icon: 'assets/icons/distance.png', value: "12", title: "Tickets abertos hoje"),
    BusinessModel(icon: 'assets/icons/sleep.png', value: "7890", title: "Clientes"),
  ];
}
