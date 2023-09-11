
package ai_project;
import java.util.*;
public class AI_Project {

  
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int select;

        while (true) {

            System.out.print("1- Using Tree_A?\n");
            System.out.print("2- Using Graph_B?\n");
            System.out.print("3- Ending the application?\n");
            System.out.print("Your choice: ");
            select = sc.nextInt();

            if (select == 1) {
                Tree_FS T = new Tree_FS();
                T.Tree_search();

            }else if(select == 2){
                secendMenu();

            }else{
                
                System.out.println("Ending the application : GOOD BYE ");
                break;
            }

        }       
    }
    
   static void secendMenu(){
       while(true){
        System.out.println("1- Using A* algorithm with Graph_B");
        System.out.println("2- Displaying the main menu?");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);   
        int option = sc.nextInt();
       
        if(option == 1){
        Graph graphb = new Graph();
            
        Vertex S = new Vertex("S");
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex C = new Vertex("C");
        Vertex G = new Vertex("G");
        
        Edge SA = new Edge(S, A);
        Edge SG = new Edge(S, G);
        Edge AC = new Edge(A, C);
        Edge AB = new Edge(A, B);
        Edge BD = new Edge(B, D);
        Edge CD = new Edge(C, D);
        Edge CG = new Edge(C, G);
        Edge DG = new Edge(D, G);
        
        graphb.addvertex(S);
        graphb.addvertex(A);
        graphb.addvertex(B);
        graphb.addvertex(D);
        graphb.addvertex(C);
        graphb.addvertex(G);
        
        System.out.println("- Please, enter the following information:");
        SA.reqestDistance();
        SG.reqestDistance();
        AC.reqestDistance();
        AB.reqestDistance();
        BD.reqestDistance();
        CD.reqestDistance();
        CG.reqestDistance();
        DG.reqestDistance();
        
        for(Vertex x : graphb.vertexs){
            System.out.print("- h("+x.label+")=");
            x.h=sc.nextInt();
        }
        
        AStar star = new AStar(S, G);
        star.PrintAstarStart();
        graphb.printDistances();
        graphb.printtable();
        star.Start();

        }else{
          break;
    }
    }
}
}
   









