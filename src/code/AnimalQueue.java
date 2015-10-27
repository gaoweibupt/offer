package code;

import java.util.LinkedList;

/*
 *@author  gaoweibupt@gmail.com	
 * 创建时间： 2015年10月27日下午10:08:31
 * 
 * 第八章习题 3.7
 * 
 */
public class AnimalQueue {
	LinkedList<Animal> dog = null;
	LinkedList<Animal> cat = null;
	private int order = 0;
	
	public AnimalQueue() {
		// TODO Auto-generated constructor stub
		dog = new LinkedList<Animal>();
		cat = new LinkedList<Animal>();
	}
	
	public void enqueue(Animal animal){
		if (animal.getType() == "cat"){
			animal.setOrder(order++);
			cat.add(animal);
		}
		if (animal.getType() == "dog"){
			animal.setOrder(order++);
			dog.add(animal);
		}
	}
	
	public Animal dequeueAny(){
		if (cat.getFirst().getOrder() < dog.getFirst().getOrder()){
			return dog.pop();
		}else{
			return cat.pop();
		}
	}
	
	public Animal dequeueDog(){
		return dog.pop();
	}
	
	public Animal dequeueCat(){
		return cat.pop();
	}
	
	
	
	
}

class Animal{
	private String name;
	private int order;
	private String type;
	Animal(String name){
		this.name = name;
	}
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public int getOrder(){
		return order;
	}
	
}
