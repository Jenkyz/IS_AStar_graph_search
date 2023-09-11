
package ai_project;

import java.util.ArrayList;

public class Vertex{
    
    int f;//estimates the total cost of the path from the start state through n to the goal state (f =g+h)
    int g = 0;//depth found in graph
    int h;//heuristic estimate of the distance from n to a goal
    String label;
    ArrayList<Edge> adjList;

    public Vertex(String label) {
        this.label=label;
        adjList = new ArrayList<>();
    }
    static void setF(Vertex x){
        x.f = x.h + x.g ;
    }
    void addEdge(Edge e){
        adjList.add(e);
    }
    
    void removeEdge(Edge e){
        adjList.remove(e);
    }
    
    void printAdj(){
        
        for(Edge x : adjList){
            System.out.print("From  "+x.src.label);
            System.out.println("--("+x.wight+")->"+x.target.label);
        }
        
    }
}
