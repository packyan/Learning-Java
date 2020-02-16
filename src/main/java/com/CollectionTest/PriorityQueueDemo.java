package com.CollectionTest;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<User> queue = new LinkedList<>();
        queue.offer(new User("jack ma", "V10"));
        queue.offer(new User("jack chen", "V9"));
        queue.offer(new User("jack liui", "V16"));
        queue.offer(new User("jack mj", "A10"));
        queue.offer(new User("jack md", "A14"));
        queue.offer(new User("jack cai", "A9"));
        queue.offer(new User("a cai", "A9"));
        queue.offer(new User("d cdai", "V9"));
        for (User user :
                queue) {
            System.out.println(user);
        }

        System.out.println("--------priority queue");
        Queue<User> priorityQueue = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                if(user.getVip().charAt(0) == t1.getVip().charAt(0)){
                    int userVip = Integer.parseInt(user.getVip().substring(1));
                    int t1Vip = Integer.parseInt(t1.getVip().substring(1));
                    return  Integer.compare(userVip,t1Vip)==0? user.getName().compareTo(t1.getName()) : -Integer.compare(userVip,t1Vip);
                }
                else {
                    if(user.getVip().charAt(0)=='V')
                        return -1;
                    else{
                        return 1;
                    }
                }
            }
        });
        for (var user :
                queue) {
            priorityQueue.offer(user);
        }

        for (User user :
                priorityQueue) {
            System.out.println(user);
        }
        System.out.println(priorityQueue.size());
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(priorityQueue.poll());
        }



    }

}

class User{
    private String name;
    private  String vip;

    public User(String name, String vip) {
        this.name = name;
        this.vip = vip;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", vip='" + vip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(vip, user.vip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vip);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }
}
