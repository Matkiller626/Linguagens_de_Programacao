

package battle_simulator;
import java.util.Scanner;

public class Battle_Simulator {
  static Scanner ler = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    String SelectedChampion;
    String SelectedItem;
    String Winner;
    
    //Selecting your champion
    System.out.println("Welcome to Battle Simulator!!!\n\n"
                     + "  Select your Champion!\n ");
    
    SelectedChampion = SelectChampion("Player");
    System.out.println("\n Select your equipment!\n");    
    SelectedItem = SelectItem("Player Item");
    
    Champion PlayerChampion = new Champion(SelectedChampion,SelectedItem);
    
    //Selecting your adversary
    System.out.println("\n Select your adversary!\n");
    SelectedChampion = SelectChampion(PlayerChampion.getName());
    System.out.println("\n Select your equipment!\n");
    SelectedItem = SelectItem(PlayerChampion.getItem());
    
    Champion AdversaryChampion = new Champion(SelectedChampion,SelectedItem);
    
    System.out.println("Let the battle begin!");
    
    if (AdversaryChampion.getItem().equals("Gun")){
      System.out.println("What? Giving a Gun to your enemy? Why?!?!\n");
      System.out.println(PlayerChampion.getState()+" "+PlayerChampion.getName()+" died.\n");
      Winner = AdversaryChampion.getState()+" "+AdversaryChampion.getName();
    }else{
      if (PlayerChampion.getItem().equals("Gun")){
        System.out.println("What? Bringing a Gun to a fight? You coward!!\n");
      }
      if (PlayerChampion.getWisdom()>AdversaryChampion.getWisdom()){
        Winner = Battle(PlayerChampion,AdversaryChampion);
      }else{
        Winner = Battle(AdversaryChampion,PlayerChampion);
      } 
    }    
    System.out.println("The winner is "+ Winner+"!");
  }
  
  private static String SelectChampion(String SelectedChampion){
    int     SeletedChampionID;
    String ValidChampion;
    
    do{
      ListChampions(SelectedChampion);
      SeletedChampionID = ler.nextInt();
      ValidChampion = NameConverter(SeletedChampionID);
      if(ValidChampion.equals(SelectedChampion)){
        ValidChampion = "None";
        System.out.println("Invalid option, try again!");
      }
      if(!ValidChampion.equals("None")){
        SelectedChampion = ValidChampion;
      }
    }while(ValidChampion.equals("None"));
    
    System.out.println("You selected: "+SelectedChampion);
    return SelectedChampion;
  }
  
  private static void ListChampions (String SelectedChampion){
    String[] Champion = {"ZZ Pet","ForeHeader","Leviatan","Fly-man"};
    
    for (int i = 1; i <= 4; i++){
      if (!SelectedChampion.equals(Champion[i-1])){
        System.out.println("["+i+"] - "+Champion[i-1]); 
      }
    }
    System.out.print("\nYour choice : ");
  }
  
  private static String SelectItem(String SelectedItem){
    int     SeletedItemID;
    String ValidItem;
    
    do {
      ListItens(SelectedItem);
      SeletedItemID = ler.nextInt();
      ValidItem = ItemConverter(SeletedItemID);
      if(ValidItem.equals(SelectedItem)){
        ValidItem = "None";
        System.out.println("Invalid option, try again!");
      }
      if (!ValidItem.equals("None")){
        SelectedItem = ValidItem;
      }
    }while(ValidItem.equals("None"));
    
    System.out.println("You selected: "+SelectedItem+"\n");
    return SelectedItem;
  }
  
  private static void ListItens (String SelectedItem){
    String[] Itens = {"Beer","Gorila Finger","Glasses","Gun"};
    
    for (int i = 1; i <= 4; i++){
      if (!SelectedItem.equals(Itens[i-1])){
        System.out.println("["+i+"] - "+Itens[i-1]); 
      }
    }
    System.out.print("\nYour choice : ");
  }
  
  private static String NameConverter(int Name){      
    switch(Name){
            case 1:
              return "ZZ Pet";
            case 2:
              return "ForeHeader";
            case 3:
              return "Leviatan";
            case 4:
              return "Fly-man";
            default:
              System.out.println("Invalid option, try again!");
              return "None";
    }
  }
  
  private static String ItemConverter(int Item){      
    switch(Item){
            case 1:
              return "Beer";
            case 2:
              return "Gorila Finger";
            case 3:
              return "Glasses";
            case 4:
              return "Gun";
            default:
              System.out.println("Invalid option, try again!");
              return "None";
    }
  }
  
  private static void Stall(int miliseconds){
    try {
      Thread.sleep(miliseconds);
    }catch(Exception e){}
  }
  
  private static String Battle(Champion FirstAttacker, Champion LastAttacker){
    String Winner = null;
    
    
    while(true){
      System.out.println("\n");
      System.out.println("Champion: "+FirstAttacker.getState()+" "+FirstAttacker.getName()
                       + "  Health: "+FirstAttacker.getHealth());
      System.out.println("Champion: "+LastAttacker.getState()+" "+LastAttacker.getName()
                       + "  Health: "+LastAttacker.getHealth()+"\n");
      
      Stall(1000);
      
      FirstAttacker.Attack(LastAttacker);
      if (LastAttacker.getHealth()<=0){
        System.out.println(LastAttacker.getState()+" "+LastAttacker.getName()+" fainted.\n");
        Winner = FirstAttacker.getState() +" "+ FirstAttacker.getName();
        break;
      }
      
      Stall(1000);
      
      LastAttacker.Attack(FirstAttacker);
      if (FirstAttacker.getHealth()<=0){
        System.out.println(FirstAttacker.getState()+" "+FirstAttacker.getName()+" fainted.\n");
        Winner = LastAttacker.getState() +" "+ LastAttacker.getName();
        break;
      }  
    }
    
    return Winner;
   
  }
  
}


