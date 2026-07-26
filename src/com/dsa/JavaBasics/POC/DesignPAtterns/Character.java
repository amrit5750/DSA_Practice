package com.dsa.JavaBasics.POC.DesignPAtterns;

public class Character implements Cloneable {

    String name;
    String power;
    String level;

    public Character(String name, String power, String level) {
        this.name = name;
        this.power = power;
        this.level = level;
    }

    @Override
    protected Character clone() throws CloneNotSupportedException {

        return (Character) super.clone();
    }

    @Override
    public String toString() {
        return "ProtoTypeDesignPattern [name=" + name + ", power=" + power + ", leve=" + level + "]";
    }

}

class CharacterFactory {

    Character prototypeCharacter;

    CharacterFactory() {

        prototypeCharacter = new Character("Default Naame", "100", "A");
    }

    public Character createCharacterWithNewName(String name)
            throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(name, clonedCharacter.power,
                clonedCharacter.level);
        return clonedCharacter;

    }
}
