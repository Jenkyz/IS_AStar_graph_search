package ai_project;

import java.util.ArrayList;

public class AStar extends Graph{
    
    float timeElapsed;
    Vertex Start;
    Vertex Goal;
    ArrayList<Vertex> Open;
    ArrayList<Vertex> Closed;
    Vertex x;
    int newG = 0;
    boolean done;

    public AStar(Vertex Start , Vertex Goal) {
    
        this.Start = Start;
        this.Goal = Goal;
        Open = new ArrayList<>();
       
        Closed = new ArrayList<>();
        
        
    }
    void Start(){
         Open.add(Start);
        float start = System.currentTimeMillis();
        
        while(!done){
            sortOpen();
            x = Open.get(0);
            printXOpenClose(x);
            Closed.add(x);
            Open.remove(x);
            
            if(isGoal()){
                printPathCost(x);
                done = true;
            }else{
                for(Edge Y : x.adjList){
                    if(!isDone(Y.target)){
                        Open.add(Y.target);
                        setG(Y.target, Y.wight);
                    }
                }
            }
        }
        float finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        
        System.out.printf("- Elapsed time = %.5f  milliseconds (= %.5f seconds)\n" , timeElapsed/1000 , timeElapsed);
        System.out.println("**** SEARCHING -- END ****");
        
    }
    boolean isDone(Vertex x){
        if(Closed.contains(x))return true;
        else return false;
    }
    void setG(Vertex y ,int C){
        y.g = x.g + C;
    }
    
    boolean isGoal(){
    if(x == Goal){
        return true;
    }
    return false;
    }
    
    Vertex lowestFInOpen(){
        System.out.println("test " + Open.isEmpty());
      Vertex temp = Open.get(0);
        Vertex.setF(temp);
      for(Vertex x : Open){
          Vertex.setF(x);
            if(x.f <= temp.f){
                temp = x;
            }
        }
        return temp;
    }
    
    void printPathCost(Vertex x){
        System.out.println("- Path Cost= "+ x.g);
    }
    void PrintOpen(){
         System.out.print("Open :[");
         
        for(Vertex x : Open){
            System.out.print(","+ x.label + "" + x.f );
        }
        System.out.print("]  ");
    }
    void PrintClosed(){
        System.out.print("Closed :[");
        for(Vertex x : Closed){
              System.out.print(","+ x.label + "" + x.f );
        }
        System.out.print("]  ");
    }
    
    void printXOpenClose(Vertex y){
        String yf = y.label +y.f;
        System.out.print("- X= " + yf +"  ");
        PrintOpen();
        PrintClosed();
        System.out.println("");
        
    }
    void sortOpen(){
         //bubble sort
        int n = Open.size();
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (Open.get(j).f > Open.get(j+1).f) 
                { 
             
                    Vertex temp = Open.get(j);
                    Open.add(j,Open.get(j+1) );
                    Open.add(j+1, temp);
                } 
    }
         
   
    void PrintAstarStart(){
        
        System.out.println("**** SEARCHING -- START ****");
        System.out.println("- Graph in use: Graph_B");
        System.out.println("- Algorithm in use: A*");
        System.out.println("- Start state: "+ Start.label);
        System.out.println("- Goal state : "+ Goal.label);
        
        
        
        
        
        
        
    }
    void printtable(){
        System.out.println("- The h(n) and f(n) for every state :");
        System.out.println("----------------------------------------");
        String State = "State" ;
        String h = "h(n)";
        String f = "f(n)";
        System.out.printf("|  %s  ||  %s  |  %s  |\n", State , h, f);
        for(Vertex x : vertexs){
        System.out.printf("|  %s  ||  %d  |  %d  |", x.label , x.h , x.f);
        }
        System.out.println("----------------------------------------");

    }
    
    
    

}