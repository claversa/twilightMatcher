import java.util.Scanner;
import java.util.ArrayList;
/**
 * Actual Functionality--matches traits with user input
 *
 * @Caroline LaVersa
 * @12/27/2021
 */
public class Main
{
    private Character Edward;
    private Character Alice;
    private Character Bella;
    private Character Jacob;
    private Character Emmett;
    private Character Rosalie;
    private Character Carlisle;
    private Character Jasper;
    private Character[] CharList;
    private int[] share;

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        Edward = new Character("Edward", "brown", new String []{"angsty", "protective", "polite", "charming"}, 17, "male");
        Alice = new Character("Alice", "brown", new String[]{"charismatic", "optimistic", "caring", "stubborn"}, 19, "female");
        Bella = new Character("Bella", "brown", new String[] {"boring", "reclusive", "insecure","clumsy"}, 17, "female");
        Jacob = new Character("Jacob", "brown", new String []{"fiery", "loyal", "protective", "jealous"} , 17, "male");
        Emmett = new Character("Emmett", "blonde", new String []{"energetic", "fun-loving", "confident", "athletic"}, 20, "male");
        Rosalie = new Character("Rosalie", "blonde", new String[] {"motherly", "loyal", "serious", "cynical"}, 18, "female");
        Carlisle = new Character("Carlisle", "blonde", new String[]{"dadlike", "calm", "wise", "kind"}, 1000, "male");
        Jasper = new Character("Jasper", "blonde", new String[]{"gentlemanly", "charming", "polite", "charismatic"}, 19, "male");
        CharList = new Character[8];
        share = new int[8];
    }

    /**
     * Main method compares user input to character traits
     */
    public void main() {
        CharList[0] = Edward;
        CharList[1] = Alice;
        CharList[2] = Bella;
        CharList[3] = Jacob;
        CharList[4] = Emmett;
        CharList[5] = Rosalie;
        CharList[6] = Carlisle;
        CharList[7] = Jasper;
        ArrayList<String> traitList = new ArrayList<String>();// = new String [] {"angsty", "protective", "polite", "charming", "outgoing", "optimistic", "caring", "stubborn", "charismatic"
        for(int i = 0; i<8; i++)
        {
            for(int j = 0; j<CharList[i].getPersonality().length; j++)
            {
                if(traitList.contains(CharList[i].getPersonality()[j])==false)
                {
                    traitList.add(CharList[i].getPersonality()[j]);
                }
            }
        }
        Scanner hair = new Scanner(System.in);  // Create a Scanner object
        String userHair = "";
        while(userHair.equals("")||(!userHair.equalsIgnoreCase("brown")&&!userHair.equalsIgnoreCase("blonde"))){
            System.out.println("Which hair color most matches yours: brown or blonde");
            hair = new Scanner(System.in);  // Recreate Scanner object until valid input
            userHair = hair.nextLine();
        }
        Scanner personality = new Scanner(System.in); 
        System.out.println("Choose 5 personality traits that best match you:\n");
        int inc = 5;
        int last = 0;
        for(int i = 0; i+inc<traitList.size(); i+=inc)
        { 
            for(int l =0; l<inc; l++)
            {
                System.out.print(traitList.get(i+l) +", ");
            }
            System.out.println(" ");
            last+=5;
        }
        int extra = traitList.size()-last;
        for(int j = 0; j<extra; j++)
        {
            if(j==extra-1)
            {
                System.out.println(traitList.get(last+j));
            }
            else
            {
                System.out.print(traitList.get(last+j) + ", ");
            }

        }
        ArrayList<String> userPersonality = new ArrayList<String>();
        String first = "";
        while(first.equals("")||(traitList.contains(first)==false)){
            System.out.println("Enter first:");
            personality = new Scanner(System.in);  // Recreate Scanner object until valid input
            first = personality.nextLine();
        }
        userPersonality.add(first);
        String second = "";
        while(second.equals("")||(traitList.contains(second)==false)){
            System.out.println("Enter second:");
            personality = new Scanner(System.in);  // Recreate Scanner object until valid input
            second = personality.nextLine();
        }
        userPersonality.add(second);
        String third = "";
        while(third.equals("")||(traitList.contains(third)==false)){
            System.out.println("Enter third:");
            personality = new Scanner(System.in);  // Recreate Scanner object until valid input
            third = personality.nextLine();
        }
        userPersonality.add(third);
        String fourth = "";
        while(fourth.equals("")||(traitList.contains(fourth)==false)){
            System.out.println("Enter fourth:");
            personality = new Scanner(System.in);  // Recreate Scanner object until valid input
            fourth = personality.nextLine();
        }
        userPersonality.add(fourth);
        String fifth = "";
        while(fifth.equals("")||(traitList.contains(fifth)==false)){
            System.out.println("Enter fifth:");
            personality = new Scanner(System.in);  // Recreate Scanner object until valid input
            fifth = personality.nextLine();
        }
        userPersonality.add(fifth);
        Scanner age = new Scanner(System.in); 
        String years = "";
        while(years.equals("")){
            System.out.println("How old are you? Enter age in numbers:");
            age = new Scanner(System.in);  // Recreate Scanner object until valid input
            years = age.nextLine();
        }
        int userAge = Integer.parseInt(years);  
        Scanner gender = new Scanner(System.in);
        String gen = "";
        while(gen.equals("")||(gen.equalsIgnoreCase("female")==false && gen.equalsIgnoreCase("male")==false && gen.equalsIgnoreCase("other")==false)){
            System.out.println("With what gender do you identify: male, female or other?");
            gender = new Scanner(System.in);  // Recreate Scanner object until valid input
            gen = gender.nextLine();
        }
        String userGender = gen;  
        for(int i = 0; i<8; i++)
        {
            if(checkHair(userHair, CharList[i].getHair())==true)
            {
                share[i] = share[i]+1;
            }
            share[i] = share[i] + checkPersonality(userPersonality, CharList[i].getPersonality());
            if(checkAge(userAge, CharList[i].getAge())==true)
            {
                share[i] = share[i]+1;
            }
            if(checkGender(userGender, CharList[i].getGender())==true)
            {
                share[i] = share[i]+1;
            }
        }
        int biggest = -1;
        int whichChar = 0;
        for(int i = 0; i<8; i++)
        {
            if(share[i]>biggest)
            {
                biggest = share[i];
                whichChar = i;
            }

        }
        System.out.println("The character you most closely resemble is " + CharList[whichChar].getName() + "!");
        String pronoun = "";
        if(CharList[whichChar].getGender()=="female")
        {
            pronoun = "her";
        }
        else
        {
            pronoun = "him";
        }
        System.out.print("Other traits of " + CharList[whichChar].getName() + "'s are ");
        String otherTraits [] = CharList[whichChar].getPersonality();
        for (int i = 0; i<otherTraits.length-1; i++)
        {
            System.out.print(otherTraits[i] + ", ");
        }
        System.out.println("and " + otherTraits[otherTraits.length-1] + " but this doesn't mean you're exactly like " + pronoun +"!"); 
        System.out.println("After all, you're definitely not a vampire!");
    }

    public Boolean checkHair(String userHair, String charHair)
    {
        if(userHair.equals(charHair)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int checkPersonality(ArrayList<String> userPersonality, String [] charPersonality)
    {
        int userSize = userPersonality.size();
        int charSize = charPersonality.length;
        int count =0;
        for(int i = 0; i<userSize; i++)
        {
            for(int j = 0; j<charSize; j++)
            {
                if(userPersonality.get(i).equals(charPersonality[j])==true)
                {
                    count ++;
                }
            }
        }
        return count;
    }

    public Boolean checkAge(int userAge, int charAge)
    {
        if(userAge==charAge)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkGender(String userGender, String charGender)
    {
        if(userGender.equals(charGender)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
