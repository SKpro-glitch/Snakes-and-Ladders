import java.util.Scanner;
public class Games
{
    static String s, str = "", z; char a, b; static long l;
    static int i, box = 0; static char play = 'r';
    static char wrong[] = new char [8]; int w = 0;
    Scanner sc = new Scanner (System.in);

    void display(String y)
    {
        int j;
        for(i=0; i<20; i++)
            for(l=0; l<10000000; l++);
        System.out.print("\fWelcome ");
        for(i=0; i<20; i++)
            for(l=0; l<10000000; l++);
        System.out.print("to ");
        for(i=0; i<15; i++)
            for(l=0; l<10000000; l++);

        for(j=0; j<y.length(); j++)
        {
            for(i=0; i<5; i++)
                for(l=0; l<10000000; l++);
            System.out.print(y.charAt(j));
        }

        for(i=0; i<5; i++)
            for(l=0; l<10000000; l++);
        System.out.println("!!");
    }

    // HANGMAN
    void hanger(int ch)
    {
        if(ch==8)
        {
            System.out.println("\t _______");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==7)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==6)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==5)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |     |");
            System.out.println("\t |     |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==4)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |    /|");
            System.out.println("\t |     |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==3)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |    /|\\");
            System.out.println("\t |     |");
            System.out.println("\t |");
            System.out.println("\t |___________|");
        }

        else if(ch==2)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |    /|\\");
            System.out.println("\t |     |");
            System.out.println("\t |    /");
            System.out.println("\t |___________|");
        }

        else if(ch==1)
        {
            System.out.println("\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     O");
            System.out.println("\t |    /|\\");
            System.out.println("\t |     |");
            System.out.println("\t |    / \\");
            System.out.println("\t |___________|");
        }

        else if(ch==0)
        {
            System.out.println("\f\t _______");
            System.out.println("\t |     |");
            System.out.println("\t |     " + (char)216);
            System.out.println("\t |    /|\\");
            System.out.println("\t |     |");
            System.out.println("\t |    / \\");
            System.out.println("\t |___________|");
        }
    }

    void Rules_H() 
    {
        display("HANGMAN");
        for(i=0; i<35; i++)
            for(l=0; l<10000000; l++);

        System.out.println("\n Rules:\n- One player enters the word(s).\n- All vowels will be shown.\n- Other player(s) will guess each consonant.\n- After his/her chance, another player will give the word.\n- A guessing player loses his chance after 8 wrong guesses.");
        for(i=0; i<50; i++)
            for(l=0; l<10000000; l++);
    }

    void input()
    {
        System.out.print("\fWord provided by opponent: "); String y;
        do
        {
            y = sc.nextLine();
            if(y.length()>=1)
                s = y;
        }
        while(!(y.length()>=1));
        s = s.toUpperCase();
        System.out.println("\f");
    }

    void FW()
    {
        for(i=0; i<s.length(); i++)
        {
            a = s.charAt(i);
            if(a=='A'||a=='E'||a=='I'||a=='O'||a=='U'||a==' ')
                str = str + a;
            else
                str = str + "_";
        }
        z = str;
    }

    boolean word_n_chance()
    {
        String x = ""; boolean f = false;
        for(i=0; i<s.length(); i++)
        {
            a = s.charAt(i);
            if(a==b)
            {
                f = true; x = x + b;
            }
            else if(a=='A'||a=='E'||a=='I'||a=='O'||a=='U'||a==' '||a==z.charAt(i))
            { 
                x = x + a; 
            }
            else
                x = x + "_";
        }
        
        if(b=='A'||b=='E'||b=='I'||b=='O'||b=='U'||b==' ')
            f = true;
        if(!f)
            if(!Wrong())
                wrong[w++] = b;
            else
                f = true;
        str = x;
        z = str;

        return(f);
    }

    void Char()
    {
        System.out.println("\n\nEnter your guess: "); String y;
        do
        {
            y = sc.next();
            if(y.length()>=1)
                b = y.charAt(0);
        }
        while(!(y.length()>=1));
        b = Character.toUpperCase(b);
    }

    boolean Wrong()
    {
        boolean f = false;
        for(i=0; i<8; i++)
            if(b==wrong[i])
            {   f = true; break; }
        return f;
    }

    void hangman()
    {
        str = ""; z = ""; w = 0;
        Rules_H();
        wrong = new char [8];
        System.out.println("\nPress 'P' & 'Enter' to begin game.");
        String x = sc.next();
        input(); FW();
        boolean chance = false;
        int ch = 8;
        while(ch>0 && !(s.equalsIgnoreCase(str)))
        {
            System.out.println("\fHANGMAN");
            hanger(ch);
            System.out.print("\nWord: ");
            for(i=0; i<str.length(); i++)
                System.out.print(str.charAt(i) + " ");
            System.out.println("\n\nChances left: " + ch);

            System.out.print("\nWrong letters entered:");
            for(i=0; i<7; i++)
                System.out.print(" " + wrong[i]);

            Char();
            chance = word_n_chance();
            if(!chance)
                ch--;
        }

        System.out.println("\fHANGMAN");
        hanger(ch);
        System.out.println("\n\nChances left: " + ch);
        if(ch>0)
            System.out.println("Congratulations!!\nYou got the word right.\nWell played.");
        else
            System.out.println("Oops! You're dead.\nBetter luck next time :)");
        System.out.println("The word was " + s);
    }

    // SNAKES AND LADDERS
    void Rules_S() 
    {
        display("SNAKES AND LADDERS");

        for(i=0; i<20; i++)
            for(l=0; l<10000000; l++);

        System.out.println("\n Rules:\n- 1 to 4 player game. *1 player game means Player vs. Computer.\n- Each player must enter a name. * Names will not be saved after the game is over.\n- A player starts moving on the board only after rolling a 6.\n- Every time a player rolls a 6, he/she must roll again.\n- If a player encounters a snake bite, he will go back to its tail.\n- If a player encounters a ladder, he will go up the ladder.\n- The first player to reach box 100 wins.");
        for(i=0; i<50; i++)
            for(l=0; l<10000000; l++);
    }

    int dice()
    {
        int n = (int) Math.round(Math.random() * 5 + 1);
        n = (int) Math.round(Math.random() * 5 + 1);
        return((int) Math.round(Math.random() * 5 + 1));
    }

    void chance(int n, char p)
    {
        int x = box + n; String y;
        if(p=='p')
            y = "You ";
        else
            y = "Computer ";

        if(n!=6)
        {
            switch(x)
            {
                case 4:  System.out.println(y + "got a ladder at " + x + "!! "); x = 14; break;
                case 9:  System.out.println(y + "got a ladder at " + x + "!! "); x = 31; break;
                case 17: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 7; break;
                case 20: System.out.println(y + "got a ladder at " + x + "!! "); x = 38; break;
                case 28: System.out.println(y + "got a ladder at " + x + "!! "); x = 84; break;
                case 40: System.out.println(y + "got a ladder at " + x + "!! "); x = 59; break;
                case 62: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 34; break;
                case 71: System.out.println(y + "got a ladder at " + x + "!! "); x = 91; break;
                case 87: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 24; break;
                case 93: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 63; break;
                case 94: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 70; break;
                case 98: System.out.println(y + "got bit by a snake at " + x + "!! "); x = 81; break; 
            }
        }
        box = x;
    }

    void table()
    {
        System.out.println("\n\t     LADDERS(#)\t\t\t\t\t      SNAKES($)");
        System.out.println("\t From:\t\tTo:\t\t\t\t  From:\t\tTo:");
        System.out.println("\t  4\t\t14\t\t\t\t   17\t\t 7");
        System.out.println("\t  9\t\t31\t\t\t\t   62\t\t34");
        System.out.println("\t  20\t\t38\t\t\t\t   87\t\t24");
        System.out.println("\t  28\t\t84\t\t\t\t   93\t\t63");
        System.out.println("\t  40\t\t59\t\t\t\t   94\t\t70");
        System.out.println("\t  71\t\t91\t\t\t\t   98\t\t81");
    }

    char SorL(int x)
    {
        char SL = '\u0000';
        switch(x)
        {
            case 4: case 9: case 20: case 28: case 40: case 71: SL = '#'; break;
            case 17: case 62: case 87: case 93: case 94: case 98: SL = '$'; break;
        }
        return(SL);
    }

    void board(int p[], char bead[])
    {
        int j; int board[] = {91,92,93,94,95,96,97,98,99,100};
        for(int k=10; k>0; k--)
        {
            System.out.print("\n\t");
            if(k%2==1)
                for(i=0; i<10; i++)
                {
                    System.out.print(board[i]);
                    System.out.print(SorL(board[i]));
                    System.out.print(" ");
                    for(j=0; j<p.length; j++)
                        if(p[j]==board[i])
                            System.out.print(bead[j]);
                    System.out.print("\t");
            }
            else
                for(i=9; i>=0; i--)
                {
                    System.out.print(board[i]);
                    System.out.print(SorL(board[i]));
                    System.out.print(" ");
                    for(j=0; j<p.length; j++)
                        if(p[j]==board[i])
                            System.out.print(bead[j]);
                    System.out.print("\t");
            }
            for(i=0; i<10; i++)
                board[i] -= 10;
        }
    }

    void PvC()//Player vs Computer
    {
        int n = 0, b = 0, sixp  = 0, sixc = 0;
        int p[] = new int [2]; char bead[] = new char [2];
        boolean ps = false, cs = false; bead[1] = (char)162;
        System.out.print("\fEnter your name, Player : ");
        String name, y;
        do
        {
            name = sc.nextLine().trim().toUpperCase();
        }while(name.length()<1);

        do
        {
            System.out.print("\nChoose your bead:  " );
            System.out.println("1. " + (char)164 + "  2. " + (char)167 + "  3. " + (char)42 + "  4. " + (char)230);
            b = sc.nextInt();
            switch(b)
            {
                case 1: bead[0] = (char)164; break;
                case 2: bead[0] = (char)167; break;
                case 3: bead[0] = (char)169; break;
                case 4: bead[0] = (char)230; break;
                default: System.out.println("Invalid input.");
            }
        }while(b<1 || b>4);
        y = sc.nextLine();
        System.out.println("\nLoading....");

        for(i=0; i<15; i++)
            for(l=0; l<10000000; l++);

        while(box<100)
        {
            //Player's chance
            do
            {
                System.out.println("\f\t\t\t\tSNAKES AND LADDERS");
                System.out.println("\t\tBeads: " + name + "- " + bead[0] + "    Computer- " + bead[1]);
                System.out.println("\t\tBoxes: " + name + ": " + p[0] + "    Computer: " + p[1]);

                table();
                board(p,bead);
                System.out.print("\n\n" + name + "'s chance:");
                System.out.print("\nTo restart the game, press 'R' and 'Enter'.\nTo quit the game, press 'Q' and 'Enter'.\nPress 'D' and 'Enter' to play dice-- ");
                do
                {
                    y = sc.next();
                    if(y.length()>=1)
                        play = y.charAt(0);
                }while(y.length()<1);

                if(play=='q' || play=='Q' || play=='r' || play=='R')
                {
                    box = 101; 
                    break; 
                }

                n = dice();
                if(sixp==3)
                {
                    n = 6;
                    sixp = 0;
                }
                if(p[0]>=90 && n==6)
                    n = (int) Math.round(Math.random() * 4 + 1);
                for(i=0; i<n; i++)
                {
                    for(int j=0; j<20; j++)
                        for(l=0; l<10000000; l++);
                    System.out.print(". ");
                }
                if(ps==true)
                {
                    if(p[0]+n>100)
                    {
                        System.out.println("You have rolled a number greater than what you need!");
                        break;
                    }

                    if(n==6)
                        System.out.println("Congratulations! You rolled a 6! Play again.");
                    else
                        System.out.println("You rolled a " + n);
                    box = p[0];
                    chance(n,'p');
                    p[0] = box;
                }
                else
                {
                    if(n==6)
                    {
                        ps = true;
                        System.out.println("Congratulations! You rolled a 6! You have started moving.");
                    }
                    else
                    {
                        System.out.println("You rolled a " + n + ". Not a 6! Not a start.");
                        sixp++;
                    }
                }
                for(i=0; i<100; i++)
                    for(l=0; l<10000000; l++);
            }while(n==6);

            if(p[0]==100)
            {
                System.out.println("Congratulations " + name + "!! You have won the Game :):):)");
                break;
            }

            if(play=='q' || play=='Q' || play=='r' || play=='R') 
                break;

            //Computer's chance
            do
            {
                System.out.println("\f\t\t\t\tSNAKES AND LADDERS");
                System.out.println("\t\tBeads: " + name + "- " + bead[0] + "    Computer- " + bead[1]);
                System.out.println("\t\tBoxes: " + name + ": " + p[0] + "     Computer: " + p[1]);
                table();
                board(p,bead);
                System.out.println("\n\nComputer's chance: ");
                for(i=0; i<30; i++)
                    for(l=0; l<10000000; l++);

                n = dice();
                if(sixc==4)
                {
                    n = 6;
                    sixc = 0;
                }
                if(p[1]>=90 && n==6)
                    n = (int) Math.round(Math.random() * 4 + 1);
                for(i=0; i<n; i++)
                {
                    for(int j=0; j<20; j++)
                        for(l=0; l<10000000; l++);
                    System.out.print(". ");
                }
                if(cs==true)
                {
                    if(p[1]+n>100)
                    {
                        System.out.println("Computer has rolled a number greater than what it needs!");
                        break;
                    }

                    if(n==6)
                        System.out.println("Computer rolled a 6! Computer plays again.");
                    else
                        System.out.println("Computer rolled a " + n);
                    box = p[1];
                    chance(n,'c');
                    p[1] = box;
                }
                else
                {
                    if(n==6)
                    {
                        cs = true;
                        System.out.println("Computer rolled a 6! Computer has started moving.");
                    }
                    else
                    {
                        System.out.println("Computer rolled a " + n + ". Not a 6! Not a start.");
                        sixc++;
                    }
                }
                for(i=0; i<100; i++)
                    for(l=0; l<10000000; l++);
            }while(n==6);

            if(p[1]==100)
                System.out.println("Oops! Computer won the game. :(:(:(\nBetter luck next time.");
        }
    }

    void PvP(int pl)//Player vs Player
    {
        int p[] = new int [pl]; int k = 3;
        String name[] = new String [pl];
        boolean start[] = new boolean [pl];
        char beads[] = {(char)164, (char)167, (char)42, (char)230};
        char bead[] = new char[pl];
        int six[] = new int [pl];
        String y;
        box = 0;
        for(i=0; i<pl; i++)
        {
            System.out.print("\fEnter your name, Player " + (i + 1) + ": ");
            do
            {
                name[i] = sc.nextLine().trim().toUpperCase(); 
            }while(name[i].length()<1);
            if(i<3)
            {
                System.out.print("\nChoose your bead: ");
                for(l=0; l<4; l++)
                    if(beads[(int)l]!='\u0000')
                        System.out.print("  " + (l+1) + ". " + beads[(int)l]);
                System.out.println();
                int b = sc.nextInt() - 1;
                bead[i] = beads[b];
                for(l=0; l<3; l++)
                    if(l >= b)
                        beads[(int)l] = beads[(int)l+1];
                beads[k--] = '\u0000';
                y = sc.nextLine();
            }
        }

        if(pl==4)
            bead[pl-1] = beads[0];
        System.out.println("\nLoading...");
        //Game begins.
        for(i=0; i<15; i++)
            for(l=0; l<10000000; l++);
        int n = 0, t = 0;

        while(box<100)
        {
            for(t=0; t<pl; t++)
            {
                System.out.println("\f\t\t\tSNAKES AND LADDERS");
                System.out.print("\t\tBeads: ");
                for(i=0; i<pl; i++)
                    System.out.print(name[i] + "- " + bead[i] + "      ");
                System.out.print("\n\t\tBoxes: ");
                for(i=0; i<pl; i++)
                    System.out.print(name[i] + "- " + p[i] + "      ");
                table();
                board(p,bead);
                System.out.print("\n\n" + name[t] + "'s chance :");
                System.out.print("\nTo restart the game, press 'R' and 'Enter'.\nTo quit the game, press 'Q' and 'Enter'.\nPress 'D' and 'Enter' to play dice-- ");
                do
                {
                    y = sc.nextLine();
                    if(y.length()>=1)
                        play = y.charAt(0); 
                }while(y.length()>1);
                if(play=='q' || play=='Q' || play=='r' || play=='R')
                {
                    box = 101; 
                    break; 
                }
                n = dice();
                if(six[t]==3)
                {
                    n = 6;
                    six[t] = 0;
                }
                if(p[t]>=90 && n==6)
                    n = (int) Math.round(Math.random() * 4 + 1);
                for(i=0; i<n; i++)
                {
                    for(int j=0; j<100; j++)
                        for(l=0; l<10000000; l++);
                    System.out.print(". ");
                }
                if(start[t]==true)
                {
                    if(p[t]+n>100)
                    { 
                        System.out.println("You have rolled a number greater than what you need!");
                        continue;
                    }

                    if(n==6)
                        System.out.println("Congratulations! You rolled a 6! Play again.");
                    else
                        System.out.println("You rolled a " + n);
                    box = p[t];
                    chance(n,'p');
                    p[t] = box;
                }
                else
                {
                    if(n==6)    
                    {
                        start[t] = true;
                        System.out.println("Congratulations! You rolled a 6! You have started moving.");
                    }
                    else
                    {
                        System.out.println("You rolled a " + n + ". Not a 6! Not a start. Better luck for your next chance!");
                        six[t] += 1;
                    }
                }

                if(box==100)
                    break;

                if(n==6)
                    t--;

                for(i=0; i<500; i++)
                    for(l=0; l<10000000; l++);
            }
        }
        //Game ends.
        if(box==100)
            System.out.println("Congratulations " + name[t] + "!! You have won the game.  :):):):)");
    }

    void S_n_L()
    {
        Scanner sc = new Scanner (System.in);
        Rules_S(); int pl = 1; box = 0;

        do
        {
            if(pl<1 || pl>4)
                System.out.print("\fInvalid input.");
            System.out.println("\nPlease enter the number of players from 1 to 4:");
            pl = sc.nextInt();
        }while(pl<1 || pl>4);

        if(pl==1) //Player vs Computer
            PvC();
        else //Multi-player
            PvP(pl);
    }

    static void play()
    {
        Scanner in = new Scanner (System.in);
        Games ob = new Games();

        ob.display("DIGI-GAMING");
        for(i=0; i<25; i++)
            for(l=0; l<10000000; l++);
        int a = 0, x = 0;

        do
        {
            System.out.println("\f\t\tDIGI-GAMING\n\nHOME\n\nWhat do you want to do?\n(Press the serial number and Enter.)\n1. Play Snakes and Ladders\n2. Play Hangman\n3. Quit Menu");
            x = in.nextInt();
            do
            {
                a = 0;
                switch(x)
                {
                    case 1: 
                    while(play=='r' || play=='R') 
                        ob.S_n_L();  
                    break;

                    case 2: ob.hangman(); break;

                    case 3: System.out.println("\nThank you for playing!! BYE!! :):):)"); break;

                    default: System.out.println("\fInvalid input. Please choose again.");
                }

                if(x==1 || x==2)
                {
                    String y = in.nextLine();

                    System.out.println("\nThank you for playing!!  :):):)");
                    while(a!=1 && a!=2)
                    {
                        System.out.println("Please make a choice");
                        System.out.println("1. Play again.\n2. Go back to HOME page.");
                        a = in.nextInt();
                        if(a!=1 && a!=2)
                        {
                            System.out.println("\fInvalid input.");
                            for(i=0; i<20; i++)
                                for(l=0; l<10000000; l++);
                            break;
                        }
                    }
                }

                if((a!=1 && a!=2)|| x==3)
                    break;
            }while(!(x>0 && x<3) || a==1);
            if(x==3)
                break;
        }while(a==2);
    }
} 