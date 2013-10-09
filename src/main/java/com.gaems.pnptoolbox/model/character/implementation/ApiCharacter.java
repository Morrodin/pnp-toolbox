package com.gaems.pnptoolbox.model.character.implementation;

import com.gaems.pnptoolbox.model.user.User;

import java.io.Serializable;

/**
 * Model class to map character responses from the remote API to
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class ApiCharacter implements Serializable {

    private static final long serialVersionUID = 7892317823178L;

    private int id;
    private String alignment;
    private User user;
    private String name;
    private CharacterClass characterClass;
    private CharacterRace race;
    private int level;
    private String diety;
    private String homeland;
    private String size;
    private String gender;
    private int age;
    private String height;
    private String weight;
    private String hairColor;
    private String eyeColor;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;


    /**
     * Gets level.
     *
     * @return Value of level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets new charisma.
     *
     * @param charisma New value of charisma.
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * Gets homeland.
     *
     * @return Value of homeland.
     */
    public String getHomeland() {
        return homeland;
    }

    /**
     * Sets new diety.
     *
     * @param diety New value of diety.
     */
    public void setDiety(String diety) {
        this.diety = diety;
    }

    /**
     * Gets age.
     *
     * @return Value of age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets new constitution.
     *
     * @param constitution New value of constitution.
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * Gets hairColor.
     *
     * @return Value of hairColor.
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * Gets weight.
     *
     * @return Value of weight.
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets new dexterity.
     *
     * @param dexterity New value of dexterity.
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Sets new eyeColor.
     *
     * @param eyeColor New value of eyeColor.
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Sets new wisdom.
     *
     * @param wisdom New value of wisdom.
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Sets new strength.
     *
     * @param strength New value of strength.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets dexterity.
     *
     * @return Value of dexterity.
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new characterClass.
     *
     * @param characterClass New value of characterClass.
     */
    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    /**
     * Sets new age.
     *
     * @param age New value of age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets new user.
     *
     * @param user New value of user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets eyeColor.
     *
     * @return Value of eyeColor.
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets new hairColor.
     *
     * @param hairColor New value of hairColor.
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets new weight.
     *
     * @param weight New value of weight.
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets user.
     *
     * @return Value of user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets new level.
     *
     * @param level New value of level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets strength.
     *
     * @return Value of strength.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets new gender.
     *
     * @param gender New value of gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets constitution.
     *
     * @return Value of constitution.
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Sets new size.
     *
     * @param size New value of size.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets charisma.
     *
     * @return Value of charisma.
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Gets wisdom.
     *
     * @return Value of wisdom.
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Gets intelligence.
     *
     * @return Value of intelligence.
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Gets gender.
     *
     * @return Value of gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets new race.
     *
     * @param race New value of race.
     */
    public void setRace(CharacterRace race) {
        this.race = race;
    }

    /**
     * Sets new height.
     *
     * @param height New value of height.
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Gets diety.
     *
     * @return Value of diety.
     */
    public String getDiety() {
        return diety;
    }

    /**
     * Gets size.
     *
     * @return Value of size.
     */
    public String getSize() {
        return size;
    }

    /**
     * Gets race.
     *
     * @return Value of race.
     */
    public CharacterRace getRace() {
        return race;
    }

    /**
     * Sets new intelligence.
     *
     * @param intelligence New value of intelligence.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets alignment.
     *
     * @return Value of alignment.
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Gets height.
     *
     * @return Value of height.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets new homeland.
     *
     * @param homeland New value of homeland.
     */
    public void setHomeland(String homeland) {
        this.homeland = homeland;
    }

    /**
     * Sets new alignment.
     *
     * @param alignment New value of alignment.
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    /**
     * Gets characterClass.
     *
     * @return Value of characterClass.
     */
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
