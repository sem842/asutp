package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
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
	private AlarmListRender _alarmListRender;
	public AlarmPanel(OperationPool oPool) {
		this._oPool = oPool;
		this._alarmList = new JList<Alarm>(oPool.alarmsModelList());
		JScrollPane scrollPane = new JScrollPane(this._alarmList);
		scrollPane.setPreferredSize(new Dimension(600, 150));
		this._alarmList.setBackground(Color.BLACK);
		this._alarmListRender = new AlarmListRender();
		this._alarmList.setCellRenderer(this._alarmListRender);
		this.add(scrollPane);
		
		JButton btn = new JButton("Квитировать");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Alarm a = _alarmList.getSelectedValue();
				int index = oPool.alarms().indexOf(a);
				if (index != -1) {
					oPool.cvitByListIndex(index);
				}
			}
		});
		btn.setPreferredSize(new Dimension(150, 150));
		this.add(btn);
		
		new Timer(TIMER_DELAY, new TimerListener()).start();
	}
	
	private class TimerListener implements ActionListener { //class helper
		public void actionPerformed(ActionEvent e) {
			_alarmListRender.toggleBlinkFlag();
			_oPool.refreshModelList();
			_alarmList.repaint();
		}
	}
}
