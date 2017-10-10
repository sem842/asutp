package ido.tomsk.ru.asutp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryPool {
	private File _historyFile;
	public HistoryPool(String outFile) {
		this._historyFile = new File(outFile);
	}
	public void add(Alarm a) {
		this.addLogRecord(this._historyFile, a);
	}
	private void addLogRecord(File f, Alarm a) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(f.getAbsolutePath(), true);
			bw = new BufferedWriter(fw);
			bw.write(a.toString());
			bw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (bw != null) bw.close();
					if (fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
