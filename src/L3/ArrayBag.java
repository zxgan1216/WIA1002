package L3;

class ArrayBag<T> implements BagInterface<T>{
    T[] bag;
    final int DEFAULT_CAPACITY=25;
    int numberOfEntries;

    ArrayBag(){
        numberOfEntries=0;
        bag=(T[]) new Object[DEFAULT_CAPACITY];
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
    public boolean add(T newEntry) {
        if (isFull()){
            return false;
        }
        else {
            bag[numberOfEntries]= newEntry;
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public T remove() {
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
    public boolean remove(T anEntry) {
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
    public int getFrequencyOf(T anEntry) {
        int check=-1;
        for (int i=0;i<numberOfEntries;i++){
            if(anEntry.equals(bag[i])){
                check=i;
            }
        }
        return check;
    }

    @Override
    public boolean contains(T anEntry) {
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
    public BagInterface<T> union(BagInterface<? extends T> bag2) {
        ArrayBag<T> collection_bag=new ArrayBag<>();
        T[] bag1Array=toArray();
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
    public BagInterface<T> intersection(BagInterface<? extends T> bag2){
        ArrayBag<T> intersection=new ArrayBag<>();
        T[] bag1Array=toArray();
        T[] bag2Array=bag2.toArray();
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
    public BagInterface<T> difference(BagInterface<? extends T> bag2) {
        ArrayBag<T> difference=new ArrayBag<>();
        T[] bag1Array=toArray();
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

