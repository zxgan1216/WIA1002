package L11;

import java.util.ArrayList;

public class L11Q1 {
    public static void main(String[] args) {
        int [] arr={45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        binarySearchTree<Integer> bst=new binarySearchTree<>();
        System.out.print("Input Data: ");
        for (int i:arr){
            System.out.print(i+" ");
            bst.insert(i);
        }

        System.out.print("\nInorder (sorted) : ");
        bst.inorder();

        System.out.print("\nPostorder : ");
        bst.postorder();

        System.out.print("\nPreorder : " );
        bst.preoder();

        System.out.println("\nHeight of BST : "+bst.height());
        System.out.println("Root of BST : "+bst.getRoot());
        System.out.println("Check whether 10 is in the tree ? "+bst.search(10));
        System.out.println("Delete 53 ? "+bst.delete(53));
        System.out.print("Updated Inorder (sorted) : ");
        bst.inorder();
        System.out.println("\nMin value : "+bst.minValue());
        System.out.println("Max value : "+bst.maxValue());
        System.out.println("A path from the root to 6 is : "+bst.path(6));
    }
}

class Node<T extends Comparable<T>>{
    T data;
    Node right;
    Node left;
    Node(T data){
        this(data,null,null);
    }
    Node(T data,Node left,Node right) {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}

class binarySearchTree<T extends Comparable<T>>{
    Node<T> root;
    int size;
    binarySearchTree(){}
    public boolean search(T t){
        if (root==null) return false;
        else{
            Node<T> current=root;
            while (current!=null){
                if (current.data.compareTo(t)==0){
                    return true;
                }
                else{
                    current=t.compareTo(current.data)>0?current.right:current.left;
                }
            }
            return false;
        }
    }
    public boolean insert(T t) {
        if (root == null) {
            root = new Node<>(t);
            size++;
            return true;
        } else if (search(t) == true) {
            return false;
        } else {
            Node<T> parent = null;
            for (Node<T> current = root; current != null; ) {
                parent = current;
                current = t.compareTo(current.data) > 0 ? current.right : current.left;
            }
            if (t.compareTo(parent.data) > 0) {
                parent.right = new Node<>(t);
            } else {
                parent.left = new Node<>(t);
            }
            size++;
            return true;
        }
    }

    public int getSize() {
        return size;
    }
    public int height(){
        return height(root);
    }
    private int height(Node<T> node){
        if (node==null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public T getRoot(){
        return root.data;
    }
    public T minValue(){
        Node<T> temp=root;
        while(temp.left!=null) temp=temp.left;
        return temp.data;
    }
    public T maxValue(){
        Node<T> temp=root;
        while(temp.right!=null) temp=temp.right;
        return temp.data;
    }
    public java.util.ArrayList<Node<T>> path(T t){
        if (root==null) return null;
        else if (search(t)==false) return null;
        else{
            ArrayList list=new ArrayList<>();
            Node<T> parent=null;
            for (Node<T> current=root;current!=null;){
                if(current.data.compareTo(t)==0){
                    list.add(t);
                    break;
                }
                else{
                    list.add(current.data);
                    parent=current;
                    current=t.compareTo(current.data)>0?current.right:current.left;
                }
            }
            return list;
        }
    }
    public boolean delete(T t){
        Node<T> parent = null;
        Node<T> current = root;
        while (current != null) {
            if (t.compareTo(current.data) == 0) break;
            parent = current;
            current = t.compareTo(current.data) < 0 ? current.left : current.right;
        }
        if (current == null) return false;

        if (current.left == null) {
            if (parent == null)
                root = current.right;
            else if (t.compareTo(parent.data) < 0)
                parent.left = current.right;
            else
                parent.right = current.right;
        } else {
            Node<T> parentOfRightMost = current;
            Node<T> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.data = rightMost.data;

            if (parentOfRightMost.left == rightMost)
                parentOfRightMost.left = rightMost.left;
            else
                parentOfRightMost.right = rightMost.left;
        }
        size--;
        return true;

    }
    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }
    protected void inorder(){
        inorder(root);
    }
    protected void inorder(Node<T> root){
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    protected void postorder(){
        postorder(root);
    }
    protected void postorder(Node<T> root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    protected void preoder(){
        preoder(root);
    }
    protected void preoder(Node<T> root){
        if (root == null) return;
        System.out.print(root.data + " ");
        preoder(root.right);
        preoder(root.left);
    }
}