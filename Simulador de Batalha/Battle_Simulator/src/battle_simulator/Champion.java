
package battle_simulator;
import java.util.Random;

public final class Champion {
  
  private String  Name;
  private String  State;
  private String  Item;
  private double  Wisdom;
  private int     Health;
  private int     Attack;
  private int     Defense;

  public Champion(String Name, String Item) {
    this.Name = Name;
    this.Item = Item;
    StatsCalculator();
    PrintChampion();
  }
  
  public void Attack(Champion AttackedChampion){
    Random rand = new Random();
    int Damage;
    int AttackVariance;
    
    AttackVariance = AttackVarianceSetter()*rand.nextInt(((int)this.Attack/3)+1);
    
    if(isCritical()){
      Damage = (int)(this.Attack*1.8*1.5) - AttackedChampion.Defense + AttackVariance;
      AttackedChampion.Health = AttackedChampion.Health - Damage;
      System.out.println(this.State+" "+this.Name+" did a CRITICAL DAMAGE of "+Damage+" Damage");
    }else{
      Damage = (int)(this.Attack*1.8) - AttackedChampion.Defense + AttackVariance;
      AttackedChampion.Health = AttackedChampion.Health - Damage;
      System.out.println(this.State+" "+this.Name+" did "+Damage+" Damage");
    }    
  }
  
  private int AttackVarianceSetter(){
    Random rand = new Random();
    
    if(rand.nextInt(101) < 50){
      return -1;
    }else{
      return 1;
    }
  }
  
  private boolean isCritical(){
    Random rand = new Random();
    int CriticalChance = 100 - (int)((this.Wisdom * 10) - 5);
    int Random = rand.nextInt(101);
    
    return Random > CriticalChance;
  }
  
  public void PrintChampion(){
    System.out.println("Champion: " + State +" "+ Name );
    System.out.println("Max Health: " + Health);
    System.out.println("Attack: " + Attack);
    System.out.println("Defense: " + Defense);
    System.out.println("Wisdom: " + Wisdom + "\n");
  }
  
  public void StatsCalculator(){
    switch(this.Name){
      case "ZZ Pet":
        Health = 45;
        Attack = 7;
        Defense = 4;
        Wisdom = 2.5;
      break;
      case "ForeHeader":
        Health = 35;
        Attack = 6;
        Defense = 4;
        Wisdom = 3.5;
      break;
      case "Leviatan":
        Health = 50;
        Attack = 9;
        Defense = 2;
        Wisdom = 1;
      break;
      case "Fly-man":
        Health = 40;
        Attack = 4;
        Defense = 7;
        Wisdom = 2;
      break;    
    }
    
    switch(this.Item){
      case "Beer":
        State = "Drunk";
        Health = Health + 5;
        Defense = Defense - 1;
        Wisdom = Wisdom + 0.5;
        break;
      case "Gorila Finger":
        State = "High";
        Defense = Defense + 1;
        Wisdom = Wisdom - 1;
        break;
      case "Glasses":
        State = "Nerd";
        Health = Health - 5;
        Wisdom = Wisdom + 2;
        break;
      case "Gun":
        State = "Coward";
        Health = 1;
        Attack = 0;
        Defense = 0;
        Wisdom = 0;
        break;
    }
  }
 
  public String getName() {
    return Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getItem() {
    return Item;
  }

  public void setItem(String Item) {
    this.Item = Item;
  }

  public int getHealth() {
    return Health;
  }

  public void setHealth(int Health) {
    this.Health = Health;
  }

  public int getAttack() {
    return Attack;
  }

  public void setAttack(int Attack) {
    this.Attack = Attack;
  }

  public int getDefense() {
    return Defense;
  }

  public void setDefense(int Defense) {
    this.Defense = Defense;
  }
  
  public double getWisdom() {
    return Wisdom;
  }

  public void setWisdom(double Wisdom) {
    this.Wisdom = Wisdom;
  }
  
  public String getState() {
    return State;
  }

  public void setState(String State) {
    this.State = State;
  }
}
