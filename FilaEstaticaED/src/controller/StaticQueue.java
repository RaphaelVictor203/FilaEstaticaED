package controller;

public class StaticQueue {
	public Object[] fila;
	public int pri;
	public int ult;
	
	public StaticQueue(int n) {
		this.pri = -1;
		this.ult = -1;
		this.fila = new Object[n];
	}
	
	public boolean isEmpty() {
		if(this.ult == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(fila.length == ult + 1) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		if(this.isEmpty()) {
			return 0;
		}
		return this.ult + 1;
	}
	
	public Object showFront() {
		if(this.isEmpty()) {
			return null;
		}
		return this.fila[this.pri];
	}
	
	public void enfileirar(Object element) {
		if(isEmpty()) {
			pri = 0;
			ult = 0;
			this.fila[ult] = element;
		}else
		if(!isFull()) {
			this.fila[++ult] = element;
		}
	}
	
	public Object desenfileirar() {
		if(isEmpty()) {
			return null;
		}
		if(getSize() == 1) {
			ult--;
			return this.fila[this.pri--];
		}
		Object tmp = this.fila[this.pri];
		for(int i = pri; i < ult; i++) {
			this.fila[i] = this.fila[i + 1];
		}
		ult--;
		return tmp;
	}
}
