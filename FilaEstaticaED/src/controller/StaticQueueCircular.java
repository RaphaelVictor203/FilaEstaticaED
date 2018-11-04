package controller;

public class StaticQueueCircular {
	
	public Object[] fila;
	public int pri;
	public int ult;
	
	public StaticQueueCircular(int n) {
		this.fila = new Object[n];
		this.pri = -1;
		this.ult = -1;
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
		}
		if(ult >= pri) {
			if(fila.length%2 == 0) {
				return Math.abs(((fila.length - ((int)fila.length/2)) - (ult-1)) - 2);
			}else {
				return Math.abs(((fila.length - ((int)fila.length/2)) - ult) - 2);
			}
		}else {
			return ((fila.length - (((int)fila.length/2) - 1)) + (ult));
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
		if(ult < pri) {
			int j = -1;
			for(int i = pri; i < (fila.length + (pri-1)); i++) {
				if(i >= fila.length - 1) {
					if(i == fila.length - 1) {
						this.fila[i] = this.fila[j+1];
						this.fila[j + 1] = null;
						j++;
					}else {
						this.fila[j] = this.fila[j+1];
						this.fila[j + 1] = null;
						j++;
					}
				}else {
					this.fila[i] = this.fila[i + 1];
					this.fila[i + 1] = null;
				}				
			}
			ult = ((ult - 1) >= 0) ? ult-1 : fila.length-1;
		}else {
			for(int i = pri; i < ult; i++) {
				this.fila[i] = this.fila[i + 1];
				this.fila[i + 1] = null;
			}
			ult--;
		}
		return tmp;
	}
}
