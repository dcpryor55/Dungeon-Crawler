import java.util.ArrayList;

public class Player 
{	
	public ArrayList<String> log = new ArrayList<String>();
	protected ArrayList<Map> levelSave = new ArrayList<Map>();	
	protected String name;	
	protected int health = 10;
	protected int level = 1;
	protected int xp;
	protected int damage = 1;
	protected int armor;
	protected int evasion;
	protected int gold = 0;
	protected int x;
	protected int y;
	
	public int attack(int enemyHealth, int damage)
	{
		enemyHealth = enemyHealth - damage;
		return enemyHealth;
	}	
	
	public void move(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}		
	public void moveLeft()
	{
		y--;
	}
	public void moveRight()
	{
		y++;
	}
	public void moveUp()
	{
		x--;
	}
	public void moveDown()
	{
		x++;
	}
	public void moveUpLeft()
	{
		x--;
		y--;
	}
	public void moveUpRight()
	{
		x--;
		y++;
	}
	public void moveDownLeft()
	{
		x++;
		y--;
	}
	public void moveDownRight()
	{
		x++;
		y++;
	}

	// getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}			
	
}
