package Thread;

import test.enums.CorSemaforo;

public class ThreadSemaforo implements Runnable {

	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;

	public ThreadSemaforo() {
		this.cor = CorSemaforo.VERMELHO;
		this.corMudou = false;
		this.parar = false;

		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!parar) {
			try {
				Thread.sleep(this.cor.getTempoespera());
				this.mudarCor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void mudarCor() {
		switch (this.cor) {
		case VERMELHO:
			this.cor = CorSemaforo.VERDE;
			break;
		case AMARELO:
			this.cor = CorSemaforo.VERMELHO;
			break;
		case VERDE:
			this.cor = CorSemaforo.AMARELO;
			break;
		default:
			break;

		}
		this.corMudou = true;
		notify();
	}

	public synchronized void esperarCorMudar() {
		while (!this.corMudou) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;

	}

	public synchronized void desligarSemaforo() {
		this.parar = true;
	}

	public CorSemaforo getCor() {
		return cor;
	}

}
