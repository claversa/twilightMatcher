import java.util.ArrayList;
/**
 * Character Objects.
 *
 * @Caroline LaVersa
 * 12/27/2021
 */
public class Character
{
    private String name;
    private String hairColor;
    private String personality[];
    private int age;
    private String gender;

    /**
     * Constructor for objects of class Character
     */
    public Character(String name, String hairColor, String personality[], int age, String gender)
    {
        this.name = name;
        this.hairColor= hairColor;
        this.personality = personality;
        this.age = age;
        this.gender = gender;
        
    }

    /**
     * Get methods for use in main method
     */
    public String makeCharacter()
    {
        return name + " is a " + age+ " year old " + gender + " and has " + hairColor + " hair. They're " + personality +"."; 
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getHair()
    {
        return hairColor;
    }
    
    public String [] getPersonality()
    {
        return personality;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public int getAge()
    {
        return age;
    }
}
