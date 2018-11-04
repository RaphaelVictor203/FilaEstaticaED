package controller;

public class StaticQueueDeque {
	public Object[] fila;
	public int pri, pri1;
	public int ult, ult1;
	
	public StaticQueueDeque(int n) {
		this.pri = -1;
		this.ult = -1;
		this.fila = new Object[n];
		this.pri1 = fila.length;
		this.ult1 = fila.length;
	}
	
	public boolean isEmpty(int fila) {
		if(fila == 1) {
			return (this.ult == -1) ? true : false;
		}else {
			return (this.ult1 == this.fila.length) ? true : false;
		}
	}
	
	public boolean isFull() {
		if(this.ult + 1 == this.ult1) {
			return true;
		}
		return false;
	}
	
	public int getSize(int fila) {
		if(this.isEmpty(fila)) {
			return 0;
		}
		return (fila == 1) ? (this.ult + 1) : (this.fila.length - this.ult1);
	}
	
	public Object showFront(int fila) {
		if(this.isEmpty(fila)) {
			return null;
		}
		return ( fila == 1) ? this.fila[this.pri] : this.fila[this.pri1];
	}
	
	public void enfileirar(Object element, int fila) {
		if(!isFull()) {
			if(fila == 1) {
				ult++;
				pri = (pri == -1) ? ult*1 : pri;
				this.fila[ult] = element;
			}else {
				ult1--;
				pri1 = (pri1 == this.fila.length) ? ult1*1 : pri1;
				this.fila[ult1] = element;
			}
		}
	}
	
	public Object desenfileirar(int fila) {
		Object tmp;
		if(isEmpty(fila)) {
			return null;
		}
		if(fila == 1) {
			if(getSize(fila) == 1) {
				ult--;
				Object temp1 = this.fila[this.pri];
				this.fila[this.pri--] = null;
				return temp1;
			}
			tmp = this.fila[this.pri];
			for(int i = pri; i < ult; i++) {
				this.fila[i] = this.fila[i + 1];
				this.fila[i + 1] = null;
			}
			ult--;
		}else {
			if(getSize(fila) == this.fila.length - 1) {
				ult1++;
				Object temp1 = this.fila[this.pri1];
				this.fila[this.pri1++] = null;
				return temp1;
			}
			tmp = this.fila[this.pri1];
			for(int i = pri1; i > ult1; i--) {
				this.fila[i] = this.fila[i - 1];
				this.fila[i - 1] = null;
			}
			ult1++;
		}
		return tmp;
	}
}
