package pl.mbrzozowski.shop;

public class Employee {
    private int id;
    private String name;
    private String secendName;
    private int sizeTime; // 1 - pelny etat; 2 - polowa etatu itd.
    private String position;

    /**
     * @param id id pracownika
     * @param name pracownika
     * @param secendName pracownika
     * @param sizeTime - wymiar etatu; 1- pelny etat, 2 - pol etatu, 3 - 1/3 etatu, 4 - 1/4 etatu
     * @param position - stanowisko zajmowane przez pracownika
     */
    public Employee(int id, String name, String secendName, int sizeTime, String position) {
        this.id = id;
        this.name = name;
        this.secendName = secendName;
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

    public String getSecendName() {
        return secendName;
    }

    public void setSecendName(String secendName) {
        this.secendName = secendName;
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
