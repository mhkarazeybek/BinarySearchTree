public class BinarySearchTree {
    
        /* 
        Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 
       
       */


    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data=data;
        }   
    }

    Node root;

    void insert(int data){
        root=insertRec(root,data);
    }

    Node insertRec(Node n, int data){
        if(n==null)
            return n = new Node(data);
        
        if(data<n.data)
            n.left=insertRec(n.left, data);
        else if(data>n.data)
            n.right=insertRec(n.right, data);
        return n;
    }

    void display(){
        displayRec(root);
    }

    void displayRec(Node n){
        if(n !=null){
            displayRec(n.left);
            System.out.println(n.data);
            displayRec(n.right);
        }
    }
    Node search(Node n, int key){
        if(n==null)
            return n;
        else if (n.data==key){
            System.out.println("It is here "+n.data);
            return n;
        }
        if(key < n.data )
            return search(n.left , key);

        return search(n.right , key) ;
    }

    void deleteKey(int key){
        root = deleteRec(root, key);
    }

    Node deleteRec(Node n,int key){
        if(n == null)
            return n;
        
        if(key<n.data)
            n.left=deleteRec(n.left, key);
        else if (key>n.data)
            n.right = deleteRec(n.right, key);
        
        else{
            if(n.left==null)
                return n.right;
            else if(n.right == null)
                return n.left;
            n.data = minValue(n.right);
            n.right =deleteRec(n.right, n.data);
        }
        return n;
    }
    int minValue(Node n){
        int minv = n.data;
        while (n.left !=null){
            minv=n.left.data;
            n=n.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(45);
        tree.insert(35);
        tree.insert(15);
        tree.insert(25);
        tree.insert(43);

        tree.display();

        System.out.println(tree.search(tree.root, 70));
        tree.deleteKey(40);
        tree.display();
    }
}

/**
15 20 25 30 35 43 45 50 60 70 80 


 */