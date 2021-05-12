package pl.mbrzozowski.shop;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private int sizeTime; // 1 - pelny etat; 2 - polowa etatu itd.
    private String position;

    /**
     * @param id id pracownika
     * @param name pracownika
     * @param surname pracownika
     * @param sizeTime - wymiar etatu; 1- pelny etat, 2 - pol etatu, 3 - 1/3 etatu, 4 - 1/4 etatu
     * @param position - stanowisko zajmowane przez pracownika
     */
    public Employee(int id, String name, String surname, int sizeTime, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sizeTime = sizeTime;
        this.position = position;
    }

    public Employee(String name, String surname, int sizeTime, String position) {
        this.id = 0;
        this.name = name;
        this.surname = surname;
        this.sizeTime = sizeTime;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSizeTime() {
        return sizeTime;
    }

    public void setSizeTime(int sizeTime) {
        this.sizeTime = sizeTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
