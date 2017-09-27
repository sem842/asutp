package ido.tomsk.ru.asutp;

public interface ISensorEmulator {
	void setEmulationStrategy(IEmulationStrategy s);
	IEmulationStrategy getEmulationStrategy();
	void emulate();
}
