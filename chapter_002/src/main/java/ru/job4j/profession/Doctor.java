package ru.job4j.profession;

public class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        diagnose.setDescription(pacient.getIllness());
        return diagnose;
    }
}
