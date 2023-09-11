package ai_project;

import java.util.*;
import jdk.nashorn.internal.ir.BreakNode;

public class Tree_FS {


    // ----------------------Tree Search------------------------------- //
     void Tree_search() {

        Scanner sc = new Scanner(System.in);
        Tree tr = new Tree();
        int select;
        char goal;

        Node root = tr.add('A');
        root.left = tr.add('B');
        root.left.left = tr.add('E');
        root.center = tr.add('C');
        root.center.left = tr.add('F');
        root.center.left.left = tr.add('I');
        root.center.right = tr.add('G');
        root.right = tr.add('D');
        root.right.left = tr.add('H');

        System.out.println("1- Using Breadth-First algorithm ?");
        System.out.println("2- Using Depth-First algorithm ?");
        System.out.println("3- Displaying The main menu ?");
        System.out.print("Your choice: ");
        select = sc.nextInt();

        if (select == 1) {

            System.out.println("- pleas, what is the goal state?");
            System.out.print("Your answer: ");
            goal = sc.next().charAt(0);

            System.out.println("Tree in use: Tree_A");
            System.out.println("Algorithm in use: Breadth-First");
            System.out.println("Start State: A");
            System.out.println("Goal state:" + goal);

            tr.breadth(root, goal);

        } else if (select == 2) {

            System.out.println("- please, what is the goal state?");
            System.out.print("Your answer: ");
            goal = sc.next().charAt(0);

            System.out.println("Tree in use: Tree_A");
            System.out.println("Algorithm in use: Depth-First");
            System.out.println("Start State: A");
            System.out.println("Goal state:" + goal);

            tr.depth(root, goal);

        } else if (select == 3) {
            
        }

        

    }

}

class Node {

    char val;

    Node left = null;
    Node center = null;
    Node right = null;

}

class Tree {

    Node root = null;
    private ArrayList<Character> open = new ArrayList<Character>();
    private ArrayList<Character> close = new ArrayList<Character>();
    private ArrayList<Node> node = new ArrayList<Node>();

    Node add(char x) {

        Node n = new Node();

        n.val = x;
        n.left = null;
        n.center = null;
        n.right = null;

        return n;

    }

    void breadth(Node root, char x) {

        long start = System.currentTimeMillis();

        if (close.isEmpty()) {
            open.add(root.val);
            node.add(root);

        }

        if (root != null && !open.isEmpty()) {

            System.out.println("X = " + open.get(0) + " open = " + open + " close = " + close);

            if (open.get(0).equals(x)) {

                long end = System.currentTimeMillis();
                float sec = (end - start);

                System.out.println("Elapsed time = " + sec + " milliseconds (= " + sec / 1000f + " seconds)");

                return;

            }

            close.add(open.get(0));
            open.remove(0);
            node.remove(0);

            if (root.left != null && !close.contains(root.left.val)) {

                open.add(root.left.val);
                node.add(root.left);

            }
            if (root.center != null && !close.contains(root.center.val)) {

                open.add(root.center.val);
                node.add(root.center);

            }
            if (root.right != null && !close.contains(root.right.val)) {

                open.add(root.right.val);
                node.add(root.right);

            }
            if (open.isEmpty()) {
                System.out.println("open = " + open + " close = " + close + "\n the element " + x + " dos not exist");
                return;
            }

            root = node.get(0);

            breadth(root, x);

        }

    }

    // Deadth first search
    void depth(Node root, char x) {

        long start = System.currentTimeMillis();

        if (close.isEmpty()) {
            open.add(root.val);
            node.add(root);

        }

        if (root != null && !open.isEmpty()) {

            System.out.println("X = " + open.get(0) + " open = " + open + " close = " + close);

            if (open.get(0).equals(x)) {

                long end = System.currentTimeMillis();
                float sec = (end - start);

                System.out.println("Elapsed time = " + sec + " milliseconds (= " + sec / 1000f + " seconds)");

                return;

            }

            close.add(open.get(0));
            open.remove(0);
            node.remove(0);

            if (root.right != null && !close.contains(root.right.val)) {

                open.add(0, root.right.val);
                node.add(0, root.right);

            }

            if (root.center != null && !close.contains(root.center.val)) {

                open.add(0, root.center.val);
                node.add(0, root.center);

            }
            if (root.left != null && !close.contains(root.left.val)) {

                open.add(0, root.left.val);
                node.add(0, root.left);

            }

            if (open.isEmpty()) {
                System.out.println("open = " + open + " close = " + close + " the element " + x + " dos not exist");
                return;

            }

            root = node.get(0);

            depth(root, x);

        }

    }

}
