package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
   public static void main(String[] args) throws Exception{

    Scanner scan=new Scanner(new File("config.txt"));
    String daoClassename=scan.nextLine();
    Class cDao=Class.forName(daoClassename);
    IDao dao=(IDao) cDao.newInstance();
    System.out.println(dao.getData());


       String metierClassename=scan.nextLine();
       Class cMetier=Class.forName(metierClassename);
       IMetier metier=(IMetier) cMetier.newInstance();
       Method method=cMetier.getMethod("setDao",IDao.class);
       method.invoke(metier,dao);
       System.out.println("resultat==>" +metier.calcul());

   }
}
