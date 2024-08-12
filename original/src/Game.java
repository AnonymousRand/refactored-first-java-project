/*If these java projects are from another computer/drive etc,
copy all the code into a new project on your own device.
If it does not run because the configuration cannot find
the main class or it says "cannot find or load main class" or
there is no configuration automatically set up for you,
go to File>Project Structure and make sure that
the project compiler output is the "out" folder in the project folder.
Then, go to the Modules section and make sure that the project folder is a content root
(use the add content root button on the right if necessary)
and mark that project folder as source. Then, when you try
to run, there should be a configuration automatically set up with
the same name as your main class and use that configuration to run it.
Also make sure that the working directory in the configuration
setup is the src file of the project.

Else: just create a new project, use the left-hand side toolbar (for IntelliJ) to navigate to
the src file of that project; then right click on the src file and click "New > Java Class"
then create a class with the same exact name as the main class on this project
(currently called "Game") and copy paste all the code into that new project.
*/
import java.util.Random;
import java.util.Scanner;
public class Game {
    public static int shield1 = 0, shield2 = 0;
    public static int player1char, player2char;
    public static boolean restart = true;
    public static boolean turnend = false;
    public static Scanner input = new Scanner(System.in);
    public static String choice;
    public static Warrior wplayer1 = new Warrior(250, 1), wplayer2 = new Warrior(250, 1);
    public static Archer aplayer1 = new Archer(240, 3), aplayer2 = new Archer(240, 3);
    public static Paladin pplayer1 = new Paladin(250, 6), pplayer2 = new Paladin(250, 6);
    public static Thug tplayer1 = new Thug(300, 0), tplayer2 = new Thug(300, 0);
    public static Monk moplayer1 = new Monk(200, 3), moplayer2 = new Monk(200, 3);
    public static Mage maplayer1 = new Mage(170, 1), maplayer2 = new Mage(170, 1);
    public static Commander cplayer1 = new Commander(190, 2), cplayer2 = new Commander(190, 2);
    public static Jedi jplayer1 = new Jedi(200, 4), jplayer2 = new Jedi(200, 4);
    public static Darkknight dplayer1 = new Darkknight(250, 2), dplayer2 = new Darkknight(250, 2);
    public static Dragon drplayer1 = new Dragon(280, 0), drplayer2 = new Dragon(280, 0);
    public static Kid kplayer1 = new Kid(170, 1), kplayer2 = new Kid(170, 1);
    public static int cooldown11 = 0;
    public static int cooldown21 = 0;
    public static int cooldown12 = 0;
    public static int cooldown22 = 0;
    public static int cooldown13 = 0;
    public static int cooldown23 = 0;
    public static int player1health, player2health, player1def, player2def;
    public static int player1reflect = 0, player2reflect = 0;
    public static boolean quitgame;
    public static boolean monkspec1 = false, monkspec2 = false;
    public static turn currenturn = turn.ONE;
    public static gamestate currentstate;
    public static boolean redo = false, invalidreplay = false;
    public static boolean charchoicevalid = true;

    enum turn {
        ONE, TWO
    }

    enum gamestate {
        RUNNING, GAMEOVER
    }

    public static void main(String[] args) {
        /*PApplet.main("ProjectRPG");*/

        do {
            replayreset();
            redo = false;
            invalidreplay = false;

            do {
                quitgame = false;
                currenturn = turn.ONE;
                charchoicevalid = true;
                System.out.println("Welcome to Project RPG. Player 1, please choose your character:");
                System.out.println("0. Character Descriptions     1. Warrior     2. Archer     3. Paladin" +
                        "     4. Thug     5. Monk     6. Mage     7. Commander     8. Jedi     9. Dark Knight     10. Dragon     11. Kid");
                String charc = input.nextLine();
                if (charc.equals("0")) {
                    System.out.println("Warrior: Straightfowards attacker that can increase his own damage"); //add more
                    System.out.println("1. Warrior     2. Archer     3. Paladin" +
                            "     4. Thug     5. Monk     6. Mage     7. Commander     8. Jedi     9. Dark Knight     10. Dragon     11. Kid");
                    charc = input.nextLine();
                }
                /*make this a comment if java can't find your image: warrior = loadImage("out/Images/warrior.jpg");
                image(warrior, 120, 300, 300, 300);*/
                /*archer = loadImage("out/Images/archer.png");
                image(archer, 120, 300, 300, 300);*/
                /*paladin = loadImage("out/Images/paladin.png");
                image(paladin, 120, 300, 300, 300);*/
                /*thug = loadImage("out/Images/thug.png");
                image(thug, 120, 300, 300, 300);*/
                /*monk = loadImage("out/Images/monk.png");
                image(monk, 120, 300, 300, 300);*/
                /*mage = loadImage("out/Images/mage.png");
                image(mage, 120, 300, 300, 300);*/
                /*commander = loadImage("out/Images/commander.gif");
                image(commander, 120, 300, 300, 300);*/
                /*jedi = loadImage("out/Images/jedi.png");
                image(jedi, 120, 300, 300, 300);*/
                /*darkknight = loadImage("out/Images/darkknight.jpg");
                image(darkknight, 120, 300, 300, 300);*/
                /*dragon = loadImage("out/Images/dragon.png");
                image(dragon, 120, 300, 300, 300);*/
                switch (charc) {
                    case "1":
                        player1char = 1;
                        wplayer1 = new Warrior(250, 1);
                        player1health = 250;
                        player1def = 1;
                        break;
                    case "2":
                        player1char = 2;
                        aplayer1 = new Archer(240, 3);
                        player1health = 240;
                        player1def = 3;
                        break;
                    case "3":
                        player1char = 3;
                        pplayer1 = new Paladin(250, 6);
                        player1health = 250;
                        player1def = 6;
                        break;
                    case "4":
                        player1char = 4;
                        tplayer1 = new Thug(300, 0);
                        player1health = 300;
                        player1def = 0;
                        break;
                    case "5":
                        player1char = 5;
                        moplayer1 = new Monk(200, 3);
                        player1health = 200;
                        player1def = 3;
                        break;
                    case "6":
                        player1char = 6;
                        maplayer1 = new Mage(170, 1);
                        player1health = 170;
                        player1def = 1;
                        break;
                    case "7":
                        player1char = 7;
                        cplayer1 = new Commander(190, 2);
                        player1health = 190;
                        player1def = 2;
                        break;
                    case "8":
                        player1char = 8;
                        jplayer1 = new Jedi(200, 4);
                        player1health = 200;
                        player1def = 4;
                        break;
                    case "9":
                        player1char = 9;
                        dplayer1 = new Darkknight(250, 2);
                        player1health = 250;
                        player1def = 2;
                        break;
                    case "10":
                        player1char = 10;
                        drplayer1 = new Dragon(280, 0);
                        player1health = 280;
                        player1def = 0;
                        break;
                    case "11":
                        player1char = 11;
                        kplayer1 = new Kid(170, 1);
                        player1health = 170;
                        player1def = 1;
                        break;
                    default:
                        System.out.println("That wasn't a valid response. Please try again:");
                        charchoicevalid = false;
                        break;
                }
            } while (!charchoicevalid);

            do {
                charchoicevalid = true;
                System.out.println("Player 2, please choose your character:");
                System.out.println("0. Character Descriptions     1. Warrior     2. Archer     3. Paladin" +
                        "     4. Thug     5. Monk     6. Mage     7. Commander     8. Jedi     9. Dark Knight     10. Dragon     11. Kid");
                String charc = input.nextLine();
                if (charc.equals("0")) {
                    System.out.println("Character Descriptions"); //add more
                    System.out.println("1. Warrior     2. Archer     3. Paladin" +
                            "     4. Thug     5. Monk     6. Mage     7. Commander     8. Jedi     9. Dark Knight     10. Dragon     11. Kid");
                    charc = input.nextLine();
                }
                /*warrior2 = loadImage("out/Images/warrior.jpg");
                image(warrior2, 580, 300, 300, 300);*/
                /*archer2 = loadImage("out/Images/archer.png");
                image(archer2, 580, 300, 300, 300);*/
                /*paladin2 = loadImage("out/Images/paladin.png");
                image(paladin2, 580, 300, 300, 300);*/
                /*thug2 = loadImage("out/Images/thug.png");
                image(thug2, 580, 300, 300, 300);*/
                /*monk2 = loadImage("out/Images/monk.png");
                image(monk2, 580, 300, 300, 300);*/
                /*mage2 = loadImage("out/Images/mage.png");
                image(mage2, 580, 300, 300, 300);*/
                /*commander2 = loadImage("out/Images/commander.gif");
                image(commander2, 580, 300, 300, 300);*/
                /*jedi2 = loadImage("out/Images/jedi.png");
                image(jedi2, 580, 300, 300, 300);*/
                /*darkknight2 = loadImage("out/Images/darkknight.jpg");
                image(darkknight2, 580, 300, 300, 300);*/
                /*dragon2 = loadImage("out/Images/dragon.png");
                image(dragon2, 580, 300, 300, 300);*/
                switch (charc) {
                    case "1":
                        player2char = 1;
                        wplayer2 = new Warrior(250, 1);
                        player2health = 250;
                        player2def = 1;
                        break;
                    case "2":
                        player2char = 2;
                        aplayer2 = new Archer(240, 3);
                        player2health = 240;
                        player2def = 3;
                        break;
                    case "3":
                        player2char = 3;
                        pplayer2 = new Paladin(250, 6);
                        player2health = 250;
                        player2def = 6;
                        break;
                    case "4":
                        player2char = 4;
                        tplayer2 = new Thug(300, 0);
                        player2health = 300;
                        player2def = 0;
                        break;
                    case "5":
                        player2char = 5;
                        moplayer2 = new Monk(200, 3);
                        player2health = 200;
                        player2def = 3;
                        break;
                    case "6":
                        player2char = 6;
                        maplayer2 = new Mage(170, 1);
                        player2health = 170;
                        player2def = 1;
                        break;
                    case "7":
                        player2char = 7;
                        cplayer2 = new Commander(190, 2);
                        player2health = 190;
                        player2def = 2;
                        break;
                    case "8":
                        player2char = 8;
                        jplayer2 = new Jedi(200, 4);
                        player2health = 200;
                        player2def = 4;
                        break;
                    case "9":
                        player2char = 9;
                        dplayer2 = new Darkknight(250, 2);
                        player2health = 250;
                        player2def = 2;
                        break;
                    case "10":
                        player2char = 10;
                        drplayer2 = new Dragon(280, 0);
                        player2health = 280;
                        player2def = 0;
                        break;
                    case "11":
                        player2char = 11;
                        kplayer2 = new Kid(170, 1);
                        player2health = 170;
                        player2def = 1;
                        break;
                    default:
                        System.out.println("That wasn't a valid response. Please try again:");
                        charchoicevalid = false;
                        break;
                }
            } while (!charchoicevalid);

            currentstate = gamestate.RUNNING;

            while (currentstate == gamestate.RUNNING) {
                restart = false;
                turnend = false;
                switch (player1char) {
                    case 1:
                        wplayer1.askmove();
                        break;
                    case 2:
                        aplayer1.askmove();
                        break;
                    case 3:
                        pplayer1.askmove();
                        break;
                    case 4:
                        tplayer1.askmove();
                        break;
                    case 5:
                        moplayer1.askmove();
                        break;
                    case 6:
                        maplayer1.askmove();
                        break;
                    case 7:
                        cplayer1.askmove();
                        break;
                    case 8:
                        jplayer1.askmove();
                        break;
                    case 9:
                        dplayer1.askmove();
                        break;
                    case 10:
                        drplayer1.askmove();
                        break;
                    case 11:
                        kplayer1.askmove();
                        break;
                }

                while (!turnend) {
                    //empty
                }

                turnend = false;

                if (currentstate == gamestate.GAMEOVER && player2health <= 0) {   //p1 wins
                    System.out.println("Player 1 wins!");
                    System.out.println("Thank you for playing Project RPG.");
                    do {
                        System.out.println("Would you like to play again? (Y/N)");
                        String replaystring = input.nextLine().toLowerCase();
                        switch (replaystring) {
                            case "y":
                                redo = true;
                                invalidreplay = false;
                                break;
                            case "n":
                                redo = false;
                                invalidreplay = false;
                                System.exit(0);
                                break;
                            default:
                                System.out.println("That was not a valid response. Please try again:");
                                invalidreplay = true;
                                break;
                        }
                    } while (invalidreplay);
                } else if (currentstate == gamestate.GAMEOVER && player1health <= 0) {   //p2 wins via counter/reflect
                    System.out.println("Player 2 wins!");
                    System.out.println("Thank you for playing Project RPG.");
                    do {
                        System.out.println("Would you like to play again? (Y/N)");
                        String replaystring = input.nextLine().toLowerCase();
                        switch (replaystring) {
                            case "y":
                                redo = true;
                                invalidreplay = false;
                                break;
                            case "n":
                                redo = false;
                                invalidreplay = false;
                                System.exit(0);
                                break;
                            default:
                                System.out.println("That was not a valid response. Please try again:");
                                invalidreplay = true;
                                break;
                        }
                    } while (invalidreplay);
                } else if (currentstate == gamestate.GAMEOVER && quitgame) {
                    System.out.println("You have exited the match.");
                    do {
                        System.out.println("Would you like to play again? (Y/N)");
                        String replaystring = input.nextLine().toLowerCase();
                        switch (replaystring) {
                            case "y":
                                redo = true;
                                invalidreplay = false;
                                break;
                            case "n":
                                redo = false;
                                invalidreplay = false;
                                System.exit(0);
                                break;
                            default:
                                System.out.println("That was not a valid response. Please try again:");
                                invalidreplay = true;
                                break;
                        }
                    } while (invalidreplay);
                }

                if (!redo) {
                    switch (player2char) {
                        case 1:
                            wplayer2.askmove();
                            break;
                        case 2:
                            aplayer2.askmove();
                            break;
                        case 3:
                            pplayer2.askmove();
                            break;
                        case 4:
                            tplayer2.askmove();
                            break;
                        case 5:
                            moplayer2.askmove();
                            break;
                        case 6:
                            maplayer2.askmove();
                            break;
                        case 7:
                            cplayer2.askmove();
                            break;
                        case 8:
                            jplayer2.askmove();
                            break;
                        case 9:
                            dplayer2.askmove();
                            break;
                        case 10:
                            drplayer2.askmove();
                            break;
                        case 11:
                            kplayer2.askmove();
                            break;
                    }

                    while (!turnend) {
                        //empty
                    }

                    turnend = false;

                    if (currentstate == gamestate.GAMEOVER && player1health <= 0) {   //p2 wins
                        System.out.println("Player 2 wins!");
                        System.out.println("Thank you for playing Project RPG.");
                        do {
                            System.out.println("Would you like to play again? (Y/N)");
                            String replaystring = input.nextLine().toLowerCase();
                            switch (replaystring) {
                                case "y":
                                    redo = true;
                                    invalidreplay = false;
                                    break;
                                case "n":
                                    redo = false;
                                    invalidreplay = false;
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("That was not a valid response. Please try again:");
                                    invalidreplay = true;
                                    break;
                            }
                        } while (invalidreplay);
                    } else if (currentstate == gamestate.GAMEOVER && player2health <= 0) {   //p1 wins
                        System.out.println("Player 1 wins!");
                        System.out.println("Thank you for playing Project RPG.");
                        do {
                            System.out.println("Would you like to play again? (Y/N)");
                            String replaystring = input.nextLine().toLowerCase();
                            switch (replaystring) {
                                case "y":
                                    redo = true;
                                    invalidreplay = false;
                                    break;
                                case "n":
                                    redo = false;
                                    invalidreplay = false;
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("That was not a valid response. Please try again:");
                                    invalidreplay = true;
                                    break;
                            }
                        } while (invalidreplay);
                    } else if (currentstate == gamestate.GAMEOVER && quitgame) {
                        System.out.println("You have exited the match.");
                        do {
                            System.out.println("Would you like to play again? (Y/N)");
                            String replaystring = input.nextLine().toLowerCase();
                            switch (replaystring) {
                                case "y":
                                    redo = true;
                                    invalidreplay = false;
                                    break;
                                case "n":
                                    redo = false;
                                    invalidreplay = false;
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("That was not a valid response. Please try again:");
                                    invalidreplay = true;
                                    break;
                            }
                        } while (invalidreplay);
                    }
                }
            }
        } while (redo);
    }

