package model;

import java.util.List;
import java.util.Set;

public class City {
    Set<Family> families;

    public City(Set<Family> families) {
        this.families = families;
    }

    public Set<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Set<Family> families) {
        this.families = families;
    }
}
