package controller;

public class StaticQueueCircular {
	
	public Object[] fila;
	public int pri;
	public int ult;
	public int size;
	
	public StaticQueueCircular(int n) {
		this.fila = new Object[n];
		this.pri = -1;
		this.ult = -1;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		if(this.ult == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(this.ult == pri - 1) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		if(this.isEmpty()) {
			return 0;
		}else {
			return size + 1;
		}
	}
	
	public Object showFront() {
		if(this.isEmpty()) {
			return null;
		}
		return this.fila[this.pri];
	}
	
	public void enfileirar(Object element) {
		if(isEmpty()) {
			pri = (int) this.fila.length/2;
			ult = (int) this.fila.length/2;
			this.fila[ult] = element;
		}else
		if(!isFull()) {
			if((ult+1) > pri && (ult + 1) < fila.length) {
				this.fila[++ult] = element;
			}else {
				int pos = (ult+1)%fila.length;
				ult = pos;
				this.fila[ult] = element;
			}
			this.size++;
		}
	}
	
	public Object desenfileirar() {
		if(isEmpty()) {
			return null;
		}
		if(getSize() == 1) {
			ult = -1;
			int tmp = this.pri;
			this.pri = -1;
			Object temp = this.fila[tmp];
			this.fila[tmp] = null;
			return temp;
		}
		Object tmp = this.fila[this.pri];
		if(pri < (fila.length-1)) {
			this.fila[this.pri] = null;
			this.pri++;
		}else {
			this.pri = (pri+1)%fila.length;
		}
		this.size--;
		return tmp;
	}
}
