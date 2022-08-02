package characters;
public class Character {
    String name;
    int level = 1;
    CharacterAttribute baseAttributes = new CharacterAttribute();     //Attributes of the character
    public Character(String name, int strength, int intelligence, int dexterity ) {
        this.name = name;
        baseAttributes.addToAttributes(strength, dexterity, intelligence);
    }

    public void levelUp(int strengthIncrease, int dexterityIncrease, int intelligenceIncrease) {
        baseAttributes.addToAttributes(strengthIncrease, dexterityIncrease, intelligenceIncrease);
        level += 1;
    }

}
