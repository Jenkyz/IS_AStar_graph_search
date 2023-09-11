
package ai_project;

import java.util.Scanner;

public class Edge{
    final static int DEFULT_WIGHT = 1;
    int wight;
    Vertex src;
    Vertex target;

    public Edge(Vertex src , Vertex target , int wight) {
        this.src = src;
        this.target = target;
        this.wight = wight;
    }

    public Edge(Vertex src , Vertex target ) {
        this.src = src;
        this.target = target;
        this.wight = DEFULT_WIGHT;
    }
    
    public void reqestDistance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("- distance("+src.label+","+target.label+")=  ");
        wight = sc.nextInt();
    }
 
}