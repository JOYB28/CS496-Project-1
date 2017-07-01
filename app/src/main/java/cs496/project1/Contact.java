package cs496.project1;

/**
 * Created by q on 2017-07-01.
 */

public class Contact {
    private long id;
    private String name;
    private String number;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + ": " + number;
    }
}
