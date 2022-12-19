package user;
import java.util.ArrayList;

public class Population implements Cloneable {
           private ArrayList<Utilisateur> listPopulation;
           private int nb;

           public Population() {
                     listPopulation = new ArrayList<Utilisateur>();
           }
           
           public Population(Utilisateur ... pop) {
                     listPopulation = new ArrayList<Utilisateur>();
                     for (Utilisateur u: pop) {
                                listPopulation.add(u);
                                this.nb++;
                     };
           }
           
           public void setPopulation(ArrayList<Utilisateur> population) {this.listPopulation = population;}
           public ArrayList<Utilisateur> getListPopulation(){return this.listPopulation;}
           
           
           public int getNb() {
                     return nb;
           }

           public void setNb(int nb) {
                     this.nb = nb;
           }
           
           public void addUser(Utilisateur user) {
                     listPopulation.add(user);
                     this.nb++;
           }
           
           public double calculerEmpreinte() {
                     double impactTotal = 0;
                     for (Utilisateur u : listPopulation) {
                                impactTotal += u.calculerEmpreinte();
                                
                     }
                     return impactTotal;       
           }
           
           public double calculerEmpreinteAlim() {
                     double impactA = 0;
                     for (Utilisateur u : listPopulation) {
                                impactA += u.getAlimentation().getImpact();
                     }
                     return impactA;   
           }
           
           public double calculerEmpreinteLog() {
                     double impactL = 0;
                     for (Utilisateur u : listPopulation) {
                                impactL += u.getLogement().getImpact();
                     }
                     return impactL;    
           }
           
           public double calculerEmpreinteBienC() {
                     double impactB = 0;
                     for (Utilisateur u : listPopulation) {
                                impactB += u.getBienConso().getImpact();
                     }
                     return impactB;    
           }
           
           public double calculerEmpreinteMail() {
                     double impactM = 0;
                     for (Utilisateur u : listPopulation) {
                                impactM += u.getMail().getImpact();
                     }
                     return impactM;  
           }
           
           public double calculerEmpreinteTrans() {
                     double impactT= 0;
                     for (Utilisateur u : listPopulation) {
                                impactT += u.getTransport().getImpact();
                     }
                     return impactT;    
           }
           
           
           @Override
           public Object clone(){
                     try {
                                Population p = (Population) super.clone();
                                p.listPopulation = new ArrayList<Utilisateur>(this.listPopulation);
                                return p;
                     }
                     catch (CloneNotSupportedException e){
                                throw new InternalError();
                     }
           }
           
           public void conseilEmpreintePop( ) {
                       double cA = 2.353*this.nb;
                       double cL = 2.706*this.nb;
                       double cB = 2.625*this.nb;
                       double cM = 2.5*this.nb;
                       double cT = 2.920*this.nb;
                       
                       
                       if (this.calculerEmpreinteAlim()> cA) System.out.println("Nous vous conseillions d'essayer la simulation qui reduit les taux de repas aux boeufs, pour reduire l'impact alimentaite");
                       if (this.calculerEmpreinteBienC() > cB) System.out.println("Nous vous conseillions d'essayer la simulation qui diminue le montant des depenses de votre population");
                       if(this.calculerEmpreinteMail() > cM) System.out.println("Nous vous conseillions d'essayer la simulation qui simule la suppression de mail");
                       if (this.calculerEmpreinteLog()> cL) System.out.println("Nous vous conseillions d'essayer la simulation qui baisse d'une classe, la classe energetique pour chaque logement de vos utilisateur");
                       if (this.calculerEmpreinteTrans() > cT) System.out.println("Nous vous conseillions d'essayer la simulation qui fait baisser le nombre de voiture de certain de vos utilisateur");
             }
                     
}
