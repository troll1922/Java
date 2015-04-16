package fomichev.shoping;

/*
 * Магазин
 */
public class App {
    public static void main( String[] args ) {
        Shop<Goods> shop = new Shop<Goods>();	//Создаем объект магазин
        MobilePhone phone = new MobilePhone("Samsung", 4500.50, 2);	//Создаем объект телефон
        Tv television = new Tv("LG", 24499.9, true);	//Создаем объект телевизор
        //Закупаем товар
        shop.buy(phone);
        shop.buy(television);
        shop.buy("Кофемолка", 1500);
        //Выводим список товаров
        shop.foodsPrint();
        System.out.println("---------------------------------------");
        //Продаем телефон Samsung
        shop.sell("Samsung");
        //Выводим измененный список товаров
        shop.foodsPrint();
    }
}