    /*public void settings() {

        size(1000, 1000);
    }

    public void setup() {
        background(255, 255, 255);
        currentstate = gamestate.RUNNING;
    }*/

    /*public void draw() {


    }*/

    public static class Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int bonus1 = 0, bonus2 = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Character(int health, int def) {
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true; //can't do from attack4 directly as target is pass by value and cannot change dd
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Warrior's defense has been increased by 1.");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Warrior lost " + (this.health * 0.08) + " health.");
                this.health -= this.health * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Warrior is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 17 + bonus1;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 50 + bonus2 - generator.nextInt(6);

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 2;
            } else {
                cooldown21 = 2;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 1);
        }

        public void attack3() {
            this.bonus1 += 2;
            this.bonus2 += 5;

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("Sword Slash now does " + this.bonus1 + " more damage for a total possible damage output of " + (17 + bonus1) + "-" + (19 + bonus1) + ".");
            System.out.println("Battering Ram now does " + this.bonus2 + " more damage for a total possible damage output of " + (45 + bonus1) + "-" + (50 + bonus1) + ".");

            turnend = true;
        }

        public void attack4(Character target) {

            if (!this.bi) {
                this.ou = true;
                System.out.println("Warrior gained Offense Up, his opponent was inflicted with Defense Down, and Warrior dispelled all buffs on his opponent.");
            } else {
                this.bi = false;
                System.out.println("Warrior has Buff Immunity. His opponent was inflicted with Defense Down, and Warrior dispelled all buffs on his opponent.");
            }

            target.defdown();
            target.dispelbuffs();

            if (!this.hi) {
                this.health += 5;
                System.out.println("Warrior also healed for 5 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Warrior");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Sword Slash");
                    System.out.println("2. Battering Ram, " + cooldown11 + " cooldown");
                    System.out.println("3. Combat Training, " + cooldown12 + " cooldown");
                    System.out.println("4. Offensive Push, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Sword Slash");
                        System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                        System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                        System.out.println("4. Offensive Push, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                wplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                wplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                wplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                wplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                wplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                wplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                wplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                wplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                wplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                wplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                wplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    wplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    wplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    wplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    wplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    wplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    wplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    wplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    wplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    wplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    wplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    wplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Battering Ram is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            wplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Combat Training is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    wplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    wplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    wplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    wplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    wplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    wplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    wplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    wplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    wplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    wplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    wplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Offensive Push is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Warrior");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Sword Slash");
                    System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                    System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                    System.out.println("4. Offensive Push, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Sword Slash");
                        System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                        System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                        System.out.println("4. Offensive Push, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                wplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                wplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                wplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                wplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                wplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                wplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                wplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                wplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                wplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                wplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                wplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    wplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    wplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    wplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    wplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    wplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    wplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    wplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    wplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    wplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    wplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    wplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Battering Ram is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            wplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Combat Training is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    wplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    wplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    wplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    wplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    wplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    wplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    wplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    wplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    wplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    wplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    wplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Offensive Push is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Warrior extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Warrior(int health, int def) {
            super(250, 1);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Warrior's defense has been increased by 1.");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Warrior lost " + (this.health * 0.08) + " health.");
                this.health -= this.health * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Warrior is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 17 + bonus1;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 50 + bonus2 - generator.nextInt(6);

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 2;
            } else {
                cooldown21 = 2;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 1);
        }

        public void attack3() {
            this.bonus1 += 2;
            this.bonus2 += 5;

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("Sword Slash now does " + this.bonus1 + " more damage for a total possible damage output of " + (17 + bonus1) + "-" + (19 + bonus1) + ".");
            System.out.println("Battering Ram now does " + this.bonus2 + " more damage for a total possible damage output of " + (45 + bonus1) + "-" + (50 + bonus1) + ".");

            turnend = true;
        }

        public void attack4(Character target) {

            if (!this.bi) {
                this.ou = true;
                System.out.println("Warrior gained Offense Up, his opponent was inflicted with Defense Down, and Warrior dispelled all buffs on his opponent.");
            } else {
                this.bi = false;
                System.out.println("Warrior has Buff Immunity. His opponent was inflicted with Defense Down, and Warrior dispelled all buffs on his opponent.");
            }

            target.defdown();
            target.dispelbuffs();

            if (!this.hi) {
                this.health += 5;
                System.out.println("Warrior also healed for 5 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
                player1health = this.health;
            } else {
                cooldown23 = 4;
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Warrior");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Sword Slash");
                    System.out.println("2. Battering Ram, " + cooldown11 + " cooldown");
                    System.out.println("3. Combat Training, " + cooldown12 + " cooldown");
                    System.out.println("4. Offensive Push, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Sword Slash");
                        System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                        System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                        System.out.println("4. Offensive Push, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                wplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                wplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                wplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                wplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                wplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                wplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                wplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                wplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                wplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                wplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                wplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    wplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    wplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    wplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    wplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    wplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    wplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    wplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    wplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    wplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    wplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    wplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Battering Ram is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            wplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Combat Training is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    wplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    wplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    wplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    wplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    wplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    wplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    wplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    wplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    wplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    wplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    wplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Offensive Push is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Warrior");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Sword Slash");
                    System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                    System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                    System.out.println("4. Offensive Push, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Sword Slash");
                        System.out.println("2. Battering Ram, " + cooldown21 + " cooldown");
                        System.out.println("3. Combat Training, " + cooldown22 + " cooldown");
                        System.out.println("4. Offensive Push, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                wplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                wplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                wplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                wplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                wplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                wplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                wplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                wplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                wplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                wplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                wplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    wplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    wplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    wplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    wplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    wplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    wplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    wplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    wplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    wplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    wplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    wplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Battering Ram is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            wplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Combat Training is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    wplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    wplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    wplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    wplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    wplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    wplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    wplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    wplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    wplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    wplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    wplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Offensive Push is still on cooldown.");
                        } else {
                            System.out.println("Warrior has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Archer extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int crit = 25;
        public int bonus = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Archer(int health, int def) {
            super(240, 3);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Archer's defense has been increased by 1.");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Archer lost " + (240 * 0.08) + " health.");
                this.health -= 240 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Archer is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(2) + 11;

            if (generator.nextInt(101) <= this.crit) {
                damage *= 2;
                System.out.println("Crit!");
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 45 - generator.nextInt(6);
            int bonus2 = 10;

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    bonus2 = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage <= 0) {
                        damage = 0;
                        bonus2 = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    bonus2 = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage <= 0) {
                        damage = 0;
                        bonus2 = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 3;
            } else {
                cooldown21 = 3;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (target.defense > 3 && !target.dd) {

                this.health -= bonus2;
                System.out.println("The opponent has too much defense and Archer took " + bonus2 + " damage!");

                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }

                target.takeDamage(damage, 0);
            } else {
                target.takeDamage(damage + bonus2, 0);
            }
        }

        public void attack3() {
            bonus = generator.nextInt(3) + 18;
            crit += bonus;

            if (crit > 80) {
                crit = 80;
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("Crossbow now has " + this.crit + "% chance of critical hits, " + bonus + "% higher chance than before!");

            turnend = true;
        }

        public void attack4(Character target) {
            target.abblock();
            target.bonusd();
            System.out.println("Archer's opponent was inflicted with Bonus Damage and Ability Block.");

            if (!this.hi) {
                this.health += 12;
                System.out.println("Archer also healed for 12 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Archer");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Crossbow");
                    System.out.println("2. Spear Impale, " + cooldown11 + " cooldown");
                    System.out.println("3. Target Practice, " + cooldown12 + " cooldown");
                    System.out.println("4. Critical Hit, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Crossbow");
                        System.out.println("2. Spear Impale, " + cooldown21 + " cooldown");
                        System.out.println("3. Target Practice, " + cooldown22 + " cooldown");
                        System.out.println("4. Critical Hit, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                aplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                aplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                aplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                aplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                aplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                aplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                aplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                aplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                aplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                aplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                aplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    aplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    aplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    aplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    aplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    aplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    aplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    aplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    aplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    aplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    aplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    aplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Spear Impale is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            aplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Target Practice is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    aplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    aplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    aplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    aplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    aplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    aplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    aplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    aplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    aplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    aplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    aplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Critical Hit is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Archer");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Crossbow");
                    System.out.println("2. Spear Impale, " + cooldown21 + " cooldown");
                    System.out.println("3. Target Practice, " + cooldown22 + " cooldown");
                    System.out.println("4. Critical Hit, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Crossbow");
                        System.out.println("2. Spear Impale, " + cooldown21 + " cooldown");
                        System.out.println("3. Target Practice, " + cooldown22 + " cooldown");
                        System.out.println("4. Critical Hit, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                aplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                aplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                aplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                aplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                aplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                aplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                aplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                aplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                aplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                aplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                aplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    aplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    aplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    aplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    aplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    aplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    aplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    aplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    aplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    aplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    aplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    aplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Spear Impale is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            aplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Target Practice is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    aplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    aplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    aplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    aplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    aplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    aplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    aplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    aplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    aplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    aplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    aplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Critical Hit is still on cooldown.");
                        } else {
                            System.out.println("Archer has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Paladin extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;
        public int hsteal = 0;

        public Paladin(int health, int def) {
            super(250, 6);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Paladin's defense has been increased by 1.");
            }

            if (generator.nextInt(101) <= 15) {
                damage = 0;
                System.out.println("Damage Immunity!");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Paladin lost " + (250 * 0.08) + " health.");
                this.health -= 250 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Paladin is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 11;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.5;
                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }
                System.out.println("Paladin regained " + (damage * 0.5) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 35 - generator.nextInt(5);
            int incr = generator.nextInt(2) + 8;

            if (!this.hi) {
                this.health += incr;
                System.out.println("Paladin regained " + incr + " health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 4;
            } else {
                cooldown21 = 4;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.5;
                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }
                System.out.println("Paladin regained " + (damage * 0.5) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);
        }

        public void attack3() {

            if (this.defense >= 12) {
                if (!this.hi) {
                    this.health += 8;
                    System.out.println("Paladin healed for 8 health.");
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }
            } else {
                this.defense += 2;
                System.out.println("Paladin's defense was increased by 2.");
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
                player1def = this.defense;
            } else {
                player2health = this.health;
                player2def = this.defense;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void attack4(Character target) {
            this.hsteal = 3;

            if (!this.bi) {
                this.du = true;
                System.out.println("Paladin gained Defense Up and 50% Health Steal for the next 3 turns.");
            } else {
                this.bi = false;
                System.out.println("Paladin has Buff Immunity. Paladin gained 50% Health Steal for the next 2 turns.");
            }

            if (!this.hi) {
                this.health += 20;
                System.out.println("Paladin also healed for 20 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Paladin");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Axe Chop");
                    System.out.println("2. Sweet Vengeance, " + cooldown11 + " cooldown");
                    System.out.println("3. Armor Enhancement, " + cooldown12 + " cooldown");
                    System.out.println("4. Armor Upgrade, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Axe Chop");
                        System.out.println("2. Sweet Vengeance, " + cooldown21 + " cooldown");
                        System.out.println("3. Armor Enhancement, " + cooldown22 + " cooldown");
                        System.out.println("4. Armor Upgrade, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                pplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                pplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                pplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                pplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                pplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                pplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                pplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                pplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                pplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                pplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                pplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    pplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    pplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    pplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    pplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    pplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    pplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    pplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    pplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    pplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    pplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    pplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Sweet Vengeance is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            pplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Armor Enhancement is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    pplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    pplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    pplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    pplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    pplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    pplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    pplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    pplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    pplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    pplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    pplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Armor Upgrade is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Paladin");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Axe Chop");
                    System.out.println("2. Sweet Vengeance, " + cooldown21 + " cooldown");
                    System.out.println("3. Armor Enhancement, " + cooldown22 + " cooldown");
                    System.out.println("4. Armor Upgrade, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Axe Chop");
                        System.out.println("2. Sweet Vengeance, " + cooldown21 + " cooldown");
                        System.out.println("3. Armor Enhancement, " + cooldown22 + " cooldown");
                        System.out.println("4. Armor Upgrade, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                pplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                pplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                pplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                pplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                pplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                pplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                pplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                pplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                pplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                pplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                pplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    pplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    pplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    pplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    pplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    pplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    pplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    pplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    pplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    pplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    pplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    pplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Sweet Vengeance is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            pplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Armor Enhancement is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    pplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    pplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    pplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    pplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    pplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    pplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    pplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    pplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    pplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    pplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    pplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Armor Upgrade is still on cooldown.");
                        } else {
                            System.out.println("Paladin has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Thug extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int specit = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Thug(int health, int def) {
            super(300, 0);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Thug's defense has been increased by 1.");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Thug lost " + (300 * 0.08) + " health.");
                this.health -= 300 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Thug is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(4) + 11;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {

            int damage = generator.nextInt(11) + 40 - this.specit;

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 2;
            } else {
                cooldown21 = 2;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            System.out.println("Club Slam will now do up to 4 less damage for a total of " + (35 - this.specit) + "-" + (50 - this.specit) + " damage.");
            target.takeDamage(damage, 0);
            this.specit += 4;
        }

        public void attack3() {
            int increase = generator.nextInt(3);
            this.specit -= 10 + increase;

            if (currenturn == turn.ONE) {
                cooldown12 = 1;
            } else {
                cooldown22 = 1;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("Club Slam will now do up to " + -this.specit + " more damage for a total of " + (35 - this.specit) + "-" + (55 - this.specit) + " damage!");
            turnend = true;
        }

        public void attack4(Character target) {

            if (!this.bi) {
                this.ou = true;
                this.doubled = true;
                System.out.println("Thug's opponent was inflicted with Buff Immunity, both players will do 50% more damage next turn and Thug gained Offense Up.");
            } else {
                this.bi = false;
                System.out.println("Thug has Buff Immunity. Thug's opponent was inflicted with Buff Immunity and will do 50% more damage next turn.");
            }

            if (!this.hi) {
                this.health += 10;
                System.out.println("Thug also healed for 10 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            target.doubd();

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Thug");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Punch");
                    System.out.println("2. Club Slam, " + cooldown11 + " cooldown");
                    System.out.println("3. Metal Club, " + cooldown12 + " cooldown");
                    System.out.println("4. Brute Force, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Punch");
                        System.out.println("2. Club Slam, " + cooldown21 + " cooldown");
                        System.out.println("3. Metal Club, " + cooldown22 + " cooldown");
                        System.out.println("4. Brute Force, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                tplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                tplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                tplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                tplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                tplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                tplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                tplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                tplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                tplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                tplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                tplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    tplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    tplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    tplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    tplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    tplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    tplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    tplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    tplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    tplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    tplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    tplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Club Slam is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            tplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Metal Club is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    tplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    tplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    tplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    tplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    tplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    tplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    tplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    tplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    tplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    tplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    tplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Brute Force is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Thug");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Punch");
                    System.out.println("2. Club Slam, " + cooldown21 + " cooldown");
                    System.out.println("3. Metal Club, " + cooldown22 + " cooldown");
                    System.out.println("4. Brute Force, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Punch");
                        System.out.println("2. Club Slam, " + cooldown21 + " cooldown");
                        System.out.println("3. Metal Club, " + cooldown22 + " cooldown");
                        System.out.println("4. Brute Force, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                tplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                tplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                tplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                tplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                tplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                tplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                tplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                tplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                tplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                tplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                tplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    tplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    tplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    tplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    tplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    tplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    tplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    tplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    tplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    tplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    tplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    tplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Club Slam is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            tplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Metal Club is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    tplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    tplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    tplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    tplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    tplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    tplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    tplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    tplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    tplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    tplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    tplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Brute Force is still on cooldown.");
                        } else {
                            System.out.println("Thug has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Monk extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int penalty = 1;
        public int regain = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Monk(int health, int def) {
            super(200, 3);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {
            int minus = 0;

            if (spec == 1) {
                this.defense++;
                System.out.println("Monk's defense has been increased by 1.");
            }
            double damageTaken = damage - this.defense;

            if (damageTaken < 2) {
                damageTaken = 2;
            }

            if (generator.nextInt(101) <= 70) {
                minus = generator.nextInt((int)(damageTaken * 0.5)) + 1;
                damageTaken -= minus;
                System.out.println("Monk took " + minus + " less damage.");
            }

            if (damageTaken <= 2) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Monk lost " + (200 * 0.08) + " health.");
                this.health -= 200 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
                monkspec1 = false;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
                monkspec2 = false;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Monk is now free to use all his moves starting next turn.");
            }

            int damage = (generator.nextInt(2) + 10) / this.penalty;
            this.penalty = 1;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            double damage;

            if (currenturn == turn.ONE) {
                damage = (player2health) * 0.5;
            } else {
                damage = (player1health) * 0.5;
            }

            this.penalty = 2;

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = (int)damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = (int)damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 4;
                monkspec1 = true;
            } else {
                cooldown21 = 4;
                monkspec2 = true;
            }

            if (!this.hi) {
                this.health += regain;

                if (regain > 0) {
                    System.out.println("Monk regained " + this.regain + " health.");
                    if (currenturn == turn.ONE) {
                        player1health = this.health;
                    } else {
                        player2health = this.health;
                    }
                }
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            //not affected by status effects

            System.out.println("Monk's next swift attack will do halved damage.");
            target.takeDamage(damage, 0);
        }

        public void attack3() {
            regain += 8;

            if (regain > 32) {
                regain = 32;
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 3;
            } else {
                cooldown22 = 3;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("From now on Monk will regain " + this.regain + " health every time he uses Meditative Flurry!");
            turnend = true;
        }

        public void attack4(Character target) {
            target.defdown();
            target.bonusd();

            if (!this.bi) {
                this.du = true;
                System.out.println("Monk's opponent was inflicted with Defense Down and Bonus Damage, and Monk gained Defense Up.");
            } else {
                this.bi = false;
                System.out.println("Monk has Buff Immunity. Monk's opponent was inflicted with Defense Down and Bonus Damage.");
            }

            if (!this.hi) {
                this.health += 8;
                System.out.println("Monk also healed for 8 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Monk");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Swift Attack");
                    System.out.println("2. Meditative Flurry, " + cooldown11 + " cooldown");
                    System.out.println("3. Focused Meditation, " + cooldown12 + " cooldown");
                    System.out.println("4. Intensive Training, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Swift Attack");
                        System.out.println("2. Meditative Flurry, " + cooldown21 + " cooldown");
                        System.out.println("3. Focused Meditation, " + cooldown22 + " cooldown");
                        System.out.println("4. Intensive Training, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                moplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                moplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                moplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                moplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                moplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                moplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                moplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                moplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                moplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                moplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                moplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    moplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    moplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    moplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    moplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    moplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    moplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    moplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    moplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    moplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    moplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    moplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Meditative Flurry is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            moplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Focused Meditation is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    moplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    moplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    moplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    moplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    moplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    moplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    moplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    moplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    moplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    moplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    moplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Intensive Training is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Monk");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Swift Attack");
                    System.out.println("2. Meditative Flurry, " + cooldown21 + " cooldown");
                    System.out.println("3. Focused Meditation, " + cooldown22 + " cooldown");
                    System.out.println("4. Intensive Training, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Swift Attack");
                        System.out.println("2. Meditative Flurry, " + cooldown21 + " cooldown");
                        System.out.println("3. Focused Meditation, " + cooldown22 + " cooldown");
                        System.out.println("4. Intensive Training, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                moplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                moplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                moplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                moplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                moplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                moplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                moplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                moplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                moplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                moplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                moplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    moplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    moplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    moplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    moplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    moplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    moplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    moplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    moplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    moplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    moplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    moplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Meditative Flurry is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            moplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Focused Meditation is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    moplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    moplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    moplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    moplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    moplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    moplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    moplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    moplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    moplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    moplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    moplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Intensive Training is still on cooldown.");
                        } else {
                            System.out.println("Monk has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Mage extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int regain = 0;
        public int bonus = 0;
        public int gain = 3;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;
        public int hsteal = 0;

        public Mage(int health, int def) {
            super(170, 1);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Mage's defense has been increased by 1.");
            }

            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Mage lost " + (170 * 0.08) + " health.");
                this.health -= 170 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Mage is now free to use all his moves starting next turn.");
            }

            int reg = 0;
            int damage = generator.nextInt(3) + 13 + bonus;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.regain > 0) {
                reg = generator.nextInt(2) + gain;

                if (!this.hi) {
                    this.health += reg;
                    System.out.println("Mage regained " + reg + " health.");
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }

                this.regain--;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.15;

                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }

                System.out.println("Mage regained " + (damage * 0.15) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {

            int damage = 100 - generator.nextInt(11);
            this.regain = 2;

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 3;
            } else {
                cooldown21 = 3;
            }
            this.health -= 20;

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            System.out.println("Mage lost 20 health, but for the next 2 turns, Mage will regain " + this.gain + "-" + (this.gain + 1) + " health each turn!");

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.15;
                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }
                System.out.println("Mage regained " + (damage * 0.15) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);
        }

        public void attack3() {
            this.bonus += 3;
            int reg;

            if (this.gain > 6) {
                this.gain += 1;
                System.out.println("Mage will now regain 1 more health every time he uses Archmage Supreme, bringing it to a total of " + this.gain + "-" + (this.gain + 1) + " health regain!");
            } else {
                this.gain += 2;
                System.out.println("Mage will now regain 2 more health every time he uses Archmage Supreme, bringing it to a total of " + this.gain + " health regain!");
            }

            if (this.regain > 0) {
                reg = generator.nextInt(2) + gain;

                if (!this.hi) {
                    this.health += reg;
                    System.out.println("Mage regained " + reg + " health.");
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }

                this.regain--;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 3;
            } else {
                cooldown22 = 3;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;

            System.out.println("Mage will also do more 3 more damage on Dark Magic, bringing it to a total of " + (13 + this.bonus) + "-" + (15 + this.bonus) + " damage.");
            turnend = true;
        }

        public void attack4(Character target) {
            target.offdown();
            this.hsteal = 2;
            int reg;

            if (!this.bi) {
                this.ou = true;
                System.out.println("Mage's opponent was inflicted with Offense Down, and Mage gained Offense Up and 15% Health Steal for the next 2 turns.");
            } else {
                this.bi = false;
                System.out.println("Mage has Buff Immunity. Mage's opponent was inflicted with Offense Down and Mage gained 15% Health Steal for the next 2 turns");
            }

            if (this.regain > 0) {
                reg = generator.nextInt(2) + gain;

                if (!this.hi) {
                    this.health += reg;
                    System.out.println("Mage regained " + reg + " health.");
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }

                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }

                this.regain--;
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Mage");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Dark Magic");
                    System.out.println("2. Archmage Supreme, " + cooldown11 + " cooldown");
                    System.out.println("3. Dark Lord, " + cooldown12 + " cooldown");
                    System.out.println("4. Arcane Sorcerer, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Dark Magic");
                        System.out.println("2. Archmage Supreme, " + cooldown21 + " cooldown");
                        System.out.println("3. Dark Lord, " + cooldown22 + " cooldown");
                        System.out.println("4. Arcane Sorcerer, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                maplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                maplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                maplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                maplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                maplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                maplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                maplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                maplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                maplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                maplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                maplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    maplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    maplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    maplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    maplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    maplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    maplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    maplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    maplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    maplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    maplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    maplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Archmage Supreme is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            maplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Dark Lord is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    maplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    maplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    maplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    maplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    maplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    maplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    maplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    maplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    maplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    maplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    maplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Arcane Sorcerer is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Mage");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Dark Magic");
                    System.out.println("2. Archmage Supreme, " + cooldown21 + " cooldown");
                    System.out.println("3. Dark Lord, " + cooldown22 + " cooldown");
                    System.out.println("4. Arcane Sorcerer, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Dark Magic");
                        System.out.println("2. Archmage Supreme, " + cooldown21 + " cooldown");
                        System.out.println("3. Dark Lord, " + cooldown22 + " cooldown");
                        System.out.println("4. Arcane Sorcerer, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                maplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                maplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                maplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                maplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                maplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                maplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                maplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                maplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                maplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                maplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                maplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    maplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    maplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    maplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    maplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    maplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    maplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    maplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    maplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    maplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    maplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    maplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Archmage Supreme is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            maplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Dark Lord is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    maplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    maplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    maplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    maplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    maplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    maplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    maplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    maplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    maplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    maplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    maplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Arcane Sorcerer is still on cooldown.");
                        } else {
                            System.out.println("Mage has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Commander extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int bonus1 = 0;
        public int bonus2 = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Commander(int health, int def) {
            super(190, 2);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Commander's defense has been increased by 1.");
            }

            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Commander lost " + (200 * 0.08) + " health.");
                this.health -= 200 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            if (currenturn == turn.ONE && shield1 <= 0) {
                this.health -= (int)damage;
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else if (currenturn == turn.TWO && shield2 <= 0){
                this.health -= (int)damage;
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            } else if (currenturn == turn.ONE && shield1 > 0) {
                int temp = (int)damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
                this.health -= (int)damage;
                System.out.println("Player 1 was shielded and still has " + this.health + " health left.");
                player1health = this.health;
            } else if (currenturn == turn.TWO && shield2 > 0) {
                int temp = (int)damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
                this.health -= (int)damage;
                System.out.println("Player 2 was shielded and still has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            if (currenturn == turn.ONE && shield1 <= 0) {
                this.health -= (int)damage;
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else if (currenturn == turn.TWO && shield2 <= 0){
                this.health -= (int)damage;
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            } else if (currenturn == turn.ONE && shield1 > 0) {
                int temp = (int)damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
                this.health -= (int)damage;
                System.out.println("Player 1 was shielded and still has " + this.health + " health left.");
                player1health = this.health;
            } else if (currenturn == turn.TWO && shield2 > 0) {
                int temp = (int)damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
                this.health -= (int)damage;
                System.out.println("Player 2 was shielded and still has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Commander is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(2) + 16 + bonus1;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            boolean def = true;
            int damage = 40 + this.bonus2 - generator.nextInt(5);

            if (defense > 0) {
                defense--;
            } else {
                def = false;
                health -= 8;
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 6;
                shield1 = 50;
            } else {
                cooldown21 = 6;
                shield2 = 50;
            }

            System.out.println("Reinforcement has been summoned!");

            if (def) {
                System.out.println("Commander lost 1 defense.");
            } else {
                System.out.println("Commander lost 8 health.");
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack3() {
            this.bonus1 += 2;
            this.bonus2 += 5;
            this.defense += 1;
            System.out.println("Commander will now be able to do " + bonus1 + " more damage on Artillery Battery and " + bonus2 + " more damage on Summon Reinforcement, bringing it to a total of " + (16 + bonus1) + "-" + (17 + bonus1) + " damage on Artillery Battery and " + (36 + bonus2) + "-" + (40 + bonus2) + " damage on Summon Reinforcement.");
            System.out.println("Commander gained 1 defense.");

            if (!this.hi) {
                this.health += 6;
                System.out.println("Commander also healed for 6 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 3;
                player1health = this.health;
            } else {
                cooldown22 = 3;
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void attack4(Character target) {
            this.bi = false;
            this.ou = true;
            this.du = true;
            this.dd = false;
            this.od = false;
            this.bd = false;
            this.hi = false;
            System.out.println("Commander dispelled all debuffs on himself and gained Defense Up and Offense Up.");

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Commander");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Artillery Battery");
                    System.out.println("2. Summon Reinforcement, " + cooldown11 + " cooldown");
                    System.out.println("3. Promotion, " + cooldown12 + " cooldown");
                    System.out.println("4. General Of The Army, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Artillery Battery");
                        System.out.println("2. Summon Reinforcement, " + cooldown21 + " cooldown");
                        System.out.println("3. Promotion, " + cooldown22 + " cooldown");
                        System.out.println("4. General Of The Army, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                cplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                cplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                cplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                cplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                cplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                cplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                cplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                cplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                cplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                cplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                cplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    cplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    cplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    cplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    cplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    cplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    cplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    cplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    cplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    cplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    cplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    cplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Summon Reinforcement is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            cplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Promotion is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    cplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    cplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    cplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    cplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    cplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    cplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    cplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    cplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    cplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    cplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    cplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("General Of The Army is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Commander");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Artillery Battery");
                    System.out.println("2. Summon Reinforcement, " + cooldown21 + " cooldown");
                    System.out.println("3. Promotion, " + cooldown22 + " cooldown");
                    System.out.println("4. General Of The Army, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Artillery Battery");
                        System.out.println("2. Summon Reinforcement, " + cooldown21 + " cooldown");
                        System.out.println("3. Promotion, " + cooldown22 + " cooldown");
                        System.out.println("4. General Of The Army, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                cplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                cplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                cplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                cplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                cplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                cplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                cplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                cplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                cplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                cplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                cplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    cplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    cplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    cplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    cplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    cplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    cplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    cplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    cplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    cplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    cplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    cplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Summon Reinforcement is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            cplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Promotion is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    cplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    cplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    cplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    cplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    cplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    cplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    cplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    cplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    cplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    cplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    cplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("General Of The Army is still on cooldown.");
                        } else {
                            System.out.println("Commander has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Jedi extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public boolean force1 = false;
        public boolean force2 = false;
        public int resist = 0;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;
        public int hsteal = 0;

        public Jedi(int health, int def) {
            super(200, 4);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Jedi's defense has been increased by 1.");
            }

            double damageTaken = damage;
            damageTaken -= this.defense;
            damageTaken *= ((100 - this.resist) / 100.0);

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Jedi lost " + (200 * 0.08) + " health.");
                this.health -= 200 * 0.08;
            }

            if (currenturn == turn.ONE && player2reflect <= 0) {
                this.health -= damageTaken;
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else if (currenturn == turn.TWO && player1reflect <= 0) {
                this.health -= damageTaken;
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            } else if (currenturn == turn.ONE && player2reflect > 0) {
                player2reflect -= damageTaken;
                this.health -= (damageTaken * 0.3);
                System.out.println("Jedi has only taken " + damageTaken * 0.3 + " damage.");
                System.out.println("Jedi reflected " + damageTaken * 0.7 + " damage back to Player 1.");
                switch (player1char) {
                    case 1:
                        wplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 2:
                        aplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 3:
                        pplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 4:
                        tplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 5:
                        moplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 6:
                        maplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 7:
                        cplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 8:
                        jplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 9:
                        dplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 10:
                        drplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                    case 11:
                        kplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                }
                player2health = this.health;
                player2def = this.defense;
            } else if (currenturn == turn.TWO && player1reflect > 0) {
                player1reflect -= damageTaken;
                this.health -= (damageTaken * 0.3);
                System.out.println("Jedi has only taken " + damageTaken * 0.3 + " damage.");
                System.out.println("Jedi reflected " + damageTaken * 0.7 + " damage back to Player 2.");
                switch (player2char) {
                    case 1:
                        wplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 2://change
                        aplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 3:
                        pplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 4:
                        tplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 5:
                        moplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 6:
                        maplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 7:
                        cplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 8:
                        jplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 9:
                        dplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 10:
                        drplayer2.reflectdamage(damageTaken * 0.7);
                        break;
                    case 11:
                        kplayer1.reflectdamage(damageTaken * 0.7);
                        break;
                }
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Jedi is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 10;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.5;
                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }
                System.out.println("Jedi regained " + (damage * 0.5) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 30 - generator.nextInt(4);

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 6;
            } else {
                cooldown21 = 6;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (hsteal > 0) {
                hsteal--;
                this.health += damage * 0.5;
                if (currenturn == turn.ONE) {
                    player1health = this.health;
                } else {
                    player2health = this.health;
                }
                System.out.println("Jedi regained " + (damage * 0.5) + " health via Health Steal.");
            }

            target.takeDamage(damage, 0);

            if (currenturn == turn.ONE) {
                player2reflect = 35;
            } else {
                player1reflect = 35;
            }
        }

        public void attack3() {
            this.resist += 15;

            if (this.resist > 45) {
                this.resist = 45;

                if (!this.hi) {
                    this.health += 12;
                    System.out.println("Jedi healed for 12 health.");
                    if (currenturn == turn.ONE) {
                        player1health = this.health;
                    } else {
                        player2health = this.health;
                    }
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }

            } else {
                System.out.println("Jedi will now take 15% less damage from most attacks, bringing it to a total of " + this.resist + "% damage reduction!");
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 3;
            } else {
                cooldown22 = 3;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void attack4(Character target) {
            this.bi = false;
            this.du = true;
            this.dd = false;
            this.od = false;
            this.bd = false;
            this.hi = false;
            this.hsteal = 2;
            System.out.println("Jedi dispelled all debuffs on himself, gained Defense Up, and gained 50% Health Steal for the next 2 turns.");

            if (currenturn == turn.ONE) {
                cooldown13 = 5;
            } else {
                cooldown23 = 5;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Jedi");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (player1reflect > 0 || this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Lightsaber Attack");
                    System.out.println("2. Mind Tricks, " + cooldown11 + " cooldown");
                    System.out.println("3. Meditation Chambers, " + cooldown12 + " cooldown");
                    System.out.println("4. Jedi High Council, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Lightsaber Attack");
                        System.out.println("2. Mind Tricks, " + cooldown21 + " cooldown");
                        System.out.println("3. Meditation Chambers, " + cooldown22 + " cooldown");
                        System.out.println("4. Jedi High Council, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                jplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                jplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                jplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                jplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                jplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                jplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                jplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                jplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                jplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                jplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                jplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    jplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    jplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    jplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    jplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    jplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    jplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    jplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    jplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    jplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    jplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    jplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Mind Tricks is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            jplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Meditation Chambers is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    jplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    jplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    jplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    jplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    jplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    jplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    jplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    jplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    jplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    jplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    jplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Jedi High Council is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Jedi");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (player2reflect > 0 || this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi || this.hsteal > 0) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + this.hsteal + " more turn(s)");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Lightsaber Attack");
                    System.out.println("2. Mind Tricks, " + cooldown21 + " cooldown");
                    System.out.println("3. Meditation Chambers, " + cooldown22 + " cooldown");
                    System.out.println("4. Jedi High Council, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Lightsaber Attack");
                        System.out.println("2. Mind Tricks, " + cooldown21 + " cooldown");
                        System.out.println("3. Meditation Chambers, " + cooldown22 + " cooldown");
                        System.out.println("4. Jedi High Council, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                jplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                jplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                jplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                jplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                jplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                jplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                jplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                jplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                jplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                jplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                jplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    jplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    jplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    jplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    jplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    jplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    jplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    jplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    jplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    jplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    jplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    jplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Mind Tricks is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            jplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Meditation Chambers is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    jplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    jplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    jplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    jplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    jplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    jplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    jplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    jplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    jplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    jplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    jplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Jedi High Council is still on cooldown.");
                        } else {
                            System.out.println("Jedi has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Darkknight extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int chance = 40;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Darkknight(int health, int def) {
            super(250, 2);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Dark Knight's defense has been increased by 1.");
            }

            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Dark Knight lost " + (250 * 0.08) + " health.");
                this.health -= 250 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Dark Knight is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(4) + 11;

            if (generator.nextInt(101) <= chance) {
                damage += generator.nextInt(4) + 11;
                System.out.println("Bonus shock damage!");
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            this.health--;

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 45 - generator.nextInt(6);

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown21++;
                cooldown22++;
                cooldown23++;
                cooldown11 = 3;
            } else {
                cooldown11++;
                cooldown12++;
                cooldown13++;
                cooldown21 = 3;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            System.out.println("Dark Knight increased his opponent's cooldowns by 1.");
            target.takeDamage(damage, 0);
        }

        public void attack3() {

            if (this.defense > 10) {
                if (!this.hi) {
                    this.health += 4;
                    System.out.println("Dark Knight healed for 4 health.");
                } else {
                    this.hi = false;
                    System.out.println("Healing Immunity!");
                }
            } else {
                this.defense++;
                System.out.println("Dark Knight's defense was increased by 1.");
            }

            if (this.chance < 100) {
                this.chance += 20;
                System.out.println("Dark Knight's is now 20% more likely to inflict additional shock damage, bringing it to a total of " + this.chance + "% chance.");
            } else {
                if (currenturn == turn.ONE) {
                    cooldown11--;
                    cooldown13--;
                } else {
                    cooldown21--;
                    cooldown23--;
                }
                System.out.println("Dark Knight reduced all his other cooldowns by 1.");
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
                player1def = this.defense;
            } else {
                player2health= this.health;
                player2def = this.defense;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void attack4(Character target) {
            target.offdown();
            target.healim();
            target.dispelbuffs();
            target.abblock();
            System.out.println("Dark Knight's opponent was inflicted with Offense Down, Ability Block and Healing Immunity, and Dark Knight dispelled all buffs on his opponent.");

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Dark Knight");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Stealthy Attack");
                    System.out.println("2. Demoralizing Blow, " + cooldown11 + " cooldown");
                    System.out.println("3. Batman, " + cooldown12 + " cooldown");
                    System.out.println("4. Mission Impossible, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Stealthy Attack");
                        System.out.println("2. Demoralizing Blow, " + cooldown21 + " cooldown");
                        System.out.println("3. Batman, " + cooldown22 + " cooldown");
                        System.out.println("4. Mission Impossible, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                dplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                dplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                dplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                dplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                dplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                dplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                dplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                dplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                dplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                dplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                dplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    dplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    dplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    dplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    dplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    dplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    dplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    dplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    dplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    dplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    dplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    dplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Demoralizing Blow is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            dplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Batman is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    dplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    dplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    dplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    dplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    dplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    dplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    dplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    dplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    dplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    dplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    dplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Mission Impossible is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Dark Knight");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Stealthy Attack");
                    System.out.println("2. Demoralizing Blow, " + cooldown21 + " cooldown");
                    System.out.println("3. Batman, " + cooldown22 + " cooldown");
                    System.out.println("4. Mission Impossible, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Stealthy Attack");
                        System.out.println("2. Demoralizing Blow, " + cooldown21 + " cooldown");
                        System.out.println("3. Batman, " + cooldown22 + " cooldown");
                        System.out.println("4. Mission Impossible, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                dplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                dplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                dplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                dplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                dplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                dplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                dplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                dplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                dplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                dplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                dplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    dplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    dplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    dplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    dplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    dplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    dplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    dplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    dplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    dplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    dplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    dplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Demoralizing Blow is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            dplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Batman is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    dplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    dplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    dplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    dplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    dplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    dplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    dplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    dplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    dplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    dplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    dplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Mission Impossible is still on cooldown.");
                        } else {
                            System.out.println("Dark Knight has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Dragon extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int incr1 = 0;
        public int incr2 = 0;
        public int max1 = 13;
        public int max2 = 55;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Dragon(int health, int def) {
            super(280, 0);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Dragon's defense has been increased by 1.");
            }

            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Dragon lost " + (280 * 0.08) + " health.");
                this.health -= 280 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Dragon is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 12 + this.incr1;
            this.incr1 += 2;

            if (damage > this.max1) {
                damage = this.max1;
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = 50 + this.incr2 - generator.nextInt(6);
            this.incr2 += 15;

            if (damage > this.max2) {
                damage = this.max2;
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 3;
            } else {
                cooldown21 = 3;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            target.takeDamage(damage, 0);
        }

        public void attack3() {
            this.max1 += 2;
            this.max2 += 15;

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
            } else {
                cooldown22 = 2;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            System.out.println("Dragon will now be able to eventually do 2 more damage on Inferno Blast and 15 more damage on Magma Elemental for a total maximum damage output of " + this.max1 + " damage on Inferno Blast and " + this.max2 + " damage on Magma Elemental!");
            turnend = true;
        }

        public void attack4(Character target) {
            target.offdown();
            target.doubd();

            if (!this.bi) {
                this.doubled = true;
                System.out.println("Dragon's opponent was inflicted with Offense Down, and both players will do 50% more damage next turn.");
            } else {
                this.bi = false;
                System.out.println("Dragon has Buff Immunity. Dragon's opponent was inflicted with Offense Down but will do 50% more damage next turn.");
            }

            if (!this.hi) {
                this.health += 18;
                System.out.println("Dragon also healed for 18 health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown13 = 4;
            } else {
                cooldown23 = 4;
            }

            if (currenturn == turn.ONE) {
                player1health = this.health;
            } else {
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Dragon");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Inferno Blast");
                    System.out.println("2. Magma Elemental, " + cooldown11 + " cooldown");
                    System.out.println("3. How To Train Your Dragon, " + cooldown12 + " cooldown");
                    System.out.println("4. Play With Fire, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Inferno Blast");
                        System.out.println("2. Magma Elemental, " + cooldown21 + " cooldown");
                        System.out.println("3. How To Train Your Dragon, " + cooldown22 + " cooldown");
                        System.out.println("4. Play With Fire, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                drplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                drplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                drplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                drplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                drplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                drplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                drplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                drplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                drplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                drplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                drplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    drplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    drplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    drplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    drplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    drplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    drplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    drplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    drplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    drplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    drplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    drplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Magma Elemental is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            drplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("How To Train Your Dragon is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    drplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    drplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    drplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    drplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    drplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    drplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    drplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    drplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    drplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    drplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    drplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Play With Fire is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Dragon");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Inferno Blast");
                    System.out.println("2. Magma Elemental, " + cooldown21 + " cooldown");
                    System.out.println("3. How To Train Your Dragon, " + cooldown22 + " cooldown");
                    System.out.println("4. Play With Fire, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Inferno Blast");
                        System.out.println("2. Magma Elemental, " + cooldown21 + " cooldown");
                        System.out.println("3. How To Train Your Dragon, " + cooldown22 + " cooldown");
                        System.out.println("4. Play With Fire, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                drplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                drplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                drplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                drplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                drplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                drplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                drplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                drplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                drplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                drplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                drplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    drplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    drplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    drplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    drplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    drplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    drplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    drplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    drplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    drplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    drplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    drplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Magma Elemental is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            drplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("How To Train Your Dragon is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    drplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    drplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    drplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    drplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    drplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    drplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    drplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    drplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    drplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    drplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    drplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Play With Fire is still on cooldown.");
                        } else {
                            System.out.println("Dragon has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static class Kid extends Character {
        Random generator = new Random();
        public int health;
        public int defense;
        public int max = 80;
        public int counterchance = 100;
        public boolean abilityblock = false, dd = false, du = false, od = false, ou = false, bd = false, bi = false, hi = false, doubled = false;

        public Kid(int health, int def) {
            super(170, 1);
            this.defense = def;
            this.health = health;
        }

        public void abblock() {
            this.abilityblock = true;
        }

        public void defdown() {
            this.dd = true;
        }

        public void offdown() {
            this.od = true;
        }

        public void bonusd() {
            this.bd = true;
        }

        public void doubd() {
            this.doubled = true;
        }

        public void buffim() {
            this.bi = true;
        }

        public void healim() {
            this.hi = true;
        }

        public void dispelbuffs() {
            this.ou = false;
            this.du = false;
        }

        public void takeDamage(double damage, int spec) {

            if (spec == 1) {
                this.defense++;
                System.out.println("Kid's defense has been increased by 1.");
            }

            double damageTaken = damage - this.defense;

            if (damageTaken < 0) {
                damageTaken = 0;
            }

            if (currenturn == turn.ONE) {
                if (this.dd && !monkspec1) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            } else {
                if (this.dd && !monkspec2) {
                    this.dd = false;
                    damageTaken *= 1.3;
                }
            }

            if (currenturn == turn.ONE) {
                if (this.du && !monkspec1) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            } else {
                if (this.du && !monkspec2) {
                    this.du = false;
                    damageTaken *= 0.7;
                }
            }

            if (this.bd) {
                this.bd = false;
                System.out.println("Bonus damage was activated and Kid lost " + (170 * 0.08) + " health.");
                this.health -= 170 * 0.08;
            }

            this.health -= damageTaken;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 did " + damageTaken + " damage to Player 2.");
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
                player2def = this.defense;
            } else {
                System.out.println("Player 2 did " + damageTaken + " damage to Player 1.");
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
                player1def = this.defense;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }

            double counterdamage = (double) (generator.nextInt(3) + 7);

            if (this.health > 0 && generator.nextInt(100) < this.counterchance) {
                System.out.println("Kid counterattacked for " + counterdamage + " damage and gained " + damageTaken + "% counter chance for a total of " + (this.counterchance + damageTaken) + "% counter chance!");

                if (currenturn == turn.ONE) {
                    switch (player1char) {
                        case 1:
                            wplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 2:
                            aplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 3:
                            pplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 4:
                            tplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 5:
                            moplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 6:
                            maplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 7:
                            cplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 8:
                            jplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 9:
                            dplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 10:
                            drplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 11:
                            kplayer1.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                    }
                } else {
                    switch (player2char) {
                        case 1:
                            wplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 2:
                            aplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 3:
                            pplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 4:
                            tplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 5:
                            moplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 6:
                            maplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 7:
                            cplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 8:
                            jplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 9:
                            dplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 10:
                            drplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                        case 11:
                            kplayer2.counterattack(counterdamage);
                            this.counterchance += damageTaken;
                            break;
                    }
                }
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void reflectdamage(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void counterattack(double damage) {
            this.health -= (int)damage;

            if (currenturn == turn.ONE) {
                System.out.println("Player 1 has " + this.health + " health left.");
                player1health = this.health;
            } else {
                System.out.println("Player 2 has " + this.health + " health left.");
                player2health = this.health;
            }

            if (this.health <= 0) {
                currentstate = gamestate.GAMEOVER;
            }
        }

        public void attack1(Character target) {

            if (this.abilityblock) {
                this.abilityblock = false;
                System.out.println("Ability Block has expired! Kid is now free to use all his moves starting next turn.");
            }

            int damage = generator.nextInt(3) + 8;

            if (currenturn == turn.ONE && shield2 > 0) {
                int temp = damage;
                damage -= shield2;

                if (damage < 0) {
                    damage = 0;
                }

                shield2 -= temp;
            } else if (currenturn == turn.TWO && shield1 > 0) {
                int temp = damage;
                damage -= shield1;

                if (damage < 0) {
                    damage = 0;
                }

                shield1 -= temp;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            this.counterchance += damage;
            target.takeDamage(damage, 0);
        }

        public void attack2(Character target) {
            int damage = counterchance;

            if (damage > this.max) {
                damage = this.max;
            }

            if (currenturn == turn.ONE && shield2 > 0) {
                if (shield2 == 50) {
                    damage = 0;
                    shield2 = 0;
                } else {
                    int temp = damage;
                    damage -= shield2;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield2 -= temp;
                }
            } else if (currenturn == turn.TWO && shield1 > 0) {
                if (shield1 == 50) {
                    damage = 0;
                    shield1 = 0;
                } else {
                    int temp = damage;
                    damage -= shield1;

                    if (damage < 0) {
                        damage = 0;
                    }

                    shield1 -= temp;
                }
            }

            if (currenturn == turn.ONE) {
                cooldown11 = 4;
            } else {
                cooldown21 = 4;
            }

            if (this.od) {
                this.od = false;
                damage *= 0.7;
            }

            if (this.ou) {
                this.ou = false;
                damage *= 1.3;
            }

            if (this.doubled) {
                this.doubled = false;
                damage *= 1.5;
            }

            if (target.du) {
                this.counterchance -= damage * 0.7;
            } else if (target.dd) {
                this.counterchance -= damage * 1.3;
            } else {
                this.counterchance -= damage;
            }

            if (this.counterchance < 60) {
                this.counterchance = 60;
            }

            target.takeDamage(damage, 0);
        }

        public void attack3() {
            this.max += 20;
            System.out.println("Kid will now be able to do 20 more damage on Scream for a total maximum damage output of " + this.max + "!");

            if (!this.hi) {
                int heal = generator.nextInt(2) + 5;
                this.health += heal;
                System.out.println("Kid also healed for " + heal + " health.");
            } else {
                this.hi = false;
                System.out.println("Healing Immunity!");
            }

            if (currenturn == turn.ONE) {
                cooldown12 = 2;
                player1health = this.health;
            } else {
                cooldown22 = 2;
                player2health = this.health;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void attack4(Character target) {
            target.buffim();
            target.healim();
            target.abblock();

            if (this.od) {
                target.offdown();
            }

            if (this.dd) {
                target.defdown();
            }

            if (this.bd) {
                target.bonusd();
            }

            System.out.println("Kid's opponent was inflicted with Buff Immunity, Ability Block and Healing Immunity in addition to all of Kid's debuffs.");

            if (currenturn == turn.ONE) {
                cooldown13 = 5;
            } else {
                cooldown23 = 5;
            }

            if (currenturn == turn.ONE) {
                currenturn = turn.TWO;
            } else {
                currenturn = turn.ONE;
            }

            turnend = true;
        }

        public void askmove() {
            boolean valid = false;
            do {
                if (currenturn == turn.ONE) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("It is now player 1's turn: Kid. Kid has " + this.counterchance + "% counter chance and " + this.max + " maximum scream damage.");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (shield2 > 0 || player2reflect > 0 || wplayer2.ou || wplayer2.du || wplayer2.od || wplayer2.dd || wplayer2.bd || wplayer2.abilityblock || wplayer2.doubled || wplayer2.bi || wplayer2.hi || aplayer2.ou || aplayer2.du || aplayer2.od || aplayer2.dd || aplayer2.bd || aplayer2.abilityblock || aplayer2.doubled || aplayer2.bi || aplayer2.hi || pplayer2.ou || pplayer2.du || pplayer2.od || pplayer2.dd || pplayer2.bd || pplayer2.abilityblock || pplayer2.doubled || pplayer2.bi || pplayer2.hi || pplayer2.hsteal > 0 || tplayer2.ou || tplayer2.du || tplayer2.od || tplayer2.dd || tplayer2.bd || tplayer2.abilityblock || tplayer2.doubled || tplayer2.bi || tplayer2.hi || moplayer2.ou || moplayer2.du || moplayer2.od || moplayer2.dd || moplayer2.bd || moplayer2.abilityblock || moplayer2.doubled || moplayer2.bi || moplayer2.hi || maplayer2.ou || maplayer2.du || maplayer2.od || maplayer2.dd || maplayer2.bd || maplayer2.abilityblock || maplayer2.doubled || maplayer2.bi || maplayer2.hi || maplayer2.hsteal > 0 || cplayer2.ou || cplayer2.du || cplayer2.od || cplayer2.dd || cplayer2.bd || cplayer2.abilityblock || cplayer2.doubled || cplayer2.bi || cplayer2.hi || jplayer2.ou || jplayer2.du || jplayer2.od || jplayer2.dd || jplayer2.bd || jplayer2.abilityblock || jplayer2.doubled || jplayer2.bi || jplayer2.hi || jplayer2.hsteal > 0 || dplayer2.ou || dplayer2.du || dplayer2.od || dplayer2.dd || dplayer2.bd || dplayer2.abilityblock || dplayer2.doubled || dplayer2.bi || dplayer2.hi || drplayer2.ou || drplayer2.du || drplayer2.od || drplayer2.dd || drplayer2.bd || drplayer2.abilityblock || drplayer2.doubled || drplayer2.bi || drplayer2.hi || kplayer2.ou || kplayer2.du || kplayer2.od || kplayer2.dd || kplayer2.bd || kplayer2.abilityblock || kplayer2.doubled || kplayer2.bi || kplayer2.hi) {
                        if (wplayer2.ou || aplayer2.ou || pplayer2.ou || tplayer2.ou || moplayer2.ou || maplayer2.ou || cplayer2.ou || jplayer2.ou || dplayer2.ou || drplayer2.ou || kplayer2.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield2 > 0) {
                            System.out.print(", " + shield2 + " reinforcement");
                        }

                        if (player2reflect > 0) {
                            System.out.print(", " + player2reflect + " damage redirection");
                        }

                        if (wplayer2.du || aplayer2.du || pplayer2.du || tplayer2.du || moplayer2.du || maplayer2.du || cplayer2.du || jplayer2.du || dplayer2.du || drplayer2.du || kplayer2.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer2.hsteal + " more turn(s)");
                        }

                        if (jplayer2.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer2.hsteal + " more turn(s)");
                        }

                        if (maplayer2.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer2.hsteal + " more turn(s)");
                        }

                        if (wplayer2.od || aplayer2.od || pplayer2.od || tplayer2.od || moplayer2.od || maplayer2.od || cplayer2.od || jplayer2.od || dplayer2.od || drplayer2.od || kplayer2.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer2.dd || aplayer2.dd || pplayer2.dd || tplayer2.dd || moplayer2.dd || maplayer2.dd || cplayer2.dd || jplayer2.dd || dplayer2.dd || drplayer2.dd || kplayer2.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer2.bd || aplayer2.bd || pplayer2.bd || tplayer2.bd || moplayer2.bd || maplayer2.bd || cplayer2.bd || jplayer2.bd || dplayer2.bd || drplayer2.bd || kplayer2.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer2.abilityblock || aplayer2.abilityblock || pplayer2.abilityblock || tplayer2.abilityblock || moplayer2.abilityblock || maplayer2.abilityblock || cplayer2.abilityblock || jplayer2.abilityblock || dplayer2.abilityblock || drplayer2.abilityblock || kplayer2.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer2.doubled || aplayer2.doubled || pplayer2.doubled || tplayer2.doubled || moplayer2.doubled || maplayer2.doubled || cplayer2.doubled || jplayer2.doubled || dplayer2.doubled || drplayer2.doubled || kplayer2.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer2.bi || aplayer2.bi || pplayer2.bi || tplayer2.bi || moplayer2.bi || maplayer2.bi || cplayer2.bi || jplayer2.bi || dplayer2.bi || drplayer2.bi || kplayer2.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer2.hi || aplayer2.hi || pplayer2.hi || tplayer2.hi || moplayer2.hi || maplayer2.hi || cplayer2.hi || jplayer2.hi || dplayer2.hi || drplayer2.hi || kplayer2.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Beg For Attention");
                    System.out.println("2. Scream, " + cooldown11 + " cooldown");
                    System.out.println("3. Tantrum, " + cooldown12 + " cooldown");
                    System.out.println("4. Annoying Little Brat, " + cooldown13 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Beg For Attention");
                        System.out.println("2. Scream, " + cooldown21 + " cooldown");
                        System.out.println("3. Tantrum, " + cooldown22 + " cooldown");
                        System.out.println("4. Annoying Little Brat, " + cooldown13 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player2char) {
                            case 1:
                                kplayer1.attack1(wplayer2);
                                break;
                            case 2:
                                kplayer1.attack1(aplayer2);
                                break;
                            case 3:
                                kplayer1.attack1(pplayer2);
                                break;
                            case 4:
                                kplayer1.attack1(tplayer2);
                                break;
                            case 5:
                                kplayer1.attack1(moplayer2);
                                break;
                            case 6:
                                kplayer1.attack1(maplayer2);
                                break;
                            case 7:
                                kplayer1.attack1(cplayer2);
                                break;
                            case 8:
                                kplayer1.attack1(jplayer2);
                                break;
                            case 9:
                                kplayer1.attack1(dplayer2);
                                break;
                            case 10:
                                kplayer1.attack1(drplayer2);
                                break;
                            case 11:
                                kplayer1.attack1(kplayer2);
                                break;
                        }

                        if (cooldown11 > 0) {
                            cooldown11--;
                        }

                        if (cooldown12 > 0) {
                            cooldown12--;
                        }

                        if (cooldown13 > 0) {
                            cooldown13--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown11 == 0 && !this.abilityblock) {

                            switch (player2char) {
                                case 1:
                                    kplayer1.attack2(wplayer2);
                                    break;
                                case 2:
                                    kplayer1.attack2(aplayer2);
                                    break;
                                case 3:
                                    kplayer1.attack2(pplayer2);
                                    break;
                                case 4:
                                    kplayer1.attack2(tplayer2);
                                    break;
                                case 5:
                                    kplayer1.attack2(moplayer2);
                                    break;
                                case 6:
                                    kplayer1.attack2(maplayer2);
                                    break;
                                case 7:
                                    kplayer1.attack2(cplayer2);
                                    break;
                                case 8:
                                    kplayer1.attack2(jplayer2);
                                    break;
                                case 9:
                                    kplayer1.attack2(dplayer2);
                                    break;
                                case 10:
                                    kplayer1.attack2(drplayer2);
                                    break;
                                case 11:
                                    kplayer1.attack2(kplayer2);
                                    break;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                            valid = true;
                        } else if (cooldown11 > 0) {
                            System.out.println("Scream is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown12 == 0 && !this.abilityblock) {
                            kplayer1.attack3();
                            valid = true;

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown13 > 0) {
                                cooldown13--;
                            }

                        } else if (cooldown12 > 0) {
                            System.out.println("Tantrum is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown13 == 0 && !abilityblock) {
                            switch (player2char) {
                                case 1:
                                    kplayer1.attack4(wplayer2);
                                    break;
                                case 2:
                                    kplayer1.attack4(aplayer2);
                                    break;
                                case 3:
                                    kplayer1.attack4(pplayer2);
                                    break;
                                case 4:
                                    kplayer1.attack4(tplayer2);
                                    break;
                                case 5:
                                    kplayer1.attack4(moplayer2);
                                    break;
                                case 6:
                                    kplayer1.attack4(maplayer2);
                                    break;
                                case 7:
                                    kplayer1.attack4(cplayer2);
                                    break;
                                case 8:
                                    kplayer1.attack4(jplayer2);
                                    break;
                                case 9:
                                    kplayer1.attack4(dplayer2);
                                    break;
                                case 10:
                                    kplayer1.attack4(drplayer2);
                                    break;
                                case 11:
                                    kplayer1.attack4(kplayer2);
                                    break;
                            }

                            if (cooldown11 > 0) {
                                cooldown11--;
                            }

                            if (cooldown12 > 0) {
                                cooldown12--;
                            }

                            valid = true;
                        } else if (cooldown13 > 0) {
                            System.out.println("Annoying Little Brat is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                } else if (currenturn == turn.TWO) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("It is now player 2's turn: Kid. Kid has " + this.counterchance + "% counter chance and " + this.max + " maximum scream damage.");
                    System.out.println("Player 1 currently has " + player1health + " health and " + player1def + " defense.");
                    System.out.println("Player 2 currently has " + player2health + " health and " + player2def + " defense.");
                    System.out.print("Player 1");

                    if (shield1 > 0 || player1reflect > 0 || wplayer1.ou || wplayer1.du || wplayer1.od || wplayer1.dd || wplayer1.bd || wplayer1.abilityblock || wplayer1.doubled || wplayer1.bi || wplayer1.hi || aplayer1.ou || aplayer1.du || aplayer1.od || aplayer1.dd || aplayer1.bd || aplayer1.abilityblock || aplayer1.doubled || aplayer1.bi || aplayer1.hi || pplayer1.ou || pplayer1.du || pplayer1.od || pplayer1.dd || pplayer1.bd || pplayer1.abilityblock || pplayer1.doubled || pplayer1.bi || pplayer1.hi || pplayer1.hsteal > 0 || tplayer1.ou || tplayer1.du || tplayer1.od || tplayer1.dd || tplayer1.bd || tplayer1.abilityblock || tplayer1.doubled || tplayer1.bi || tplayer1.hi || moplayer1.ou || moplayer1.du || moplayer1.od || moplayer1.dd || moplayer1.bd || moplayer1.abilityblock || moplayer1.doubled || moplayer1.bi || moplayer1.hi || maplayer1.ou || maplayer1.du || maplayer1.od || maplayer1.dd || maplayer1.bd || maplayer1.abilityblock || maplayer1.doubled || maplayer1.bi || maplayer1.hi || maplayer1.hsteal > 0 || cplayer1.ou || cplayer1.du || cplayer1.od || cplayer1.dd || cplayer1.bd || cplayer1.abilityblock || cplayer1.doubled || cplayer1.bi || cplayer1.hi || jplayer1.ou || jplayer1.du || jplayer1.od || jplayer1.dd || jplayer1.bd || jplayer1.abilityblock || jplayer1.doubled || jplayer1.bi || jplayer1.hi || jplayer1.hsteal > 0 || dplayer1.ou || dplayer1.du || dplayer1.od || dplayer1.dd || dplayer1.bd || dplayer1.abilityblock || dplayer1.doubled || dplayer1.bi || dplayer1.hi || drplayer1.ou || drplayer1.du || drplayer1.od || drplayer1.dd || drplayer1.bd || drplayer1.abilityblock || drplayer1.doubled || drplayer1.bi || drplayer1.hi || kplayer1.ou || kplayer1.du || kplayer1.od || kplayer1.dd || kplayer1.bd || kplayer1.abilityblock || kplayer1.doubled || kplayer1.bi || kplayer1.hi) {
                        if (wplayer1.ou || aplayer1.ou || pplayer1.ou || tplayer1.ou || moplayer1.ou || maplayer1.ou || cplayer1.ou || jplayer1.ou || dplayer1.ou || drplayer1.ou || kplayer1.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (shield1 > 0) {
                            System.out.print(", " + shield1 + " reinforcement");
                        }

                        if (player1reflect > 0) {
                            System.out.print(", " + player1reflect + " damage redirection");
                        }

                        if (wplayer1.du || aplayer1.du || pplayer1.du || tplayer1.du || moplayer1.du || maplayer1.du || cplayer1.du || jplayer1.du || dplayer1.du || drplayer1.du || kplayer1.du) {
                            System.out.print(", Defense Up");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (maplayer1.hsteal > 0) {
                            System.out.print(", 15% Health Steal for " + maplayer1.hsteal + " more turn(s)");
                        }

                        if (pplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + pplayer1.hsteal + " more turn(s)");
                        }

                        if (jplayer1.hsteal > 0) {
                            System.out.print(", 50% Health Steal for " + jplayer1.hsteal + " more turn(s)");
                        }

                        if (wplayer1.od || aplayer1.od || pplayer1.od || tplayer1.od || moplayer1.od || maplayer1.od || cplayer1.od || jplayer1.od || dplayer1.od || drplayer1.od || kplayer1.od) {
                            System.out.print(", Offense Down");
                        }

                        if (wplayer1.dd || aplayer1.dd || pplayer1.dd || tplayer1.dd || moplayer1.dd || maplayer1.dd || cplayer1.dd || jplayer1.dd || dplayer1.dd || drplayer1.dd || kplayer1.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (wplayer1.bd || aplayer1.bd || pplayer1.bd || tplayer1.bd || moplayer1.bd || maplayer1.bd || cplayer1.bd || jplayer1.bd || dplayer1.bd || drplayer1.bd || kplayer1.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (wplayer1.abilityblock || aplayer1.abilityblock || pplayer1.abilityblock || tplayer1.abilityblock || moplayer1.abilityblock || maplayer1.abilityblock || cplayer1.abilityblock || jplayer1.abilityblock || dplayer1.abilityblock || drplayer1.abilityblock || kplayer1.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (wplayer1.doubled || aplayer1.doubled || pplayer1.doubled || tplayer1.doubled || moplayer1.doubled || maplayer1.doubled || cplayer1.doubled || jplayer1.doubled || dplayer1.doubled || drplayer1.doubled || kplayer1.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (wplayer1.bi || aplayer1.bi || pplayer1.bi || tplayer1.bi || moplayer1.bi || maplayer1.bi || cplayer1.bi || jplayer1.bi || dplayer1.bi || drplayer1.bi || kplayer1.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (wplayer1.hi || aplayer1.hi || pplayer1.hi || tplayer1.hi || moplayer1.hi || maplayer1.hi || cplayer1.hi || jplayer1.hi || dplayer1.hi || drplayer1.hi || kplayer1.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.print("Player 2");

                    if (this.ou || this.du || this.od || this.dd || this.bd || this.abilityblock || this.doubled || this.bi || this.hi) {
                        if (this.ou) {
                            System.out.print(", Offense Up");
                        }

                        if (this.du) {
                            System.out.print(", Defense Up");
                        }

                        if (this.od) {
                            System.out.print(", Offense Down");
                        }

                        if (this.dd) {
                            System.out.print(", Defense Down");
                        }

                        if (this.bd) {
                            System.out.print(", Bonus Damage");
                        }

                        if (this.abilityblock) {
                            System.out.print(", Ability Block");
                        }

                        if (this.doubled) {
                            System.out.print(", +50% damage");
                        }

                        if (this.bi) {
                            System.out.print(", Buff Immunity");
                        }

                        if (this.hi) {
                            System.out.print(", Healing Immunity");
                        }
                    } else {
                        System.out.print(" has no status effects.");
                    }

                    System.out.println("");
                    System.out.println("1. Beg For Attention");
                    System.out.println("2. Scream, " + cooldown21 + " cooldown");
                    System.out.println("3. Tantrum, " + cooldown22 + " cooldown");
                    System.out.println("4. Annoying Little Brat, " + cooldown23 + " cooldown");
                    System.out.println("0. Exit match");
                    choice = input.nextLine();

                    if (choice.equals("0")) {
                        System.out.println("Are you sure you want to exit the match? Press \"Y\" to exit, else choose your move.");
                        System.out.println("1. Beg For Attention");
                        System.out.println("2. Scream, " + cooldown21 + " cooldown");
                        System.out.println("3. Tantrum, " + cooldown22 + " cooldown");
                        System.out.println("4. Annoying Little Brat, " + cooldown23 + " cooldown");
                        choice = input.nextLine().toLowerCase();

                        if (choice.equals("y")) {
                            currentstate = gamestate.GAMEOVER;
                            quitgame = true;
                            turnend = true;
                            return;
                        }
                    }

                    if (choice.equals("1")) {

                        switch (player1char) {
                            case 1:
                                kplayer2.attack1(wplayer1);
                                break;
                            case 2:
                                kplayer2.attack1(aplayer1);
                                break;
                            case 3:
                                kplayer2.attack1(pplayer1);
                                break;
                            case 4:
                                kplayer2.attack1(tplayer1);
                                break;
                            case 5:
                                kplayer2.attack1(moplayer1);
                                break;
                            case 6:
                                kplayer2.attack1(maplayer1);
                                break;
                            case 7:
                                kplayer2.attack1(cplayer1);
                                break;
                            case 8:
                                kplayer2.attack1(jplayer1);
                                break;
                            case 9:
                                kplayer2.attack1(dplayer1);
                                break;
                            case 10:
                                kplayer2.attack1(drplayer1);
                                break;
                            case 11:
                                kplayer2.attack1(kplayer1);
                                break;
                        }

                        if (cooldown21 > 0) {
                            cooldown21--;
                        }

                        if (cooldown22 > 0) {
                            cooldown22--;
                        }

                        if (cooldown23 > 0) {
                            cooldown23--;
                        }

                        valid = true;
                    } else if (choice.equals("2")) {

                        if (cooldown21 == 0 && !this.abilityblock) {

                            switch (player1char) {
                                case 1:
                                    kplayer2.attack2(wplayer1);
                                    break;
                                case 2:
                                    kplayer2.attack2(aplayer1);
                                    break;
                                case 3:
                                    kplayer2.attack2(pplayer1);
                                    break;
                                case 4:
                                    kplayer2.attack2(tplayer1);
                                    break;
                                case 5:
                                    kplayer2.attack2(moplayer1);
                                    break;
                                case 6:
                                    kplayer2.attack2(maplayer1);
                                    break;
                                case 7:
                                    kplayer2.attack2(cplayer1);
                                    break;
                                case 8:
                                    kplayer2.attack2(jplayer1);
                                    break;
                                case 9:
                                    kplayer2.attack2(dplayer1);
                                    break;
                                case 10:
                                    kplayer2.attack2(drplayer1);
                                    break;
                                case 11:
                                    kplayer2.attack2(kplayer1);
                                    break;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                            valid = true;
                        } else if (cooldown21 > 0) {
                            System.out.println("Scream is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("3")) {

                        if (cooldown22 == 0 && !this.abilityblock) {
                            kplayer2.attack3();
                            valid = true;

                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown23 > 0) {
                                cooldown23--;
                            }

                        } else if (cooldown22 > 0) {
                            System.out.println("Tantrum is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else if (choice.equals("4")) {

                        if (cooldown23 == 0 && !this.abilityblock) {
                            switch (player1char) {
                                case 1:
                                    kplayer2.attack4(wplayer1);
                                    break;
                                case 2:
                                    kplayer2.attack4(aplayer1);
                                    break;
                                case 3:
                                    kplayer2.attack4(pplayer1);
                                    break;
                                case 4:
                                    kplayer2.attack4(tplayer1);
                                    break;
                                case 5:
                                    kplayer2.attack4(moplayer1);
                                    break;
                                case 6:
                                    kplayer2.attack4(maplayer1);
                                    break;
                                case 7:
                                    kplayer2.attack4(cplayer1);
                                    break;
                                case 8:
                                    kplayer2.attack4(jplayer1);
                                    break;
                                case 9:
                                    kplayer2.attack4(dplayer1);
                                    break;
                                case 10:
                                    kplayer2.attack4(drplayer1);
                                    break;
                                case 11:
                                    kplayer2.attack4(kplayer1);
                                    break;
                            }
                            if (cooldown21 > 0) {
                                cooldown21--;
                            }

                            if (cooldown22 > 0) {
                                cooldown22--;
                            }

                            valid = true;
                        } else if (cooldown23 > 0) {
                            System.out.println("Annoying Little Brat is still on cooldown.");
                        } else {
                            System.out.println("Kid has been Ability Blocked for this turn.");
                        }
                    } else {
                        System.out.println("That was not a valid response.");
                    }
                }
            } while (!valid);
        }
    }

    public static void replayreset() {
        redo = false;
        invalidreplay = false;
        boolean charchoicevalid = true;
        cooldown11 = 0;
        cooldown21 = 0;
        cooldown12 = 0;
        cooldown22 = 0;
        cooldown13 = 0;
        cooldown23 = 0;
        wplayer1.ou = false;
        wplayer1.du = false;
        wplayer1.od = false;
        wplayer1.dd = false;
        wplayer1.abilityblock = false;
        wplayer1.bd = false;
        wplayer1.bi = false;
        wplayer1.hi = false;
        wplayer1.doubled = false;
        wplayer2.ou = false;
        wplayer2.du = false;
        wplayer2.od = false;
        wplayer2.dd = false;
        wplayer2.abilityblock = false;
        wplayer2.bd = false;
        wplayer2.bi = false;
        wplayer2.hi = false;
        wplayer2.doubled = false;
        aplayer1.ou = false;
        aplayer1.du = false;
        aplayer1.od = false;
        aplayer1.dd = false;
        aplayer1.abilityblock = false;
        aplayer1.bd = false;
        aplayer1.bi = false;
        aplayer1.hi = false;
        aplayer1.doubled = false;
        aplayer2.ou = false;
        aplayer2.du = false;
        aplayer2.od = false;
        aplayer2.dd = false;
        aplayer2.abilityblock = false;
        aplayer2.bd = false;
        aplayer2.bi = false;
        aplayer2.hi = false;
        aplayer2.doubled = false;
        pplayer1.ou = false;
        pplayer1.du = false;
        pplayer1.od = false;
        pplayer1.dd = false;
        pplayer1.abilityblock = false;
        pplayer1.bd = false;
        pplayer1.bi = false;
        pplayer1.hi = false;
        pplayer1.doubled = false;
        pplayer1.hsteal = 0;
        pplayer2.ou = false;
        pplayer2.du = false;
        pplayer2.od = false;
        pplayer2.dd = false;
        pplayer2.abilityblock = false;
        pplayer2.bd = false;
        pplayer2.bi = false;
        pplayer2.hi = false;
        pplayer2.doubled = false;
        pplayer2.hsteal = 0;
        tplayer1.ou = false;
        tplayer1.du = false;
        tplayer1.od = false;
        tplayer1.dd = false;
        tplayer1.abilityblock = false;
        tplayer1.bd = false;
        tplayer1.bi = false;
        tplayer1.hi = false;
        tplayer1.doubled = false;
        tplayer2.ou = false;
        tplayer2.du = false;
        tplayer2.od = false;
        tplayer2.dd = false;
        tplayer2.abilityblock = false;
        tplayer2.bd = false;
        tplayer2.bi = false;
        tplayer2.hi = false;
        tplayer2.doubled = false;
        moplayer1.ou = false;
        moplayer1.du = false;
        moplayer1.od = false;
        moplayer1.dd = false;
        moplayer1.abilityblock = false;
        moplayer1.bd = false;
        moplayer1.bi = false;
        moplayer1.hi = false;
        moplayer1.doubled = false;
        moplayer2.ou = false;
        moplayer2.du = false;
        moplayer2.od = false;
        moplayer2.dd = false;
        moplayer2.abilityblock = false;
        moplayer2.bd = false;
        moplayer2.bi = false;
        moplayer2.hi = false;
        moplayer2.doubled = false;
        maplayer1.ou = false;
        maplayer1.du = false;
        maplayer1.od = false;
        maplayer1.dd = false;
        maplayer1.abilityblock = false;
        maplayer1.bd = false;
        maplayer1.bi = false;
        maplayer1.hi = false;
        maplayer1.doubled = false;
        maplayer1.hsteal = 0;
        maplayer2.ou = false;
        maplayer2.du = false;
        maplayer2.od = false;
        maplayer2.dd = false;
        maplayer2.abilityblock = false;
        maplayer2.bd = false;
        maplayer2.bi = false;
        maplayer2.hi = false;
        maplayer2.doubled = false;
        maplayer2.hsteal = 0;
        cplayer1.ou = false;
        cplayer1.du = false;
        cplayer1.od = false;
        cplayer1.dd = false;
        cplayer1.abilityblock = false;
        cplayer1.bd = false;
        cplayer1.bi = false;
        cplayer1.hi = false;
        cplayer1.doubled = false;
        cplayer2.ou = false;
        cplayer2.du = false;
        cplayer2.od = false;
        cplayer2.dd = false;
        cplayer2.abilityblock = false;
        cplayer2.bd = false;
        cplayer2.bi = false;
        cplayer2.hi = false;
        cplayer2.doubled = false;
        jplayer1.ou = false;
        jplayer1.du = false;
        jplayer1.od = false;
        jplayer1.dd = false;
        jplayer1.abilityblock = false;
        jplayer1.bd = false;
        jplayer1.bi = false;
        jplayer1.hi = false;
        jplayer1.doubled = false;
        jplayer1.hsteal = 0;
        jplayer2.ou = false;
        jplayer2.du = false;
        jplayer2.od = false;
        jplayer2.dd = false;
        jplayer2.abilityblock = false;
        jplayer2.bd = false;
        jplayer2.bi = false;
        jplayer2.hi = false;
        jplayer2.doubled = false;
        jplayer2.hsteal = 0;
        dplayer1.ou = false;
        dplayer1.du = false;
        dplayer1.od = false;
        dplayer1.dd = false;
        dplayer1.abilityblock = false;
        dplayer1.bd = false;
        dplayer1.bi = false;
        dplayer1.hi = false;
        dplayer1.doubled = false;
        dplayer2.ou = false;
        dplayer2.du = false;
        dplayer2.od = false;
        dplayer2.dd = false;
        dplayer2.abilityblock = false;
        dplayer2.bd = false;
        dplayer2.bi = false;
        dplayer2.hi = false;
        dplayer2.doubled = false;
        drplayer1.ou = false;
        drplayer1.du = false;
        drplayer1.od = false;
        drplayer1.dd = false;
        drplayer1.abilityblock = false;
        drplayer1.bd = false;
        drplayer1.bi = false;
        drplayer1.hi = false;
        drplayer1.doubled = false;
        drplayer2.ou = false;
        drplayer2.du = false;
        drplayer2.od = false;
        drplayer2.dd = false;
        drplayer2.abilityblock = false;
        drplayer2.bd = false;
        drplayer2.bi = false;
        drplayer2.hi = false;
        drplayer2.doubled = false;
        kplayer1.ou = false;
        kplayer1.du = false;
        kplayer1.od = false;
        kplayer1.dd = false;
        kplayer1.abilityblock = false;
        kplayer1.bd = false;
        kplayer1.bi = false;
        kplayer1.hi = false;
        kplayer1.doubled = false;
        kplayer2.ou = false;
        kplayer2.du = false;
        kplayer2.od = false;
        kplayer2.dd = false;
        kplayer2.abilityblock = false;
        kplayer2.bd = false;
        kplayer2.bi = false;
        kplayer2.hi = false;
        kplayer2.doubled = false;
        shield1 = 0;
        shield2 = 0;
        player1reflect = 0;
        player2reflect = 0;
        monkspec1 = false;
        monkspec2 = false;
    }
}