package ido.tomsk.ru.asutp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AlarmPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int TIMER_DELAY = 500;
	private OperationPool _oPool;
	private JList<Alarm> _alarmList = null;
	public AlarmPanel(OperationPool oPool) {
		this._oPool = oPool;
		
		this._alarmList = new JList<Alarm>(oPool.alarmsModelList());
		
		JScrollPane scrollPane = new JScrollPane(this._alarmList);
		scrollPane.setPreferredSize(new Dimension(600, 150));
		this._alarmList.setCellRenderer(new AlarmListRender());
		this.add(scrollPane);
		new Timer(TIMER_DELAY, new TimerListener()).start();
	}
	
	private class TimerListener implements ActionListener { //class helper
		public void actionPerformed(ActionEvent e) {
			_oPool.refreshModelList();
			_alarmList.repaint();
		}
	}
}
