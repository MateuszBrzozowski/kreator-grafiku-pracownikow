package pl.mbrzozowski.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Shop {
    private String name;
    private List<Employee> employees = new LinkedList<>();
    protected static final Logger logger = LoggerFactory.getLogger(Shop.class);

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
        if(isEmployeeAndGetIndex(id)==-1){
            Employee employee = new Employee(id,name,secendName,sizeTime,position);
            employees.add(employee);
            logger.info("Pracownik {} {} {} został dodany",id,name,secendName);
        }else {
            logger.error("Pracownik o id {} już istnieje.", id);
        }

    }

    public int isEmployeeAndGetIndex(int id){
        int i=0;
        for (Employee employee:employees){
            if (employee.getId()==id){
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * Usuwa pracownika ze sklepu
     * @param id pracownika
     */
    public void removeEmployee(int id){
        int indexEmployee = isEmployeeAndGetIndex(id);
        if (indexEmployee==-1){
            logger.error("Pracownik o ID ["+ id +"] nie istnieje.");
        }else {
            employees.remove(indexEmployee);
            logger.info("Pracownik o ID ["+ id +"] został poprawnie usunięty z listy pracowników.");
        }
    }

    public void showAllEmployee(){
        for (Employee employee: employees) {
            logger.info("Pracownik o ID [{}] : {} {}, etat: {}, na stanowisku: {} ",employee.getId(),employee.getName(),employee.getSecendName(),employee.getSizeTime(),employee.getPosition());
        }
    }
}
