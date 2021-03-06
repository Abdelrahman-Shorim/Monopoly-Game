package monopolygame;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Game implements Serializable{
//    Scanner in=new Scanner(System.in);
    private static Player[] p=new Player[4];
    private static String[] filenames=new String[5];
    private static Object[] c=null;
    private newgame n=new newgame();

    public Game() throws IOException, FileNotFoundException, ClassNotFoundException {
        c=Game.loadProperty(c);
    }
    
    
    
    
//    public void buyMortage(Player p)
//    {
//        System.out.println("do you want to buy a mortaged property?");
//        String choice=in.next();
//        if(choice.equalsIgnoreCase("yes"))
//        {
//            for(int i=0;i<p.getNumOfProperties();i++)
//            {
//                if(p.getProperties(i).isIsmortaged())
//                    System.out.println(p.getProperties(i).getName()+"  ID:"+p.getProperties(i).getID());
//            }
//            System.out.println("enter id of property to buy");
//            int id=in.nextInt();
//            for(int i=0;i<p.getNumOfProperties();i++)
//            {
//                if(p.getProperties(i).getID()==id)
//                {
//                    p.getProperties(i).setIsmortaged(false);
//                    p.decrementBalance(p.getProperties(i).getPrice());
//                }
//            }
//        }
//    }
    
    
    public boolean canbuild(Player pl,Object[] pr) {
        return true;
//        Scanner in=new Scanner(System.in);
//        System.out.println("Choose the property u want to build in");
//        int choice=in.nextInt();
//        boolean canBuild=true;
//        if(choice<=21&&choice>=0)
//        {
//            for(int i=0;i<22;i++)
//            {
//                if(((Property)pr[choice]).getColor().equalsIgnoreCase(((Property)pr[i]).getColor()))
//                {
//                    if(((Property)pr[i]).getOwnerid()!=pl.getId())
//                        canBuild=false;
//                }                        
//            }
//
//            if(canBuild&&(pl.getBalance()>((Cities)pr[choice]).getHousesprice()))
//            {
//                System.out.println("u builded a new house");
//                ((Cities)pr[choice]).setHousecounter();
//                pl.decrementBalance(((Cities)pr[choice]).getHousesprice());
//            }
//            else
//                System.out.println("u can't build");
//        }
//        
//        else
//            System.out.println("u can only build in a city");
    }

    
    
    public static void savePlayer(Player[] p) throws FileNotFoundException, IOException
    {        
        String name="SavePlayers.bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(p);
        out.close();
    }
    public static Object[] loadProperty(Object[] c) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String name="SaveProperty.bin";
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
         c=(Object[])in.readObject();
         in.close();
         return c;
    }
    
    public static Player[] loadPlayer(Player[] p) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String name="SavePlayers.bin";
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
        p=(Player[])in.readObject();
        in.close();
        return p;
    }
    
    public static void saveProperty(Object[] c) throws FileNotFoundException, IOException
    {
        String name="SaveProperty.bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(c);
        out.close();
    }
    public void saveNewGame(String name) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String fileplayer="files\\"+name+"players.bin";
        String fileproperties="files\\"+name+"properties.bin";
        
        ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(fileplayer));
        out1.writeObject(p);
        out1.close();
        c=loadProperty(c);
        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(fileproperties));
        out2.writeObject(c);
        out2.close();
        
        
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileplayer));
        Player[] player1=new Player[4];
        player1=(Player[])in.readObject();
        //filenames[0]=name;
        System.out.println("file name: "+fileplayer);
        for(int i=0;i<player1.length;i++)
        {
            System.out.println("Player: "+player1[i].getName());
        }
        
        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(fileproperties));
        Object[] property1=new Object[4];
        property1=(Object[])in2.readObject();
        System.out.println(property1.length);
        //filenames[0]=name;
        System.out.println("file name: "+fileproperties);
        for(int i=0;i<property1.length;i++)
        {
            System.out.println("property: "+((Property)property1[i]).getName());
        }
        
        MonopolyGame.n.setVisible(false);
        new board(p,c,name);
        
        
    }
    public void loadgame(String name) throws FileNotFoundException, IOException, ClassNotFoundException
    {
//        File file=new File("\\oop\\monopoly\\Monopoly-Game\\MonopolyGame\\files");
//        File[] f=file.listFiles();
//        System.out.println("file names:");
//        for(int i=0;i<f.length;i++)
//        {
//            System.out.println(f[i]+"  ");
//        }
//        System.out.println("lolo");
//        for(int i=0;i<filenames.length;i++)
//        {
//            //System.out.println("nour");
//            if(name.equals(filenames[i]))
//            {
                //System.out.println("nour");
        String fileplayer="files\\"+name+"players.bin";
        String fileproperties="files\\"+name+"properties.bin";
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileplayer));
        p=(Player[])in.readObject();
        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(fileproperties));
        c=(Object[])in2.readObject();
//                Player[] player2=new Player[4];
//                player2=(Player[])in.readObject();
        System.out.println("player file name: "+fileplayer);
        for(int j=0;j<p.length;j++)
        {
            System.out.println("Player: "+p[j].getName());
        }
        System.out.println("property file name: "+fileproperties);
        for(int j=0;j<c.length;j++)
        {
            System.out.println("property: "+((Property)c[j]).getName());
        }
//            }
//        }
        
        MonopolyGame.l.setVisible(false);
        new board(p,c,name);
        
    }
    public void newgame(Player[] p,String name) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        this.p=p;
        saveNewGame(name);
    }
    
    public void returnPlayers()
    {
        for(int i=0;i<p.length;i++)
        {
            System.out.println("Player: "+p[i].getName());
        }
    }
    
    
    public static void saveAndExit(String name,Object[] property) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String fileplayer="files\\"+name+"players.bin";
        String fileproperties="files\\"+name+"properties.bin";
        
        ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(fileplayer));
        out1.writeObject(p);
        out1.close();
        //c=loadProperty(c);
        c=property;
        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(fileproperties));
        out2.writeObject(c);
        out2.close();
        
        
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileplayer));
        Player[] player1=new Player[4];
        player1=(Player[])in.readObject();
        //filenames[0]=name;
        System.out.println("file name: "+fileplayer);
        for(int i=0;i<player1.length;i++)
        {
            System.out.println("Player: "+player1[i].getCurrentLocation());
        }
        
        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(fileproperties));
        Object[] property1=new Object[4];
        property1=(Object[])in2.readObject();
        //System.out.println(property1.length);
        //filenames[0]=name;
        System.out.println("file name: "+fileproperties);
        for(int i=0;i<property1.length;i++)
        {
            System.out.println("property: "+((Property)property1[i]).getName());
        }
    }
}