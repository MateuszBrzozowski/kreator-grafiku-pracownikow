package pl.mbrzozowski;

import pl.mbrzozowski.shop.Shop;

public class MainWindowController {
    Shop shop;

    public void initialize(){
        shop = new Shop("Zara");
        addEmployeeFromFile();
    }

    private void addEmployeeFromFile() {

    }
}
