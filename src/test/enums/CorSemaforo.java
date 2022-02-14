package test.enums;

public enum CorSemaforo {
	VERDE(1000), AMARELO(300), VERMELHO(2000);

	private int tempoEspera;

	CorSemaforo(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public int getTempoespera() {
		return tempoEspera;
	}
}
