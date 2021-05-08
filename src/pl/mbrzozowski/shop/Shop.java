package pl.mbrzozowski.shop;

import java.util.LinkedList;
import java.util.List;

public class Shop {
    private String name;
    private List<Employee> employees = new LinkedList<>();

    public Shop(String name) {
        this.name = name;
    }

    /**
     * Dodaje pracownika do sklepu
     * @param id pracownika
     * @param name pracownika
     * @param secendName pracownika
     * @param sizeTime - wymiar etatu; 1- pelny etat, 2 - pol etatu, 3 - 1/3 etatu, 4 - 1/4 etatu
     * @param position - stanowisko zajmowane przez pracownika
     */
    public void addEmployee(int id, String name, String secendName, int sizeTime, String position){
        Employee employee = new Employee(id,name,secendName,sizeTime,position);
        employees.add(employee);
    }

    /**
     * Usuwa pracownika ze sklepu
     * @param id pracownika
     */
    public void removeEmployee(int id){

    }
}
