package LabTest1_try;

public class Data<T extends Comparable> implements Comparable<Data<T>>{
        private String user;
    private T data;
    private int date;

    public Data(String user, T data, int date) {
        this.user = user;
        this.data = data;
        this.date = date;
    }

    @Override
    public int compareTo(Data<T> o) {
        return this.data.compareTo(o.data);
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
