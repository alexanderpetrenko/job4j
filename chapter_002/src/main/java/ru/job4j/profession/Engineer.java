package ru.job4j.profession;

public class Engineer extends Profession {
    public House build(Drawing project) {
        House house = new House();
        house.setSquare(project.getHouseSquare());
        return house;
    }
}
