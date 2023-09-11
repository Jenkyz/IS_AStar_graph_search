
package ai_project;

import java.util.ArrayList;

public class Graph {
    ArrayList<Vertex> vertexs;

    public Graph() {
    vertexs = new ArrayList<>();
    }

    void addvertex(Vertex x){
        vertexs.add(x);
    }
    
    void removevertex(Vertex x){
        vertexs.remove(x);
    }
    
    void printGraph(){
       
        for(Vertex x : vertexs){
            x.printAdj();
            System.out.println();
        }
        
    }
    void printDistances(){
        for(Vertex x : vertexs){
            for(Edge y : x.adjList){
                System.out.printf("- distance(%s,%s)= %d \n" , y.src.label , y.target.label , y.wight);
            }
        }
    }
    void printtable(){
        System.out.println("- The h(n) and f(n) for every state :");
        System.out.println("----------------------------------------");
        String State = "State" ;
        String h = "h(n)";
        String f = "f(n)";
        System.out.printf("|  %s  ||  %s  |  %s  |\n", State , h, f);
        for(Vertex x : vertexs){
            Vertex.setF(x);
        System.out.printf("|  %s  ||  %d  |  %d  |\n", x.label , x.h , x.f);
        }
        System.out.println("----------------------------------------");

    }
   
    
}