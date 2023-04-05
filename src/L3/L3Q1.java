package L3;

public class L3Q1 {
    private static void testAdd(BagInterface<String> aBag,String[] content){
        System.out.print("Adding ");
        for (String s:content){
            aBag.add(s);
            System.out.print(s+" ");
        }
        System.out.println("");
    }

    private static void displayBag(BagInterface<String> aBag){
        Object[] newBag= aBag.toArray();
        System.out.printf("The bag contains %d string(s), as follows:\n", aBag.getCurrentSize());
        for (Object s:newBag){
            System.out.print(s+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayBag<String> bag1=new ArrayBag<>();
        ArrayBag<String> bag2=new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("bag1 :");
        testAdd(bag1,contentsOfBag1);
        System.out.println("Displaying bag 1");
        displayBag(bag1);
        System.out.println("");

        System.out.println("bag2 :");
        testAdd(bag2,contentsOfBag2);
        System.out.println("Displaying bag 2");
        displayBag(bag2);
        System.out.println("");

        System.out.println("bag3, test the method union of bag1 and bag2:");
        ArrayBag<String> bag3= (ArrayBag<String>) bag1.union(bag2);
        displayBag(bag3);
        System.out.println("");

        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        ArrayBag<String> bag4= (ArrayBag<String>) bag1.intersection(bag2);
        displayBag(bag4);
        System.out.println("");

        System.out.println("bag5, test the method difference of bag1 and bag2:");
        ArrayBag<String> bag5=(ArrayBag<String>) bag1.difference(bag2);
        displayBag(bag5);
    }
}

interface BagInterface<T>{
    /** Gets the current number of entries in this bag.
     * @return the integer number of entries currently in the bag */
    public int getCurrentSize();
    /** Sees whether this bag is full.
     @return true if the bag is full, or false if not */
    public boolean isFull();
    /** Sees whether this bag is empty.
     @return true if the bag is empty, or false if not */
    public boolean isEmpty();
    /** Adds a new entry to this bag.
     @param newEntry the object to be added as a new entry
     @return true if the addition is successful, or false if not */
    public boolean add(T newEntry);
    /** Removes one unspecified entry from this bag, if possible.
     @return either the removed entry, if the removal was successful,
     or null */
    public T remove();
    /** Removes one occurrence of a given entry from this bag.
     @param anEntry the entry to be removed
     @return true if the removal was successful, or false if not */
    public boolean remove(T anEntry);
    /** Removes all entries from this bag. */
    public void clear();
    /** Counts the number of times a given entry appears in this bag.
     @param anEntry the entry to be counted
     @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T anEntry);
    /** Tests whether this bag contains a given entry.
     @param anEntry the entry to locate
     @return true if this bag contains anEntry, or false otherwise */
    public boolean contains(T anEntry);
    /** Retrieves all entries that are in this bag.
     @return a newly allocated array of all the entries in the bag */
    public T[] toArray();
    public BagInterface<T> union(BagInterface<? extends T> bag2);
    public BagInterface<T> intersection(BagInterface<? extends T> bag2);
    public BagInterface<T> difference(BagInterface<? extends T> bag2);
}

class ArrayBag<T> implements BagInterface{
    private T[] bag=(T[]) new Object[DEFAULT_CAPACITY];
    private static final int DEFAULT_CAPACITY=25;
    private int numberOfEntries;

    ArrayBag(){
        numberOfEntries=0;
    }
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries>DEFAULT_CAPACITY?true:false;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries<1?true:false;
    }

    @Override
    public boolean add(Object newEntry) {
        if (isFull()){
            return false;
        }
        else {
            bag[numberOfEntries]= (T) newEntry;
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public Object remove() {
        if (isEmpty()){
            return null;
        }
        else {
            T result=bag[numberOfEntries-1];
            bag[numberOfEntries]=null;
            return result;
        }
    }

    @Override
    public boolean remove(Object anEntry) {
        if (isEmpty()){
            return false;
        }
        else {
            for (int i=0;i<numberOfEntries;i++){
                if(anEntry.equals(bag[i])){
                    bag[i]=null;
                    numberOfEntries--;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void clear() {
        for (T bag:bag){
            bag=null;
        }
    }

    @Override
    public int getFrequencyOf(Object anEntry) {
        int check=-1;
        for (int i=0;i<numberOfEntries;i++){
            if(anEntry.equals(bag[i])){
                check=i;
            }
        }
        return check;
    }

    @Override
    public boolean contains(Object anEntry) {
        for (int i=0;i<numberOfEntries;i++){
            if(anEntry.equals(bag[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, result, 0, numberOfEntries);
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface bag2) {
        ArrayBag<T> collection_bag=new ArrayBag<>();
        T[] bag1Array=this.toArray();
        T[] bag2Array= (T[]) bag2.toArray();
        for (T bag:bag1Array){
            collection_bag.add(bag);
        }
        for (T bag:bag2Array){
            collection_bag.add(bag);
        }
        return collection_bag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface bag2) {
        ArrayBag<T> intersection=new ArrayBag<>();
        T[] bag1Array=this.toArray();
        T[] bag2Array=(T[]) bag2.toArray();
        for (T test:bag1Array){
            intersection.add(test);
        }

        for (int i=0;i< bag1Array.length;i++){
            boolean found=false;
            for (int j=0;j< bag2Array.length;j++){
                if (bag1Array[i].equals(bag2Array[j])){
                    found=true;
                    bag2Array[j] = bag2Array[bag2Array.length - 1];
                    bag2Array[bag2Array.length - 1] = null;
                    break;
                }
            }
            if (!found){
                intersection.remove(bag1Array[i]);
            }
        }
        return intersection;
    }

    @Override
    public BagInterface<T> difference(BagInterface bag2) {
        ArrayBag<T> difference=new ArrayBag<>();
        T[] bag1Array=this.toArray();
        T[] bag2Array=(T[])bag2.toArray();
        for (T test:bag1Array){
            difference.add(test);
        }

        for (int i=0;i<bag1Array.length;i++){
            for (int j=0;j<bag2Array.length;j++){
                if (bag1Array[i].equals(bag2Array[j])){
                    difference.remove(bag1Array[i]);
                    bag2Array[j]=bag2Array[bag2Array.length-1];
                    bag2Array[bag2Array.length-1]=null;
                    break;
                }
            }
        }
        return difference;
    }
}
