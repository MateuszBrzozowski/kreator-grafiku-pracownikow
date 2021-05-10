package pl.mbrzozowski.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Shop {
    private String name;
    private List<Employee> employees = new LinkedList<>();
    protected static final Logger logger = LoggerFactory.getLogger(Shop.class);
    private String path = "Z:\\PROJECTS_JAVA\\034_KreatorGrafikuPracownikowZara\\resources\\employee.txt";

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
            //TODO dodać do pliku pracownika.
            Employee employee = new Employee(id,name,secendName,sizeTime,position);
            employees.add(employee);
            String employeeStringToFile = "\n"+id+";"+name+";"+secendName+";"+sizeTime+";"+position+";";
            try {
                FileWriter writer = new FileWriter(path,true);
                writer.write(employeeStringToFile);
                writer.close();
            }catch (IOException e){
                logger.error("Błąd podczas dodwania pracownika do bazy danych.");
            }
            logger.info("Pracownik {} {} {} został dodany",id,name,secendName);
        }else {
            logger.error("Pracownik o id {} już istnieje.", id);
        }

    }

    /**
     * Dodawnie pracówników podczas otwierania aplikacji. Nie możemy dopisać do pliku.
     * Wczytujemy tylko plik i tworzymy liste pracowników. INIT aplki
     * Metoda tymczasowa
     * @param id pracownika
     * @param name pracownika
     * @param secendName pracownika
     * @param sizeTime - wymiar etatu; 1- pelny etat, 2 - pol etatu, 3 - 1/3 etatu, 4 - 1/4 etatu
     * @param position - stanowisko zajmowane przez pracownika
     */
    public void addEmployeeFromFileInitApp(int id, String name, String secendName, int sizeTime, String position){
        Employee employee = new Employee(id,name,secendName,sizeTime,position);
        employees.add(employee);
    }

    public boolean isPossibleAddEmployeeToShop(int id){
        for (Employee employee : employees) {
            if (employee.getId()==id){
                logger.error("Podane ID już istnieje.");
                return false;
            }
        }
        return true;
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

    public int getMaxId(){
        int result = -1;
        for (Employee employee: employees) {
            if(employee.getId()>result){
                result=employee.getId();
            }
        }
        return result;
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
